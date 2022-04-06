package WDM.Entity;

import javax.persistence.Entity;

@Entity
public class Khuyen_Mai {
	private int MaKM;
	private int PhanTramGiam;
	private int MaMH;
	
	public Khuyen_Mai() {
		super();
	}
	public Khuyen_Mai(int maKM, int phanTramGiam, int maMH) {
		super();
		MaKM = maKM;
		PhanTramGiam = phanTramGiam;
		MaMH = maMH;
	}
	public int getMaKM() {
		return MaKM;
	}
	public void setMaKM(int maKM) {
		MaKM = maKM;
	}
	public int getPhanTramGiam() {
		return PhanTramGiam;
	}
	public void setPhanTramGiam(int phanTramGiam) {
		PhanTramGiam = phanTramGiam;
	}
	public int getMaMH() {
		return MaMH;
	}
	public void setMaMH(int maMH) {
		MaMH = maMH;
	}
	
}
