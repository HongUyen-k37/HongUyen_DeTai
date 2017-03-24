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
<title>Tuyển sinh</title>
<jsp:include page="Asset/Head.jsp" />
</head>
<body>
<jsp:include page="Asset/Header.jsp" />
<jsp:include page="Asset/Menu1.jsp" />
<div class="col-md-4 col-md-offset-4">
<div class="login">
	<html:form method="post" action="DangNhap.do">
	    <div class="form-group">
	      <label for="user">Tên đăng nhập:</label>
	      <input type="text" class="form-control" name="username" placeholder="Nhập tên đăng nhập">  
	    </div>
	    <div class="form-group">
	      <label for="pwd">Mật khẩu:</label>
	      <input type="password" class="form-control" name="password" placeholder="Nhập mật khẩu"> 
	    </div>
	    <button type="submit" class="btn btn-success" name="submit">Đăng nhập</button>
 	</html:form>
 	<p class="message">
 		<bean:write name="dangNhapActionForm" property="error"/>
 	</p>		
</div>
</div>
<div class="clear"></div>
<jsp:include page="Asset/Footer.jsp" />
</body>
</html>