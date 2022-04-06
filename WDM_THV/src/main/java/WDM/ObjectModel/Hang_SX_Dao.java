package WDM.ObjectModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Hang_SX;
import WDM.ModelMapper.Hang_SX_Mapper;

@Repository
@Transactional
public class Hang_SX_Dao {
	  @Autowired
	  private JdbcTemplate jdbcTemplate;
	  public Hang_SX getHangSX(int id ) {
		    String sql = "SELECT  * FROM hang_sx where MaHangSX=?";
		    return  jdbcTemplate.queryForObject(sql, new Hang_SX_Mapper(),id);
		  }
	  
	  public List<Hang_SX> getAllHangSX() {
		    String sql = "SELECT  * FROM hang_sx";
		    return  jdbcTemplate.query(sql, new Hang_SX_Mapper());
		  }
}
