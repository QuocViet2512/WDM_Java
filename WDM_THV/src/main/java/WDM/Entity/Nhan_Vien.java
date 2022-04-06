package WDM.Entity;

import javax.persistence.Entity;

@Entity
public class Nhan_Vien {
	private String MaNV;
	private String TenNV;
	private String MatKhauNV;
	private int ChucVu;
	public Nhan_Vien(String maNV, String tenNV, String matKhauNV, int chucVu) {
		super();
		MaNV = maNV;
		TenNV = tenNV;
		MatKhauNV = matKhauNV;
		ChucVu = chucVu;
	}
	public Nhan_Vien() {
		super();
	}
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getTenNV() {
		return TenNV;
	}
	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}
	public String getMatKhauNV() {
		return MatKhauNV;
	}
	public void setMatKhauNV(String matKhauNV) {
		MatKhauNV = matKhauNV;
	}
	public int getChucVu() {
		return ChucVu;
	}
	public void setChucVu(int chucVu) {
		ChucVu = chucVu;
	}

}
