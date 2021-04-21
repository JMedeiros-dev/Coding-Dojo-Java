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
<title>title</title>
<!---------Bootstrap--------->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
  <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container"> <!---------Beginning of Container--------->
<a class="float-right" href="/dashboard">Go Back</a>
<h1 class="mt-4"><c:out value="${event.name}"/></h1>
<h4 class="mt-4">Edit Event</h4>
<form:form action="/event/${event.id}" method="post" modelAttribute="event">
		<input type="hidden" name="_method" value="put">
    <div class="form-group">
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input class="form-control col-8" path="name"/>
    </div>
    <div class="form-group">
        <form:label path="date">Date</form:label>
        <form:errors path="date"/>
        <form:input type="date" class="form-control col-8" path="date"/>
    </div>
	<div class="form-group">
            <form:label path="location">Location</form:label>
            <div class="row">          
            <form:input class="form-control col-6 ml-3" path="location" />
            <form:select path="state" class="form-control col-2 ml-2">
            	<form:option value="MA" label="MA">MA</form:option>
            	<form:option value="RI" label="RI">RI</form:option>
            	<form:option value="CT" label="CT">CT</form:option>
          	<form:hidden value="${userId}" path="user"></form:hidden>
            </form:select>
            </div>
   
    <input type="submit" class="btn btn-primary mt-3" value="Submit"/>
</form:form>    
</div><!---------End of Container--------->
</body>
</html>