/**
 * 
 */
function selectchnPopupDisplay() {
	jQuery("#selectChannelModal").modal('show');

}

function saveCookie() {
	var vnexpresschnArr = [];
	$('#selectChannelModalContent').children().each(
			function() {
				var checkBoxItem = $(this).children('.checkbox-chn');
				if (checkBoxItem.is(":checked")) {
					// alert($(this).children('.checkbox-chn').attr('value'));
					vnexpresschnArr[vnexpresschnArr.length] = $(this)
							.children('.checkbox-chn').attr('value');

				} else {
					//alert("non");
				}
			});
	$.cookie('vnexpress_chn', escape(vnexpresschnArr.join(',')), {expires:1234});
	// for (var i = 0; i < selectchnItems.length; i++) {
	// test = selectchnItems.find(".checkbox-chn");
	// if (test.is(':checked')) {
	// alert("checked")
	// }else{
	// alert("non");
	// }
	// }

}