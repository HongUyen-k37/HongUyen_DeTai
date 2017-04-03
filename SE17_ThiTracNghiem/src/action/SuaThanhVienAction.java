package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.UserActionForm;
import model.bean.UserBean;
import model.bo.UserBO;

public class SuaThanhVienAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		
		UserBO userbo = new UserBO();
		UserActionForm frm = (UserActionForm)form;
		String idUser=frm.getIdUser();
		
		UserBean user=userbo.getUser(idUser);
		UserBean userSession=(UserBean) request.getSession().getAttribute("user");
		if(userSession==null) return mapping.findForward("Login");
		if("NangCap".equals(frm.getAction())){
			if(userSession.getRole() == 3){
				//Lấy thống kê của user trong BO ra để so sánh.
				//Lớn hơn 500 thì cho phép
				
				//Lỗi
				return mapping.findForward("Error");
			}
			if(userSession.getRole() == 1){	
				//String idUser=frm.getIdUser();			
				if(idUser==null || idUser.equals("")) 
					return mapping.findForward("Error");
				user = userbo.getUser(idUser);
			}	
			user.setRole(5-user.getRole());
			System.out.println(user.getRole());
			userbo.updateUser(user);
		}
		if("CapMK".equals(frm.getAction())){
		//Action Cap MK
			userbo.resetPassword(idUser);
			return mapping.findForward("resetPass");
		}		
		//Action Chan
		if("Chan".equals(frm.getAction())){
			
			userbo.changeActive(idUser);
			return mapping.findForward("stopUser");
		}
		return mapping.findForward("update");
	}
}
