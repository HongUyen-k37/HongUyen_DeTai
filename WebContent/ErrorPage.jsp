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
<title>Error Page</title>
<jsp:include page="Asset/Head.jsp" />
</head>
<body>
<jsp:include page="Asset/Header.jsp" />
<jsp:include page="Asset/Menu1.jsp" />
<div class="content" style="min-height: 600px">
    <div class="container">
    	<div class="text-center">
    		<hr>
    		<h1 class="title-h1">404 Page not found</h1>
    		<hr>
    		<p>Dữ liệu không khả dụng.</p>
    		<p>
    			<a href="KyThi.do" class="btn btn-primary">Trở về trang Thông tin kỳ thi</a>
    		</p>
    	</div>
    </div>
</div>   
<jsp:include page="Asset/Footer.jsp" />
</body>
</html>