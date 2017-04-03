package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThongKeBaiThiThanhTichActionForm;
import model.bean.UserBean;
import model.bo.ThongKeBO;

public class ShowChiTietThanhTichCaNhanAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
HttpServletResponse response){
		

		ThongKeBaiThiThanhTichActionForm frm = (ThongKeBaiThiThanhTichActionForm) form;
		ThongKeBO thongKeBO = new ThongKeBO();
		
		//kiểm tra xem đã đăng nhập chưa? 
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		if(user==null) return mapping.findForward("Login");
		 
		frm.setListBaiThiThanhTich(thongKeBO.getListThanhTichUser(user.getIdUser()));
		
		return mapping.findForward("ThongKeChiTietBaiThiThanhTich");
	}
}
