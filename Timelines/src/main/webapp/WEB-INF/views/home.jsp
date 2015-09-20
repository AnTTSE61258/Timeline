<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.cworld.timeline.database.model.Item"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="UTF-8">
<meta name="keywords" content="" />
<meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<script type="text/javascript"
	src='<c:url value="/resources/js/readMoreFunctions.js"/>'></script>
<!-- Title -->
<title>Timeline</title>

<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon"
	href='<c:url value="/resources/img/favicon.png"/>'>
<!-- CSS -->
<link rel='stylesheet'
	href='<c:url value="/resources/css/custom.css" />' type='text/css'
	media='all' />
<link rel='stylesheet'
	href='<c:url value="/resources/css/bootstrap.css" />' type='text/css'
	media='all' />
<link rel='stylesheet' href='<c:url value="/resources/css/style.css"/>'
	type='text/css' media='all' />
	
<link rel='stylesheet' href='<c:url value="/resources/css/animate.css"/>'
	type='text/css' media='all' />


<!-- JS -->
<script type='text/javascript'
	src='<c:url value="/resources/js/jquery-2.1.4.min.js" ></c:url>'></script>

<script type='text/javascript'
	src='<c:url value="/resources/js/jquery.lazyload.min.js" ></c:url>'></script>	
	
<script type="text/javascript"
	src='<c:url value="/resources/js/js-date-format.js"/>'></script>

<script type='text/javascript'
	src='<c:url value="/resources/js/bootstrap.js?ver=4.1.7"/>'></script>
<script type='text/javascript'
	src='<c:url value="/resources/js/responsiveslides.js?ver=4.1.7"/>'></script>
<script type='text/javascript'
	src='<c:url value="/resources/js/modernizr.js?ver=4.1.7"/>'></script>

<script type='text/javascript'
	src='<c:url value="/resources/js/custom.js?ver=4.1.7"/>'></script>

<script type="text/javascript"
	src='<c:url value="/resources/js/viewdetail.js"/>'></script>

<script type="text/javascript"
	src='<c:url value="/resources/js/item-add.js"/>'></script>

<script type="text/javascript"
	src='<c:url value="/resources/js/selectchn.js"/>'></script>

<script type="text/javascript" 
	src='<c:url value="/resources/js/jquery.cookie.js"/>'>
</script>

<script type="text/javascript"
	src='<c:url value="/resources/js/sonic.js"/>'></script>	

<style type="text/css">
#btn-newnews {
	position: fixed;
	padding: 5px 10px;	
	border-radius: 5px;
	display: table;
	z-index: 100;
	color: #000;
	background: #ffff99;
	margin-top: 10px;
	display: table;
	box-shadow: 5px 5px 3px #888;
	cursor: pointer;
	visibility: collapse;
	text-align: center;
}
</style>	

<%-- <script type="text/javascript"
	src='<c:url value="/resources/js/bootstrap-notify.min.js"/>'></script> --%>

