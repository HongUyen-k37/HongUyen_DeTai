<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<%@include file="header.jsp" %>

<div class="content" style="min-height: 600px">
    <div class="container home text-center">
    	<div class="col-md-10 col-md-offset-1 title-header text-center">
    		<h2>TRẮC NGHIỆM ONLINE</h2>
    		<h5>Đánh giá bản thân - Thể hiện khả năng</h5>
    		<p>Mục tiêu của chúng tôi là muốn các bạn có thể đánh giá bản thân qua các bài thi trắc nghiệm với độ chính xác cao.
    		<br>Chúng tôi hứa hẹn sẽ đem đến cho các bạn những bài trắc nghiệm tuyệt vời.</p>
    	</div>
    	<hr>
    	<div class="rank-table col-md-8 col-md-offset-2">
    		<h3>TOP THÀNH VIÊN</h3>
    		<table class="table table-bordered table-hover">
    			<thead>
    				<tr>
    					<th>Rank</th>
    					<th>ID</th>
    					<th>Họ tên</th>
    					<th>Số lần thi</th>
    					<th>Số câu hỏi</th>
    					<th>Trả lời đúng</th>
    				</tr>
    			</thead>
    			<bean:define id="stt" value="0"/>
                <tbody>
               		<logic:iterate id="dsTKThanhVien" name="thongKeActionForm" property="listTKThanhVien">
               		<bean:define id="idUser" name="dsTKThanhVien" property="idUser"></bean:define>
               		<bean:define id="stt" value="${stt+1}"/>
                    <tr>
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
    	</div>
    	<hr>
    	<div class="rank-test col-md-8 col-md-offset-2">
    		<h3>TOP BÀI THI</h3>
    		<table class="table table-hover table-bordered">
               <thead>
                    <tr>
                        <th>Rank</th>
                        <th>ID</th>
                        <th>Tên bài</th>
                        <th>Số câu hỏi</th>
                        <th>Số lượt làm</th>
                        <th>Trả lời đúng</th>
                    </tr>
               </thead>
               <bean:define id="stt" value="0"/>
               <tbody>
                    <logic:iterate id="TKBaiThi" name="thongKeActionForm" property="listTKBaiThi">
               		<bean:define id="idBaiThi" name="TKBaiThi" property="idBaiThi"></bean:define>
                    <tr onclick="window.location='ChiTietBaiThi.do?idBaiThi=${idBaiThi}'" style="cursor:pointer">
                    <bean:define id="stt" value="${stt+1}"/>
                        <td>${stt}</td>
                        <td><bean:write name="TKBaiThi" property="idBaiThi"/></td>
                        <td><bean:write name="TKBaiThi" property="tenBaiThi"/></td>
                        <td><bean:write name="TKBaiThi" property="soCauHoi"/></td>
                        <td><bean:write name="TKBaiThi" property="soLuotLam"/></td>
                        <td><bean:write name="TKBaiThi" property="tiLeLamDuoc"/>%</td>                      
                    </tr>  
                    </logic:iterate>        
               </tbody>
           </table>
    	</div>
    </div>
</div>

<%@include file="footer.jsp" %>
    <script type="text/javascript">
        // Code javascript
    </script>
