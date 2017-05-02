<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>    
<div id="footer">
	
	<p> &copy; Bản quyền Trường Đại Học Khoa Học Huế </p>
</div>
<span class="alert alert-success" id="notice"></span>
<div id="printSection">
</div>
<script src="js/test.js"></script>
<!-- <script type="text/javascript">
	$(document).ready(function(){
		<logic:notEmpty name="notice" scope="session">
			showNotice('${notice}');
			<bean:define id="notice" name="notice" scope="session"></bean:define>
		</logic:notEmpty>
	});
</script> -->
