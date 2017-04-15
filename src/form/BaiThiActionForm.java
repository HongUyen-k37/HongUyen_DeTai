package form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import model.bean.KyThiBean;
import model.bean.PhongThiBean;
import model.bean.ThiSinhBean;

public class BaiThiActionForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maKyThi;
	private List<KyThiBean> listKyThi;
	private KyThiBean kyThi;
	private String xuLyThi;
	private String save;
	private List<PhongThiBean> listPhongThi;
	private List<ThiSinhBean> listThiSinh;
	private String maPhongThi;
	public String getMaPhongThi() {
		return maPhongThi;
	}
	public void setMaPhongThi(String maPhongThi) {
		this.maPhongThi = maPhongThi;
	}
	public List<ThiSinhBean> getListThiSinh() {
		return listThiSinh;
	}
	public void setListThiSinh(List<ThiSinhBean> listThiSinh) {
		this.listThiSinh = listThiSinh;
	}
	public List<PhongThiBean> getListPhongThi() {
		return listPhongThi;
	}
	public void setListPhongThi(List<PhongThiBean> listPhongThi) {
		this.listPhongThi = listPhongThi;
	}
	public String getMaKyThi() {
		return maKyThi;
	}
	public void setMaKyThi(String maKyThi) {
		this.maKyThi = maKyThi;
	}
	public List<KyThiBean> getListKyThi() {
		return listKyThi;
	}
	public void setListKyThi(List<KyThiBean> listKyThi) {
		this.listKyThi = listKyThi;
	}
	public KyThiBean getKyThi() {
		return kyThi;
	}
	public void setKyThi(KyThiBean kyThi) {
		this.kyThi = kyThi;
	}
	public String getXuLyThi() {
		return xuLyThi;
	}
	public void setXuLyThi(String xuLyThi) {
		this.xuLyThi = xuLyThi;
	}
	public String getSave() {
		return save;
	}
	public void setSave(String save) {
		this.save = save;
	}
}
