//У���û���
function verify(){
    //alert("�����˰�ť����");
    var jqueryObj = $("#name");
    var name = jqueryObj.val();
    //alert(name);

    $.get("ajaxServlet?name="+name,null,callback);

    
    
}

function callback(data){
//    alert("�������ϵ����ݻ����ˣ���");
    var resultObj = $("#result") ;
    resultObj.html(data);
//    alert("successful!!");
}