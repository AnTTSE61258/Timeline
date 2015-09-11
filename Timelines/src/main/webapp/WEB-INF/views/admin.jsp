<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<link rel='stylesheet'
	href='<c:url value="/resources/css/bootstrap.css" />' type='text/css'
	media='all' />

</head>
<body>
	<c:set var="rssTimer" value="${getRssTimer}"></c:set>
	<c:set var="generateTimer" value="${generateTimer}"></c:set>
	
	${rssTimer.timerName }



	<h3>Update status</h3>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>#</th>
				<th>Service name</th>
				<th>isRunning</th>
				<th>isRepeating</th>
				<th>isCoalesces</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>${rssTimer.timerName }</td>
				<td>${rssTimer.running}</td>
				<td>${rssTimer.repeats}</td>
				<td>${rssTimer.coalesces}</td>
			</tr>
			<tr>
				<td>1</td>
				<td>${generateTimer.timerName }</td>
				<td>${generateTimer.running}</td>
				<td>${generateTimer.repeats}</td>
				<td>${generateTimer.coalesces}</td>
			</tr>
		</tbody>
	</table>
	<div>
		<form action="<c:url value="/admin/control"/>" method="POST">
			<input name="btnControl" type="submit" value="START SERVICE" /> <input
				name="btnControl" type="submit" value="STOP SERVICE" /> <input
				name="btnControl" type="submit" value="GENERATE CACHE" />
		</form>
	</div>

	<table style="border: 5px">
		<thead>
			<tr>
				<th>No.</th>
				<th>Title</th>
				<th>Channel_Category</th>
				<th>ShortUrl</th>
				<th>addDate</th>
			</tr>

		</thead>
		<tbody>
			<c:forEach var="item" items="${items }" varStatus="counter">
				<tr>

					<td>${counter.count}</td>
					<td>${item.title }</td>
					<td>${item.channel}-${item.category}</td>
					<td>${item.seourl }</td>
					<td>${item.addDate }</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<a href="/timeline/admin/admin-refresh" class="button">Go to Google</a>
</body>