$("select").selecter();
$("input[type='checkbox']").iCheck();
$("input[type='radio']").iCheck();
var num=0;
var soCauHoiMax=0;
var timeinterval;
var submit=0;
(function($) {

	  var ajaxQueue = $({});

	  $.ajaxQueue = function(ajaxOpts) {

	    var oldComplete = ajaxOpts.complete;

	    ajaxQueue.queue(function(next) {

	      ajaxOpts.complete = function() {
	        if (oldComplete) oldComplete.apply(this, arguments);

	        next();
	      };

	      $.ajax(ajaxOpts);
	    });
	  };

	})(jQuery);

function chonCauHoi(soCau){
	soCauHoiMax=soCau;
	num=$(".icheckbox.checked").length;
	if(num>=soCau){
		$(".icheckbox").iCheck('disable');
		$(".icheckbox.checked").iCheck('enable');
		$(this).iCheck('enable');
	}
	$("#numQuest").html(num);
	$(".icheckbox").on("ifChanged",function(){
		num=$(".icheckbox.checked").length;
	});
	$(".icheckbox").on("ifChecked",function(){
		var idCauHoi=$(this).children().attr("id").split("_")[1];
		var idBaiThi=$("input[name='idBaiThi']").val();
		$.ajaxQueue({
			type: "POST",
			data:{
				idBaiThi : idBaiThi,
				idCauHoi : idCauHoi,
				action : "insert"
			},
			url:"XuLyCauHoi.do",
			success: function (result) {
				console.log("Insert Ok");
		    },
		});
		if(num>=soCau-1){
	    	$(".icheckbox").iCheck('disable');
			$(".icheckbox.checked").iCheck('enable');
			$(this).iCheck('enable');
	    }
	    $("#numQuest").html(num+1);
	});
	$(".icheckbox").on("ifUnchecked",function(){
		var idCauHoi=$(this).children().attr("id").split("_")[1];
		var idBaiThi=$("input[name='idBaiThi']").val();
		$.ajaxQueue({
			type: "POST",
			data:{
				idBaiThi : idBaiThi,
				idCauHoi : idCauHoi,
				action : "delete"
			},
			url:"XuLyCauHoi.do",
			success: function (result) {
				console.log("Delete Ok");
		    },
		});
		$(".icheckbox").iCheck('enable');
		$("#numQuest").html(num-1);
	});
}

function chonLaiCauHoi(){
	if(confirm("Bạn chắc chắn muốn bỏ chọn tất cả câu hỏi?"));
	$(".icheckbox").iCheck('uncheck');
}

function chonCauHoiRandom(){
	var numQuest=$(".icheckbox").length;
	if(numQuest<soCauHoiMax){
		if(confirm("Không đủ số câu hỏi. Tiếp tục chọn ngẫu nhiên có thể không đủ dữ liệu để làm bài thi. Bạn có muốn tiếp tục không?")) soCauHoiMax=numQuest;
		else return;
	}
	$(".icheckbox").iCheck('uncheck');
	while(num<soCauHoiMax-1){
		var x=parseInt(Math.random()*numQuest);
		$($(".icheckbox")[x]).iCheck("check");
	}
}

$(document).ready(function(){
	if($("input[name='search'].search-query").length>0){
		$("input[name='search'].search-query").change(function(){
			$(this).val($(this).val().trim());
		});
	}
	$("input[name='url']").val(window.location.href);
	// Đăng nhập
	$('.toggle-account').click(function(){
		$(this).toggleClass('glyphicon-log-in');
		$('.form-account form').animate({
			height: "toggle",
			'padding-top': 'toggle',
			'padding-bottom': 'toggle',
			opacity: "toggle"
		  }, 400);
	});
	$('#account').click(function(){
		$('.form-account').slideToggle();
	});
	$(document).click(function(event){
		if(!$(event.target).closest('.account').length)
			$('.form-account').slideUp();
	});
});

$(".cau-hoi .iradio").on("ifChecked",function(){
	var viTri=$(this).parents(".cau-hoi").attr("id").split("_")[1];
	var label=$(".list-quest a span")[viTri-1];
	if(!$(label).hasClass("label-primary")) $(label).addClass("label-primary");
	$("#ketThucLanThi .modal-body strong").html($(".label-primary").length+"/"+$(".label").length);
});

function chooseAnswer(){
	for (var i = 0; i < listAnswer.length; i++) {
		var x=$("#question_"+(i+1)+" .answer label span");
		for(var j=0;j<4;j++)
			if($(x[j]).html()==listAnswer[i]) {
				$(x[j]).parent().find("input").iCheck("check");
			}
	}
}


function getViTriHienTai(){
	return $(".cau-hoi.hientai").attr("id").split("_")[1];
}

