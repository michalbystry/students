<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<ul style="list-style: none; line-height: 28px;">

	<li><spring:url value="/index" var="homeUrl" htmlEscape="true" />
		<a href="${homeUrl}">Home</a></li>

	<li><spring:url value="/viewStudent" var="personListUrl"
			htmlEscape="true" /> <a href="${personListUrl}">Students List</a></li>

	<li><spring:url value="/searchStudent" var="personListUrl"
			htmlEscape="true" /> <a href="${personListUrl}">Search student</a></li>

	<li><spring:url value="/viewDepartment" var="personListUrl"
			htmlEscape="true" /> <a href="${personListUrl}">Department List</a></li>

	<li><spring:url value="/searchDepartment" var="personListUrl"
			htmlEscape="true" /> <a href="${personListUrl}">Search
			department</a></li>


</ul>
