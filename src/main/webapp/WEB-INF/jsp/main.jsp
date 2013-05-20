<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <div id = "events">
        <c:forEach items="${events}" var="event">
            <c:url value="/event" var="url">
                <c:param name="id" value="${event.id}"/>
            </c:url>
            <a href='<c:out value="${url}" />'>${event.name}</a>            
        </c:forEach>
    </div>
    
	<div id="pagination">
	    <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
	        <c:choose>
	            <c:when test="${page == i.index}">
	                <span>${i.index}</span>
	            </c:when>
	            <c:otherwise>
	                <c:url value="/main" var="url">
	                    <c:param name="page" value="${i.index}"/>
	                    <c:param name="user" value="${user}"/>
	                </c:url>
	                <a href='<c:out value="${url}" />'>${i.index}</a>
	            </c:otherwise>
	        </c:choose>
	    </c:forEach>
	    <c:url value="/main" var="next">
	        <c:param name="page" value="${page + 1}"/>
	        <c:param name="user" value="${user}"/>
	    </c:url>
	    <c:if test="${page + 1 < maxPages}">
	        <a href='<c:out value="${next}" />' class="pn next">Next</a>
	    </c:if>
	</div>
	<a href='<c:out value="main/create" />'>Create Event</a>
</html>