package WDM.Entity;

import javax.persistence.Entity;

@Entity
public class Loai_MH {
	
	private int MaLMH;
	private String TenLMH;
	private int HangSX;
	public Loai_MH(int maLMH, String tenLMH, int HangSX) {
		super();
		this.MaLMH = maLMH;
		this.TenLMH = tenLMH;
		this.HangSX=HangSX;
	}
	public Loai_MH() {
		super();
	}
	public int getMaLMH() {
		return MaLMH;
	}
	public void setMaLMH(int maLMH) {
		MaLMH = maLMH;
	}
	public String getTenLMH() {
		return TenLMH;
	}
	public void setTenLMH(String tenLMH) {
		TenLMH = tenLMH;
	}
	public int getHangSX() {
		return HangSX;
	}
	public void setHangSX(int hangSX) {
		HangSX = hangSX;
	}
}
