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

import form.BaiThiActionForm;
import model.bean.BaiThiBean;
import model.bean.MonThiBean;
import model.bean.PhongThiBean;
import model.bo.BaiThiBO;
import model.bo.MonThiBO;
import model.bo.PhongThiBO;

public class GetDonTuiPhach extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		BaiThiActionForm frm = (BaiThiActionForm)form;
	
		String maKyThi = frm.getMaKyThi();
		String maMonThi = frm.getMaMonThi();
		System.out.println(maKyThi+" "+maMonThi);
		if(maKyThi == null || maKyThi.equals("") || maMonThi == null || maMonThi.equals(""))
			return null;
		PhongThiBO ptBO = new PhongThiBO();
		List<PhongThiBean> listPhongThi = ptBO.getListPhongThiTheoMaKyThi(maKyThi);
		BaiThiBO btBO = new BaiThiBO();
		List<BaiThiBean> listBaiThi = btBO.getListDonTui(maKyThi, maMonThi);
		
		MonThiBO mtBO = new MonThiBO();
		MonThiBean monThi = mtBO.getMonThi(maMonThi);
		
		Object[] ot=new Object[3];
		ot[0]= listPhongThi;
		ot[1]= listBaiThi;
		ot[2] = monThi;
		ObjectWriter ow= new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json=ow.writeValueAsString(ot);
		PrintWriter pw=response.getWriter();
		pw.print(json);
		return null;
	}
	
}
