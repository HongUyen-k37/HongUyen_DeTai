package form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import model.bean.KyThiBean;

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
