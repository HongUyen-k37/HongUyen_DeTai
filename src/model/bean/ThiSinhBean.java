package model.bean;

public class ThiSinhBean {
	private String maThiSinh;
	private String maKyThi;
	private String maPhongThi;
	private String hoDem;
	private String ten;
	private String ngaySinh;
	private String noiSinh;
	private String khuVuc;
	private String doiTuong;
	private String dienThoai;
	private String email;
	private String diaChi;
	private String soBaoDanh;
	private float diemChinhThuc;
	public String getMaKyThi() {
		return maKyThi;
	}
	public void setMaKyThi(String maKyThi) {
		this.maKyThi = maKyThi;
	}
	public String getMaPhongThi() {
		return maPhongThi;
	}
	public void setMaPhongThi(String maPhongThi) {
		this.maPhongThi = maPhongThi;
	}
	public String getHoDem() {
		return hoDem;
	}
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getNoiSinh() {
		return noiSinh;
	}
	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}
	public String getKhuVuc() {
		return khuVuc;
	}
	public void setKhuVuc(String khuVuc) {
		this.khuVuc = khuVuc;
	}
	public String getDoiTuong() {
		return doiTuong;
	}
	public void setDoiTuong(String doiTuong) {
		this.doiTuong = doiTuong;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoBaoDanh() {
		return soBaoDanh;
	}
	public void setSoBaoDanh(String soBaoDanh) {
		this.soBaoDanh = soBaoDanh;
	}
	public ThiSinhBean(String maThiSinh, String maKyThi, String maPhongThi, String hoDem, String ten, String ngaySinh,
			String noiSinh, String khuVuc, String doiTuong, String dienThoai, String email, String diaChi,
			String soBaoDanh) {
		super();
		this.maThiSinh = maThiSinh;
		this.maKyThi = maKyThi;
		this.maPhongThi = maPhongThi;
		this.hoDem = hoDem;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.noiSinh = noiSinh;
		this.khuVuc = khuVuc;
		this.doiTuong = doiTuong;
		this.dienThoai = dienThoai;
		this.email = email;
		this.diaChi = diaChi;
		this.soBaoDanh = soBaoDanh;
	}
	public ThiSinhBean() {
		super();
	}
	public String getMaThiSinh() {
		return maThiSinh;
	}
	public void setMaThiSinh(String maThiSinh) {
		this.maThiSinh = maThiSinh;
	}
	public float getDiemChinhThuc() {
		return diemChinhThuc;
	}
	public void setDiemChinhThuc(float diemChinhThuc) {
		this.diemChinhThuc = diemChinhThuc;
	}
}
