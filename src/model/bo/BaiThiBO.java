package model.bo;

import java.util.List;

import model.bean.BaiThiBean;
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
	public List<BaiThiBean> getListTheoMon(String maKyThi, String maMonThi){
		return bt.getListTheoMon(maKyThi, maMonThi);
	}
}
