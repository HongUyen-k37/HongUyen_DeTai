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
    		<h1 class="title-h1">Lần thi của bạn xảy ra lỗi</h1>
    		<hr>
    		<p>Các nguyên nhân dẫn tới lỗi: <strong>Làm bài quá thời gian quy định; Cheat; Bug.</strong></p>
    		<p>Liên hệ <strong>Admin</strong> để được giúp đỡ.</p>
    		<p>
    			<a href="Home.do" class="btn btn-primary">Trở về trang chủ</a>
    		</p>
    	</div>
    </div>
</div>   
<%@include file="footer.jsp" %>
