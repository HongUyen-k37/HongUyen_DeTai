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
				<jsp:include page="Asset/ThongTinKyThi.jsp" />
			</div>
		</div>
	</div>
	<br>
	<div class="col-md-8">
		<div class="group-content">
			<a class="btn btn-success" data-toggle="modal" href='#modal-id'>Thêm thí sinh</a>
			
		<!-- 	<div class="row main-nav" >
				<p class="title">THÔNG TIN THÍ SINH DỰ THI</p>
				<form action="" class="form-horizontal" method="POST">
					<div class="col-md-7">
						<div class="form-group">
							<label class="col-md-2 no-pad" for="first-name">Họ đệm:</label>
							<div class="col-md-10">
								<input type="text" class="form-control" name="first-name">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 no-pad" for="birthday-place">Nơi sinh:</label>
							<div class="col-md-10">
								<input type="text" class="form-control" name="birthday-place">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 no-pad" for="Subjects">Đối tượng:</label>
							<div class="col-md-10">
								<input type="text" class="form-control" name="">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 no-pad" for="email">Email:</label>
							<div class="col-md-10">
								<input type="text" class="form-control" name="email">
							</div>
						</div>
					</div>
					<div class="col-md-5 pad-5">
						<div class="form-group">
							<label class="col-md-4 no-pad" for="last-name">Tên:</label>
							<div class="col-md-8 ">
								<input type="text" class="form-control" name="last-name">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 no-pad" for="birthday">Ngày sinh:</label>
							<div class="col-md-8 ">
								<input type="text" class="form-control" name="birthday">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 no-pad" for="area">Khu vực:</label>
							<div class="col-md-8 ">
								<select class="form-control" name="area">
									<option value="">Khu vực 1</option>
									<option value="">Khu vực 2</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 no-pad" for="phone">Số điện thoại:</label>
							<div class="col-md-8">
								<input type="text" class="form-control" name="phone">
							</div>
						</div>
					</div>
				</form>
			</div> 
		<div class="main-nav">
			<label for="address">Địa chỉ liên hệ:</label>
			<textarea class="form-control" rows="4" cols="100" name="address"></textarea>
		</div>
		<div class="btn-gr">
			<button type="submit" class="btn btn-success btn-all" name='add'>Thêm</button>
			<button type="submit" class="btn btn-success btn-all" name='update'>Lưu</button>
			<button type="submit" class="btn btn-success btn-all" name='delete'>Xoá</button>
		</div>
		--><!-- end form-->
		<div class="details_info">
			<p class="title">DANH SÁCH CÁC THÍ SINH DỰ THI</p>
			<table id="table" class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th>STT</th>
						<th>Họ đệm</th>
						<th>Tên</th>
						<th>Ngày sinh</th>
						<th>Khu vực</th>
						<th>Đối tượng</th>
						<th style="width: 92px;"></th>
					</tr>
				</thead>
				<bean:define id="stt" value="0"/>
				<tbody>
					<logic:iterate name="danhSachThiSinhActionForm" property="listThiSinh" id="dsts">
					<bean:define id="stt" value="${stt+1}"/>
					<tr onclick="linkTo('mats',${dsts.maThiSinh})">
						<td>${stt}</td>
						<td><bean:write name="dsts" property="hoDem"/></td>
						<td><bean:write name="dsts" property="ten"/></td>
						<td><bean:write name="dsts" property="ngaySinh"/></td>
						<td><bean:write name="dsts" property="khuVuc"/></td>
						<td><bean:write name="dsts" property="doiTuong"/></td>
						<td>	                    
						<a href="#modal-id" onclick="suaThiSinh('${maThiSinh}')" data-toggle="modal" class="icon icon-primary" title="Sửa kỳ thi"><i class="fa fa-edit"></i></a> 
	                    <a href="#xoaThiSinh"  data-toggle="modal" class="icon icon-danger" title="Xóa thí sinh"><i class="fa fa-trash"></i></a>
	                    </td>
					</tr>
					</logic:iterate>
				</tbody>
			</table>
			<div class="totalCandidates">
				<p>Danh sách gồm có: <span> ${stt} </span> sinh viên.</p>
			</div>
		</div><!-- end details_info -->
		</div>
		</div>
	</div>
</div>
<div class="modal fade" id="modal-id">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">Thêm thí sinh</h4>
			</div>
			<div class="modal-body">
				<div class="row main-nav" >
				<p class="title">THÔNG TIN THÍ SINH DỰ THI</p>
				<form action="" class="form-horizontal" method="POST">
					<div class="col-md-7">
						<div class="form-group">
							<label class="col-md-2 no-pad" for="first-name">Họ đệm:</label>
							<div class="col-md-10">
								<input type="text" class="form-control" name="first-name">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 no-pad" for="birthday-place">Nơi sinh:</label>
							<div class="col-md-10">
								<input type="text" class="form-control" name="birthday-place">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 no-pad" for="Subjects">Đối tượng:</label>
							<div class="col-md-10">
								<input type="text" class="form-control" name="">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 no-pad" for="email">Email:</label>
							<div class="col-md-10">
								<input type="text" class="form-control" name="email">
							</div>
						</div>
					</div>
					<div class="col-md-5 pad-5">
						<div class="form-group">
							<label class="col-md-4 no-pad" for="last-name">Tên:</label>
							<div class="col-md-8 ">
								<input type="text" class="form-control" name="last-name">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 no-pad" for="birthday">Ngày sinh:</label>
							<div class="col-md-8 ">
								<input type="text" class="form-control" name="birthday">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 no-pad" for="area">Khu vực:</label>
							<div class="col-md-8 ">
								<select class="form-control" name="area">
									<option value="">Khu vực 1</option>
									<option value="">Khu vực 2</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 no-pad" for="phone">Số điện thoại:</label>
							<div class="col-md-8">
								<input type="text" class="form-control" name="phone">
							</div>
						</div>	
					</div>
					<div class="main-nav">
						<label for="address">Địa chỉ liên hệ:</label>
						<textarea class="form-control" rows="4" cols="100" name="address"></textarea>
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