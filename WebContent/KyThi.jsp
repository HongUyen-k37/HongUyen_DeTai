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
<br>
<a type="" class="btn btn-success" data-toggle="modal" href="javascript:void(0)" onclick="taoKyThi()" >Tạo kỳ thi</a>
	<div class="col-md-4 col-xs-6" style="float:right">
	<html:form action="/TimKiemKyThi" styleClass="input-group" method="POST"> 
	
        <input type="text" id="menu_my_bootstrap_menu_settings_main_menu_search" value="search" class="btn form-control hidden">
        <input class="form-control" type="text" size="9" name="search" style="border-radius: 5px 0 0 5px" placeholder="Nhập tên kỳ thi, ngành để tìm kiếm..">
		<span class="input-group-btn">
	        <button style="height: 34px;" for="menu_my_bootstrap_menu_settings_main_menu_search" type="submit" name="submit" value="submit" class="btn ">
			<i class="glyphicon glyphicon-search"></i></button>
        </span>
	
	</html:form>
	</div>
	<div class="group-content">
	<div class="main-nav">
		<p class="title">DANH SÁCH CÁC KỲ THI</p>
		<div class="main-table">
			<table id="table" class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th>STT</th>
						<th>Tên kỳ thi</th>
						<th>Ngành</th>
						<th>Thời gian thi</th>
						 <th style="width: 92px;"></th>
					</tr>
				</thead>
					<bean:define id="stt" value="0"/>
				<tbody>
					<logic:iterate name="kyThiActionForm" property="listKyThi" id="dskt">
					<tr>
						<bean:define id="stt" value="${stt+1}"/>
						<td>${stt}</td>	
						<bean:define id="maKyThi" name="dskt" property="maKyThi"></bean:define>
						<td><bean:write name="dskt" property="tenKyThi" /></td>
						<td><bean:write name="dskt" property="nganh" /></td>
						<td><bean:write name="dskt" property="ngayThi" />/<bean:write name="dskt" property="namTuyenSinh" /></td>
						<td>	                    
						<a href="javascript:void(0)" onclick="suaKyThi('${maKyThi}')" data-toggle="modal" class="icon icon-primary" title="Sửa kỳ thi"><i class="glyphicon glyphicon-edit"></i></a> 
	                    <a href="javascript:void(0)" onclick="xoaKyThi('${maKyThi}')" data-toggle="modal" class="icon icon-danger" title="Xóa kỳ thi"><i class="glyphicon glyphicon-trash"></i></a></td>
						</tr>
					</logic:iterate>
				</tbody>
			</table>
		</div>
	</div>
	</div>
</div>
</div>

<div class="modal fade" id="xoaKyThi">
    <div class="modal-dialog">
        <div class="modal-content">
        	<html:form action="/XoaPhongThi" styleId="formDelete" styleClass="form-horizontal">
	        	<div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title">Xóa kỳ thi</h4>
	            </div>
	            
	             <div class="modal-body">
	             	<p>Nếu xóa thì các dữ liệu liên quan sẽ mất. Việc làm của bạn sẽ ảnh hưởng đến thông tin và điểm số của các thí sinh.</p>
	             	<p>Bạn có bỏ chọn <b>Hoạt động</b> thay vì xóa kỳ thi.</p>
	             	<p>Bạn có chắc chắn xóa kỳ thi này?</p>
	             </div>
	            
	            <div class="modal-footer">
	            	<button type="button" class="btn btn-default btn1" data-dismiss="modal">Hủy</button>
	            	<button type="submit" name="delete" value="delete" class="btn btn-danger">Đồng ý</button>
	            </div>
            </html:form>
        </div>
    </div>
</div>


