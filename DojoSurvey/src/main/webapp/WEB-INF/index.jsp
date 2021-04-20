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
      <form action="/processing" method="POST" class="col-8 shadow p-3 mb-5 bg-white rounded mt-4 pb-3">
        <div class="form-group">
          <label for="your_name">Your Name</label>
          <input type="text" class="form-control" id="your_name" name="name" >
        </div>
        <div class="form-group">
          <label for="location">Dojo Location</label>
          <select class="form-control" id="location" name="location">
            <option>San Jose</option>
            <option>Arlington</option>
            <option>Bellevue</option>
            <option>Burbank</option>
            <option>Chicago</option>
            <option>Dallas</option>
          </select>
        </div>
        <div class="form-group">
          <label for="language">Favorite Language</label>
          <select class="form-control" id="language" name="language">
            <option>Python</option>
            <option>C#</option>
            <option>Java</option>
            <option>Ruby</option>
            <option>JavaScript</option>
            <option>Dothraki</option>
          </select>
        </div>
        <div class="form-group">
          <label for="textarea">Comment (optional):</label>
          <textarea class="form-control" id="textarea" rows="3" name="comment"></textarea>
        </div>
        <div>
        <button type="submit" class="btn btn-success float-right">Submit</button>
      </div>
      </form>
    </div>
</body>
</html>