package model.bo;

import java.util.List;

import model.bean.MonThiBean;
import model.dao.MonThiDAO;

public class MonThiBO {
	MonThiDAO mt = new MonThiDAO();
	public List<MonThiBean> getListMonThi(String maKyThi){
		return mt.getListMonThi(maKyThi);
	}
	public MonThiBean getMonThi(String maMonThi){	
		return mt.getMonThi(maMonThi);
	}
}
