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
					<bean:define id="listMaKyThi" name="phongThiActionForm"></bean:define>
					<%@include file="Asset/ThongTinKyThi.jsp" %>
				</div>
			</div>
		</div>
		<div class="col-md-8">
			<div class="group-content">
				<%-- <bean:define id="kyThi" name="phongThiActionForm" property="kyThi"></bean:define> --%>
				<bean:define id="maKyThi" name="kyThi" property="maKyThi"></bean:define>
				<a class="btn btn-success" data-toggle="modal" href="javascript:void(0)" onclick="taoPhongThi('${maKyThi}')">Thêm phòng thi</a>
				
				<div class="details_info">
				<p class="title">DANH SÁCH PHÒNG THI</p>
				<table id="table" class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th>STT</th>	
								<th>Số hiệu phòng thi</th>						
								<th>Số lượng chỗ</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<bean:define id="stt" value="0"/>
							<logic:iterate id="dspt" name="phongThiActionForm" property="listPhongThi" >	
							<tr>
								<bean:define id="stt" value="${stt+1}"/>
								<td>${stt}</td>				
								<bean:define id="maPhongThi" name="dspt" property="maPhongThi"></bean:define>
								<td><bean:write name="dspt" property="soHieuPhongThi"/></td>
								<td class="soLuongThiSinh"><bean:write name="dspt" property="soLuongThiSinh" /></td>		
								<td>
								<a href="javascript:void(0)" onclick="suaPhongThi('${maKyThi}', '${maPhongThi}')" data-toggle="modal" class="icon icon-primary" title="Sửa phòng thi"><i class="glyphicon glyphicon-edit"></i></a>
								<a href="javascript:void(0)" onclick="xoaPhongThi('${maPhongThi}')" data-toggle="modal" class="icon icon-danger" title="Xóa phòng thi"><i class="glyphicon glyphicon-trash"></i></a></td>
							</tr>
							</logic:iterate>
						</tbody>
					</table>
					<div class="row">
						<div class="col-sm-9">
							Tổng: <span id="tongSoLuong"></span>/${phongThiActionForm.soLuongThiSinh} sinh viên.							
						</div>
						<div class="col-sm-3">
							<html:form action="/PhanPhongThi" method="POST">
								<input type="hidden" name="tongSoCho" id="tongSoCho"/>
								<button style="margin-left: 50px" type="submit" class="btn btn-success btn-all" name="bienChe" value="bienChe">Biên chế</button>
							</html:form>
						</div>
					</div>
				</div>
			</div>
			<logic:notEmpty name="phongThiActionForm" property="error">
				<div class="alert alert-danger">
				  ${phongThiActionForm.error }
				</div>	
			</logic:notEmpty>
		</div>
	</div>
</div>
<div class="modal fade" id="xoaPhongThi">
    <div class="modal-dialog">
        <div class="modal-content">
        	<html:form action="/XoaPhongThi" styleId="formDelete" styleClass="form-horizontal">
	        	<div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title">Xóa phòng thi</h4>
	            </div>
	            
	             <div class="modal-body">
	             	<p>Nếu xóa thì các dữ liệu liên quan sẽ mất.</p>
	             	<p>Bạn có chắc chắn xóa phòng thi này?</p>
	             </div>
	            
	            <div class="modal-footer">
	            	<button type="button" class="btn btn-default btn1" data-dismiss="modal">Hủy</button>
	            	<button type="submit" name="delete" value="delete" class="btn btn-danger">Đồng ý</button>
	            </div>
	        </html:form>
        </div>
    </div>
</div>
<div class="modal fade" id="modal-phongthi">
	<div class="modal-dialog">
		<div class="modal-content">
		<html:form action="/ThemPhongThi" styleId="formCreateEdit" styleClass="form-horizontal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">Thêm phòng thi</h4>
			</div>
			<div class="modal-body">
				<div class="row main-nav" >
				<p class="title">THÔNG TIN PHÒNG THI</p>
					<form>
						<div class="form-group row">
							<label class="col-md-3" for="first-name">Số hiệu phòng thi:</label>
							<div class="col-md-9">
								<input type="text" class="form-control" id="f_soHieuPhongThi" name="soHieuPhongThi">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-md-3" for="first-name">Số lượng chỗ:</label>
							<div class="col-md-9">
								<input type="number" class="form-control" id="f_soLuongThiSinh" name="soLuongThiSinh" min="0">
							</div>
						</div>
					</form>
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
<script type="text/javascript">
	$(document).ready(function(){
		<logic:notEmpty name="phongThiActionForm" property="notice">
			showNotice('${phongThiActionForm.notice}');
		</logic:notEmpty>
	});
	var x = $('#tongSoLuong').html();
	$('#tongSoCho').val(x);
</script>
</body>
</html>