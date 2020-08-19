<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Issue Details</title>
</head>
<body>
	<h3>Book Issue Details</h3>
	<hr>
	<br>

	<table border="1">
		<tr>
			<th>Issue Serial Number</th>
			<th>Member Code</th>
			<th>Member Name</th>
			<th>Book Code</th>
			<th>Book Name</th>
			<th>Date Of Issue</th>
			<th>Date Of Return</th>
		</tr>
		<logic:iterate name="bookIssueDetails" id="issueDetails">
			<tr>
				<td><bean:write name="issueDetails" property="issueCode" /></td>
				<td><bean:write name="issueDetails"
						property="member.memberCode" /></td>
				<td><bean:write name="issueDetails"
						property="member.memberName" /></td>
				<td><bean:write name="issueDetails" property="book.bookCode" /></td>
				<td><bean:write name="issueDetails" property="book.title" /></td>
				<td><bean:write name="issueDetails" property="issueDate" /></td>
				<td><bean:write name="issueDetails" property="returnDate" /></td>
			</tr>
		</logic:iterate>
	</table>

	<br>
	<br>
	<a href="addBookDetails.jsp">Issue New Book</a> &nbsp;
	<a href="update.jsp">Update Book</a> &nbsp;
	<a href="delete.jsp">Delete Book</a> &nbsp;
</body>
</html>