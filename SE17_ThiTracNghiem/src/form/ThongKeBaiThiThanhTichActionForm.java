package form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import model.bean.TKBaiThiThanhTichBean;

public class ThongKeBaiThiThanhTichActionForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idBaiThi;
	private String tenBaiThi;
	private String idUser;
	private String hoTen;
	private int soCauTraLoiDung;
	private long thoiGianThi;
	private long thoiGianLamBai;
	private String idLanThi;
	private int page=0;
	private int total=1;
	private List<TKBaiThiThanhTichBean> listBaiThiThanhTich;

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

	public List<TKBaiThiThanhTichBean> getListBaiThiThanhTich() {
		return listBaiThiThanhTich;
	}

	public void setListBaiThiThanhTich(List<TKBaiThiThanhTichBean> listBaiThiThanhTich) {
		this.listBaiThiThanhTich = listBaiThiThanhTich;
	}

	public String getIdLanThi() {
		return idLanThi;
	}

	public void setIdLanThi(String idLanThi) {
		this.idLanThi = idLanThi;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
