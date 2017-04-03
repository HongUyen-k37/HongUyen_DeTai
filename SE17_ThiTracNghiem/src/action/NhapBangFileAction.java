package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;
import org.apache.struts.upload.FormFile;

import common.ReadFileExcel;
import form.FileActionForm;
import model.bean.CauHoiBean;
import model.bean.UserBean;
import model.bo.BaiThi_CauHoiBO;
import model.bo.CauHoiBO;

public class NhapBangFileAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		FileActionForm frm=(FileActionForm) form;
		CauHoiBO cauHoiBO=new CauHoiBO();
		BaiThi_CauHoiBO baiThi_CauHoiBO = new BaiThi_CauHoiBO();
		
		//kiểm tra xem đã đăng nhập chưa? 
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		if(user==null || user.getRole()!=2) return mapping.findForward("Login");
		
		String idUser = user.getIdUser();
		String idBaiThi = frm.getIdBaiThi();
		String action = frm.getAction();
		FormFile formFile=frm.getFile();
		
		if(formFile==null) 
			return mapping.findForward("Error");
		String s=formFile.getFileName();
		String[] arr=s.split("[.]");
		if(!arr[arr.length-1].equals("xlsx")) return new ActionForward("/ErrorFilePage.jsp");
		List<CauHoiBean> lstCauHoi=ReadFileExcel.getListFromFile(formFile, idUser);
		if(action.equals("baiThi")){	
			if(idBaiThi==null || idBaiThi.equals("")) 
				return mapping.findForward("Error");	
			
			String url="NhapCauHoi.do?idBaiThi="+idBaiThi;		
			baiThi_CauHoiBO.insertQuestList(lstCauHoi, idBaiThi);
			ActionRedirect redirect=new ActionRedirect(url);
			return redirect;
		}
		if(action.equals("cauHoi")){
			String url="QuanLyCauHoi.do";
			for (CauHoiBean ch : lstCauHoi) {
				cauHoiBO.insert(ch);
			}
			ActionRedirect redirect=new ActionRedirect(url);
			return redirect;
		}
		return mapping.findForward("Error");
	}

}
