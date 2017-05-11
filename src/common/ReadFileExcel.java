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

import model.bean.ThiSinhBean;

public class ReadFileExcel {
	public static List<ThiSinhBean> getListFromFile(FormFile formFile, String maKyThi) throws Exception{
		List<ThiSinhBean> lstThiSinh =new  ArrayList<ThiSinhBean>();
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
			String hoDem = null,ten = null,ngaySinh = null,noiSinh = null,khuVuc = null,doiTuong = null,
					dienThoai = null, email = null, diaChi = null;
			int i = 0;

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				// Đổi thành getCellType() nếu sử dụng POI 4.x
				String value=dataFormat.formatCellValue(cell).trim();
				if(i==1) hoDem = value;
				if(i==2) ten = value;
				if(i==3) ngaySinh = value;
				if(i==4) noiSinh = value;
				if(i==5) khuVuc = value;
				if(i==6) doiTuong = value;
				if(i==7) dienThoai = value;
				if(i==8) email = value;
				if(i==9) diaChi = value;
				i++;		
			}
			ThiSinhBean ts = new ThiSinhBean(null, maKyThi, null, hoDem, ten, ngaySinh, noiSinh, khuVuc, doiTuong, dienThoai, email, diaChi, null);
			if(!hoDem.equals("") && !ten.equals("") && !ngaySinh.equals("") && !doiTuong.equals("") && !khuVuc.equals(""))
			lstThiSinh.add(ts);
		}
		return lstThiSinh;
	}
}