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
		<div class="col-sm-6 col-sm-offset-3">
			<label class="col-sm-3">Môn thi:</label>
    		<div class="col-sm-9">
	    		<html:select property="maMonThi" name="baiThiActionForm" styleId="f_maMonThi" styleClass="form-control" onchange="getDonTuiPhach()">
                	<html:optionsCollection name="baiThiActionForm" property="listMonThi" label="tenMonThi" value="maMonThi"/>
	            </html:select>
            </div>
		</div>
		<div class="row">
		<html:form action="/DonTuiPhach" method="post">
			<div class="col-md-5 form-group">
				<label class="col-md-5">Cơ số phòng:</label>
				<div class="col-md-7">
					<input type="number" class="form-control" name="coSoPhong" min="1" value="${baiThiActionForm.coSoPhong}">
				</div>
			</div>
			<div class="col-md-5 form-group">
				<label class="col-md-5">Cơ số túi:</label>
				<div class="col-md-7 no-pad">
					<input type="number" class="form-control" name="coSoTui" min="1" value="${baiThiActionForm.coSoTui}">
				</div>
			</div>
			<div class="btn-gr col-md-2">
				<button type="submit" class="btn btn-success btn-all" name="submit" value="cal">Tính số lượt</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="col-md-3 form-group">
					<label>Lượt:</label>
				</div>
				<div class="col-md-9">
					<input class="form-control" type="number" name="luot">
				</div>
			</div>
			<div class="col-md-5">
				<div class="col-md-6 no-pad form-group">
					<label>/Số lượt thực hiện: ${baiThiActionForm.soLuot}</label>
				</div>
				<div class="col-md-6 no-pad">
				</div>	
			</div>
			<div class="col-md-2">
				<button type="submit" class="btn btn-success btn-all" name="submit" value="execute">Thực hiện</button>
			</div>
			</html:form>
		</div>
	</div>
		<div class="details_info">
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
			<div class="row">
				<p class="col-md-10">Danh sách gồm có: <span> 50/100 </span> sinh viên</p>
				<div class="col-md-2"><button type="submit" class="btn btn-success btn-all" name="execute">In dồn túi</button></div>
			</div>
		</div>
	</div>
</div>
</div>

</div>
<jsp:include page="Asset/Footer.jsp" />
<script type="text/javascript">

	var listPhong=[15,23,31,41];
	var baiThi1={"soBaoDanh":5,"soPhach":10,"phong":15,};
	var baiThi2={"soBaoDanh":5,"soPhach":10,"phong":23};
	var baiThi3={"soBaoDanh":5,"soPhach":10,"phong":31};
	var baiThi4={"soBaoDanh":5,"soPhach":10,"phong":41};

	var tui=[baiThi1,baiThi1,baiThi1,baiThi2,baiThi2,baiThi2,baiThi2,baiThi3,baiThi3,baiThi3,baiThi4,baiThi4];
	var listTui=[tui,tui,tui];
	var phong1=[baiThi1,baiThi1,baiThi1,baiThi1,baiThi1,baiThi1]
	var listPhong=
		for(var i=0;i<listPhong.length;i++){
			var html='<th colspan="2">Phòng '+listPhong[i]+'</th>';
			$("#soPhong").append(html);
			$("#soBaiDanhSoPhach").append("<th>SBD</th><th>So Phach</th>");
		}
		for(var i=0;i<listTui.length;i++){
			var size=Math.ceil(listTui[i].length/listPhong.length);
			var html='<tr><th rowspan="'+size+'">Tui '+(i+1)+'</th>';
			for(var j=0;j<size;j++){
				for(var k=0;k<listPhong.length;k++){
					html+='<td id="sbd_'+i+'_'+j+'_'+listPhong[k]+'"></td>';
					html+='<td id="sp_'+i+'_'+j+'_'+listPhong[k]+'"></td>';
				}
				if(j!=size-1) html+="</tr><tr>";
			}
			html+="</tr>";
			$("#bodyTable").append(html);
		}
		for(var i=0;i<listTui.length;i++){
			for(var j=0;j<listTui[i].length;j++){
				var baiThi=listTui[i][j];
				var locationSBD="#sbd_"+i+"_"+(j%listPhong.length)+"_"+baiThi.phong;
				var locationSP="#sp_"+i+"_"+(j%listPhong.length)+"_"+baiThi.phong;
				$(locationSBD).append(baiThi.soBaoDanh);
				$(locationSP).append(baiThi.soPhach);
			}
			
		}

</script>
</body>
</html>