
package model.bean;
//Uyên, 9:30 am
public class LanThi_CauHoiBean {
	private String idLanThi;
	private String idCauHoi;
	private String cauTraLoi;
	private String traLoiMot;
	private String traLoiHai;
	private String traLoiBa;
	private String traLoiBon;
	private String noiDung;
	private String dapAn;
	private int viTri;
	public LanThi_CauHoiBean(String idLanThi, String idCauHoi, String cauTraLoi, String traLoiMot, String traLoiHai,
			String traLoiBa, String traLoiBon, String noiDung, String dapAn, int viTri) {
		super();
		this.idLanThi = idLanThi;
		this.idCauHoi = idCauHoi;
		this.cauTraLoi = cauTraLoi;
		this.traLoiMot = traLoiMot;
		this.traLoiHai = traLoiHai;
		this.traLoiBa = traLoiBa;
		this.traLoiBon = traLoiBon;
		this.noiDung = noiDung;
		this.dapAn = dapAn;
		this.viTri = viTri;
	}
	public LanThi_CauHoiBean() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getTraLoiBon() {
		return traLoiBon;
	}

	public void setTraLoiBon(String traLoiBon) {
		this.traLoiBon = traLoiBon;
	}
	public int getViTri() {
		return viTri;
	}


	public void setViTri(int viTri) {
		this.viTri = viTri;
	}


	public String getIdLanThi() {
		return idLanThi;
	}


	public void setIdLanThi(String idLanThi) {
		this.idLanThi = idLanThi;
	}


	public String getIdCauHoi() {
		return idCauHoi;
	}


	public void setIdCauHoi(String idCauHoi) {
		this.idCauHoi = idCauHoi;
	}


	public String getCauTraLoi() {
		return cauTraLoi;
	}


	public void setCauTraLoi(String cauTraLoi) {
		this.cauTraLoi = cauTraLoi;
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


	
}
