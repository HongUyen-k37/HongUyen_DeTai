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
				<%@include file="Asset/ThongTinKyThi2.jsp" %>
			</div>
		</div>
	</div>

	<div class="col-md-8">
		<div class="group-content">
			<a class="btn btn-success" data-toggle="modal" href="javascript:void(0)" onclick="taoThiSinh()">Thêm thí sinh</a>
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
						<logic:iterate id="dsts" name="thiSinhActionForm" property="listThiSinh">	
						<tr>	
							<bean:define id="stt" value="${stt+1}"/>
							<td>${stt}</td>				
							<%-- <bean:define id="maThiSinh" name="dsts" property="maThiSinh"></bean:define>
							<td><bean:write name="dsts" property="maThiSinh"/></td> --%>
							<%-- <tr onclick="linkTo('mats',${dsts.maThiSinh})"> --%>
							<bean:define id="maThiSinh" name="dsts" property="maThiSinh"></bean:define>
							<td><bean:write name="dsts" property="hoDem"/></td>
							<td><bean:write name="dsts" property="ten"/></td>
							<td><bean:write name="dsts" property="ngaySinh"/></td>
							<td><bean:write name="dsts" property="khuVuc"/></td>
							<td><bean:write name="dsts" property="doiTuong"/></td>
							<td>
							<a href="javascript:void(0)" onclick="suaThiSinh('${maThiSinh}')" data-toggle="modal" class="icon icon-primary" title="Sửa thí sinh"><i class="glyphicon glyphicon-edit"></i></a> 
	                   		<a href="XoaThiSinh.do?maThiSinh=${maThiSinh}" onclick="return confirm('Bạn chắc chắn muốn xóa tất cả thông tin về thí sinh này?')" class="icon icon-danger" title="Xóa thí sinh"><i class="glyphicon glyphicon-trash"></i></a>
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
<div class="modal fade" id="modal-thisinh">
	<div class="modal-dialog">
		<div class="modal-content">
		<html:form action="/ThemThiSinh" styleId="formCreateEdit" styleClass="form-horizontal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">Thêm thí sinh</h4>
			</div>
			<div class="modal-body">
				<div class="row main-nav" >
				<p class="title">THÔNG TIN THÍ SINH DỰ THI</p>
				<div>
					<div class="col-md-7">
						<div class="form-group">
							<label class="col-md-3 no-pad" for="first-name">Họ đệm:</label>
							<div class="col-md-9">
								<input type="text" class="form-control" id="f_hoDem" name="hoDem">
							</div>
						</div>	
					</div>
					<div class="col-md-5">
						<div class="form-group">
							<label class="col-md-4 no-pad" for="last-name">Tên:</label>
							<div class="col-md-8 no-pad">
								<input type="text" class="form-control" id="f_ten" name="ten">
							</div>
						</div>
					</div>
				</div>
					<div class="form-group">
						<label class="col-md-2" for="birthday-place">Nơi sinh:</label>
						<div class="col-md-10">
							<input type="text" class="form-control" id="f_noiSinh" name="noiSinh">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2" for="birthday">Ngày sinh:</label>
						<div class="col-md-10">
							<input type="text" class="form-control" id="f_ngaySinh" name="ngaySinh">
						</div>
					</div>
					<div class="col-md-7">
						<div class="form-group">
							<label class="col-md-3 no-pad" for="Subjects">Đối tượng:</label>
							<div class="col-md-9">
								<input type="text" class="form-control" id="f_doiTuong" name="doiTuong">
							</div>
						</div>
					</div>
					<div class="col-md-5">
						<div class="form-group">
							<label class="col-md-4 no-pad" for="area">Khu vực:</label>
							<div class="col-md-8 no-pad">
						<!-- 		<select class="form-control" id="f_khuVuc" name="khuVuc">
									<option value="f_khuVuc">Khu vực 1</option>	
									<option value="f_khuVuc">Khu vực 2-NT</option>	
									<option value="f_khuVuc">Khu vực 2</option>	
									<option value="f_khuVuc">Khu vực 3</option>	
									
								</select> -->
								<%-- <html:select property="khuVuc" styleId="f_khuVuc" styleClass="form-control">
									<html:option value="KV1">Khu vực 1</html:option>
									<html:option value="KV2">Khu vực 2</html:option>
									<html:option value="KV2NT">Khu vực 2 - NT</html:option>
									<html:option value="KV3">Khu vực 3</html:option>
		                    </html:select> --%>
		                    <input type="text" class="form-control" id="f_khuVuc" name="khuVuc">
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2" for="email">Email:</label>
						<div class="col-md-10">
							<input type="text" class="form-control" id="f_email" name="email">
						</div>
					</div>
				
						
					<div class="form-group">
						<label class="col-md-2" for="phone">SĐT:</label>
						<div class="col-md-10">
							<input type="text" class="form-control" id="f_dienThoai" name="dienThoai">
						</div>
					</div>	
					<div class="form-group" style="margin-right: 0px; margin-left: 0px;">
						<label class="" for="address">Địa chỉ liên hệ:</label>
						<textarea class="form-control" rows="3" cols="50" id="f_diaChi" name="diaChi"></textarea>
					</div>
			
		
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
				<button type="reset" name="resetForm" onclick="clearCheckbox()" class="btn btn-warning">Xóa</button>
				<button type="submit" name="submit" value="submit" class="btn btn-success">Đồng ý</button>
			</div>
			</div>
			</div>
		</html:form>
		</div>
	</div>
</div>
<jsp:include page="Asset/Footer.jsp" />
</body>
</html>