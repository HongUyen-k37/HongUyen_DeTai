package model.bo;

import java.util.List;

import model.bean.BaiThiBean;
import model.bean.ThongKeBean;
import model.dao.ThongKeDAO;

public class ThongKeBO {
	ThongKeDAO tk =new ThongKeDAO();
	public List<ThongKeBean> tkBangDiemTheoMon(String maKyThi, String maMonThi){
		return tk.tkBangDiemTheoMon(maKyThi, maMonThi);
	}
	public List<BaiThiBean> tkBienBanChamThi(String maKyThi, String maMonThi){
		return tk.tkBienBanChamThi(maKyThi, maMonThi);
	}
	public List<BaiThiBean> tkBienBanTongHopChamThi(String maKyThi, String maMonThi, int tuiSo){
		return tk.tkBienBanTongHopChamThi(maKyThi, maMonThi, tuiSo);
	}
}
