package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThongKeBangDiemTheoMonActionForm;
import model.bean.NguoiDungBean;
import model.bean.ThongKeBangDiemTheoMonBean;
import model.bo.ThongKeBangDiemTheoMonBO;

public class ThongKeBangDiemTheoMonAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		ThongKeBangDiemTheoMonActionForm frm = (ThongKeBangDiemTheoMonActionForm)form;
		ThongKeBangDiemTheoMonBO tk = new ThongKeBangDiemTheoMonBO();
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		//show list thống kê bảng điểm theo môn
		List<ThongKeBangDiemTheoMonBean> list = tk.tkBangDiemTheoMon();
		frm.setListTKBangDiem(list);
		return mapping.findForward("success");
	}
}
