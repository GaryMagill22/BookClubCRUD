<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<title>Book Details</title>
</head>
<body>
<div style="margin: 0 auto; width: 500px;" >
<h1><c:out value="${userName}"/> </h1>
<h2><c:out value="${book.title}"/></h2>
<h2><c:out value="${book.thoughts}"/></h2>
</div>
<div style="margin: 0 auto;" >
<a href="/books/${book.id}/edit" ><button class="btn btn-outline-primary">Edit</button></a>
</div>
<form:form action="/books/${id}" method="delete">
<button  class="btn btn-outline-danger">Delete</button>
</form:form>
<div  style="margin: 0 auto;">
<a href="/users/logout"><button class="btn btn-outline-danger" style="margin: 10px;" >Logout</button></a>
<a href="/books" ><button class="btn btn-outline-primary">Home</button></a>	
</div>
</body>
</html>