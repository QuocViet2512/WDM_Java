package WDM.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Mat_Hang;
import WDM.ObjectModel.Mat_Hang_Dao;

@Service
@Transactional
public class Mat_Hang_Service {
	@Autowired
	private Mat_Hang_Dao mathangdao;
	public List<Mat_Hang> GetAllMH_SV() {
		return mathangdao.getallMatHang();
	}
}
