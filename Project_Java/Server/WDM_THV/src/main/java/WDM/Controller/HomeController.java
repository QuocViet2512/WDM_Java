package WDM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import WDM.Entity.Hoa_Don;
import WDM.Entity.Loai_MH;
import WDM.Entity.Mat_Hang;
import WDM.Service.Hang_SX_Service;
import WDM.Service.Hoa_Don_Service;
import WDM.Service.Loai_MH_Service;
import WDM.Service.Mat_Hang_Service;
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
	
	@RequestMapping("/")
	public ModelAndView test() {
		return new ModelAndView("IndexServer");
	}
	
//-----------------------API------------------------------//
	@RequestMapping(value ="/mathang/getall", method = RequestMethod.GET)
	public ResponseEntity<List<Mat_Hang>> getallmh() {
		return new ResponseEntity<List<Mat_Hang>>(mathangservice.GetAllMH_SV(),HttpStatus.OK);
	}
	@RequestMapping(value ="/hoadon/getall", method = RequestMethod.GET)
	public ResponseEntity<List<Hoa_Don>> getallhd() {
		return new ResponseEntity<List<Hoa_Don>>(hoadonservice.getAllHoaDon(),HttpStatus.OK);
	}
	@RequestMapping("/loaimathang/getall")
	public ResponseEntity<List<Loai_MH>> getalllmh() {
		return new ResponseEntity<List<Loai_MH>>(loaimhservice.GetAllLMH(),HttpStatus.OK);
	}
	


}
