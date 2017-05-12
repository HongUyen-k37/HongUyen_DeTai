<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Biển bản chấm thi</title>
<jsp:include page="Asset/Head.jsp" />
</head>
<body>
<jsp:include page="Asset/Header.jsp" />
<jsp:include page="Asset/Menu2.jsp" />
<div class="container">
		<div class="group-content">
			<div class="row main-nav">
				<p class="title">BIÊN BẢN CHẤM THI</p>
				<div class="row">
				<div class="form-group col-sm-7">
			   		<label class="col-sm-2">Tên kỳ thi:</label>
			   		<bean:define id="kyThi" name="thongKeActionForm" property="kyThi"></bean:define>
			    	<div class="col-sm-10">
				      	<html:select property="maKyThi" name="kyThi" styleId="f_maKyThi" styleClass="form-control" onchange="getMaKyThi()">
	                    		<html:optionsCollection name="thongKeActionForm" property="listKyThi" label="tenKyThi" value="maKyThi"/>
		             	</html:select>
			    	</div>
			  	</div>
		    	<div class="form-group col-sm-5">
		    	<label class="col-sm-3">Môn thi:</label>
		    		<div class="col-sm-9">
			    		<html:select property="maMonThi" name="thongKeActionForm" styleId="f_maMonThi" styleClass="form-control" onchange="getTKBienBanChamThi()">
		                	<html:optionsCollection name="thongKeActionForm" property="listMonThi" label="tenMonThi" value="maMonThi"/>
			            </html:select>
		            </div>
		    	</div>
		    	</div>
	    		<div style="padding-bottom: 20px"><a class="btn btn-success btn-all" style="float:right;" onclick="printDiv('thongKeBBChamThi')">Tải xuống</a></div>
	    	<div class="group-content" id="thongKeBBChamThi">
   	    		<div class="title-content" >
					<div class="col-md-6">
						<h5>TRƯỜNG ĐẠI HỌC KHOA HỌC</h5>
						<h6 style="padding-left:30px;"><b>TUYỂN SINH NĂM <bean:write name="kyThi" property="namTuyenSinh"></bean:write></b></h6>
					</div>
					<div class="col-md-6 text-center">
						<h6 ><b>BIÊN BẢN CHẤM THI</b></h6>
						<p >Hình thức đào tạo: <bean:write name="kyThi" property="hinhThucDT"></bean:write></p>
					</div>
				</div>
				<div class="col-md-6">	
					<p>Ngành: <bean:write name="kyThi" property="nganh"></bean:write></p>
					<p>Điểm thi: <bean:write name="kyThi" property="coSoLKDT"></bean:write></p>
				</div>
				<div class="col-md-6 text-center">
					<p><b>Môn thi: ${thongKeActionForm.monThi.tenMonThi}</b></p>
				</div>
				
				<div class="details_info main-nav">
					<div class="main-list">
						<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th  rowspan="2" style="line-height: 45px;">STT</th>	
								<th rowspan="2" style="line-height: 45px;">Số phách</th>					
								<th colspan="2">Điểm thi</th>
								<th  rowspan="2" style="line-height: 45px;">Ghi chú</th>
							</tr>
							<tr>
								<th>Bằng số</th>
								<th>Bằng chữ</th>
							</tr>
						</thead>
						<bean:define id="stt" value="0"/>
						<tbody>
							<logic:iterate id="dsbt" name="thongKeActionForm" property="listTKBienBan">	
								<tr>	
									<bean:define id="stt" value="${stt+1}"/>
									<td style="text-align: center">${stt}</td>
									<td style="text-align: center"><bean:write name="dsbt" property="soPhach"/></td>
									
									<logic:notEqual value="-1" name="dsbt" property="diemChinhThuc">
										<td style="text-align: center">
											<bean:write name="dsbt" property="diemChinhThuc" />
											<input type="hidden" id="input${stt-1}" value="${dsbt.diemChamThi}" />
										</td>
					                    <td><span id="output${stt-1}"></span></td>
					                </logic:notEqual>
				                    <logic:equal value="-1" name="dsbt" property="diemChinhThuc">
					                    <input type="hidden" id="input${stt-1}" value="" />
					                    <td></td>
					                    <td><span id="output${stt-1}"></span></td>
				                    </logic:equal>
				                    <td style="text-align: center"><bean:write name="dsbt" property="ghiChu"/></td>
								</tr>
							</logic:iterate>
						</tbody>
						</table>
						<input type="hidden" id="soBaiThi" value="${stt}"/>
						<div class="row totalCandidates">
						<div><div class="col-md-7">
								<p>Danh sách gồm có: <span> ${stt} </span> bài thi.</p>
							</div>
							<div class="col-md-5 btn-group" style="text-align: center">
								<p>Thừa Thiên Huế, ngày.....tháng.....năm 20...</p>
							</div></div>
						<div class="row">
							<div class="col-md-3 text-center">
								<p>Cán bộ đọc điểm</p>	
							</div>
							<div class="col-md-4 text-center">				
								<p>Cán bộ nhập điểm</p>		
							</div>
							<div class="col-md-5 text-center">
								<p>TRƯỞNG BAN CHẤM THI</p>			
							</div>
						</div>				
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