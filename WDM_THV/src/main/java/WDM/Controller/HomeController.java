package WDM.Controller;

import java.lang.ProcessBuilder.Redirect;
import java.net.http.HttpRequest;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import WDM.Entity.CusCart;
import WDM.Entity.Hoa_Don;
import WDM.Entity.Khach_Hang;
import WDM.Entity.Loai_MH;
import WDM.Entity.Mat_Hang;
import WDM.Entity.Nhan_Vien;
import WDM.Entity.cate_ad;
import WDM.Entity.product_ad;
import WDM.Service.CT_HD_Service;
import WDM.Service.CusCart_Service;
import WDM.Service.Hang_SX_Service;
import WDM.Service.Hoa_Don_Service;
import WDM.Service.Khach_Hang_Service;
import WDM.Service.Loai_MH_Service;
import WDM.Service.Mat_Hang_Service;
import WDM.Service.Nhan_Vien_Service;
import WDM.Service.product_ad_sv;
import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class HomeController {
	@Autowired(required = true)
	private Hang_SX_Service hangsxservice;
	@Autowired(required = true)
	private Loai_MH_Service loaimhservice;
	@Autowired(required = true)
	private Mat_Hang_Service mathangservice;
	@Autowired(required = true)
	private Hoa_Don_Service hoadonservice;
	@Autowired(required = true)
	private Khach_Hang_Service khachhangservice;
	@Autowired(required = true)
	private CusCart_Service cuscartsv;
	@Autowired(required = true)
	private CT_HD_Service cthdsv;
	@Autowired(required = true)
	private product_ad_sv prd_ad_sv;
	@Autowired(required = true)
	private Nhan_Vien_Service nvsv;
	

	// Trang chủ
	@RequestMapping(value = { "/", "/index" })
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	
	private javax.servlet.http.HttpSession sess ;

	// -----------------------------------API------------------------------//
	// lấy mặt hàng
	@RequestMapping(value = "/mathang/getall", method = RequestMethod.GET)
	public ResponseEntity<List<Mat_Hang>> getallmh(@RequestParam int page) {
		int slct = 4;
		// so trang = tong so luong%so luong lay == 0? tong so mat hang / so luong can lay (neu chia het) : math.floor(tong mat hang/so luong lay)+1(neu khong chia het)
		//model.addObject("pagesize",sotrang);
		//model.addObject("item",....)
		return new ResponseEntity<List<Mat_Hang>>(mathangservice.GetAllMH_SV().stream().skip(page*slct).limit(slct).toList(),
				HttpStatus.OK);
	}
	
	

	
	
	
	@RequestMapping(value = "/mathang/totalcountprd", method = RequestMethod.GET)
	public ResponseEntity<List<Mat_Hang>> totalcount() {

			return new ResponseEntity<List<Mat_Hang>>(mathangservice.GetAllMH_SV(),
					HttpStatus.OK);
	}
	
	// search
	@RequestMapping(value = "/mathang/search", method = RequestMethod.GET)
	public ResponseEntity<Object> search(@RequestParam String key ,@RequestParam int count) {
		
		List<Mat_Hang> result = mathangservice.GetAllMH_SV();
		if (key.equals("") == false) {
			if (result != null) {
				return new ResponseEntity<Object>(
						result.stream().filter(s -> s.getTenMH().toLowerCase().contains(key.toLowerCase())).toList(),
						HttpStatus.OK);
			}
			return new ResponseEntity<Object>("404", HttpStatus.OK);
		} else {
			if (result != null) {
				return new ResponseEntity<Object>(result.stream().skip(count).limit(6).toList(), HttpStatus.OK);
			}
			return new ResponseEntity<Object>("404", HttpStatus.OK);
		}
	}
	@RequestMapping(value = "/mathang/getbycate", method = RequestMethod.GET)
	public ResponseEntity<Object> getbycate(@RequestParam int idlmh) {
		List<Mat_Hang> result = mathangservice.GetAllMH_SV();
		
			if (result != null) {
				return new ResponseEntity<Object>(
						result.stream().filter(s -> s.getLoaiMH()==idlmh).toList(),
						HttpStatus.OK);
			}
			return new ResponseEntity<Object>("404", HttpStatus.OK);
		
	}
	
	
	// lấy loại mặt hàng
	@RequestMapping("/loaimathang/getall")
	public ResponseEntity<List<Loai_MH>> getalllmh() {
		return new ResponseEntity<List<Loai_MH>>(loaimhservice.GetAllLMH(), HttpStatus.OK);
	}

	// đăng nhập
	@RequestMapping(value = "/logincus/{mail}/{pass}", method = RequestMethod.POST)
	public ResponseEntity<Object> Login(@PathVariable String mail, @PathVariable String pass) {
		Khach_Hang kh = khachhangservice.Login(mail, pass);
		if (kh == null) {
			return new ResponseEntity<Object>("404", HttpStatus.OK);
		}
		return new ResponseEntity<Object>(kh, HttpStatus.OK);
	}

	// lấy giỏ hàng
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ResponseEntity<Object> scart(@RequestParam String kh) {
		List<CusCart> cuscart = cuscartsv.getcartbyemail(kh);

		if (cuscart == null) {
			return new ResponseEntity<Object>("404", HttpStatus.OK);
		}
		return new ResponseEntity<Object>(cuscart, HttpStatus.OK);
	}
	
	

	// thêm giỏ hàng - thay đổi số lượng
	@RequestMapping(value = "/addcart", method = RequestMethod.GET)
	public ResponseEntity<Object> addcart(@RequestParam int idmh, @RequestParam String mail) {
		boolean result = cthdsv.addtocart(idmh, mail);
		if (result == true) {
			return new ResponseEntity<Object>("ok", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("404", HttpStatus.OK);
	}

	// đặt hàng
	@RequestMapping(value = "/paycart", method = RequestMethod.GET)
	public ResponseEntity<Object> paycart(@RequestParam int idhd, @RequestParam String note) {
		boolean result = hoadonservice.dathang(idhd, note);
		if (result == true) {
			return new ResponseEntity<Object>("ok", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("404", HttpStatus.OK);
	}
	// -------------------------------API ADMIN----------------------------------//

	// quản lý sản phẩm
	@RequestMapping(value = "/getproductmanager", method = RequestMethod.GET)
	public ResponseEntity<Object> getprdmng() {
		
		List<product_ad> result = prd_ad_sv.getAllProductAD();
		if (result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("404", HttpStatus.OK);

	}


	
	// quản lý loại sản phẩm
	@RequestMapping(value = "/getcategorymanager", method = RequestMethod.GET)
	public ResponseEntity<Object> getctmng() {
		List<cate_ad> result = loaimhservice.loadcate_ad();
		if (result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("404", HttpStatus.OK);
	}

	// quản lý đơn hàng chưa thanh toán
	@RequestMapping(value = "/getbillmanager", method = RequestMethod.GET)
	public ResponseEntity<Object> getbillmng() {
		List<Hoa_Don> result = hoadonservice.getAllHoaDon().stream()
				.filter(s -> s.isTrangThaiTT() == false && s.getTongTien() > 0).toList();
		if (result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("404", HttpStatus.OK);
	}

	// thống kê đơn hàng và doanh thu theo tháng
	@RequestMapping(value = "/getbillcplmanager", method = RequestMethod.GET)
	public ResponseEntity<Object> getbillcplmng() {
		List<Hoa_Don> result = hoadonservice.getAllHoaDon().stream().filter(s -> s.isTrangThaiTT() == true).toList();
		if (result != null) {
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("404", HttpStatus.OK);
	}

	@RequestMapping(value = "/confirmbill", method = RequestMethod.GET)
	public ResponseEntity<Object> confirmbill(@RequestParam int idhd,HttpServletRequest req) {
		sess = req.getSession();
		Nhan_Vien nv = (Nhan_Vien)sess.getAttribute("AccAD");
		if(nv!=null) {
			boolean result = hoadonservice.XacnhanTT(idhd,nv.getMaNV());
			if (result == true) {
				return new ResponseEntity<Object>("ok", HttpStatus.OK);
			}
			return new ResponseEntity<Object>("404", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("404", HttpStatus.OK);
	}

	// -----------------------------------Router-------------------------------//

	// lấy dữ liệu chuyển qua chi tiết
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(ModelAndView model, @RequestParam String id) {
		Mat_Hang mh = mathangservice.getMatHangbyID(Integer.parseInt(id));
		if (mh == null) {
			return new ModelAndView("404Page");
		} else {
			model.addObject("product", mh);
			model.setViewName("DetailPage");
		}
		return model;
	}

	// chuyển đến giỏ hàng
	@RequestMapping(value = "/cartpage", method = RequestMethod.GET)
	public ModelAndView loadcart() {
		return new ModelAndView("CartPage");
	}

	// chuyển đến trang sau khi đặt hàng
	@RequestMapping(value = "/thankpage", method = RequestMethod.GET)
	public ModelAndView loadthankpage() {
		return new ModelAndView("PayLY");
	}

	// mở trang sản phẩm
	@RequestMapping(value = "/listproduct", method = RequestMethod.GET)
	public ModelAndView listproduct() {
		return new ModelAndView("SanPham");
	}

	// ------------------------------Router ADMIN-----------------------------//
	
	//Dang nhap ADMIN
	@RequestMapping(value = "/admin/loginad")
	public ModelAndView oplogin() {
		ModelAndView model = new ModelAndView();
		model.setViewName("LoginAD");
		return model;
	}
	@PostMapping(value = "/admin/loginad/submit")
	public ModelAndView login(HttpServletRequest req) {
		sess= req.getSession();
		ModelAndView model = new ModelAndView();
		String Code = req.getParameter("MaNV");
		String Pass = req.getParameter("MatKhau");
		var nv = nvsv.LoginAD(Code, Pass);
		if(nv!=null) {
			sess.setAttribute("AccAD", nv);
			//model.addObject("adminname",nv.getTenNV());
			model.setViewName("redirect:../prdad");
		}
		else {
			model.setViewName("redirect:./loginad");
		}	
		return model;
	}
	//dang xuat
	@RequestMapping(value = "/admin/logout")
	public ModelAndView logout(HttpServletRequest req) {
		sess = req.getSession();
		sess.invalidate();
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:./loginad");
		return model;
	}
	
	// mở quản lý sp
	@RequestMapping(value = "/admin/prdad")
	public ModelAndView prdad(HttpServletRequest req) {
		sess = req.getSession();
		Nhan_Vien check = (Nhan_Vien) sess.getAttribute("AccAD");
		if (check != null) {
			ModelAndView model = new ModelAndView();
			model.setViewName("ProductAD");
			return model;
		}
		return new ModelAndView("redirect:../admin/loginad");
	}

	// mở quản lý loại sp
	@RequestMapping(value = "/admin/catead", method = RequestMethod.GET)
	public ModelAndView catead(HttpServletRequest req) {
		sess = req.getSession();
		Nhan_Vien check = (Nhan_Vien) sess.getAttribute("AccAD");
		if (check != null) {
			ModelAndView model = new ModelAndView();
			model.setViewName("CateAD");
			return model;
		}
		return new ModelAndView("redirect:../admin/loginad");
	}

	// Thêm mới loại sản phẩm
	@RequestMapping(value = "admin/addnewcate")
	public ModelAndView opaddcate(HttpServletRequest req) {
		sess = req.getSession();
		Nhan_Vien check = (Nhan_Vien) sess.getAttribute("AccAD");
		if (check != null) {
			ModelAndView model = new ModelAndView();
			model.addObject("listhsx", hangsxservice.getAllHSX());
			model.setViewName("AddnewCate");
			return model;
		}
		return new ModelAndView("redirect:../admin/loginad");
	}

	@RequestMapping(value = "/admin/addnewcate/submit", method = RequestMethod.POST)
	public String addcate(HttpServletRequest rq, Model model) {
		Loai_MH lmh = new Loai_MH();
		lmh.setTenLMH((rq.getParameter("TenLMH")));
		lmh.setHangSX(Integer.parseInt(rq.getParameter("HangSX")));
		if (loaimhservice.ThemLMH(lmh) == true) {
			model.addAttribute("notifi", "Thêm sản phẩm mới thành công 👍");
		} else {
			model.addAttribute("notifi", "Thêm sản phẩm thất bại ❌");
		} // model.setViewName();
		return "redirect:../catead";

	}
//Sua loai mh

	@RequestMapping(value = "admin/updatecate")
	public ModelAndView opupdatecate(@RequestParam int idlmh,HttpServletRequest req) {
		sess = req.getSession();
		Nhan_Vien check = (Nhan_Vien) sess.getAttribute("AccAD");
		if (check != null) {
			ModelAndView model = new ModelAndView();
			model.addObject("listhsx", hangsxservice.getAllHSX());
			model.addObject("cate",
					loaimhservice.GetAllLMH().stream().filter(s -> s.getMaLMH() == idlmh).findFirst().get());
			model.setViewName("UpdateCate");
			return model;
		}
		return new ModelAndView("redirect:../admin/loginad");
	}

	@RequestMapping(value = "/admin/updatecate/submit", method = RequestMethod.POST)
	public String updatecate(HttpServletRequest rq, Model model, @RequestParam int idlmh) {
		Loai_MH lmh = new Loai_MH();
		lmh.setTenLMH((rq.getParameter("TenLMH")));
		lmh.setHangSX(Integer.parseInt(rq.getParameter("HangSX")));
		lmh.setMaLMH(idlmh);

		if (loaimhservice.SuaLMH(lmh) == true) {
			model.addAttribute("notifi", "Sua danh muc thành công 👍");
		} else {
			model.addAttribute("notifi", "Sua danh muc thất bại ❌");
		} // model.setViewName();
		return "redirect:../catead";

	}

	// mở quản lý hóa đơn chưa thanh toán
	@RequestMapping(value = "/admin/billad", method = RequestMethod.GET)
	public ModelAndView billad(HttpServletRequest req) {
		sess = req.getSession();
		Nhan_Vien check = (Nhan_Vien) sess.getAttribute("AccAD");
		if (check != null) {
			ModelAndView model = new ModelAndView();
			model.setViewName("BillAD");
			return model;
		}
		return new ModelAndView("redirect:../admin/loginad");
	}

	// mở thống kê
	@RequestMapping(value = "/admin/billcplad", method = RequestMethod.GET)
	public ModelAndView billcplad(HttpServletRequest req) {
		sess = req.getSession();
		Nhan_Vien check = (Nhan_Vien) sess.getAttribute("AccAD");
		if (check != null) {
			ModelAndView model = new ModelAndView();
			model.setViewName("BillcplAD");
			return model;
		}
		return new ModelAndView("redirect:../admin/loginad");
	}
	// mo xem chi tiet hoa don
	@RequestMapping(value = "/admin/viewdetail")
	public ModelAndView viewbill(@RequestParam int idbill) {
		ModelAndView model = new ModelAndView();
		model.addObject("ldetail",cuscartsv.getcartbyidbill(idbill));
		model.setViewName("DetailBillAD");
		return model;
	}

	// Mo them moi san pham

	@RequestMapping(value = "admin/addnewprd")
	public ModelAndView opaddprd(HttpServletRequest req) {
		sess = req.getSession();
		Nhan_Vien check = (Nhan_Vien) sess.getAttribute("AccAD");
		if (check != null) {
			ModelAndView model = new ModelAndView();
			model.addObject("listlmh", loaimhservice.GetAllLMH());
			model.setViewName("AddnewProduct");
			return model;
		}
		return new ModelAndView("redirect:../admin/loginad");
	}

	// them moi san pham
	@RequestMapping(value = "/admin/addnewprd/submit", method = RequestMethod.POST)
	public String addprd(HttpServletRequest rq, Model model) {
		Mat_Hang mh = new Mat_Hang();
		mh.setBaoHanh(Integer.parseInt(rq.getParameter("BaoHanh")));
		mh.setGiaBan(Integer.parseInt(rq.getParameter("GiaBan")));
		mh.setGiaNhap(Integer.parseInt(rq.getParameter("GiaNhap")));
		mh.setHinhAnh(rq.getParameter("HinhAnh"));
		mh.setLoaiMH(Integer.parseInt(rq.getParameter("MaLMH")));
		mh.setSoLuongTon(Integer.parseInt(rq.getParameter("SoLuong")));
		mh.setTrangThai(rq.getParameter("TrangThai"));
		mh.setMoTa(rq.getParameter("MoTa") == null ? "" : rq.getParameter("MoTa"));
		mh.setTenMH(rq.getParameter("TenMH"));

		if (prd_ad_sv.ThemMH(mh) == true) {
			model.addAttribute("notifi", "Thêm sản phẩm mới thành công 👍");
		} else {
			model.addAttribute("notifi", "Thêm sản phẩm thất bại ❌");
		}
		// model.setViewName();
		return "redirect:../prdad";

	}

	// xoa san pham
	@RequestMapping(value = "/admin/deleteprd")
	public ModelAndView deleteprd(@RequestParam int idmh,HttpServletRequest req) {
		sess = req.getSession();
		Nhan_Vien check = (Nhan_Vien) sess.getAttribute("AccAD");
		if (check != null) {
			ModelAndView model = new ModelAndView();
			if (prd_ad_sv.XoaMH(idmh) == true) {
				model.addObject("notifi", "Xóa thành công 👍");
			} else {
				model.addObject("notifi", "Xóa thất bại ❌");
			}
			model.setViewName("redirect:./prdad");
			return model;
		}
		return new ModelAndView("redirect:../admin/loginad");
	}

	// cap nhat san pham
	@RequestMapping(value = "admin/updateprd")
	public ModelAndView opupdateprd(@RequestParam int idmh,HttpServletRequest req) {
		sess = req.getSession();
		Nhan_Vien check = (Nhan_Vien) sess.getAttribute("AccAD");
		if (check != null) {
			ModelAndView model = new ModelAndView();
			model.addObject("listlmh", loaimhservice.GetAllLMH());
			model.addObject("prd", mathangservice.getMatHangbyID(idmh));
			model.setViewName("UpdateProduct");
			return model;
		}
		return new ModelAndView("redirect:../admin/loginad");

	}

	// luu cap nhat san pham
	@RequestMapping(value = "/admin/updateprd/submit", method = RequestMethod.POST)
	public String updateprd(HttpServletRequest rq, Model model, @RequestParam int idmh) {
		Mat_Hang mh = new Mat_Hang();
		mh.setBaoHanh(Integer.parseInt(rq.getParameter("BaoHanh")));
		mh.setGiaBan(Integer.parseInt(rq.getParameter("GiaBan")));
		mh.setGiaNhap(Integer.parseInt(rq.getParameter("GiaNhap")));
		mh.setHinhAnh(rq.getParameter("HinhAnh"));
		mh.setLoaiMH(Integer.parseInt(rq.getParameter("MaLMH")));
		mh.setSoLuongTon(Integer.parseInt(rq.getParameter("SoLuong")));
		mh.setTrangThai(rq.getParameter("TrangThai"));
		mh.setMoTa(rq.getParameter("MoTa") == null ? "" : rq.getParameter("MoTa"));
		mh.setTenMH(rq.getParameter("TenMH"));
		mh.setMaMH(idmh);

		if (prd_ad_sv.CapnhatMH(mh) == true) {
			model.addAttribute("notifi", "Cập nhật sản phẩm thành công 👍");
		} else {
			model.addAttribute("notifi", "Cập nhật sản phẩm thất bại ❌");
		}
		// model.setViewName();
		return "redirect:../prdad";

	}

}
