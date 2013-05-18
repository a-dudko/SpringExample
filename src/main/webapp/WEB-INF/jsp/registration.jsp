<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Sample registration
	form</title>
<meta name="keywords"
	content="example, JavaScript Form Validation, Sample registration form" />
<meta name="description"
	content="This document is an example of JavaScript Form Validation using a sample registration form. " />
<link rel='stylesheet' href='<c:url value="/resources/registration-form.css"/>' type='text/css' />
<script src="<c:url value="/resources/registration-form-validation.js"/>"></script>
</head>
<body onload="document.registration.userLogin.focus();">
	<h1>Registration Form</h1>
	<p>Use tab keys to move from one input field to the next.</p>
	<form name='registration' onSubmit="${pageContext.servletContext.contextPath}/registration/success" method = "POST">
		<ul>
			<li><label for="userLogin">User Login:</label></li>
			<li><input type="text" name="userLogin" size="12" /></li>
			<li><label for="passid">Password:</label></li>
			<li><input type="password" name="passid" size="12" /></li>
			<li><label for="reppassid">Repeat password:</label></li>
            <li><input type="password" name="reppassid" size="12" /></li>
			<li><label for="username">Full Name:</label></li>
			<li><input type="text" name="username" size="50" /></li>
			<li><label for="age">Age:</label></li>
			<li><input type="text" name="age" size="50" /></li>
			<li><label for="email">Email:</label></li>
			<li><input type="text" name="email" size="50" /></li>
			<li><label id="gender">Sex:</label></li>
			<li><input type="radio" name="sex" value="Male" /><span>Male</span></li>
			<li><input type="radio" name="sex" value="Female" /><span>Female</span></li>
			<li><label>Preferences:</label></li>
			<li><input type="checkbox" name="boys" value="boys"   /><span>Boys</span></li>
			<li><input type="checkbox" name="girls" value="girls" /><span>Girls</span></li>
			<li><input type="checkbox" name="animals" value="animals" /><span>Animals</span></li>
			<li><input type="checkbox" name="mermaids" value="mermaids" /><span>Mermaids</span></li>
			<li><label for="desc">About:</label></li>
			<li><textarea name="desc" id="desc"></textarea></li>
			<li><input type="submit" name="submit" value="Submit" /></li>
		</ul>
	</form>
</body>
</html>