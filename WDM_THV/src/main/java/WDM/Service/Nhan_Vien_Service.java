package WDM.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Nhan_Vien;
import WDM.ObjectModel.Nhan_Vien_Dao;

@Service
@Transactional
public class Nhan_Vien_Service {
@Autowired
private Nhan_Vien_Dao nvdao;
public List<Nhan_Vien> getAllNhanVien(){
	return nvdao.getAllNhanVien();
}
public Nhan_Vien LoginAD(String Code,String Pass){
	return nvdao.LoginAD(Code, Pass);
}
}
