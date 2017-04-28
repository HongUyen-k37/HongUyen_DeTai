package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DiemActionForm;
import model.bean.KyThiBean;
import model.bean.NguoiDungBean;
import model.bo.KyThiBO;
import model.bo.MonThiBO;
import model.bo.ThiSinhBO;

public class XacDinhDiemChuanAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		DiemActionForm frm = (DiemActionForm)form;
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		//get list ky thi de select
		KyThiBO ktBO = new KyThiBO();
		List<KyThiBean> listKyThi=ktBO.getListKyThi();
		//java.util.Collections.shuffle(listKyThi);
		frm.setListKyThi(listKyThi);
		//get makythi
		String maKyThi = null;
		if(session.getAttribute("maKyThi")!=null){
			maKyThi = (String)session.getAttribute("maKyThi");
		}
		else{
			maKyThi = listKyThi.size()==0?"":listKyThi.get(0).getMaKyThi();
		}
		if(frm.getMaKyThi()!=null ){
			maKyThi = frm.getMaKyThi();
			session.setAttribute("maKyThi", maKyThi);
		}
		//get thong tin cua ky thi duoc chon
		KyThiBean kyThi = ktBO.getKyThi(maKyThi);
		frm.setKyThi(kyThi);
		//get mon thi cua ky thi
		MonThiBO mtBO = new MonThiBO();
		frm.setListMonThi(mtBO.getListMonThi(maKyThi));
		frm.setNotice(null);
		//chức năng
		if ("test".equals(frm.getKiemTra()) || "submit".equals(frm.getSubmit())) {
			if(kyThi.getTrangThai()>6){
				return mapping.findForward("errorStatus");
			}
			//get input
			float diemLiet = frm.getDiemLiet();
			boolean check = frm.getCheck();
			float diemChuan = frm.getDiemChuan();
			//xu ly
			ThiSinhBO tsBO = new ThiSinhBO();
			frm.setListResult(tsBO.kiemTraDiemChuan(maKyThi, diemLiet, diemChuan, check));
			frm.setNotice("Kiểm tra thành công");
			if("submit".equals(frm.getSubmit())){
				ktBO.xacDinhDiemChuan(maKyThi, diemChuan, diemLiet, check);
				ktBO.updateTrangThai(maKyThi, 7);
				frm.setNotice("Xác định điểm chuẩn thành công");
				return mapping.findForward("success");
			}
		}
		return mapping.findForward("success");
	}
	
}
