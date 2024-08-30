<%@ include file="common/headers.jsp"%>
<div class="container">
    <h1>Student Registration Form</h1>
    <hr>
    <form:form modelAttribute="student" action="processForm">
        <fieldset class="mb-3">
            <form:label path="firstName">First Name</form:label>
            <form:input type="text" path="firstName" required="required" />
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="lastName">Last Name</form:label>
            <form:input type="text" path="lastName" required="required" />
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="age">Age</form:label>
            <form:input type="number" path="age" required="required" min="18"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="branch">Branch</form:label>
            <form:select path="branch">
                <form:options items="${student.branchOptions}" />
            </form:select>
        </fieldset>

        <fieldset class="mb-3">
            Favorite Programming Language:
            <br>
            <form:radiobutton path="favoriteLanguage" value="Java" /> Java
            <form:radiobutton path="favoriteLanguage" value="Cpp" /> Cpp
            <form:radiobutton path="favoriteLanguage" value="Python" /> Python
            <form:radiobutton path="favoriteLanguage" value="PHP" /> PHP
        </fieldset>

        <fieldset class="mb-3">
            Languages Known:
            <br>
            <form:checkbox path="languagesKnown" value="English" /> English
            <form:checkbox path="languagesKnown" value="Hindi" /> Hindi
            <form:checkbox path="languagesKnown" value="Telugu" /> Telugu
            <form:checkbox path="languagesKnown" value="Japanese" /> Japanese
        </fieldset>

        <input type="submit" class="btn btn-success" value="Submit">
    </form:form>
</div>
<%@ include file="common/footers.jsp"%>

