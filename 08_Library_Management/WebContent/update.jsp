<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book Details</title>
</head>
<body>
	<h3>Update Book Details</h3>
	<hr>
	<html:form action="updateBook" method="post">
		
		<hr>
			<bean:message key="label.name.serialNo" />
			<html:text property="issueCode"/>
		<br>
		<br>
		<html:submit>GET BOOK DETAILS</html:submit>
	

	</html:form>
</body>
</html>