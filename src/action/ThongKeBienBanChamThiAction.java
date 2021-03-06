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
import model.bean.BaiThiBean;
import model.bean.KyThiBean;
import model.bean.MonThiBean;
import model.bean.NguoiDungBean;
import model.bo.KyThiBO;
import model.bo.MonThiBO;
import model.bo.ThongKeBO;

public class ThongKeBienBanChamThiAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		ThongKeActionForm frm = (ThongKeActionForm)form;
		ThongKeBO tk = new ThongKeBO();
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
		frm.setKyThi(ktBO.getKyThi(maKyThi));
		//get list mon thi de select
		MonThiBO mtBO = new MonThiBO();
		List<MonThiBean> listMonThi = mtBO.getListMonThi(maKyThi);
		frm.setListMonThi(listMonThi);
		//get ma mon thi
		String maMonThi = listMonThi.size()==0?"":listMonThi.get(0).getMaMonThi();
		if(frm.getMaMonThi()!=null)
			maMonThi = frm.getMaMonThi();
		System.out.println(maMonThi);
		//get thong tin mon thi thong qua maMonThi 
		frm.setMonThi(mtBO.getMonThi(maMonThi));
		//show list thống kê biên bản chấm thi theo môn
		List<BaiThiBean> list = tk.tkBienBanChamThi(maKyThi, maMonThi);
		frm.setListTKBienBan(list);
		return mapping.findForward("success");
	}
}
