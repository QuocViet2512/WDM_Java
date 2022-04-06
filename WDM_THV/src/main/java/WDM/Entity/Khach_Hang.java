package WDM.Entity;

import javax.persistence.Entity;

@Entity
public class Khach_Hang {

	private String EmailKH;
	private String TenKH;
	private String DiaChiKH;
	private String SDTKH;
	private String MatKhauKH;
	public Khach_Hang(String emailKH, String tenKH, String diaChiKH, String sDTKH, String matKhauKH) {
		super();
		EmailKH = emailKH;
		TenKH = tenKH;
		DiaChiKH = diaChiKH;
		SDTKH = sDTKH;
		MatKhauKH = matKhauKH;
	}
	public Khach_Hang() {
		super();
	}
	public String getEmailKH() {
		return EmailKH;
	}
	public void setEmailKH(String emailKH) {
		EmailKH = emailKH;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	public String getDiaChiKH() {
		return DiaChiKH;
	}
	public void setDiaChiKH(String diaChiKH) {
		DiaChiKH = diaChiKH;
	}
	public String getSDTKH() {
		return SDTKH;
	}
	public void setSDTKH(String sDTKH) {
		SDTKH = sDTKH;
	}
	public String getMatKhauKH() {
		return MatKhauKH;
	}
	public void setMatKhauKH(String matKhauKH) {
		MatKhauKH = matKhauKH;
	}
	
}
