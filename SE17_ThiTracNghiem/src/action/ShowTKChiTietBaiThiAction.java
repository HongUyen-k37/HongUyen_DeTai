package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThongKeChiTietActionForm;
import model.bean.UserBean;
import model.bo.BaiThiBO;
import model.bo.ThongKeBO;

public class ShowTKChiTietBaiThiAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response){
		
		ThongKeChiTietActionForm frm = (ThongKeChiTietActionForm) form;
		ThongKeBO thongKeBO = new ThongKeBO();
		BaiThiBO bt = new BaiThiBO();
		int tongSoCauHoi = bt.getBaiThi(frm.getIdBaiThi()).getSoCauHoi();
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		if(user==null) return mapping.findForward("Login");
		
		frm.setListTKThanhTich(thongKeBO.getListThongKeBaiThiThanhTich(frm.getIdBaiThi()));
		frm.setTenBaiThi(bt.getBaiThi(frm.getIdBaiThi()).getTenBaiThi());
		frm.setTongSoCauHoi(tongSoCauHoi);
		frm.setSoThanhVienlam(thongKeBO.getListThongKeBaiThiThanhTich(frm.getIdBaiThi()).size());
		
		
		return mapping.findForward("ThongKeChiTietBaiThi");
	}

}
