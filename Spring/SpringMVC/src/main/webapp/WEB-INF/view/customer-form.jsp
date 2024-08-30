<%@ include file="common/headers.jsp"%>
<div class="container">
    <h1>Customer Form</h1>
    <hr>
    <i>Fill out the Form. Asterisk (*) is mandatory.</i>

    <form:form modelAttribute="customer" action="processForm" method="POST">
        <fieldset class="mb-3">
            <form:label path="firstName">First Name (*):</form:label>
            <form:input type="text" path="firstName"/>
            <!-- Display validation errors -->
            <form:errors path="firstName" cssClass="text-danger" />
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="lastName">Last Name:</form:label>
            <form:input type="text" path="lastName" />
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="age">Age (*):</form:label>
            <form:input path="age" />
            <form:errors path="age" cssClass="text-danger" />
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="email">Email (*):</form:label>
            <form:input path="email" />
            <form:errors path="email" cssClass="text-danger" />
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="phoneNumber">Phone Number (*):</form:label>
            <form:input path="phoneNumber" />
            <form:errors path="phoneNumber" cssClass="text-danger" />
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="couponCode">Coupon Code (*):</form:label>
            <form:input path="couponCode" />
            <form:errors path="couponCode" cssClass="text-danger" />
        </fieldset>

        <input type="submit" class="btn btn-success" value="Submit">
    </form:form>
</div>
<%@ include file="common/footers.jsp"%>

