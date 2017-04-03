package form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import model.bean.TKChiTietLanThiBean;

public class KetQuaThiActionForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	private String idLanThi;
	private String tenBaiThi;
	private List<TKChiTietLanThiBean> lst;
	private String idUser;
	private int tongCauHoiDung;
	private int soCauHoi;
	private String thoiGianBatDauThi;
	private String thoiGianThi;
	private int page=0;
	private int total=1;
	public List<TKChiTietLanThiBean> getLst() {
		return lst;
	}

	public void setLst(List<TKChiTietLanThiBean> lst) {
		this.lst = lst;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getIdLanThi() {
		return idLanThi;
	}
	public String getTenBaiThi() {
		return tenBaiThi;
	}
	public void setIdLanThi(String idLanThi) {
		this.idLanThi = idLanThi;
	}
	public void setTenBaiThi(String tenBaiThi) {
		this.tenBaiThi = tenBaiThi;
	}

	public int getTongCauHoiDung() {
		return tongCauHoiDung;
	}

	public void setTongCauHoiDung(int tongCauHoiDung) {
		this.tongCauHoiDung = tongCauHoiDung;
	}

	public int getSoCauHoi() {
		return soCauHoi;
	}

	public void setSoCauHoi(int soCauHoi) {
		this.soCauHoi = soCauHoi;
	}

	public String getThoiGianBatDauThi() {
		return thoiGianBatDauThi;
	}

	public void setThoiGianBatDauThi(String thoiGianBatDauThi) {
		this.thoiGianBatDauThi = thoiGianBatDauThi;
	}

	public String getThoiGianThi() {
		return thoiGianThi;
	}

	public void setThoiGianThi(String thoiGianThi) {
		this.thoiGianThi = thoiGianThi;
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
