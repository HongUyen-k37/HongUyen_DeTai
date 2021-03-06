package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThongKeActionForm;
import model.bean.KyThiBean;
import model.bean.NguoiDungBean;
import model.bo.KyThiBO;
import model.bo.ThiSinhBO;

public class ThongKeDSTSTrungTuyenAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ThongKeActionForm frm = (ThongKeActionForm)form;
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		//get list ky thi de select
		KyThiBO ktBO = new KyThiBO();
		List<KyThiBean> listKyThi=ktBO.getListKyThi();
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
		frm.setSoMonThi(kyThi.getSoMonThi());
		//show danh sách
		ThiSinhBO tsBO = new ThiSinhBO();
		if(kyThi.getSoMonThi()==3){
			frm.setListTrungTuyen(tsBO.getListThiSinhTrungTuyen(maKyThi));
		}
		else{
			frm.setListTrungTuyen(tsBO.getListThiSinhTrungTuyen2Mon(maKyThi));
		}
		return mapping.findForward("success");
	}
}
