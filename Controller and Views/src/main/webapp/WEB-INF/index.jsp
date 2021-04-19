<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!---------"c:out ; c:if ; c:when ; c:forEach"--------->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Registration</title>
<!---------Bootstrap--------->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
  <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<!-------------------Beginning of Container----------------->
<div class="container"> 

		<p class="text-danger text-center mt-2"><c:out value="${please}" /></p>


<!-----------------------Registration--------------------------->

<div class="row">
	<div class="col-md-6">
		<h1 class="mt-4">Register</h1>
    
    <div class="text-danger"><form:errors path="user.*"/></div>
    
    <form:form method="POST" action="/registration" class="col-10 mt-4" modelAttribute="user">
        <div class="form-group">
            <form:label path="email">Email:</form:label>
            <form:input class="form-control" type="email" path="email"/>
        </div>
        <div class="form-group">
            <form:label path="password">Password:</form:label>
            <form:password class="form-control" path="password"/>
        </div>
        <div class="form-group">
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password class="form-control" path="passwordConfirmation"/>
        </div>
        <input type="submit" class="btn btn-primary" value="Sign Up"/>
    </form:form>	
	</div>
		
					
		
<!--------------------------Login--------------------------->
		<div class="col-md-6">
		 <h1 class="mt-4">Login</h1>
    	<div><p class="text-danger"><c:out value="${error}" /></p></div>
    	<form method="post" class="col-10 mt-4" action="/login">
         <div class="form-group">
            <label for="email">Email</label>
            <input type="text" class="form-control" id="email" name="email"/>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password"/>
        </div>
        <div>
        <input type="submit" class="btn btn-primary" value="Sign in"/>
        </div>
   	 	</form>    
		</div>
	</div>
</div>
<!-----------------------End of Container-------------------->
</body>
</html>