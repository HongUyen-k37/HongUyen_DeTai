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
			$("#soMonThi").val(result["soMonThi"]);
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

function xoaKyThi(maKyThi){
	document.forms.formDelete.reset();
	document.forms.formDelete.action="XoaKyThi.do?maKyThi="+maKyThi;
	$("#xoaKyThi").modal();
}

function taoHTMLMonThi(that){
	var htmlMonThi='<div class="form-group row"><div class="col-sm-7"><input type="text" class="form-control" name="tenMonThi" placeholder="Tên môn thi"></div><div class="col-sm-3"><input type="number" class="form-control" name="heSo" placeholder="Hệ số"></div><button type="button" onclick="xoaMonThi(this)" class="btn btn-default" title="Xóa câu hỏi"><i class="glyphicon glyphicon-remove"></i></button></div>'
	$(htmlMonThi).insertBefore($(that));
}

function luuMonThi(that){
	var tenMonThi=$(that).parent().find("input").val();
	console.log("Load ajax insert: "+tenMonThi);
	that.disabled = true;
	var soMonThi = $("#soMonThi").html();
	soMonThi++;
	$("#soMonThi").html(soMonThi);
}

function xoaMonThi(that){
	var tenMonThi=$(that).parent().find("input").val();
	console.log("Load ajax delete: "+tenMonThi);
	$(that).parent().remove();
	var soMonThi = $("#soMonThi").html();
	soMonThi--;
	$("#soMonThi").html(soMonThi);
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
};

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
	if (str=="Một Không") {
		str = "Mười";
	}
	$output.html(str);
	ClipboardHelper.copyText(str);
	$input.focus();
}

var $input = $("#input");
var $output = $("#output");
$input.on("input",function(){
	convertCode();
});

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

function lock(){
	$('#save')[0].disabled = true;
	$('#delete')[0].disabled = true;
}