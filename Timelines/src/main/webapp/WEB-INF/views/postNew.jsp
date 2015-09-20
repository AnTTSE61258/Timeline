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

<script type="text/javascript"
	src='<c:url value="/resources/js/ckeditor/ckeditor.js"/>'></script>


</head>

<body>
	<form id="form-1" action="post-new" method="POST">
		<div class="input-group input-group-lg">
			<span class="input-group-addon">Title</span>
			 <input name="txtTitle"	type="text" class="form-control" aria-describedby="sizing-addon1">
		</div>
		<div class="input-group input-group-lg">
			<span class="input-group-addon">Description</span>
			<input name="txtDescription" type="text" class="form-control"
				aria-describedby="sizing-addon1">
		</div>
		
		<div class="input-group input-group-lg">
			<span class="input-group-addon">Image</span>
			<input name="txtImageUrl" type="text" class="form-control"
				aria-describedby="sizing-addon1">
		</div>
		

		<textarea name="content" cols="10" rows="80">
		
		</textarea>
		
		<input type="submit" value="SUBMIT"/>
		<input type="reset" value="RESET"/> 
	</form>
	<script type="text/javascript">
	 CKEDITOR.replace( 'content' );
	</script>


</body>
</html>