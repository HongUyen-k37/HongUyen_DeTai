

function linkTo(ma,value){
   var url=window.location.href;
   var x = url.split("/");
   x=x[x.length-1];
   var i=x.indexOf(".do");
   x=x.substring(0,i+3);
   window.location.href=x+"?"+ma+"="+value;
}
