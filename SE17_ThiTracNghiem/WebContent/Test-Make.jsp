<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<%@include file="header.jsp" %>
<bean:define id="user" name="lanThiActionForm" property="user"></bean:define>
<bean:define id="baiThi" name="lanThiActionForm" property="baiThi"></bean:define>
<bean:define id="timeLeft" name="lanThiActionForm" property="timeLeft"></bean:define>
<script>
var listAnswer=[];
</script>
<bean:define id="idLanThi" name="lanThiActionForm" property="idLanThi"/>
<div class="content" style="min-height: 600px">
    <div class="container">
    	<form action="KetQua.do" name="KetThucLanThi">
    		<input type="hidden" name="idLanThi" value='${idLanThi}'/>
    	</form>
        <h2 class="col-md-12"><bean:write name="baiThi" property="tenBaiThi"/></h2>
        <div class="col-md-9">
            <div class="item detail clearfix">
                <div class="info">
                    <i class="fa fa-user"></i><span><bean:write name="user" property="hoTen"/></span>
                    <i class="fa fa-clock-o"></i><span><bean:write name="baiThi" property="thoiGian"/> phút</span>
                    <i class="fa fa-question-circle"></i><span><bean:write name="baiThi" property="soCauHoi"/> câu</span>
                    <i class="fa fa-bar-chart"></i><span><bean:write name="baiThi" property="soLuotLam"/></span>
                    
                </div>
                
            </div>
            <div class="list-quest">
            	<logic:iterate id="ch" name="lanThiActionForm" property="listCauHoi">
            	<bean:define id="viTri" name="ch" property="viTri"/>
                <a href="javascript:void(0)" onclick="showQuest(${viTri})"><span class="label">${viTri}</span></a>
                </logic:iterate>
            </div>
            <logic:iterate id="ch" name="lanThiActionForm" property="listCauHoi">
            	<bean:define id="idCauHoi" name="ch" property="idCauHoi"></bean:define>
            	<bean:define id="viTri" name="ch" property="viTri"></bean:define>
            	<logic:notEmpty name="ch" property="traLoiChon">
            		<bean:define id="traLoiChon" name="ch" property="traLoiChon"></bean:define>
            	</logic:notEmpty>
            	<logic:empty name="ch" property="traLoiChon">
            		<bean:define id="traLoiChon" value=""></bean:define>
            	</logic:empty>
            	<div id="question_${viTri}" class="cau-hoi">
	                <div class="panel panel-info">
	                    <div class="panel-heading">
	                        <h3 class="panel-title">Câu ${viTri}</h3>
	                    </div>
	                    <div class="panel-body clearfix">
	                   		<input type="hidden" name="idCauHoi" class="form-control" value="${idCauHoi}">
	                        <div class="question">
	                            <bean:write name="ch" property="noiDung"/>
	                        </div>
	                        <logic:notEqual name="ch" property="traLoiMot" value="">
	                        <div class="answer">
	                        	<label for="answer_${viTri}">
	                            	<input type="radio" name="answer_${viTri}">
	                            <span><bean:write name="ch" property="traLoiMot"/></span></label>
	                        </div>
	                        </logic:notEqual>
	                        <logic:notEqual name="ch" property="traLoiHai" value="">
	                        <div class="answer">
	                        	<label for="answer_${viTri}">
	                            	<input type="radio" name="answer_${viTri}">
	                            <span><bean:write name="ch" property="traLoiHai"/></span></label>
	                        </div>
	                        </logic:notEqual>
	                        <logic:notEqual name="ch" property="traLoiBa" value="">
	                        <div class="answer">
	                       	 	<label for="answer_${viTri}">
	                            	<input type="radio" name="answer_${viTri}">
	                            <span><bean:write name="ch" property="traLoiBa"/></span></label>
	                        </div>
	                        </logic:notEqual>
	                        <logic:notEqual name="ch" property="traLoiBon" value="">
	                        <div class="answer">
	                        	<label for="answer_${viTri}">
	                            	<input type="radio" name="answer_${viTri}">
	                            <span><bean:write name="ch" property="traLoiBon"/></span></label>
	                        </div>
	                        </logic:notEqual>
	                    </div>
	                </div>
                    <script>listAnswer.push("${traLoiChon}".trim());</script>
            	</div>
            </logic:iterate>
            <ul class="pager">
                <li class="prev disabled"><a href="javascript:void(0)" onclick="prevQuest()"><i class="fa fa-angle-double-left"></i> Trước</a></li>
                <li class="next"><a href="javascript:void(0)" onclick="nextQuest()" style="float: none;">Tiếp <i class="fa fa-angle-double-right"></i></a></li>
            </ul>
            
        </div>
        <div class="col-md-3">
            <div class="clock text-center">
                <p>THỜI GIAN CÒN LẠI</p>
                <div id="time-down">
                    <span id="hours">01</span>
                    <span>:</span>
                    <span id="minutes">32</span>
                    <span>:</span>
                    <span id="seconds">27</span>
                </div>
            </div>
            <div class="complete">
                <a href="#ketThucLanThi" data-toggle="modal" class="btn btn-danger">Hoàn tất</a>
            </div>
        </div>
    	
    </div>
</div>

<div class="modal fade" id="ketThucLanThi">
    <div class="modal-dialog">
        <div class="modal-content">
        	
        	<div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Hoàn tất lần thi</h4>
            </div>
            
             <div class="modal-body">
             	<p>Bạn đã hoàn thành <strong>12/20</strong> câu hỏi.</p>
             	<p>Bạn có chắc chắn muốn hoàn tất bài thi này?</p>
             </div>
            
            <div class="modal-footer">
            	<button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
            	<a href="javascript:void(0)" onclick="hoanTatBaiThi()" class="btn btn-primary">Đồng ý</a>
            </div>
        </div>
    </div>
</div>


<%@include file="footer.jsp" %>
<script type="text/javascript">
        var timeDown = ${timeLeft};
        $($(".cau-hoi")[0]).addClass("hientai");
        initializeClock('time-down', new Date(Date.parse(new Date()) +  timeDown*1000));
        $("#ketThucLanThi .modal-body strong").html($(".label-primary").length+"/"+$(".label").length);
        chooseAnswer();	
</script>
