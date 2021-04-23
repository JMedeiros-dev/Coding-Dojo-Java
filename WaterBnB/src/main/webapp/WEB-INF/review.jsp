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
   <a class="float-right ml-3" href="/search">Home</a>
   <a class="float-right" href="/listings/${listing.id}">Go Back</a>
   </div>
   </div>
<h4 class="font-weight-bold mt-4"><c:out value="${listing.address}"/></h4>
<form:form action="/listings/add_review" method="post" class="mt-4" modelAttribute="review">
<form:input type="hidden" value="${user.firstName} ${user.lastName}" path="reviewer"/>
<form:input type="hidden" value="${listing.id}" path="listing"/>
    <div class="form-group">
        <form:errors path="response"/>
        <form:textarea class="form-control" rows="8" path="response"/>
    </div>
   <div class="form-group">
        <form:label path="rating">Rating</form:label>
        <form:errors path="rating"/>     
        <form:input type="number" min="1" max="5" class="form-control col-4" path="rating"/>
    </div>   
    <input type="submit" class="btn btn-warning" value="Submit"/>
</form:form>    
		
</div><!---------End of Container--------->
</body>
</html>