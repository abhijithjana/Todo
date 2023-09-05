<%@ include file="common/header.jspf" %>
<%@ include file="common/navbar.jspf" %>
<div class=" m-5">
<form:form action="${action}" method="post" modelAttribute="todo">
<form:input hidden="true" path="id"/>
<form:input hidden="true" path="username"/>
<div class="mb-3">
    <label for="date" class="form-label">Target Date</label>
    <form:input path="target"  type="date" pattern="yyyy-MM-dd" class="form-control" id="date" aria-describedby="datehelp"/>
    <div id="datehelp" class="form-text">Enter Expected completion date</div>
  </div>

<form:input hidden="true" path="done"/>
<div class="form-floating">
  <form:textarea name="discription" class="form-control" placeholder="Enter your discrip.." id="floatingTextarea" required="required" path="disc"></form:textarea>
  <form:errors path="disc" cssClass="text-warning"></form:errors>
  <label for="floatingTextarea">discription</label>
</div>
 <button  type="submit" class="btn btn-primary btn-lg btn-block">submit</button>
</form:form>
</div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
  </body>
</html>