package model.dao;

import model.bo.UserBO;


public class TestVinh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ThongKeBO thongKeBO = new ThongKeBO();
//		List<TKBaiThiBean> lst =  thongKeBO.getListThongKeBaiThi("U0001");
		UserBO user =  new UserBO();
		//user.getUser("U0002");
		System.out.println(user.getUser("U0002").getHoTen());
	}
}

