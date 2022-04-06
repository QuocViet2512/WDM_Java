package WDM.ObjectModel;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.CT_HD;
import WDM.ModelMapper.CT_HD_Mapper;

@Repository
@Transactional
public class CT_HD_Dao {
	@Autowired
	private JdbcTemplate jdbctemplate;

	public List<CT_HD> getAllCTHD() {
		String query = "select* from ct_hd";
		return jdbctemplate.query(query, new CT_HD_Mapper());
	}

	public List<CT_HD> getAllCTHD_ByIDHD(int idhd) {
		try {
			String query = "select* from ct_hd where mahd=?";
			return jdbctemplate.query(query, new CT_HD_Mapper(), idhd);
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}
	
	public CT_HD getexsistid(int idmh ,int idhd) {
		try {
			String query = "select* from ct_hd where maMH=? and mahd=?";
			return jdbctemplate.queryForObject(query, new CT_HD_Mapper(),idmh, idhd);
		}
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public void addtocart(int idmh,int idhd) {
		try {
			
			String query = "insert into ct_hd values (?,1,(select giaban from Mat_Hang where MaMH = ? ),?)";
			 jdbctemplate.update(query,idmh,idmh,idhd);
		}catch (Exception e) {
			
		}
	}
	public void updatetocart(int idmh,int idcthd,int idhd) {
		try {
			String query = "update CT_HD set sl+=1, dongia+= (select giaban from Mat_Hang where MaMH = ? )where MaCTHD =? and MaHD = ? ";
			jdbctemplate.update(query,idmh,idcthd,idhd);
		}catch (Exception e) {
			
		}
	}
}
