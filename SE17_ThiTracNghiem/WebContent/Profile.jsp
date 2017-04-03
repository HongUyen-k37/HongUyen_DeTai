<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<%@include file="header.jsp" %>

<div class="content" style="min-height: 600px">
    <!-- Nơi code content -->
    <div class="container">
        <h1 class="title-h1">Thông tin cá nhân</h1>
        <div class="col-md-6">
            <html:form action="/CaNhan" styleClass="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-3 control-label">Họ và tên(*)</label>
                    <div class="col-sm-9">
                        <input type="text" name="hoTen" value='<bean:write name="userActionForm" property="hoTen" />' onchange="this.value=this.value.trim()" class="form-control" required="required"  maxlength="50"> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">Email(*)</label>
                    <div class="col-sm-9">
                        <input type="email" name="email" value='<bean:write name="userActionForm" property="email" />' onchange="this.value=this.value.trim()" class="form-control" required="required"  maxlength="50"> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">Password(*)</label>
                    <div class="col-sm-9">
                        <input type="password" name="password" value='<bean:write name="userActionForm" property="password" />' class="form-control" required="required"  maxlength="50"> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">Số điện thoại</label>
                    <div class="col-sm-9">
                        <input type="text" name="sdt" value='<bean:write name="userActionForm" property="sdt" />' class="form-control" maxlength="12" pattern="[0-9]{10,12}" data-toggle="tooltip" data-placement="bottom" data-original-title="Chỉ chứa số, độ dài từ 10-12 số"> 
                    </div>
                </div>
                 <div class="form-group">
                    <label class="col-sm-3 control-label">Đơn vị</label>
                    <div class="col-sm-9">
                        <input type="text" name="donVi" value='<bean:write name="userActionForm" property="donVi" />' onchange="this.value=this.value.trim()" class="form-control" maxlength="50"> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">Địa chỉ</label>
                    <div class="col-sm-9">
                        <input type="text" name="diaChi" value='<bean:write name="userActionForm" property="diaChi" />' onchange="this.value=this.value.trim()" class="form-control" maxlength="50"> 
                    </div>
                </div>          
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <input type="submit" name="capNhat" value="Cập nhật" class="btn btn-primary"></input>
                        <logic:equal name="userActionForm" property="role" value="3">
                        	<input type="submit" name="nangCap" value="Nâng cấp" class="btn btn-warning"></input>
                        </logic:equal>
                        <input type="reset" name="huy" value="Hủy" class="btn btn-normal"></input>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"></label>
                    <div class="col-sm-9">
                        <p>(*): Thông tin bắt buộc</p>
                    </div>
                </div>
            </html:form>      
        </div> 
        <div class="col-md-6">
            <form action="" method="POST" class="form-horizontal" role="form">
            <h4>Thành tích cá nhân</h4>
            <div class="" >
                <table class="table table-bordered table-hover text-center">
                    <thead>
                        <tr class="success">
                            <th class="text-center">Số bài thi</th>
                            <th class="text-center">Số câu hỏi</th>
                            <th class="text-center">Số câu giải được</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><bean:write name="userActionForm" property="soBaiThi"/> </td>
                             <td><bean:write name="userActionForm" property="tongCauHoi"/></td>
                             <td><bean:write name="userActionForm" property="tongCauDung"/></td>
                        </tr>
                    </tbody>
                </table>
            <div class="form-group" style="text-align: center;">
                <div class="col-sm-5 col-sm-offset-4">
                    <a href="TKBaiThiThanhTich.do" class="btn btn-primary">Chi tiết</a>
                </div>
            </div>
            </div>   
            </form>
        </div>  
    </div>          
</div>

<%@include file="footer.jsp"%>
