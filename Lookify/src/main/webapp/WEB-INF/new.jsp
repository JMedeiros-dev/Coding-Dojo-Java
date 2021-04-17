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
		<div>
			<div>
				<form:form action="/songs/new" method="post" modelAttribute="song"
					class="mt-5">
					<div class="form-row mb-3">
						<form:label path="title" class="col-sm-2 col-form-label">Title</form:label>
						<form:errors path="title" />
						<div class="col-sm-6">
							<form:input path="title" class="form-control" />
						</div>
					</div>
					<div class="form-row mb-3">
						<form:label path="artist" class="col-sm-2 col-form-label">Artist</form:label>
						<form:errors path="artist" />
						<div class="col-sm-6">
							<form:input path="artist" class="form-control" />
						</div>
					</div>
					<div class="form-row mb-3">
						<form:label path="rating" class="col-sm-2 col-form-label">Rating (1-10)</form:label>
						<form:errors path="rating" />
						<div class="col-sm-1">
							<form:input type="number" class="form-control" min="1" max="10"
								path="rating" />
						</div>
					</div>
					<div class="col-8">
						<input type="submit" class="btn btn-primary float-right"
							value="Add Song" />
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<!---------End of Container--------->
</body>
</html>