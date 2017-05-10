package model.bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.bean.BaiThiBean;
import model.bean.PhongThiBean;
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
	public void nhapDiem(String maKyThi, String maMonThi, int soPhach, float diemSo) {
		bt.nhapDiem(maKyThi, maMonThi, soPhach, diemSo);
		List<BaiThiBean> lst = bt.getListDiem(maKyThi, maMonThi);
		for (BaiThiBean baiThi : lst) {
			if(baiThi.getTrangThaiDuThi()==5)
				bt.updateDiemChinhThuc(maKyThi, maMonThi, baiThi.getMaThiSinh(), -1);
			if(baiThi.getTrangThaiDuThi()==4)
				bt.updateDiemChinhThuc(maKyThi, maMonThi, baiThi.getMaThiSinh(), 0);
			if(baiThi.getTrangThaiDuThi()==3){
				float diemChinhThuc = (float)50/100*baiThi.getDiemChamThi();
				bt.updateDiemChinhThuc(maKyThi, maMonThi, baiThi.getMaThiSinh(), (double)Math.round(diemChinhThuc*100)/100);
			}
			if(baiThi.getTrangThaiDuThi()==2){
				float diemChinhThuc = (float)75/100*baiThi.getDiemChamThi();
				bt.updateDiemChinhThuc(maKyThi, maMonThi, baiThi.getMaThiSinh(), (double)Math.round(diemChinhThuc*100)/100);
			}
			if(baiThi.getTrangThaiDuThi()==1){
				float diemChinhThuc = baiThi.getDiemChamThi();
				bt.updateDiemChinhThuc(maKyThi, maMonThi, baiThi.getMaThiSinh(), (double)Math.round(diemChinhThuc*100)/100);
			}	
		}
	}
	public List<BaiThiBean> getListTheoMon(String maKyThi, String maMonThi, String maPhongThi){
		return bt.getListTheoMon(maKyThi, maMonThi, maPhongThi);
	}
	public boolean updateDonTui(String maKyThi, String maMonThi, String maThiSinh, int tuiSo, int soPhach) {
		return bt.updateDonTui(maKyThi, maMonThi, maThiSinh, tuiSo, soPhach);
	}
	public void DonTuiPhach1(String maKyThi, String maMonThi, int coSoPhong, int coSoTui, int soLuotThucHien){
		PhongThiBO ptBO = new PhongThiBO();
		BaiThiBO btBO = new BaiThiBO();
		List<PhongThiBean> listPhongThi = ptBO.getListPhongThiTheoMaKyThi(maKyThi);
		int soPhach=1;
		for(int l = 1; l <= soLuotThucHien; l++){ //1
			List<BaiThiBean> listAll = new ArrayList<>();
			for(int i = (l-1)*coSoPhong; i < l*coSoPhong; i++){ //0
				List<BaiThiBean> listBaiThiTheoPhong = btBO.getListTheoMon(maKyThi, maMonThi, listPhongThi.get(i).getMaPhongThi());
				listAll.addAll(listBaiThiTheoPhong); //so sv phong 1: 20 sv
			}
			Collections.shuffle(listAll);
			int sizeTui=(int) Math.ceil(1.0*listAll.size()/coSoTui); //20/1 = 20
			for(int i=0;i<coSoTui;i++){ //0
				for(int j = i*sizeTui; j < sizeTui*(i+1); j++){ //0
					if(j >= listAll.size()) break;
					btBO.updateDonTui(maKyThi, maMonThi, listAll.get(j).getMaThiSinh(), i+1+coSoTui*(l-1), soPhach++);
					
				}
			}
		}
	}
	public void DonTuiPhach(String maKyThi, String maMonThi, int coSoPhong, int coSoTui, int soLuotThucHien){
		PhongThiBO ptBO = new PhongThiBO();
		BaiThiBO btBO = new BaiThiBO();
		List<PhongThiBean> listPhongThi = ptBO.getListPhongThiTheoMaKyThi(maKyThi);
		int soPhach=1;
		for(int l = 1; l <= soLuotThucHien; l++){ //1
			//List<BaiThiBean> listAll = new ArrayList<>();
			for(int i = (l-1)*coSoPhong; i < l*coSoPhong; i++){ //0
				List<BaiThiBean> listBaiThiTheoPhong = btBO.getListTheoMon(maKyThi, maMonThi, listPhongThi.get(i).getMaPhongThi());
				Collections.shuffle(listBaiThiTheoPhong);
				int sizeTui=(int) Math.ceil(1.0*listBaiThiTheoPhong.size()/coSoTui); //20/1 = 20
				for(int x=0;x<coSoTui;x++){ //0
					for(int j = x*sizeTui; j < sizeTui*(x+1); j++){ //0
						if(j >= listBaiThiTheoPhong.size()) break;
						btBO.updateDonTui(maKyThi, maMonThi, listBaiThiTheoPhong.get(j).getMaThiSinh(), x+1+coSoTui*(l-1), soPhach++);						
					}
				}
			}
//			Collections.shuffle(listAll);
//			int sizeTui=(int) Math.ceil(1.0*listAll.size()/coSoTui); //20/1 = 20
//			for(int i=0;i<coSoTui;i++){ //0
//				for(int j = i*sizeTui; j < sizeTui*(i+1); j++){ //0
//					if(j >= listAll.size()) break;
//					btBO.updateDonTui(maKyThi, maMonThi, listAll.get(j).getMaThiSinh(), i+1+coSoTui*(l-1), soPhach++);
//					
//				}
//			}
		}
	}
	public List<BaiThiBean> getListDonTui(String maKyThi, String maMonThi){
		return bt.getListDonTui(maKyThi, maMonThi);
	}
	public List<BaiThiBean> getListXuLy(String maKyThi, String maMonThi, String maPhongThi){
		return bt.getListXuLy(maKyThi, maMonThi, maPhongThi);
	}
	public boolean deleteAllScore(String maKyThi, String maMonThi, int tuiSo) {
		return bt.deleteAllScore(maKyThi, maMonThi, tuiSo);
	}
}