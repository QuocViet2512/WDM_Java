package WDM.ModelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import WDM.Entity.Hang_SX;

public class Hang_SX_Mapper implements RowMapper<Hang_SX> {

	@Override
	public Hang_SX mapRow(ResultSet rs, int rowNum) throws SQLException {
		Hang_SX hangsx = new Hang_SX();
		hangsx.setMaHangSX(rs.getInt("MaHangSX"));
		hangsx.setTenHangSX(rs.getNString("TenHangSX"));
		hangsx.setDCHangSX(rs.getNString("DCHangSX"));
		return hangsx;
	}
		

}
