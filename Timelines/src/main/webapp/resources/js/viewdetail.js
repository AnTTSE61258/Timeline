/**
 * This file handle view details function.
 */



function handleDetailItem(url,seourl) {
	if (url === '' && seourl === '') {
		return;
	}

	else {
		var data = readMore(url,seourl);
		
		showModal();
	}

}
