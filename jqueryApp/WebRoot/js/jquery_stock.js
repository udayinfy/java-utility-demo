
var count = 0;

$(document).ready(function(){
	
	var stockNode = $('#stock');
	stockNode.css('border','1px solid gray');
	stockNode.css('width','200px');
	stockNode.css('height','100px');
	stockNode.hide();
	
	var aNodes = $('a');
	aNodes.mouseover(function(){
		stockNode.show();
	});
	
	aNodes.mouseout(function(){
		stockNode.hide();
	});
	
	
	getStackInfo();
	setInterval(getStackInfo,1000);
	
	
});

function getStackInfo() {

	count = count + 1; //防止IE缓存，每次提交一个有地增值的count
	$.get('getStockInfo?count='+count, null, function(data){
		
		var obj = eval(data); 
		var szzs = obj['300001'];  
		var pufy = obj['000001'];  
		
		var spanSz = $('#300001').children('span');
		spanSz.html(szzs.now);
		
		if (szzs.now > szzs.yes) {
			spanSz.css('color','red');
		}else{
			spanSz.css('color','green');
		}
		
		var spanPf = $('#000001').children('span');
		spanPf.html(pufy.now);
		
		if (pufy.now > pufy.yes) {
			spanPf.css('color','red');
		}else{
			spanPf.css('color','green');
		}
		
	});
	
}


$(document).ready(function(){
	
	var divNode = $('#secondDocumentReady');
	divNode.html('This is a secondDocumentReady method!!');	
	
});
