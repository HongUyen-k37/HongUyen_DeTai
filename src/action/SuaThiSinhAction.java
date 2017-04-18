package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThiSinhActionForm;
import model.bean.NguoiDungBean;
import model.bean.ThiSinhBean;
import model.bo.ThiSinhBO;

public class SuaThiSinhAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		ThiSinhActionForm frm = (ThiSinhActionForm)form;
		ThiSinhBO tsBO = new ThiSinhBO();
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		//get maThiSinh
		String maThiSinh = frm.getMaThiSinh();
		if(maThiSinh==null || maThiSinh.equals("")) 
			return mapping.findForward("error");

		String maKyThi = frm.getMaKyThi();
		System.out.println(maKyThi);
		String hoDem = frm.getHoDem();
		String ten = frm.getTen();
		String ngaySinh = frm.getNgaySinh();
		String noiSinh = frm.getNoiSinh();
		String khuVuc = frm.getKhuVuc();
		String doiTuong = frm.getDoiTuong();
		String email = frm.getEmail();
		String dienThoai = frm.getDienThoai();
		String diaChi = frm.getDiaChi();
		ThiSinhBean ts =new ThiSinhBean(maThiSinh, maKyThi, null, hoDem, ten, ngaySinh, noiSinh, khuVuc, doiTuong, dienThoai, email, diaChi, null);
		tsBO.update(ts);
		return mapping.findForward("success");
	}
	
}
