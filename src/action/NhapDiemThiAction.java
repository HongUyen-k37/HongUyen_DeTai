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
import model.bean.MonThiBean;
import model.bean.NguoiDungBean;
import model.bo.BaiThiBO;
import model.bo.KyThiBO;
import model.bo.MonThiBO;

public class NhapDiemThiAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DiemActionForm frm = (DiemActionForm)form;
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		//get list ky thi de select
		KyThiBO ktBO = new KyThiBO();
		List<KyThiBean> listKyThi=ktBO.getListKyThi();
		frm.setListKyThi(listKyThi);
		//get mã kỳ thi
		String maKyThi = listKyThi.size()==0?"":listKyThi.get(0).getMaKyThi();
		if(frm.getMaKyThi()!=null)
			maKyThi = frm.getMaKyThi();
		//get thong tin cua ky thi duoc chon
		frm.setKyThi(ktBO.getKyThi(maKyThi));
		//get list Môn
		MonThiBO mtBO = new MonThiBO();
		List<MonThiBean> listMonThi = mtBO.getListMonThi(maKyThi);
		frm.setListMonThi(listMonThi);
		//get Mã Môn thi
		String maMonThi = listMonThi.size()==0?"":listMonThi.get(0).getMaMonThi();
		if(frm.getMaMonThi()!=null)
			maMonThi = frm.getMaMonThi();
		//get list Túi
		BaiThiBO btBO = new BaiThiBO();
		List<Integer> listTui = btBO.getListTui(maKyThi);
		frm.setListTui(listTui);
		//get Túi
		int tuiSo = listTui.size()==0?0:listTui.get(0);
		if(frm.getTuiSo()!=0)
			tuiSo = frm.getTuiSo();
		//get Bài thi theo Môn và Túi
		frm.setListBaiThi(btBO.getListTheoTui(maKyThi, maMonThi, tuiSo));
		if("save".equals(frm.getSave())){
			btBO.nhapDiem(maKyThi, maMonThi, 1, 10, "Mười");
			return mapping.findForward("success");
		}
		return mapping.findForward("success");
	}
	
}
