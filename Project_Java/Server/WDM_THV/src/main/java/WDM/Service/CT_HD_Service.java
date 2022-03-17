package WDM.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.CT_HD;
import WDM.ObjectModel.CT_HD_Dao;

@Service
@Transactional
public class CT_HD_Service {
	@Autowired
	private CT_HD_Dao cthddao;
	public List<CT_HD> getAllCTHD(){
		return cthddao.getAllCTHD();
	}
}
