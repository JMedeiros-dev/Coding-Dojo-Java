<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Secret Code</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<p style="color: red;"><c:out value="${error}"></c:out></p>
<p>What is the code?</p>
<form action="/secret_code" method="POST">
<div class="containerText">
<input type="text" class="text" name="magicWord">
</div>
<div class="containerButton">
<input type="submit" class="myButton" value="Test Code">
</div>
</form>
</body>
</html>