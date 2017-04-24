package model.bean;

public class DiemThiBean {
	private int soPhach;
	private float diemChamThi;
	public int getSoPhach() {
		return soPhach;
	}
	public void setSoPhach(int soPhach) {
		this.soPhach = soPhach;
	}
	public float getDiemChamThi() {
		return diemChamThi;
	}
	public void setDiemChamThi(float diemChamThi) {
		this.diemChamThi = diemChamThi;
	}
	public DiemThiBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DiemThiBean(int soPhach, float diemChamThi) {
		super();
		this.soPhach = soPhach;
		this.diemChamThi = diemChamThi;
	}
}
