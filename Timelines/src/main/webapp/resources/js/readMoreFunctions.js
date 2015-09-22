/**
 * 
 */

function readMore(url,seourl) {
	document.getElementById("modalContent").innerHTML = '<a href="' + url
			+ '">' + url + '</a>';
	var data = getResponseFromUrl(url,seourl);
	var loader = new Sonic({
		 width: 100,
		  height: 50,

		  stepsPerFrame: 1,
		  trailLength: 1,
		  pointDistance: .1,
		  fps: 15,
		  padding: 10,
		  //step: 'fader',

		  fillColor: '#FF2E82',

		  setup: function() {
		   this._.lineWidth = 20;
		  },

		  path: [
		   ['line', 0, 20, 100, 20],
		   ['line', 100, 20, 0, 20]
		  ]
	});
	$("#modalContent").append(loader.canvas);
	loader.play();
	$(".sonic").attr('class', 'sonicModal');
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
			var videoHeight = $(window).height() * 0.85;
			$(".embed-video").css("height",videoHeight);
			return data;
		},
		error : function(data) {
			return data;
		}
	});

}