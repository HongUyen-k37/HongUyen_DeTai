<!-- CuongB 23/02/2017 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<%@include file="header.jsp"%>

<div class="content" style="min-height: 600px">
    <!-- Nơi code content -->
    <div class="container">
           <h1 style="text-align: center;" class="title-h1">Chi tiết thành tích cá nhân</h1>
           <table class="table table-hover">
               <thead>
                    <tr class="success">
                        <th>ID</th>
                        <th>Tên bài thi</th>
                        <th>Thời gian thi</th>
                        <th>Thời gian làm bài</th>
                        <th>Số câu giải được</th>
                        <th></th>
                    </tr>
               </thead>
               <tbody>
               		<logic:iterate id="dsBaiThiThanhTich" name="thongKeBaiThiThanhTichActionForm" property="listBaiThiThanhTich">
                    <tr>
                       <td><bean:write name="dsBaiThiThanhTich" property="idBaiThi"/></td>
                       <bean:define id="idLanThi" name="dsBaiThiThanhTich" property="idLanThi"></bean:define>
                       <td><bean:write name="dsBaiThiThanhTich" property="tenBaiThi"/></td>
                       <td><bean:write name="dsBaiThiThanhTich" property="sThoiGianThi"/></td>
                       <td><bean:write name="dsBaiThiThanhTich" property="sThoiGianLamBai"/></td>
                       <td><bean:write name="dsBaiThiThanhTich" property="soCauTraLoiDung"/></td>
                       <td><a href="KetQua.do?idLanThi=${idLanThi}" class="icon icon-primary" title="Chi tiết lần thi"><i class="fa fa-search"></i></a></td>
                    </tr> 
                    </logic:iterate>                 
               </tbody>
              
           </table>
           <div class="phan-trang">
                <ul class="pagination">
                    
                </ul>
            </div>
    </div>
</div>

<%@include file="footer.jsp"%>