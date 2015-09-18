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

<link rel='stylesheet'
	href='<c:url value="/resources/css/animate.css"/>' type='text/css'
	media='all' />


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
</head>

<body class="home blog" onresize="fixwidth();">

	<script>
		$(document).ready(function() {
			loadCookieToModal();
		})
	</script>

	<button type="button" class="btn btn-default btn-lg" onclick="selectback()">
		<span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>Trở về
	</button>

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
	
	<button type="button" class="btn btn-default btn-lg" onclick="selectback()" style="width: 100%">
		<span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>Trở về
	</button>
	
	<div id="getFeedBack">
		<div class="form-group" align="center" style="margin-left: 10%">
			<p>
				<i>Không tìm thấy trang yêu thích của bạn? Hảy gửi yêu cầu cho
					chúng tôi</i>
			</p>

			<input type="text" class="form-control" id="feedBackContent"
				style="width: 70%; float: left;"> <input type="button"
				class="btn" style="width: 10" value="Gửi">
		</div>

	</div>


</body>
</html>