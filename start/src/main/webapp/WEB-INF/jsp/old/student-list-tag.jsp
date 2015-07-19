<%@ page import="amg.start.model.Student" %>
<%@ page import="java.util.Map" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<%
    Map<Long, Student> students = (Map<Long, Student>)(request.getAttribute("students"));
%>
<html lang="en">
<head>
  <title>Student list</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
 
<%-- <div class="container">
  <h2>Students <%= students.size() %>  </h2>
  <table class="table table-hover">
    <thead>
      <tr>
		<th>ID</th>      
        <th>Name</th>
        <th>Surname</th>
        <th>PESEL</th>
      </tr>
    </thead>

    
    <c:forEach var="entry" items="${students}">
     <tr> 
    <td>${entry.key}</td>
    <td>${entry.value.getFistName()}</td>
    <td>${entry.value.getLastName()}</td>
    <td>${entry.value.getPesel()}</td>
    </tr> 
        </tbody>
  </table>
</div> --%>
    
<%--     <td> <a href="/start/student/edit?id=${entry.key}" class="btn btn-success" role="button">Edit</a></td>
    <td> <a href="/start/student/delete?id=${entry.getKey}" class="btn btn-danger" role="button">Delete</a></td> --%>
    
    <fmt:setLocale value="${param.lang}" />
    <fmt:setBundle basename="bundles.messages"/>
    
   <div class="container">
   
 <a href="?lang=pl">PL</a>    <a href="?lang=eng">ENG</a>
 
 <h2>Lista studentow JSTL core %>  </h2> 
  <table class="table table-hover">
    <thead>
      <tr>
		<th>
		<fmt:message key="student.ID.label"/>
		</th>      
        <th>
        <fmt:message key="student.firstName.label"/>
        </th>
        <th>
        <fmt:message key="student.lastName.label"/>
        </th>
        <th>
        <fmt:message key="student.pesel.label"/>
        </th>
      </tr>
    </thead>
    <tbody>
    
  <c:forEach var="entry" items="${students}">
     <tr> 
    <td>${entry.key}</td>
    <td>${entry.value.firstName}</td>
    <td>${entry.value.lastName}</td>
    <td>${entry.value.pesel}</td>
    </tr> 
    
    </c:forEach>
        </tbody>
  </table>
</div>
 <%--      <tr> 
         <td><%=entry.getKey() %></td>
        <td><%=entry.getValue().getFist_name() %></td>
        <td><%=entry.getValue().getLast_name() %></td>
        <td><%=entry.getValue().getPesel()%></td>
       <td> <a href="/start/student/edit?id=<%=entry.getKey() %>" class="btn btn-success" role="button">Edit</a></td>
       <td> <a href="/start/student/delete?id=<%=entry.getKey() %>" class="btn btn-danger" role="button">Delete</a></td>
      
      </tr>
      <% } 
  %> --%>

      
<%--       <c:forEach var="s" items="${students}">
        <td>${s.name}</td>
        <td>${s.surname}</td>
        <td>${s.email}</td>
      </c:forEach> --%>





<div class="container">
  <h2>Searched student ID</h2>
  <form class="form-inline" action="student/edit" role="form" method="post">
    <div class="form-group">
      <label class="sr-only" for="name">Student ID:</label>
      <input type="text" class="form-control" id="Student ID" name="Student ID" ">
    </div>
   
    <button type="submit" class="btn btn-default">Search</button>
  </form>
</div>

<td> <a href="/start/student/add" class="btn btn-success" role="button">Add student</a></td>

 
</body>
</html>