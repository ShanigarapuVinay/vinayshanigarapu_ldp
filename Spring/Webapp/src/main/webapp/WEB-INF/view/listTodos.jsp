<%@ include file="common/headers.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h2>Your Todos</h2>
	<table class="table mt-5">
		<thead class="text-primary">
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Status</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody class="text-light">
			<c:forEach items="${todos}" var="todo">
			    <!-- construct an "update" link with Todo id -->
			    <c:url var="updateLink" value="/update-todo">
			        <c:param name="id" value="${todo.id}" />
			    </c:url>

			    <!-- construct an "delete" link with Todo id -->
			    <c:url var="deleteLink" value="/delete-todo">
                    <c:param name="id" value="${todo.id}" />
                </c:url>
				<tr>
					<td>${todo.description }</td>
					<td>${todo.targetDate }</td>
					<td>${todo.status }</td>
					<td><a href="${updateLink}"
						class="btn btn-success">Update</a></td>
					<td><a href="${deleteLink}"
					       onclick="if (!(confirm('Are you sure!! This process is inevitable'))) return false"
						class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-success mt-3">Add Todo</a>
</div>
<%@ include file="common/footers.jspf"%>
