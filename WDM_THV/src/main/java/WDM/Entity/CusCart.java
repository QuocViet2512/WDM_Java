package WDM.Entity;


import javax.persistence.Entity;

@Entity
public class CusCart {

	private int MaMH;
	private String TenMH;
	private int GiaBan;
	private String HinhAnh;	
	private int MaCTHD;
	private int SL;
	private int DonGia;
	private int MaHD;
	public CusCart() {
		super();
	}
	public CusCart(int maMH, String tenMH, int giaBan, String hinhAnh, int maCTHD, int sL,
			int donGia, int maHD ) {
		super();
		MaMH = maMH;
		TenMH = tenMH;
		GiaBan = giaBan;
		HinhAnh = hinhAnh;
		MaCTHD = maCTHD;
		SL = sL;
		DonGia = donGia;
		MaHD = maHD;
	
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
	public String getHinhAnh() {
		return HinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		HinhAnh = hinhAnh;
	}

	public int getMaCTHD() {
		return MaCTHD;
	}
	public void setMaCTHD(int maCTHD) {
		MaCTHD = maCTHD;
	}
	public int getSL() {
		return SL;
	}
	public void setSL(int sL) {
		SL = sL;
	}
	public int getDonGia() {
		return DonGia;
	}
	public void setDonGia(int donGia) {
		DonGia = donGia;
	}
	public int getMaHD() {
		return MaHD;
	}
	public void setMaHD(int maHD) {
		MaHD = maHD;
	}
	
	
}
