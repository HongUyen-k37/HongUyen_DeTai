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

import form.PhongThiActionForm;
import model.bean.PhongThiBean;
import model.bo.PhongThiBO;

public class GetPhongThiAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		PhongThiActionForm frm = (PhongThiActionForm)form;
		
		String maPhongThi=frm.getMaPhongThi();
		PhongThiBO ptBO = new PhongThiBO();
		PhongThiBean pt = ptBO.getPhongThi(maPhongThi);
		
		ObjectWriter ow= new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json=ow.writeValueAsString(pt);
		PrintWriter pw=response.getWriter();
		
		pw.print(json);
		return null;
}
}
