package WDM.ModelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import WDM.Entity.Khuyen_Mai;

public class Khuyen_Mai_Mapper implements RowMapper<Khuyen_Mai>{
@Override
public Khuyen_Mai mapRow(ResultSet rs, int rowNum) throws SQLException {
	// TODO Auto-generated method stub
	Khuyen_Mai km = new Khuyen_Mai();
	km.setMaKM(rs.getInt("MaKM"));
	km.setPhanTramGiam(rs.getInt("PhanTramGiam"));
	km.setMaMH(rs.getInt("MaMH"));
	return km;
}
}
