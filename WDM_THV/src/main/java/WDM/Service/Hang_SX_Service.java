package WDM.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WDM.Entity.Hang_SX;
import WDM.ObjectModel.Hang_SX_Dao;

@Service
@Transactional
public class Hang_SX_Service {
	  @Autowired
	  private Hang_SX_Dao hangsxdao;
	public Hang_SX getHangSX() {
		return hangsxdao.getHangSX(1);
	}
	public List<Hang_SX> getAllHSX(){
		return hangsxdao.getAllHangSX();
	}
}
