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
<jsp:include page="Asset/Menu2.jsp" />
<div class="container">
	
<div class="row">
	<div class="col-md-4 no-pad">
		<div class="thongtinkithi group-content">
			<div class="main-nav">
				<bean:define id="listMaKyThi" name="phongThiActionForm"></bean:define>
				<%@include file="Asset/ThongTinKyThi.jsp" %>
			</div>
		</div>
	</div>
	<div class="col-md-8">
		<div class="group-content">
			<div class="row main-nav">
				<p class="title">PHÒNG THI</p>
				<form>
					<div class="form-group row">
						<label class="col-md-2" for="sl">Danh sách:</label>
						<div class="col-md-10">
							<html:select property="maPhongThi" name="phongThiActionForm" styleId="f_maPhongThi" styleClass="form-control" onchange="getDanhSachPhongThi()">
	                    		<html:optionsCollection name="phongThiActionForm" property="listPhongThi" label="soHieuPhongThi" value="maPhongThi"/>
		             		</html:select>
						</div>
					</div>
				</form>
				</div>
				<div role="tabpanel">
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active">
							<a href="#dsPhongThi" aria-controls="home" role="tab" data-toggle="tab">Danh sách thí sinh dự thi</a>
						</li>
						<li role="presentation" class="">
							<a href="#bienBanPhongThi" aria-controls="tab" role="tab" data-toggle="tab">Biên bản thu bài thi</a>
						</li>
						<li class="export-excel">
							<a href="javascript:download()">Tải xuống</a>
						</li>
						<script type="text/javascript">
							function download(){
								var id=1;
								if($("#bienbanPhongThi").hasClass("active")) id=2;
								//Gửi dữ liệu lên server để tải = Ajax
							}
						</script>
					</ul>
					<!-- Tab panes -->
					
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane fade in active" id="dsPhongThi">
							<%@include file="Asset/Tab1.jsp" %>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="bienBanPhongThi">
							<%@include file="Asset/Tab2.jsp" %>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="Asset/Footer.jsp" />
</body>
</html>