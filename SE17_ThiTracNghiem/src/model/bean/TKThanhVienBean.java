package model.bean;

public class TKThanhVienBean {
	private String idUser;
	private String hoTen;
	private int soBaiThi;
	private int tongCauHoi;
	private int tongCauDung;
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getSoBaiThi() {
		return soBaiThi;
	}
	public void setSoBaiThi(int soBaiThi) {
		this.soBaiThi = soBaiThi;
	}
	public int getTongCauHoi() {
		return tongCauHoi;
	}
	public void setTongCauHoi(int tongCauHoi) {
		this.tongCauHoi = tongCauHoi;
	}
	public int getTongCauDung() {
		return tongCauDung;
	}
	public void setTongCauDung(int tongCauDung) {
		this.tongCauDung = tongCauDung;
	}
	public TKThanhVienBean(String idUser, String hoTen, int soBaiThi, int tongCauHoi, int tongCauDung) {
		super();
		this.idUser = idUser;
		this.hoTen = hoTen;
		this.soBaiThi = soBaiThi;
		this.tongCauHoi = tongCauHoi;
		this.tongCauDung = tongCauDung;
	}
	
}
