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
<title>Welcome</title>
<!---------Bootstrap--------->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
  <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<div class="container"> <!---------Beginning of Container--------->
	<div class="row">
	<div class="col">
  <a class="float-right" href="/logout">Logout</a>
</div>
</div>
		
	<h6 class="text-center mt-5">Find places to swim and sleep on WaterBnB!</h6>
	<div class="d-flex justify-content-center">
		<form class="form-inline mt-2" action="/search" method="post">
  			<div class="form-group mx-sm-3 mb-2">
    			<input type="text" class="form-control" name="address" placeholder="Location">
  			</div>
  			<button type="submit" id="button" class="btn btn-warning mb-2">Search</button>
		</form>
</div>

