<%@ include file="common/headers.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h2>Enter Todo Details</h2>
	<form:form method="post" modelAttribute="todo">
	    <!-- important for update -->
	    <form:input type="hidden" path="id" />

		<fieldset class="mb-3 mt-3">
			<form:label path="description">Description: </form:label>
			<form:input type="text" path="description" cssClass="transparent-input" />
			<form:errors path="description" cssClass="text-warning" />
		</fieldset>
		<fieldset class="mb-3">
			<form:label path="targetDate">Target Date: </form:label>
			<form:input type="text" path="targetDate" cssClass="transparent-input" />
		</fieldset>

		<fieldset class="mb-3">
            <form:label path="status">Status: </form:label>
            <form:select path="status" id="status" cssClass="transparent-input">
                <form:option value="Pending" label="Pending" />
                <form:option value="In Progress" label="In Progress" />
                <form:option value="Completed" label="Completed" />
            </form:select>
        </fieldset>
		<input type="submit" class="btn btn-success mt-3" value="Submit">
	</form:form>

</div>
<%@ include file="common/footers.jspf"%>
<style>
	.transparent-input {
		background-color: #555;
		opacity: 0.5;
		border: 1px solid #ccc;
		color: #fff;
	}

</style>
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd',
        startDate: new Date(),
        autoclose: true
    });
</script>
