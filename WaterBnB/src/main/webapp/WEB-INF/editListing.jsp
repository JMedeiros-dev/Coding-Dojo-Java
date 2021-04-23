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
   <a class="float-right" href="/dashboard">Home</a>
  	<div class="row mt-4">
		<div class="col-md-12">
		<p class="font-weight-bold"><c:out value="${listing.address}"/></p>
		
    
<div class="form-group">
<p >Name: <c:out value="${listing.user.firstName}"/> <c:out value="${listing.user.lastName}"/></p>
		 <p >Email: <c:out value="${listing.user.email}"/></p>
<form:form action="/listings/edit/${listing.id}" method="post" class=" mt-4 text-light shadow-sm p-3 mb-2 bg-dark rounded" modelAttribute="listing">
    <form:hidden value="${user.id}" path="user"/>
    <div class="form-group">
        <form:label path="address">Address</form:label>
        <form:errors path="address"/>
        <form:input class="form-control" path="address"/>
    </div>
    <div class="form-group">
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea class="form-control" rows="4" path="description"/>
    </div>
    <div class="form-group">
        <form:label path="cost">Cost Per Night</form:label>
        <form:errors path="cost"/>     
        <form:input type="number" step=".01" class="form-control col-4" path="cost"/>
    </div>   
     <div class="form-group">
			<form:label path="pool">Pool Size</form:label>
            <form:select path="pool" class="form-control col-4 ">
            	<form:option value="small" label="Small">Small</form:option>
            	<form:option value="medium" label="Medium">Medium</form:option>
            	<form:option value="large" label="Large">Large</form:option>
            </form:select>
            </div>
    <input type="hidden" name="_method" value="put"/>
    <input type="submit" class="btn btn-warning" value="Save Changes"/>
</form:form>  
</div>   
</div>
	
	</div>
	<div class="row">
		<div class="col-md-12">
		<p class="font-weight-bold">Reviews</p>
	<div class="rounded" id="messageBox">
	 <c:forEach items="${users}" var="u">

            <p><c:out value="${u.firstName}"/> <c:out value="${u.lastName}"/></p>
            <p>Rating: <c:out value="${u.user.rating}"/></p>
            <p><c:out value="${u.user.response}"/></p>
            
			<hr>

        </c:forEach>
	</div>
		</div>
  
  
  
  
  
  
  
  
  
</div>
</div>
</div><!---------End of Container--------->
</body>
</html>