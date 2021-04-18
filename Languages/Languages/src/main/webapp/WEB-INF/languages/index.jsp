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
<table class="table table-dark mt-4">
    <thead class="thead-light">
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Current Version</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${languageList}" var="l">
        <tr>
            <td><a href="/languages/${l.id}"><c:out value="${l.name}"/></a></td>
            <td><c:out value="${l.creator}"/></td>
            <td><c:out value="${l.currentVersion}"/></td>
            <td>
<form action="/languages/${l.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" class="text-button text-primary" value="Delete">
</form><a href="languages/edit/${l.id}">Edit</a></td>

        </tr>
        </c:forEach>
    </tbody>
</table>

<form:form action="/languages" method="post" class="mt-4" modelAttribute="language">
    <div class="form-group">
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input class="form-control" path="name"/>
    </div>
    <div class="form-group">
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea class="form-control" path="creator"/>
    </div>
    <div class="form-group">
        <form:label path="currentVersion">Current Version</form:label>
        <form:errors path="currentVersion"/>
        <form:input class="form-control" path="currentVersion"/>
   </div> 
    <input type="submit" value="Submit" class="btn btn-primary"/>
</form:form>    
</div><!---------End of Container--------->
</body>
</html>