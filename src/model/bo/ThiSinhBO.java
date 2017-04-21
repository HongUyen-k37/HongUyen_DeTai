package model.bo;

import java.util.ArrayList;
import java.util.List;

import model.bean.DiemChuanBean;
import model.bean.PhongThiBean;
import model.bean.ThiSinhBean;
import model.dao.PhongThiDAO;
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
	public List<ThiSinhBean> searchThiSinh(String key){
		return ts.searchThiSinh(key);	
	}
	public List<ThiSinhBean> getListThiSinhTheoPhongThi(String maPhongThi){
		return ts.getListThiSinhTheoPhongThi(maPhongThi);
	}
	public void phanPhongThi(String maKyThi){
		List<ThiSinhBean> listThiSinh = ts.getListThiSinh(maKyThi);
		PhongThiDAO pt = new PhongThiDAO();
		List<PhongThiBean> listPhongThi = pt.getListPhongThiTheoMaKyThi(maKyThi);
		int slot = 0;
		for(int i = 0; i < listPhongThi.size(); i++){
			slot += listPhongThi.get(i).getSoLuongThiSinh();
		}
		float avgRoom = 1.0f*listThiSinh.size()/slot;
		int current = 0;
		for(int i = 0; i < listPhongThi.size(); i++){
			for(int j = 0; j < Math.ceil(listPhongThi.get(i).getSoLuongThiSinh()*avgRoom); j++){
				if(listThiSinh.size()<=j+current) return;
				ts.update(listThiSinh.get(j+current).getMaThiSinh(), listPhongThi.get(i).getMaPhongThi());	
			}
			current += Math.ceil(listPhongThi.get(i).getSoLuongThiSinh()*avgRoom);
		}
	}
	public List<DiemChuanBean> kiemTraDiemChuan(float diemLiet, float diemChuan, int check){
		List<DiemChuanBean> lst = new ArrayList<>();
		List<String> listKhuVuc = ts.getListKhuVuc();
		List<String> listDoiTuong = ts.getListDoiTuong();
		for(int i = 0; i < listKhuVuc.size(); i++){
			for(int j = 0; j < listDoiTuong.size(); j++){
				DiemChuanBean d = new DiemChuanBean(listKhuVuc.get(i)+" - "+listDoiTuong.get(j), 1.0f*0, 0, 0, 0);
				lst.add(d);
			}
		}
		for(int i = 0; i < lst.size(); i++){
			switch (lst.get(i).getTen()) {
			case "Khu vực 3 - KƯT":
				lst.get(i).setDiem(diemChuan);
				break;

			default:
				break;
			}
		}
		return lst;
	}
}
