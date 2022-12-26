<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DL List</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">


<style>
.topnav {
	background-color: #333;
	overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
	margin-top: 0%;
}

/* Change the color of links on hover */
.topnav a:hover {
	background-color: #ddd;
	color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
	background-color: #0d0e0d;
	color: white;
}

.head {
	font-weight: bolder;
	font-style: oblique;
	color: rgb(255, 255, 255);;
}

body {
	background-image:
		url("data:image/jpeg;base64,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");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
	background-size: cover;
}

.table {
	font-weight: bolder;
	font-style: normal;
}

.third {
	border-color: 2px white;
	color: rgb(7, 7, 7);
	transition: all 150ms ease-in-out;
}

.third:hover {
	box-shadow: 0 0 10px 0 #3498db inset, 0 0 10px 4px #3498db;
}

.btn {
	box-sizing: border-box;
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	background-color: black;
	border: 2px solid white;
	border-radius: 0.6em;
	color: rgb(255, 250, 250);
	cursor: pointer;
	display: flex;
	align-self: center;
	font-size: 1rem;
	font-weight: 400;
	line-height: 1;
	margin: -7px;
	padding: 1em 1em;
	text-decoration: none;
	text-align: center;
	font-family: "Montserrat", sans-serif;
	font-weight: 700;
}

.btn:hover, .btn:focus {
	color: rgb(0, 0, 0);
	outline: 0;
}
</style>


</head>
<body class="w-100">
	<div class="topnav">
		<a href="/home">Home</a> <a href="/createdl">Create</a>
		<!--  <a href="/home">Logout</a> -->
	</div>
	<center>
		<h2 class="head">List Of DL</h2>
	</center>
	<br>
	<table class="table table-success table-striped table-light"
		align="center">
		<thead class="thead-dark">
			<tr>
				<div class="table">
					<td>ID</td>
					<td>DLNo</td>
					<td>NAME</td>
					<td>DateofBirth</td>
					<td>Address</td>
					<td>FromDate</td>
					<td>ToDate</td>

					<!-- <td>MobNo</td> -->
					<td>vehicleType</td>
					<td>Update</td>
				</div>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dl}" var="dl">
				<tr>
					<td>${dl.id}</td>
					<td>${dl.dlno }</td>
					<td>${dl.name }</td>
					<td>${dl.dateofBirth }</td>
					<td>${dl.address }</td>
					<td>${dl.fromDate }</td>
					<td>${dl.toDate }</td>

				<%-- 	<td>${dl.mobNo}</td>
 --%>
					<td><c:forEach var="v" items="${dl.vehicle}">  
						${v} </c:forEach></td>

					<%-- <td><a href="/updatedl/${dl.id }"><button type="submit" name="update" value="Update">UPDATE</button></a></td> --%>
					<td><a href="/updatedl/${dl.id }"><button
								class="btn third" type="submit" name="update" value="Update">Update</button></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>







