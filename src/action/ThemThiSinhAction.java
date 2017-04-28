package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThiSinhActionForm;
import model.bean.KyThiBean;
import model.bean.NguoiDungBean;
import model.bean.ThiSinhBean;
import model.bo.KyThiBO;
import model.bo.ThiSinhBO;

public class ThemThiSinhAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		ThiSinhActionForm frm = (ThiSinhActionForm)form;
		ThiSinhBO tsBO = new ThiSinhBO();
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		String maKyThi = frm.getMaKyThi();
		System.out.println(maKyThi);
		//get thông tin kỳ thi
		KyThiBO ktBO = new KyThiBO();
		KyThiBean kyThi = ktBO.getKyThi(maKyThi);
		if(kyThi.getTrangThai()!=0){
			return mapping.findForward("errorStatus");
		}
		if ("submit".equals(frm.getSubmit())) {
			String hoDem = frm.getHoDem();
			String ten = frm.getTen();
			String ngaySinh = frm.getNgaySinh();
			String noiSinh = frm.getNoiSinh();
			String khuVuc = frm.getKhuVuc();
			String doiTuong = frm.getDoiTuong();
			String dienThoai = frm.getDienThoai();
			String email = frm.getEmail();
			String diaChi = frm.getDiaChi();
		
			ThiSinhBean ts = new ThiSinhBean(null, maKyThi, null, hoDem, ten, ngaySinh, noiSinh, khuVuc, doiTuong, dienThoai, email, diaChi, null);
			tsBO.insert(ts);
			return mapping.findForward("ThemThiSinh");
		}
		return mapping.findForward("ShowThiSinh");
	}
}
