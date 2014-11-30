<%@page import="java.io.InputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.nio.file.Files"%>
<%@ page session="true"%>
<%@ page import="java.io.File"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>eBusiness Framework Demo - Download</title>
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<link rel="stylesheet" type="text/css" href="default.css">
<script type="text/javascript">
	var select = "";
	function disable() {
		document.getElementById("send").disabled = true;
	}

	function checkValue() {

		select = document.getElementById('select').value;
		if (select != "") {
			document.getElementById("send").disabled = false;
		} else {
			document.getElementById("send").disabled = true;
		}
	}
</script>
</head>
<body onload="disable()">
	<%@ include file="header.jsp"%>
	<%@ include file="error.jsp"%>
	<%@ include file="authentication.jsp"%>
	<%@ include file="navigation.jspfragment"%>



	<form id="download-form" name="catalogDownloadForm" method="post"
		action="<%=response.encodeURL("controllerservlet") + "?action="
					+ Constants.DOWNLOAD_CAT%>">
		<span class="label">Filter products by short description:
			(optional)</span> <input type="text" name="<%=Constants.SEARCH_STRING%>"
			placeholder="short description" /> <br /> <select
			name="<%=Constants.FILE_TYPE%>" id="select" placeholder="File type"
			onchange="checkValue()">
			<option value=""></option>
			<option value="bmecat"><%=Constants.FILE_TYPE_VALUE_XML%></option>
			<option value="xhtml"><%=Constants.FILE_TYPE_VALUE_XHTML%></option>
		</select> <br /> <input type="submit" id="send" value="Send" />
	</form>

	<%
		File exportFile = (File) session.getAttribute("exportfile");
		if (exportFile != null) {
			session.setAttribute("exportfile", null);
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition",
					"attachment;filename='" + exportFile.getName() + "'");
			//InputStream input = Files.newInputStreamSupplier(exportFile).getInput();
			OutputStream output = (OutputStream) response.getOutputStream();
			//Files.copy(exportFile, output);
			output.flush();
			output.close();
		}
	%>
</body>
</html>
