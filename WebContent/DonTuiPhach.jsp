<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tuyển sinh</title>
<jsp:include page="Asset/Head.jsp" />
</head>
<body>
<jsp:include page="Asset/Header.jsp" />
<jsp:include page="Asset/Menu2.jsp" />
<div class="container">

<div class="row">
	<div class="col-md-4 no-pad">
		<div class="thongtinkithi group-content">
			<div class="main-nav">
				<bean:define id="listMaKyThi" name="baiThiActionForm"></bean:define>
				<%@include file="Asset/ThongTinKyThi.jsp" %>
			</div>
		</div>
	</div>
	<div class="col-md-8">
		<div class="group-content">
			<div class="row main-nav">
		<p class="title">DỒN TÚI</p>
		<html:form action="/DonTuiPhach" method="post">
		<div class="col-sm-6 col-sm-offset-3" style="margin-bottom: 10px;">
			<label class="col-sm-3">Môn thi:</label>
    		<div class="col-sm-9">
	    		<html:select property="maMonThi" name="baiThiActionForm" styleId="f_maMonThi" styleClass="form-control" onchange="getDonTuiPhach()">
                	<html:optionsCollection name="baiThiActionForm" property="listMonThi" label="tenMonThi" value="maMonThi"/>
	            </html:select>	
            </div>
		</div>
		<div class="row">
			<div class="col-md-5 form-group">
				<label class="col-md-5">Cơ số phòng:</label>
				<div class="col-md-7">
					<input type="number" class="form-control" name="coSoPhong" min="1" value="${baiThiActionForm.coSoPhong}">
				</div>
			</div>
			<div class="col-md-4 form-group">
				<label class="col-md-5">Cơ số túi:</label>
				<div class="col-md-7 no-pad">
					<input type="number" class="form-control" name="coSoTui" min="1" value="${baiThiActionForm.coSoTui}">
				</div>
			</div>
			<div class="col-sm-3">
				<button type="submit" class="btn btn-success btn-all" name="submit" value="execute">Thực hiện</button>
			</div>
			<logic:notEmpty name="baiThiActionForm" property="error">
				<div class="alert alert-danger" style="padding: 5px;">
				  ${baiThiActionForm.error }
				</div>	
			</logic:notEmpty>
		</div>
		</html:form>
		<div class="row">
			<div class="col-md-5">
				<div class="col-md-3 form-group">
					<label>Lượt:</label>
				</div>
				<div class="col-md-9 form-group">
					<select id="soLuot" class="form-control">
						
					</select>
				</div>
			</div>
			<div class="col-md-5">
				<div class="col-md-6 no-pad form-group">
					<label>/Số lượt thực hiện: ${baiThiActionForm.soLuot}</label>
				</div>
				<div class="col-md-6 no-pad">
				</div>	
			</div>
		</div>
	</div>
		<div class="details_info" style="text-align:center" id="donTuiPhach">
			<table class="table table-bordered table-hover table-striped">
			<thead id="headTable">
				<tr id="soPhong">
					<th rowspan="2"></th>
					<!-- In so phong tai day -->
				</tr>
				<tr id="soBaiDanhSoPhach">
					<!-- In cap text tuong ung voi so phong tai day -->
				</tr>
			</thead>
			<tbody id="bodyTable">
				
			</tbody>
			</table>
		</div>
		<button class="btn btn-success btn-all" onclick="printDiv('donTuiPhach')">In dồn túi</button>
	</div>
</div>
</div>

</div>
<jsp:include page="Asset/Footer.jsp" />
<script type="text/javascript">
	
	function loadSelectLuot(soLuot){
		for(var i=0;i<soLuot;i++){
			var html='<option value='+(i+1)+'>'+(i+1)+'</option>';
			$("#soLuot").append(html);	
		}
		
	}
	var soLuot=${baiThiActionForm.soLuot};
	loadSelectLuot(soLuot);
	if($("#soLuot").val()) loadData($("#soLuot").val());
	$("#soLuot").on("change load",function(){
		loadData($(this).val());
	});
	function loadData(luot){
		$("#bodyTable").html("");
		$("#soPhong").html("<th rowspan='2'></th>");
		$("#soBaiDanhSoPhach").html("");
		$.ajax({
			type: "POST",
			data:{
				maKyThi : $("[name='maKyThi']").val(),
				maMonThi: $("[name='maMonThi']").val()
			},
			url:"GetBaiThiDonTui.do",
			success: function (result) {
				result=JSON.parse(result);
				var monThi=result[2];
				var coSoPhong=monThi.coSoPhongThi;
				var coSoTui=monThi.coSoTui;
				
				var listPhong=result[0];
				var listTui=[];
				for(var i=0;i<coSoTui*monThi.soLuot;i++) listTui.push([]);
				var listBaiThi=result[1];
				var maxRoom=new Array(listTui.length);
				for(var i=0;i<listBaiThi.length;i++){
					var baiThi=listBaiThi[i];
					listTui[baiThi.tuiSo-1].push(baiThi);
				}
				var maxRoom=[];
				for(var i=0;i<listTui.length;i++)
				{
					var roomSlot={};
					for(var j=0;j<listPhong.length;j++) roomSlot[listPhong[j].soHieuPhongThi]=0;
					for(var j=0;j<listTui[i].length;j++){
						roomSlot[listTui[i][j].phong]++;
					}
					var max=0;
					for(var j=0;j<listPhong.length;j++) if(max<roomSlot[listPhong[j].soHieuPhongThi]) max=roomSlot[listPhong[j].soHieuPhongThi];
					maxRoom.push(max);
				}
				for(var i=(luot-1)*coSoPhong;i<luot*coSoPhong;i++){
					var html='<th colspan="2">Phòng '+listPhong[i].soHieuPhongThi+'</th>';
					$("#soPhong").append(html);
					$("#soBaiDanhSoPhach").append("<th>SBD</th><th>Số phách</th>");
				}
				for(var i=(luot-1)*coSoTui;i<luot*coSoTui;i++){
					var size=maxRoom[i];
					var html='<tr><th rowspan="'+size+'">Túi '+(i+1)+'</th>';
					for(var j=0;j<size;j++){
						for(var k=(luot-1)*coSoPhong;k<luot*coSoPhong;k++){
							html+='<td id="sbd_'+(i+1)+'_'+listPhong[k].soHieuPhongThi+'_'+j+'"></td>';
							html+='<td id="sp_'+(i+1)+'_'+listPhong[k].soHieuPhongThi+'_'+j+'"></td>';
						}
						if(j!=size-1) html+="</tr><tr>";
					}
					html+="</tr>";
					$("#bodyTable").append(html);
				}
				for(var i=0;i<listBaiThi.length;i++){
					var baiThi=listBaiThi[i];
					var locationSBD="#sbd_"+baiThi.tuiSo+"_"+baiThi.phong+"_";
					var locationSP="#sp_"+baiThi.tuiSo+"_"+baiThi.phong+"_";
					var x=0;
					
					while($(locationSBD+x).html()!="" && $(locationSBD+x).length!=0){
						x++;
					}
					$(locationSBD+x).append(baiThi.soBaoDanh);
					$(locationSP+x).append(baiThi.soPhach);
				}
			}
		});
	}
	
</script>
</body>
</html>