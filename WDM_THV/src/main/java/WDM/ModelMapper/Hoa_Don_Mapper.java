package WDM.ModelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;



import WDM.Entity.Hoa_Don;

public class Hoa_Don_Mapper implements RowMapper<Hoa_Don> {
@Override
public Hoa_Don mapRow(ResultSet rs, int rowNum) throws SQLException {
	// TODO Auto-generated method stub
	Hoa_Don hd = new Hoa_Don();	
	hd.setMaHD(rs.getInt("MaHD"));
	hd.setNgayMua(rs.getDate("NgayMua"));
	hd.setTongTien(rs.getInt("TongTien"));
	hd.setEmailKH(rs.getString("EmailKH"));
	hd.setMaNV(rs.getString("MaNV"));
	hd.setTrangThaiTT(rs.getBoolean("TrangThaiTT"));
	hd.setGhiChu(rs.getNString("GhiChu"));
	return hd;
}
}
