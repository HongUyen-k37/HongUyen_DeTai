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
        <h1 align="center" class="title-h1">Chi tiết bài thi </h1>
        <h3 align="center">${thongKeChiTietActionForm.tenBaiThi}</h3>
        <p><b>Số thành viên làm bài: <bean:write name="thongKeChiTietActionForm" property = "soThanhVienlam"/></b> </p>
        <p><b>Số câu hỏi: <bean:write name="thongKeChiTietActionForm" property = "tongSoCauHoi"/></b></p>

        <table class="table table-hover table-bordered">
            <thead>
                <tr class="success">
                    <th>ID User</th>
                    <th>Họ và tên thí sinh</th>
                    <th>Số câu trả lời đúng</th>
                    <th>Thời gian thi</th>
                    <th>Thời gian làm bài</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>           
           		<logic:iterate id="dsTKThanhTich" name="thongKeChiTietActionForm" property="listTKThanhTich">
                   <tr>
                       <td><bean:write name="dsTKThanhTich" property="idUser"/></td>
                       <td><bean:write name="dsTKThanhTich" property="hoTen"/></td>
                       <td><bean:write name="dsTKThanhTich" property="soCauTraLoiDung"/></td>
                       <td><bean:write name="dsTKThanhTich" property="sThoiGianThi"/></td>
                       <td><bean:write name="dsTKThanhTich" property="sThoiGianLamBai"/></td> 
                       <td class="text-center"><a href="#xoaLanThi"  data-toggle="modal" class="icon icon-danger" title="Hủy lần thi"><i class="fa fa-times"></i></a></td>                         
                   </tr>  
                   </logic:iterate>      
            </tbody>
        </table>
        <div class="phan-trang" id="phan-trang">
                <ul class="pagination">
                   
                </ul>
            </div>  
    </div>

</div>
<div class="modal fade" id="xoaLanThi">
    <div class="modal-dialog">
        <div class="modal-content">
        	
        	<div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Xóa lần thi</h4>
            </div>
            
             <div class="modal-body">
             	<p>Việc xóa lần thi này sẽ ảnh hưởng đến thành tích của thành viên</p>
             	<p>Bạn có chắc chắn xóa lần thi này?</p>
             </div>
            
            <div class="modal-footer">
            	<button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
            	<a href="XoaLanThi.do?idUser=${dsTKThanhTich.idUser}&idBaiThi=${dsTKThanhTich.idBaiThi}"  class="btn btn-danger">Đồng ý</a>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>
<script type="text/javascript">
var numPage=${thongKeChiTietActionForm.total};
var currentPage=${thongKeChiTietActionForm.page};
loadPhanTrang("phan-trang");
</script>