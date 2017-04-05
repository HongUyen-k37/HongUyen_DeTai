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
<!-- //viết hàm js taoKyThi() -->
<br>
<a type="" class="btn btn-success" data-toggle="modal" href="#modal-id" onclick="taoKyThi()">Tạo kỳ thi</a>
<%--  <div id="search" class="col-md-5" style="float:right">
	<html:form action="" method="GET">   
    <div class="form-search search-only">
        <i class="search-icon glyphicon glyphicon-search"></i>
        <input type="text" name ="search" class="form-control search-query">
    </div>
    </html:form>
</div> --%>
	<div class="group-content">
	<div class="main-nav">
		<p class="title">DANH SÁCH CÁC KỲ THI</p>
		<div class="main-table">
			<table id="table" class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th>Tên kỳ thi</th>
						<th>Ngành</th>
						<th>Thời gian thi</th>
						 <th style="width: 92px;"></th>
					</tr>
				</thead>
				<tbody>
					<logic:iterate name="danhSachKyThiActionForm" property="listKyThi" id="dskt">
					<tr onclick="linkTo('makt',${dskt.maKyThi})">					
						<td style="display: none;"><bean:write name="dskt" property="maKyThi" /></td>
						<td><bean:write name="dskt" property="tenKyThi" /></td>
						<td><bean:write name="dskt" property="nganh" /></td>
						<td><bean:write name="dskt" property="ngayThi" />/<bean:write name="dskt" property="namTuyenSinh" /></td>
						<td>	                    
						<a href="#modal-id" onclick="suaKyThi('${maKyThi}')" data-toggle="modal" class="icon icon-primary" title="Sửa kỳ thi"><i class="fa fa-edit"></i></a> 
	                    <a href="#xoaKyThi"  data-toggle="modal" class="icon icon-danger" title="Xóa kỳ thi"><i class="fa fa-trash"></i></a>
	                    </td>
					</tr>
					</logic:iterate>
				</tbody>
			</table>
		</div>
	</div>
	</div>
</div>
</div>


<div class="modal fade" id="modal-id">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">Thêm Kỳ thi</h4>
			</div>
			<div class="modal-body">
				<div class="thongtinkithi">
						<p class="title">THÔNG TIN KỲ THI</p>
						<form class="form-horizontal">
							<div class="form-group">
						   		<label class="col-sm-2 pad-5">Tên kỳ thi:</label>
						    	<div class="col-sm-10">
						      		<input type="text" class="form-control" id="tenkithi">
						    	</div>
						  	</div>
							<div class="form-group row">
						    	<label class="control-label col-sm-2 pad-5" for="pwd">Năm tuyển sinh:</label>
						    	<div class="col-sm-4"> 
						      		<input type="number" class="form-control" id="namts" min="2015">
						    	</div>
						    	<label class="control-label col-sm-2 pad-5">Ngày thi:</label>
						    	<div class="col-sm-4">
						      		<input type="text" class="form-control" id="ngaythi" placeholder="Ví dụ: 02-11">
						    	</div>
						  	</div>
							<div class="form-group row">
						    	<label class="control-label col-sm-2 pad-5">Ngành:</label>
						    	<div class="col-sm-4">
						      		<select class="form-control">
										<option value="FPT">FPT</option>
										<option value="gosu">Gosu</option>
									</select>
						    	</div>
						    	<label class="control-label col-sm-2 pad-5">Hình thức đào tạo:</label>
						    	<div class="col-sm-4">
						    		<select class="form-control">
										<option value="dh">Đại học</option>
										<option value="ch">Cao học</option>
									</select>
					    		</div>
						  	</div>
						  	<div class="form-group">
						    	<label class="control-label col-sm-2 pad-5">Cơ sở liên kết đào tạo:</label>
						    	<div class="col-sm-10">
						      		<input type="text" class="form-control" id="cslkdt">
						    	</div>
						  	</div>
						  	<div class="form-group">
						    	<label class="control-label col-sm-2 pad-5">Danh sách môn thi:</label>
						    	<div class="col-sm-10">
						      		<input type="text" class="form-control" id="dsmt">
						    	</div>
						  	</div>
						</form>
					</div>
				</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
				<button type="button" class="btn btn-primary">Xóa</button>
				<button type="button" class="btn btn-success">Đồng ý</button>
			</div>
		</div>
	</div>
</div>
<jsp:include page="Asset/Footer.jsp" />
</body>
</html>