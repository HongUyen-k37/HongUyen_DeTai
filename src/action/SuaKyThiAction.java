package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.KyThiActionForm;
import model.bean.KyThiBean;
import model.bean.MonThiBean;
import model.bean.NguoiDungBean;
import model.bo.KyThiBO;

public class SuaKyThiAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		KyThiActionForm frm = (KyThiActionForm)form;
		KyThiBO ktBO = new KyThiBO();
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		//get maKyThi
		String maKyThi = frm.getMaKyThi();
		if(maKyThi==null || maKyThi.equals("")) 
			return mapping.findForward("error");
		//get thông tin kỳ thi
		KyThiBean kyThi = ktBO.getKyThi(maKyThi);
		//get list mon thi cua ky thi
		if(kyThi.getTrangThai()!=0){
			return mapping.findForward("errorStatus");
		}
		else{
			//get list môn thi
			List<MonThiBean> listMonThi = null;
			if(frm.getListMonThi()==null){
				return mapping.findForward("error");
			}
			else{
				listMonThi = frm.getListMonThi();
			}
			String tenKyThi = frm.getTenKyThi();
			String ngayThi = frm.getNgayThi();
			int namTuyenSinh = frm.getNamTuyenSinh();
			String nganh = frm.getNganh();
			String hinhThucDT = frm.getHinhThucDT();
			String coSoLKDT = frm.getCoSoLKDT();
			int soMonThi = listMonThi.size();
			KyThiBean kt = new KyThiBean(maKyThi, tenKyThi, ngayThi, namTuyenSinh, nganh, hinhThucDT, coSoLKDT, soMonThi,
					0, null, 0, 0, 0, 0, false);
			ktBO.update(kt, listMonThi);
			return mapping.findForward("success");
		}
	}
	
}
