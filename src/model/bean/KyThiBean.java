package model.bean;

public class KyThiBean {
	private String maKyThi;
	private String tenKyThi;
	private String ngayThi;
	private int namTuyenSinh;
	private String nganh;
	private String hinhThucDT;
	private String coSoLKDT;
	private int soMonThi;
	private int trangThai;
	private String tiepDauNgu;
	private int soBatDau;
	private int soLuongChuSo;
	private double diemChuan;
	private double diemLiet;
	private boolean nhoHonDiemLiet;
	public String getTenKyThi() {
		return tenKyThi;
	}
	public void setTenKyThi(String tenKyThi) {
		this.tenKyThi = tenKyThi;
	}
	public String getNgayThi() {
		return ngayThi;
	}
	public void setNgayThi(String ngayThi) {
		this.ngayThi = ngayThi;
	}
	public int getNamTuyenSinh() {
		return namTuyenSinh;
	}
	public void setNamTuyenSinh(int namTuyenSinh) {
		this.namTuyenSinh = namTuyenSinh;
	}
	public String getNganh() {
		return nganh;
	}
	public void setNganh(String nganh) {
		this.nganh = nganh;
	}
	public String getHinhThucDT() {
		return hinhThucDT;
	}
	public void setHinhThucDT(String hinhThucDT) {
		this.hinhThucDT = hinhThucDT;
	}
	public String getCoSoLKDT() {
		return coSoLKDT;
	}
	public void setCoSoLKDT(String coSoLKDT) {
		this.coSoLKDT = coSoLKDT;
	}
	public int getSoMonThi() {
		return soMonThi;
	}
	public void setSoMonThi(int soMonThi) {
		this.soMonThi = soMonThi;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public String getTiepDauNgu() {
		return tiepDauNgu;
	}
	public void setTiepDauNgu(String tiepDauNgu) {
		this.tiepDauNgu = tiepDauNgu;
	}
	public int getSoBatDau() {
		return soBatDau;
	}
	public void setSoBatDau(int soBatDau) {
		this.soBatDau = soBatDau;
	}
	public int getSoLuongChuSo() {
		return soLuongChuSo;
	}
	public void setSoLuongChuSo(int soLuongChuSo) {
		this.soLuongChuSo = soLuongChuSo;
	}
	public double getDiemChuan() {
		return diemChuan;
	}
	public void setDiemChuan(double diemChuan) {
		this.diemChuan = diemChuan;
	}
	public double getDiemLiet() {
		return diemLiet;
	}
	public void setDiemLiet(double diemLiet) {
		this.diemLiet = diemLiet;
	}

	public KyThiBean() {
		super();
	}
	public String getMaKyThi() {
		return maKyThi;
	}
	public void setMaKyThi(String maKyThi) {
		this.maKyThi = maKyThi;
	}
	public boolean isNhoHonDiemLiet() {
		return nhoHonDiemLiet;
	}
	public void setNhoHonDiemLiet(boolean nhoHonDiemLiet) {
		this.nhoHonDiemLiet = nhoHonDiemLiet;
	}
	public KyThiBean(String maKyThi, String tenKyThi, String ngayThi, int namTuyenSinh, String nganh, String hinhThucDT,
			String coSoLKDT, int soMonThi, int trangThai, String tiepDauNgu, int soBatDau, int soLuongChuSo,
			double diemChuan, double diemLiet, boolean nhoHonDiemLiet) {
		super();
		this.maKyThi = maKyThi;
		this.tenKyThi = tenKyThi;
		this.ngayThi = ngayThi;
		this.namTuyenSinh = namTuyenSinh;
		this.nganh = nganh;
		this.hinhThucDT = hinhThucDT;
		this.coSoLKDT = coSoLKDT;
		this.soMonThi = soMonThi;
		this.trangThai = trangThai;
		this.tiepDauNgu = tiepDauNgu;
		this.soBatDau = soBatDau;
		this.soLuongChuSo = soLuongChuSo;
		this.diemChuan = diemChuan;
		this.diemLiet = diemLiet;
		this.nhoHonDiemLiet = nhoHonDiemLiet;
	}
	
}
