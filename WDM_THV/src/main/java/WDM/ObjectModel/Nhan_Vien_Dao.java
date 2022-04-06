package WDM.ObjectModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Nhan_Vien;
import WDM.ModelMapper.Nhan_Vien_Mapper;

@Repository
@Transactional
public class Nhan_Vien_Dao {
@Autowired
private JdbcTemplate jd ;
public List<Nhan_Vien> getAllNhanVien(){
	String query="select* from nhan_vien";
	return jd.query(query, new Nhan_Vien_Mapper());
}
public Nhan_Vien LoginAD(String Code,String Pass) {
	try {
	String qr = "exec LoginAD @Code=?,@Pass=? ";
	return jd.queryForObject(qr,new Nhan_Vien_Mapper() ,Code,Pass);
	}catch (Exception e) {
		// TODO: handle exception
		return null;
	}
}
}
