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

import form.CauHoiActionForm;
import model.bean.CauHoiBean;
import model.bo.CauHoiBO;

public class GetCauHoiAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		
		CauHoiActionForm frm=(CauHoiActionForm)form;
		
		String idCauHoi=frm.getIdCauHoi();
		CauHoiBO cauHoiBO=new CauHoiBO();
		CauHoiBean cauHoi =cauHoiBO.getCauHoi(idCauHoi);
		
		ObjectWriter ow= new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json=ow.writeValueAsString(cauHoi);
		PrintWriter pw=response.getWriter();
		pw.print(json);
		return null;
	}
	
}
