package WDM.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.CT_HD;
import WDM.Entity.CusCart;
import WDM.Entity.Hoa_Don;
import WDM.Entity.Khach_Hang;
import WDM.Entity.Mat_Hang;
import WDM.ObjectModel.CT_HD_Dao;
import WDM.ObjectModel.Hoa_Don_Dao;
import WDM.ObjectModel.Khach_Hang_Dao;
import WDM.ObjectModel.Mat_Hang_Dao;

@Service
@Transactional
public class CusCart_Service {
	@Autowired
	private CT_HD_Dao cthddao;
	@Autowired
	private Mat_Hang_Dao mhdao;
	@Autowired
	private Hoa_Don_Dao hddao;

	public List<CusCart> getcartbyemail(String mail) {
		List<CusCart> cuscart = new ArrayList<CusCart>();
		try {
			List<CT_HD> cthd = cthddao.getAllCTHD_ByIDHD(hddao.getHDbyemail(mail).getMaHD());
			for (CT_HD x : cthd) {
				Mat_Hang mh = mhdao.getallMatHang().stream().filter(s -> s.getMaMH() == x.getMaMH()).findFirst().get();
				CusCart cc = new CusCart();
				cc.setDonGia(x.getDonGia());
				cc.setGiaBan(mh.getGiaBan());
				cc.setHinhAnh(mh.getHinhAnh());
				cc.setMaCTHD(x.getMaCTHD());
				cc.setMaHD(x.getMaHD());
				cc.setMaMH(x.getMaMH());
				cc.setSL(x.getSL());
				cc.setTenMH(mh.getTenMH());
				cuscart.add(cc);
			}

			return cuscart;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<CusCart> getcartbyidbill(int idbill) {
		List<CusCart> dtbill = new ArrayList<CusCart>();
		try {
			List<CT_HD> cthd = cthddao.getAllCTHD().stream().filter(s->s.getMaHD()==idbill).toList();
			for (CT_HD x : cthd) {
				Mat_Hang mh = mhdao.getallMatHang().stream().filter(s -> s.getMaMH() == x.getMaMH()).findFirst().get();
				CusCart cc = new CusCart();
				cc.setDonGia(x.getDonGia());
				cc.setGiaBan(mh.getGiaBan());
				cc.setHinhAnh(mh.getHinhAnh());
				cc.setMaCTHD(x.getMaCTHD());
				cc.setMaHD(x.getMaHD());
				cc.setMaMH(x.getMaMH());
				cc.setSL(x.getSL());
				cc.setTenMH(mh.getTenMH());
				dtbill.add(cc);
			}

			return dtbill;
		} catch (Exception e) {
			return null;
		}
	}

}
