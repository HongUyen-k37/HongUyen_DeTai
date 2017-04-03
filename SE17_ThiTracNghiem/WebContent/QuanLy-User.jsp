
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
        <!-- Title h1 - căn giữa -->
        <h1 align="center" class="title-h1">Quản lý thành viên</h1>
        <!-- Table ID-UserName-HoTen-....-Nâng cấp|Cấp mật khẩu|Chặn -->
		<div id="search" class="col-md-5 mar-bot" style="float:right">
    		<html:form action="/QuanLyThanhVien" method="GET">   
         		<div class="form-search search-only">
             		<i class="search-icon glyphicon glyphicon-search"></i>
             		<input type="text" name ="search" class="form-control search-query">
         		</div>
         </html:form>
		</div>
        <table class="table table-hover table-bordered">
            <thead>
                <tr class="success">
                 	<th>STT</th>
                    <th>UserName</th>
                    <th>Họ tên</th>
                    <th>Email</th>
                    <th>SĐT</th>
                    <th></th>
                </tr>
            </thead>
            <bean:define id="stt" value="0"/>
            <tbody> 
            	<logic:iterate id="dsUser" name="userActionForm" property="listUser">
            		<bean:define id="idUser" name="dsUser" property="idUser"></bean:define> 
            		<bean:define id="stt" value="${stt+1}"/>      
                	<tr>
                	<td>${stt}</td>
                	<td><bean:write name="dsUser" property="username"/></td>
                    <td><bean:write name="dsUser" property="hoTen"/></td>
                    <td><bean:write name="dsUser" property="email"/></td>
                    <td><bean:write name="dsUser" property="sdt"/></td>           
                    <td>
                    <logic:equal name="dsUser" property="role" value="3">
                    <a href="SuaThanhVien.do?idUser=${idUser}&action=NangCap" class="btn btn-info" data-toggle="tooltip" data-placement="top" data-original-title="Nâng Cấp"><i class="fa fa-arrow-circle-up"></i></a>
                    </logic:equal>
                    <logic:notEqual name="dsUser" property="role" value="3">
                    <a href="SuaThanhVien.do?idUser=${idUser}&action=NangCap" class="btn btn-info" data-toggle="tooltip" data-placement="top" data-original-title="Hạ bậc" ><i class="fa fa-arrow-circle-down"></i></a>
                    </logic:notEqual>
                    <a href="SuaThanhVien.do?idUser=${idUser}&action=CapMK" class="btn btn-success" data-toggle="tooltip" data-placement="top" data-original-title="Cấp lại mật khẩu"><i class="fa fa-refresh"></i></a>
                    <logic:equal name="dsUser" property="active" value="true">
                    <a href="SuaThanhVien.do?idUser=${idUser}&action=Chan" class="btn btn-danger" data-toggle="tooltip" data-placement="top" data-original-title="Chặn"><i class="fa fa-minus-square"></i></a>
                    </logic:equal>
                    <logic:notEqual name="dsUser" property="active" value="true">
                    <a href="SuaThanhVien.do?idUser=${idUser}&action=Chan" class="btn btn-danger" data-toggle="tooltip" data-placement="top" data-original-title="Bỏ chặn"><i class="fa fa-check-square"></i></a>
                    </logic:notEqual>
                    </td>
                	</tr>
            	</logic:iterate>            
            </tbody>
        </table>

        <!-- Phân trang -->
       <div class="phan-trang" id="phan-trang">
                <ul class="pagination">
                	
                </ul>
       </div>
    </div>
    
</div>

<%@include file="footer.jsp"%>
<script type="text/javascript">
        // Code javascript
        var numPage=${userActionForm.total};
        var currentPage=${userActionForm.page};
        loadPhanTrang("phan-trang");
 </script>
