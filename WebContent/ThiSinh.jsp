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

<div class="row main-nav">
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
			<%-- <bean:define id="kyThi" name="thiSinhActionForm" property="kyThi"></bean:define> --%>
			<bean:define id="maKyThi" name="kyThi" property="maKyThi"></bean:define>
			<a class="btn btn-success "data-toggle="modal" href="javascript:void(0)" onclick="taoThiSinh('${maKyThi}')">Thêm thí sinh</a>
			<a class="btn btn-danger" data-toggle="modal" href="javascript:void(0)" onclick="readFile('${maKyThi}')">Nhập bằng file</a>
			<div class="col-md-7 col-xs-6" style="float:right">
				<html:form action="/TimKiemThiSinh" styleClass="input-group" method="POST"> 				
			        <input type="text" id="menu_my_bootstrap_menu_settings_main_menu_search" value="search" class="btn form-control hidden">
			        <input class="form-control" type="text" size="9" name="search" style="border-radius: 5px 0 0 5px; height: 34px" placeholder="Nhập tên thí sinh, khu vực, đối tượng để tìm kiếm...">
					<span class="input-group-btn">
				        <button style="height: 34px;" for="menu_my_bootstrap_menu_settings_main_menu_search" type="submit" name="submit" value="submit" class="btn ">
						<i class="glyphicon glyphicon-search"></i></button>
			        </span>
				</html:form>
			</div>
			<div class="details_info">
				<p class="title" style="margin-top: 20px">DANH SÁCH CÁC THÍ SINH DỰ THI</p>
				<table id="table" class="table table-bordered table-hover table-striped">
					<thead>
						<tr>
							<th>STT</th>
							<th>Họ đệm</th>
							<th>Tên</th>
							<th>Ngày sinh</th>
							<th>Giới tính</th>
							<th>Khu vực</th>
							<th>Đối tượng</th>
							<th style="width: 92px;"></th>
						</tr>
					</thead>
						<bean:define id="stt" value="${(thiSinhActionForm.page-1)*10}"/>
					<tbody>
						<logic:iterate id="dsts" name="thiSinhActionForm" property="listThiSinh">	
						<tr>	
							<bean:define id="stt" value="${stt+1}"/>
							<td style="text-align: center">${stt}</td>
							<bean:define id="maThiSinh" name="dsts" property="maThiSinh"></bean:define>
							
							<td><bean:write name="dsts" property="hoDem"/></td>
							<td><bean:write name="dsts" property="ten"/></td>
							<td style="text-align: center"><bean:write name="dsts" property="ngaySinh"/></td>
							<logic:equal name="dsts" value="1" property="gioiTinh">
								<td style="text-align: center">Nam</td>
							</logic:equal>
							<logic:notEqual name="dsts" value="1" property="gioiTinh">
								<td style="text-align: center">Nữ</td>
							</logic:notEqual>
							<%-- <td style="text-align: center"><bean:write name="dsts" property="gioiTinh"/></td> --%>
							
							<td style="text-align: center"><bean:write name="dsts" property="khuVuc"/></td>
							<td style="text-align: center"><bean:write name="dsts" property="doiTuong"/></td>
							<td style="text-align: center">
							<a href="javascript:void(0)" onclick="suaThiSinh('${maKyThi}', '${maThiSinh}')" data-toggle="modal" class="icon icon-primary" title="Sửa thí sinh"><i class="glyphicon glyphicon-edit"></i></a> 
	                   		<a href="javascript:void(0)" onclick="xoaThiSinh('${maKyThi}', '${maThiSinh}')" data-toggle="modal" class="icon icon-danger" title="Xóa thí sinh"><i class="glyphicon glyphicon-trash"></i></a>
	                   		</td>	                    
						</tr>
						</logic:iterate>
					</tbody>
				</table>
				<div class="phan-trang text-center" id="phan-trang">
                <ul class="pagination" style="margin: 0">
                	
                </ul>
            	</div>
				<div class="totalCandidates">
					<p>Danh sách gồm có: <span> ${thiSinhActionForm.tong} </span> sinh viên.</p>
				</div>
			</div><!-- end details_info -->
		</div>
		<logic:notEmpty name="thiSinhActionForm" property="error">
			<div class="alert alert-warning">
				${thiSinhActionForm.error }
			</div>	
		</logic:notEmpty>
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
				<div class="form-group">
					<div class="col-md-7">
						<label class="col-md-3 no-pad" for="first-name">Họ đệm(*)</label>
							<div class="col-md-9 no-pad" style="padding-right: 0px; padding-left: 20px">
								<input type="text" class="form-control" id="f_hoDem" name="hoDem" required="required" onchange="this.value=this.value.trim()">
							</div>
					</div>
					<div class="col-md-5">		
						<label class="col-md-4 no-pad" for="last-name">Tên(*)</label>
						<div class="col-md-8 no-pad">
							<input type="text" class="form-control" id="f_ten" name="ten" required="required" onchange="this.value=this.value.trim()">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-7">		
						<label class="col-md-3 no-pad" for="birthday">Ngày sinh(*)</label>
						<div class="col-md-9" style="padding-right: 0px; padding-left: 20px">
							<input type="text" class="form-control" id="f_ngaySinh" name="ngaySinh" required="required" placeholder="Ví dụ: 02/11/1995">
						</div>
					
					</div>
					<div class="col-md-5">
							<label class="col-md-5 no-pad" for="gender">Giới tính(*)</label>
							<div class="col-md-7 no-pad" >
								<html:select styleClass="selectpicker form-control" property="gioiTinh" value="1">
									<html:option value="1">Nam</html:option>
									<html:option value="0">Nữ</html:option>
								</html:select>
								<%-- <html:radio property="gioiTinh" value="1" styleId="f_gioiTinh">Nam</html:radio>
								<html:radio property="gioiTinh" value="0" styleId="f_gioiTinh">Nữ</html:radio>	 --%>			
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
				   <div class="col-md-7">	
						<label class="col-md-3 no-pad" for="Subjects">Đối tượng(*)</label>
						<div class="col-md-9 no-pad" style="padding-left: 20px">
							<html:select styleId="f_doiTuong" property="doiTuong" styleClass="form-control" value="">
								<html:option value="KƯT">KƯT</html:option>	
								<html:option value="ƯT1">ƯT1</html:option>
								<html:option value="ƯT2">ƯT2</html:option>													
							</html:select>
					   </div>
				   </div>
				   <div class="col-md-5">
						<label class="col-md-4 no-pad" for="area">Khu vực(*)</label>
						<div class="col-md-8 no-pad">
							<html:select styleId="f_khuVuc" property="khuVuc" styleClass="form-control" value="KV3">
								<html:option value="KV3">Khu vực 3</html:option>
								<html:option value="KV2">Khu vực 2</html:option>
								<html:option value="KV2NT">Khu vực 2 - NT</html:option>	
								<html:option value="KV1">Khu vực 1</html:option>														
							</html:select>		               
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2" for="email">Email</label>
					<div class="col-md-10">
						<input type="email" class="form-control" id="f_email" name="email" maxlength="50" onchange="this.value=this.value.trim()">
					</div>
				</div>	
				<div class="form-group">
					<label class="col-md-2" for="phone">SĐT:</label>
					<div class="col-md-10">
						<input type="text" class="form-control" id="f_dienThoai" name="dienThoai" data-original-title="Chỉ chứa số" maxlength="11" onchange="this.value=this.value.trim()">
					</div>
				</div>	
				<div class="form-group" style="margin-right: 0px; margin-left: 0px;">
					<label class="" for="address">Địa chỉ liên hệ:</label>
					<textarea class="form-control" rows="3" cols="50" id="f_diaChi" name="diaChi" onchange="this.value=this.value.trim()"></textarea>
				</div>
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

<div class="modal fade" id="modal-file">
    <div class="modal-dialog">
        <div class="modal-content">
        	<html:form action="/NhapFile" styleId="upload" styleClass="form-horizontal" enctype="multipart/form-data">
        	<div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Nhập thí sinh bằng file excel</h4>
            </div>
            
             <div class="modal-body">
             	<input id="uploadfile" name="file" type="file">
             	<hr>
             	<p>Để dữ liệu thí sinh upload được đảm bảo đúng và không xảy ra lỗi, bạn nên làm theo mẫu.
             	Xem mẫu hướng dẫn ở đây</p>
             	<a href="Files/Template.xlsx">File mẫu</a>
             </div>
            </html:form>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>

<jsp:include page="Asset/Footer.jsp" />
	<script type="text/javascript">
        // Code javascript
        var numPage=${thiSinhActionForm.total};
        var currentPage=${thiSinhActionForm.page};
        loadPhanTrang("phan-trang");
        $("#uploadfile").change(function(){
    		document.forms.upload.submit();
    	});
    </script>
</body>
</html>