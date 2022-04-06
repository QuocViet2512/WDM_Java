package WDM.Entity;

public class cate_ad {
	
	private int MaLMH;
	private String TenLMH;
	private int HangSX;
	private String TenHangSX;
	public cate_ad(int maLMH, String tenLMH, int hangSX, String tenHangSX) {
		super();
		MaLMH = maLMH;
		TenLMH = tenLMH;
		HangSX = hangSX;
		TenHangSX = tenHangSX;
	}
	public cate_ad() {
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
	public String getTenHangSX() {
		return TenHangSX;
	}
	public void setTenHangSX(String tenHangSX) {
		TenHangSX = tenHangSX;
	}
	
}
