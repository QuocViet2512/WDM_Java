package WDM.ModelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import WDM.Entity.Loai_MH;

public class Loai_MH_Mapper implements RowMapper<Loai_MH> {

	@Override
	public Loai_MH mapRow(ResultSet rs, int rowNum) throws SQLException {
		Loai_MH lmh = new Loai_MH();
		lmh.setMaLMH(rs.getInt("MaLMH"));
		lmh.setTenLMH(rs.getNString("TenLMH"));
		lmh.setHangSX(rs.getInt("HangSX"));
		return lmh;
	}

}
