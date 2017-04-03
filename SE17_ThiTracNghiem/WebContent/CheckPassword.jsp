<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<%@include file="header.jsp" %>
<div class="content" style="min-height: 600px">
    <div class="container">
    	<div class="text-center">
    		<hr>
    		<h2>Bài thi <span style="color: #da4453">${baiThiActionForm.tenBaiThi}</span> được đặt khóa cho nội dung</h2>
    		<hr>
    		<form action="" method="POST">
	     		<div class="col-md-6 col-md-offset-3 mar-bot">
		    		<h4>Để tham gia bài thi này, cần nhập đúng mật khẩu:</h4>    		
		    		<input type="password" name="password" class="form-control text-center">		    		
	    		</div>
	    		<div class="col-md-12">
	    			<div class="mar-bot"><label class="label label-danger" style="font-size: 12px"><bean:write name="baiThiActionForm" property="error"/></label></div>
	    			<div><button type="submit" class="btn btn-primary mar-bot">Vào thi</button></div>
	    			<i>Nếu bạn không thể truy cập được. Xin liên hệ với <b>chủ bài thi</b></i>
	    		</div>
    		</form>
    	</div>
    </div>
</div>   
<%@include file="footer.jsp" %>
