package model.bean;

public class DiemChuanBean {
	private String ten;
	private float diem;
	private int soTSDat;
	private int soTSKhongDat;
	private int soTSBiDiemLiet;
	private int tong;
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public float getDiem() {
		return diem;
	}
	public void setDiem(float diem) {
		this.diem = diem;
	}
	public int getSoTSDat() {
		return soTSDat;
	}
	public void setSoTSDat(int soTSDat) {
		this.soTSDat = soTSDat;
	}
	public int getSoTSKhongDat() {
		return soTSKhongDat;
	}
	public void setSoTSKhongDat(int soTSKhongDat) {
		this.soTSKhongDat = soTSKhongDat;
	}
	public int getSoTSBiDiemLiet() {
		return soTSBiDiemLiet;
	}
	public void setSoTSBiDiemLiet(int soTSBiDiemLiet) {
		this.soTSBiDiemLiet = soTSBiDiemLiet;
	}
	public DiemChuanBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTong() {
		return tong;
	}
	public void setTong(int tong) {
		this.tong = tong;
	}
	public DiemChuanBean(String ten, float diem, int soTSDat, int soTSKhongDat, int soTSBiDiemLiet, int tong) {
		super();
		this.ten = ten;
		this.diem = diem;
		this.soTSDat = soTSDat;
		this.soTSKhongDat = soTSKhongDat;
		this.soTSBiDiemLiet = soTSBiDiemLiet;
		this.tong = tong;
	}
}
