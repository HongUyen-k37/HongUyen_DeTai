package model.dao;

import model.bo.KetQuaThiBO;

public class UyenTestDao {

	public static void main(String[] args) throws Exception {
/*		String idBaiThi="BT0009";
		BaiThiBO baiThiBO=new BaiThiBO();
		BaiThiBean baiThi=baiThiBO.getBaiThi(idBaiThi);
		
		ObjectWriter ow= new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json=ow.writeValueAsString(baiThi);
		System.out.println(json);
*/
		KetQuaThiBO kq = new KetQuaThiBO();
		kq.getListKetQua("LT0001");
/*		LanThi_CauHoiBO lt_ch = new  LanThi_CauHoiBO();
		LanThi_CauHoiBean lt_ch1 = new LanThi_CauHoiBean(null, "CH0001", "Fine");
		System.out.println(lt_ch.insert(lt_ch1));*/
	}
}
