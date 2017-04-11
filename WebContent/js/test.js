var test = 0 ;
function suaKyThi(maKyThi){
	document.forms.formCreateEdit.reset();
	document.forms.formCreateEdit.action="SuaKyThi.do?maKyThi="+maKyThi;
	$(".modal-title").html("Sửa kỳ thi");
	$.ajax({
		type: "POST",
		data:{
			maKyThi : maKyThi,
		},
		url:"GetKyThi.do",
		success: function (result) {
			result=JSON.parse(result);
			test=result;
			$("#f_tenKyThi").val(result["tenKyThi"]);
			$("#f_ngayThi").val(result["ngayThi"]);
			$("#f_namTuyenSinh").val(result["namTuyenSinh"]);
			$("#f_nganh").val(result["nganh"]);
			$("#f_hinhThucDT").val(result["hinhThucDT"]);
			$("#f_coSoLKDT").val(result["coSoLKDT"]);
			//$("#f_maMonThi").val(result["maMonThi"]).trigger("change");
	    }
	});
	$("#modal-kythi").modal();
}
function taoKyThi(){
	document.forms.formCreateEdit.reset();
	document.forms.formCreateEdit.action="ThemKyThi.do";
	$(".modal-title").html("Thêm kỳ thi");
	
	$("#modal-kythi").modal();
}

function linkTo(ma,value){
   var url=window.location.href;
   var x = url.split("/");
   x=x[x.length-1];
   var i=x.indexOf(".do");
   x=x.substring(0,i+3);
   window.location.href=x+"?"+ma+"="+value;
}
function taoHTMLMonThi(that){
	var htmlMonThi='<div class="form-group row"><div class="col-sm-8 col-sm-offset-2"><input type="text" class="form-control" placeholder="Tên môn thi"></div><button onclick="luuMonThi(this)" type="button" class="btn btn-default" title="Xóa câu hỏi"><i class="glyphicon glyphicon-ok"></i></button><button onclick="xoaMonThi(this)" type="button" class="btn btn-default" title="Xóa câu hỏi"><i class="glyphicon glyphicon-remove"></i></button></div>'
	$(htmlMonThi).insertBefore($(that));
}

//Thiếu kết thúc lưu môn thi --> submit
function luuMonThi(that){
	var tenMonThi=$(that).parent().find("input").val();
	console.log("Load ajax insert: "+tenMonThi);
	$("#soMonThi")
}

function xoaMonThi(that){
	var tenMonThi=$(that).parent().find("input").val();
	console.log("Load ajax delete: "+tenMonThi);
	$(that).parent().remove();
}

function taoThiSinh(){
	document.forms.formCreateEdit.reset();
	document.forms.formCreateEdit.action="ThemThiSinh.do";
	$(".modal-title").html("Thêm thí sinh");
	$("#modal-thisinh").modal();
}

function suaThiSinh(maThiSinh){
	document.forms.formCreateEdit.reset();
	document.forms.formCreateEdit.action="SuaThiSinh.do?maThiSinh="+maThiSinh;
	$(".modal-title").html("Sửa thí sinh");
	$.ajax({
		type: "POST",
		data:{
			maThiSinh : maThiSinh,
		},
		url:"GetThiSinh.do",
		success: function (result) {
			result=JSON.parse(result);
			test=result;
			$("#f_hoDem").val(result["hoDem"]);
			$("#f_ten").val(result["ten"]);
			$("#f_ngaySinh").val(result["ngaySinh"]);
			$("#f_noiSinh").val(result["noiSinh"]);
			$("#f_khuVuc").val(result["khuVuc"]);
			$("#f_doiTuong").val(result["doiTuong"]);
			$("#f_dienThoai").val(result["dienThoai"]);
			$("#f_email").val(result["email"]);
			$("#f_diaChi").val(result["diaChi"]);
	    }
	});
	$("#modal-thisinh").modal();
}
function suaPhongThi(maPhongThi){
	document.forms.formCreateEdit.reset();
	document.forms.formCreateEdit.action="SuaPhongThi.do?maPhongThi="+maPhongThi;
	$(".modal-title").html("Sửa phòng thi");
	$.ajax({
		type: "POST",
		data:{
			maPhongThi : maPhongThi,
		},
		url:"GetPhongThi.do",
		success: function (result) {
			result=JSON.parse(result);
			test=result;
			$("#f_soHieuPhongThi").val(result["soHieuPhongThi"]);
			$("#f_soLuongThiSinh").val(result["soLuongThiSinh"]);
	    }
	});
	$("#modal-phongthi").modal();
}
function taoPhongThi(){
	document.forms.formCreateEdit.reset();
	document.forms.formCreateEdit.action="ThemPhongThi.do";
	$(".modal-title").html("Thêm phòng thi");
	
	$("#modal-phongthi").modal();
}


function getMaKyThi(){
	var makt = $("#f_maKyThi").val();
	document.location.href="ThiSinh.do?maKyThi="+makt;
}
function getMaKyThi2(){
	var makt = $("#f_maKyThi").val();
	document.location.href="PhanPhongThi.do?maKyThi="+makt;
}
