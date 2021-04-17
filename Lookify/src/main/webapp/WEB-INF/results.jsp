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
		  <p><span class="font-weight-bold">Results for:</span> <c:out value="${artist}" /></p>
		  </div>
		  <form class="form-inline float-right" action="/search" method="post">
        <div class="form-group mx-sm-3 mb-2">
        <input type="text" class="form-control" placeholder="Artist" name="artist"/>
        </div>
         <input type="submit" class="btn btn-primary mb-2" value="Search Artists"/>
	</form>  
		
		<div>
			<table class="table mt-4">
				<thead class="thead-dark">
					<tr>
						<th>Name</th>
						<th>Rating</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${results}" var="result">
						<tr>
							<td><a class="text-dark" href="/songs/${result.id}"><c:out
										value="${result.title}" /></a></td>
							<td><c:out value="${result.rating}" /></td>
							<td><form action="/songs/${result.id}" method="post">
									<input type="hidden" name="_method" value="delete"> <input
										type="submit" value="Delete">
								</form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!---------End of Container--------->
</body>
</html>