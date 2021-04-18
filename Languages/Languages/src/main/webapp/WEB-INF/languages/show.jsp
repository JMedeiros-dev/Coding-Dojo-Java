<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!---------"c:out ; c:if ; c:when ; c:forEach"--------->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${language.id}</title>
<!---------Bootstrap--------->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
  <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style type="text/css">
    .text-button 
    { 
        background-color: Transparent;                                  
        cursor: pointer; 
        border:0;
        padding: 0;
    }    
</style>
</head>
<body>
<div class="container"> <!---------Beginning of Container--------->
<p><a href="/languages" class="float-right">Dashboard</a></p>
<div class="mt-5">
<p><c:out value="${language.name}"/></p>
<p><c:out value="${language.creator}"/></p>
<p><c:out value="${language.currentVersion}"/></p>
<p>
<form action="/languages/${language.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" class="text-button text-primary" value="Delete">
</form></p>
<p><a href="/languages/edit/${language.id}">  Edit</a></p>
</div>
</div><!---------End of Container--------->
</body>
</html>