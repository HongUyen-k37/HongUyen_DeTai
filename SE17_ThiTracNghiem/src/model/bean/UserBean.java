package model.bean;

public class UserBean {
	
	private String idUser;
	private String hoTen;
	private String diaChi;
	private String email;
	private String sdt;
	private String donVi;
	private String username;
	private String password;
	private int role;
	private boolean active;
	
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
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
	
	public UserBean(String idUser, String hoTen, String diaChi, String email, String sdt, String donVi,
			String username, String password, int role, boolean active) {
		super();
		this.idUser = idUser;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.email = email;
		this.sdt = sdt;
		this.donVi = donVi;
		this.username = username;
		this.password = password;
		this.role = role;
		this.active = active;
	}
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
