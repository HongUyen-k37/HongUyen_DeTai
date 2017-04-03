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
    		<h1 class="title-h1">Không thể truy cập trang</h1>
    		<hr>
    		<p>Lý do: Bạn cần <strong>đăng nhập</strong> để sử dụng chức năng này hoặc đăng nhập với <strong>quyền cao hơn</strong></p>
    		<p>Xin vui lòng đăng nhập và thử lại.</p>
    		<p>
    			<a href="Home.do" class="btn btn-primary">Trở về trang chủ</a>
    		</p>
    	</div>
    </div>
</div>   
<%@include file="footer.jsp" %>
