package WDM.Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Loai_MH;
import WDM.Entity.cate_ad;
import WDM.ObjectModel.Hang_SX_Dao;
import WDM.ObjectModel.Loai_MH_Dao;

@Service
@Transactional
public class Loai_MH_Service {
	@Autowired
	private Loai_MH_Dao loaimhdao;
	@Autowired
	private Hang_SX_Dao hsxdao;
	public List<Loai_MH> GetAllLMH(){
		return loaimhdao.getallLoaiMH();
	}
	public List<cate_ad> loadcate_ad(){
		List<cate_ad> lcatead= new ArrayList<cate_ad>();
		try {
			for(Loai_MH x:GetAllLMH()) {
				cate_ad cate = new cate_ad();
				cate.setHangSX(x.getHangSX());
				cate.setMaLMH(x.getMaLMH());
				cate.setTenHangSX(hsxdao.getHangSX(x.getHangSX()).getTenHangSX());
				cate.setTenLMH(x.getTenLMH());
				lcatead.add(cate);
			}
			return lcatead ; 
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

	public boolean ThemLMH(Loai_MH lmh) {
		return loaimhdao.InsertLMH(lmh);
	}
	public boolean SuaLMH(Loai_MH lmh) {
		return loaimhdao.UpdateLMH(lmh);
	}
}
