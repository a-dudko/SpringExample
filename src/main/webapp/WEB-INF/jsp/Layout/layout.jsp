<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
		<link rel="stylesheet" href="<c:url value="/resources/style.less"/>" />
		<script src="<c:url value="/resources/less.js"/>" type="text/javascript"></script>
		<tiles:insertAttribute name="header" />
	</head>
	
	<body>
		<tiles:insertAttribute name="body" />
		<footer>
            <tiles:insertAttribute name="footer" />
        </footer>
	</body>
	
	
</html>