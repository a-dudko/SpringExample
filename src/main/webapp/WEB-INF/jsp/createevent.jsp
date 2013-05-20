<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Sample registration
	    form</title>
	<link rel='stylesheet' href='<c:url value="/resources/registration-form.css"/>' type='text/css' />
	<script src="<c:url value="/resources/registration-form-validation.js"/>"></script>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&language=ru"></script>
	<script type="text/javascript" src="/resources/map.js"></script>
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
        <div class="wrapper">
	        <div class="map" id="Map">
	        </div>
	        <div class="info" id="Info">
	            <div class="input_city">
	                <div class="title">
	                    Введите город:</div>
	                <div class="control">
	                    <input id="address" class="address" name="address" type="text" value="" />
	                    <input id="submit" class="submit" name="submit" type="button" value="Ok" />
	                </div>
	            </div>
	            <div class="info-put-marker">
	                Переместите маркер
	            </div>
	            <div class="address_list">
	            </div>
	
	        </div>
    	</div>
    </form>
</body>
</html>