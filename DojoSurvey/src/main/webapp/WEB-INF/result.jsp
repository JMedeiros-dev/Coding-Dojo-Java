<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<title>Dojo Survey Index</title>
</head>
<body>
<div class="container d-flex justify-content-center">
      <div class="col-8">
        <div>
          <div class="col-10 shadow p-3 mb-5 bg-white rounded mt-4 pb-3" >
          <h4 style="font-weight: bold; text-decoration: underline;">Submitted Info</h4>
            <p class="ml-5">Name:<c:out value="${name}"/></p>
            <p class="ml-5">Dojo Location:<c:out value="${location}"/></p>
            <p class="ml-5">Favorite Language: <c:out value="${language}"/></p>
            <p class="ml-5" style="padding-bottom: 25vh;">Comment:<c:out value="${comment}"/></p>
              <a href="/" class="btn btn-success float-right" style="margin-top: -5vh;">Go Back</a>
          </div>
        </div>
      </div>
    </div>
</body>
</html>