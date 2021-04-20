<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
</head>
<body>
<div class="container">
      <div>
        <h3 class="mt-5">Your Gold: <c:out value="${count}"/></h3>
      </div>
      
      
      <div class="row d-flex mt-5 justify-content-around">
        
          <div class="col-sm-3">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title text-center">Farm</h5>
                <p class="card-text text-center">(earns 10-20 gold)</p>
                  <form action="/submit" method="POST" class="d-flex justify-content-center">
                  <input type="hidden" name="getGold" value="farm">
                  <input type="submit" class="btn btn-success" value="Find Gold!">
                </form>
              </div>
            </div>
          </div>


          <div class="col-sm-3">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title text-center">Cave</h5>
                <p class="card-text text-center">(earns 5-10 gold)</p>
                 <form action="/submit" method="POST" class="d-flex justify-content-center">
                  <input type="hidden" name="getGold" value="cave">
                  <input type="submit" class="btn btn-success" value="Find Gold!">
                </form>
              </div>
            </div>
          </div>


          <div class="col-sm-3">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title text-center">House</h5>
                <p class="card-text text-center">(earns 2-5 gold)</p>
                 <form action="/submit" method="POST" class="d-flex justify-content-center">
                  <input type="hidden" name="getGold" value="house">
                  <input type="submit" class="btn btn-success" value="Find Gold!">
                </form>
              </div>
            </div>
          </div>
          
    
          <div class="col-sm-3 mb-2">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title text-center">Casino</h5>
                <p class="card-text text-center">(earns/takes 0-50 gold)</p>
                 <form action="/submit" method="POST" class="d-flex justify-content-center">
                  <input type="hidden" name="getGold" value="casino">
                  <input type="submit" class="btn btn-success" value="Find Gold!">
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="mt-5">
          <h3>Activities:</h3>
        </div>
        <div class="card" style="height: 20vh;  overflow: scroll;">
        	<c:forEach items="${activities}" var="text">
          <p class="card-text text-${color}"> <c:out value="${text}"/></p>
          </c:forEach>
        </div>
        <a href="/clear" class="text-light mt-4 col-12 btn btn-warning">Empty Your Account</a>
      </div>
</body>
</html>