<%@page import="mavend6.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="mavend6.dto.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
	body{
	background-image: url("https://images.unsplash.com/photo-1532019333101-b0f43c16a912?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80");
	background-repeat: no-repeat;
	background-attachment: fixed;
  	background-size: cover;
  	font-weight: 400;
	}
	.modify{
	color:#333;
	font-weight:80;  
	}
</style>
<title>Landing Page</title>
</head>
<body>

	<br>
	<h5 style="font-family:serif; ">${message2}</h5>
	<br>
	<br>	

<div class="container" style="width: 50%">
<table class="table">
	<thead>
	<tr>
		<th>Email</th>
		<th>Password</th>
		<th>Phone</th>
		
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>${user.getEmail()}</td>
		<td>${user.getPassword()}</td>
		<td>${user.getPhoneno()}</td>
	</tr>
	</tbody>
</table>

<a style="font-weight: bold;color: #333;"  href="allData?key=${user.getEmail()}">View All Users</a>

<!-- Now the code for fetching arraylist  req.setAttribute("listofuser", listOfUser); always use ctr+space -->
<table class="table">
	<thead>
	<tr>
		<th>Email
		&nbsp;&nbsp;&nbsp;
		<a href="sortAsc?sort=asc&key=${param.key}"><img alt="icon" src="https://cdn-icons-png.flaticon.com/512/6499/6499790.png" style="height: 20px;width: 20px" 
		></a>
		&nbsp;
		<a href="sortDsc?sort=desc&key=${param.key}"><img alt="icon" src="https://cdn-icons-png.flaticon.com/512/6499/6499735.png" style="height: 20px;width: 20px"> 
		</a>
		</th>
		<th>Password</th>
		<th>Phone</th>
		<th>Action</th>
		<th>Edit entry</th>
	</tr>
	</thead>
	<tbody>
<%
List<UserDTO> listOfUsers=(List<UserDTO>)request.getAttribute("listofuser");
		if(listOfUsers!=null){
			for(UserDTO entry:listOfUsers){
				%>
		<tr>
			<td><%=entry.getEmail() %></td>
			<td><%=entry.getPassword()%></td>
			<td><%=entry.getPhoneno()%></td>
			<!--//if we want to pass key from prev file, use param.  -->
			<td><a class="modify" href="deleteRow?keydel=<%=entry.getEmail()%>&key=${param.key}">Delete</a></td>
		<td><a class="modify" href="editRow?key=${param.key}&keyedit=<%=entry.getEmail()%>">Edit</a> </td>
		</tr>
<%
			}
%>
</tbody>
<%
		}
		%>
</table>
</div>
</body>
</html>