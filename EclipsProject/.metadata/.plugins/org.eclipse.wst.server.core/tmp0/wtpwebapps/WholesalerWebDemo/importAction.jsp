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

	<script>
		function validate() {
			
			if (document.getElementById('file').value !== '') {
				//document.getElementById('upload_form').submit();
				return true;
			} else {
				alert('No File Attached, please select you catalog xml file!');
				return false;
			}
		
		}
	</script>

	<%@ include file="header.jsp"%>
	<%@ include file="error.jsp"%>
	<%@ include file="authentication.jsp"%>
	<%@ include file="navigation.jspfragment"%>

	<h1>Import your file</h1>
	
	<!-- file upload with Apache Commons FileUpload -->
	
	<div>
		<form action="<%=response.encodeURL("controllerservlet") + "?action="+ Constants.IMPORT%>" method="Post" 
			name="upload_form" id="upload_form" onsubmit="return validate()" enctype="multipart/form-data">
		
			<input type="file" id="file" name="<%=Constants.PARAM_IMPORT_FILENAME%>"><br>
			<input type="submit" value="upload" id="subButton"/>
			
		</form>
	</div>
</body>
</html>
