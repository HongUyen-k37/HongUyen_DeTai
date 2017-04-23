package model.bean;

public class TrangThaiBean {
	private String maThiSinh;
	private int trangThaiDuThi;
	public TrangThaiBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTrangThaiDuThi() {
		return trangThaiDuThi;
	}
	public void setTrangThaiDuThi(int trangThaiDuThi) {
		this.trangThaiDuThi = trangThaiDuThi;
	}
	public String getMaThiSinh() {
		return maThiSinh;
	}
	public void setMaThiSinh(String maThiSinh) {
		this.maThiSinh = maThiSinh;
	}
	public TrangThaiBean(String maThiSinh, int trangThaiDuThi) {
		super();
		this.maThiSinh = maThiSinh;
		this.trangThaiDuThi = trangThaiDuThi;
	}
}
