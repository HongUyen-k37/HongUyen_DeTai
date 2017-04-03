package model.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TKBaiThiThanhTichBean {
	private String idBaiThi;
	private String tenBaiThi;
	private String idUser;
	private String hoTen;
	private int soCauTraLoiDung;
	private long thoiGianThi;
	private long thoiGianLamBai;
	private String idLanThi;
	private String sThoiGianThi;
	private String sThoiGianLamBai;
	
	public TKBaiThiThanhTichBean(String idBaiThi, String tenBaiThi, String idUser, String hoTen, int soCauTraLoiDung,
			long thoiGianThi, long thoiGianLamBai, String idLanThi) {
		super();
		this.idBaiThi = idBaiThi;
		this.tenBaiThi = tenBaiThi;
		this.idUser = idUser;
		this.hoTen = hoTen;
		this.soCauTraLoiDung = soCauTraLoiDung;
		this.thoiGianThi = thoiGianThi;
		sThoiGianThi = new SimpleDateFormat("HH:mm dd/MM/yyyy").format(new Date(thoiGianThi));
		this.thoiGianLamBai = thoiGianLamBai;
		thoiGianLamBai/=1000;
		sThoiGianLamBai=thoiGianLamBai/3600+" giờ "+(thoiGianLamBai/60)%60+" phút "+thoiGianLamBai%60+" giây";
		this.idLanThi = idLanThi;
		
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
	public String getIdLanThi() {
		return idLanThi;
	}
	public void setIdLanThi(String idLanThi) {
		this.idLanThi = idLanThi;
	}

	public String getsThoiGianThi() {
		return sThoiGianThi;
	}

	public void setsThoiGianThi(String sThoiGianThi) {
		this.sThoiGianThi = sThoiGianThi;
	}

	public String getsThoiGianLamBai() {
		return sThoiGianLamBai;
	}

	public void setsThoiGianLamBai(String sThoiGianLamBai) {
		this.sThoiGianLamBai = sThoiGianLamBai;
	}
	

}
