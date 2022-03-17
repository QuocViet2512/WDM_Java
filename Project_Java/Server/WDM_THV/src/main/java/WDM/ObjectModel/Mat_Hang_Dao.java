package WDM.ObjectModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Mat_Hang;
import WDM.ModelMapper.Mat_Hang_Mapper;

@Repository
@Transactional
public class Mat_Hang_Dao {
	  @Autowired
	  private JdbcTemplate jdbcTemplate;
	  public List<Mat_Hang> getallMatHang() {
		  String query = "select* from Mat_Hang";
		  return jdbcTemplate.query(query,new Mat_Hang_Mapper());
		
	}

}
