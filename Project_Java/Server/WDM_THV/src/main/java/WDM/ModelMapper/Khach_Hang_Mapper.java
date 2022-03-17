package WDM.ModelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import WDM.Entity.Khach_Hang;

public class Khach_Hang_Mapper implements RowMapper<Khach_Hang> {
@Override
public Khach_Hang mapRow(ResultSet rs, int rowNum) throws SQLException {
	Khach_Hang kh = new Khach_Hang();
	kh.setEmailKH(rs.getString("EmailKH"));
	kh.setTenKH(rs.getNString("TenKH"));
	kh.setDiaChiKH(rs.getNString("DiaChiKH"));
	kh.setSDTKH(rs.getString("SDTKH"));
	kh.setMatKhauKH(rs.getString("MatKhauKH"));
	return kh;
}
}
