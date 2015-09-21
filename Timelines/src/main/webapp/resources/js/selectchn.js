/**
 * 
 */
//var host="/timeline"
var host = "/";
function selectchnPopupDisplay() {
	jQuery("#selectChannelModal").modal('show');
	
}

function switchToSelectChannel(){
	window.location.href = host + "selectchannel";
	
}

function loadCookieToModal() {
	var vnexpressCookie = getCookie("vnexpress_chn");
	vnexpressCookie = vnexpressCookie.replace("%2C", ",");
	$('#categoryBound_vnexpress').children().each(function() {
		var checkBoxItem = $(this).children('.checkbox-chn');
		var checkBoxValue = checkBoxItem.val();
		if (vnexpressCookie.indexOf(checkBoxValue) >= 0) {
			checkBoxItem.attr("checked", "checked");
		}
	});
	
	$('#categoryBound_kenh14').children().each(function() {
		var checkBoxItem = $(this).children('.checkbox-chn');
		var checkBoxValue = checkBoxItem.val();
		if (vnexpressCookie.indexOf(checkBoxValue) >= 0) {
			checkBoxItem.attr("checked", "checked");
		}
	});
	
	$('#categoryBound_dantri').children().each(function() {
		var checkBoxItem = $(this).children('.checkbox-chn');
		var checkBoxValue = checkBoxItem.val();
		if (vnexpressCookie.indexOf(checkBoxValue) >= 0) {
			checkBoxItem.attr("checked", "checked");
		}
	});

}

function saveCookie() {
	var vnexpresschnArr = [];
	$('#categoryBound_vnexpress').children().each(
			function() {
				var checkBoxItem = $(this).children('.checkbox-chn');

				if (checkBoxItem.is(":checked")) {
					vnexpresschnArr[vnexpresschnArr.length] = $(this).children(
							'.checkbox-chn').attr('value');

				}
			});

	$('#categoryBound_kenh14').children().each(
			function() {
				var checkBoxItem = $(this).children('.checkbox-chn');

				if (checkBoxItem.is(":checked")) {
					vnexpresschnArr[vnexpresschnArr.length] = $(this).children(
							'.checkbox-chn').attr('value');

				}
			});
	
	$('#categoryBound_dantri').children().each(
			function() {
				var checkBoxItem = $(this).children('.checkbox-chn');

				if (checkBoxItem.is(":checked")) {
					vnexpresschnArr[vnexpresschnArr.length] = $(this).children(
							'.checkbox-chn').attr('value');

				}
			});
	var cookieValue = generateCookie(vnexpresschnArr);
	$.cookie('vnexpress_chn', cookieValue, {
		expires : 1234
	});
}
function generateCookie(array) {
	var cookieString = "";
	for (var i = 0; i < array.length; i++) {
		cookieString += (array[i] + ",");
	}
	return cookieString;
}
$(document).ready(function() {
	$('#selectChannelModal').on('show.bs.modal', function() {
		loadCookieToModal();
	});

	$('#selectChannelModal').on('hide.bs.modal', function() {
		saveCookie();
		location.reload();
	});
});
function getCookie(cname) {
	var name = cname + "=";
	var ca = document.cookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ')
			c = c.substring(1);
		if (c.indexOf(name) == 0)
			return c.substring(name.length, c.length);
	}
	return "";
}
function selectback(){
	saveCookie();
	window.location.href = host;
}


var recommendChannels = ["vne_TrangChu","vne_GiaiTri","vne_KhoaHoc","ken_TrangChu","ken_Star",
                 		 "dan_TrangChu","dan_GiaiTri"]
//<!-- ALL + UNCHECK ALL + RECOMMEND -->
function checkall() {
	$('.form-group').each(function() {
		var checkBoxItem = $(this).children('.checkbox-chn');
		if (!checkBoxItem.is(":checked")) {
			$(this).children('.btn-group').children('.active').click();
		}
	});

	$('span.checkall').css("visibility", "visible");
	$('span.uncheckall').css("visibility", "hidden");
	$('span.recommend').css("visibility", "hidden");
}

function uncheckall() {
	$('.form-group').each(function() {
		var checkBoxItem = $(this).children('.checkbox-chn');
		if (checkBoxItem.is(":checked")) {
			$(this).children('.btn-group').children('.active').click();
		}
	});

	$('span.checkall').css("visibility", "hidden");
	$('span.uncheckall').css("visibility", "visible");
	$('span.recommend').css("visibility", "hidden");
}

function recommend() {
	uncheckall();
	
	$('.form-group').each(function() {
		var checkBoxItem = $(this).children('.checkbox-chn');
		if ($.inArray(checkBoxItem.val(),recommendChannels)>=0) {
			if (!checkBoxItem.is(":checked")) {
				$(this).children('.btn-group').children('.active').click();
			}
		}
		
	});

	
	$('span.checkall').css("visibility", "hidden");
	$('span.uncheckall').css("visibility", "hidden");
	$('span.recommend').css("visibility", "visible");
}
//<!--ALL + UNCHECK ALL + RECOMMEND-->
