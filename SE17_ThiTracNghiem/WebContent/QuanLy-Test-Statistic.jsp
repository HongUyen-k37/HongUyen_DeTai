<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<%@include file="header.jsp" %>


<div class="content" style="min-height: 600px">
    <div class="container">
        <h1 style="text-align: center;" class="title-h1">Thống kê Bài thi</h1>
           <table class="table table-hover table-bordered">
               <thead>
                    <tr class="success">
                        <th>STT</th>
                        <th>IDBài Thi</th>
                        <th>Tên bài</th>
                        <th>Số câu hỏi</th>
                        <th>Số lượt làm</th>
                        <th>Tỉ lệ câu hỏi giải được</th>
                        <th></th>
                    </tr>
               </thead>
               <tbody>
               		<bean:define id="stt" value="0"/>
                    <logic:iterate id="TKBaiThi" name="thongKeBaiThiActionForm" property="listTKBaiThi">
                    <tr>
                    	<bean:define id="stt" value="${stt+1}"/>
                    	<bean:define id="idBaiThi" name="TKBaiThi" property="idBaiThi"/>
                        <td>${stt}</td>
                        <td><bean:write name="TKBaiThi" property="idBaiThi"/></td>
                        <td><bean:write name="TKBaiThi" property="tenBaiThi"/></td>
                        <td><bean:write name="TKBaiThi" property="soCauHoi"/></td>
                        <td><bean:write name="TKBaiThi" property="soLuotLam"/></td>
                        <td><bean:write name="TKBaiThi" property="tiLeLamDuoc"/>%</td>
                        <td><a href="TKChiTietBaiThi.do?idBaiThi=${idBaiThi}" class="btn btn-primary"><i class="fa fa-search"></i></a></td>                      
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



<%@include file="footer.jsp"%>
<script type="text/javascript">
var numPage=${thongKeBaiThiActionForm.total};
var currentPage=${thongKeBaiThiActionForm.page};
loadPhanTrang("phan-trang");
</script>