package form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import model.bean.ThiSinhBean;

public class ThiSinhActionForm extends ActionForm{
	private long maKyThi;
	private List<ThiSinhBean> listThiSinh;

	public long getMaKyThi() {
		return maKyThi;
	}

	public void setMaKyThi(long maKyThi) {
		this.maKyThi = maKyThi;
	}

	public List<ThiSinhBean> getListThiSinh() {
		return listThiSinh;
	}

	public void setListThiSinh(List<ThiSinhBean> listThiSinh) {
		this.listThiSinh = listThiSinh;
	}
}
