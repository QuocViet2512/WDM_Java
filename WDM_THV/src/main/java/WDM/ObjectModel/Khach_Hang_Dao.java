package WDM.ObjectModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Khach_Hang;
import WDM.ModelMapper.Khach_Hang_Mapper;

@Repository
@Transactional
public class Khach_Hang_Dao {
	@Autowired
	private JdbcTemplate jd;
	public List<Khach_Hang> getAllKhachHang(){
		String query="select* from khach_hang";
		return jd.query(query,new Khach_Hang_Mapper());
	}
	public Khach_Hang Login(String mail, String pass){
		try {
			String query="exec  login @email=?,@pass = ?";
			return jd.queryForObject(query,new Khach_Hang_Mapper(),mail,pass);
		}catch (Exception e) {
			return null;
		}
		
	}
}
