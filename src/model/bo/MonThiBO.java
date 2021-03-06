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
	public void insert(String maKyThi, List<MonThiBean> listMonThi){
		for (MonThiBean monThi : listMonThi) {
			mt.insert(maKyThi, monThi);
		}
	}
	public boolean update(String maKyThi, MonThiBean monThi) {
		return mt.update(maKyThi, monThi);
	}
	public boolean updateDonTui(String maMonThi, int coSoPhongThi, int coSoTui, int soLuot){
		return mt.updateDonTui(maMonThi, coSoPhongThi, coSoTui, soLuot);
	}
	public boolean updateTrangThai(String maMonThi, int trangThai){
		return mt.updateTrangThai(maMonThi, trangThai);
	}
}
