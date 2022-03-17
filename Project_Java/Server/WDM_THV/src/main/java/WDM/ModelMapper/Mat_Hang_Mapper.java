package WDM.ModelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import WDM.Entity.Mat_Hang;

public class Mat_Hang_Mapper implements RowMapper<Mat_Hang> {

	@Override
	public Mat_Hang mapRow(ResultSet rs, int rowNum) throws SQLException {
		Mat_Hang mh = new Mat_Hang();
		mh.setMaMH(rs.getInt("MaMH"));
		mh.setBaoHanh(rs.getInt("BaoHanh"));
		mh.setGiaBan(rs.getFloat("GiaBan"));
		mh.setGiaNhap(rs.getFloat("GiaNhap"));
		mh.setTenMH(rs.getNString("TenMH"));
		mh.setMoTa(rs.getNString("MoTa"));
		mh.setSoLuongTon(rs.getInt("SoLuongTon"));
		mh.setTrangThai(rs.getNString("TrangThai"));
		mh.setLoaiMH(rs.getInt("LoaiMH"));
		mh.setHinhAnh(rs.getNString("HinhAnh"));
		return mh;
	}

}
