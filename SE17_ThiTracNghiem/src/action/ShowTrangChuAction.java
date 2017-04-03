package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThongKeActionForm;
import model.bo.ThongKeBO;

public class ShowTrangChuAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ThongKeActionForm frm=(ThongKeActionForm) form;
		ThongKeBO thongKeBO=new ThongKeBO();
		frm.setListTKBaiThi(thongKeBO.getListThongKeBaiThi(5));
		frm.setListTKThanhVien(thongKeBO.getListThongKeThanhVien(5));
		return mapping.findForward("TrangChu");
	}
	
}
