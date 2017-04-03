package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.UserActionForm;
import model.bean.TKThanhVienBean;
import model.bean.UserBean;
import model.bo.ThongKeBO;
import model.bo.UserBO;

public class ShowCaNhanAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
HttpServletResponse response){
		
		UserActionForm frm = (UserActionForm) form;
		UserBO userBO = new UserBO();
		
		//Neu chua login thi chuyen trang login
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		if(user==null) 
			return mapping.findForward("Login");
		ThongKeBO tkBO=new ThongKeBO();
		TKThanhVienBean tk=tkBO.getThongKeThanhVien(user.getIdUser());
		if(frm.getCapNhat()!=null && frm.getCapNhat().equals("Cập nhật")){
			String idUser = user.getIdUser();
			String hoTen = frm.getHoTen();
			String email = frm.getEmail();
			String sdt = frm.getSdt();
			String donVi = frm.getDonVi();
			String diaChi = frm.getDiaChi();
			String password = frm.getPassword();
			UserBean object = new UserBean(idUser, hoTen, diaChi, email, sdt, donVi, user.getUsername(), password, user.getRole(), user.isActive());
			userBO.updateUser(object);
			request.getSession().setAttribute("user",object);
			user=object;
		}
		frm.setRole(user.getRole());
		frm.setDiaChi(user.getDiaChi());
		frm.setDonVi(user.getDonVi());
		frm.setEmail(user.getEmail());
		frm.setHoTen(user.getHoTen());
		frm.setSdt(user.getSdt());
		frm.setPassword(user.getPassword());
		frm.setRole(user.getRole());
		frm.setSoBaiThi(tk.getSoBaiThi());
		frm.setTongCauDung(tk.getTongCauDung());
		frm.setTongCauHoi(tk.getTongCauHoi());
		return mapping.findForward("profile");
	}
}
