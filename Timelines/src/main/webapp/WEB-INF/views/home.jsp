<%@page import="com.cworld.timeline.service.TimerStatus"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.cworld.timeline.database.model.Item"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="UTF-8">
<meta name="keywords" content="doc bao,tin tuc,dong thoi gian,tin moi,bao moi,tin viet,giai tri" />
<meta name="description" content="Tổng hợp tin tức Việt Nam nhanh nhất, giao diện đẹp, tiện sử dụng">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<script type="text/javascript"
	src='<c:url value="/resources/js/readMoreFunctions.js"/>'></script>
<!-- Title -->
<title>Dòng thời gian| Tổng hợp tin tức Việt | Đọc báo | Tin mới</title>

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
	<c:set var="dtItemSeourl" value = "${detailItem.seourl}"></c:set>
	<script>
		var previousPoint;
		var nextPoint;
		var isGettingPrevious;
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
								<fmt:parseDate value="${item.addDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date" timeZone="GMT-15"/>
								${date.hours }:${date.minutes }
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
		 role="dialog" aria-labelledby="myLargeModalLabel">
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


	<!-- Select Channel modal -->
	<div id="selectChannelModal" class="modal fade " tabindex="-1"
		role="dialog" aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg">
			<div id="iconCloseBound">
				<img id="icon-close" alt="Close"
					src='<c:url value="/resources/img/close-icon.png"/>'
					onclick="hideSelectChnModal()">
			</div>
			<div id="selectChannelModalContent" class="modal-content"
				style="min-height: 70vh; overflow: auto; max-height: 90vh; padding: 4vh;">

				<div class="row">
					<!-- Vnexpress_Category -->
					<div id="categoryBound_vnexpress" class="col-md-4"">
						<img class="newslogo" alt="Vnexpess"
							src='<c:url value="/resources/img/logo/logo_vnexpress.jpg"/>'
							style="margin-left: 20%">


						<c:forEach var="cateItem" items="${vnexpressCategory}">
							<div class="[ form-group ]">
								<input class="checkbox-chn" name="fancy-checkbox-default"
									id="fancy-checkbox-${cateItem.cookie}-vnexpress"
									value="${cateItem.cookie}" autocomplete="off" type="checkbox">
								<div class="[ btn-group ]" style="width: 80%; margin-left: 20%">
									<label
										style="border-radius: 10px 0px; background: #9F224E none repeat scroll 0% 0%;"
										for="fancy-checkbox-${cateItem.cookie}-vnexpress"
										class="[ btn btn-default"> <span
										class="[ glyphicon glyphicon-ok ]"></span> <span>&nbsp;</span>
									</label> <label style="border-radius: 0px 0px 0px 5px; width: 60%;"
										"
										for="fancy-checkbox-${cateItem.cookie}-vnexpress"
										class="[ btn btn-default active ]">
										${cateItem.displayName}</label>
								</div>
							</div>

						</c:forEach>
					</div>
					<!-- Vnexpress_Category -->
					<div id="categoryBound_kenh14" class="col-md-4">
						<!-- Kenh14_Category -->
						<img class="newslogo" alt="Kenh14"
							src='<c:url value="/resources/img/logo/logo_kenh14.jpg"/>'
							style="margin-left: 20%">

						<c:forEach var="cateItem" items="${kenh14Category}">
							<div class="[ form-group ]">
								<input class="checkbox-chn" name="fancy-checkbox-default"
									id="fancy-checkbox-${cateItem.cookie}-vnexpress"
									value="${cateItem.cookie}" autocomplete="off" type="checkbox">
								<div class="[ btn-group ]" style="width: 80%; margin-left: 20%">
									<label
										style="border-radius: 10px 0px; background: #C44718 none repeat scroll 0% 0%;"
										for="fancy-checkbox-${cateItem.cookie}-vnexpress"
										class="[ btn btn-default"> <span
										class="[ glyphicon glyphicon-ok ]"></span> <span>&nbsp;</span>
									</label> <label style="border-radius: 0px 0px 0px 5px; width: 60%;"
										for="fancy-checkbox-${cateItem.cookie}-vnexpress"
										class="[ btn btn-default active ]">
										${cateItem.displayName}</label>
								</div>
							</div>
						</c:forEach>

						<!-- Kenh14_Category -->
					</div>
					<div id="categoryBound_dantri" class="col-md-4">
						<!-- DanTri_category -->
						<img class="newslogo" alt="Kenh14"
							src='<c:url value="/resources/img/logo/logo_dantri.jpg"/>'
							style="margin-left: 20%">

						<c:forEach var="cateItem" items="${dantriCategory}">
							<div class="[ form-group ]">
								<input class="checkbox-chn" name="fancy-checkbox-default"
									id="fancy-checkbox-${cateItem.cookie}-vnexpress"
									value="${cateItem.cookie}" autocomplete="off" type="checkbox">
								<div class="[ btn-group ]" style="width: 80%; margin-left: 20%">
									<label
										style="border-radius: 10px 0px; background: #00622A none repeat scroll 0% 0%;"
										for="fancy-checkbox-${cateItem.cookie}-vnexpress"
										class="[ btn btn-default"> <span
										class="[ glyphicon glyphicon-ok ]"></span> <span>&nbsp;</span>
									</label> <label style="border-radius: 0px 0px 0px 5px; width: 60%;"
										for="fancy-checkbox-${cateItem.cookie}-vnexpress"
										class="[ btn btn-default active ]">
										${cateItem.displayName}</label>
								</div>
							</div>
						</c:forEach>

						<!-- DanTricategory -->						
					</div>										
				</div>
				<!-- ALL + UNCHECK ALL + RECOMMEND -->
				<div class="row-utility">				
					<div class="col-md-4" style="text-align: right;">
						<label class="btn-utility-checkbox" onclick="checkall();"> 
							<span class="[ glyphicon glyphicon-ok checkall ]"
								  style="visibility: hidden;"></span>
						</label> 
						<label class="btn-utility-title" onclick="checkall();">
							Chọn Tất cả
						</label>
					</div>
					<div class="col-md-4" style="text-align: center;">
						<label class="btn-utility-checkbox" onclick="uncheckall();"> 
							<span class="[ glyphicon glyphicon-ok uncheckall ]"
								  style="visibility: hidden;"></span>
						</label> 
						<label class="btn-utility-title" onclick="uncheckall();">
							Bỏ chọn Tất cả
						</label>
					</div>
					<div class="col-md-4" style="text-align: left;">
						<label class="btn-utility-checkbox" onclick="recommend();"> 
							<span class="[ glyphicon glyphicon-ok recommend ]"
								  style="visibility: hidden;"></span>
						</label> 
						<label class="btn-utility-title" onclick="recommend();">
							Gợi ý
						</label>
					</div>
				</div>
				<!-- ALL + UNCHECK ALL + RECOMMEND -->
				<div id="getFeedBack">
					<div class="form-group" align="center" style="margin-left: 10%">
						<p>
							<i>Không tìm thấy trang yêu thích của bạn? Hảy gửi yêu cầu
								cho chúng tôi</i>
						</p>

						<input type="text" class="form-control" id="feedBackContent"
							style="width: 70%; float: left;"> <input type="button"
							class="btn" style="width: 10" value="Gửi">
					</div>

				</div>
			</div>

		</div>
	</div>
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

		function callPreviousAjax(){
			isGettingPrevious = true;
			jQuery.ajax({
				type : "GET",
				url : "getPrevious",
				data : {
					previousPoint : previousPoint
				},
				success : function(data) {
					$(".sonic").remove();
					$(".sonicChrome").remove();
					if (data.length === 0) {
						return;
					}
					console.log("Get previous. Result = " + data.length);
					addItemsToTail(data);
					isGettingPrevious = false;
				},
				error : function(data) {
					$(".sonic").remove();
					$(".sonicChrome").remove();
					isGettingPrevious = false;
					console.log("Get previous Error: " + data);
				}
			});
			$(".cd-timeline-year").show();
		}

		function getPrevious() {
		//create new Sonic each getPrevious;]
		if (isGettingPrevious === true){
			return;
		}

			
		var loader = new Sonic({
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
			var agent = navigator.userAgent;
			if(agent.indexOf("Mobile") != -1){
				$(".sonic").attr('class', 'sonicMobile');
			}
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
			var seourl = "${dtItemSeourl}";
			handleDetailItem(url,seourl);
			
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
				
				if (window.pageYOffset >= document.body.scrollHeight - document.documentElement.clientHeight) {
			        // at bottom
					setTimeout(getPrevious,1000);
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