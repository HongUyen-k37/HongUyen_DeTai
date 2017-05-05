//$('#menu li').hover(
//	function() {
//	 $('ul', this).stop().slideDown(200);
//	 },
//	function() {
//	 $('ul', this).stop().slideUp(200);
//	 }
//);
function mouseOn(that){
	 $('ul', that).stop().slideDown(200);
}
function mouseOut(that){
	 $('ul', that).stop().slideUp(200);
}

function suaKyThi(maKyThi){
	document.forms.formCreateEdit.reset();
	document.forms.formCreateEdit.action="SuaKyThi.do?maKyThi="+maKyThi;
	$(".xoaMonThi").each(function(){
		$(this).click();
	});
	$(".modal-title").html("Sửa kỳ thi");
	$.ajax({
		type: "POST",
		data:{
			maKyThi : maKyThi,
		},
		url:"GetKyThi.do",
		success: function (result) {
			result=JSON.parse(result);
			var kyThi=result[0];
			var arrMonThi=result[1];
			test=result;
			$("#f_tenKyThi").val(kyThi["tenKyThi"]);
			$("#f_ngayThi").val(kyThi["ngayThi"]);
			$("#f_namTuyenSinh").val(kyThi["namTuyenSinh"]);
			$("#f_nganh").val(kyThi["nganh"]);
			$("#f_hinhThucDT").val(kyThi["hinhThucDT"]);
			$("#f_coSoLKDT").val(kyThi["coSoLKDT"]);
			//$("#soMonThi").val(kyThi["soMonThi"]);
			for(var i=0;i<arrMonThi.length;i++)
				$("#taoMonThi").click();
			var j=0;
			$(".monthi input[type='hidden']").each(function(){
				$(this).val(arrMonThi[j++].maMonThi);
			});
			j=0;
			$(".monthi input[type='text']").each(function(){
				$(this).val(arrMonThi[j++].tenMonThi);
			});
			j=0;
			$(".monthi input[type='number']").each(function(){
				$(this).val(arrMonThi[j++].heSo);
			});
	    }
	});
	$("#modal-kythi").modal();
}

function taoKyThi(){
	document.forms.formCreateEdit.reset();
	document.forms.formCreateEdit.action="ThemKyThi.do";
	$(".xoaMonThi").each(function(){
		$(this).click();
	});
	$("#taoMonThi").click();
	$(".modal-title").html("Thêm kỳ thi");
	$("#modal-kythi").modal();
}

function xoaKyThi(maKyThi){
	document.forms.formDelete.reset();
	document.forms.formDelete.action="XoaKyThi.do?maKyThi="+maKyThi;
	$("#xoaKyThi").modal();
}

function taoHTMLMonThi(that){
	var x=$(".monthi").length;
	var htmlMonThi='<div class="form-group row monthi"><input type="hidden" class="form-control" name="monThi['+x+'].maMonThi"><div class="col-sm-7"><input type="text" class="form-control" name="monThi['+x+'].tenMonThi"></div><div class="col-sm-3"><input type="number" class="form-control" name="monThi['+x+'].heSo" value="1" min="1"></div><button type="button" onclick="xoaMonThi(this)" class="btn btn-default xoaMonThi" title="Xóa môn thi"><i class="glyphicon glyphicon-remove"></i></button></div>'
	$(htmlMonThi).insertBefore($(that));
	var soMonThi = $("#soMonThi").val();
	soMonThi++;
	$("#soMonThi").val(soMonThi);
}

/*function luuMonThi(that){
	var tenMonThi=$(that).parent().find("input").val();
	console.log("Load ajax insert: "+tenMonThi);
	that.disabled = true;
	var soMonThi = $("#soMonThi").val();
	soMonThi++;
	$("#soMonThi").val(soMonThi);
}*/

function xoaMonThi(that){
	var tenMonThi=$(that).parent().find("input").val();
	console.log("Load ajax delete: "+tenMonThi);
	$(that).parent().remove();
	var soMonThi = $("#soMonThi").val();
	soMonThi--;
	$("#soMonThi").val(soMonThi);
}

function taoThiSinh(maKyThi){
	document.forms.formCreateEdit.reset();
	document.forms.formCreateEdit.action="ThemThiSinh.do?maKyThi="+maKyThi;
	$(".modal-title").html("Thêm thí sinh");
	$("#modal-thisinh").modal();
}

