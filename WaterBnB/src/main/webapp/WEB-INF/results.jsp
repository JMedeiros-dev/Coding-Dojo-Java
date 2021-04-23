<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!---------"c:out ; c:if ; c:when ; c:forEach"--------->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WaterBnb</title>
<!---------Bootstrap--------->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
  <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container"> <!---------Beginning of Container--------->
	<div class="row mt-4">
	<div class="col">
  <a class="float-right ml-3" href="/logout">Logout</a>
   <a class="float-right" href="/search">Home</a>
   </div>
   </div>
   <p>Find Your Pool!</p>
   <form class="form-inline mt-4" action="/search" method="post">
  			<div class="form-group mx-sm-3 mb-2">
    			<input type="text" class="form-control" name="address" placeholder="Try Another Location">
  			</div>
  			<button type="submit" id="button" class="btn btn-warning mb-2">Search</button>
		</form>
		<table class="table table-striped mt-4 shadow-sm p-3 mb-5 bg-white rounded">
    <thead class="thead-dark">
        <tr>
            <th scope="col">Address</th>
            <th scope="col">Pool Size</th>
            <th scope="col">Cost Per Night</th>
            <th scope="col">Details</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${results}" var="result">
        <tr>
            <td><c:out value="${result.address}"/></td>
            <td><c:out value="${result.pool}"/></td>
            <td>$<c:out value="${result.cost}"/></td>
            <td><a href="/listings/${result.id}"> - See more</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</div><!---------End of Container--------->
</body>
</html>