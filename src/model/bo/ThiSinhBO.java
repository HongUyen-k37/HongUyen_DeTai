package model.bo;

import java.util.List;

import model.bean.ThiSinhBean;
import model.dao.ThiSinhDAO;

public class ThiSinhBO {
	ThiSinhDAO ts = new ThiSinhDAO();
	public List<ThiSinhBean> getListThiSinh(String maKyThi){
		return ts.getListThiSinh(maKyThi);
	}
	public ThiSinhBean getThiSinh(String maThiSinh) {
		return ts.getThiSinh(maThiSinh);
	}
	public boolean danhSoBaoDanh(String tiepDauNgu, int soBatDau, int soLuong, String maKyThi){
		return ts.danhSoBaoDanh(tiepDauNgu, soBatDau, soLuong, maKyThi);
	}
	public boolean insert(ThiSinhBean thiSinh) {
		return ts.insert(thiSinh);
	}
	public boolean update(ThiSinhBean thiSinh) {
		return ts.update(thiSinh);
	}
	public boolean delete(String maThiSinh) {
		return ts.delete(maThiSinh);
		
	}
	public List<ThiSinhBean> searchThiSinh(String tenThiSinh, String maThiSinh){
		return ts.searchThiSinh(tenThiSinh, maThiSinh);
		
	}
}
