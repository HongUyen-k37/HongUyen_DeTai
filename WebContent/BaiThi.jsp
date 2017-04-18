<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
				<bean:define id="listMaKyThi" name="baiThiActionForm"></bean:define>
				<%@include file="Asset/ThongTinKyThi.jsp" %>
			</div>
		</div>
	</div>
	<div class="col-md-8">
		<div class="group-content">
			<div class="row main-nav">
			<p class="title">XỬ LÝ BÀI THI</p>
			<label class="control-label col-sm-2">Phòng thi:</label>
	    	<div class="col-sm-4">
	    		<html:select property="maPhongThi" name="baiThiActionForm" styleId="f_maPhongThi" styleClass="form-control" onchange="getXuLyBaiThi()">
                	<html:optionsCollection name="baiThiActionForm" property="listPhongThi" label="soHieuPhongThi" value="maPhongThi"/>
	            </html:select>
	    	</div>
	    	<label class="control-label col-sm-2">Môn thi:</label>
	    	<div class="col-sm-4">
	    		<html:select property="maMonThi" name="baiThiActionForm" styleId="f_maMonThi" styleClass="form-control" onchange="getXuLyBaiThi()">
                	<html:optionsCollection name="baiThiActionForm" property="listMonThi" label="tenMonThi" value="maMonThi"/>
	            </html:select>
	    	</div>
			</div>
		<div class="details_info">
			<p class="title">DANH SÁCH CÁC THÍ SINH DỰ THI</p>
			<div class="main-list">
			<html:form>
				<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th>STT</th>
						<th>Số báo danh</th>
						<th>Họ đệm</th>
						<th>Tên</th>
						<th>Ngày sinh</th>
						<th>Xử lý thi</th>
					</tr>
				</thead>
				<bean:define id="stt" value="0"/>
				<tbody>
					<logic:iterate id="dsts" name="baiThiActionForm" property="listThiSinh">	
						<tr>	
							<bean:define id="stt" value="${stt+1}"/>
							<td>${stt}</td>
							<bean:define id="maThiSinh" name="dsts" property="maThiSinh"></bean:define>
							<td><bean:write name="dsts" property="soBaoDanh"/></td>
							<td><bean:write name="dsts" property="hoDem"/></td>
							<td><bean:write name="dsts" property="ten"/></td>
							<td><bean:write name="dsts" property="ngaySinh"/></td>
							
							<td>		
							<html:select property="trangThaiDuThi" styleClass="trangThaiDuThi form-control" value="1">
								<html:option value="1">Dự thi</html:option>
								<html:option value="2">Khiển trách</html:option>
								<html:option value="3">Cảnh cáo</html:option>
								<html:option value="4">Đình chỉ thi</html:option>						
								<html:option value="5">Vắng thi</html:option>
							</html:select>
							</td>	                    
						</tr>
					</logic:iterate>
				</tbody>
				</table>
				<div class="col-sm-9">
						<p>Danh sách gồm có: <span> ${stt} </span> sinh viên</p>
				</div>
				<button type="submit" name="save" value="save" class="btn btn-success btn-all">Lưu</button>
				<button type="submit" class="btn btn-success btn-all" name='execute'>In Danh sách</button>
				</html:form>
			</div>
		</div>
		</div>
	</div>
</div>

</div>
<jsp:include page="Asset/Footer.jsp" />
</body>
</html>