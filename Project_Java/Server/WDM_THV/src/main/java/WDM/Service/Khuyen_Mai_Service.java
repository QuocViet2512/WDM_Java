package WDM.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Khuyen_Mai;
import WDM.ObjectModel.Khuyen_Mai_Dao;

@Service
@Transactional
public class Khuyen_Mai_Service {
@Autowired
private Khuyen_Mai_Dao kmdao;
public List<Khuyen_Mai> getAllKhuyenMai(){
	return kmdao.getAllKhuyenMai();
}
}
