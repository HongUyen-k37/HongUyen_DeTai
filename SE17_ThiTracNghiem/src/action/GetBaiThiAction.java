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

import form.BaiThiActionForm;
import model.bean.BaiThiBean;
import model.bo.BaiThiBO;

public class GetBaiThiAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		
		BaiThiActionForm frm=(BaiThiActionForm)form;
		
		String idBaiThi=frm.getIdBaiThi();
		BaiThiBO baiThiBO=new BaiThiBO();
		BaiThiBean baiThi=baiThiBO.getBaiThi(idBaiThi);
		
		ObjectWriter ow= new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json=ow.writeValueAsString(baiThi);
		PrintWriter pw=response.getWriter();
		pw.print(json);
		return null;
	}
	
}
