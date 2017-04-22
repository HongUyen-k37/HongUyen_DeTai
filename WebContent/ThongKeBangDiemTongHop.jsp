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
<title>Thống kê bảng điểm tổng hợp</title>
<jsp:include page="Asset/Head.jsp" />
</head>
<body>
<jsp:include page="Asset/Header.jsp" />
<jsp:include page="Asset/Menu2.jsp" />
<div class="container">
		<div class="group-content">
			<div class="row main-nav">
				<p class="title">THỐNG KÊ BẢNG ĐIỂM TỔNG HỢP</p>
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
					<div class="col-md-6">
						<h5>TRƯỜNG ĐẠI HỌC KHOA HỌC</h5>
						<h6 style="padding-left:30px;"><b>TUYỂN SINH NĂM ${thongKeActionForm.kyThi.namTuyenSinh}</b></h6>
					</div>
					<div class="col-md-6">
						<h6><b>KẾT QUẢ CHẤM THI TUYỂN SINH ĐẠI HỌC</b></h6>
						<p style="padding-left:30px;">Ngày thi: ${thongKeActionForm.kyThi.ngayThi} năm ${thongKeActionForm.kyThi.namTuyenSinh}</p>
					</div>
				</div>
				<div class="col-md-7">	
					<p>Hình thức đào tạo: ${thongKeActionForm.kyThi.hinhThucDT}</p>
					<p>Ngành: ${thongKeActionForm.kyThi.nganh}</p>
				</div>
				<div class="col-md-5">
					<p>Điểm thi: ${thongKeActionForm.kyThi.coSoLKDT}</p>
				</div>
				<div class="details_info">
					<div class="main-list">
						<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th rowspan="2">STT</th>						
								<th rowspan="2">Số báo danh</th>
								<th rowspan="2" colspan="2">Họ và tên</th>
								<th rowspan="2">Ngày sinh</th>
								<th rowspan="2">Khu vực</th>
								<th rowspan="2">Nhóm đối tượng</th>
								<th colspan="4">Điểm thi</th>
								<th rowspan="2">Điểm ƯT</th>
								<th rowspan="2">Cộng</th>
								<th rowspan="2">Ghi chú</th>
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
							<logic:iterate id="dsts" name="thongKeActionForm" property="listTKTongHop">	
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
<jsp:include page="Asset/Footer.jsp" />
</body>
</html>