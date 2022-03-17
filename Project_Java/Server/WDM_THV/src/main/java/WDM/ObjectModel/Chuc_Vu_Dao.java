package WDM.ObjectModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Chuc_Vu;
import WDM.ModelMapper.Chuc_Vu_Mapper;

@Repository
@Transactional
public class Chuc_Vu_Dao {
	@Autowired
	private JdbcTemplate jdbctemplate;
	public List<Chuc_Vu> getAllChucVu(){
		String query="select* from chuc_vu";
		return jdbctemplate.query(query,new Chuc_Vu_Mapper());
	}
}
