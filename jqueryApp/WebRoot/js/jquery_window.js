
function showWindow() {
	var winNode = $('#window');
//	winNode.css('display','block');
//	winNode.show('slow');
	winNode.fadeIn('slow');
}

function closeWindow() {
	var winNode = $('#window');
//	winNode.hide('slow');
	winNode.fadeOut('slow');
}

$(function(){
	$('#close').click(function () { 
		var winNode = $('#window');
//		$(this).fadeOut('slow'); 
		winNode.fadeOut('slow');
	    return false; 
	}); 
});