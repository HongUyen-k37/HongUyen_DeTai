package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.KyThiActionForm;
import model.bean.KyThiBean;
import model.bean.NguoiDungBean;
import model.bo.KyThiBO;

public class ThemKyThiAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		KyThiActionForm frm = (KyThiActionForm)form;
		KyThiBO ktBO = new KyThiBO();
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		//them
		if ("submit".equals(frm.getSubmit())) {
			String tenKyThi = frm.getTenKyThi();
			String nganh = frm.getNganh();
			List<KyThiBean> lst = ktBO.getListKyThi();
			
			for (KyThiBean kt1 : lst) {
				if(kt1.getTenKyThi().equals(tenKyThi) && kt1.getNganh().equals(nganh)){
					return mapping.findForward("error");
				}
			}
			String ngayThi = frm.getNgayThi();
			int namTuyenSinh = frm.getNamTuyenSinh();
			String hinhThucDT = frm.getHinhThucDT();
			String coSoLKDT = frm.getCoSoLKDT();
		
			int soMonThi = frm.getSoMonThi();
			System.out.println(soMonThi);
			int trangThai = 1;
			KyThiBean kt = new KyThiBean(null, tenKyThi, ngayThi, namTuyenSinh, nganh, hinhThucDT, coSoLKDT, soMonThi,
					trangThai, null, 0, 0, 0, 0, false);
			ktBO.insert(kt);
			frm.setNotice("Thêm kỳ thi thành công");
			return mapping.findForward("ThemKyThi");
		}
		return mapping.findForward("ShowKyThi");
	}
	
}
