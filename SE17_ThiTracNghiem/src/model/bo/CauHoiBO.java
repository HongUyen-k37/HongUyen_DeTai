package model.bo;

import java.util.List;

import model.bean.CauHoiBean;
import model.dao.CauHoiDao;

public class CauHoiBO {
	CauHoiDao ch = new CauHoiDao();
	public boolean insert(CauHoiBean cauHoi){
		return ch.insert(cauHoi);
	}
	public boolean update(CauHoiBean cauHoi){
		return ch.update(cauHoi);
	}
	public boolean delete(String idCauHoi) {
		return ch.delete(idCauHoi);
	}
	public List<CauHoiBean> getListID(String idBaiThi){
		return ch.getListID(idBaiThi);
	}
	public List<CauHoiBean> getListViTriThi(String idLanThi){
		return ch.getListViTriThi(idLanThi);
	}
	public List<CauHoiBean> getListCauHoiUser(String idUser){
		return ch.getListCauHoiUser(idUser);
	}
	public CauHoiBean getCauHoi(String idCauHoi){
		return ch.getCauHoi(idCauHoi);
	}
	public List<CauHoiBean> searchCauHoi(String key,String idUser,String idLoai){
		return ch.searchCauHoi(key,idUser,idLoai);
	}
	public List<CauHoiBean> searhCauHoiAll(String key,String idUser){
		return ch.searchCauHoiAll(key, idUser);
	}
	public List<String> getListStringID(String idBaiThi) {
		// TODO Auto-generated method stub
		return ch.getListStringID(idBaiThi);
	}
}
