<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div class="thongtinkithi group-content">
		<div class="main-nav">
			
			<p class="title">THÔNG TIN KỲ THI</p>
			<form class="form-horizontal">
				<div class="form-group">
			   		<label class="control-label col-sm-2 pad-5">Tên kì thi:</label>
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
			      		<input type="text" class="form-control" id="ngaythi">
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
			    	<label class="control-label col-sm-2 pad-5">Danh sách các môn thi:</label>
			    	<div class="col-sm-4">
			      		<textarea class="form-control" rows="3"></textarea>
			   		 </div>
			  	</div>
			
			  	<div class="form-group"> 
			    	<div style="text-align: center">
			      		<button type="submit" class="btn btn-success btn-all">Thêm</button>
			      		<button type="submit" class="btn btn-success btn-all">Lưu</button>
			      		<button type="submit" class="btn btn-success btn-all">Xóa</button>
			    	</div>
			  	</div>
			</form>
		</div>
	</div>
	<div class="group-content">
	<div class="main-nav">
		<p class="title">THÔNG TIN KỲ THI</p>
		<div class="main-table">
			<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>Tên kì thi</th>
					<th>Ngành</th>
					<th>Thời gian thi</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>TUYỂN SINH ĐẠI HỌC</td>
					<td>Công nghệ thông tin</td>
					<td>22/7/2016</td>
				</tr>
				<tr>
					<td>TUYỂN SINH ĐẠI HỌC</td>
					<td>Toàn học</td>
					<td>22/7/2016</td>
				</tr>
				<tr>
					<td>TUYỂN SINH ĐẠI HỌC</td>
					<td>Điện tử viễn thông</td>
					<td>22/7/2016</td>
				</tr>
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