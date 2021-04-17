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
<div>
<a class="float-right" href="/">Dashboard</a>
</div>
<h1 class="mt-4"><c:out value="${category.name}"/></h1>
<div class="row">
		<div class="col-md-6 mt-4">
		<h4>Products</h4>
		<c:forEach items="${category.products}" var="product">
        <div>
            <h6>- <c:out value="${product.name}"/></h6>
		</div>
        </c:forEach>
		</div>
		
		
		<div class="col-md-6 mt-4">
		<form action="/categories/addProduct" method="post" class="mt-4">
		<input type="hidden" value="${category.id}" name="category_id"  />
     <div class="form-row">
    <label class="form-label">Add Product</label>
    </div>
      <div>
        <select class="form-control mt-2 col-8" name="product_id">
        <option value="" label="--- Select ---"/>
        <c:forEach items="${products}" var="product">
          <option value="${product.id}">
            <c:out value="${product.name}"/></option>
        </c:forEach>
      </select>
      </div>
      <input type="submit" class="btn btn-primary offset-5 mt-4"
        value="Add Product" />
      </form>
    </div>
		</div>
	</div>
</div><!---------End of Container--------->
</body>
</html>