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
<%--  <div id="search" class="col-md-5" style="float:right">
	           		<html:form action="/QuanLyBaiThi" method="GET">   
	                <div class="form-search search-only">
	                    <i class="search-icon glyphicon glyphicon-search"></i>
	                    <html:select property="inputSearch" styleId="select-search" styleClass="form-control">
	                    	<option value="">-- Tất cả --</option>
	                    	<html:optionsCollection name="baiThiActionForm" property="listLoai" label="tenLoai" value="idLoai"/>
	                    </html:select>
	                    <input type="text" name ="search" class="form-control search-query">
	                </div>
	                </html:form>
	            </div> --%>
<%--  <div id="search" class="col-md-5" style="float:right">
	<html:form action="" method="GET">   
    <div class="form-search search-only">
        <i class="search-icon glyphicon glyphicon-search"></i>
        <input type="text" name ="search" class="form-control search-query">
    </div>
    </html:form>
</div> --%>
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
	                    <a href="#xoaKyThi" data-toggle="modal" class="icon icon-danger" title="Xóa kỳ thi"><i class="glyphicon glyphicon-trash"></i></a></td>
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
            	<button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
            	<a href="XoaKyThi.do?maKyThi=${maKyThi}"  class="btn btn-danger">Đồng ý</a>
            </div>
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
						      		<input type="text" class="form-control" id="f_tenKyThi" name="tenKyThi" title="Sida rồi bạn ơi" required onchange="this.value=this.value.trim()">
						    	</div>
						  	</div>
							<div class="form-group row">
							<label class="control-label col-sm-2 pad-5">Ngày thi(*)</label>
						    	<div class="col-sm-4">
						      		<input type="text" class="form-control" id="f_ngayThi" name="ngayThi" required placeholder="Ví dụ: 02,03,04/11" data-original-title="Chỉ chứa số" title="Vui lòng nhập đúng quy định" pattern="[0-9]{2},[0-9]{2},[0-9]{2}/[0-9]{2}">
						    	</div>
						    	<label class="control-label col-sm-3 pad-5">Năm tuyển sinh(*)</label>
						    	<div class="col-sm-3"> 
						      		<input type="number" class="form-control" id="f_namTuyenSinh" name="namTuyenSinh" min="2015" required data-original-title="Chỉ chứa số" maxlength="4">
						    	</div>
						    	
						  	</div>
							<div class="form-group row">
						    	<label class="control-label col-sm-2 pad-5">Ngành(*)</label>
						    	<div class="col-sm-4">
						      		<input type="text" class="form-control" id="f_nganh" name="nganh" required onchange="this.value=this.value.trim()">
						    	</div>
						    	<label class="control-label col-sm-3 pad-5">Hình thức đào tạo(*)</label>
						    	<div class="col-sm-3">
						    		<input type="text" class="form-control" id="f_hinhThucDT" name="hinhThucDT" required>
					    		</div>
						  	</div>
						  	<div class="form-group row">
						    	<label class="control-label col-sm-4">Cơ sở liên kết đào tạo</label>
						    	<div class="col-sm-8">
						      		<input type="text" class="form-control" id="f_coSoLKDT" name="coSoLKDT">
						    	</div>
						  	</div>
						  	<div class="form-group row">
						    	<label class="control-label col-sm-4">Số môn thi <i id="soMonThi" name="soMonThi">0</i></label>
						  		<label class="control-label col-sm-8">Danh sách môn thi</label>
						  	</div>
						  	<div class="form-group row">
						    	<div class="col-sm-8 col-sm-offset-2">
						    		<input type="text" class="form-control" name="tenMonThi" placeholder="Tên môn thi">
						    	</div>
						    	<button type="button" onclick="luuMonThi(this)" class="btn btn-default" title="Lưu câu hỏi"><i class="glyphicon glyphicon-ok"></i></button>
						  		<button type="button" onclick="xoaMonThi(this)" class="btn btn-default" title="Xóa câu hỏi"><i class="glyphicon glyphicon-remove"></i></button>
						  	</div>
						  	<button type="button" class="btn btn-default col-md-8 col-md-offset-2" onclick="taoHTMLMonThi(this)">Thêm môn thi</button>
				<label><i>(*): Thông tin bắt buộc</i></label>
				</div>
			
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
				<button type="reset" name="resetForm" onclick="clearCheckbox()" class="btn btn-warning">Xóa</button>
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