<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<div id="menu">
	<div  class="container">
		<ul>
			<li onmouseover="mouseOn(this)" onmouseleave="mouseOut(this)"> <a href="#">Tổ chức thi</a>
			<ul>
				<li><a href="KyThi.do">Thông tin kỳ thi</a></li>
				<li><a href="ThiSinh.do">Thí sinh dự thi</a></li>
				<li><a href="SoBaoDanh.do">Đánh số báo danh</a></li>
				<li><a href="PhanPhongThi.do">Phân phòng thi</a></li>
				<li><a href="DanhSachPhongThi.do">Danh sách phòng thi</a></li>
			</ul>
			</li>
			<li onmouseover="mouseOn(this)" onmouseleave="mouseOut(this)"><a href="#">Tổ chức chấm thi</a>
			<ul>
				<li><a href="XuLyBaiThi.do">Xử lý bài thi</a></li>
				<li><a href="DonTuiPhach.do">Dồn túi phách</a></li>
				<li><a href="NhapDiemThi.do">Nhập điểm thi</a></li>
				<li><a href="XacDinhDiemChuan.do">Xác định điểm chuẩn</a></li>
			</ul>
			</li>
			
			<li onmouseover="mouseOn(this)" onmouseleave="mouseOut(this)"> <a href="#">Báo cáo - Thống kê</a>
			<ul>
				<li><a href="ThongKeBienBanChamThi.do">Biên bản chấm thi</a></li>
				<li><a href="ThongKeBienBanTongHopChamThi.do">Biên bản tổng hợp chấm thi</a></li>
				<li><a href="ThongKeBangDiemTheoMon.do">Bảng điểm theo môn thi</a></li>
				<li><a href="ThongKeBangDiemTongHop.do">Bảng điểm tổng hợp</a></li>
				<li><a href="ThongKeDSTSTrungTuyen.do">Danh sách trúng tuyển</a></li>				
			</ul></li>
			<li> <a href="LienHe.jsp">Liên hệ</a></li>
			<div class="log-out">
				<logic:notEmpty name="user" scope="session">
				<span style="color: #fff;">Xin chào, <b><bean:write name="user" property="tenDangNhap" scope="session"/></b>!</span>
				</logic:notEmpty>
				<a href="DangXuat.do" class="btn btn-success btn-all">Đăng xuất</a>
			</div>
		</ul>
	</div>
</div>