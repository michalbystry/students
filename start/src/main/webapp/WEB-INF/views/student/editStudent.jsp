<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<form:form class="form-horizontal" method="post"
		modelAttribute="studentObject" action="/start/student/edit/">
		
		<form:hidden path="id" />

		<%-- <label>ID</label>
		<div>
			<form:input path="id" type="text" id="id" placeholder="ID" />
		</div> --%>

		<label>First Name</label>
		<div>
			<form:input path="firstName" type="text" id="name"
				placeholder="First Name" />
		</div>

		<label>Last Name</label>
		<div>
			<form:input path="lastName" type="text" id="name" placeholder="Name" />
		</div>

		<label>PESEL</label>
		<div>
			<form:input path="pesel" type="text" id="name" placeholder="Pesel" />
		</div>
		<button type="submit">Submit</button>
	</form:form>
</div>
