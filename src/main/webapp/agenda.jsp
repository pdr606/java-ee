<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%
List<JavaBeans> list = (ArrayList<JavaBeans>) request.getAttribute("contacts");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="style.css" />
<title>Contact book</title>
</head>
<body>
	<h1>Contact book</h1>
	<a href="new.html" class="button1">New contact</a>
	<div class="container">
		<table id="table" >
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Phone</th>
					<th>E-mail</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<td><%=list.get(i).getIdcon()%></td>
					<td><%=list.get(i).getNome()%></td>
					<td><%=list.get(i).getFone()%></td>
					<td><%=list.get(i).getEmail()%></td>
				</tr>
				<%
				}
				%>

			</tbody>
		</table>
	</div>

</body>
</html>