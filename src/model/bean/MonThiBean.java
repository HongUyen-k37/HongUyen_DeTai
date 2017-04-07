package model.bean;

public class MonThiBean {
	private String maMonThi;
	private String maKyThi;
	private String tenMonThi;
	private String trangThaiMonThi;
	private String coSoPhongThi;
	private String coSoTui;
	private String soLuot;
	private String heSo;
	public String getHeSo() {
		return heSo;
	}
	public void setHeSo(String heSo) {
		this.heSo = heSo;
	}
	public String getMaMonThi() {
		return maMonThi;
	}
	public void setMaMonThi(String maMonThi) {
		this.maMonThi = maMonThi;
	}
	public String getMaKyThi() {
		return maKyThi;
	}
	public void setMaKyThi(String maKyThi) {
		this.maKyThi = maKyThi;
	}
	public String getTenMonThi() {
		return tenMonThi;
	}
	public void setTenMonThi(String tenMonThi) {
		this.tenMonThi = tenMonThi;
	}
	public String getTrangThaiMonThi() {
		return trangThaiMonThi;
	}
	public void setTrangThaiMonThi(String trangThaiMonThi) {
		this.trangThaiMonThi = trangThaiMonThi;
	}
	public String getCoSoPhongThi() {
		return coSoPhongThi;
	}
	public void setCoSoPhongThi(String coSoPhongThi) {
		this.coSoPhongThi = coSoPhongThi;
	}
	public String getCoSoTui() {
		return coSoTui;
	}
	public void setCoSoTui(String coSoTui) {
		this.coSoTui = coSoTui;
	}
	public String getSoLuot() {
		return soLuot;
	}
	public void setSoLuot(String soLuot) {
		this.soLuot = soLuot;
	}
	public MonThiBean(String maMonThi, String maKyThi, String tenMonThi, String trangThaiMonThi, String coSoPhongThi,
			String coSoTui, String soLuot, String heSo) {
		super();
		this.maMonThi = maMonThi;
		this.maKyThi = maKyThi;
		this.tenMonThi = tenMonThi;
		this.trangThaiMonThi = trangThaiMonThi;
		this.coSoPhongThi = coSoPhongThi;
		this.coSoTui = coSoTui;
		this.soLuot = soLuot;
		this.heSo = heSo;
	}
	public MonThiBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
