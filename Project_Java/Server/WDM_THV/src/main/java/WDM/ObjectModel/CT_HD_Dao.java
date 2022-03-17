package WDM.ObjectModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.CT_HD;
import WDM.ModelMapper.CT_HD_Mapper;

@Repository
@Transactional
public class CT_HD_Dao {
@Autowired
private JdbcTemplate jdbctemplate;
public List<CT_HD> getAllCTHD(){
	String query = "select* from ct_hd";
	return jdbctemplate.query(query, new CT_HD_Mapper());
}
}
