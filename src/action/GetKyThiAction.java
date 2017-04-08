package action;

import java.io.PrintWriter;

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
import model.bo.KyThiBO;

public class GetKyThiAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		KyThiActionForm frm = (KyThiActionForm)form;
		
		String maKyThi=frm.getMaKyThi();
		KyThiBO ktBO = new KyThiBO();
		KyThiBean kt = ktBO.getKyThi(maKyThi);
		
		ObjectWriter ow= new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json=ow.writeValueAsString(kt);
		PrintWriter pw=response.getWriter();
		pw.print(json);
		return null;
	}
	
}
