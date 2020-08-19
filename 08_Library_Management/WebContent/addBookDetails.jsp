<%@page import="java.util.Date"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issue New Book</title>
</head>
<body>

<h3>Issue New Book</h3>
	<hr>
	<html:form action="newBookIssue" method="post">
		<table style="border-collapse: collapse;">
			<tr>
				<td><bean:message key="label.name.serialNo" /></td>
				<td><html:text property="issueCode"  /></td>
			</tr>
			<tr>
		      <td><bean:message key="label.name.memberCode" /></td>
				<td><html:text property="memberCode" /></td>
				<td><html:submit property="member"  value="getMember">Get Member Details</html:submit></td>

			</tr>
			<tr>
				<td><bean:message key="label.name.name" /></td>
				<td><html:text property="memberName" /></td>
			</tr>

			<tr>
				<td><bean:message key="label.name.bookCode" /></td>
				<td><html:text property="bookCode"  /></td>
				<td><html:submit property="book"  value="getBook">Get Book Details</html:submit></td>
			</tr>
			<tr>
				<td><bean:message key="label.name.title" /></td>
				<td><html:text property="title" /></td>
			</tr>
			<tr>
				<td><bean:message key="label.name.author" /></td>
				<td><html:text property="author" /></td>
			</tr>
			<tr>
				<td><bean:message key="label.name.issueDate" /></td>
				<td><html:text property="issueDate" /></td>
			</tr>
			<tr>
				<td><bean:message key="label.name.duedate" /></td>
				<td><html:text property="returnDate" /></td>
			</tr>
				<tr>
				<td></td>
				<td><html:submit property="issue" value="issueBook">Issue Book</html:submit></td>
				<td></td>
			</tr>
		</table>
		</html:form>

</body>
</html>