function shortString(x,len){
	for (var i = 0; i < x.length; i++) {
		var y = $(x[i]).html();
		if(y.length>len) y=y.substring(0,len)+"...";
		$(x[i]).html(y);
	}
}

function getTimeRemaining(endtime) {
  var t = Date.parse(endtime) - Date.parse(new Date());
  var seconds = Math.floor((t / 1000) % 60);
  var minutes = Math.floor((t / 1000 / 60) % 60);
  var hours = Math.floor((t / (1000 * 60 * 60)) % 24);
  return {
    'total': t,
    'hours': hours,
    'minutes': minutes,
    'seconds': seconds
  };
}

function initializeClock(id, endtime) {
  var clock = document.getElementById(id);
  var hoursSpan = clock.querySelector('#hours');
  var minutesSpan = clock.querySelector('#minutes');
  var secondsSpan = clock.querySelector('#seconds');

  function updateClock() {
    var t = getTimeRemaining(endtime);
    luuDapAn();
    hoursSpan.innerHTML = ('0' + t.hours).slice(-2);
    minutesSpan.innerHTML = ('0' + t.minutes).slice(-2);
    secondsSpan.innerHTML = ('0' + t.seconds).slice(-2);  
    if (t.total <= 0) {
        clearInterval(timeinterval);
        document.forms.KetThucLanThi.submit();
    }
  }
  updateClock();
  timeinterval = setInterval(updateClock, 1000);
}

function updateNewTime(timeDown){
	clearInterval(timeinterval);
	initializeClock('time-down', new Date(Date.parse(new Date()) +  timeDown*1000));
}

function luuDapAn(){
	var idCauHoi=$(".cau-hoi.hientai input[name='idCauHoi']").val();
	var idLanThi=document.forms.KetThucLanThi.idLanThi.value;
	var value=$(".cau-hoi.hientai .checked input[name='answer_"+getViTriHienTai()+"']").parents(".answer").find("label>span").html();
	$.ajax({
		type: "POST",
		data:{
			idLanThi : idLanThi,
			idCauHoi : idCauHoi,
			traLoiChon : value
		},
		url:"LuuDapAn.do",
		success: function (result) {
			if(result<=0 || submit==1) document.forms.KetThucLanThi.submit();
			else updateNewTime(result);
	    }
	});
}

function hoanTatBaiThi(){
	submit=1;
	luuDapAn();
	document.forms.KetThucLanThi.submit();	
}

function nextQuest(){
	var next=Number(getViTriHienTai())+1;
	if(next == $(".cau-hoi").length){
		$("li.next").addClass("disabled");
	}
	if(next>$(".cau-hoi").length) return; 
	if($("li.prev").hasClass("disabled")){
		$("li.prev").removeClass("disabled");
	}
	luuDapAn();
	$(".cau-hoi.hientai").removeClass("hientai");
	$("#question_"+next).addClass("hientai");
	
}
function prevQuest(){
	var prev=getViTriHienTai()-1;
	if(prev == 1){
		$("li.prev").addClass("disabled");
	}
	if(prev < 1) return;
	if($("li.next").hasClass("disabled")){
		$("li.next").removeClass("disabled");
	}
	luuDapAn();
	$(".cau-hoi.hientai").removeClass("hientai");
	$("#question_"+prev).addClass("hientai");
}

$(window).bind("pageshow", function(event) {
    if (event.originalEvent.persisted) {
        window.location.reload() 
    }
});
function clearCheckbox(){
	$("#f_active").iCheck("check");
	$("#f_active").iCheck("uncheck");
}
function suaBaiThi(idBaiThi){
	clearCheckbox();
	$("button[name='resetForm']").click();
	document.forms.formCreateEdit.action="SuaBaiThi.do?idBaiThi="+idBaiThi;
	$(".modal-title").html("Sửa bài thi");
	$.ajax({
		type: "POST",
		data:{
			idBaiThi : idBaiThi,
		},
		url:"GetBaiThi.do",
		success: function (result) {
			result=JSON.parse(result);
			$("#f_tenBaiThi").val(result["tenBaiThi"]);
			$("#f_thoiGian").val(result["thoiGian"]);
			$("#f_soCauHoi").val(result["soCauHoi"]);
			$("#f_moTa").val(result["moTa"]);
			$("#f_idLoai").val(result["idLoai"]).trigger("change");
			$("#f_password").val(result["password"]);
			if(result['active']==true) $("#f_active").iCheck("check");
	    }
	});
}
function taoBaiThi(){
	clearCheckbox();
	$("button[name='resetForm']").click();
	document.forms.formCreateEdit.action="ThemBaiThi.do";
	$(".modal-title").html("Tạo bài thi");
	$("#f_active").iCheck("check");
}
function suaCauHoi(idCauHoi){
	clearRadiobox();
	$("button[name='resetForm']").click();
	document.forms.formCreateEdit.action="SuaCauHoi.do?idCauHoi="+idCauHoi;
	$(".modal-title").html("Sửa câu hỏi");
	$.ajax({
		type: "POST",
		data:{
			idCauHoi : idCauHoi,
		},
		url:"GetCauHoi.do",
		success: function (result) {
			result=JSON.parse(result);
			$("#f_noiDung").val(result["noiDung"]);
			if(result["dapAn"]==result["traLoiMot"]){
				$("input[type='radio']#answer_1").iCheck("check");
			}
			if(result["dapAn"]==result["traLoiHai"]){
				$("input[type='radio']#answer_2").iCheck("check");
			}
			if(result["dapAn"]==result["traLoiBa"]){
				$("input[type='radio']#answer_3").iCheck("check");
			}
			if(result["dapAn"]==result["traLoiBon"]){
				$("input[type='radio']#answer_4").iCheck("check");
			}
			$("#f_traLoiMot").val(result["traLoiMot"]);
			$("#f_traLoiHai").val(result["traLoiHai"]);
			$("#f_traLoiBa").val(result["traLoiBa"]);
			$("#f_traLoiBon").val(result["traLoiBon"]);
			$("#f_idLoai").val(result["idLoai"]).trigger("change");
	    }
	});
}
function clearRadiobox(){
	$("input[type='radio']").iCheck("check");
	$("input[type='radio']").iCheck("uncheck");
}
function taoCauHoi(){
	clearRadiobox();
	$("button[name='resetForm']").click();
	document.forms.formCreateEdit.action="ThemCauHoi.do";
	$(".modal-title").html("Thêm câu hỏi");
}

