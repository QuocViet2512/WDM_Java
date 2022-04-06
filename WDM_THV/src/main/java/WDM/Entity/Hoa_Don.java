package WDM.Entity;




import java.sql.Date;


import javax.persistence.Entity;

@Entity
public class Hoa_Don {

	private int MaHD;
	private Date NgayMua;
	private int TongTien;
	private boolean TrangThaiTT;
	private String EmailKH;
	private String MaNV;
	private String GhiChu;
	public Hoa_Don(int maHD, Date ngayMua, int tongTien, boolean trangThaiTT, String emailKH, String maNV,
			String ghiChu) {
		super();
		MaHD = maHD;
		NgayMua = ngayMua;
		TongTien = tongTien;
		TrangThaiTT = trangThaiTT;
		EmailKH = emailKH;
		MaNV = maNV;
		GhiChu = ghiChu;
	}
	public Hoa_Don() {
		super();
	}
	public int getMaHD() {
		return MaHD;
	}
	public void setMaHD(int maHD) {
		MaHD = maHD;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	public int getTongTien() {
		return TongTien;
	}
	public void setTongTien(int tongTien) {
		TongTien = tongTien;
	}
	public boolean isTrangThaiTT() {
		return TrangThaiTT;
	}
	public void setTrangThaiTT(boolean trangThaiTT) {
		TrangThaiTT = trangThaiTT;
	}
	public String getEmailKH() {
		return EmailKH;
	}
	public void setEmailKH(String emailKH) {
		EmailKH = emailKH;
	}
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	
}
