package model.bean;

public class KetQuaThiSinhBean {
	private String maKyThi;
	private String maThiSinh;
	private String soBaoDanh;
	private String hoDem;
	private String khuVuc;
	private String ten;
	private String ngaySinh;
	private String doiTuong;
	private float diemUuTien;
	private float diemMon1;
	private float diemMon2;
	private float diemMon3;
	private String ghiChu;
	private float diemChuan;
	private float diemLiet;
	private boolean nhoHonDiemLiet;
	
	public KetQuaThiSinhBean(String maKyThi, String maThiSinh, String soBaoDanh, String hoDem, String khuVuc,
			String ten, String ngaySinh, String doiTuong, float diemChuan, float diemLiet, boolean nhoHonDiemLiet) {
		super();
		this.maKyThi = maKyThi;
		this.maThiSinh = maThiSinh;
		this.soBaoDanh = soBaoDanh;
		this.hoDem = hoDem;
		this.khuVuc = khuVuc;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.doiTuong = doiTuong;
		this.diemChuan = diemChuan;
		this.diemLiet = diemLiet;
		this.nhoHonDiemLiet = nhoHonDiemLiet;
	}
	public float getDiemChuan() {
		return diemChuan;
	}
	public void setDiemChuan(float diemChuan) {
		this.diemChuan = diemChuan;
	}
	public float getDiemLiet() {
		return diemLiet;
	}
	public void setDiemLiet(float diemLiet) {
		this.diemLiet = diemLiet;
	}
	public boolean isNhoHonDiemLiet() {
		return nhoHonDiemLiet;
	}
	public void setNhoHonDiemLiet(boolean nhoHonDiemLiet) {
		this.nhoHonDiemLiet = nhoHonDiemLiet;
	}
	public KetQuaThiSinhBean(String maKyThi, String maThiSinh, String soBaoDanh, String hoDem, String khuVuc,
			String ten, String ngaySinh, String doiTuong) {
		super();
		this.maKyThi = maKyThi;
		this.maThiSinh = maThiSinh;
		this.soBaoDanh = soBaoDanh;
		this.hoDem = hoDem;
		this.khuVuc = khuVuc;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.doiTuong = doiTuong;
	}
	public String getMaKyThi() {
		return maKyThi;
	}
	public void setMaKyThi(String maKyThi) {
		this.maKyThi = maKyThi;
	}
	
	public String getMaThiSinh() {
		return maThiSinh;
	}
	public void setMaThiSinh(String maThiSinh) {
		this.maThiSinh = maThiSinh;
	}
	public String getSoBaoDanh() {
		return soBaoDanh;
	}
	public void setSoBaoDanh(String soBaoDanh) {
		this.soBaoDanh = soBaoDanh;
	}
	public String getHoDem() {
		return hoDem;
	}
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	public String getKhuVuc() {
		return khuVuc;
	}
	public void setKhuVuc(String khuVuc) {
		this.khuVuc = khuVuc;
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
	public String getDoiTuong() {
		return doiTuong;
	}
	public void setDoiTuong(String doiTuong) {
		this.doiTuong = doiTuong;
	}
	public float getDiemUuTien() {
		return diemUuTien;
	}
	public void setDiemUuTien(float diemUuTien) {
		this.diemUuTien = diemUuTien;
	}
	public float getDiemMon1() {
		return diemMon1;
	}
	public void setDiemMon1(float diemMon1) {
		this.diemMon1 = diemMon1;
	}
	public float getDiemMon2() {
		return diemMon2;
	}
	public void setDiemMon2(float diemMon2) {
		this.diemMon2 = diemMon2;
	}
	public float getDiemMon3() {
		return diemMon3;
	}
	public void setDiemMon3(float diemMon3) {
		this.diemMon3 = diemMon3;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
}
