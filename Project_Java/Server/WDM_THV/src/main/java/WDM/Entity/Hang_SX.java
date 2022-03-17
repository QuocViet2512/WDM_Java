package WDM.Entity;

import javax.persistence.Entity;

@Entity
public class Hang_SX {
	private int MaHangSX ;
	private String TenHangSX;
	private String DCHangSX;
	public Hang_SX(int maHangSX, String tenHangSX, String dCHangSX) {
		super();
		MaHangSX = maHangSX;
		TenHangSX = tenHangSX;
		DCHangSX = dCHangSX;
	}
	
	public Hang_SX() {
		super();
	}

	public int getMaHangSX() {
		return MaHangSX;
	}

	public void setMaHangSX(int maHangSX) {
		MaHangSX = maHangSX;
	}

	public String getTenHangSX() {
		return TenHangSX;
	}

	public void setTenHangSX(String tenHangSX) {
		TenHangSX = tenHangSX;
	}

	public String getDCHangSX() {
		return DCHangSX;
	}

	public void setDCHangSX(String dCHangSX) {
		DCHangSX = dCHangSX;
	}
	
}
