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
import model.bo.ThiSinhBO;

public class TimKiemThiSinhAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ThiSinhActionForm frm = (ThiSinhActionForm) form;
		ThiSinhBO ts = new ThiSinhBO();
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		//get list ky thi de select
		KyThiBO ktBO = new KyThiBO();
		List<KyThiBean> listKyThi=ktBO.getListKyThi();
		frm.setListKyThi(listKyThi);
		
		String maKyThi = listKyThi.size()==0?"":listKyThi.get(0).getMaKyThi();
		if(frm.getMaKyThi()!=null)
			maKyThi = frm.getMaKyThi();
		//get thong tin cua ky thi duoc chon
		frm.setKyThi(ktBO.getKyThi(maKyThi));
		//get từ khóa tìm kiếm về
		String search = frm.getSearch();
		System.out.println(search);
		//get submit
		String submit = frm.getSubmit();
		System.out.println(submit);
		frm.setListThiSinh(ts.getListThiSinh(maKyThi));
		if (submit == null ||search == null || search.equals("")) 
			frm.setListThiSinh(ts.getListThiSinh(maKyThi));
		else{		
			/*search = new String(search.getBytes("ISO-8859-1"), "UTF-8");*/
			frm.setListThiSinh(ts.searchThiSinh(search));	
		}
		// Lay list tim kiem
	
		return mapping.findForward("success");
	}
}
