package model.dao;

import java.util.List;

import model.bean.KetQuaThiSinhBean;

public class testDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThiSinhDAO ts=new ThiSinhDAO();
		//ts.danhSoBaoDanh("KH", 4, 3, "KT0001");
		List<KetQuaThiSinhBean> lst=ts.getListKetQuaThiSinh("KT0001");
		for (KetQuaThiSinhBean kq : lst) {
			System.out.println(kq.getMaThiSinh()+" "+kq.getHoDem()+" "+kq.getTen()+" "+kq.getKhuVuc()+" "+kq.getDoiTuong()+" "+kq.getDiemUuTien()+" "+(kq.getDiemMon1()+kq.getDiemMon2()+kq.getDiemMon3()));
		}
	}
}
