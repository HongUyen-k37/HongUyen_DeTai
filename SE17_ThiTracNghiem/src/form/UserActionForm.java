package form;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.UserBean;

public class UserActionForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idUser;
	private String hoTen;
	private String diaChi;
	private String email;
	private String sdt;
	private String donVi;
	private String action;
	private String username;
	private String password;
	private int role;
	private boolean active;
	
	private String url;
	private String search;
	private int page=0;
	private int total=1;
	
	public int getSoBaiThi() {
		return soBaiThi;
	}
	public void setSoBaiThi(int soBaiThi) {
		this.soBaiThi = soBaiThi;
	}
	public int getTongCauHoi() {
		return tongCauHoi;
	}
	public void setTongCauHoi(int tongCauHoi) {
		this.tongCauHoi = tongCauHoi;
	}
	public int getTongCauDung() {
		return tongCauDung;
	}
	public void setTongCauDung(int tongCauDung) {
		this.tongCauDung = tongCauDung;
	}
	private int soBaiThi;
	private int tongCauHoi;
	private int tongCauDung;
	
	private List<UserBean> listUser;
	private UserBean user;

	private String capNhat;
	private String nangCap;
	
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<UserBean> getListUser() {
		return listUser;
	}
	public void setListUser(List<UserBean> listUser) {
		this.listUser = listUser;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDonVi() {
		return donVi;
	}
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCapNhat() {
		return capNhat;
	}
	public void setCapNhat(String capNhat) {
		this.capNhat = capNhat;
	}
	public String getNangCap() {
		return nangCap;
	}
	public void setNangCap(String nangCap) {
		this.nangCap = nangCap;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
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
