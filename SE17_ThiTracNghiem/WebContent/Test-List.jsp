
<!-- UyenTTH 9:00 21/02/2017 -->
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
        <div class="col-md-9 test">
        	<logic:notEmpty name="baiThiActionForm" property="listQuanTrong">  
            <div class="hot-test clearfix">
                <h3 class="">Bài thi quan trọng</h3>
                <logic:iterate id="a" name="baiThiActionForm" property="listQuanTrong">
                <bean:define id="idBaiThi" name="a" property="idBaiThi"></bean:define> 
                <bean:define id="tenBaiThi" name="a" property="tenBaiThi"></bean:define>
                <div class="col-md-4">
                    <div class="item">
                        <a href="ChiTietBaiThi.do?idBaiThi=${idBaiThi}" class="title" title="${tenBaiThi}"><span>${tenBaiThi}</span></a>
                       <div class="info">
                           <i class="fa fa-clock-o"></i><span><bean:write name="a" property="thoiGian"/></span>
                           <i class="fa fa-question-circle"></i><span><bean:write name="a" property="soCauHoi"/></span>
                           <i class="fa fa-bar-chart"></i><span><bean:write name="a" property="soLuotLam"/></span>
                  			<logic:notEmpty name="a" property="password">
                  				<i class="fa fa-lock"></i>
                  			</logic:notEmpty>
                       </div>
                       <div class="desc ellipsis">
                           <bean:write name="a" property="moTa"/>
                       </div>
                       <div class="do-now">
                          <a href="LamBaiThi.do?idBaiThi=${idBaiThi}" class="btn btn-danger">Làm ngay</a> 
                          <a href="ChiTietBaiThi.do?idBaiThi=${idBaiThi}" class="detail">Chi tiết <i class="fa fa-angle-double-right"></i></a>
                       </div> 
                    </div>
                </div>
                </logic:iterate>
            </div>
            </logic:notEmpty> 
            <logic:notEmpty name="baiThiActionForm" property="listNoiBat">  
            <div class="new-test clearfix">
                <h3 class="">Bài thi nổi bật</h3>
                <logic:iterate id="b" name="baiThiActionForm" property="listNoiBat"> 
                <bean:define id="idBaiThi" name="b" property="idBaiThi"></bean:define>
                <bean:define id="tenBaiThi" name="b" property="tenBaiThi"></bean:define>
                <div class="col-md-4">
                    <div class="item">
                        <a href="#" class="title" title="${tenBaiThi}"><span>${tenBaiThi}</span></a>
                        <div class="info">
                            <i class="fa fa-clock-o"></i><span><bean:write name="b" property="thoiGian"/></span>
                            <i class="fa fa-question-circle"></i><span><bean:write name="b" property="soCauHoi"/></span>
                            <i class="fa fa-bar-chart"></i><span><bean:write name="b" property="soLuotLam"/></span>
                        	<logic:notEmpty name="b" property="password">
                  				<i class="fa fa-lock"></i>
                  			</logic:notEmpty>
                        </div>
                        <div class="desc ellipsis">
                            <bean:write name="b" property="moTa"/>
                        </div>
                        <div class="do-now">
                        
                           <a href="LamBaiThi.do?idBaiThi=${idBaiThi}" class="btn btn-danger">Làm ngay</a> 
                           <a href="ChiTietBaiThi.do?idBaiThi=${idBaiThi}" class="detail">Chi tiết <i class="fa fa-angle-double-right"></i></a>
                        </div>
                    </div>
                </div>
                </logic:iterate> 
          	</div> 
            </logic:notEmpty>  
            <div class="list-test clearfix">
                <h3 class="">Danh sách bài thi</h3>
                <logic:iterate id="dsBaiThi" name="baiThiActionForm" property="lst"> 
                <bean:define id="idBaiThi" name="dsBaiThi" property="idBaiThi"></bean:define>
                <bean:define id="tenBaiThi" name="dsBaiThi" property="tenBaiThi"></bean:define>
                <div class="col-md-4">
                    <div class="item">
                    
                        <a href="ChiTietBaiThi.do?idBaiThi=${idBaiThi}" class="title" title="${tenBaiThi}"><span>${tenBaiThi}</span></a>
                        <div class="info">
                            <i class="fa fa-clock-o"></i><span><bean:write name="dsBaiThi" property="thoiGian"/></span>
                            <i class="fa fa-question-circle"></i><span><bean:write name="dsBaiThi" property="soCauHoi"/></span>
                            <i class="fa fa-bar-chart"></i><span><bean:write name="dsBaiThi" property="soLuotLam"/></span>
                        	<logic:notEmpty name="dsBaiThi" property="password">
                  				<i class="fa fa-lock"></i>
                  			</logic:notEmpty>
                        </div>
                        <div class="desc ellipsis">
                            <bean:write name="dsBaiThi" property="moTa"/>
                        </div>
                        <div class="do-now">
                          <a href="LamBaiThi.do?idBaiThi=${idBaiThi}" class="btn btn-danger">Làm ngay</a> 
                           <a href="ChiTietBaiThi.do?idBaiThi=${idBaiThi}" class="detail">Chi tiết <i class="fa fa-angle-double-right"></i></a>
                        </div> 
                    
                    </div>
                </div>
                </logic:iterate>
            </div>
               
            <div class="phan-trang" id="phan-trang">
                <ul class="pagination">
                	
                </ul>
            </div>
   		</div>
        <div class="col-md-3 col-right">
        	<html:form action="/BaiThi" method="GET">
	            <div id="search" class="search">
	                <div class="form-search search-only">
	                  <i class="search-icon glyphicon glyphicon-search"></i>
	                  <input type="text" name="search" class="form-control search-query">
	                </div>
	            </div>
            </html:form>
            <div class="category-header">Danh mục</div>
            <div class="category item">
                <ul>     
                <logic:iterate id="dsLoai" name="baiThiActionForm" property="listLoai"> 
            		<bean:define id="idLoai" name="dsLoai" property="idLoai"></bean:define>    
                    <li><a href="BaiThi.do?idLoai=${idLoai}"><i class="fa fa-chevron-right"></i><span><bean:write name="dsLoai" property="tenLoai"/></span></a></li>
                </logic:iterate>
                </ul>
            </div>
        </div>
    </div>
</div>


<%@include file="footer.jsp" %>

<script type="text/javascript">
	var numPage=${baiThiActionForm.total};
	var currentPage=${baiThiActionForm.page};
	loadPhanTrang("phan-trang");
	var x=$(".item .title span");
	shortString(x,17);
</script>