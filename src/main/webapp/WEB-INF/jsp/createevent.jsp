<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Sample registration
    form</title>
<link rel='stylesheet' href='<c:url value="/resources/registration-form.css"/>' type='text/css' />
<script src="<c:url value="/resources/registration-form-validation.js"/>"></script>
</head>
<body onload="document.new_event.eventTitle.focus();">
    <h1>Creating new event form</h1>
    <p>Use tab keys to move from one input field to the next.</p>
    <form name='new_event' onSubmit="formValidation(this); return false;" 
    action = "${pageContext.servletContext.contextPath}/main/newevent" method = "POST">
        <ul>
            <li><label for="eventTitle">Event Title:</label></li>
            <li><input type="text" name="eventTitle" size="12" /></li>
            <li><label for="description">Description of the event:</label></li>
            <li><textarea name="description" id="description"></textarea></li>
            <li><label for="dateandtime">Date and time:</label></li>
            <li><input type="datetime-local" name="dateandtime" size="12" /></li>
            <li><input type="submit" name="submit" value="Submit" /></li>
        </ul>
    </form>
</body>
</html>