package model.bo;

import java.util.List;

import model.bean.BaiThiBean;
import model.dao.BaiThiDAO;

public class BaiThiBO {
	BaiThiDAO bt=new BaiThiDAO();
	public List<BaiThiBean> getList(String maKyThi, String maPhongThi, String maMonThi){
		return bt.getList(maKyThi, maPhongThi, maMonThi);
	}
}
