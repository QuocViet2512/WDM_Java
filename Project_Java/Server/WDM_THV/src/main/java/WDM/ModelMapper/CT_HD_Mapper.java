package WDM.ModelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import WDM.Entity.CT_HD;

public class CT_HD_Mapper implements RowMapper<CT_HD> {
@Override
public CT_HD mapRow(ResultSet rs, int rowNum) throws SQLException {
	CT_HD ct = new CT_HD();
	ct.setMaCTHD(rs.getInt("MaCTHD"));
	ct.setMaMH(rs.getInt("MaMH"));
	ct.setSL(rs.getInt("SL"));
	ct.setDonGia(rs.getFloat("DonGia"));
	ct.setMaHD(rs.getInt("MaHD"));
	return ct;
}
}
