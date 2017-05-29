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
				<div class="text-center col-xs-7">
					<h6><b>DANH SÁCH THEO DÕI THÍ SINH DỰ THI</b></h6>
					<p>Hình thức đào tạo: <bean:write name="kyThi" property="hinhThucDT"></bean:write></p>
				</div>
			</div>
			<div style="text-align: center">	
				<p><b>Ngành: <bean:write name="kyThi" property="nganh"></bean:write></b></p>
				
			</div>
			<p><b>Điểm thi: <bean:write name="kyThi" property="coSoLKDT"></bean:write></b></p>
	<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>STT</th>
			<th>Số BD</th>
			<th colspan="2">Họ và tên</th>
			<th>Ngày sinh</th>
			<th>Khu vực</th>
			<th>Đối tượng</th>
			<th>Ghi chú</th>
		</tr>
	</thead>
	<bean:define id="stt" value="0"/>
	<tbody>
	<logic:iterate id="dsts" name="phongThiActionForm" property="listThiSinh">	
		<tr>	
			<bean:define id="stt" value="${stt+1}"/>
			<td style="text-align: center">${stt}</td>
			<td style="text-align: center"><bean:write name="dsts" property="soBaoDanh"/></td>
			<td>${dsts.hoDem}</td>
			<td>${dsts.ten}</td>
			<td style="text-align: center"><bean:write name="dsts" property="ngaySinh"/></td>
			<td style="text-align: center"><bean:write name="dsts" property="khuVuc"/></td>
			<td style="text-align: center"><bean:write name="dsts" property="doiTuong"/></td>
			<td></td>
		</tr>
	</logic:iterate>
	</tbody>
	</table>
	<div class="row totalCandidates">
		<div class="col-xs-7">
			<p>Danh sách gồm có: <span> ${stt} </span> sinh viên.</p>
		</div>
		<div class="col-xs-5 btn-group" style="text-align: center">
			<p>Thừa Thiên Huế, ngày.....tháng.....năm 20...</p>
			<p>T.M. Hội đồng tuyển sinh</p>
			<p>Chủ tịch</p>
		</div>
	</div>
</div>