function suaThiSinh(maKyThi, maThiSinh){
	document.forms.formCreateEdit.reset();
	document.forms.formCreateEdit.action="SuaThiSinh.do?maKyThi="+maKyThi+"&maThiSinh="+maThiSinh;
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

function xoaThiSinh(maThiSinh){
	document.forms.formDelete.reset();
	document.forms.formDelete.action="XoaThiSinh.do?maThiSinh="+maThiSinh;
	$("#xoaThiSinh").modal();
}

function taoPhongThi(maKyThi){
	document.forms.formCreateEdit.reset();
	document.forms.formCreateEdit.action="ThemPhongThi.do?maKyThi="+maKyThi;
	$(".modal-title").html("Thêm phòng thi");
	$("#modal-phongthi").modal();
}

function suaPhongThi(maKyThi, maPhongThi){
	document.forms.formCreateEdit.reset();
	document.forms.formCreateEdit.action="SuaPhongThi.do?maKyThi="+maKyThi+"&maPhongThi="+maPhongThi;
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

function xoaPhongThi(maPhongThi){
	document.forms.formDelete.reset();
	document.forms.formDelete.action="XoaPhongThi.do?maPhongThi="+maPhongThi;
	$("#xoaPhongThi").modal();
}

var sum = 0;
$(".soLuongThiSinh").each(function(){
    sum += parseInt($(this).text());  // Or this.innerHTML, this.innerText
});
$("#tongSoLuong").html(sum);

function getMaKyThi(){
	var makt = $("#f_maKyThi").val();
	var url=window.location.href;
	var x = url.split("/");
	x=x[x.length-1];
	var i=x.indexOf(".do");
	x=x.substring(0,i+3);
	window.location.href=x+"?maKyThi="+makt;
}

function getDanhSachPhongThi(){
	var makt = $("#f_maKyThi").val();
	var mapt = $("#f_maPhongThi").val();
	window.location.href="DanhSachPhongThi.do?maKyThi="+makt+"&maPhongThi="+mapt;
}

function getXuLyBaiThi(){
	var makt = $("#f_maKyThi").val();
	var mapt = $("#f_maPhongThi").val();
	var mamt = $("#f_maMonThi").val();
	window.location.href="XuLyBaiThi.do?maKyThi="+makt+"&maPhongThi="+mapt+"&maMonThi="+mamt;
}

var ClipboardHelper = {
    copyElement: function ($element)
    {
       this.copyText($element.text())
    },
    copyText:function(text) // Linebreaks with \n
    {
        var $tempInput =  $("<input>");
        $("body").append($tempInput);
        $tempInput.val(text).select();
        document.execCommand("copy");
        $tempInput.remove();
    }
}

function soSangChu(str) {
	str = str.replace(/1/g, ' Một');
	str = str.replace(/2/g, ' Hai');
	str = str.replace(/3/g, ' Ba');
	str = str.replace(/4/g, ' Bốn');
	str = str.replace(/5/g, ' Năm');
	str = str.replace(/6/g, ' Sáu');
	str = str.replace(/7/g, ' Bảy');
	str = str.replace(/8/g, ' Tám');
	str = str.replace(/9/g, ' Chín');
	str = str.replace(/10/g, ' Mười');
	str = str.replace(/0/g, ' Không');
	str = str.replace(/\./g, ' chấm');
	str = str.trim();
	return str;
}

function convertCode(){
	var str=$input.val();
	str = soSangChu(str);
	if (str=="Một Không chấm Không") {
		str = "Mười";
	}
	if(str=="Không chấm Không"){
		str="Không";
	}
	$output.html(str);
	ClipboardHelper.copyText(str);
	$input.focus();
}

var soBaiThi = $("#soBaiThi").val();
for(var i = 0; i < soBaiThi; i++){
	var $input = $("#input"+i);
	var $output = $("#output"+i);
	convertCode();
}

function convertCode2(){
	var str=$input[i].val();
	str = soSangChu(str);
	if (str=="Một Không chấm Không") {
		str = "Mười";
	}
	if(str=="Không chấm Không"){
		str="Không";
	}
	$output[i].html(str);
	ClipboardHelper.copyText(str);
	$input[i].focus();
}
var soBT = $("#soBT").html();
var $input = [soBT];
var $output = [soBT];
for(var i = 0; i < soBT; i++){
	$input[i] = $("#in"+i);
	$output[i] = $("#out"+i);
	$input[i].on("input",function(){
		convertCode2();
	});
}

function getTKBangDiemTheoMon(){
	var makt = $("#f_maKyThi").val();
	var mamt = $("#f_maMonThi").val();
	window.location.href="ThongKeBangDiemTheoMon.do?maKyThi="+makt+"&maMonThi="+mamt;
}

function getNhapDiemThi(){
	var makt = $("#f_maKyThi").val();
	var mamt = $("#f_maMonThi").val();
	var tuiso = $("#f_tuiSo").val();
	window.location.href="NhapDiemThi.do?maKyThi="+makt+"&maMonThi="+mamt+"&tuiSo="+tuiso;
}

function getDonTuiPhach(){
	var makt = $("#f_maKyThi").val();
	var mamt = $("#f_maMonThi").val();
	window.location.href="DonTuiPhach.do?maKyThi="+makt+"&maMonThi="+mamt;
}

function lock(){
	$('#save')[0].disabled = true;
	$('#delete')[0].disabled = true;
}

function showNotice(text){
	$("#notice").html(text);
	$("#notice").attr("style","opacity:0.8;bottom:20px");
	setTimeout(function(){
		$("#notice").attr("style","opacity:0;bottom:-20px");
	},1500);
}

$('#finish').click(function(e) {
    // prevent click action
    e.preventDefault();
    $('#save')[0].disabled = true;
	$('#delete')[0].disabled = true;
    return false;
});

function getTKBienBanTongHop(){
	var makt = $("#f_maKyThi").val();
	var mamt = $("#f_maMonThi").val();
	var tuiso = $("#f_tuiSo").val();
	window.location.href="ThongKeBienBanTongHopChamThi.do?maKyThi="+makt+"&maMonThi="+mamt+"&tuiSo="+tuiso;
}

function getTKBienBanChamThi(){
	var makt = $("#f_maKyThi").val();
	var mamt = $("#f_maMonThi").val();
	window.location.href="ThongKeBienBanChamThi.do?maKyThi="+makt+"&maMonThi="+mamt;
}

function printDiv(divId) {
   var printContents = document.getElementById(divId).innerHTML;
   //var originalContents = document.body.innerHTML;
   //document.body.innerHTML = printContents;
   printSection.innerHTML=printContents;
   window.print();
   //document.body.innerHTML = originalContents;
}