<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!---------"c:out ; c:if ; c:when ; c:forEach"--------->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
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

		<div class="mt-5">
			<h1>New Person</h1>
		</div>
		<div>
			<form:form action="/persons/new" method="post"
				modelAttribute="person" class="mt-5">
				<div class="form-row mb-3">
					<form:label path="firstName" class="col-sm-2 col-form-label">First Name</form:label>
					<form:errors path="firstName" />
					<div class="col-sm-4">
						<form:input path="firstName" class="form-control" />
					</div>
				</div>
				<div class="form-row mb-3">
					<form:label path="lastName" class="col-sm-2 col-form-label">Last Name</form:label>
					<form:errors path="lastName" />
					<div class="col-sm-4">
						<form:input path="lastName" class="form-control" />
					</div>
				</div>
				<div class="col-6">
					<input type="submit" class="btn btn-success btn-sm float-right"
						value="Create" />
				</div>
			</form:form>
		</div>
	</div>
	<!---------End of Container--------->
</body>
</html>