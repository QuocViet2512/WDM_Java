package WDM.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Mat_Hang;
import WDM.Entity.product_ad;
import WDM.ObjectModel.Loai_MH_Dao;
import WDM.ObjectModel.Mat_Hang_Dao;

@Transactional
@Service
public class product_ad_sv {
	@Autowired
	private Mat_Hang_Dao mhdao;
	@Autowired
	private Loai_MH_Dao lmhdao;
	
	public List<product_ad> getAllProductAD(){
		try {
			List<product_ad> lprd = new ArrayList<product_ad>();
			for(Mat_Hang x: mhdao.getallMatHang()) {
				product_ad prd = new product_ad();
				prd.setBaoHanh(x.getBaoHanh());
				prd.setGiaBan(x.getGiaBan());
				prd.setGiaNhap(x.getGiaNhap());
				prd.setHinhAnh(x.getHinhAnh());
				prd.setTenLoaiMH(lmhdao.getallLoaiMH().stream().filter(s->s.getMaLMH()==x.getLoaiMH()).findFirst().get().getTenLMH());
				prd.setMaMH(x.getMaMH());
				prd.setMoTa(x.getMoTa());
				prd.setSoLuongTon(x.getSoLuongTon());
				prd.setTenMH(x.getTenMH());
				prd.setTrangThai(x.getTrangThai());
				prd.setMaLoaiMH(x.getLoaiMH());
				lprd.add(prd);
			}
			return lprd;
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public boolean ThemMH(Mat_Hang mh) {
		try {
			mhdao.insertMH(mh);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	public boolean XoaMH(int idmh) {
		return mhdao.deleteMH(idmh);
	}
	public boolean CapnhatMH(Mat_Hang mh) {
		return mhdao.UpdateMH(mh);
	}
}
