function suaKyThi(makt){
	clearCheckbox();
	$("button[name='resetForm']").click();
	document.forms.formCreateEdit.action="SuaKyThi.do?makt="+maKyThi;
	$(".modal-title").html("Sửa kỳ thi");
	$.ajax({
		type: "POST",
		data:{
			maKyThi : makt,
		},
		url:"GetKyThi.do",
		success: function (result) {
			result=JSON.parse(result);
			$("#f_tenKyThi").val(result["tenKyThi"]);
			$("#f_ngayThi").val(result["ngayThi"]);
			$("#f_namTuyenSinh").val(result["namTuyenSinh"]);
			$("#f_nganh").val(result["nganh"]);
			$("#f_hinhThucDT").val(result["hinhThucDT"]);
			$("#f_coSoLKDT").val(result["coSoLKDT"]);
			
	    }
	});
}
function taoKyThi(){
	clearCheckbox();
	$("button[name='resetForm']").click();
	document.forms.formCreateEdit.action="ThemKyThi.do";
	$(".modal-title").html("Thêm kỳ thi");
}

function linkTo(ma,value){
   var url=window.location.href;
   var x = url.split("/");
   x=x[x.length-1];
   var i=x.indexOf(".do");
   x=x.substring(0,i+3);
   window.location.href=x+"?"+ma+"="+value;
}
