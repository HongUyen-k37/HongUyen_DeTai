
<!-- UyenTTH 9:00 21/02/2017 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@include file="header.jsp" %>



<div class="content" style="min-height: 600px">
    <div class="container">
           <h1 style="text-align: center;">Chi tiết lần thi</h1>
          	<h4 class="col-md-12">Tên bài thi: <bean:write name="ketQuaThiActionForm" property="tenBaiThi"/></h4>
          	<p class="col-md-6">Tổng số câu hỏi: <strong><bean:write name="ketQuaThiActionForm" property="soCauHoi"/></strong></p>
      		<p class="col-md-6">Thời gian bắt đầu thi: <strong><bean:write name="ketQuaThiActionForm" property="thoiGianBatDauThi"/></strong></p>
           	<p class="col-md-6">Số câu trả lời đúng: <strong><bean:write name="ketQuaThiActionForm" property="tongCauHoiDung"/></strong></p>
           	<p class="col-md-6">Thời gian làm bài: <strong><bean:write name="ketQuaThiActionForm" property="thoiGianThi"/></strong></p>
           	
           <table class="table table-hover table-bordered">
               <thead>
                    <tr class="success">
                        <th>Câu</th>
                        <th>Nội dung</th>
                        <th>Câu trả lời</th>
                        <th>Đáp án</th>                     
                    </tr>
               </thead>
               <tbody>
               		<bean:define id="stt" value="0"/>	
                    <logic:iterate id="dsKetQua" name="ketQuaThiActionForm" property="lst"> 
                    	<tr>
                    	<bean:define id="idLanThi" name="dsKetQua" property="idLanThi"></bean:define>
                    	<bean:define id="stt" value="${stt+1}"/>
                        <td>${stt}</td>
                        <td><bean:write name="dsKetQua" property="noiDung"/></td>
                        <logic:notEqual name="dsKetQua" property="dapAn" value="${dsKetQua.cauTraLoi}">
                    		<td class="warning"><bean:write name="dsKetQua" property="cauTraLoi"/></td>
                    	</logic:notEqual>
                    	<logic:equal name="dsKetQua" property="dapAn" value="${dsKetQua.cauTraLoi}">
                    		<td><bean:write name="dsKetQua" property="cauTraLoi"/></td>
                    	</logic:equal>
                        <td><bean:write name="dsKetQua" property="dapAn"/></td>
                    	</tr>
                	</logic:iterate>             
               </tbody>
           </table>
    </div>
</div>

<%@include file="footer.jsp" %>