function showQuest(x){
	$(".cau-hoi.hientai").removeClass("hientai");
	$("#question_"+x).addClass("hientai");
	if(x == $(".cau-hoi").length){
		$("li.next").addClass("disabled");
	}
	else if(x == 1){
		$("li.prev").addClass("disabled");
	}
	else{
		if($("li.prev").hasClass("disabled")){
			$("li.prev").removeClass("disabled");
		}
		if($("li.next").hasClass("disabled")){
			$("li.next").removeClass("disabled");
		}
	}
}
function checkDapAn(){
	if($(".checked input[name='answer']").length==0){
		alert("Bạn chưa chọn đáp án cho câu hỏi của mình!");
		return false;
	}
	$("#f_dapAn").val($(".checked input[name='answer']").parent().parent().parent().find("input").val());
	if($("#f_dapAn").val()==""){
		alert("Bạn chưa chọn đáp án cho câu hỏi của mình!");
		return false;
	}
	if($.trim($('#f_noiDung').val())== ''){
		alert("Bạn vui lòng nhập đầy đủ nội dung!");
		return false;
	}
	if($.trim($('#f_traLoiMot').val())== ''){
		alert("Bạn vui lòng nhập đầy");
		return false;
	}
	if($.trim($('#f_traLoiHai').val())== ''){
		alert("Bạn Vui Long Nhap Day Du!");
		return false;
	}
	
	document.forms.formCreateEdit.submit();
	return true;
}
function loadPhanTrang(id){
	if(numPage<=1) return;
	id="#"+id;
	var next='<li><a href="javascript:void(0)" onclick="nextPage()">&raquo;</a></li>';
	if(currentPage<=1){
		currentPage=1;
		$(id+" .pagination").append('<li class="disabled"><a href="javascript:void(0)" onclick="prevPage()">&laquo;</a></li>');
	}
	else $(id+" .pagination").append('<li><a href="javascript:void(0)" onclick="prevPage()">&laquo;</a></li>');
	if(currentPage>=numPage){
		currentPage=numPage;
		next='<li class="disabled"><a href="javascript:void(0)" onclick="nextPage()">&raquo;</a></li>'
	}
	for(var i=1;i<=numPage;i++){
		if(i==currentPage) $(id+" .pagination").append('<li class="active" ><a href="javascript:void(0)" onclick="goPage('+i+')">'+i+'</a></li>');
		else $(id+" .pagination").append('<li ><a href="javascript:void(0)" onclick="goPage('+i+')">'+i+'</a></li>');
	}
	$(id+" .pagination").append(next);
}
function goPage(page){
	var url=$(location).attr('href');
	if(url.indexOf("page=")>0){
		var x="";
		if(url.indexOf("&page=")>0) x=url.substr(url.indexOf("&page="));
		else x=url.substr(url.indexOf("page="));
		url=url.replace(x,"");
	}
	if(url.indexOf(".do?")>0) url+="&page="+page;
	else	url+="?page="+page;
	window.location=url;
}
function nextPage(){
	currentPage++;
	if(currentPage>=numPage) currentPage=numPage;
	goPage(currentPage);
}
function prevPage(){
	currentPage--;
	if(currentPage<=1) currentPage=1;
	goPage(currentPage);
}