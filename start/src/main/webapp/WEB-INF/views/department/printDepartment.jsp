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
	<h4>Student</h4>
	<table style="width: 600px" class="reference">
		<tbody>
			<tr>
				<th>ID</th>
				<th>Department Name</th>
			</tr>
			
				<tr>
					<td>${department.id}</td>
					<td>${department.name}</td>
					<td> <a href="department/edit?id=${department.id}" class="btn btn-info role="button">Edit</a></td>
					<td> <a href="department/remove/${department.id}" class="btn btn-danger role="button">Remove</a></td>
				</tr>
		</tbody>
	</table>
</div>