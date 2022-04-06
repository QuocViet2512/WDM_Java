package WDM.Entity;

import javax.persistence.Entity;

@Entity
public class Chuc_Vu {
	private int MaCV;
	private String TenCV;
	public Chuc_Vu(int maCV, String tenCV) {
		super();
		MaCV = maCV;
		TenCV = tenCV;
	}
	public Chuc_Vu() {
		super();
	}
	public int getMaCV() {
		return MaCV;
	}
	public void setMaCV(int maCV) {
		MaCV = maCV;
	}
	public String getTenCV() {
		return TenCV;
	}
	public void setTenCV(String tenCV) {
		TenCV = tenCV;
	}
	

}
