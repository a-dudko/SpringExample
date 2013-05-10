<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/app.css"/>" />
<script src="<c:url value="/resources/app.js"/>" type="text/javascript"></script>

<div id = "home">
    <h2>Home page</h2>
    <div class="container">
        <div id="login">
        <form method="post" action="/fpmi/login">
            <fieldset>
                <input type="text" name="user[name]" placeholder="username"/>
                <input type="password" name="user[password]" placeholder="password"/>
                <input type="submit" value="Login"/>
                <p id="loginInfo">username: luke / password: skywalker</p>
            </fieldset>
        </form>
        </div>
    </div>
</div>
