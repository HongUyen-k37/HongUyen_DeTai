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
<title>Thống kê bảng điểm theo môn thi</title>
<jsp:include page="Asset/Head.jsp" />
</head>
<body>
<jsp:include page="Asset/Header.jsp" />
<jsp:include page="Asset/Menu2.jsp" />
<div class="container">
		<div class="group-content">
			<div class="row main-nav">
				<p class="title">THỐNG KÊ BẢNG ĐIỂM THEO MÔN</p>
				<div class="row">
				<div class="form-group col-sm-7">
			   		<label class="col-sm-2">Tên kỳ thi:</label>
			    	<div class="col-sm-10">
				      	<html:select property="maKyThi" name="thongKeActionForm" styleId="f_maKyThi" styleClass="form-control" onchange="getMaKyThi()">
	                    		<html:optionsCollection name="thongKeActionForm" property="listKyThi" label="tenKyThi" value="maKyThi"/>
		             	</html:select>
			    	</div>
			  	</div>
		    	<div class="form-group col-sm-5">
		    	<label class="col-sm-3">Môn thi:</label>
		    		<div class="col-sm-9">
			    		<html:select property="maMonThi" name="thongKeActionForm" styleId="f_maMonThi" styleClass="form-control" onchange="getTKBangDiemTheoMon()">
		                	<html:optionsCollection name="thongKeActionForm" property="listMonThi" label="tenMonThi" value="maMonThi"/>
			            </html:select>
		            </div>
		    	</div>
		    	</div>
	    		<div style="padding-bottom: 20px"><a class="btn btn-success btn-all" style="float:right;" onclick="printDiv('thongKeBangDiemTheoMon')">Tải xuống</a></div>
	    	<div class="group-content">
   	    		<div class="title-content">
					<div class="col-md-4">
						<h5>TRƯỜNG ĐẠI HỌC KHOA HỌC</h5>
						<bean:define id="kyThi" name="thongKeActionForm" property="kyThi"></bean:define>
						<h6 style="padding-left:30px;"><b>TUYỂN SINH NĂM <bean:write name="kyThi" property="namTuyenSinh"></bean:write></b></h6>
					</div>
					<div class="col-md-8 text-center">
						<h6><b>KẾT QUẢ CHẤM THI TUYỂN SINH ĐẠI HỌC</b></h6>
						<p>Hình thức đào tạo: <bean:write name="kyThi" property="hinhThucDT"></bean:write></p>
					</div>
				</div>
				<div class="col-md-4">	
					<p>Ngành: <bean:write name="kyThi" property="nganh"></bean:write></p>
					<p>Điểm thi: <bean:write name="kyThi" property="coSoLKDT"></bean:write></p>
				</div>
				<div class="col-md-8 text-center">
					<p><b>Môn thi: ${thongKeActionForm.monThi.tenMonThi}</b></p>
				</div>
				
				<div class="details_info main-nav">
					<div class="main-list">
						<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th rowspan="2" style="line-height: 45px;">STT</th>						
								<th rowspan="2" style="line-height: 45px;" colspan="2">Họ và tên</th>
								<th rowspan="2" style="line-height: 45px;">Ngày sinh</th>
								<th rowspan="2" style="line-height: 45px;">Số báo danh</th>
								<th rowspan="2" style="line-height: 45px;">Số phách</th>
								<th colspan="2">Điểm thi</th>
								<th rowspan="2" style="line-height: 45px;">Ghi chú</th>
							</tr>
							<tr>
								<th>Bằng số</th>
								<th>Bằng chữ</th>
							</tr>
						</thead>
						<bean:define id="stt" value="0"/>
						<tbody>
							<logic:iterate id="dsts" name="thongKeActionForm" property="listTKTheoMon">	
								<tr>	
									<bean:define id="stt" value="${stt+1}"/>
									<td>${stt}</td>
									<td><bean:write name="dsts" property="hoDem"/></td>
									<td><bean:write name="dsts" property="ten"/></td>
									<td style="text-align: right"><bean:write name="dsts" property="ngaySinh"/></td>
									<td style="text-align: center"> <bean:write name="dsts" property="soBaoDanh"/></td>
									<td style="text-align: center"><bean:write name="dsts" property="soPhach"/></td>
									
									<logic:notEqual value="-1" name="dsts" property="diemChinhThuc">
									<td style="text-align: center">
									<bean:write name="dsts" property="diemChinhThuc"/>
									<input type="hidden" id="input${stt-1}" value="${dsts.diemChinhThuc}" />
									</td>
				                    <td><span id="output${stt-1}"></span></td>
				                    </logic:notEqual>   
				                    <logic:equal value="-1" name="dsts" property="diemChinhThuc">
				                    <input type="hidden" id="input${stt-1}" value=""/>
				                    <td></td>
				                    <td><span id="output${stt-1}"></span></td>
				                    </logic:equal>
				                    <td style="text-align: center"><bean:write name="dsts" property="ghiChu"/></td>
								</tr>
							</logic:iterate>
						</tbody>
						</table>
						<input type="hidden" id="soBaiThi" value="${stt}"/>
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