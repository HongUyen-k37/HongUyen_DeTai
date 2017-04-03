package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThongKeActionForm;
import model.bean.TKBaiThiBean;
import model.bean.TKThanhVienBean;
import model.bean.UserBean;
import model.bo.ThongKeBO;

public class ShowTKTongQuanAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response){
		
		ThongKeActionForm frm = (ThongKeActionForm) form;
		ThongKeBO thongKeBO = new ThongKeBO();
		List<TKThanhVienBean> lstThanhVien=thongKeBO.getListThongKeThanhVien();
		List<TKBaiThiBean> lstBaiThi=thongKeBO.getListThongKeBaiThi();
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		if(user==null) frm.setIdUser("1");
		else frm.setIdUser(user.getIdUser());
		
		/*PhanTrang phanTrang=new PhanTrang(5,frm.getPageTV(),lstThanhVien);
		frm.setListTKThanhVien((List<TKThanhVienBean>) phanTrang.getLst());
		frm.setTotalTV(phanTrang.getTotal());
		
		PhanTrang phanTrang1=new PhanTrang(5,frm.getPageTK(),lstBaiThi);
		frm.setListTKBaiThi((List<TKBaiThiBean>) phanTrang1.getLst());
		frm.setTotalTV(phanTrang1.getTotal());*/
		
		frm.setListTKThanhVien(lstThanhVien);
		frm.setListTKBaiThi(lstBaiThi);
		return mapping.findForward("ThongKeTongQuan");
		
	}
}
