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
				<p class="title">DANH SÁCH THÍ SINH TRÚNG TUYỂN</p>
	    		<div class="form-group col-sm-8 col-sm-offset-2">
	    		<bean:define id="kyThi" name="thongKeActionForm" property="kyThi"></bean:define>
			   		<label class="col-sm-2">Tên kỳ thi:</label>
			    	<div class="col-sm-10">
				      	<html:select property="maKyThi" name="kyThi" styleId="f_maKyThi" styleClass="form-control" onchange="getMaKyThi()">
	                    		<html:optionsCollection name="thongKeActionForm" property="listKyThi" label="tenKyThi" value="maKyThi"/>
		             	</html:select>
			    	</div>
			  	</div>
	    	</div>
	    	<div style="padding-bottom: 30px"><a class="btn btn-success btn-all" style="float:right;" onclick="printDiv('thongKeDSTSTT')">Tải xuống</a></div>
	    	<div class="group-content main-nav" id="thongKeDSTSTT">
   	    		<div class="title-content">
   	    			<div class="row">
						<div class="col-md-4 text-center">
							<h5>TRƯỜNG ĐẠI HỌC KHOA HỌC</h5>
							<h6><b>TUYỂN SINH NĂM ${thongKeActionForm.kyThi.namTuyenSinh}</b></h6>				
						</div>
						<div class="col-md-5 col-md-offset-3 text-center">
							<h5><b>CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</b></h5>
							<h6><b>Độc lập - Tự do - Hạnh phúc</b></h6>											
						</div>
					</div>
					<hr style="margin: 0 0 20px 0">
					<div style="text-align:center;">
						<h5><b>DANH SÁCH THÍ SINH TRÚNG TUYỂN ĐẠI HỌC HỆ KHÔNG CHÍNH QUY NĂM ${thongKeActionForm.kyThi.namTuyenSinh}</b></h5>
					</div>
				
					<div class="col-md-8">
						<p>Loại hình đào tạo: ${thongKeActionForm.kyThi.hinhThucDT}</p>
						<p>Ngành: ${thongKeActionForm.kyThi.nganh}</p>
					</div>
					<div class="col-md-4">
						<p>Ngày thi: ${thongKeActionForm.kyThi.ngayThi} năm ${thongKeActionForm.kyThi.namTuyenSinh}</p>
						<p>Điểm thi: ${thongKeActionForm.kyThi.coSoLKDT}</p>
					</div>				
					<p style="padding-left:15px;">Kèm theo Quyết định số..../QĐ-ĐHKH ngày..../..../.... của Chủ tịch Hội đồng tuyển sinh, Hiệu trưởng trường Đại học Khoa học</p>
				</div>
				<div class="details_info">
					<div class="main-list">
					<!-- Bảng điểm 2 môn -->
					<logic:equal value="2" name="thongKeActionForm" property="soMonThi">
						<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th rowspan="2" style="line-height: 45px;">STT</th>						
								<th rowspan="2" style="line-height: 45px;">Số báo danh</th>
								<th rowspan="2" colspan="2" style="line-height: 45px;">Họ và tên</th>
								<th rowspan="2" style="line-height: 45px;">Ngày sinh</th>
								<th rowspan="2" style="line-height: 45px;">Khu vực</th>
								<th rowspan="2" style="line-height: 45px;">Nhóm đối tượng</th>
								<th colspan="3">Điểm thi</th>
								<th rowspan="2" style="line-height: 45px;">Điểm ƯT</th>
								<th rowspan="2" style="line-height: 45px;">Cộng</th>
								<th rowspan="2" style="line-height: 45px;">Ghi chú</th>
							</tr>
							<tr>
								<th>Môn 1</th>						
								<th>Môn 2</th>
								<th>Tổng</th>
							</tr>
						</thead>
						<bean:define id="stt" value="0"/>
						<tbody>
							<logic:iterate id="dsts" name="thongKeActionForm" property="listTrungTuyen">	
								<tr>	
									<bean:define id="stt" value="${stt+1}"/>
									<td>${stt}</td>
									<td style="text-align: center"><bean:write name="dsts" property="soBaoDanh"/></td>
									<td><bean:write name="dsts" property="hoDem"/></td>
									<td><bean:write name="dsts" property="ten"/></td>
									<td  style="text-align: right"><bean:write name="dsts" property="ngaySinh"/></td>
									<td  style="text-align: center"><bean:write name="dsts" property="khuVuc"/></td>
									<td style="text-align: center"><bean:write name="dsts" property="doiTuong"/></td>
									<td style="text-align: center"><bean:write name="dsts" property="diemMon1"/></td>
									<td style="text-align: center"><bean:write name="dsts" property="diemMon2"/></td>
									<td style="text-align: center">${dsts.diemMon1 + dsts.diemMon2}</td>
									<td style="text-align: center"><bean:write name="dsts" property="diemUuTien"/></td>
									<td style="text-align: center">${dsts.diemMon1 + dsts.diemMon2 + dsts.diemUuTien}</td>
									<td><bean:write name="dsts" property="ghiChu"/></td>                    
								</tr>
							</logic:iterate>
						</tbody>
						</table>
					</logic:equal>
					<!-- Bảng điểm 3 môn -->
					<logic:notEqual value="2" name="thongKeActionForm" property="soMonThi">
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
									<td style="text-align: center"><bean:write name="dsts" property="soBaoDanh"/></td>
									<td><bean:write name="dsts" property="hoDem"/></td>
									<td><bean:write name="dsts" property="ten"/></td>
									<td  style="text-align: right"><bean:write name="dsts" property="ngaySinh"/></td>
									<td  style="text-align: center"><bean:write name="dsts" property="khuVuc"/></td>
									<td style="text-align: center"><bean:write name="dsts" property="doiTuong"/></td>
									<td style="text-align: center"><bean:write name="dsts" property="diemMon1"/></td>
									<td style="text-align: center"><bean:write name="dsts" property="diemMon2"/></td>
									<td style="text-align: center"><bean:write name="dsts" property="diemMon3"/></td>
									<td style="text-align: center">${dsts.diemMon1 + dsts.diemMon2 + dsts.diemMon3}</td>
									<td style="text-align: center"><bean:write name="dsts" property="diemUuTien"/></td>
									<td style="text-align: center">${dsts.diemMon1 + dsts.diemMon2 + dsts.diemMon3 + dsts.diemUuTien}</td>
									<td><bean:write name="dsts" property="ghiChu"/></td>                    
								</tr>
							</logic:iterate>
						</tbody>
						</table>
					</logic:notEqual>
						<div class="row totalCandidates">
							<div class="col-md-7">
								<p>Danh sách gồm có: <span> ${stt} </span> sinh viên.</p>
							</div>
							<div class="col-md-5 btn-group" style="text-align: center">
								<p>Thừa Thiên Huế, ngày.....tháng.....năm 20...</p>
								<p>T.M. Hội đồng tuyển sinh</p>
								<p>Chủ tịch</p>
							</div>
						</div>
					</div>
				</div>
	    	</div>
		</div>
</div>
</div>
<jsp:include page="Asset/Footer.jsp" />
</body>
</html>