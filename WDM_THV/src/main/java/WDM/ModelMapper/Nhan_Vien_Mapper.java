package WDM.ModelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import WDM.Entity.Nhan_Vien;

public class Nhan_Vien_Mapper implements RowMapper<Nhan_Vien> {
@Override
public Nhan_Vien mapRow(ResultSet rs, int rowNum) throws SQLException {
	Nhan_Vien nv = new Nhan_Vien();
	nv.setMaNV(rs.getString("MaNV"));
	nv.setTenNV(rs.getNString("TenNV"));
	nv.setMatKhauNV(rs.getString("MatKhauNV"));
	nv.setChucVu(rs.getInt("ChucVu"));
	return nv;
}
}
