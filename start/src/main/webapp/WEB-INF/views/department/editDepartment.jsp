<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<form:form class="form-horizontal" method="post"
		modelAttribute="departmentObject" action="/start/department/edit/">
		<form:errors path="*" cssClass="errorblock" element="div" />

		<form:hidden path="id" />

		<label>ID</label>
		<div>
			<form:input path="id" type="text" id="id" placeholder="ID" />
		</div>

		<label>Department</label>
		<div>
			<form:input path="name" type="text" id="Department Name"
				placeholder="Department Name" />
			<form:errors path="name" cssClass="error" />
			
		</div>



		<button type="submit">Submit</button>
	</form:form>
</div> --%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
 
<body>
	<h2>Customer SignUp Form - JSR303 @Valid example</h2>
 
	<form:form method="POST" commandName="departmentObject" action="/start/department/edit/">
		<%-- <form:errors path="*" cssClass="errorblock" element="div" /> --%>
		<table>
			<tr>
				<td>Department Name :</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>
 
</body>
</html>

