package model.dao;

import java.util.List;

import model.bean.TKThanhVienBean;

//public class TestDao {
//	
//	public static void main(String[] agrs){
//		KetQuaThiDao user=new KetQuaThiDao();
//		List<KetQuaThiBean> kq = user.getList();
//		//Hien thi danh sach	
//		for (KetQuaThiBean ketQuaThiBean : kq) {
//			System.out.println(ketQuaThiBean.getNoiDung());
//		}
//		
//		
//		//System.out.println(user.checkLogin("admin", "admin"));
//	}	
////	public static void main(String[] args) throws Exception {
////		UserDAO user = new UserDAO();
////		//finding user
////		boolean lst = user.updatePassword("U00071");
////		System.out.println(lst);		
////	}
//}


public class TestDao {
	
	public static void main(String[] agrs){
		ThongKeDAO user=new ThongKeDAO();
		//Hien thi danh sach
		List<TKThanhVienBean> kq = user.getListThongKeThanhVien();
//		System.out.println(kq.size());
		for (TKThanhVienBean tkThanhVienBean : kq) {
			System.out.println(tkThanhVienBean.getHoTen());
		}
		
		//System.out.println(user.checkLogin("admin", "admin"));
	}
	
//	public static void main(String[] args) throws Exception {
//		UserDAO user = new UserDAO();
//		//finding user
//		boolean lst = user.updatePassword("U00071");
//		System.out.println(lst);		
//	}
}
