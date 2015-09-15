/**
 * 
 */

	function addItemsToTail(newItems) {
			removeLoadMoreButton();
			for (var i = 0; i < newItems.length; i++) {
				addOneItemToTail(newItems[i], i);
			}
			previousPoint = newItems[newItems.length - 1].seourl;
			addLoadMoreButton();

		}

		function addOneItemToHead(item, pos) {
			var evenOrOdd;
			if (pos % 2 == 0) {
				evenOrOdd = '';
			} else {
				evenOrOdd = 'even';
			}
			var date = new Date(item.addDate);
			jQuery("#cd-timeline")
					.prepend(
							'<div id="post-1" class="post-40 post type-post status-publish format-status has-post-thumbnail hentry category-status tag-status-2 tag-twitter cd-timeline-block '+evenOrOdd+'" style="min-height: 250px">'
									+ '<div class="cd-timeline-img bounce-in">'
									+ '<h2 style="padding-top: 8px">'
									+ date.getHours()
									+ ':'
									+ date.getMinutes()
									+ '</h2>'
									+ '</div>'
									+ '<!-- cd-timeline-img -->'
									+ '<div style="opacity: 1; top: 0px;" class="cd-timeline-content  is-hidden">'
									+ '<div class="cd-content clearfix">'
									+ '<div class="content-padding">'
									+'<a data-toggle="modal" data-target=".bs-example-modal-lg"'
										+'href="javascript:;" class="post-title"'
										+'onclick="readMore(\''
										+item.link
										+'\')"><h2>'+item.title+'</h2></a>'


									+ '<div class="post-content">'
									+ '<p>'
									+ item.desWithoutImage
									+ '</p>'
									+ '</div>'
									+ '<button class="btn btn-primary btn-default cd-read-more" data-toggle="modal" data-target=".bs-example-modal-lg" onclick="readMore('
									+ '\''
									+ item.link
									+ '\''
									+ ')">Read'
									+ 'more</button>'
									+ '<div class="clearfix"></div>'
									+ '<div class="cd-author">'
									+ '<a data-toggle="modal" data-target=".bs-example-modal-lg"'
									+ 'href="javascript:;"'
									+ 'onclick="readMore('
									+ '\''
									+ item.link
									+ '\''
									+ ')">'
									+ '<img src='+item.smallImage+' class="media-object img-responsive" alt="" style="width: 150px"/>'
									+ '</a>'
									+ '</div>'
									+ '</div>'
									+ '</div>'
									+ '</div>'
									+ '<!-- cd-timeline-content -->' + '</div>')

		}

		function addOneItemToTail(item, pos) {
			var evenOrOdd;
			if (pos % 2 == 0) {
				evenOrOdd = '';
			} else {
				evenOrOdd = 'even';
			}
			var date = new Date(item.addDate);
			jQuery("#cd-timeline")
					.append(
							'<div id="post-1" class="post-40 post type-post status-publish format-status has-post-thumbnail hentry category-status tag-status-2 tag-twitter cd-timeline-block '+evenOrOdd+'" style="min-height: 250px">'
									+ '<div class="cd-timeline-img bounce-in">'
									+ '<h2 style="padding-top: 8px">'
									+ date.getHours()
									+ ':'
									+ date.getMinutes()
									+ '</h2>'
									+ '</div>'
									+ '<!-- cd-timeline-img -->'
									+ '<div style="opacity: 1; top: 0px;" class="cd-timeline-content  is-hidden">'
									+ '<div class="cd-content clearfix">'
									+ '<div class="content-padding">'
									+'<a data-toggle="modal" data-target=".bs-example-modal-lg"'
									+'href="javascript:;" class="post-title"'
									+'onclick="readMore('
									+'\''
									+item.link
									+'\''
									+')"><h2>'+item.title+'</h2></a>'


									+ '<div class="post-content">'
									+ '<p>'
									+ item.desWithoutImage
									+ '</p>'
									+ '</div>'
									+ '<button class="btn btn-primary btn-default cd-read-more" data-toggle="modal" data-target=".bs-example-modal-lg" onclick="readMore('
									+ '\''
									+ item.link
									+ '\''
									+ ')">Read'
									+ 'more</button>'
									+ '<div class="clearfix"></div>'
									+ '<div class="cd-author">'
									+ '<a data-toggle="modal" data-target=".bs-example-modal-lg"'
									+ 'href="javascript:;"'
									+ 'onclick="readMore('
									+ '\''
									+ item.link
									+ '\''
									+ ')">'
									+ '<img src='+item.smallImage+' class="media-object img-responsive" alt="" style="width: 150px"/>'
									+ '</a>'
									+ '</div>'
									+ '</div>'
									+ '</div>'
									+ '</div>'
									+ '<!-- cd-timeline-content -->' + '</div>')

		}

		function removeLoadMoreButton() {
			jQuery("#loadMoreButton").remove();
		}

		function addLoadMoreButton() {
			jQuery("#cd-timeline").append(
					'<div id="loadMoreButton" class="cd-timeline-block load-more-block">'
							+ '<div class="cd-timeline-year">' + '<h2>'
							+ '<a href="javascript:;" onclick="getPrevious()">'
							+ 'Cũ hơn' + '</a>' + '</h2>' + '</div>'
							+ '<!-- cd-timeline-img -->' + '</div>');
		}
		