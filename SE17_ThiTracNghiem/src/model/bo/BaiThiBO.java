package model.bo;

import java.util.List;

import model.bean.BaiThiBean;
import model.bean.LoaiBaiThiBean;
import model.dao.BaiThiDao;

public class BaiThiBO {
	BaiThiDao bt = new BaiThiDao();
	public boolean insert(BaiThiBean baiThi){
		return bt.insert(baiThi);
	}
	public boolean update(BaiThiBean baiThi){
		return bt.update(baiThi);
	}
	public boolean delete(String idBaiThi){
		return bt.delete(idBaiThi);
	}
	public BaiThiBean getBaiThi(String idBaiThi) {
		// TODO Auto-generated method stub
		return bt.getBaiThi(idBaiThi);
	}
	public int getLuotLam(String idBaiThi){
		return bt.getLuotLam(idBaiThi);
	}
	public List<BaiThiBean> getListBaiThi(String idUser){
		return bt.getListBaiThi(idUser);
	}
	public List<BaiThiBean> getListBaiThi(){
		return bt.getListBaiThi();
	}
	public List<LoaiBaiThiBean> getListLoaiBT(){
		return bt.getListLoaiBT();
	}
	public List<BaiThiBean> searchBaiThi(String tenBaiThi,String idLoai,String idUser){
		return bt.searchBaiThi(tenBaiThi, idLoai, idUser);
	}
	public List<BaiThiBean> searchBaiThiTatCa(String tenBaiThi,String idUser){
		return bt.searchBaiThiTatCa(tenBaiThi, idUser);
	}
	public List<BaiThiBean> searchBaiThiALL(String tenBaiThi){
		return bt.searchBaiThiALL(tenBaiThi);
	}
	public List<BaiThiBean> getListTheoDanhMuc(String idLoai){
		return bt.getListTheoDanhMuc(idLoai);
	}
}
