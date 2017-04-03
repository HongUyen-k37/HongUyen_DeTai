<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@include file="header.jsp" %>

<bean:define id="idBaiThi" name="nhapCauHoiActionForm" property="idBaiThi"/>
<div class="content" style="min-height: 600px">
    <div class="container">
        <h1 class="title-h1 text-center">Nhập câu hỏi</h1>
        <h4>Bài thi: <bean:write name="nhapCauHoiActionForm" property="tenBaiThi"/> </h4>
        <div class="mar-bot">
            <a class="btn btn-danger" data-toggle="modal" href="#modal-id">Nhập bằng file</a>
            <a class="btn btn-info" href="javascipt:void(0)" onclick="chonCauHoiRandom()">Chọn ngẫu nhiên</a>
            <a class="btn btn-normal" href="javascipt:void(0)" onclick="chonLaiCauHoi()">Bỏ chọn tất cả</a>
            <a class="btn btn-primary" href="QuanLyBaiThi.do">Xong</a>
            <div id="search" class="col-md-5" style="float:right">
	        	<html:form action="/NhapCauHoi" method="GET"> 
	                <div class="form-search search-only">
	                  <i class="search-icon glyphicon glyphicon-search"></i>
	                   <i class="search-icon glyphicon glyphicon-search"></i>
	                    <html:select property="inputSearch" styleId="select-search" styleClass="form-control">
	                    	<option value="">-- Tất cả --</option>
	                    	<html:optionsCollection name="nhapCauHoiActionForm" property="lst" label="tenLoai" value="idLoai"/>
	                    </html:select>
	                  <input type="hidden" name="idBaiThi" value="${idBaiThi}">
	                  <input type="text" name="search" class="form-control search-query">
	                </div>
	            </html:form>
            </div>
        </div>
        <form action="" method="POST" class="" role="form">
            <table class="table table-bordered table-hover">
                <thead>
                    <tr class="success">
                        <th class="text-center"><span id="numQuest" class="num-quest badge badge-danger">0</span></th>
                        <th>ID</th>
                        <th>Nội dung câu hỏi</th>
                        <th>Trả lời 1</th>
                        <th>Trả lời 2</th>
                        <th>Trả lời 3</th>
                        <th>Trả lời 4</th>
                    </tr>
                </thead>
                <tbody>
                	<logic:iterate id="dsCauHoi" name="nhapCauHoiActionForm" property="listCauHoi"> 
                  <tr>
                  	<bean:define id="idCauHoi" name="dsCauHoi" property="idCauHoi"></bean:define>
                  	<td class="text-center">
                            	<input type="checkbox" name='checkbox' id="Question_${idCauHoi}">
                        	</td>
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
                 </tr>
              </logic:iterate>
                </tbody>
            </table>
        </form>
    </div>
</div>

<div class="modal fade" id="modal-id">
    <div class="modal-dialog">
        <div class="modal-content">
        	<html:form action="/NhapFile" styleId="upload" styleClass="form-horizontal" enctype="multipart/form-data">
        	<div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Nhập câu hỏi bằng file excel</h4>
            </div>
            
             <div class="modal-body">
             	<input type="hidden" name="idBaiThi" value="${idBaiThi}">
             	<input type="hidden" name="action" value="baiThi">
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
        $("#uploadfile").change(function(){
    		document.forms.upload.submit();
    	});
        <logic:iterate id="IDCauHoi" name="nhapCauHoiActionForm" property="listCauHoiBaiThi">$("#Question_"+('<bean:write name="IDCauHoi"/>')).iCheck('check');
		</logic:iterate>
		chonCauHoi(<bean:write name="nhapCauHoiActionForm" property="soCauHoi"/>);
    </script>