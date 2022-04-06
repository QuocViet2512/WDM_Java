package WDM.Entity;

import javax.persistence.Entity;

@Entity
public class Mat_Hang {
	private int MaMH;
	private String TenMH;
	private int GiaBan;
	private int GiaNhap;
	private String MoTa;
	private int SoLuongTon;
	private int BaoHanh;
	private String HinhAnh;
	private String TrangThai;
	private int LoaiMH;
	public Mat_Hang(int maMH, String tenMH, int giaBan, int giaNhap, String moTa, int soLuongTon, int baoHanh,String hinhAnh,
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
	public int getGiaBan() {
		return GiaBan;
	}
	public void setGiaBan(int giaBan) {
		GiaBan = giaBan;
	}
	public int getGiaNhap() {
		return GiaNhap;
	}
	public void setGiaNhap(int giaNhap) {
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
	@Override
	public String toString() {
		return "Mat_Hang [MaMH=" + MaMH + ", TenMH=" + TenMH + ", GiaBan=" + GiaBan + ", GiaNhap=" + GiaNhap + ", MoTa="
				+ MoTa + ", SoLuongTon=" + SoLuongTon + ", BaoHanh=" + BaoHanh + ", HinhAnh=" + HinhAnh + ", TrangThai="
				+ TrangThai + "]";
	}


}
