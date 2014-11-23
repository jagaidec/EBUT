<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
	<title>eBusiness Framework Demo - Import</title>
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="pragma" content="no-cache">
	<link rel="stylesheet" type="text/css" href="default.css">
</head>
<body>

	<%@ include file="header.jsp"%>
	<%@ include file="error.jsp"%>
	<%@ include file="authentication.jsp"%>
	<%@ include file="navigation.jspfragment"%>

	<h1>Import your file</h1>
	
	<!-- file upload with Apache Commons FileUpload -->
	
	<div>
		<form action="<%=response.encodeURL("controllerservlet")%>" method="Post" name="action">
			<input type="file" name="userXML" accept="xml" ><br>
			<input type="submit" value="UPLOAD">
		</form>
	</div>
</body>
</html>
