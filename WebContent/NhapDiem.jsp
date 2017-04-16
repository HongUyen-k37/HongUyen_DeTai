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
				<p class="title">NHẬP ĐIỂM THI</p>
				<form>
					<div class="form-group no-pad row">
						<label class="col-sm-2">Chọn môn thi:</label>
						<div class="col-sm-4">
							<select class="form-control">
							<option>Toán</option>
							<option>Văn</option>
							<option>Anh</option>
						</select>
						</div>
						<label class="col-sm-2">Túi số:</label>
						<div class="col-sm-4">
							<select class="form-control" min="1">
							<option>1</option>
							<option>2</option>
							<option>3</option>
						</select>
						</div>
					</div>
				</form>
			</div>
		<div class="details_info">
			<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th colspan="4">Số phách</th>
					<th colspan="4">Điểm</th>
					<th colspan="4">Điểm chữ</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="4">01</td>
					<td colspan="4">
						<input type="text" name="diemSo" class="form-control" id="input">
					</td>
					<td colspan="4">
						<!-- <input type="text" name="diemChu" class="form-control" id="output"> -->
						<span id="output"></span>
					</td>
				</tr>
			</tbody>
			</table>
			<div class="row">
				<div class="col-sm-6">
				<p>Danh sách gồm có: <span> ... </span> bài thi.</p>
				</div>
				<div class="btn-gr col-sm-6">
					<button type="submit" class="btn btn-success btn-all" name="save">Lưu</button>
					<button type="submit" class="btn btn-success btn-all" name="cancel">Kết thúc nhập</button>
					<button type="submit" class="btn btn-success btn-all" name="delete">Xóa hết</button>
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