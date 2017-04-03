package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.PhanTrang;
import form.ThongKeBaiThiActionForm;
import model.bean.TKBaiThiBean;
import model.bean.UserBean;
import model.bo.ThongKeBO;

public class ShowTKBaiThiAction extends Action{
	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response){
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		if(user==null) return mapping.findForward("Login");
		
		ThongKeBaiThiActionForm frm = (ThongKeBaiThiActionForm) form;
		ThongKeBO thongKeBO = new ThongKeBO();
		List<TKBaiThiBean> lst=new ArrayList<TKBaiThiBean>();
		if(user.getRole()==1){
			lst=thongKeBO.getListThongKeBaiThi();
			if(frm.getIdUser()!=null) lst=thongKeBO.getListThongKeBaiThi(frm.getIdUser());
		}
		else lst=thongKeBO.getListThongKeBaiThi(user.getIdUser());
		PhanTrang phanTrang=new PhanTrang(10,frm.getPage(),lst);
		frm.setListTKBaiThi((List<TKBaiThiBean>) phanTrang.getLst());
		frm.setTotal(phanTrang.getTotal());
		return mapping.findForward("ThongKeBaiThiUser");
	}

}
