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
		frm.setListKyThi(listKyThi);
		
		String maKyThi = listKyThi.size()==0?"":listKyThi.get(0).getMaKyThi();
		if(frm.getMaKyThi()!=null)
			maKyThi = frm.getMaKyThi();
		//get thong tin cua ky thi duoc chon
		frm.setKyThi(ktBO.getKyThi(maKyThi));
		
		/*ThiSinhBO tsBO = new ThiSinhBO();
		List<DiemChuanBean> lst = tsBO.kiemTraDiemChuan(0, 15, 1);
		for(int i = 0; i < lst.size(); i++){
			System.out.println(lst.get(i).getTen());
			System.out.println(lst.get(i).getDiem());
			System.out.println(lst.get(i).getSoTSDat());
			System.out.println(lst.get(i).getSoTSBiDiemLiet());
			System.out.println(lst.get(i).getSoTSKhongDat());
		}*/
		if ("test".equals(frm.getKiemTra())) {
			//get input
			float diemLiet = frm.getDiemLiet();
			System.out.println(diemLiet);
			int check = frm.getCheck();
			float diemChuan = frm.getDiemChuan();
			//xu ly
			ThiSinhBO tsBO = new ThiSinhBO();
			frm.setListResult(tsBO.kiemTraDiemChuan(diemLiet, diemChuan, check));
			return mapping.findForward("success");
		}
		return mapping.findForward("success");
	}
	
}
