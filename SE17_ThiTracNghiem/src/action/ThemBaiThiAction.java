package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaiThiActionForm;
import model.bean.BaiThiBean;
import model.bean.LoaiBaiThiBean;
import model.bean.UserBean;
import model.bo.BaiThiBO;

/**
 * Kai
 * @author HCD-Fresher112
 *
 */
public class ThemBaiThiAction extends Action {
//ID user lay tam thoi,sau nay sua lai
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		BaiThiActionForm frm = (BaiThiActionForm) form;
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		if(user==null || user.getRole()!=2) return mapping.findForward("Login");
		
		//lay danh sach cac loai
		BaiThiBO bt = new BaiThiBO();
		List<LoaiBaiThiBean> listLoai = bt.getListLoaiBT();
		frm.setListLoai(listLoai);
		
		if(frm.getSubmit()!=null){
			String tenBaiThi = frm.getTenBaiThi();
			int thoiGian = frm.getThoiGian();
			int soCauHoi = frm.getSoCauHoi();
			String moTa = frm.getMoTa();
			String idLoai = frm.getIdLoai();
			Boolean active = frm.isActive();
			String password = frm.getPassword();
			BaiThiBean baiThi = new BaiThiBean(null, tenBaiThi, thoiGian, soCauHoi, moTa, idLoai, password, user.getIdUser(), active);
			bt.insert(baiThi);
			
		}/*else{		
		//chuyen sang trang Them sinh vien		
		return mapping.findForward("thembaithi");
		}*/
		return mapping.findForward("long");
									
	}
	

}
