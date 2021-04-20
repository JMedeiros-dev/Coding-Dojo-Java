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
		<h1><c:out value="${person.firstName}"></c:out> <c:out value="${person.lastName}"></c:out></h1>
		</div>
		 <div>
			<p>License Number: <c:out value="${person.license.number}"></c:out> </p>
			<p>State: <c:out value="${person.license.state}"></c:out> </p>
			<p>Expiration Date: <c:out value="${person.license.expirationDate}"></c:out> </p>
	   </div>
	</div>
	<!---------End of Container--------->
</body>
</html>