package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.Define;
import model.bean.KetQuaThiSinhBean;
import model.bean.ThiSinhBean;

public class ThiSinhDAO extends DataAccessObject{
	public List<ThiSinhBean> getListThiSinh(String maKyThi){
		List<ThiSinhBean> lst = new ArrayList<ThiSinhBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM THISINH WHERE maKyThi = ? ORDER BY ten, hoDem";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			rs = pstm.executeQuery();
			ThiSinhBean ts = null;
			while (rs.next()) {
				ts = new ThiSinhBean(rs.getString("maThiSinh"), rs.getString("maKyThi"), rs.getString("maPhongThi"), rs.getString("hoDem"),
						rs.getString("ten"), rs.getString("ngaySinh"), rs.getString("noiSinh"), rs.getString("khuVuc"),
						rs.getString("doiTuong"), rs.getString("dienThoai"), rs.getString("email"), rs.getString("diaChi"),
						rs.getString("soBaoDanh"));
				lst.add(ts);
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return lst;
	}
	public ThiSinhBean getThiSinh(String maThiSinh) {
		ThiSinhBean ts = null;
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM THISINH where maThiSinh = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maThiSinh);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ts = new ThiSinhBean(rs.getString("maThiSinh"), rs.getString("maKyThi"), rs.getString("maPhongThi"), rs.getString("hoDem"),
						rs.getString("ten"), rs.getString("ngaySinh"), rs.getString("noiSinh"), rs.getString("khuVuc"),
						rs.getString("doiTuong"), rs.getString("dienThoai"), rs.getString("email"), rs.getString("diaChi"),
						rs.getString("soBaoDanh"));
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return ts;
	}
	public boolean danhSoBaoDanh(String tiepDauNgu, int soBatDau, int soLuong, String maKyThi){
		if(tiepDauNgu==null || tiepDauNgu.equals("")) System.out.println("Nothing");
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "EXEC DanhSoBaoDanh ?, ?, ?, ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, tiepDauNgu);
			pstm.setInt(2, soBatDau);
			pstm.setInt(3, soLuong);
			pstm.setString(4, maKyThi);
			result = pstm.execute();
		} catch (Exception ex) {
			result = false;
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
		}
		return result;
	}
	
	public boolean insert(ThiSinhBean thiSinh) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "INSERT INTO THISINH VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, thiSinh.getMaKyThi());
			pstm.setString(2, thiSinh.getMaPhongThi());
			pstm.setString(3, thiSinh.getHoDem());
			pstm.setString(4, thiSinh.getTen());
			pstm.setString(5, thiSinh.getNgaySinh());
			pstm.setString(6, thiSinh.getNoiSinh());	
			pstm.setString(7, thiSinh.getKhuVuc());
			pstm.setString(8, thiSinh.getDoiTuong());
			pstm.setString(9, thiSinh.getDienThoai());
			pstm.setString(10, thiSinh.getEmail());
			pstm.setString(11, thiSinh.getDiaChi());
			pstm.setString(12, thiSinh.getSoBaoDanh());
			pstm.executeUpdate();
			result = true;
		} catch (Exception ex) {
			result = false;
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
		}
		return result;
	}
	
	public boolean update(ThiSinhBean thiSinh) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Update THISINH Set hoDem=?, ten=?, ngaySinh=?, noiSinh=?, khuVuc=?, doiTuong=?, dienThoai=?,"
					+ "email=?, diaChi=? where maThiSinh=? ";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(10, thiSinh.getMaThiSinh());
			pstm.setString(1, thiSinh.getHoDem());
			pstm.setString(2, thiSinh.getTen());
			pstm.setString(3, thiSinh.getNgaySinh());
			pstm.setString(4, thiSinh.getNoiSinh());	
			pstm.setString(5, thiSinh.getKhuVuc());
			pstm.setString(6, thiSinh.getDoiTuong());
			pstm.setString(7, thiSinh.getDienThoai());
			pstm.setString(8, thiSinh.getEmail());
			pstm.setString(9, thiSinh.getDiaChi());	
			pstm.executeUpdate();
			result = true;
		} catch (Exception ex) {
			result = false;
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
		}
		return result;
	}
	
	public boolean delete(String maThiSinh) {
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Delete from THISINH where maThiSinh=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maThiSinh);
			result = pstm.execute();
		} catch (Exception ex) {
			result = false;
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
		}
		return result;
	}
	public List<ThiSinhBean> searchThiSinh(String key){
		List<ThiSinhBean> lst = new ArrayList<ThiSinhBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM THISINH where ten Like N'%"+key +"%' or khuVuc Like N'%"+key+"%' or doiTuong Like N'%"+key+"%' ORDER BY ten, hoDem";
			pstm = cnn.prepareStatement(sql);
			rs = pstm.executeQuery();
			ThiSinhBean ts = null;
			while (rs.next()) {
				ts = new ThiSinhBean(rs.getString("maThiSinh"), rs.getString("maKyThi"), rs.getString("maPhongThi"), rs.getString("hoDem"),
						rs.getString("ten"), rs.getString("ngaySinh"), rs.getString("noiSinh"), rs.getString("khuVuc"),
						rs.getString("doiTuong"), rs.getString("dienThoai"), rs.getString("email"), rs.getString("diaChi"),
						rs.getString("soBaoDanh")) ;
				lst.add(ts);
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return lst;		
	}
	public List<ThiSinhBean> getListThiSinhTheoPhongThi(String maPhongThi){
		List<ThiSinhBean> lst = new ArrayList<ThiSinhBean>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT * FROM THISINH WHERE maPhongThi = ? ORDER BY ten, hoDem";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maPhongThi);
			rs = pstm.executeQuery();
			ThiSinhBean ts = null;
			while (rs.next()) {
				ts = new ThiSinhBean(rs.getString("maThiSinh"), rs.getString("maKyThi"), rs.getString("maPhongThi"), rs.getString("hoDem"),
						rs.getString("ten"), rs.getString("ngaySinh"), rs.getString("noiSinh"), rs.getString("khuVuc"),
						rs.getString("doiTuong"), rs.getString("dienThoai"), rs.getString("email"), rs.getString("diaChi"),
						rs.getString("soBaoDanh"));
				lst.add(ts);
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return lst;
	}
	public boolean update(String maThiSinh, String maPhongThi){
		boolean result = false;
		Connection cnn = getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "Update THISINH Set maPhongThi=? where maThiSinh=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maPhongThi);
			pstm.setString(2, maThiSinh);
			pstm.executeUpdate();
			result = true;
		} catch (Exception ex) {
			result = false;
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
		}
		return result;
	}
	public List<String> getListKhuVuc(){
		List<String> lst = new ArrayList<>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT distinct khuVuc FROM THISINH";
			pstm = cnn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				String kv = rs.getString("khuVuc");
				lst.add(kv);
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return lst;
	}
	public List<String> getListDoiTuong(){
		List<String> lst = new ArrayList<>();
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;		
		try {
			String sql = "SELECT distinct doiTuong FROM THISINH";
			pstm = cnn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				String dt = rs.getString("doiTuong");
				lst.add(dt);
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return lst;
	}
	public int getSoThiSinhDat(String maKyThi, String khuVuc, String doiTuong, float diemChuan, float diemLiet, boolean check){
		int total = 0;
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT *, tongDiem + diemKhuVuc + diemDoiTuong AS diemChinhThuc FROM v_TinhDiem WHERE maKyThi = ? AND khuVuc = ? AND doiTuong = ? AND tongDiem + diemKhuVuc + diemDoiTuong >= ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			pstm.setNString(2, khuVuc);
			pstm.setNString(3, doiTuong);
			pstm.setFloat(4, diemChuan);
			rs = pstm.executeQuery();
			while (rs.next()) {
				String maThiSinh = rs.getString("maThiSinh");
				float[] diem3Mon = getDiem3Mon(maKyThi, maThiSinh);
				if(diem3Mon[0] > diemLiet && diem3Mon[1] > diemLiet && diem3Mon[2] > diemLiet && check == false) total++;
				if(diem3Mon[0] >= diemLiet && diem3Mon[1] >= diemLiet && diem3Mon[2] >= diemLiet && check == true) total++;
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return total;
	}
	public int getSoThiSinhBiDiemLiet(String maKyThi, String khuVuc, String doiTuong, float diemLiet, boolean check){
		int total = 0;
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM v_TinhDiem WHERE maKyThi = ? AND khuVuc = ? AND doiTuong = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			pstm.setNString(2, khuVuc);
			pstm.setNString(3, doiTuong);
			rs = pstm.executeQuery();
			while (rs.next()) {
				String maThiSinh = rs.getString("maThiSinh");
				float[] diem3Mon = getDiem3Mon(maKyThi, maThiSinh);
				if((diem3Mon[0] <= diemLiet || diem3Mon[1] <= diemLiet || diem3Mon[2] <= diemLiet && check == false)
						|| (diem3Mon[0] < diemLiet || diem3Mon[1] < diemLiet || diem3Mon[2] < diemLiet && check == true)) total++;
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return total;
	}
	public int getTongSoThiSinh(String maKyThi, String khuVuc, String doiTuong){
		int total = 0;
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM v_TinhDiem WHERE maKyThi = ? AND khuVuc = ? AND doiTuong = ?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			pstm.setNString(2, khuVuc);
			pstm.setNString(3, doiTuong);
			rs = pstm.executeQuery();
			while (rs.next()) {
				total++;
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return total;
	}
	
	public List<KetQuaThiSinhBean> getListKetQuaThiSinh(String maKyThi){
		List<KetQuaThiSinhBean> lst = new ArrayList<>();	
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM THISINH WHERE maKyThi=?";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				KetQuaThiSinhBean ts = new KetQuaThiSinhBean(maKyThi, rs.getString("maThiSinh"),  rs.getString("soBaoDanh"), rs.getString("hoDem"), rs.getString("khuVuc"), 
						rs.getString("ten"), rs.getString("ngaySinh"), rs.getString("doiTuong"));
				float[] diem3Mon=getDiem3Mon(maKyThi, ts.getMaThiSinh());
				ts.setDiemMon1(diem3Mon[0]);
				ts.setDiemMon2(diem3Mon[1]);
				ts.setDiemMon3(diem3Mon[2]);
				ts.setDiemUuTien(Define.getDiemCongDoiTuong().get(ts.getDoiTuong())+Define.getDiemCongKhuVuc().get(ts.getKhuVuc()));
				lst.add(ts);
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}	
		return lst;
	}
	
	public float[] getDiem3Mon(String maKyThi,String maThiSinh){
		float[] diem3Mon=new float[3];
		int i=0;
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT diemChinhThuc FROM BAITHI WHERE maKyThi=? AND maThiSinh=? ORDER BY maMonThi";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			pstm.setString(2, maThiSinh);
			rs = pstm.executeQuery();
			while (rs.next()) {
				diem3Mon[i++]=rs.getFloat("diemChinhThuc");
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}
		return diem3Mon;
	}
	public List<KetQuaThiSinhBean> getListThiSinhTrungTuyen(String maKyThi){
		List<KetQuaThiSinhBean> lst = new ArrayList<>();	
		Connection cnn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			String sql = "SELECT * FROM THISINH, KYTHI WHERE THISINH.maKyThi=? and THISINH.maKyThi = KYTHI.maKyThi";
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, maKyThi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				KetQuaThiSinhBean ts = new KetQuaThiSinhBean(maKyThi, rs.getString("maThiSinh"),  rs.getString("soBaoDanh"),
						rs.getString("hoDem"), rs.getString("khuVuc"), rs.getString("ten"), rs.getString("ngaySinh"),
						rs.getString("doiTuong"), rs.getFloat("diemChuan"), rs.getFloat("diemLiet"),
						rs.getBoolean("nhoHonDiemLiet"));
				float[] diem3Mon=getDiem3Mon(maKyThi, ts.getMaThiSinh());
				ts.setDiemMon1(diem3Mon[0]);
				ts.setDiemMon2(diem3Mon[1]);
				ts.setDiemMon3(diem3Mon[2]);
				ts.setDiemUuTien(Define.getDiemCongDoiTuong().get(ts.getDoiTuong())+Define.getDiemCongKhuVuc().get(ts.getKhuVuc()));
				if((ts.getDiemMon1()+ts.getDiemMon2()+ts.getDiemMon3()+ts.getDiemUuTien()>ts.getDiemChuan()
						&& ts.getDiemMon1()>=ts.getDiemLiet()
						&& ts.getDiemMon2()>=ts.getDiemLiet()
						&& ts.getDiemMon3()>=ts.getDiemLiet()
						&& ts.isNhoHonDiemLiet()==true)
						|| (ts.getDiemMon1()+ts.getDiemMon2()+ts.getDiemMon3()+ts.getDiemUuTien()>ts.getDiemChuan()
								&& ts.getDiemMon1()>ts.getDiemLiet()
								&& ts.getDiemMon2()>ts.getDiemLiet()
								&& ts.getDiemMon3()>ts.getDiemLiet()
								&& ts.isNhoHonDiemLiet()==false)){
					lst.add(ts);
				}
			}
		} catch (Exception ex) {
			getMessenger(ex);
		} finally {
			tryToClose(cnn);
			tryToClose(pstm);
			tryToClose(rs);
		}	
		return lst;
	}
}
