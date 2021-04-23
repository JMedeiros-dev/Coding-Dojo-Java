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
<title>WaterBnB</title>
<!---------Bootstrap--------->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
  <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
     <style> 
	#messageBox {
  overflow:scroll;
  height: 30vh;
  border: 3px solid black;
}
</style>
</head>
<body>
<div class="container"> <!---------Beginning of Container--------->
	<div class="row mt-4">
	<div class="col">
  <a class="float-right ml-3" href="/logout">Logout</a>
   <a class="float-right" href="/search">Home</a>
   </div>
   </div>
   <div class="row">
		<div class="col-md-6">
		<h4 class="font-weight-bold"><c:out value="${listing.address}"/></h4>
		<p class="mt-4"><c:out value="${listing.description}"/></p>
		
		</div>
		<div class="col-md-6 mt-2">
		<p class="ml-5">Email: <c:out value="${listing.user.email}"/></p>
<p class="ml-5">Name: <c:out value="${listing.user.firstName}"/> <c:out value="${listing.user.lastName}"/></p>
<p class="ml-5">Pool Size: <c:out value="${listing.pool}"/></p>
<p class="ml-5">Cost Per Night: $<c:out value="${listing.cost}"/></p>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
		<p><a class="float-right" href="/listings/${listing.id}/review">Leave a review</a></p>
		<p class="font-weight-bold">Reviews</p>
		
	<div class="rounded" id="messageBox">
	 <c:forEach items="${listing.reviews}" var="r"> 

            <p><c:out value="${r.reviewer}"/>
            <p>Rating: <c:out value="${r.rating}"/></p>
            <p><c:out value="${r.response}"/></p>
            
			<hr>

        </c:forEach>
		</div>
</div><!---------End of Container--------->
</body>
</html>