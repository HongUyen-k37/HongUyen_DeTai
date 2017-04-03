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
					<p class="title">DANH SÁCH PHÒNG THI</p>
					<form>
						<div class="form-group row">
							<label class="col-md-3" for="first-name">Số hiệu phòng thi:</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="soHieuPhongThi">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-md-3" for="first-name">Tên phòng thi:</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="tenPhongThi">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-md-3" for="first-name">Số lượng thí sinh:</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="soLuongThiSinh">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-md-3" for="first-name">Ghi chú:</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="ghiChu">
							</div>
						</div>
					</form>
				<div class="btn-gr">
					<button type="submit" class="btn btn-success btn-all" name="add">Thêm</button>
					<button type="submit" class="btn btn-success btn-all" name="update">Lưu</button>
				</div>
				</div>
				<div class="details_info">
					<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th>Mã phòng thi</th>
								<th>Tên phòng thi</th>
								<th>Số lượng</th>
								<th>Ghi chú</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>P1</td>
								<td>Phòng 1</td>
								<td>30</td>
								<td>Không</td>
							</tr>
							<tr>
								<td>P1</td>
								<td>Phòng 1</td>
								<td>30</td>
								<td>Không</td>
							</tr>
							<tr>
								<td>P1</td>
								<td>Phòng 1</td>
								<td>30</td>
								<td>Không</td>
							</tr>
						</tbody>
					</table>
					<div class="row">
						<div class="col-sm-5 col-md-offset-6">
							Tổng: <span> 90/100 </span> sinh viên
							<button style="margin-left: 50px" type="submit" class="btn btn-success btn-all" name='bienche'>Biên chế</button>
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