package model.bean;

public class PhongThiBean {
	private String maPhongThi;
	private String maKyThi;
	private String soHieuPhongThi;
	private int soLuongThiSinh;
	public String getMaPhongThi() {
		return maPhongThi;
	}
	public void setMaPhongThi(String maPhongThi) {
		this.maPhongThi = maPhongThi;
	}
	public String getMaKyThi() {
		return maKyThi;
	}
	public void setMaKyThi(String maKyThi) {
		this.maKyThi = maKyThi;
	}
	public String getSoHieuPhongThi() {
		return soHieuPhongThi;
	}
	public void setSoHieuPhongThi(String soHieuPhongThi) {
		this.soHieuPhongThi = soHieuPhongThi;
	}
	public int getSoLuongThiSinh() {
		return soLuongThiSinh;
	}
	public void setSoLuongThiSinh(int soLuongThiSinh) {
		this.soLuongThiSinh = soLuongThiSinh;
	}
	public PhongThiBean(String maPhongThi, String maKyThi, String soHieuPhongThi, int soLuongThiSinh) {
		super();
		this.maPhongThi = maPhongThi;
		this.maKyThi = maKyThi;
		this.soHieuPhongThi = soHieuPhongThi;
		this.soLuongThiSinh = soLuongThiSinh;
	}
	public PhongThiBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
