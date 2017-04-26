package action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import form.KyThiActionForm;
import model.bean.BaiThiBean;
import model.bean.PhongThiBean;
import model.bo.BaiThiBO;
import model.bo.PhongThiBO;

public class GetDonTuiPhach extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		KyThiActionForm frm = (KyThiActionForm)form;
		
		String maKyThi = frm.getMaKyThi();
		PhongThiBO ptBO = new PhongThiBO();
		List<PhongThiBean> listPhongThi = ptBO.getListPhongThiTheoMaKyThi(maKyThi);
		BaiThiBO btBO = new BaiThiBO();
		List<BaiThiBean> listBaiThi = btBO.getListDonTui(maKyThi);
		
		Object[] arrPhongThi = new Object[listPhongThi.size()];
		for(int i = 0; i < listPhongThi.size(); i++){
			arrPhongThi[i] = listPhongThi.get(i);
			System.out.println(arrPhongThi[i]);
		}
		Object[] arrBaiThi = new Object[listBaiThi.size()];
		for(int i = 0; i < listBaiThi.size(); i++){
			arrBaiThi[i] = listBaiThi.get(i);
			System.out.println(arrBaiThi[i]);
		}
		
		Object[] ot=new Object[2];
		ot[0]= arrPhongThi;
		ot[1]= arrBaiThi;
		
		ObjectWriter ow= new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json=ow.writeValueAsString(ot);
		PrintWriter pw=response.getWriter();
		pw.print(json);
		return null;
	}
	
}
