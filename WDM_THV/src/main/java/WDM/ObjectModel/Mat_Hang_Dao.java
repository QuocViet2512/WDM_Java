package WDM.ObjectModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Mat_Hang;
import WDM.ModelMapper.Mat_Hang_Mapper;

@Repository
@Transactional
public class Mat_Hang_Dao {
	  @Autowired
	  private JdbcTemplate jdbcTemplate;
	  public List<Mat_Hang> getallMatHang() {
		  String query = "select* from Mat_Hang order by MaMH desc";
		  return jdbcTemplate.query(query,new Mat_Hang_Mapper());
		
	}
	  public Mat_Hang getMatHangbyID(int id) {
		  try {
			  String query = "select* from Mat_Hang where mamh = ?";
			  return jdbcTemplate.queryForObject(query,new Mat_Hang_Mapper(),id);
		  }catch (Exception e) {
			return null;
		}
		  
	  }
	  	public void insertMH(Mat_Hang mh) {
	  		try {
	  			String query = "insert  mat_hang values (?, ?,?,?,?,?,?,?,?)";
	  			jdbcTemplate.update(query,mh.getTenMH(),mh.getGiaBan(),mh.getGiaNhap(),mh.getMoTa(),mh.getSoLuongTon(),mh.getBaoHanh(),mh.getTrangThai(),mh.getLoaiMH(),mh.getHinhAnh());
	  		}catch(Exception e) {
	  			System.out.println(e);
	  		}
	  	}
	  	public boolean deleteMH(int idmh) {
	  		try {
	  			jdbcTemplate.update("delete mat_hang where MaMH=?",idmh);
	  			return true;
	  		}catch (Exception e) {
				// TODO: handle exception
	  			System.out.println(e);
	  			return false;
			}
	  	}
	  	
	  	public boolean UpdateMH(Mat_Hang mh) {
	  		try {
	  			String query="update mat_hang set TenMH =? , GiaBan =?, GiaNhap=?,mota=?, soluongton=?, baohanh=?,  trangthai=?, LoaiMH=?,HinhAnh=? where MaMH = ?";
	  			jdbcTemplate.update(query,mh.getTenMH(),mh.getGiaBan(),mh.getGiaNhap(),mh.getMoTa(),mh.getSoLuongTon(),mh.getBaoHanh(),mh.getTrangThai(),mh.getLoaiMH(),mh.getHinhAnh(),mh.getMaMH());
	  			return true;
	  		}catch (Exception e) {
				// TODO: handle exception
	  			System.out.println(e);
	  			return false;
			}
	  	}
}
