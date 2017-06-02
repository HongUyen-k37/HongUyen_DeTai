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
				<bean:define id="listMaKyThi" name="diemActionForm"></bean:define>
				<%@include file="Asset/ThongTinKyThi.jsp" %>
			</div>
		</div>
	</div>
	<div class="col-md-8">
		<div class="group-content">
		<html:form action="/NhapDiemThi" method="POST">
			<div class="row main-nav">
				<p class="title">NHẬP ĐIỂM THI</p>
				<div class="form-group no-pad row">
					<label class="col-sm-2">Chọn môn thi:</label>
					<div class="col-sm-4">
						<html:select property="maMonThi" name="diemActionForm" styleId="f_maMonThi" styleClass="form-control" onchange="getNhapDiemThi()">
                    		<html:optionsCollection name="diemActionForm" property="listMonThi" label="tenMonThi" value="maMonThi"/>
	             		</html:select>
					</div>
					<label class="col-sm-2">Túi số:</label>
					<div class="col-sm-4">
						<html:select property="tuiSo" name="diemActionForm" styleId="f_tuiSo" styleClass="form-control" onchange="getNhapDiemThi()">
                    		<html:options name="diemActionForm" property="listTui"/>
	             		</html:select>
					</div>
				</div>
			</div>
		<div class="group-content">
  	    		<div class="title-content">
  	    		<div class="row">
					<div class="col-md-5 text-center">
						<h5>TRƯỜNG ĐẠI HỌC KHOA HỌC</h5>
						<h6><b>TUYỂN SINH NĂM ${diemActionForm.kyThi.namTuyenSinh}</b></h6>
					</div>
					<div class="col-md-7 text-center">
						<h6><b>BIÊN BẢN TỔNG HỢP CHẤM THI TUYỂN SINH</b></h6>
						<p>Hình thức đào tạo:  ${diemActionForm.kyThi.hinhThucDT}</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">	
						<p>Ngành:  ${diemActionForm.kyThi.nganh}</p>
						<p>Điểm thi:  ${diemActionForm.kyThi.coSoLKDT}</p>
					</div>
					<div class="col-md-4 col-sm-offset-1">
						<p><b>Môn thi: ${diemActionForm.monThi.tenMonThi}</b></p>
						<p>Túi số: ${diemActionForm.tuiSo}</p>
					</div>
				</div>
				</div>
		<div class="details_info">
			<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>STT</th>
					<th>Số phách</th>
					<th>Điểm</th>
					<th>Điểm chữ</th>
					<th>Ghi chú</th>
				</tr>
			</thead>
			<bean:define id="stt" value="0"/>
			<tbody>
				<logic:iterate id="bt" name="diemActionForm" property="listBaiThi">
				<tr>
					<bean:define id="stt" value="${stt+1}"/>
					<td style="text-align: center">${stt}</td>
					<td style="text-align: right">
						${bt.soPhach}	
						<input type="hidden" name="diemThi[${stt-1}].soPhach" value="${bt.soPhach}" >
					</td>
					<td>
						<%-- <input value="${bt.diemChamThi}" type="text" name="diemThi[${stt-1}].diemChamThi" class="form-control" id="input${stt-1}"> --%>
						<input value="${bt.diemChamThi}" type="text" name="diemThi[${stt-1}].diemChamThi" class="form-control in" id="in${stt-1}"
						>
					</td>
					<td>
						<span id="out${stt-1}" class="out"></span>
					</td>
					<td style="text-align: center"><bean:write name="bt" property="ghiChu"/></td>
				</tr>
				</logic:iterate>
			</tbody>
			</table>
			<div class="row totalCandidates">
			<div><div class="col-md-7">
					<p>Danh sách gồm có: <span id="soBT"> ${stt} </span> bài thi.</p>
					<p>Cán bộ chấm thi</p>
				</div>
				<div class="col-md-5 btn-group" style="text-align: center">
					<p>Thừa Thiên Huế, ngày.....tháng.....năm 20...</p>
					<p>TRƯỞNG BAN CHẤM THI</p>
				</div></div>			
			</div>	
		</div>
		</div>
		<div class="row">
			<div class="col-sm-3" style="float: right;" >
				<button type="submit" class="btn btn-success btn-all" name="save" id="save" value="save">Lưu</button>
				<button type="submit" class="btn btn-warning btn-all" name="xoaHet" value="xoaHet" onclick="clearCheckbox()" id="delete">Xóa hết</button>
				<!-- <button type="reset" name="resetForm" onclick="clearCheckbox()" class="btn btn-warning btn-all" id="delete">Xóa hết</button> -->
			</div>
		</div>
		</html:form>
		<logic:notEmpty name="diemActionForm" property="error">
			<div class="alert alert-danger" style="padding: 5px;">
			  ${diemActionForm.error }
			</div>	
		</logic:notEmpty></div>
		<div class="text-center" style="margin-bottom: 10px">
			<button type="submit" id="finish" class="btn btn-danger btn-all" name="save" value="finish">Kết thúc nhập</button>
		</div>
	</div>
</div>
</div>
<jsp:include page="Asset/Footer.jsp" />
<script type="text/javascript">
	$(document).ready(function(){
		<logic:notEmpty name="diemActionForm" property="notice">
			showNotice('${diemActionForm.notice}');
		</logic:notEmpty>
	});
</script>
</body>
</html>