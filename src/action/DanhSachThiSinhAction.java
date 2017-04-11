package action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import form.ThiSinhActionForm;
import model.bean.NguoiDungBean;
import model.bean.ThiSinhBean;
import model.bo.ThiSinhBO;

public class DanhSachThiSinhAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ThiSinhActionForm frm = (ThiSinhActionForm)form;
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		
		ThiSinhBO tsBO = new ThiSinhBO();
		frm.setListThiSinh(tsBO.getListThiSinh(frm.getMaKyThi()));
		return mapping.findForward("success");
	}
	
}
