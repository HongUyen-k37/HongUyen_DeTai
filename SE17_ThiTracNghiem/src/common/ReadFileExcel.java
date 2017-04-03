package common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts.upload.FormFile;

import model.bean.CauHoiBean;

public class ReadFileExcel {
	public static List<CauHoiBean> getListFromFile(FormFile formFile,String idUser) throws Exception{
		List<CauHoiBean> lstCauHoi =new  ArrayList<CauHoiBean>();
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(formFile.getInputStream());
		
		// Lấy ra sheet đầu tiên từ workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
		Iterator<Row> rowIterator = sheet.iterator();
		DataFormatter dataFormat=new DataFormatter();
		Row row = rowIterator.next();
		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			// Lấy Iterator cho tất cả các cell của dòng hiện tại.
			Iterator<org.apache.poi.ss.usermodel.Cell> cellIterator = row.cellIterator();
			String noiDung = null,dapAn = null,traLoiMot = null,traLoiHai = null,traLoiBa = null,traLoiBon = null;
			int i = 0;

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				// Đổi thành getCellType() nếu sử dụng POI 4.x
				String value=dataFormat.formatCellValue(cell).trim();
				if(i==1) noiDung = value;
				if(i==2) dapAn = value;
				if(i==3) traLoiMot = value;
				if(i==4) traLoiHai = value;
				if(i==5) traLoiBa = value;
				if(i==6) traLoiBon = value;
				i++;
				
			}
			CauHoiBean ch = new CauHoiBean(null, noiDung, dapAn, traLoiMot, traLoiHai, traLoiBa, traLoiBon, idUser,null);
			if(!noiDung.equals("") && !dapAn.equals("") && !traLoiMot.equals("") && !traLoiHai.equals("") && (dapAn.equals(traLoiHai) || dapAn.equals(traLoiMot) || dapAn.equals(traLoiBa) || dapAn.equals(traLoiBon)))
			lstCauHoi.add(ch);
		}
		return lstCauHoi;
	}
}
