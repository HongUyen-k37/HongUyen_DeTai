<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<%@include file="header.jsp" %>
<bean:define id="user" name="baiThiActionForm" property="user"></bean:define>
<bean:define id="idBaiThi" name="baiThiActionForm" property="idBaiThi"></bean:define>
<div class="content" style="min-height: 600px">
    <div class="container">
        <h2 class="col-md-12"><bean:write name="baiThiActionForm" property="tenBaiThi"/></h2>
        <div class="col-md-9">
            <div class="item detail clearfix">
                <div class="info">
                    <i class="fa fa-user"></i><span><bean:write name="user" property="hoTen"/></span>
                    <i class="fa fa-clock-o"></i><span><bean:write name="baiThiActionForm" property="thoiGian"/>phút</span>
                    <i class="fa fa-question-circle"></i><span><bean:write name="baiThiActionForm" property="soCauHoi"/> câu</span>
                    <i class="fa fa-bar-chart"></i><span><bean:write name="baiThiActionForm" property="soLuotLam"/></span>
                </div>
                <div class="des">
                	<bean:write name="baiThiActionForm" property="moTa"/>
                </div>
                <div class="rank">
                    <h5>Bảng xếp hạng</h5>
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Thành viên</th>
                                <th>Số câu trả lời đúng</th>
                                <th>Thời gian thi</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%--<logic:iterate id="dsChiTiet" name="baiThiActionForm" property="lst"> 
		                    	<tr>
		                    	<td><bean:write name="dsChiTiet" property=""/></td>
		                        <td><bean:write name="dsChiTiet" property="idUser"/></td>
		                        <td><bean:write name="dsChiTiet" property="hoTen"/></td>
		                        <td><bean:write name="dsChiTiet" property="soCauTraLoiDung"/></td>
		                        <td><bean:write name="dsChiTiet" property="thoiGianThi"/></td>
		                    	</tr>
                			</logic:iterate> --%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="do-this text-center">
                <a href="LamBaiThi.do?idBaiThi=${idBaiThi}">BẮT ĐẦU</a>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>
