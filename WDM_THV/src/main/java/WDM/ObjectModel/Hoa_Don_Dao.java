package WDM.ObjectModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private JdbcTemplate jd;

	public List<Hoa_Don> getAllHoaDon() {
		String query = "select* from hoa_don";
		return jd.query(query, new Hoa_Don_Mapper());
	}

	public Hoa_Don getHDbyemail(String email) {
		try {
			String query = "select* from hoa_don where tongtien=0 and Emailkh=?";
			return jd.queryForObject(query, new Hoa_Don_Mapper(), email);
		} catch (Exception e) {
			return null;
		}

	}
	public void createhoadon(String mail) {
		try {
			String query ="insert into Hoa_Don values(null,0,0,?,null,null )";
			  Map<String, Object> param = new HashMap<String, Object>();
			  param.put("mail", mail);
			  
			jd.update(query,mail);
					
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void dathang(int idhoadon, String ghichu ) {
		try {
			String query ="update Hoa_Don set NgayMua=getdate(),TongTien=(select sum(dongia) from CT_HD where MaHD = ?),GhiChu=? where MaHD = ?";
			jd.update(query,idhoadon,ghichu,idhoadon);
					
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void XacnhanTT(int idhoadon,String manv ) {
		try {
			String query ="update hoa_don set trangthaitt = 1, manv=? where  mahd =?";
			jd.update(query,idhoadon,manv);
					
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
