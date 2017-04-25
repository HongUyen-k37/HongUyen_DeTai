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
import model.bean.KyThiBean;
import model.bean.MonThiBean;
import model.bo.KyThiBO;
import model.bo.MonThiBO;

public class GetKyThiAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		KyThiActionForm frm = (KyThiActionForm)form;
		
		String maKyThi=frm.getMaKyThi();
		KyThiBO ktBO = new KyThiBO();
		KyThiBean kt = ktBO.getKyThi(maKyThi);
		MonThiBO mtBO = new MonThiBO();
		List<MonThiBean> lst= mtBO.getListMonThi(maKyThi);
		
		Object[] ot=new Object[2];
		ot[0]=kt;
		ot[1]=lst;
		
		ObjectWriter ow= new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json=ow.writeValueAsString(ot);
		PrintWriter pw=response.getWriter();
		pw.print(json);
		return null;
	}
	
}
