package model.bean;

public class BaiThi_ThanhTichViewBean {
	private String idBaiThi;
	private String tenBaiThi;
	private String idUser;
	private String hoTen;
	private int soCauTraLoiDung;
	private long thoiGianThi;
	private long thoiGianLamBai;
		
	public BaiThi_ThanhTichViewBean(String idBaiThi, String tenBaiThi, String idUser, String hoTen,
			int soCauTraLoiDung, long thoiGianThi, long thoiGianLamBai) {
		super();
		this.idBaiThi = idBaiThi;
		this.tenBaiThi = tenBaiThi;
		this.idUser = idUser;
		this.hoTen = hoTen;
		this.soCauTraLoiDung = soCauTraLoiDung;
		this.thoiGianThi = thoiGianThi;
		this.thoiGianLamBai = thoiGianLamBai;
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
	public int getSoCauTraLoiDung() {
		return soCauTraLoiDung;
	}
	public void setSoCauTraLoiDung(int soCauTraLoiDung) {
		this.soCauTraLoiDung = soCauTraLoiDung;
	}
	public long getThoiGianThi() {
		return thoiGianThi;
	}
	public void setThoiGianThi(long thoiGianThi) {
		this.thoiGianThi = thoiGianThi;
	}
	public long getThoiGianLamBai() {
		return thoiGianLamBai;
	}
	public void setThoiGianLamBai(long thoiGianLamBai) {
		this.thoiGianLamBai = thoiGianLamBai;
	}

	
}
