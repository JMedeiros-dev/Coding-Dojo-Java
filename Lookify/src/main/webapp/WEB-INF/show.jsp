<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!---------"c:out ; c:if ; c:when ; c:forEach"--------->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify</title>
<style type="text/css">
.text-button {
	background-color: Transparent;
	padding: 0;
	cursor: pointer;
	border: 0;
}
</style>
<!---------Bootstrap--------->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<!---------Beginning of Container--------->
		<div class="col-12 text-right mt-4 mb-4">
			<a href="/dashboard">Dashboard</a>
		</div>
		<div class="mt-5">
			<p>
				<span class="font-weight-bold">Title:</span>
				<c:out value="${song.title}" />
			</p>
			<p>
				<span class="font-weight-bold">Artist:</span>
				<c:out value="${song.artist}" />
			</p>
			<p>
				<span class="font-weight-bold">Rating (1-10):</span>
				<c:out value="${song.rating}" />
			</p>
			<p>
			<form action="/songs/${song.id}" method="post">
				<input type="hidden" name="_method" value="delete"> <input
					type="submit" class="text-button text-primary" value="Delete">
			</form>
			</p>
		</div>
	</div>
	<!---------End of Container--------->
</body>
</html>