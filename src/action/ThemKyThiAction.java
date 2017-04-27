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
import model.bean.MonThiBean;
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
		if(user == null) return mapping.findForward("login");
		//them
		if ("submit".equals(frm.getSubmit())) {
			String tenKyThi = frm.getTenKyThi();
			String nganh = frm.getNganh();
			List<KyThiBean> lst = ktBO.getListKyThi();
			//kiểm tra trùng
			for (KyThiBean kt1 : lst) {
				if(kt1.getTenKyThi().equals(tenKyThi) && kt1.getNganh().equals(nganh)){
					return mapping.findForward("error");
				}
			}
			List<MonThiBean> listMonThi = null;
			if(frm.getListMonThi()!=null){
				listMonThi = frm.getListMonThi();
			}
			String ngayThi = frm.getNgayThi();
			int namTuyenSinh = frm.getNamTuyenSinh();
			String hinhThucDT = frm.getHinhThucDT();
			String coSoLKDT = frm.getCoSoLKDT();
			int soMonThi = listMonThi.size();
			KyThiBean kt = new KyThiBean(null, tenKyThi, ngayThi, namTuyenSinh, nganh, hinhThucDT, coSoLKDT, soMonThi,
					0, null, 0, 0, 0, 0, false);
			ktBO.insert(kt, listMonThi);
			/*session.setAttribute("notice", "Thêm kỳ thi thành công");*/
			frm.setNotice("Thêm kỳ thi thành công");
			return mapping.findForward("success");
		}
		return mapping.findForward("home");
	}
	
}
