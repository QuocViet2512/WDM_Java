package WDM.Entity;

import javax.persistence.Entity;

@Entity
public class Mat_Hang {
	private int MaMH;
	private String TenMH;
	private float GiaBan;
	private float GiaNhap;
	private String MoTa;
	private int SoLuongTon;
	private int BaoHanh;
	private String HinhAnh;
	private String TrangThai;
	private int LoaiMH;
	public Mat_Hang(int maMH, String tenMH, float giaBan, float giaNhap, String moTa, int soLuongTon, int baoHanh,String hinhAnh,
			String trangThai, int loaiMH) {
		super();
		MaMH = maMH;
		TenMH = tenMH;
		GiaBan = giaBan;
		GiaNhap = giaNhap;
		MoTa = moTa;
		SoLuongTon = soLuongTon;
		BaoHanh = baoHanh;
		HinhAnh = hinhAnh;
		TrangThai = trangThai;
		LoaiMH = loaiMH;
	}
	public String getHinhAnh() {
		return HinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		HinhAnh = hinhAnh;
	}
	public Mat_Hang() {
		super();
	}
	public int getMaMH() {
		return MaMH;
	}
	public void setMaMH(int maMH) {
		MaMH = maMH;
	}
	public String getTenMH() {
		return TenMH;
	}
	public void setTenMH(String tenMH) {
		TenMH = tenMH;
	}
	public float getGiaBan() {
		return GiaBan;
	}
	public void setGiaBan(float giaBan) {
		GiaBan = giaBan;
	}
	public float getGiaNhap() {
		return GiaNhap;
	}
	public void setGiaNhap(float giaNhap) {
		GiaNhap = giaNhap;
	}
	public String getMoTa() {
		return MoTa;
	}
	public void setMoTa(String moTa) {
		MoTa = moTa;
	}
	public int getSoLuongTon() {
		return SoLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		SoLuongTon = soLuongTon;
	}
	public int getBaoHanh() {
		return BaoHanh;
	}
	public void setBaoHanh(int baoHanh) {
		BaoHanh = baoHanh;
	}


	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
	public int getLoaiMH() {
		return LoaiMH;
	}
	public void setLoaiMH(int loaiMH) {
		LoaiMH = loaiMH;
	}
	
	
	
}
