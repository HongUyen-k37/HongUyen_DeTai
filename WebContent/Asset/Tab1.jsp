<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<div class="main-nav row">
			<div class="title-content">
				<div class="title-left col-md-6">
					<h5>TRƯỜNG ĐẠI HỌC KHOA HỌC</h5>
					<bean:define id="kyThi" name="phongThiActionForm" property="kyThi"></bean:define>
					<h6>HỘI ĐỒNG TUYỂN SINH NĂM <bean:write name="kyThi" property="namTuyenSinh"></bean:write></h6>
				</div>
				<div class="title-right col-md-6">
					<h6>DANH SÁCH THÍ SINH ĐĂNG KÝ DỰ THI</h6>
					<p>Hình thức đào tạo: <bean:write name="kyThi" property="hinhThucDT"></bean:write></p>
				</div>
			</div>
			<div style="text-align: center">	
				<p>Ngành: <bean:write name="kyThi" property="nganh"></bean:write></p>
				<p>Điểm thi: Trường Đại Học Khoa Học</p>
			</div>
	<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>STT</th>
			<th>Số báo danh</th>
			<th>Họ đệm</th>
			<th>Tên</th>
		</tr>
	</thead>
	<bean:define id="stt" value="0"/>
	<tbody>
	<logic:iterate id="dsts" name="phongThiActionForm" property="listThiSinh">	
		<tr>	
			<bean:define id="stt" value="${stt+1}"/>
			<td>${stt}</td>
			<td><bean:write name="dsts" property="soBaoDanh"/></td>
			<td><bean:write name="dsts" property="hoDem"/></td>
			<td><bean:write name="dsts" property="ten"/></td>
		</tr>
	</logic:iterate>
	</tbody>
	</table>
	<div class="row totalCandidates">
		<div class="col-md-7">
			<p>Danh sách gồm có: <span> ${stt} </span> sinh viên.</p>
		</div>
		<div class="col-md-5 btn-group" style="text-align: center">
			<p>Thừa Thiên Huế, ngày 10 tháng 12 năm 2016</p>
			<p>T.M. Hội đồng tuyển sinh</p>
			<p>Chủ tịch</p>
		</div>
	</div>
</div>