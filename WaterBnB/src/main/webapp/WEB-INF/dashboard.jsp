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
</head>
<body>
<div class="container"> <!---------Beginning of Container--------->
<div class="row">
	<div class="col">
  <a class="float-right mt-2" href="/logout">Logout</a>
</div>
</div>
<h6 class="mt-4"><c:out value="${user.firstName}"/>'s Current listings:</h6>

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
        <c:forEach items="${user.listings}" var="listing">
        <tr>
            <td><c:out value="${listing.address}"/></td>
            <td><c:out value="${listing.pool}"/></td>
            <td>$<c:out value="${listing.cost}"/></td>
            <td><a href="/listings/edit/${listing.id}"> - edit</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<h6 class="mt-5">New Listing:</h6>

<div class="d-flex justify-content-center">
<form:form action="/dashboard/new_listing" method="post" class="col-10 mt-4 text-light shadow-sm p-3 mb-5 bg-dark rounded" modelAttribute="listing">
    <form:hidden value="${user.id}" path="user"/>
    <div class="form-group">
        <form:label path="address">Address</form:label>
        <form:errors path="address"/>
        <form:input class="form-control" path="address"/>
    </div>
    <div class="form-group">
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea class="form-control" path="description"/>
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
    
    <input type="submit" class="btn btn-warning" value="Add Listing"/>
</form:form>    
</div>
</div><!---------End of Container--------->
</body>
</html>