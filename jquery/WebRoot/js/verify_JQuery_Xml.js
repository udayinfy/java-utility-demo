function verify(){

    var jqueryObj = $('#name');
    var name = jqueryObj.val();
//    alert('name=' + name);
    $.ajax({
        type: 'GET',
        url: 'ajaxXmlServlet?name=' + name,
        //date: {name:name},    //POST传参后台得不到数据
        dateType: 'xml',
        success: callback
     });

}

function callback(data){

    var jqueryObj = $(data);
    var message = jqueryObj.children();
    var text = message.text();

    $('#result').html(text);


}