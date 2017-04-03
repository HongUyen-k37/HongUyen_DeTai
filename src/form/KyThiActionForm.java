package form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import model.bean.KyThiBean;

public class KyThiActionForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<KyThiBean> listKyThi;

	public List<KyThiBean> getListKyThi() {
		return listKyThi;
	}

	public void setListKyThi(List<KyThiBean> listKyThi) {
		this.listKyThi = listKyThi;
	}
}