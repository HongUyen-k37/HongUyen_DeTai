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
import model.bean.KyThiBean;
import model.bean.MonThiBean;
import model.bean.NguoiDungBean;
import model.bean.ThongKeBangDiemTheoMonBean;
import model.bo.KyThiBO;
import model.bo.MonThiBO;
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
		//get list ky thi de select
		KyThiBO ktBO = new KyThiBO();
		List<KyThiBean> listKyThi=ktBO.getListKyThi();
		frm.setListKyThi(listKyThi);
		//get ma ky thi
		String maKyThi = listKyThi.size()==0?"":listKyThi.get(0).getMaKyThi();
		if(frm.getMaKyThi()!=null)
			maKyThi = frm.getMaKyThi();
		//get thong tin cua ky thi duoc chon
		frm.setKyThi(ktBO.getKyThi(maKyThi));
		//list mon thi de select
		MonThiBO mtBO = new MonThiBO();
		List<MonThiBean> listMonThi = mtBO.getListMonThi(maKyThi);
		frm.setListMonThi(listMonThi);
		//get ma mon thi
		String maMonThi = listMonThi.size()==0?"":listMonThi.get(0).getMaMonThi();
		if(frm.getMaMonThi()!=null)
			maMonThi = frm.getMaMonThi();
		//get thong tin mon thi
		//chua xu ly duoc vi chua co ham getMonThi(String maMonThi) o MonThiDAO
		//show list thống kê bảng điểm theo môn
		List<ThongKeBangDiemTheoMonBean> list = tk.tkBangDiemTheoMon();
		frm.setListTKBangDiem(list);
		return mapping.findForward("success");
	}
}
