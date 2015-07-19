<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<form:form class="form-horizontal" method="post" 
		 modelAttribute="searchCriteria" >
		<!-- <form:hidden path="id" /> -->

		<label>Searched student ID</label>
		<div>
			<form:input path="id" type="text" id="id" placeholder="ID" />
		</div>

		<button type="submit">Search</button>
	</form:form>
</div>