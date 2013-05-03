<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	<link rel="stylesheet/less" type="text/css" href="style.less">
	<script src="less.js" type="text/javascript"></script>
</head>
<body>

	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />

</body>
</html>