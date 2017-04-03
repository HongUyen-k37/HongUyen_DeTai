package model.bean;

public class CauHoiBean {
	public String getIdCauHoi() {
		return idCauHoi;
	}
	public void setIdCauHoi(String idCauHoi) {
		this.idCauHoi = idCauHoi;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getDapAn() {
		return dapAn;
	}
	public void setDapAn(String dapAn) {
		this.dapAn = dapAn;
	}
	public String getTraLoiMot() {
		return traLoiMot;
	}
	public void setTraLoiMot(String traLoiMot) {
		this.traLoiMot = traLoiMot;
	}
	public String getTraLoiHai() {
		return traLoiHai;
	}
	public void setTraLoiHai(String traLoiHai) {
		this.traLoiHai = traLoiHai;
	}
	public String getTraLoiBa() {
		return traLoiBa;
	}
	public void setTraLoiBa(String traLoiBa) {
		this.traLoiBa = traLoiBa;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	private String idCauHoi;
	private String noiDung;
	private String dapAn;
	private String traLoiMot;
	private String traLoiHai;
	private String traLoiBa;
	private String traLoiBon;
	private String traLoiChon;
	private String idUser;
	private String idLoai;
	private int viTri;
	public CauHoiBean(String idCauHoi, String noiDung, String dapAn, String traLoiMot, String traLoiHai,
			String traLoiBa,String traLoiBon, String idUser,String idLoai) {
		super();
		this.idCauHoi = idCauHoi;
		this.noiDung = noiDung;
		this.dapAn = dapAn;
		this.traLoiMot = traLoiMot;
		this.traLoiHai = traLoiHai;
		this.traLoiBa = traLoiBa;
		this.idUser = idUser;
		this.traLoiBon=traLoiBon;
		this.idLoai = idLoai;
	}
	public int getViTri() {
		return viTri;
	}
	public void setViTri(int viTri) {
		this.viTri = viTri;
	}
	public String getTraLoiBon() {
		return traLoiBon;
	}
	public void setTraLoiBon(String traLoiBon) {
		this.traLoiBon = traLoiBon;
	}
	public String getTraLoiChon() {
		return traLoiChon;
	}
	public void setTraLoiChon(String traLoiChon) {
		this.traLoiChon = traLoiChon;
	}
	public String getIdLoai() {
		return idLoai;
	}
	public void setIdLoai(String idLoai) {
		this.idLoai = idLoai;
	}
	
	

}
