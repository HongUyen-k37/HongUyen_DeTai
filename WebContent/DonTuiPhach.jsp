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
		<p class="title">DỒN TÚI</p>
		<div class="col-sm-6 col-sm-offset-3">
			<label class="col-sm-3">Môn thi:</label>
    		<div class="col-sm-9">
	    		<html:select property="maMonThi" name="baiThiActionForm" styleId="f_maMonThi" styleClass="form-control" onchange="getTKBangDiemTheoMon()">
                	<html:optionsCollection name="baiThiActionForm" property="listMonThi" label="tenMonThi" value="maMonThi"/>
	            </html:select>
            </div>
		</div>
		<div class="row">
		<html:form action="/DonTuiPhach" method="post">
			<div class="col-md-5 form-group">
				<label class="col-md-5">Cơ số phòng:</label>
				<div class="col-md-7">
					<input type="number" class="form-control" name="coSoPhong" min="1" value="${baiThiActionForm.coSoPhong}">
				</div>
			</div>
			<div class="col-md-5 form-group">
				<label class="col-md-5">Cơ số túi:</label>
				<div class="col-md-7 no-pad">
					<input type="number" class="form-control" name="coSoTui" min="1" value="${baiThiActionForm.coSoTui}">
				</div>
			</div>
			<div class="btn-gr col-md-2">
				<button type="submit" class="btn btn-success btn-all" name="cal" value="cal">Tính số lượt</button>
			</div>
			</html:form>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="col-md-3 form-group">
					<label>Lượt:</label>
				</div>
				<div class="col-md-9">
					<input class="form-control" type="number" name="luot">
				</div>
			</div>
			<div class="col-md-5">
				<div class="col-md-6 no-pad form-group">
					<label>/Số lượt thực hiện: ${baiThiActionForm.soLuot}</label>
				</div>
				<div class="col-md-6 no-pad">
				</div>	
			</div>
			<div class="col-md-2">
				<button style="width: 96px" type="submit" class="btn btn-success btn-all" name="execute">Thực hiện</button>
			</div>
		</div>
	</div>
		<div class="details_info">
			<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th></th>
					<th colspan="2">Phòng 1</th>
					<th colspan="2">Phòng 2</th>
					<th colspan="2">Phòng 3</th>
					<th colspan="2">Phòng 4</th>
					<th colspan="2">Phòng 5</th>
				</tr>
			</thead>
			<thead>
				<tr>
					<th></th>
					<th>SBD</th>
					<th>Số phách</th>
					<th>SBD</th>
					<th>Số phách</th>
					<th>SBD</th>
					<th>Số phách</th>
					<th>SBD</th>
					<th>Số phách</th>
					<th>SBD</th>
					<th>Số phách</th>
				</tr>
			</thead>
			<tbody>
			<thead>
				<tr>
					<th>Túi 1</th>
						<td>001</td>
						<td>167</td>
						<td>002</td>
						<td>168</td>
						<td>003</td>
						<td>169</td>
						<td>004</td>
						<td>170</td>
						<td>005</td>
						<td>171</td>
				</tr>
			</thead>
			<thead>
				<tr>
					<th></th>
						<td>001</td>
						<td>167</td>
						<td>002</td>
						<td>168</td>
						<td></td>
						<td></td>
						<td>004</td>
						<td>170</td>
						<td>005</td>
						<td>171</td>
				</tr>
			</thead>
			<thead>
				<tr>
					<th></th>
						<td>001</td>
						<td>167</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>004</td>
						<td>170</td>
						<td></td>
						<td></td>
				</tr>
			</thead>
			<thead>
				<tr>
					<th>Túi 2</th>
						<td>001</td>
						<td>167</td>
						<td>002</td>
						<td>168</td>
						<td>003</td>
						<td>169</td>
						<td>004</td>
						<td>170</td>
						<td>005</td>
						<td>171</td>
				</tr>
			</thead>
			<thead>
				<tr>
					<th>Túi 3</th>
						<td>001</td>
						<td>167</td>
						<td>002</td>
						<td>168</td>
						<td>003</td>
						<td>169</td>
						<td>004</td>
						<td>170</td>
						<td>005</td>
						<td>171</td>
				</tr>
			</thead>
			<thead>
				<tr>
					<th>Túi 4</th>
						<td>001</td>
						<td>167</td>
						<td>002</td>
						<td>168</td>
						<td>003</td>
						<td>169</td>
						<td>004</td>
						<td>170</td>
						<td>005</td>
						<td>171</td>
				</tr>
			</thead>
			</tbody>
			</table>
			<div class="row">
				<p class="col-md-10">Danh sách gồm có: <span> 50/100 </span> sinh viên</p>
				<div class="col-md-2"><button type="submit" class="btn btn-success btn-all" name="execute">In dồn túi</button></div>
			</div>
		</div>
	</div>
</div>
</div>

</div>
<jsp:include page="Asset/Footer.jsp" />
</body>
</html>