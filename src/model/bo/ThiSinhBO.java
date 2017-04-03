package model.bo;

import java.util.List;

import model.bean.ThiSinhBean;
import model.dao.ThiSinhDAO;

public class ThiSinhBO {
	ThiSinhDAO ts = new ThiSinhDAO();
	public List<ThiSinhBean> getListThiSinh(long maKyThi){
		return ts.getListThiSinh(maKyThi);
	}
	public ThiSinhBean getThiSinh(String maThiSinh) {
		return ts.getThiSinh(maThiSinh);
	}
	public boolean danhSoBaoDanh(String tiepDauNgu, int soBatDau, int soLuong, long maKyThi){
		return ts.danhSoBaoDanh(tiepDauNgu, soBatDau, soLuong, maKyThi);
	}
}