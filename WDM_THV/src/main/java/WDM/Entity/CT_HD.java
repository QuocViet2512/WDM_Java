package WDM.Entity;

import javax.persistence.Entity;

@Entity
public class CT_HD {
	private int MaCTHD;
	private int MaMH;
	private int SL;
	private int DonGia;
	private int MaHD;
	public CT_HD(int maCTHD, int maMH, int sL, int donGia, int maHD) {
		super();
		MaCTHD = maCTHD;
		MaMH = maMH;
		SL = sL;
		DonGia = donGia;
		MaHD = maHD;
	}
	public CT_HD() {
		super();
	}
	public int getMaCTHD() {
		return MaCTHD;
	}
	public void setMaCTHD(int maCTHD) {
		MaCTHD = maCTHD;
	}
	public int getMaMH() {
		return MaMH;
	}
	public void setMaMH(int maMH) {
		MaMH = maMH;
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
