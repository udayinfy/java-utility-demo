//校验用户名
function verify(){
    //alert("你点击了按钮！！");
    var jqueryObj = $("#name");
    var name = jqueryObj.val();
    //alert(name);

    $.get("encodeServlet?name="+encodeURI(encodeURI(name)),null,callback);



}

function callback(data){
//    alert("服务器上的数据回来了！！");
    var resultObj = $("#result") ;
    resultObj.html(data);
//    alert("successful!!");
}