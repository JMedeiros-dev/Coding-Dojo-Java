<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Visit Count</title>
</head>
<body>
   <p>You have visited <a href="/">http://localhost:8080</a> <c:out value="${count}"/> times.</p>
   <p><a href="/">Test another visit?</a></p>
   <p><a href="/by-two">1 is nice but 2 is better...</a></p>
      <a href="/reset">
      <button style="background-color: darkorange;">Reset Count</button>
</body>
</html>