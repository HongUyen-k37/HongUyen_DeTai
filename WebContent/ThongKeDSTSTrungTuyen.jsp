<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Thống kê danh sách thí sinh trúng tuyển</title>
<jsp:include page="Asset/Head.jsp" />
</head>
<body>
<jsp:include page="Asset/Header.jsp" />
<jsp:include page="Asset/Menu2.jsp" />
<div class="container">
		<div class="group-content">
			<div class="row main-nav">
				<!-- <p class="title">DANH SÁCH THÍ SINH TRÚNG TUYỂN</p> -->
	    		<div class="form-group col-sm-8 col-sm-offset-2">
			   		<label class="col-sm-2">Tên kỳ thi:</label>
			    	<div class="col-sm-10">
				      	<html:select property="maKyThi" name="thongKeActionForm" styleId="f_maKyThi" styleClass="form-control" onchange="getMaKyThi()">
	                    		<html:optionsCollection name="thongKeActionForm" property="listKyThi" label="tenKyThi" value="maKyThi"/>
		             	</html:select>
			    	</div>
			  	</div>
	    	</div>
	    	<div style="padding-bottom: 30px"><a class="btn btn-success btn-all" style="float:right;" href="javascript:download()">Tải xuống</a></div>
	    	<div class="group-content">
   	    		<div class="title-content">
   	    			<div>
						<div class="col-md-5">
							<h5>TRƯỜNG ĐẠI HỌC KHOA HỌC</h5>
							<h6 style="padding-left:30px;"><b>TUYỂN SINH NĂM ${thongKeActionForm.kyThi.namTuyenSinh}</b></h6>
						</div>
						<div class="col-md-7">
							<h5>CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</h5>
							<h6 style="padding-left:70px;">Độc lập - Tự do - Hạnh phúc</h6>
						</div>
					</div>
				
					<div style="height: 100px;text-align:center;"><h5><b>DANH SÁCH THÍ SINH TRÚNG TUYỂN ĐẠI HỌC HỆ KHÔNG CHÍNH QUY NĂM ${thongKeActionForm.kyThi.namTuyenSinh}</b></h5></div>
					
					<div>
					<div>
						<div class="col-md-6">
							<p>Loại hình đào tạo: ${thongKeActionForm.kyThi.hinhThucDT}</p>
							<p>Ngành: ${thongKeActionForm.kyThi.nganh}</p>
						</div>
						<div class="col-md-6">
							<p style="padding-left:30px;">Ngày thi: ${thongKeActionForm.kyThi.ngayThi} năm ${thongKeActionForm.kyThi.namTuyenSinh}</p>
							<p>Điểm thi: ${thongKeActionForm.kyThi.coSoLKDT}</p>
						</div>
					</div>
					<p style="padding-left:15px;">Kèm theo Quyết định số..../QĐ-ĐHKH ngày..../..../.... của Chủ tịch Hội đồng tuyển sinh, Hiệu trưởng trường Đại học Khoa học</p>
				</div>
				<div class="details_info">
					<div class="main-list">
						<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th rowspan="2" style="line-height: 45px;">STT</th>						
								<th rowspan="2" style="line-height: 45px;">Số báo danh</th>
								<th rowspan="2" colspan="2" style="line-height: 45px;">Họ và tên</th>
								<th rowspan="2" style="line-height: 45px;">Ngày sinh</th>
								<th rowspan="2" style="line-height: 45px;">Khu vực</th>
								<th rowspan="2" style="line-height: 45px;">Nhóm đối tượng</th>
								<th colspan="4">Điểm thi</th>
								<th rowspan="2" style="line-height: 45px;">Điểm ƯT</th>
								<th rowspan="2" style="line-height: 45px;">Cộng</th>
								<th rowspan="2" style="line-height: 45px;">Ghi chú</th>
							</tr>
							<tr>
								<th>Môn 1</th>						
								<th>Môn 2</th>
								<th>Môn 3</th>
								<th>Tổng</th>
							</tr>
						</thead>
						<bean:define id="stt" value="0"/>
						<tbody>
							<logic:iterate id="dsts" name="thongKeActionForm" property="listTrungTuyen">	
								<tr>	
									<bean:define id="stt" value="${stt+1}"/>
									<td>${stt}</td>
									<td><bean:write name="dsts" property="soBaoDanh"/></td>
									<td><bean:write name="dsts" property="hoDem"/></td>
									<td><bean:write name="dsts" property="ten"/></td>
									<td><bean:write name="dsts" property="ngaySinh"/></td>
									<td><bean:write name="dsts" property="khuVuc"/></td>
									<td><bean:write name="dsts" property="doiTuong"/></td>
									<td><bean:write name="dsts" property="diemMon1"/></td>
									<td><bean:write name="dsts" property="diemMon2"/></td>
									<td><bean:write name="dsts" property="diemMon3"/></td>
									<td>${dsts.diemMon1 + dsts.diemMon2 + dsts.diemMon3}</td>
									<td><bean:write name="dsts" property="diemUuTien"/></td>
									<td>${dsts.diemMon1 + dsts.diemMon2 + dsts.diemMon3 + dsts.diemUuTien}</td>
									<td><bean:write name="dsts" property="ghiChu"/></td>                    
								</tr>
							</logic:iterate>
						</tbody>
						</table>
					</div>
				</div>
	    	</div>
		</div>
</div>
</div>
<jsp:include page="Asset/Footer.jsp" />
</body>
</html>