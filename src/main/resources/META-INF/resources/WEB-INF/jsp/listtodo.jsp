<%@ include file="common/header.jspf" %>
<%@ include file="common/navbar.jspf" %>
<div class="p-2 m-3">

<table class="table">
<thead>
<tr>
<th>id</th>
<th>name</th>

<th>Time</th>
<th>Done</th>
</tr>
</thead>
<tbody>
<c:forEach items="${todos}" var="todo">
<tr>
<td>${todo.id}</td>

<td>${todo.disc}</td>
<td>${todo.target}</td>
<td>${todo.done}</td>
<td><a  href="update-todo?id=${todo.id}" class="btn btn-primary">Edit</a></td>
<td><a  href="remove-id?id=${todo.id}" class="btn btn-danger">Delete</a></td>

</tr>
</c:forEach>
</tbody>
</table>
<a  href="add-todo" class="btn btn-success">Add Todo</a>
</div>
</body>
</html>