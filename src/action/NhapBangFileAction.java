package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import common.ReadFileExcel;
import form.FileActionForm;
import model.bean.KyThiBean;
import model.bean.NguoiDungBean;
import model.bean.ThiSinhBean;
import model.bo.KyThiBO;
import model.bo.ThiSinhBO;

public class NhapBangFileAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		FileActionForm frm=(FileActionForm) form;
		ThiSinhBO tsBO = new ThiSinhBO();
		
		//check login
		HttpSession session = request.getSession(true);
		NguoiDungBean user = (NguoiDungBean)session.getAttribute("user");
		if(user == null) return mapping.findForward("error");
		String maKyThi = frm.getMaKyThi();
		System.out.println(maKyThi);
		
		//get thông tin kỳ thi
		KyThiBO ktBO = new KyThiBO();
		KyThiBean kyThi = ktBO.getKyThi(maKyThi);
		if(kyThi.getTrangThai()!=0){
			return mapping.findForward("errorStatus");
		}
		FormFile formFile=frm.getFile();
		
		if(formFile==null) 
			return mapping.findForward("Error");
		String s=formFile.getFileName();
		String[] arr=s.split("[.]");
		if(!arr[arr.length-1].equals("xlsx")) return new ActionForward("/ErrorFilePage.jsp");
		List<ThiSinhBean> lstThiSinh=ReadFileExcel.getListFromFile(formFile, maKyThi);
		for (ThiSinhBean ts : lstThiSinh) {
			tsBO.insert(ts);
		}
		return mapping.findForward("success");
	}

}
