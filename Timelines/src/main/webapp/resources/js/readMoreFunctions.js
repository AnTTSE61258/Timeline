/**
 * 
 */

function readMore(url) {
	document.getElementById("modalContent").innerHTML = '<a href="' + url
			+ '">' + url + '</a>';
	var data = getResponseFromUrl(url);
	return data;
}

function getResponseFromUrl(url) {
	jQuery.ajax({
		type : "GET",
		url : "/timeline/getTargetResponse",
		data : {
			url : url
		},
		success : function(data) {
			if (data === null || data === '') {
				return;
			}
			document.getElementById("modalContent").innerHTML = data;
			$("#modalContent h1").after('<a class="likeBtn coreSpriteHeartOpen" role="button" href="#inline" onclick="likePress(this)"></a>');
			return data;
		},
		error : function(data) {
			return data;
		}
	});

}