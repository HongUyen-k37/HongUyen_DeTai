package model.bo;

import java.util.List;

import model.bean.KyThiBean;
import model.dao.KyThiDAO;

public class KyThiBO {
	KyThiDAO kt = new KyThiDAO();
	public List<KyThiBean> getListKyThi(){
		return kt.getListKyThi();
	}
	public KyThiBean getKyThi(String MaKyThi) {
		return kt.getKyThi(MaKyThi);
	}
	public boolean delete(String maKyThi) {
		return kt.delete(maKyThi);
	}
	public boolean update(KyThiBean kyThi) {
		return kt.update(kyThi);	
	}
	public boolean insert(KyThiBean kyThi) {
		return kt.insert(kyThi);	
	}
	public List<KyThiBean> searchKyThi(String key){
		return kt.searchKyThi(key);
	}
}
