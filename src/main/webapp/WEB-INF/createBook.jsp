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
<title>Create Book</title>
</head>
<body>
	<h1 style="text-align: center;" > Add a book to Your Shelf!</h1>
   <div class="container" style="margin-left: 700px;" >
    <form:form class="border rounded p-3" style="width: 500px; height: 300px;" action="/books/create" method="post" modelAttribute="newBook">
      <form:input type="hidden" path="owner" value="${userId}" />
      <div class="form-group">
        <form:label path="title"> Title: </form:label>
        <form:input  path="title" type="text" class="form-control"  placeholder="Enter book title"/>
        <form:errors path="title" />
      </div>
      <div class="form-group">
        <form:label path="author"> Author: </form:label>
        <form:input  path="author" type="text" class="form-control"  placeholder="Enter Author of Book"/>
        <form:errors path="author" style="color: red;" />
      </div>
      <div class="form-group">
        <form:label path="thoughts"> My Thoughts: </form:label>
        <form:textarea type="textarea" path="thoughts"  class="form-control" placeholder="thoughts..."/>
        <form:errors path="thoughts" />
      </div>
      <button type="submit" class="btn btn-outline-primary">Create</button>
    </form:form>
  </div>
  <a href="/books" ><button class="btn btn-outline-primary">Home</button></a>
</body>
</html>