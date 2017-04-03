package model.bean;

public class TKBaiThiBean {
	private String idBaiThi;
	private String tenBaiThi;
	private int soCauHoi;
	private int soLuotLam;
	private double tiLeLamDuoc;
	private String idUser;
	public String getIdBaiThi() {
		return idBaiThi;
	}
	public void setIdBaiThi(String idBaiThi) {
		this.idBaiThi = idBaiThi;
	}
	public String getTenBaiThi() {
		return tenBaiThi;
	}
	public void setTenBaiThi(String tenBaiThi) {
		this.tenBaiThi = tenBaiThi;
	}
	public int getSoCauHoi() {
		return soCauHoi;
	}
	public void setSoCauHoi(int soCauHoi) {
		this.soCauHoi = soCauHoi;
	}
	public int getSoLuotLam() {
		return soLuotLam;
	}
	public void setSoLuotLam(int soLuotLam) {
		this.soLuotLam = soLuotLam;
	}
	public double getTiLeLamDuoc() {
		return tiLeLamDuoc;
	}
	public void setTiLeLamDuoc(double tiLeLamDuoc) {
		this.tiLeLamDuoc = tiLeLamDuoc;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public TKBaiThiBean(String idBaiThi, String tenBaiThi, int soCauHoi, int soLuotLam, double tiLeLamDuoc,
			String idUser) {
		super();
		this.idBaiThi = idBaiThi;
		this.tenBaiThi = tenBaiThi;
		this.soCauHoi = soCauHoi;
		this.soLuotLam = soLuotLam;
		this.tiLeLamDuoc = tiLeLamDuoc;
		this.idUser = idUser;
	}
	
}
