<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
    <script src="<c:url value="/resources/login.js"/>"></script>
</head>


<div id = "home">
    <h2>Home page</h2>
    <div class="container">
        <div id="login">
        <form name = "logging" onSubmit="formValidation(this); return false;" method="post" action="${pageContext.servletContext.contextPath}/login">
            <fieldset>
                <input type="text" name="userName" placeholder="username"/>
                <input type="password" name="userPassword" placeholder="password"/>
                <input type="submit" value="Login"/>
            </fieldset>
        </form>
        </div>
        <a href = "<c:url value="registration"/>">Registration</a>
    </div>
</div>
