<!-- UyenTTH 9:00 21/02/2017 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@include file="header.jsp" %>


<div class="content" style="min-height: 600px">
    <!-- Nơi code content -->
    <div class="container">
        <h1 class="text-center" class="title-h1">Quản lý câu hỏi</h1>
        <div class="mar-bot">
         <a class="btn btn-info" data-toggle="modal" href="#modal-id" onclick="taoCauHoi()">Tạo Câu Hỏi</a>
          <a class="btn btn-danger" data-toggle="modal" href="#modal1-id">Nhập bằng file</a>
        	<div id="search" class="col-md-5" style="float:right">
	           		<html:form action="/QuanLyCauHoi" method="GET">   
	                <div class="form-search search-only">
	                    <i class="search-icon glyphicon glyphicon-search"></i>
	                    <html:select property="inputSearch" styleId="select-search" styleClass="form-control">
	                    	<option value="">-- Tất cả --</option>
	                    	<html:optionsCollection name="cauHoiActionForm" property="listLoai" label="tenLoai" value="idLoai"/>
	                    </html:select>
	                    <input type="text" name="search" class="form-control search-query">
	                </div>
	                </html:form>
	            </div>
        </div>
        <div class="table-responsive">
            <table class="table table-bordered table-hover">
                <thead >
                    <tr class="success">
                    	<th>ID</th>
                        <th>Nội dung câu hỏi</th>
                        <th>Trả lời 1</th>
                        <th>Trả lời 2</th>
                        <th>Trả lời 3</th>
                        <th>Trả lời 4</th>
                        <th style="width: 65px;"></th>
                    </tr>
                </thead>
                <tbody>
                <logic:iterate id="dsCauHoi" name="cauHoiActionForm" property="lst"> 
                    <tr>
                    	<bean:define id="idCauHoi" name="dsCauHoi" property="idCauHoi"></bean:define>
                    	<td><bean:write name="idCauHoi"/></td>
                        <td><bean:write name="dsCauHoi" property="noiDung"/></td>
                        <logic:equal name="dsCauHoi" property="traLoiMot" value="${dsCauHoi.dapAn}">
                        	<td><b><bean:write name="dsCauHoi" property="traLoiMot"/></b></td>
                        </logic:equal>
                        <logic:notEqual name="dsCauHoi" property="traLoiMot" value="${dsCauHoi.dapAn}">
                        	<td><bean:write name="dsCauHoi" property="traLoiMot"/></td>
                        </logic:notEqual>
                        <logic:equal name="dsCauHoi" property="traLoiHai" value="${dsCauHoi.dapAn}">
                        	<td><b><bean:write name="dsCauHoi" property="traLoiHai"/></b></td>
                        </logic:equal>
                        <logic:notEqual name="dsCauHoi" property="traLoiHai" value="${dsCauHoi.dapAn}">
                        	<td><bean:write name="dsCauHoi" property="traLoiHai"/></td>
                        </logic:notEqual>
                        <logic:equal name="dsCauHoi" property="traLoiBa" value="${dsCauHoi.dapAn}">
                        	<td><b><bean:write name="dsCauHoi" property="traLoiBa"/></b></td>
                        </logic:equal>
                        <logic:notEqual name="dsCauHoi" property="traLoiBa" value="${dsCauHoi.dapAn}">
                        	<td><bean:write name="dsCauHoi" property="traLoiBa"/></td>
                        </logic:notEqual>
                        <logic:equal name="dsCauHoi" property="traLoiBon" value="${dsCauHoi.dapAn}">
                        	<td><b><bean:write name="dsCauHoi" property="traLoiBon"/></b></td>
                        </logic:equal>
                        <logic:notEqual name="dsCauHoi" property="traLoiBon" value="${dsCauHoi.dapAn}">
                        	<td><bean:write name="dsCauHoi" property="traLoiBon"/></td>
                        </logic:notEqual>
                        <td>
                        <a href="#modal-id" onclick="suaCauHoi('${idCauHoi}')" data-toggle="modal" class="icon icon-primary" title="Sửa câu hỏi"><i class="fa fa-edit"></i></a> 
                    	<a href="XoaCauHoi.do?idCauHoi=${idCauHoi}" onclick="return confirm('Bạn chắc chắn muốn xóa câu hỏi này?')" class="icon icon-danger" title="Xóa câu hỏi"><i class="fa fa-trash"></i></a></td>
                    </tr>
                </logic:iterate>
                </tbody>
            </table>
            <div class="phan-trang" id="phan-trang">
                <ul class="pagination">
                	
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="modal-id">
    <div class="modal-dialog">
        <div class="modal-content">
             <html:form action="/ThemCauHoi" styleId="formCreateEdit" styleClass="form-horizontal">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Thêm mới câu hỏi</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="textarea" class="col-sm-3 control-label">Nội Dung <b class="required">(*)</b></label>
                    <div class="col-sm-8">
                        <textarea name="noiDung" id="f_noiDung" class="form-control" rows="2" required="required" onchange="this.value=this.value.trim()"></textarea>
                    </div>
                </div>
                 <div class="form-group">
                    <label for="textarea" class="col-sm-3 control-label">Trả Lời 1 <b class="required">(*)</b></label>
                    <div class="col-sm-8">
                        <input type ="text" name="traLoiMot" id="f_traLoiMot" class="form-control" required="required" onchange="this.value=this.value.trim()">
                    </div>
                    <div class="col-md-1">
                    	<input type="radio" id="answer_1" name="answer">
                    </div>
                </div>
                 <div class="form-group">
                    <label for="textarea" class="col-sm-3 control-label">Trả Lời 2 <b class="required">(*)</b></label>
                    <div class="col-sm-8">
                        <input type ="text" name="traLoiHai" id="f_traLoiHai" class="form-control" required="required" onchange="this.value=this.value.trim()">
                    </div>
                    <div class="col-md-1">
                    	<input type="radio" id="answer_2" name="answer">
                    </div>
                </div>
                 <div class="form-group">
                    <label for="textarea" class="col-sm-3 control-label">Trả Lời 3</label>
                    <div class="col-sm-8">
                        <input type ="text" name="traLoiBa" id="f_traLoiBa" class="form-control" onchange="this.value=this.value.trim()"></input>
                    </div>
                    <div class="col-md-1">
                    	<input type="radio" id="answer_3" name="answer">
                    </div>
                </div>
                   <div class="form-group">
                    <label for="textarea" class="col-sm-3 control-label">Trả Lời 4</label>
                    <div class="col-sm-8">
                        <input type ="text" name="traLoiBon" id="f_traLoiBon" class="form-control" onchange="this.value=this.value.trim()"></input>
                    </div>
                    <div class="col-md-1">
                    	<input type="radio" id="answer_4" name="answer">
                    </div>
                </div>
                <div class="form-group">
                 	<label for="textarea" class="col-sm-3 control-label">Loại</label>
                 	<div class="col-sm-8">
                	<html:select property="idLoai" styleId="f_idLoai" styleClass="form-control">
                    	<html:optionsCollection name="cauHoiActionForm" property="listLoai" label="tenLoai" value="idLoai"/>
	             	</html:select>
	              	</div>
                </div>
                <input type="hidden" name="dapAn" id="f_dapAn" class="form-control">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
                <button type="reset" name="resetForm" onclick="clearCheckbox()" class="btn btn-warning">Xóa</button>
                <button type="submit" name="submit" value="submit" onclick="return checkDapAn()" class="btn btn-primary">Đồng ý</button>
            </div>
            </html:form>
        </div>
    </div>
</div>
<!-- Tét -->
<div class="modal fade" id="modal1-id">
    <div class="modal-dialog">
        <div class="modal-content">
        	<html:form action="/NhapFile" styleId="upload" styleClass="form-horizontal" enctype="multipart/form-data">
        	<div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Nhập câu hỏi bằng file excel</h4>
            </div>
            
             <div class="modal-body">
             	<input type="hidden" name="action" value="cauHoi">
             	<input id="uploadfile" name="file" type="file">
             	<hr>
             	<p>Để dữ liệu câu hỏi upload được đảm bảo đúng và không xảy ra lỗi, bạn nên làm theo mẫu.
             	Xem mẫu hướng dẫn ở đây</p>
             	<a href="Files/Template.xlsx">File mẫu</a>
             </div>
            </html:form>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
 <script type="text/javascript">
        // Code javascript
        var numPage=${cauHoiActionForm.total};
        var currentPage=${cauHoiActionForm.page};
        loadPhanTrang("phan-trang");
        $("#uploadfile").change(function(){
    		document.forms.upload.submit();
    	});
 </script>
