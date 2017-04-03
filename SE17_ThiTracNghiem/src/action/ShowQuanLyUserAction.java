package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.PhanTrang;
import form.UserActionForm;
import model.bean.UserBean;
import model.bo.UserBO;

public class ShowQuanLyUserAction extends Action{
	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
HttpServletResponse response) throws Exception{
		
		UserActionForm frm = (UserActionForm) form;
		UserBO userBO = new UserBO();
		String search = frm.getSearch();
		//kiểm tra xem đã đăng nhập chưa? 
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		List<UserBean> lst = userBO.getListUser();
		if(user==null || user.getRole()!=1) 
			return mapping.findForward("Login");
		
		if(search == null || search.equals("")){
			lst = userBO.getListUser();
		}
		else{
			search= new String(search.getBytes("ISO-8859-1"),"UTF-8");
			lst = userBO.searchUser(search);
		}
		
		PhanTrang phanTrang=new PhanTrang(10,frm.getPage(),lst);
		frm.setListUser((List<UserBean>) phanTrang.getLst());
		frm.setTotal(phanTrang.getTotal());
		return mapping.findForward("ShowUser");
		
	}
}
