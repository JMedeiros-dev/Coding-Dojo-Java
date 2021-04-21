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
<title>Dashboard</title>
<!---------Bootstrap--------->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
  <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container"> <!---------Beginning of Container--------->
<a class="float-right" href="/logout">Logout</a>
<h1 class="mt-4"> Welcome <c:out value="${user.firstName}"/></h1>
<p class="mt-4">Here are some events in your local state:</p>

<table class="table table-striped mt-2 mb-2">
  <thead class="thead-dark">
      <tr>
          <th scope="col">Name</th>
          <th scope="col">Date</th>
          <th scope="col">Location</th>
          <th scope="col">State</th>
          <th scope="col">Host</th>
          <th scope="col">Action</th>
      </tr>
  </thead>
  <tbody>
    <c:forEach items="${events}" var="e">
        <c:if test="${e.state == user.state}">
      <tr>
          <td><a href="/events/${e.id}"><c:out value="${e.name}"/></a></td>
          <td><c:out value="${e.date}"/></td>
          <td><c:out value="${e.location}"/></td>
          <td><c:out value="${e.state}"/></td>
          <td><c:out value="${e.user.firstName}"/> <c:out value="${e.user.lastName}"/></td>
           <c:if test="${e.user.id == user.id}">
       	
          <td><a class="btn btn-secondary btn-sm" href="/events/${e.id}/edit">Edit</a>  
          <form action="/delete/${e.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" class="btn btn-danger btn-sm mt-2" value="Delete"></form></td>
    	</c:if>
           
          <c:if test="${!e.attendees.contains(user) && e.user.id != user.id}"> 
          <td><a class="btn btn-primary btn-sm" href="/events/join/${e.id}">Attend</a></td>
          </c:if>
          <c:if test="${e.attendees.contains(user)}"> 
          <td><span class="text-success">Attending</span> <a class="btn btn-primary btn-sm ml-2" href="/events/cancel/${e.id}">Cancel</a></td>
          </c:if>
      </tr>
    </c:if>
      </c:forEach>
  </tbody>
</table>

<p class="mt-4">Here are some events in other states:</p>

<table class="table table-striped  mt-2 mb-3">
  <thead class="thead-dark">
      <tr>
          <th scope="col">Name</th>
          <th scope="col">Date</th>
          <th scope="col">Location</th>
          <th scope="col">State</th>
          <th scope="col">Host</th>
          <th scope="col">Action</th>
      </tr>
  </thead>
  <tbody>
    <c:forEach items="${events}" var="e">
        <c:if test="${e.state != user.state}">
      <tr>
          <td><a href="/events/${e.id}"><c:out value="${e.name}"/></a></td>
          <td><c:out value="${e.date}"/></td>
          <td><c:out value="${e.location}"/></td>
          <td><c:out value="${e.state}"/></td>
          <td><c:out value="${e.user.firstName}"/> <c:out value="${e.user.lastName}"/></td>
          
          <c:if test="${e.user.id == user.id}">
       	
          <td><a class="btn btn-secondary btn-sm" href="/events/${e.id}/edit">Edit</a>  
          <form action="/delete/${e.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" class="btn btn-danger btn-sm mt-2" value="Delete"></form></td>
    	</c:if>
           
          <c:if test="${!e.attendees.contains(user) && e.user.id != user.id}"> 
          <td><a class="btn btn-primary btn-sm" href="/events/join/${e.id}">Attend</a></td>
          </c:if>
          <c:if test="${e.attendees.contains(user)}"> 
          <td><span class="text-success">Attending</span> <a class="btn btn-primary btn-sm ml-2" href="/events/cancel/${e.id}">Cancel</a></td>
          </c:if>
      </tr>
    </c:if>
      </c:forEach>
  </tbody>
</table>

<h4 class="mt-5">Create an Event</h4>
<form:form action="/events" method="post" class="mt-2" modelAttribute="event">
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