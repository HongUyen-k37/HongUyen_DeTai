package action;

import java.util.List;

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
import model.bo.KyThiBO;
import model.bo.MonThiBO;
import model.bo.ThiSinhBO;

public class DanhSoBaoDanhAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ThiSinhActionForm frm = (ThiSinhActionForm)form;
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		ThiSinhBO tsBO = new ThiSinhBO();
		//get list ky thi de select
		KyThiBO ktBO = new KyThiBO();
		List<KyThiBean> listKyThi=ktBO.getListKyThi();
		frm.setListKyThi(listKyThi);
		//get makythi
		String maKyThi = listKyThi.size()==0?"":listKyThi.get(0).getMaKyThi();
		if(frm.getMaKyThi()!=null ){
			maKyThi = frm.getMaKyThi();
		}
		else{
			return mapping.findForward("error");
		}
		//get thong tin cua ky thi duoc chon
		frm.setKyThi(ktBO.getKyThi(maKyThi));
		//get listmonthi cua kythi
		MonThiBO mtBO = new MonThiBO();
		frm.setListMonThi(mtBO.getListMonThi(maKyThi));
		//danh sbd
		if ("submit".equals(frm.getSubmit())&&( frm.getMaKyThi()!=null)){
			tsBO.danhSoBaoDanh(frm.getTiepDauNgu(), frm.getSoBatDau(), frm.getSoLuong(), frm.getMaKyThi());
			frm.setNotice("Đánh số báo danh thành công");
			ktBO.updateTrangThai(maKyThi, 1);
		}else{
			return mapping.findForward("error");
		}
		//show list thi sinh
		frm.setListThiSinh(tsBO.getListThiSinh(maKyThi));
		return mapping.findForward("success");
	}
	
}
