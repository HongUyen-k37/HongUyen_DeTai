package model.bo;

import java.util.List;

import model.bean.CauHoiBean;
import model.dao.BaiThi_CauHoiDao;

public class BaiThi_CauHoiBO {
	BaiThi_CauHoiDao bc = new BaiThi_CauHoiDao();
	public void insertQuestList(List<CauHoiBean> lstCauHoi,String idBaiThi){
		for (CauHoiBean ch : lstCauHoi) {
			bc.insertCH(ch, idBaiThi);
		}
	}
	public boolean insert(String idBaiThi,String idCauHoi){
		return bc.insert(idBaiThi, idCauHoi);
	}
	public boolean delete(String idBaiThi,String idCauHoi){
		return bc.delete(idBaiThi, idCauHoi);
	}
}
