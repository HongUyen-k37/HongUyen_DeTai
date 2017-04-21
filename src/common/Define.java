package common;

import java.util.HashMap;
import java.util.Map;

public class Define {
	public static String SEVER_NAME = "localhost";
	public static String DB_NAME = "QuanLyTuyenSinh";
	public static String DB_USERNAME = "sa";
	public static String DB_PASSWORD = "12345678";
	
	public static Map<String,Float> getDiemCongKhuVuc(){
		Map<String,Float> map=new HashMap<>();
		map.put("Khu vực 1", 1.5f);
		map.put("Khu vực 2", 1f);
		map.put("Khu vực 2NT", .5f);
		map.put("Khu vực 3", 0f);
		return map;
	}
	public static Map<String,Float> getDiemCongDoiTuong(){
		Map<String,Float> map=new HashMap<>();
		map.put("ƯT1", 2f);
		map.put("ƯT2", 1f);
		map.put("KƯT", 0f);
		return map;
	}
}
