<%@ include file="common/headers.jsp"%>
<h3>Hello this message is to Confirm that the student with ${student.firstName} ${student.lastName} is registered successfully</h3>
<p> ${student.firstName} is ${student.age} years old from ${student.branch} branch </p>
<p> Favorite Language is ${student.favoriteLanguage} </p>
Languages Known :
<ul>
    <c:forEach items="${student.languagesKnown}" var="language">
        <li>${language}</li>
    </c:forEach>
</ul>
<%@ include file="common/footers.jsp"%>

