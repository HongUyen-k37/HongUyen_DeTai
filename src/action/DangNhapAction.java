package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.NguoiDungActionForm;
import model.bo.NguoiDungBO;

public class DangNhapAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		NguoiDungActionForm frm = (NguoiDungActionForm)form;
		String username = frm.getUsername();
		String password = frm.getPassword();
		
		NguoiDungBO ndBO = new NguoiDungBO();
		if(ndBO.checkLogin(username, password)){
			HttpSession session=request.getSession();
			session.setAttribute("user", ndBO.getUserByUsername(username));
			System.out.println(session.getAttribute("user"));
			return mapping.findForward("success");
		}
		else{
			frm.setError("Dữ liệu không đúng. Vui lòng nhập lại!");
			return mapping.findForward("login");
		}
	}
}
