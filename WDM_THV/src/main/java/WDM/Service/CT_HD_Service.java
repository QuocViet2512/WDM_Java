package WDM.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.CT_HD;
import WDM.ObjectModel.CT_HD_Dao;
import WDM.ObjectModel.Hoa_Don_Dao;

@Service
@Transactional
public class CT_HD_Service {
	@Autowired
	private CT_HD_Dao cthddao;
	@Autowired
	private Hoa_Don_Dao hddao;

	public List<CT_HD> getAllCTHD() {
		return cthddao.getAllCTHD();
	}

	public boolean addtocart(int idmh, String mail) {
		try {
			if (hddao.getHDbyemail(mail) == null) {
				hddao.createhoadon(mail);
			}

			int mhd2 = hddao.getHDbyemail(mail).getMaHD();
			CT_HD ct = cthddao.getexsistid(idmh, mhd2);
			if (ct == null) {
				cthddao.addtocart(idmh, mhd2);
			} else {
				cthddao.updatetocart(idmh, ct.getMaCTHD(), mhd2);
			}

			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}

}
