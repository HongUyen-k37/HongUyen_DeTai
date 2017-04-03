<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@include file="header.jsp" %>


<div class="content" style="min-height: 600px">
    <div class="container">
        <!-- tiÃªu Äá» -->
        <h1 align="center" class="title-h1">Quản lý bài thi</h1>
      
        <div class="mar-bot">
            
	            <a type="button" class="btn btn-info" data-toggle="modal" href="#modal-id" onclick="taoBaiThi()">Tạo bài thi</a>
	          
	            <div id="search" class="col-md-5" style="float:right">
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
	            </div>
           	
        </div>
        <!--Danh sách bài thi info-->
        <table class="table table-bordered table-hover">
            <thead>
            
                <tr class="success">
                    <th>ID</th>
                    <th>Bài thi</th>
                    <th>Thời gian</th>
                    <th>Câu hỏi</th>
                    <th>Mô tả</th>
                    <th>Loại</th>
                    <th>Password</th>
                    <th style="width: 92px;"></th>
                </tr>
            </thead>
            <tbody>
            <logic:iterate id="dsBaiThi" name="baiThiActionForm" property="lst"> 
                <tr>
                	<bean:define id="idBaiThi" name="dsBaiThi" property="idBaiThi"/>
                    <td><bean:write name="dsBaiThi" property="idBaiThi"/></td>
                    <td class="ten-bai"><bean:write name="dsBaiThi" property="tenBaiThi"/></td>
                    <td><bean:write name="dsBaiThi" property="thoiGian"/></td>
                    <td><bean:write name="dsBaiThi" property="soCauHoi"/></td>
                    <td class="mo-ta"><bean:write name="dsBaiThi" property="moTa"/></td>
                    <td><bean:write name="dsBaiThi" property="idLoai"/></td>
                    <td><bean:write name="dsBaiThi" property="password"/></td>
                    <td>
	                    <a href="#modal-id" onclick="suaBaiThi('${idBaiThi}')" data-toggle="modal" class="icon icon-primary" title="Sửa bài thi"><i class="fa fa-edit"></i></a> 
	                    <a href="#xoaBaiThi"  data-toggle="modal" class="icon icon-danger" title="Xóa bài thi"><i class="fa fa-trash"></i></a>
	                    <a href="NhapCauHoi.do?idBaiThi=${idBaiThi}" data-toggle="modal" class="icon icon-success" title="Nhập Câu hỏi"><i class="fa fa-upload"></i></a> 
                    </td>
                </tr>
                </logic:iterate>
            </tbody>
        </table>  
    </div>
</div>
<!-- Test -->
<div class="modal fade" id="xoaBaiThi">
    <div class="modal-dialog">
        <div class="modal-content">
        	
        	<div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Xóa bài thi</h4>
            </div>
            
             <div class="modal-body">
             	<p>Nếu xóa thì các dữ liệu liên quan sẽ mất. Việc làm của bạn sẽ ảnh hưởng đến thành tích các thành viên đã tham gia bài thi của bạn</p>
             	<p>Bạn có bỏ chọn <b>Hoạt động</b> thay vì xóa bài thi.</p>
             	<p>Bạn có chắc chắn xóa bài thi này?</p>
             </div>
            
            <div class="modal-footer">
            	<button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
            	<a href="XoaBaiThi.do?idBaiThi=${idBaiThi}"  class="btn btn-danger">Đồng ý</a>
            </div>
        </div>
    </div>
</div>




<div class="modal fade" id="modal-id">
    <div class="modal-dialog">
        <div class="modal-content">
             <html:form action="/ThemBaiThi" styleId="formCreateEdit" styleClass="form-horizontal">
             <div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Tạo bài thi</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
	                    <label for="textarea" class="col-sm-3 control-label">Tên <b class="required">(*)</b></label>
	                    <div class="col-sm-9">
	                        <input type ="text" name="tenBaiThi" id="f_tenBaiThi" class="form-control"  required="required" onchange="this.value=this.value.trim()"></input>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="textarea" class="col-sm-3 control-label">Thời gian(Phút) <b class="required">(*)</b></label>
	                    <div class="col-sm-9">
	                        <input type ="number" min="1" max="1440" id="f_thoiGian" name="thoiGian" id="textarea" class="form-control"  required="required"></input>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="textarea" class="col-sm-3 control-label">Số câu <b class="required">(*)</b></label>
	                    <div class="col-sm-9">
	                       <input type ="number" min="1" id="f_soCauHoi" name="soCauHoi" id="textarea" class="form-control"  max="100" required="required"></input>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="textarea" class="col-sm-3 control-label">Mô tả</label>
	                    <div class="col-sm-9">
	                       <textarea rows="3" id="f_moTa" name="moTa" class="form-control" onchange="this.value=this.value.trim()"></textarea>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="textarea" class="col-sm-3 control-label">Tên loại</label>
	                    <div class="col-sm-9">
	                        <html:select property="idLoai" styleId="f_idLoai" styleClass="form-control">
		                    	<html:optionsCollection name="baiThiActionForm" property="listLoai" label="tenLoai" value="idLoai"/>
		                    </html:select>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="textarea" class="col-sm-3 control-label">Password</label>
	                    <div class="col-sm-9">
	                        <input type ="text" id="f_password" name="password" class="form-control" ></input>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-3 control-label"></label>
	                    <div class="col-sm-9">
	                        <input type="checkbox" id="f_active" name="active"><label style="margin-left: 5px;"> Hoạt động</label>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-3 control-label"></label>
	                    <div class="col-sm-9">
	                        <b class="required">(*): Yêu cầu bắt buộc</b>
	                    </div>
	                </div>
				</div>
                <div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
					<button type="reset" name="resetForm" onclick="clearCheckbox()" class="btn btn-warning">Xóa</button>
					<button type="submit" name="submit" value="1" class="btn btn-primary">Đồng ý</button>
				</div>
        </html:form>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
    <script type="text/javascript">
        // Code javascript 
        var y=$(".ten-bai");
        shortString(y, 20);
        var x=$(".mo-ta");
        shortString(x, 50);      
    </script>