</head>
<body class="home blog" onresize="fixwidth();">


	<!-- PARAMETERS -->
	<c:set var="textLoadMore" value="Cũ hơn"></c:set>
	<c:set var="dtItemLink" value="${detailItem.link}"></c:set>
	<script>
		var previousPoint;
		var nextPoint;
	</script>

	<script>
		jQuery(document).ready(function() {
			previousPoint = "${items[fn:length(items)-1].seourl }";
			nextPoint = "${items[0].seourl}";
			$('#mainModal').on('shown.bs.modal', function() {
				document.body.style.overflow = 'hidden';
				$('#modalContent').scrollTop(0);
			}).on('hidden.bs.modal', function() {
				document.body.style.overflow = 'scroll';
			})
			$('#selectChannelModal').on('shown.bs.modal', function() {
				document.body.style.overflow = 'hidden';
				$('#modalContent').scrollTop(0);
			}).on('hidden.bs.modal', function() {
				document.body.style.overflow = 'scroll';
			})
		});
	</script>	
	
	<div class="">
		<img id="background" class="main-listing-bg"
			src='<c:url value="/resources/img/background.jpg"/>' alt="">
	</div>
	<section class="main-listing">		

		<div class="container">		
			<div class="row">
				<div id="btn-newnews" onclick="gotop();">
					Tin mới <span style="font-size:20px;">&#9757;</span>
				</div>
				<div class="col-md-12">									
					<div id="loadNewButton" class="cd-timeline-block load-more-block"
						style="margin-bottom: 100px">
						<!-- cd-timeline-img -->
					</div>

					<section id="cd-timeline" class="cd-container">
						<!-- cd-timeline-block -->
						<c:forEach var="item" items="${items}" varStatus="counter">
							<c:if test="${counter.count%2==0 }">
								<div id="post-1"
									class="post-40 post type-post status-publish format-status has-post-thumbnail hentry category-status tag-status-2 tag-twitter cd-timeline-block even"
									style="min-height: 250px">
							</c:if>
							<c:if test="${counter.count%2!=0 }">
								<div id="post-1"
									class="post-40 post type-post status-publish format-status has-post-thumbnail hentry category-status tag-status-2 tag-twitter cd-timeline-block"
									style="min-height: 250px">
							</c:if>

							<div class="cd-timeline-img">
									<%
									
									Item item = (Item) pageContext.getAttribute("item");
									Date date = item.getAddDate();
									
									Calendar calendar = Calendar.getInstance();
									calendar.setTime(date);
									int hours = calendar.get(Calendar.HOUR_OF_DAY);
									int minutes = calendar.get(Calendar.MINUTE);
									int seconds = calendar.get(Calendar.SECOND);
									
									out.println("<h2 style=\"padding-top: 8px\">"+hours+":"+minutes+"</h2>");
									%>
							</div>
							<!-- cd-timeline-img -->
							<div class="cd-timeline-content ">
								<div class="cd-content clearfix">
									<div class="content-padding">
										<a data-toggle="modal" data-target=".bs-example-modal-lg"
											href="javascript:;" class="post-title"
											onclick="readMore('${item.link}','${item.seourl}')"><h2>${item.title }</h2></a>


										<div class="post-content">
											<p>${item.desWithoutImage }</p>
										</div>
										<button class="btn btn-primary btn-default cd-read-more"
											data-toggle="modal" data-target=".bs-example-modal-lg"
											onclick="readMore('${item.link}','${item.seourl }')">Read more</button>
										<div class="clearfix"></div>
										<div class="cd-author">
											<a data-toggle="modal" data-target=".bs-example-modal-lg"
												href="javascript:;"	onclick="readMore('${item.link}','${item.seourl }')">
												<img class="lazy" data-original=${item.smallImage} alt=""
													style="width: 150px" />
											</a>													
										</div>
									</div>
								</div>
							</div>
							<!-- cd-timeline-content -->
				</div>
				<!-- cd-timeline-block -->
				</c:forEach>


				<div id="loadMoreButton" class="cd-timeline-block load-more-block">
					<div class="cd-timeline-year">
						<h2>
							<a href="javascript:;"><c:out
									value="${textLoadMore}"></c:out></a>

						</h2>
					</div>
					<!-- cd-timeline-img -->
				</div>
				<!-- cd-timeline-block -->
	</section>
	</div>
	</div>
	</div>


	</section>




	<!-- Main modal -->
	<div id="mainModal" class="modal bs-example-modal-lg"
		tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg" style="width: 100%;margin: 0%">
			<div id="iconCloseBound" align="right">
			
				<button id="icon-close" type="button" class="btn btn-default btn-lg" onclick="hideModal()">
					<span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>Đóng
				</button>
			
				<%-- <img id="icon-close" alt="Close"
					src='<c:url value="/resources/img/close-icon.png"/>'
					onclick="hideModal()"> --%>
			</div>
			<div id="modalContent" class="modal-content"
				style="min-height: 100vh; overflow: auto; max-height: 100vh; padding: 3%;">

			</div>

		</div>
	</div>
	</div>

	<!-- THIS ARER FOR SELECT CHANNEL -->
	<img id="selectchn-icon" onclick="switchToSelectChannel()"
		alt="SELECT CHANNEL"
		src='<c:url value="/resources/img/selectchn-icon.png"/>'>



	</div>
	<div id="underConstructor">
		<div>
		This site is under construction.
		</div>
		
	</div>

	<script>


	
		function getNext() {
			jQuery.ajax({
				type : "GET",
				url : "getNext",
				data : {
					nextPoint : nextPoint
				},
				success : function(data) {
					if (data.length === 0) {
						return;
					}
					console.log("Get next. Result = " + data.length);
					addItemsToHead(data);
				},
				error : function(data) {
					console.log("getNextFail: " +data)
				}
			});
		}
		//Fix issue loader not defined
		var loader;
		//Fix issue loader not defined
		function callPreviousAjax(){
			jQuery.ajax({
				type : "GET",
				url : "getPrevious",
				data : {
					previousPoint : previousPoint
				},
				success : function(data) {
					if (data.length === 0) {
						return;
					}
					console.log("Get previous. Result = " + data.length);
					addItemsToTail(data);
				},
				error : function(data) {
					console.log("Get previous Error: " + data);
				}
			});
			$(".cd-timeline-year").show();
			loader.stop();
		}

		function getPrevious() {
		//create new Sonic each getPrevious;
		loader = new Sonic({
				width: 100,
				height: 100,
				stepsPerFrame: 1,
				trailLength: 1,
				pointDistance: .02,
				fps: 100,
				fillColor: '#CB410B',
				step: function(point, index) {
					
					this._.beginPath();
					this._.moveTo(point.x, point.y);
					this._.arc(point.x, point.y, index * 7, 0, Math.PI*2, false);
					this._.closePath();
					this._.fill();
				},
				path: [
					['arc', 50, 50, 30, 0, 360]
				]
			});

		//create new Sonic each getPrevious;
			
			$(".cd-timeline-year").hide();
			$("#loadMoreButton").append(loader.canvas);
			loader.play();
			setTimeout(callPreviousAjax,1000);
		}

		function addItemsToHead(newItems) {
			for (var i = 0; i < newItems.length; i++) {
				addOneItemToHead(newItems[i], i);
			}
			nextPoint = newItems[0].seourl;
		}

		function hideModal() {
			jQuery("#mainModal").modal('hide');
		}

		function hideSelectChnModal() {
			jQuery("#selectChannelModal").modal('hide');
		}

		function showModal() {
			jQuery("#mainModal").modal('show');
		}
		
		function checknews() {
			jQuery.ajax({
				type : "GET",
				url : "hasNews",
				data : {
					nextPoint : nextPoint
				},
				success : function(data) {
					if (!data) {
						jQuery("#btn-newnews").css("visibility", "collapse");
						return myNews = setTimeout(function(){checknews();}, 1000*60);
					}					
					
					jQuery("#btn-newnews").css("visibility", "visible");
				},
				error : function(data) {
					jQuery("#btn-newnews").css("visibility", "collapse");
				}
			});				
		}		
		
		function gotop() {
			jQuery('html, body').animate({ scrollTop: 0 }, 'fast');
			getNext();
			jQuery("#btn-newnews").css("visibility", "collapse");
			
			//window.clearTimeout(myNews);
			//check has new news or not?
			myNews = setTimeout(function(){checknews();}, 1000*60);
		}
		//check has new news or not?
		var myNews = setTimeout(function(){checknews();}, 1000*60);
		
		function left_btnnewnews(){
			var row_width = $('.row').width();
			var btn_width = $('#btn-newnews').width();
			var int_left = (row_width - btn_width - 100) / 2;
			var str_left = int_left.toString() + "px";
			$('#btn-newnews').css("margin-left", str_left);
		}
		
		function fixwidth() {
			var row_width = $('.row').width();
			var btn_width = $('#btn-newnews').width();
			var int_left = (row_width - btn_width) / 2;
			var str_left = int_left.toString() + "px";
			$('#btn-newnews').css("margin-left", str_left);
		}

		$(document).ready(function() {
			console.log("ViewDetails");
			var url = "${dtItemLink}";
			handleDetailItem(url);
			
			left_btnnewnews();
			
			window.onscroll = function(ev)
			{
				var B = document.body; //IE 'quirks'
				var D = document.documentElement; //IE with doctype
				var h = $(window).height();
				D = (D.clientHeight) ? D : B;
				/*
				if (D.scrollTop == 0) {
					getNext();
				}
				*/

				if (D.scrollHeight - D.scrollTop == h) {
					getPrevious();
				}
				if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
			        // at bottom
					setTimeout(getPrevious,500);
			    }
			};
		});

		function displayNotification() {
		
			 $.notify({
				icon: '/timeline/resources/img/favicon.png',
				title: 'Có 1 tin mới',
				message: 'Ảnh chính thức Sony Xperia Z5',
				url: "/timeline/item/anh-chinh-thuc-sony-xperia-z5"
			},{
				type: 'minimalist',
				delay: 5000,
				icon_type: 'image',
				template: '<div data-notify="container" class="col-xs-11 col-sm-3 alert alert-{0}" role="alert">' +
					'<img data-notify="icon" class="img-circle pull-left" style ="max-width:40px; max-height:40px">' +
					'<span data-notify="title">{1}</span>' +
					'<span data-notify="message">{2}</span>' +
					'<a href="{3}" target="_self" data-notify="url"></a>' +
				'</div>',
			}); 
			/* 
			var notify = $.notify({
				title: 'Có 1 tin mới</br>',
				message : 'Ảnh chính thức Sony Xperia Z5'
			}, {
				type : 'success',
				allow_dismiss : false,
			}); */
			/* $.notify({
				title: "Có 1 tin mới",
				message: "Check out my twitter account by clicking on this notification!",
				url: "https://twitter.com/Mouse0270",
				icon: "/timeline/resources/img/logo/logo_vnexpress.jpg",
			},{
				icon_type: 'image',
				animate: {
					enter: 'animated fadeInRight',
					exit: 'animated fadeOutRight'
				}
			}); */
		}

		$(function() {
		    $("img.lazy").lazyload({
			    skip_invisible : true
			});
		});
	
		
	</script>