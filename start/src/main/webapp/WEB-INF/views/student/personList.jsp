<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
table.reference tr:nth-child(even) {
	background-color: #ffffff;
	border: 1px solid #000;
}

tbody {
	display: table-row-group;
	vertical-align: middle;
	border-color: inherit;
}

table.reference tr:nth-child(odd) {
	background-color: #f1f1f1;
}

tr {
	display: table-row;
	vertical-align: inherit;
	border-color: inherit;
}
</style>
<div style="margin: 10px;">
	<h4>List of Persons</h4>
	<table style="width: 600px" class="reference">
		<tbody>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Surname</th>
				<th>PESEL</th>
			</tr>
			<c:forEach var="entry" items="${requestScope.persons}">
				<tr>
					<td>${entry.id}</td>
					<td>${entry.firstName}</td>
					<td>${entry.lastName}</td>
					<td>${entry.pesel}</td>
					<td><a href="student/edit?id=${entry.id}"
						class="btn btn-info role="button">Edit</a></td>
					<td><a href="student/remove/${entry.id}"
						class="btn btn-danger role="button">Remove</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<tr>
		<td><a href="student/edit" class="btn btn-info role="button">Add student</a></td>
	</tr>
</div>