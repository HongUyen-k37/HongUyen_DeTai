package model.bean;

public class TrangThai {
	private String maThiSinh;
	private int trangThai;
	public String getMaThiSinh() {
		return maThiSinh;
	}
	public void setMaThiSinh(String maThiSinh) {
		this.maThiSinh = maThiSinh;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public TrangThai(String maThiSinh, int trangThai) {
		super();
		this.maThiSinh = maThiSinh;
		this.trangThai = trangThai;
	}
	public TrangThai() {
		super();
		// TODO Auto-generated constructor stub
	}
}
