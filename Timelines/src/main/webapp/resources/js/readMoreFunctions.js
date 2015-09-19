/**
 * 
 */

function readMore(url) {		
	document.getElementById("modalContent").innerHTML = '<a href="' + url
			+ '">' + url + '</a>';
	var data = getResponseFromUrl(url);
	
	/*
	//Check has over-flowed
	if (jQuery('.modal-dialog.modal-lg')[0].scrollHeight >  jQuery('.modal-dialog.modal-lg')[0].innerHeight()) {	    
		// set right of iconCloseBound
		var scrollbarWidth = getScrollbarWidth();
		jQuery('#iconCloseBound').css("right", getScrollbarWidth() + "px");
	}*/
	return data;	
}

function getResponseFromUrl(url) {
	jQuery.ajax({
		type : "GET",
		url : "getTargetResponse",
		data : {
			url : url
		},
		success : function(data) {
			if (data === null || data === '') {
				return;
			}
			data += "<div id=\"secondaryCloseDiv\" onclick=\"hideModal()\"><a id=\"closeA\" href=\"javascript:;\">Đóng</a></div>";
			document.getElementById("modalContent").innerHTML = data;
			return data;
		},
		error : function(data) {
			return data;
		}
	});

}