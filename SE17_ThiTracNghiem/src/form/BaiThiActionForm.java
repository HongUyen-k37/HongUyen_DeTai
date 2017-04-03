package form;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.BaiThiBean;
import model.bean.LanThiBean;
import model.bean.LoaiBaiThiBean;
import model.bean.UserBean;

public class BaiThiActionForm extends ActionForm{

	private static final long serialVersionUID = 1L;
	private String idBaiThi;
	private String tenBaiThi;
	private int thoiGian;
	private int soCauHoi;
	private String moTa;
	private String idLoai;
	private String password;
	private String idUser;
	private UserBean user;
	private boolean active;
	private int soLuotLam;
	private String submit;
	private List<LanThiBean> lstU;
	private List<BaiThiBean> lst;
	private List<BaiThiBean> listQuanTrong;
	private List<BaiThiBean> listNoiBat;
	private List<LoaiBaiThiBean> listLoai;
	private String inputSearch;
	private String search;
	private String tenLoai;
	private String error="";
	private int page=0;
	private int total=1;
	public List<BaiThiBean> getLst() {
		return lst;
	}
	public void setLst(List<BaiThiBean> lst) {
		this.lst = lst;
	}
	public String getIdBaiThi() {
		return idBaiThi;
	}
	public void setIdBaiThi(String idBaiThi) {
		this.idBaiThi = idBaiThi;
	}
	public String getTenBaiThi() {
		return tenBaiThi;
	}
	public void setTenBaiThi(String tenBaiThi) {
		this.tenBaiThi = tenBaiThi;
	}
	public int getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(int thoiGian) {
		this.thoiGian = thoiGian;
	}
	public int getSoCauHoi() {
		return soCauHoi;
	}
	public void setSoCauHoi(int soCauHoi) {
		this.soCauHoi = soCauHoi;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getIdLoai() {
		return idLoai;
	}
	public void setIdLoai(String idLoai) {
		this.idLoai = idLoai;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public int getSoLuotLam() {
		return soLuotLam;
	}
	public void setSoLuotLam(int soLuotLam) {
		this.soLuotLam = soLuotLam;
	}
	public String getInputSearch() {
		return inputSearch;
	}
	public void setInputSearch(String inputSearch) {
		this.inputSearch = inputSearch;
	}
	public List<LoaiBaiThiBean> getListLoai() {
		return listLoai;
	}
	public void setListLoai(List<LoaiBaiThiBean> listLoai) {
		this.listLoai = listLoai;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}

	public List<BaiThiBean> getListQuanTrong() {
		return listQuanTrong;
	}
	public void setListQuanTrong(List<BaiThiBean> listQuanTrong) {
		this.listQuanTrong = listQuanTrong;
	}
	public List<BaiThiBean> getListNoiBat() {
		return listNoiBat;
	}
	public void setListNoiBat(List<BaiThiBean> listNoiBat) {
		this.listNoiBat = listNoiBat;
	}
	public List<LanThiBean> getLstU() {
		return lstU;
	}
	public void setLstU(List<LanThiBean> lstU) {
		this.lstU = lstU;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}


}