<div class="modal fade" id="modal-kythi">
	<div class="modal-dialog">
		<div class="modal-content">
		<html:form action="/ThemKyThi" styleId="formCreateEdit" styleClass="form-horizontal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">Thêm Kỳ thi</h4>
			</div>
			<div class="modal-body">
			<div class="row main-nav" >
						<p class="title">THÔNG TIN KỲ THI</p>
							<div class="form-group">
						   		<label class="col-sm-2 pad-5">Tên kỳ thi(*)</label>
						    	<div class="col-sm-10">
						      		<input type="text" class="form-control" id="f_tenKyThi" name="tenKyThi" required onchange="this.value=this.value.trim()">
						    	</div>
						  	</div>
							<div class="form-group row">
							<label class="control-label col-sm-2 pad-5">Ngày thi(*)</label>
						    	<div class="col-sm-4">
						      		<input type="text" class="form-control" id="f_ngayThi" name="ngayThi" min="0">
						    	</div>
						    	<label class="control-label col-sm-3 pad-5">Năm tuyển sinh(*)</label>
						    	<div class="col-sm-3"> 
						      		<input type="number" class="form-control" id="f_namTuyenSinh" name="namTuyenSinh" min="2015" required data-original-title="Chỉ chứa số" maxlength="4">
						    	</div>
						    	
						  	</div>
							<div class="form-group row">
						    	<label class="control-label col-sm-2 pad-5">Ngành(*)</label>
						    	<div class="col-sm-10">
									<html:select  styleId="f_nganh" property="nganh" styleClass="form-control">
										<html:option value="Hán - Nôm">Hán - Nôm</html:option>
										<html:option value="Ngôn ngữ học">Ngôn ngữ học</html:option>
										<html:option value="Văn học">Văn học</html:option>
										<html:option value="Kỹ thuật địa chất">Kỹ thuật địa chất</html:option>						
										<html:option value="Địa chất học">Địa chất học</html:option>
										<html:option value="Kỹ thuật trắc địa - Bản đồ">Kỹ thuật trắc địa - Bản đồ</html:option>
										<html:option value="Toán ứng dụng">Toán ứng dụng</html:option>
										<html:option value="Toán học">Toán học</html:option>
										<html:option value="Địa lý tự nhiên">Địa lý tự nhiên</html:option>						
										<html:option value="Quản lý tài nguyên và môi trường">Quản lý tài nguyên và môi trường</html:option>
										<html:option value="Lịch sử">Lịch sử</html:option>
										<html:option value="Đông phương học">Đông phương học</html:option>
										<html:option value="Xã hội học">Xã hội học</html:option>
										<html:option value="Báo chí">Báo chí</html:option>						
										<html:option value="Sinh học">Sinh học</html:option>
										<html:option value="Công nghệ sinh học">Công nghệ sinh học</html:option>
										<html:option value="Vật lý học">Vật lý học</html:option>
										<html:option value="Hóa học">Hóa học</html:option>
										<html:option value="Khoa học môi trường">Khoa học môi trường</html:option>						
										<html:option value="Triết học">Triết học</html:option>
										<html:option value="Công nghệ thông tin">Công nghệ thông tin</html:option>
										<html:option value="CN kỹ thuật điện tử - Truyền thông">CN kỹ thuật điện tử - Truyền thông</html:option>
										<html:option value="Kiến trúc">Kiến trúc</html:option>
										<html:option value="Công tác xã hội">Công tác xã hội</html:option>						
									</html:select>			
						      		<!-- <input type="text" class="form-control" id="f_nganh" name="nganh" required onchange="this.value=this.value.trim()"> -->
						    	</div>
						    </div>
						    <div class="form-group row">
						    	<label class="control-label col-sm-4 pad-5">Hình thức đào tạo(*)</label>
						    	<div class="col-sm-8" style="padding-left: 0;">
						    		<html:select styleId="f_hinhThucDT" property="hinhThucDT" styleClass="form-control">
										<html:option value="Đại học - Vừa làm vừa học">Đại học - Vừa làm vừa học</html:option>
										<html:option value="Liên thông Cao đẳng lên Đại học - Vừa học vừa làm">Liên thông Cao đẳng lên Đại học - Vừa học vừa làm</html:option>
										<html:option value="Bằng thứ 2 - Vừa học vừa làm">Bằng thứ 2 - Vừa học vừa làm</html:option>					
									</html:select>	
						    		<!-- <input type="text" class="form-control" id="f_hinhThucDT" name="hinhThucDT" required> -->
					    		</div>
						  	</div>
						  	<div class="form-group row">
						    	<label class="control-label col-sm-4 pad-5">Cơ sở liên kết đào tạo</label>
						    	<div class="col-sm-8" style="padding-left: 0;">
						      		<input type="text" class="form-control" id="f_coSoLKDT" name="coSoLKDT">
						    	</div>
						  	</div>
						  	
						  	<div class="form-group row"><hr>
							  	<p class="title">DANH SÁCH MÔN THI</p>
							  	<!-- <label class="control-label col-sm-6" >Số môn thi <i id="soMonThi" name="soMonThi">0</i></label> -->
						  		<label class="control-label col-sm-7">Tên môn thi</label>
						  		<label class="control-label col-sm-5">Hệ số</label>
						  	</div>
						  	
						  	<div class="form-group row monthi">
						    	<div class="col-sm-7">
						    		<input type="text" class="form-control" name="monThi[0].tenMonThi">
						    	</div>
						    	<div class="col-sm-3">
						    		<input type="number" class="form-control" name="monThi[0].heSo" value="1" min="1">
						    	</div>
						    	<!-- <button type="button" onclick="luuMonThi(this)" class="btn btn-default" title="Lưu câu hỏi"><i class="glyphicon glyphicon-ok"></i></button> -->
						  		<button type="button" onclick="xoaMonThi(this)" class="btn btn-default xoaMonThi" title="Xóa môn thi"><i class="glyphicon glyphicon-remove"></i></button>
						  	</div>
						  	<button type="button" id="taoMonThi" class="btn btn-default" onclick="taoHTMLMonThi(this)">Thêm môn thi</button>
				</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default btn1" data-dismiss="modal">Hủy</button>
				<button type="reset" name="resetForm" onclick="clearCheckbox()" class="btn btn-warning btn1">Xóa</button>
				<button type="submit" name="submit" value="submit" class="btn btn-success">Đồng ý</button>
			</div>
			</div>
			</html:form>
		</div>
	</div>
</div>
<jsp:include page="Asset/Footer.jsp" />
</body>
</htm>>