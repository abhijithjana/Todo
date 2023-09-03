<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${uname} Todolist</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  </head>
<body>
<div class="container p-2 mt-3">
<table class="table">
<thead>
<tr>
<th>id</th>
<th>name</th>
<th>discription</th>
<th>Time</th>
<th>Done</th>
</tr>
</thead>
<tbody>
<c:forEach items="${todos}" var="todo">
<tr>
<td>${todo.id}</td>
<td>${todo.username}</td>
<td>${todo.disc}</td>
<td>${todo.target}</td>
<td>${todo.done}</td>


</tr>
</c:forEach>
</tbody>
</table>
<a  href="add-todo" class="btn btn-success">Add Todo</a>
</div>
</body>
</html>