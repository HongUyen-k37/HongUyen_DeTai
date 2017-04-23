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
				<bean:define id="listMaKyThi" name="diemActionForm"></bean:define>
				<%@include file="Asset/ThongTinKyThi.jsp" %>
			</div>
		</div>
	</div>
	<div class="col-md-8">
		<div class="group-content">
		<html:form action="/NhapDiemThi" method="POST">
			<div class="row main-nav">
				<p class="title">NHẬP ĐIỂM THI</p>
				<div class="form-group no-pad row">
					<label class="col-sm-2">Chọn môn thi:</label>
					<div class="col-sm-4">
						<html:select property="maMonThi" name="diemActionForm" styleId="f_maMonThi" styleClass="form-control" onchange="getNhapDiemThi()">
                    		<html:optionsCollection name="diemActionForm" property="listMonThi" label="tenMonThi" value="maMonThi"/>
	             		</html:select>
					</div>
					<label class="col-sm-2">Túi số:</label>
					<div class="col-sm-4">
						<html:select property="tuiSo" name="diemActionForm" styleId="f_tuiSo" styleClass="form-control" onchange="getNhapDiemThi()">
                    		<html:options name="diemActionForm" property="listTui"/>
	             		</html:select>
					</div>
				</div>
			</div>
		<div class="details_info">
			<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>Số phách</th>
					<th>Điểm</th>
					<th>Điểm chữ</th>
				</tr>
			</thead>
			<bean:define id="stt" value="0"/>
			<tbody>
				<logic:iterate id="bt" name="diemActionForm" property="listBaiThi"></logic:iterate>
				<tr>
					<bean:define id="stt" value="${stt+1}"/>
					<td>${bt.soPhach}</td>
					<td>
						<input type="text" name="diemSo" class="form-control" id="input">
					</td>
					<td>
						<span id="output"></span>
					</td>
				</tr>
			</tbody>
			</table>
			<div class="row">
				<div class="col-sm-6">
				<p>Danh sách gồm có: <span> ${stt} </span> bài thi.</p>
				</div>
				<div class="btn-gr col-sm-6">
					<button type="submit" class="btn btn-success btn-all" name="save" id="save" value="save">Lưu</button>
					<button type="submit" class="btn btn-success btn-all" name="finish" onclick="lock()">Kết thúc nhập</button>
					<button type="submit" class="btn btn-success btn-all" name="delete" id="delete">Xóa hết</button>
				</div>
			</div>
		</div>
		</html:form>
	</div>
</div>
</div>

</div>
<jsp:include page="Asset/Footer.jsp" />
</body>
</html>