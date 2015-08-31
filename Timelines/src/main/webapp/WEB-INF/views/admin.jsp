<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en-US">
<head>

</head>
<body>
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
					<td>${item.title }</td>\
					<td>${item.channel} - ${item.category}</td>
					<td>${item.seourl }</td>
					<td>${item.addDate }</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<a href="/timeline/admin/admin-refresh" class="button">Go to Google</a>
</body>