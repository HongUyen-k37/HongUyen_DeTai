package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

import form.UserActionForm;
import model.bo.UserBO;

public class DangNhapAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		UserActionForm frm=(UserActionForm) form;
		
		String username=frm.getUsername();
		String password=frm.getPassword();
		String url=frm.getUrl();
		
		UserBO userBO=new UserBO();
		if(userBO.checkLogin(username, password) && userBO.getUserByUsername(username).isActive()){
			HttpSession session=request.getSession();
			session.setAttribute("user", userBO.getUserByUsername(username));
		}
		ActionRedirect ar=new ActionRedirect(url); 
		return ar;
	}
	
}
