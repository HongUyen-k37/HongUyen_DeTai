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
	public boolean insert(String maKyThi, MonThiBean monThi){
		return mt.insert(maKyThi, monThi);
	}
	public boolean update(MonThiBean monThi) {
		return mt.update(monThi);
	}
}
