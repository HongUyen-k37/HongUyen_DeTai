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
			<div class="row main-nav">
				<html:form action="/XacDinhDiemChuan" method="POST">
				<p class="title">XÁC ĐỊNH ĐIỂM CHUẨN</p>
				<div class="row">
				<div class="col-md-6 form-group">
					<label class="col-md-4">Điểm liệt:</label>
					<div class="col-md-8">
						<input type="number" class="form-control" name="diemliet">
					</div>
				</div>
				<div class="col-sm-6 form-group">
					<%-- <html:radio property="check" value="1">Bằng hoặc nhỏ hơn điểm liệt</html:radio>
					<html:radio property="check" value="0">Nhỏ hơn điểm liệt</html:radio> --%>
						<input type="radio" name="" checked><label>Bằng hoặc nhỏ hơn điểm liệt</label><br>
						<input type="radio" name=""><label>Nhỏ hơn điểm liệt</label>
				</div>
				</div>
				<div class="form-group row">
					<label class="col-md-6" style="padding-left: 30px;">Điểm chuẩn cho Khu vực 3 - KƯT:</label>
					<div class="col-md-6">
						<input type="number" class="form-control" name="diemchuan">
					</div>
				</div>
				<div class="btn-gr">
					<button type="submit" class="btn btn-success btn-all" name="test" value="test">Kiểm tra</button>
				</div>
				</html:form>
			</div>
			<div class="details_info">
				<table class="table table-bordered table-hover table-striped">
							<thead>
								<tr>
									<th>KV - Đối tượng</th>
									<!-- <th>Điểm</th>
									<th>Số TS Đạt</th>
									<th>Số TS Không Đạt</th>
									<th>Số TS Bị Điểm Liệt</th>
									<th>Tổng</th> -->
								</tr>
							</thead>
							<tbody>
							<logic:iterate name="diemActionForm" property="listResult" id="dc">
								<tr>
									<td><bean:write name="dc" property="ten"/> </td>
									<%-- <td>${diemChuan.diem}</td>
									<td>${diemChuan.soTSDat}</td>
									<td>${diemChuan.soTSKhongDat}</td>
									<td>${diemChuan.soTSBiDiemLiet}</td>
									<td>${diemChuan.soTSDat}+${diemChuan.soTSKhongDat}+${diemChuan.soTSBiDiemLiet}</td> --%>
								</tr>
							</logic:iterate>
							</tbody>
						</table>
				<div class="btn-gr">
					<button type="submit" class="btn btn-success btn-all" name="xddc">Xác định điểm chuẩn</button>
				</div>		
			</div>
		</div>
	</div>
</div>

</div>
<jsp:include page="Asset/Footer.jsp" />
</body>
</html>