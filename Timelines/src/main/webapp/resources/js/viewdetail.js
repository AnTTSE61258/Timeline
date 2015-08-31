/**
 * This file handle view details function.
 */



function handleDetailItem(url) {
	if (url == '') {
		return;
	}

	else {
		var data = readMore(url);
		
		showModal();
	}

}
