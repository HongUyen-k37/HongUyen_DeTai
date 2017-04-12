<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<p class="title">THÔNG TIN KỲ THI</p>
			<form class="form-horizontal">
				<div class="form-group">
			   		<label class="col-sm-3">Tên kỳ thi:</label>
			    	<div class="col-sm-9">
				      	<html:select property="maKyThi" name="thiSinhActionForm" styleId="f_maKyThi" styleClass="form-control" onchange="getMaKyThi()">
	                    		<html:optionsCollection name="thiSinhActionForm" property="listKyThi" label="tenKyThi" value="maKyThi"/>
		             	</html:select>
			    	</div>
			  	</div>
			  	<div class="form-group">
			    	<label class="col-sm-3">Ngành:</label>
			    	<div class="col-sm-9">
			      		<select class="form-control" disabled>
							<option value="FPT">FPT</option>
							<option value="gosu">Gosu</option>
						</select>
			    	</div>
			    </div>
			    <div class="form-group">	
			    	<label class="col-sm-3">Ngày thi:</label>
			    	<div class="col-sm-9">
			      		<input type="text" class="form-control" id="ngaythi" disabled>
			    	</div>
			    </div>
				<div class="form-group">
			    	<label class="col-sm-6">Năm tuyển sinh:</label>
			    	<div class="col-sm-6"> 
			      		<input type="number" class="form-control" id="namts" min="2015" disabled>
			    	</div>
			    </div>
			    <div class="form-group">
			    	<label class="col-sm-6">Hình thức đào tạo:</label>
			    	<div class="col-sm-6">
			    		<select class="form-control" disabled>
							<option value="dh">Đại học</option>
							<option value="ch">Cao học</option>
						</select>
		    		</div>
			  	</div>
			  	<div class="form-group">
			    	<label class="col-sm-6">Cơ sở liên kết đào tạo:</label>
			    	<div class="col-sm-6">
			      		<input type="text" class="form-control" id="cslkdt" disabled>
			    	</div>
			  	</div>
			  	<div class="form-group">
			    	<label class="col-sm-6">Danh sách các môn thi:</label>
			    	<div class="col-sm-6">
			      		<textarea class="form-control" rows="3" disabled></textarea>
			   		 </div>
			  	</div>
			  	</form>