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
<title>Event</title>
<!---------Bootstrap--------->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
  <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style> 
	#messageBox {
  overflow:scroll;
  height: 25vh;
  border: 3px solid black;
}
</style>
</head>
<body>
<div class="container"> <!---------Beginning of Container--------->
<a class="float-right" href="/dashboard">Go Back</a>
<h1 class="mt-4"><c:out value="${event.name}"/></h1>

<div class="row">
	<div class="col-md-6">
	<p class="mt-4"><span class="font-weight-bold"> Host:</span> <c:out value="${event.user.firstName}"/> <c:out value="${event.user.lastName}"/></p>
	<p><span class="font-weight-bold"> Date:</span> <c:out value="${event.date}"/></p>
	<p><span class="font-weight-bold"> Location:</span> <c:out value="${event.location}"/>, <c:out value="${event.state}"/></p>
	<p><span class="font-weight-bold"> People who are attending this event:</span> 
	<table class="table table-striped mt-2 col-8">
    <thead class="thead-dark">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Location</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${event.attendees}" var="attendee">
        <tr>
            <td><c:out value="${attendee.firstName}"/> <c:out value="${attendee.lastName}"/></td>
            <td><c:out value="${attendee.location}"/>, <c:out value="${attendee.state}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
	</div>
			
	<div class="col-md-6">
	<h3 class="text-center mt-5">Messages</h3>
	<div class="rounded" id="messageBox">
	 <c:forEach items="${messages}" var="m">

            <p><c:out value="${m.commenter}"/>: <c:out value="${m.comment}"/></p>
            <p>----------------------------------</p>

        </c:forEach>
	</div>
	<form:form action="/addComment" method="post" class="mt-4" modelAttribute="message">
    <div class="form-group">
        <form:label path="comment">Comment:</form:label>
        <form:errors path="comment"/>
        <form:input class="form-control" path="comment"/>
    </div>

        <form:input type="hidden"   value="${user.firstName} ${user.lastName}" path="commenter"/>
        <form:input type="hidden"   value="${event.id}" path="event"/>
    <input type="submit" class="btn btn-primary float-right" value="Add Comment"/>
</form:form>    
	</div>
</div>

</div><!---------End of Container--------->
</body>
</html>