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
				<p class="title">XÁC ĐỊNH ĐIỂM CHUẨN</p>
				<div class="row">
				<div class="col-md-6 form-group">
					<label class="col-md-4">Điểm liệt:</label>
					<div class="col-md-8">
						<input type="number" class="form-control" name="diemliet">
					</div>
				</div>
				<div class="col-sm-6 form-group">
						<input type="radio" name="" checked><label>Bằng hoặc nhỏ hơn điểm liệt</label><br>
						<input type="radio" name=""><label>Nhỏ hơn điểm liệt</label>
				</div>
				</div>
				<div class="form-group row">
					<label class="col-md-6" style="padding-left: 30px;">Điểm chuẩn cho khu vực 3 - không ưu tiên:</label>
					<div class="col-md-6">
						<input type="number" class="form-control" name="diemchuan">
					</div>
				</div>
				<div class="btn-gr">
					<button type="submit" class="btn btn-success btn-all" name="kt">Kiểm tra</button>
				</div>
			</div>
			<div class="details_info">
				<table class="table table-bordered table-hover table-striped">
							<thead>
								<tr>
									<th>KV - Đối tượng</th>
									<th>Điểm</th>
									<th>Số TS Đạt</th>
									<th>Số TS Không Đạt</th>
									<th>Số TS Bị Điểm Liệt</th>
									<th>Tổng</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Khu vực 3 - KUT</td>
									<td>15.0</td>
									<td>20</td>
									<td>1</td>
									<td>0</td>
									<td>21</td>
								</tr>
								<tr>
									<td>Khu vực 3 - KUT</td>
									<td>15.0</td>
									<td>20</td>
									<td>1</td>
									<td>0</td>
									<td>21</td>
								</tr>
								<tr>
									<td>Khu vực 3 - KUT</td>
									<td>15.0</td>
									<td>20</td>
									<td>1</td>
									<td>0</td>
									<td>21</td>
								</tr>
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