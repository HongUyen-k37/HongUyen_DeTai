package form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import model.bean.BaiThiBean;
import model.bean.CauHoiBean;
import model.bean.UserBean;

public class LanThiActionForm extends ActionForm{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private String idLanThi;
	private String idBaiThi;
	private String idUser;
	private int soCauTraLoiDung;
	private long thoiGianThi;
	private long thoiGianKetThuc;
	private List<CauHoiBean> listCauHoi;
	private BaiThiBean baiThi;
	private UserBean user;
	private long timeLeft;
	private boolean hoanTat;
	
	public String getIdLanThi(){
		return idLanThi;
	}
	public void setIdLanThi(String idLanThi) {
		this.idLanThi = idLanThi;
	}
	public String getIdBaiThi() {
		return idBaiThi;
	}
	public void setIdBaiThi(String idBaiThi) {
		this.idBaiThi = idBaiThi;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public int getSoCauTraLoiDung() {
		return soCauTraLoiDung;
	}
	public void setSoCauTraLoiDung(int soCauTraLoiDung) {
		this.soCauTraLoiDung = soCauTraLoiDung;
	}
	public long getThoiGianThi() {
		return thoiGianThi;
	}
	public void setThoiGianThi(long thoiGianThi) {
		this.thoiGianThi = thoiGianThi;
	}
	public long getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(long thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public List<CauHoiBean> getListCauHoi() {
		return listCauHoi;
	}
	public void setListCauHoi(List<CauHoiBean> listCauHoi) {
		this.listCauHoi = listCauHoi;
	}
	public BaiThiBean getBaiThi() {
		return baiThi;
	}
	public void setBaiThi(BaiThiBean baiThi) {
		this.baiThi = baiThi;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public long getTimeLeft() {
		return timeLeft;
	}
	public void setTimeLeft(long timeLeft) {
		this.timeLeft = timeLeft;
	}
	public boolean isHoanTat() {
		return hoanTat;
	}
	public void setHoanTat(boolean hoanTat) {
		this.hoanTat = hoanTat;
	}
}
