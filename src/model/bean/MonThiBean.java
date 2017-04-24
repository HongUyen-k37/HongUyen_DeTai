package model.bean;

public class MonThiBean {
	private String maMonThi;
	private String maKyThi;
	private String tenMonThi;
	private int trangThaiMonThi;
	private int coSoPhongThi;
	private int coSoTui;
	private int soLuot;
	private int heSo;

	public MonThiBean(String maMonThi, String maKyThi, String tenMonThi, int trangThaiMonThi, int coSoPhongThi,
			int coSoTui, int soLuot, int heSo) {
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

	public MonThiBean(String tenMonThi, int heSo) {
		super();
		this.tenMonThi = tenMonThi;
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

	public int getTrangThaiMonThi() {
		return trangThaiMonThi;
	}

	public void setTrangThaiMonThi(int trangThaiMonThi) {
		this.trangThaiMonThi = trangThaiMonThi;
	}

	public int getCoSoPhongThi() {
		return coSoPhongThi;
	}

	public void setCoSoPhongThi(int coSoPhongThi) {
		this.coSoPhongThi = coSoPhongThi;
	}

	public int getCoSoTui() {
		return coSoTui;
	}

	public void setCoSoTui(int coSoTui) {
		this.coSoTui = coSoTui;
	}

	public int getSoLuot() {
		return soLuot;
	}

	public void setSoLuot(int soLuot) {
		this.soLuot = soLuot;
	}

	public int getHeSo() {
		return heSo;
	}

	public void setHeSo(int heSo) {
		this.heSo = heSo;
	}

	public MonThiBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
