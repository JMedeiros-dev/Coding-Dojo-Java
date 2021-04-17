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
			<h5 class="mt-4">Top Ten Songs:</h5>
		</div>
		<div>
			<table class="table mt-4">
				<thead class="thead-dark">
					<tr>
						<th colspan="2"><c:out value="${date}" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach end="9" items="${songs}" var="song">
						<tr>
							<td><c:out value="${song.rating}" /></td>
							<td><a class="text-dark" href="/songs/${song.id}"><c:out
										value="${song.title}" /> - by <span class="text-primary"> <c:out
										value="${song.artist}" /></span> </a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!---------End of Container--------->
</body>
</html>