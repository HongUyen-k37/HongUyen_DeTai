package model.bo;

import java.util.List;

import model.bean.PhongThiBean;
import model.dao.PhongThiDAO;

public class PhongThiBO {
	PhongThiDAO pt = new PhongThiDAO();
	public List<PhongThiBean> getListPhongThi(){
		return pt.getListPhongThi();
	}
	public List<PhongThiBean> getListPhongThi(String maPhongThi){
		return pt.getListPhongThi(maPhongThi);
	}
	public PhongThiBean getPhongThi(String maPhongThi) {
		return pt.getPhongThi(maPhongThi);
	}
	public boolean insert(PhongThiBean phongThi) {
		return pt.insert(phongThi);
	}
	public boolean update(PhongThiBean phongThi) {
		return pt.update(phongThi);
	}
	public List<PhongThiBean> getListPhongThiTheoMaKyThi(String maKyThi){
		return pt.getListPhongThiTheoMaKyThi(maKyThi);
	}
}
