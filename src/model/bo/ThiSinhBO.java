package model.bo;

import java.util.ArrayList;
import java.util.List;

import common.Define;
import model.bean.DiemChuanBean;
import model.bean.KetQuaThiSinhBean;
import model.bean.PhongThiBean;
import model.bean.ThiSinhBean;
import model.dao.KyThiDAO;
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
	public void danhSoBaoDanh(String tiepDauNgu, int soBatDau, int soLuong, String maKyThi){
		ts.danhSoBaoDanh(tiepDauNgu, soBatDau, soLuong, maKyThi);
		KyThiDAO kt = new KyThiDAO();
		kt.updateSBD(maKyThi, tiepDauNgu, soBatDau, soLuong);
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
	public List<ThiSinhBean> searchThiSinh(String maKyThi, String key){
		return ts.searchThiSinh(maKyThi, key);
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
	public List<DiemChuanBean> kiemTraDiemChuan(String maKyThi, float diemLiet, float diemChuan, boolean check){
		List<DiemChuanBean> lst = new ArrayList<>();
		List<String> listKhuVuc = ts.getListKhuVuc();
		List<String> listDoiTuong = ts.getListDoiTuong();
		for(int i = 0; i < listKhuVuc.size(); i++){
			for(int j = 0; j < listDoiTuong.size(); j++){
				DiemChuanBean d = new DiemChuanBean(listKhuVuc.get(i)+" - "+listDoiTuong.get(j),
						diemChuan+Define.getDiemCongKhuVuc().get(listKhuVuc.get(i))+Define.getDiemCongDoiTuong().get(listDoiTuong.get(j)),
						ts.getSoThiSinhDat(maKyThi, listKhuVuc.get(i), listDoiTuong.get(j), diemChuan, diemLiet, check),
						ts.getTongSoThiSinh(maKyThi, listKhuVuc.get(i), listDoiTuong.get(j))-ts.getSoThiSinhDat(maKyThi, listKhuVuc.get(i), listDoiTuong.get(j), diemChuan, diemLiet, check),
						ts.getSoThiSinhBiDiemLiet(maKyThi, listKhuVuc.get(i), listDoiTuong.get(j), diemLiet, check),
						ts.getTongSoThiSinh(maKyThi, listKhuVuc.get(i), listDoiTuong.get(j)));
				lst.add(d);
			}
		}
		return lst;
	}
	public List<KetQuaThiSinhBean> getListKetQuaThiSinh(String maKyThi){
		return ts.getListKetQuaThiSinh(maKyThi);
	}
	public List<KetQuaThiSinhBean> getListThiSinhTrungTuyen(String maKyThi){
		return ts.getListThiSinhTrungTuyen(maKyThi);
	}
}
