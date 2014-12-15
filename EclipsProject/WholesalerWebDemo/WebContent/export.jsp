<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.File"%>
<%@ page import="com.google.common.io.Files" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>eBusiness Framework Demo - Product List</title>
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<link rel="stylesheet" type="text/css" href="default.css">
</head>

<body>

	<%@ include file="header.jsp"%>
	<%@ include file="error.jsp"%>
	<%@ include file="authentication.jsp"%>
	<%@ include file="navigation.jspfragment"%>
	
	<!-- Form to choose if xml (bmecat) or xtml should be exported -->
	
	<form id="download-form" name="catalogDownloadForm" method="post" action="<%=response.encodeURL("controllerservlet") + "?action=" + Constants.ACTION_DOWNLOAD_CATALOG%>">
		<span class="label">Filter products by short description: (optional)</span> <input type="text" name="<%=Constants.PARAM_SEARCH_STRING%>"/> <br> 
		
			<select	name="<%=Constants.PARAM_FILE_TYPE%>">
			<optgroup id="opt" label="select file type">
				<option value="bmecat"><%=Constants.PARAM_FILE_TYPE_VALUE_XML%></option>
				<option value="xhtml"><%=Constants.PARAM_FILE_TYPE_VALUE_XHTML%></option>
			</optgroup>
		</select>
		
		 <br> 
		 
		 <input type="submit" value="Send"/>
	</form>
	
	<!-- Download File via OutputStream -->

	<%
		File exportFile = (File) session.getAttribute("exportfile");
		if(exportFile != null){

			session.setAttribute("exportfile", null);
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition",
					"attachment;filename='"+ exportFile.getName() +"'");
			ServletOutputStream outputStream = response.getOutputStream();

			Files.copy(exportFile, outputStream);
			outputStream.flush();
			outputStream.close();
		} else{

		}
	%>
</body>
</html>
