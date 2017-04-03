package model.bean;

public class KetQuaThiBean {
	private String idLanThi;
	private String noiDung;
	private String cauTraLoi;
	private String dapAn;

	public KetQuaThiBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public KetQuaThiBean(String idLanThi, String noiDung, String cauTraLoi, String dapAn) {
		super();
		this.idLanThi = idLanThi;
		this.noiDung = noiDung;
		this.cauTraLoi = cauTraLoi;
		this.dapAn = dapAn;
	}



	public String getIdLanThi() {
		return idLanThi;
	}

	public void setIdLanThi(String idLanThi) {
		this.idLanThi = idLanThi;
	}

	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getCauTraLoi() {
		return cauTraLoi;
	}
	public void setCauTraLoi(String cauTraLoi) {
		this.cauTraLoi = cauTraLoi;
	}
	public String getDapAn() {
		return dapAn;
	}
	public void setDapAn(String dapAn) {
		this.dapAn = dapAn;
	}
	
}
