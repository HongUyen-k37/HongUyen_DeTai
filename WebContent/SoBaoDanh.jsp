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
				<bean:define id="listMaKyThi" name="thiSinhActionForm"></bean:define>
				<%@include file="Asset/ThongTinKyThi.jsp" %>
			</div>
		</div>
	</div>
	<div class="col-md-8">
		<div class="group-content">
			<div class="row main-nav">
			<p class="title">ĐÁNH SỐ BÁO DANH</p>
			<html:form action="SoBaoDanh.do" method="POST">
				<div class="form-group row">
				<label class="col-md-3" for="tdn">Tiếp đầu ngữ:</label>
				<div class="col-md-9">
					<input type="text" class="form-control" name="tiepDauNgu">
				</div>
				</div>
				<div class="form-group row">
				<label class="col-md-3" for="sbd">Số bắt đầu:</label>
				<div class="col-md-9">
					<input type="number" class="form-control" name="soBatDau" min="1">
				</div>
				</div>
				<div class="form-group row">
				<label class="col-md-3" for="sl">Số lượng chữ số:</label>
				<div class="col-md-9">
					<input type="number" class="form-control" name="soLuong" min="1">
				</div>
				</div>
				<div class="btn-gr">
					<button type="submit" name="submit" value="submit" class="btn btn-success">Thực hiện</button>
				</div>
			</html:form>
			</div>
		<div class="details_info">
		<p class="title">DANH SÁCH CÁC THÍ SINH DỰ THI</p>
			<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>STT</th>
					<th>Số báo danh</th>
					<th>Họ đệm</th>
					<th>Tên</th>
					<th>Ngày sinh</th>
				</tr>
			</thead>
			<bean:define id="stt" value="0"/>
			<tbody>
				<logic:iterate name="thiSinhActionForm" property="listThiSinh" id="dsts">
				<bean:define id="stt" value="${stt+1}"/>
				<tr>
					<td>${stt}</td>
					<td><bean:write name="dsts" property="soBaoDanh"/></td>
					<td><bean:write name="dsts" property="hoDem"/></td>
					<td><bean:write name="dsts" property="ten"/></td>
					<td  style="text-align: right"><bean:write name="dsts" property="ngaySinh"/></td>
				</tr>
				</logic:iterate>
			</tbody>
			</table>
			<div class="totalCandidates">
					<p>Danh sách gồm có: <span> ${stt} </span> sinh viên</p>
			</div>
		</div> <!-- end details -->
		</div>
	</div>
</div>

</div>
<jsp:include page="Asset/Footer.jsp" />
<script type="text/javascript">
	$(document).ready(function(){
		<logic:notEmpty name="thiSinhActionForm" property="notice">
			showNotice('${thiSinhActionForm.notice}');
		</logic:notEmpty>
	});
</script>
</body>
</html>