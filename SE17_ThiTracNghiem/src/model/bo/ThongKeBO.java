package model.bo;

import java.util.List;

import model.bean.TKBaiThiBean;
import model.bean.TKBaiThiThanhTichBean;
import model.bean.TKChiTietLanThiBean;
import model.bean.TKThanhVienBean;
import model.dao.ThongKeDAO;

public class ThongKeBO {
	ThongKeDAO kq = new ThongKeDAO();

	public List<TKThanhVienBean> getListThongKeThanhVien() {
		return kq.getListThongKeThanhVien();
	}

	public List<TKBaiThiBean> getListThongKeBaiThi() {
		return kq.getListThongKeBaiThi();
	}

	public List<TKBaiThiThanhTichBean> getListThongKeBaiThiThanhTich(String idBaiThi) {
		return kq.getListThongKeBaiThiThanhTich(idBaiThi);
	}

	public List<TKBaiThiThanhTichBean> getListThanhTichUser(String idUser) {
		return kq.getListThanhTichUser(idUser);
	}

	public List<TKChiTietLanThiBean> getListThongKeChiTietLanThi(String idLanThi) {
		return kq.getListThongKeChiTietLanThi(idLanThi);
	}

	public List<TKBaiThiBean> getListThongKeBaiThi(String idUser) {
		return kq.getListThongKeBaiThi(idUser);
	}
	public TKThanhVienBean getThongKeThanhVien(String idUser){
		return kq.getThongKeThanhVien(idUser);
	}
	public List<TKThanhVienBean> getListThongKeThanhVien(int top) {
		return kq.getListThongKeThanhVien(top);
	}

	public List<TKBaiThiBean> getListThongKeBaiThi(int top) {
		return kq.getListThongKeBaiThi(top);
	}
}
