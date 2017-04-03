package action;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.CauHoiActionForm;
import model.bean.BaiThiBean;
import model.bean.LanThiBean;
import model.bo.BaiThiBO;
import model.bo.LanThiBO;

public class LuuDapAnAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		CauHoiActionForm frm=(CauHoiActionForm) form;
		LanThiBO lanThiBO=new LanThiBO();
		String idLanThi=frm.getIdLanThi();
		String idCauHoi=frm.getIdCauHoi();
		String traLoiChon=frm.getTraLoiChon();
		if(idLanThi==null || idLanThi.equals("") || idCauHoi==null || idCauHoi.equals("")) 
			return mapping.findForward("Error");
		LanThiBean lanThi=lanThiBO.getLanThi(idLanThi);
		if(lanThi.isHoanTat()) {
			PrintWriter pw=response.getWriter();
			pw.print(-1);
			return null;
		}
		lanThiBO.luuDapAn(idLanThi, idCauHoi, traLoiChon);
		lanThiBO.setThoiGianKetThuc(idLanThi);	
		BaiThiBO baiThiBO=new BaiThiBO();
		BaiThiBean baiThi=baiThiBO.getBaiThi(lanThi.getIdBaiThi());
		long timeNow=new Date().getTime()/1000;
		long timeStart=lanThi.getThoiGianThi()/1000;
		int timeDo=baiThi.getThoiGian()*60;
		
		PrintWriter pw=response.getWriter();
		pw.print(timeDo-(timeNow-timeStart));
		return null;
	}

}
