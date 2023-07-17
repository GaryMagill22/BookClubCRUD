<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<title>Dashboard</title>
</head>
<body>
<h1 style="text-align: center;" >Welcome ${userName}!</h1>



<h2>Books from everyone's shelves: </h2>
<table class="table table-bordered">
  <thead>
    <tr>
      <th>Title</th>
      <th>Author</th>
      <th>Posted By</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="eachBook" items="${bookList}">
      <tr>
        <td><a href="/books/${eachBook.id}">${eachBook.title}</a></td>
        <td>${eachBook.author}</td>
        <td>${eachBook.owner.userName}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
	<a href="/books/new" ><button class="btn btn-outline-primary">Add Book To My Shelf</button></a>
	<a href="/users/logout"><button class="btn btn-outline-danger" style="margin: 10px;" >Logout</button></a>
</body>
</html>