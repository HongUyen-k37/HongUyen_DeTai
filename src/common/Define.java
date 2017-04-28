package common;

import java.util.HashMap;
import java.util.Map;

public class Define {
	public static String SEVER_NAME = "localhost";
	public static String DB_NAME = "QuanLyTuyenSinh1";
	public static String DB_USERNAME = "sa";
	public static String DB_PASSWORD = "12345678";
	
	public static Map<String,Float> getDiemCongKhuVuc(){
		Map<String,Float> map=new HashMap<>();
		map.put("KV1", 1.5f);
		map.put("KV2", 1f);
		map.put("KV2-NT", .5f);
		map.put("KV3", 0f);
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
