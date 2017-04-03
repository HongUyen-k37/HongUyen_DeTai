<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<%@include file="header.jsp" %>

<div class="content" style="min-height: 600px">
    <div class="container">
           <h1 style="text-align: center;" class="title-h1">Xếp hạng Thành viên</h1>
           <table class="table table-hover table-bordered">
               <thead>
                    <tr class="success">
                        <th>STT</th>
                        <th>ID</th>
                        <th>Họ Tên</th>
                        <th>Số bài thi</th>
                        <th>Số câu hỏi</th>
                        <th>Số câu giải được</th>
                    </tr>
               </thead>
               <bean:define id="stt" value="0"/>
               <tbody>
               		<bean:define id="idUserSession" name="thongKeActionForm" property="idUser"></bean:define>
               		<logic:iterate id="dsTKThanhVien" name="thongKeActionForm" property="listTKThanhVien">
               		<bean:define id="idUser" name="dsTKThanhVien" property="idUser"></bean:define>
               		<bean:define id="stt" value="${stt+1}"/>
               		<logic:equal name="dsTKThanhVien" property="idUser" value="${idUserSession}">         		
                    <tr class="success">
                    </logic:equal>
                    <logic:notEqual name="dsTKThanhVien" property="idUser" value="${idUserSession}">         		
                    <tr>
                    </logic:notEqual>
                        <td>${stt}</td>
                        <td><bean:write name="dsTKThanhVien" property="idUser"/></td>
                        <td><bean:write name="dsTKThanhVien" property="hoTen"/></td>
                        <td><bean:write name="dsTKThanhVien" property="soBaiThi"/></td>
                        <td><bean:write name="dsTKThanhVien" property="tongCauHoi"/></td>
                        <td><bean:write name="dsTKThanhVien" property="tongCauDung"/></td>                       
                    </tr>  
                    </logic:iterate>                 
               </tbody>
              
           </table>
          <div class="phan-trang" id="phan-trang">
                <ul class="pagination">
                	
                </ul>
            </div>
            <hr>
            <h1 style="text-align: center;" class="title-h1">Xếp hạng Bài thi</h1>
           <table class="table table-hover table-bordered">
               <thead>
                    <tr class="success">
                        <th>STT</th>
                        <th>ID</th>
                        <th>Tên bài</th>
                        <th>Số câu hỏi</th>
                        <th>Số lượt làm</th>
                        <th>Tỉ lệ câu hỏi giải được</th>
                    </tr>
               </thead>
               <tbody>
               		<bean:define id="stt" value="0"/>
                    <logic:iterate id="TKBaiThi" name="thongKeActionForm" property="listTKBaiThi">
               		<bean:define id="idBaiThi" name="TKBaiThi" property="idBaiThi"></bean:define>
               		<bean:define id="stt" value="${stt+1}"/>
                    <tr onclick="window.location='ChiTietBaiThi.do?idBaiThi=${idBaiThi}'" style="cursor:pointer">
                        <td>${stt}</td>
                        <td><bean:write name="TKBaiThi" property="idBaiThi"/></td>
                        <td><bean:write name="TKBaiThi" property="tenBaiThi"/></td>
                        <td><bean:write name="TKBaiThi" property="soCauHoi"/></td>
                        <td><bean:write name="TKBaiThi" property="soLuotLam"/></td>
                        <td><bean:write name="TKBaiThi" property="tiLeLamDuoc"/></td>                      
                    </tr>  
                    </logic:iterate>        
               </tbody>
              
           </table>
           <div class="phan-trang" id="phan-trang1">
                <ul class="pagination">
                	
                </ul>
            </div>
    </div>
</div>

<%@include file="footer.jsp"%>
<script type="text/javascript">
        // Code javascript
        var numPage=${thongKeActionForm.pageTV};
        var currentPage=${thongKeActionForm.totalTV};
        loadPhanTrang("phan-trang");
 </script>
