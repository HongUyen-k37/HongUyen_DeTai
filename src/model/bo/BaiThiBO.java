package model.bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.bean.BaiThiBean;
import model.bean.PhongThiBean;
import model.dao.BaiThiDAO;

public class BaiThiBO {
	BaiThiDAO bt=new BaiThiDAO();
	public List<BaiThiBean> getList(String maKyThi, String maMonThi, String maThiSinh){
		return bt.getList(maKyThi, maMonThi, maThiSinh);
	}
	public boolean insert(BaiThiBean baiThi) {
		return bt.insert(baiThi);
	}
	public boolean update(String maKyThi, String maMonThi, String maThiSinh, int trangThaiDuThi) {
		return bt.update(maKyThi, maMonThi, maThiSinh, trangThaiDuThi);
	}
	public List<Integer> getListTui(String maKyThi){
		return bt.getListTui(maKyThi);
	}
	public List<BaiThiBean> getListTheoTui(String maKyThi, String maMonThi, int tuiSo){
		return bt.getListTheoTui(maKyThi, maMonThi, tuiSo);
	}
	public boolean nhapDiem(String maKyThi, String maMonThi, int soPhach, float diemSo) {
		return bt.nhapDiem(maKyThi, maMonThi, soPhach, diemSo);
	}
	public List<BaiThiBean> getListTheoMon(String maKyThi, String maMonThi, String maPhongThi){
		return bt.getListTheoMon(maKyThi, maMonThi, maPhongThi);
	}
	public boolean updateDonTui(String maKyThi, String maMonThi, String maThiSinh, int tuiSo, int soPhach) {
		return bt.updateDonTui(maKyThi, maMonThi, maThiSinh, tuiSo, soPhach);
	}
	public void DonTuiPhach(String maKyThi, String maMonThi, int coSoPhong, int coSoTui, int luot, int soLuotThucHien){
		PhongThiBO ptBO = new PhongThiBO();
		BaiThiBO btBO = new BaiThiBO();
		List<PhongThiBean> listPhongThi = ptBO.getListPhongThiTheoMaKyThi(maKyThi);
		List<BaiThiBean> listAll = new ArrayList<>();
		for(int i = (luot-1)*coSoPhong; i < luot*coSoPhong; i++){
			List<BaiThiBean> listBaiThiTheoPhong = btBO.getListTheoMon(maKyThi, maMonThi, listPhongThi.get(i).getMaPhongThi());
			listAll.addAll(listBaiThiTheoPhong);
		}
		Collections.shuffle(listAll);
		int sizeTui=(int) Math.ceil(1.0*listAll.size()/coSoTui);
		for(int i=0;i<coSoTui;i++){
			for(int j = i*sizeTui; j < sizeTui*(i+1); j++){
				btBO.updateDonTui(maKyThi, maMonThi, listAll.get(j).getMaThiSinh(), i+1, j+1);
				if(j > listAll.size()) break;
			}
		}
	}
	public List<BaiThiBean> getListDonTui(String maKyThi){
		return bt.getListDonTui(maKyThi);
	}
}