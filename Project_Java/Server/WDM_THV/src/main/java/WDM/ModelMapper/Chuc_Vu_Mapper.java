package WDM.ModelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import WDM.Entity.Chuc_Vu;

public class Chuc_Vu_Mapper implements RowMapper<Chuc_Vu> {

	@Override
	public Chuc_Vu mapRow(ResultSet rs, int rowNum) throws SQLException {
		Chuc_Vu cv = new Chuc_Vu();
		cv.setMaCV(rs.getInt("MaCV"));
		cv.setTenCV(rs.getNString("TenCV"));
		return cv;
	}

}
