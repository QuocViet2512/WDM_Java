package WDM.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Khach_Hang;
import WDM.ObjectModel.Khach_Hang_Dao;

@Service
@Transactional
public class Khach_Hang_Service {
@Autowired
private Khach_Hang_Dao khdao;
public List<Khach_Hang> getAllKhachHang(){
	return khdao.getAllKhachHang();
}
}
