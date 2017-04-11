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

import form.ThiSinhActionForm;
import model.bean.ThiSinhBean;
import model.bo.ThiSinhBO;

public class GetThiSinhAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		ThiSinhActionForm frm = (ThiSinhActionForm)form;
		
		String maThiSinh=frm.getMaThiSinh();
		ThiSinhBO tsBO = new ThiSinhBO();
		ThiSinhBean kt = tsBO.getThiSinh(maThiSinh);
		
		ObjectWriter ow= new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json=ow.writeValueAsString(kt);
		PrintWriter pw=response.getWriter();
		
		pw.print(json);
		return null;
}
}
