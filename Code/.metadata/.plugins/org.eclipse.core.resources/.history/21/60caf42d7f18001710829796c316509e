<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<div id="menu">
	<div  class="container">
		<ul>
			<li> <a href="#">Tổ chức thi</a>
			<ul>
				<li><a href="KyThi.do">Thông tin kỳ thi</a></li>
				<li><a href="ThiSinh.do">Thí sinh dự thi</a></li>
				<li><a href="SoBaoDanh.do">Đánh số báo danh</a></li>
				<li><a href="PhanPhongThi.jsp">Phân phòng thi</a></li>
				<li><a href="DanhSachPhongThi.jsp">Danh sách phòng thi</a></li>
			</ul>
			</li>
			<li><a href="#">Tổ chức chấm thi</a>
			<ul>
				<li><a href="BaiThi.jsp">Xử lý bài thi</a></li>
				<li><a href="DonTui.jsp">Dồn túi phách</a></li>
				<li><a href="NhapDiem.jsp">Nhập điểm thi</a></li>
				<li><a href="DiemChuan.jsp">Xác định điểm chuẩn</a></li>
			</ul>
			</li>
			<li> <a href="#">Hướng dẫn - Hỗ trợ</a></li>
			<li> <a href="#">Báo cáo - Thống kê</a></li>
			<li> <a href="#">Tìm kiếm</a></li>
			<div class="log-out">
				<logic:notEmpty name="user" scope="session">
				<span style="color: #fff;">Xin chào, <b><bean:write name="user" property="tenDangNhap" scope="session"/></b>!</span>
				</logic:notEmpty>
				<a href="DangXuat.do" class="btn btn-success btn-all">Đăng xuất</a>
			</div>
		</ul>
	</div>
</div>
<script type="text/javascript">
	$('#menu li').hover(
  		function() {
   		 $('ul', this).stop().slideDown(200);
 		 },
  		function() {
   		 $('ul', this).stop().slideUp(200);
 		 }
	);
</script>