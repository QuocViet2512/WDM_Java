package WDM.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Chuc_Vu;
import WDM.ObjectModel.Chuc_Vu_Dao;

@Service
@Transactional
public class Chuc_Vu_Service {
	@Autowired
	private Chuc_Vu_Dao cvdao;
	public List<Chuc_Vu> getAllChucVu(){
		return cvdao.getAllChucVu();
	}

}
