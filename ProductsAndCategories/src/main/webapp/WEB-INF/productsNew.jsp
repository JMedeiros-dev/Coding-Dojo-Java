<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<h1 class="mt-4">New Product</h1>
<form:form action="/products" method="post" class="mt-4" modelAttribute="product">
    <div class="form-group">
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input class="form-control col-8" path="name"/>
    </div>
    <div class="form-group">
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea class="form-control col-8" path="description"/>
    </div>
    <div class="form-group">
        <form:label path="price">Price</form:label>
        <form:errors path="price"/>     
        <form:input type="number" step="0.01" class="form-control col-8" path="price"/>
    </div>    
    <input type="submit" class="btn btn-primary" value="Submit"/>
</form:form>    

</div><!---------End of Container--------->
</body>
</html>