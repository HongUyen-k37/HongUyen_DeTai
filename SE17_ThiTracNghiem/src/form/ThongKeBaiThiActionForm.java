package form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import model.bean.TKBaiThiBean;

public class ThongKeBaiThiActionForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idUser;
	private String idBaiThi;
	private String TenBaiThi;
	private int soCauHoi;
	private int soLuotLam;
	private double tiLeLamDuoc;
	private List<TKBaiThiBean> listTKBaiThi;
	private int page=0;
	private int total=1;
	public String getIdBaiThi() {
		return idBaiThi;
	}
	public void setIdBaiThi(String idBaiThi) {
		this.idBaiThi = idBaiThi;
	}
	public String getTenBaiThi() {
		return TenBaiThi;
	}
	public void setTenBaiThi(String tenBaiThi) {
		TenBaiThi = tenBaiThi;
	}
	public int getSoCauHoi() {
		return soCauHoi;
	}
	public void setSoCauHoi(int soCauHoi) {
		this.soCauHoi = soCauHoi;
	}
	public int getSoLuotLam() {
		return soLuotLam;
	}
	public void setSoLuotLam(int soLuotLam) {
		this.soLuotLam = soLuotLam;
	}
	public double getTiLeLamDuoc() {
		return tiLeLamDuoc;
	}
	public void setTiLeLamDuoc(double tiLeLamDuoc) {
		this.tiLeLamDuoc = tiLeLamDuoc;
	}
	public List<TKBaiThiBean> getListTKBaiThi() {
		return listTKBaiThi;
	}
	public void setListTKBaiThi(List<TKBaiThiBean> listTKBaiThi) {
		this.listTKBaiThi = listTKBaiThi;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
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
