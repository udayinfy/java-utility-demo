var xmlHttpRequest;

function verify(){
    
    var name = document.getElementById('name').value;

    if(window.XMLHttpRequest){
        xmlHttpRequest = new XMLHttpRequest();
        if(xmlHttpRequest.overrideMimeType){
            xmlHttpRequest.overrideMimeType('text/html');
        }
       
    }else if(window.ActiveXObject){
        var activeName = ['MSXML2.XMLHTTP','Microsoft.XMLHTTP'];
        for(var i=0; i<activeName.length; i++){
            try{
                xmlHttpRequest = new ActiveXObject(activeName[i]);
                break;
            }catch(e){
                
            }
        }

    }

    if(!xmlHttpRequest){
        alert('create XMLHttpRequest failed');
        return;
    }else{
//         alert(xmlHttpRequest);
    }

    xmlHttpRequest.onreadystatechange = callback;

//    xmlHttpRequest.open('GET','ajaxServlet?name='+name,true);

    xmlHttpRequest.open('POST','ajaxServlet',true);
    xmlHttpRequest.setRequestHeader('Content-Type','application/x-www-form-urlencoded');

//    xmlHttpRequest.send(null)
    xmlHttpRequest.send('name=' + name);
    

}

function callback(){

//    alert(xmlHttpRequest.readyState);

    if(xmlHttpRequest.readyState==4){

        if(xmlHttpRequest.status==200){
            var responseText = xmlHttpRequest.responseText;
            document.getElementById('result').innerHTML = responseText;
        }

    }
    
}