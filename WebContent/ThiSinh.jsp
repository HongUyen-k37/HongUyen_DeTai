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
				<bean:define id="listMaKyThi" name="thiSinhActionForm"></bean:define>
				<%@include file="Asset/ThongTinKyThi.jsp" %>
			</div>
		</div>
	</div>

	<div class="col-md-8">
		<div class="group-content">
			<bean:define id="kyThi" name="thiSinhActionForm" property="kyThi"></bean:define>
			<bean:define id="maKyThi" name="kyThi" property="maKyThi"></bean:define>
			<a class="btn btn-success" data-toggle="modal" href="javascript:void(0)" onclick="taoThiSinh('${maKyThi}')">Thêm thí sinh</a>
			<div class="col-md-4 col-xs-6" style="float:right">
				<html:form action="/TimKiemThiSinh" styleClass="input-group" method="POST"> 				
			        <input type="text" id="menu_my_bootstrap_menu_settings_main_menu_search" value="search" class="btn form-control hidden">
			        <input class="form-control" type="text" size="9" name="search" style="border-radius: 5px 0 0 5px; height: 34px" placeholder="Nhập tên thí sinh, khu vực để tìm kiếm..">
					<span class="input-group-btn">
				        <button style="height: 34px;" for="menu_my_bootstrap_menu_settings_main_menu_search" type="submit" name="submit" value="submit" class="btn ">
						<i class="glyphicon glyphicon-search"></i></button>
			        </span>
				</html:form>
			</div>
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
							<bean:define id="maThiSinh" name="dsts" property="maThiSinh"></bean:define>
							<td><bean:write name="dsts" property="hoDem"/></td>
							<td><bean:write name="dsts" property="ten"/></td>
							<td><bean:write name="dsts" property="ngaySinh"/></td>
							<td><bean:write name="dsts" property="khuVuc"/></td>
							<td><bean:write name="dsts" property="doiTuong"/></td>
							<td>
							<a href="javascript:void(0)" onclick="suaThiSinh('${maKyThi}', '${maThiSinh}')" data-toggle="modal" class="icon icon-primary" title="Sửa thí sinh"><i class="glyphicon glyphicon-edit"></i></a> 
	                   		<a href="javascript:void(0)" onclick="xoaThiSinh('${maThiSinh}')" data-toggle="modal" class="icon icon-danger" title="Xóa thí sinh"><i class="glyphicon glyphicon-trash"></i></a>
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
<div class="modal fade" id="xoaThiSinh">
    <div class="modal-dialog">
        <div class="modal-content">
        	<html:form action="/XoaPhongThi" styleId="formDelete" styleClass="form-horizontal">
	        	<div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title">Xóa thí sinh</h4>
	            </div>
	            
	             <div class="modal-body">
	             	<p>Nếu xóa thì các dữ liệu liên quan sẽ mất.</p>
	             	<p>Bạn có chắc chắn xóa thí sinh này?</p>
	             </div>
            
	            <div class="modal-footer">
	            	<button type="button" class="btn btn-default btn1" data-dismiss="modal">Hủy</button>
	            	<button type="submit" name="delete" value="delete" class="btn btn-danger">Đồng ý</button>
	            </div>
            </html:form>
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
							<label class="col-md-3 no-pad" for="first-name">Họ đệm(*)</label>
							<div class="col-md-9">
								<input type="text" class="form-control" id="f_hoDem" name="hoDem" required="required" onchange="this.value=this.value.trim()">
							</div>
						</div>	
					</div>
					<div class="col-md-5">
						<div class="form-group">
							<label class="col-md-4 no-pad" for="last-name">Tên(*)</label>
							<div class="col-md-8 no-pad">
								<input type="text" class="form-control" id="f_ten" name="ten" required="required" onchange="this.value=this.value.trim()">
							</div>
						</div>
					</div>
				</div>
					<div class="form-group">
						<label class="col-md-2"  for="birthday-place">Nơi sinh</label>
						<div class="col-md-10">
							<input type="text" class="form-control" id="f_noiSinh" name="noiSinh" onchange="this.value=this.value.trim()">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2" style="padding-right:0;" for="birthday">Ngày sinh(*)</label>
						<div class="col-md-10">
							<input type="text" class="form-control" id="f_ngaySinh" name="ngaySinh" required="required" placeholder="Ví dụ: 02/11/1995" title="Vui lòng nhập đúng Ngày sinh quy định." pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}" >
						</div>
					</div>
					<div class="col-md-7">
						<div class="form-group">
							<label class="col-md-3 no-pad" for="Subjects">Đối tượng(*)</label>
							<div class="col-md-9">
								<html:select styleId="f_doiTuong" property="doiTuong" styleClass="form-control" value="">
									<html:option value=""></html:option>	
									<html:option value="01">01</html:option>
									<html:option value="02">02</html:option>													
								</html:select>
							</div>
						</div>
					</div>
					<div class="col-md-5">
						<div class="form-group">
							<label class="col-md-4 no-pad" for="area">Khu vực(*)</label>
							<div class="col-md-8 no-pad">
								<html:select styleId="f_khuVuc" property="khuVuc" styleClass="form-control" value="">
									<html:option value="KV1">Khu vực 1</html:option>	
									<html:option value="KV2">Khu vực 2</html:option>
									<html:option value="KV2NT">Khu vực 2 - NT</html:option>	
									<html:option value="KV3">Khu vực 3</html:option>													
								</html:select>		               
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2" for="email">Email(*)</label>
						<div class="col-md-10">
							<input type="email" class="form-control" id="f_email" name="email" required="required" maxlength="50" onchange="this.value=this.value.trim()">
						</div>
					</div>
				
						
					<div class="form-group">
						<label class="col-md-2" for="phone">SĐT:</label>
						<div class="col-md-10">
							<input type="text" class="form-control" id="f_dienThoai" name="dienThoai" data-original-title="Chỉ chứa số, độ dài từ 10-12 số" maxlength="12" pattern="[0-9]{10,12}" onchange="this.value=this.value.trim()">
						</div>
					</div>	
					<div class="form-group" style="margin-right: 0px; margin-left: 0px;">
						<label class="" for="address">Địa chỉ liên hệ:</label>
						<textarea class="form-control" rows="3" cols="50" id="f_diaChi" name="diaChi" onchange="this.value=this.value.trim()"></textarea>
					</div>
            <label><i>(*): Thông tin bắt buộc</i></label>
			<div class="modal-footer">
				<button type="button" class="btn btn-default btn1" data-dismiss="modal">Hủy</button>
				<button type="reset" name="resetForm" onclick="clearCheckbox()" class="btn btn-warning btn1">Xóa</button>
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