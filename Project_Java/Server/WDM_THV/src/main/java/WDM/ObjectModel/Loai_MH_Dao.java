package WDM.ObjectModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Loai_MH;
import WDM.ModelMapper.Loai_MH_Mapper;

@Repository
@Transactional
public class Loai_MH_Dao {
	  @Autowired
	  private JdbcTemplate jdbcTemplate;
	  public List<Loai_MH> getallLoaiMH() {
		  String query = "select* from Loai_MH";
		  return jdbcTemplate.query(query,new Loai_MH_Mapper());
		
	}

}
