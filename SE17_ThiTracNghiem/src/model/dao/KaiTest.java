package model.dao;

import java.util.List;

import model.bean.BaiThiBean;
import model.bo.BaiThiBO;

public class KaiTest {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
	BaiThiBO bt = new BaiThiBO();
	List<BaiThiBean> bt1 = bt.searchBaiThiALL("dep");
		//List<TKThanhVienBean> lst = thongKeBO.getListThongKeThanhVien();
	System.out.println(bt1.size());
	}
}
