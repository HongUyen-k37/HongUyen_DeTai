package model.bean;

public class LanThiBean {
	private String idLanThi;
	private String idBaiThi;
	private String idUser;
	private int soCauTraLoiDung;
	private long thoiGianThi;
	private long thoiGianKetThuc;
	private boolean hoanTat;
	
	public String getIdLanThi() {
		return idLanThi;
	}
	public void setIdLanThi(String idLanThi) {
		this.idLanThi = idLanThi;
	}
	public String getIdBaiThi() {
		return idBaiThi;
	}
	public void setIdBaiThi(String idBaiThi) {
		this.idBaiThi = idBaiThi;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
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
	public long getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(long thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public LanThiBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LanThiBean(String idLanThi, String idBaiThi, String idUser, int soCauTraLoiDung, long thoiGianThi,
			long thoiGianKetThuc) {
		super();
		this.idLanThi = idLanThi;
		this.idBaiThi = idBaiThi;
		this.idUser = idUser;
		this.soCauTraLoiDung = soCauTraLoiDung;
		this.thoiGianThi = thoiGianThi;
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public boolean isHoanTat() {
		return hoanTat;
	}
	public void setHoanTat(boolean hoanTat) {
		this.hoanTat = hoanTat;
	}
	
		
}
