package form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import model.bean.CauHoiBean;
import model.bean.LoaiBaiThiBean;

public class NhapCauHoiActionForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<CauHoiBean> getListCauHoi() {
		return listCauHoi;
	}
	public void setListCauHoi(List<CauHoiBean> listCauHoi) {
		this.listCauHoi = listCauHoi;
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
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getSoCauHoi() {
		return soCauHoi;
	}
	public void setSoCauHoi(int soCauHoi) {
		this.soCauHoi = soCauHoi;
	}
	public List<String> getListCauHoiBaiThi() {
		return listCauHoiBaiThi;
	}
	public void setListCauHoiBaiThi(List<String> listCauHoiBaiThi) {
		this.listCauHoiBaiThi = listCauHoiBaiThi;
	}
	public String getIdCauHoi() {
		return idCauHoi;
	}
	public void setIdCauHoi(String idCauHoi) {
		this.idCauHoi = idCauHoi;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List<LoaiBaiThiBean> getLst() {
		return lst;
	}
	public void setLst(List<LoaiBaiThiBean> lst) {
		this.lst = lst;
	}
	public String getInputSearch() {
		return inputSearch;
	}
	public void setInputSearch(String inputSearch) {
		this.inputSearch = inputSearch;
	}
	private List<CauHoiBean> listCauHoi;
	private List<String> listCauHoiBaiThi;
	private String idBaiThi;
	private String idCauHoi;
	private String tenBaiThi;
	private String search;
	private String action;
	private int soCauHoi;
	private List<LoaiBaiThiBean> lst;
	private String inputSearch;
}
