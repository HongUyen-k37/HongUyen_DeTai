var test;
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
	$(".modal-title").html("Thêm kỳ thi"); //còn 1 cái ni cần góp ý cmn thôi
	
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
