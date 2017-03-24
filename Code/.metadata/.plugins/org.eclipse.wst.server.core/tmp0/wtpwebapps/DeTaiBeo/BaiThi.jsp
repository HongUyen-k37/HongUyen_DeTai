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
	<div class="col-md-4 no-pad">
		<div class="thongtinkithi group-content">
			<div class="main-nav">
				<jsp:include page="Asset/ThongTinKyThi.jsp" />
			</div>
		</div>
	</div>
	<div class="col-md-8">
		<div class="group-content">
			<div class="row main-nav">
			<p class="title">XỬ LÝ BÀI THI</p>
		<h6><b>Phòng thi</b></h6>
		<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>Số hiệu phòng thi</th>
					<th>Số lượng</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>01</td>
					<td>25</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="details_info">
		<p class="title">DANH SÁCH CÁC THÍ SINH DỰ THI</p>
		<div class="main-list">
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
			<tbody>
				<tr>
					<td>1</td>
					<td>001</td>
					<td>Trần Thị Hồng</td>
					<td>Uyên</td>
					<td>02/11/1995</td>
					<td>
						<select class="form-control">
							<option value="vangthi">Dự thi</option>
							<option value="dinhchi">Khiển trách</option>
							<option value="dinhchi">Cảnh cáo</option>
							<option value="dinhchi">Đình chỉ thi</option>						
							<option value="dinhchi">Vắng thi</option>
						</select>
					</td>
				</tr>
			</tbody>
			</table>
			<div class="col-sm-10">
					<p>Danh sách gồm có: <span> 50/100 </span> sinh viên</p>
			</div>
			<div class="btn-group">
				<button type="submit" class="btn btn-success btn-all" name='execute'>In Danh sách</button>
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