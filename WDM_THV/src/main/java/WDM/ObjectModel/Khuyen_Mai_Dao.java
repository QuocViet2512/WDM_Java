package WDM.ObjectModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Khuyen_Mai;
import WDM.ModelMapper.Khuyen_Mai_Mapper;

@Repository
@Transactional
public class Khuyen_Mai_Dao {
	@Autowired
	private JdbcTemplate jd ;
	public List<Khuyen_Mai> getAllKhuyenMai(){
		String query ="select* from khuyen_mai";
	return jd.query(query, new Khuyen_Mai_Mapper());
	}

}
