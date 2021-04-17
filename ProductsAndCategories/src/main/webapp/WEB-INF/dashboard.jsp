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
<h1 class="mt-4">All Products and Categories</h1>
<h1 class="mt-4">Products</h1>
<table class="table table-striped">
    <thead class="thead-dark">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${products}" var="product">
        <tr>
            <td><a href="/products/${product.id}"><c:out value="${product.name}"/></a></td>
            <td><c:out value="${product.price}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/products/new">New Product</a>

<h1 class="mt-4">Categories</h1>
<table class="table table-striped">
    <thead class="thead-dark">
        <tr>
            <th scope="col">Name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${categories}" var="category">
        <tr>
            <td><a href="/categories/${category.id}"><c:out value="${category.name}"/></a></td>

        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/categories/new">New Category</a>
</div><!---------End of Container--------->
</body>
</html>