package WDM.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Hoa_Don;
import WDM.ObjectModel.Hoa_Don_Dao;



@Service
@Transactional
public class Hoa_Don_Service {
@Autowired
private Hoa_Don_Dao hddao;
public List<Hoa_Don> getAllHoaDon(){
	return hddao.getAllHoaDon();
}
}
