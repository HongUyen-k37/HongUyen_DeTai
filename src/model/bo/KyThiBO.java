package model.bo;

import java.util.List;

import model.bean.KyThiBean;
import model.dao.KyThiDAO;

public class KyThiBO {
	KyThiDAO kt = new KyThiDAO();
	public List<KyThiBean> getListKyThi(){
		return kt.getListKyThi();
	}
}
