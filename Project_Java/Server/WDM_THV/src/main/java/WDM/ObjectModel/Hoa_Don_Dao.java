package WDM.ObjectModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Hoa_Don;
import WDM.ModelMapper.Hoa_Don_Mapper;

@Repository
@Transactional
public class Hoa_Don_Dao {
@Autowired
private JdbcTemplate jd ;
public List<Hoa_Don> getAllHoaDon(){
	String query ="select* from hoa_don";
	return jd.query(query, new Hoa_Don_Mapper());
}
}
