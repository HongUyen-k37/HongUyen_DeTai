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
<title>Tuyển sinh</title>
<jsp:include page="Asset/Head.jsp" />
</head>
<body>
<jsp:include page="Asset/Header.jsp" />
<jsp:include page="Asset/Menu2.jsp" />
<div class="container">
<div class="row">
	<div class="col-md-4 no-pad">
		<div class="thongtinkithi group-content">
			<div class="main-nav">
				<bean:define id="listMaKyThi" name="thongKeBangDiemTheoMonActionForm"></bean:define>
				<%@include file="Asset/ThongTinKyThi.jsp" %>
			</div>
		</div>
	</div>
	<div class="col-md-8">
		<div class="group-content">
			<div class="row main-nav">
				<p class="title">THỐNG KÊ BẢNG ĐIỂM THEO MÔN</p>
		    	
		    	<div>
		    	<label class="control-label col-sm-2">Môn thi:</label>
		    		<html:select property="maMonThi" name="thongKeBangDiemTheoMonActionForm" styleId="f_maMonThi" styleClass="form-control" onchange="getTKBangDiemTheoMon()">
	                	<html:optionsCollection name="thongKeBangDiemTheoMonActionForm" property="listMonThi" label="tenMonThi" value="maMonThi"/>
		            </html:select>
		    	</div>
	    	</div>
	    		<div style="padding-bottom: 20px"><a class="btn btn-success btn-all" style="float:right;" href="javascript:download()">Tải xuống</a></div>
	    	<div class="group-content" style="border: 1px solid #ddd;border-radius: inherit;">
   	    		<div class="title-content">
					<div class="col-md-6">
						<h5>TRƯỜNG ĐẠI HỌC KHOA HỌC</h5>
						<bean:define id="kyThi" name="thongKeBangDiemTheoMonActionForm" property="kyThi"></bean:define>
						<h6 style="padding-left:30px;"><b>TUYỂN SINH NĂM<bean:write name="kyThi" property="namTuyenSinh"></bean:write></b></h6>
					</div>
					<div class="col-md-6">
						<h6><b>KẾT QUẢ CHẤM THI TUYỂN SINH ĐẠI HỌC</b></h6>
						<p style="padding-left:30px;">Hình thức đào tạo: <bean:write name="kyThi" property="hinhThucDT"></bean:write></p>
					</div>
				</div>
				<div class="col-md-7">	
					<p>Ngành: <bean:write name="kyThi" property="nganh"></bean:write></p>
					<p>Điểm thi: Trường Đại Học Khoa Học</p>
				</div>
				<div class="col-md-5">
					<p><b>Môn thi: <bean:write name="" property="monThi"></bean:write></b></p>
				</div>
				
				<div class="details_info">
					<div class="main-list">
					<html:form>
						<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th>STT</th>						
								<th>Họ đệm</th>
								<th>Tên</th>
								<th>Ngày sinh</th>
								<th>Số báo danh</th>
								<th>Số phách</th>
								<th>Điểm thi<th>Bằng số</th>
									<th>Bằng chữ</th></th>
								<th>Ghi chú</th>
							</tr>
						</thead>
						<bean:define id="stt" value="0"/>
						<tbody>
							<logic:iterate id="dsts" name="thongKeBangDiemTheoMonActionForm" property="listTKBangDiem">	
								<tr>	
									<bean:define id="stt" value="${stt+1}"/>
									<td>${stt}</td>
									<bean:define id="maThiSinh" name="dsts" property="maThiSinh"></bean:define>
							
									<td><bean:write name="dsts" property="hoDem"/></td>
									<td><bean:write name="dsts" property="ten"/></td>
									<td><bean:write name="dsts" property="ngaySinh"/></td>
									<td><bean:write name="dsts" property="soBaoDanh"/></td>
									<td><bean:write name="dsts" property="soPhach"/></td>
									<td><bean:write name="dsts" property="diemChamThi"/></td>								
		                    
								</tr>
							</logic:iterate>
						</tbody>
						</table>
						<button type="submit" class="btn btn-success btn-all" name='execute'>In Danh sách</button>
						</html:form>
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