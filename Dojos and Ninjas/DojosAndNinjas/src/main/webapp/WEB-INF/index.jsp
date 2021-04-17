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
<h1 class="mt-4">New Dojo</h1>

<div>
  <form:form action="/dojos" method="post" modelAttribute="dojo"
    class="mt-5">
    <div class="form-row col-8 mb-3">
      <form:label path="name" class="col-sm-2 col-form-label">Name:</form:label>
      <form:errors path="name" />
      <div class="col-sm-4">
        <form:input path="name" class="form-control" />
      </div>
    </div>
    <div class="col-sm-4">
      <input type="submit" class="btn btn-sm btn-info float-right"
        value="Create" />
    </div>
  </form:form>
</div>
</div><!---------End of Container--------->
</body>
</html>