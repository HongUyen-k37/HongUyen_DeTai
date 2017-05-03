<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<div class="main-nav row">
	<div class="title-content">
		<div class="col-xs-5">
			<h5>TRƯỜNG ĐẠI HỌC KHOA HỌC</h5>
			<h6 class="text-center"><b>TUYỂN SINH NĂM <bean:write name="kyThi" property="namTuyenSinh"></bean:write></b></h6>
		</div>
		<div class="col-xs-7 text-center">
			<h5><b>BIÊN BẢN THU BÀI THI</b></h5>
			<h6>Môn: ..........</h6>
		</div>
	</div>
	<div class="text-center">	
		<p><b>Ngành: <bean:write name="kyThi" property="nganh"></bean:write></b></p>
	</div>
	<div class="no-pad">
		<p class="col-md-7 no-pad"><b>Điểm thi: <bean:write name="kyThi" property="coSoLKDT"></bean:write></b></p>
		<div class="numberroom col-md-5">
			<bean:define id="phongThi" name="phongThiActionForm" property="phongThi"></bean:define>
			<p style="float:right">Phòng thi: <bean:write name="phongThi" property="soHieuPhongThi"></bean:write></p>
		</div>
	</div>
	<div class="room-info">
		<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th>STT</th>
				<th colspan="2">Họ và tên</th>
				<th>Ngày sinh</th>
				<th>SBD</th>
				<th>Số tờ</th>
				<th>Ký tên</th>
				<th>Ghi chú</th>
			</tr>
		</thead>
		<bean:define id="stt" value="0"/>
	<tbody>
	<logic:iterate id="dsts" name="phongThiActionForm" property="listThiSinh">	
		<tr>	
			
			<bean:define id="stt" value="${stt+1}"/>
			<td style="text-align: center">${stt}</td>
			<td>${dsts.hoDem}</td>
			<td>${dsts.ten}</td>
			<td style="text-align: center"><bean:write name="dsts" property="ngaySinh"/></td>
			<td style="text-align: center"><bean:write name="dsts" property="soBaoDanh"/></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</logic:iterate>
	</tbody>
		</table>
	<div class="row totalCandidates">
		<div class="col-xs-12">
		<div class="col-xs-7">
			<p>Tổng cộng danh sách có ..... bài thi và ..... tờ giấy thi.</p></div>
		<div class="col-xs-5">	<p>Thừa Thiên Huế, ngày.....tháng.....năm 20...</p></div>
		</div>
		<div class="col-xs-3" style="text-align: center">
			<p>Cán bộ coi thi 1</p>
		</div>
		<div class="col-xs-3" style="text-align: center">
			<p>Cán bộ coi thi 2</p>
		</div>
		<div class="col-xs-6 btn-group" style="text-align: center">
			
			<p>Trưởng ban coi thi</p>
		</div>
	</div>
	</div>
</div>