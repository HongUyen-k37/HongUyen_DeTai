package model.bean;

public class BaiThiBean {
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
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
	public int getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(int thoiGian) {
		this.thoiGian = thoiGian;
	}
	public int getSoCauHoi() {
		return soCauHoi;
	}
	public void setSoCauHoi(int soCauHoi) {
		this.soCauHoi = soCauHoi;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getIdLoai() {
		return idLoai;
	}
	public void setIdLoai(String idLoai) {
		this.idLoai = idLoai;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	private String idBaiThi;
	private String tenBaiThi;
	private int thoiGian;
	private int soCauHoi;
	private String moTa;
	private String idLoai;
	private String password;
	private String idUser;
	private boolean active;
	private int soLuotLam;
	public BaiThiBean(String idBaiThi, String tenBaiThi, int thoiGian, int soCauHoi, String moTa, String idLoai,
			String password, String idUser, boolean active) {
		super();
		this.idBaiThi = idBaiThi;
		this.tenBaiThi = tenBaiThi;
		this.thoiGian = thoiGian;
		this.soCauHoi = soCauHoi;
		this.moTa = moTa;
		this.idLoai = idLoai;
		this.password = password;
		this.idUser = idUser;
		this.active = active;
	}
	public BaiThiBean() {
		super();
	}
	public int getSoLuotLam() {
		return soLuotLam;
	}
	public void setSoLuotLam(int soLuotLam) {
		this.soLuotLam = soLuotLam;
	}
	
	

}
