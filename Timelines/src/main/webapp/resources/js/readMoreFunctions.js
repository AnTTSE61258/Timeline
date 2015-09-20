/**
 * 
 */

function readMore(url,seourl) {
	document.getElementById("modalContent").innerHTML = '<a href="' + url
			+ '">' + url + '</a>';
	var data = getResponseFromUrl(url,seourl);
	return data;
}

function getResponseFromUrl(url,seourl) {
	jQuery.ajax({
		type : "GET",
		url : "getTargetResponse",
		data : {
			url : url,
			seourl: seourl
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