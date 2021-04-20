<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!---------"c:out ; c:if ; c:when ; c:forEach"--------->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
<!---------Bootstrap--------->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<!---------Beginning of Container--------->
		<div class="mt-5">
			<h1>New License</h1>
		</div>
		<div>
			<form:form action="/license" method="post"
				modelAttribute="license" class="mt-5">
				 <div class="form-row mb-3">
				<form:label path="person" class="col-sm-2 col-form-label">Person</form:label>
				<form:errors path="person" />
					<div class="col-sm-4">
						<form:select path="person" class="form-control">
						<c:forEach items="${persons}" var="person">
							<form:option value="${person.id}">
								<c:out value="${person.firstName}"/>
									<c:out value="${person.lastName}"/> </form:option>
						</c:forEach>
					</form:select>
					</div>
				</div>
				<div class="form-row mb-3">
					<form:label path="state" class="col-sm-2 col-form-label">State</form:label>
					<form:errors path="state" />
					<div class="col-sm-4">
						<form:input path="state" class="form-control" />
					</div>
				</div>
				<div class="form-row mb-3">
					<form:label path="expirationDate" class="col-sm-2 col-form-label">Expiration Date</form:label>
					<form:errors path="expirationDate" />
					<div class="col-sm-4">
						<form:input type="date" path="expirationDate" class="form-control" />
						
					</div>
				</div>
				<div class="col-6">
					<input type="submit" class="btn btn-success btn-sm float-right"
						value="Create" />
				</div>
			</form:form>
		</div>
	</div>
	<!---------End of Container--------->
</body>
</html>