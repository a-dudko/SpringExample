<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/app.css"/>" />
<div class="container">
    <div id="loggedin">
    <p>HELLO <br/>luke</p>

    <form method="post" action="/fpmi">
        <input type="submit" value="Logout"/>
    </form>
</div>
</div>