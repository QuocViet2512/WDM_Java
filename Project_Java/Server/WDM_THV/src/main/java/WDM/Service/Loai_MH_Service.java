package WDM.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Loai_MH;
import WDM.ObjectModel.Loai_MH_Dao;

@Service
@Transactional
public class Loai_MH_Service {
	@Autowired
	private Loai_MH_Dao loaimhdao;
	public List<Loai_MH> GetAllLMH(){
		return loaimhdao.getallLoaiMH();
	}
		

}
