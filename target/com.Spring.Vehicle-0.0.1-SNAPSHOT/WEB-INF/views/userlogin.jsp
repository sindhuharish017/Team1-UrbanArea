

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta charset="UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<title>User</title>

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

body {
	background-image:
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center center;
	background-size: cover;
	height: 100%;
	opacity: 0.8;
	padding: 5px;
	width: 100%;
}

.head {
	position: relative;
	top: 5%;
	width: 100%;
	text-align: top;
	font-size: 60px;
	color: rgb(255, 255, 255);
	font-weight: bolder;
	font-style: serif;
}

.topnav {
	background-color: #333;
	overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 12px 14px;
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

body {
	background-image:
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center center;
	background-size: cover;
	height: 100%;
	opacity: 0.8;
	padding: 5px;
	width: 100%;
}

.head {
	position: relative;
	top: 5%;
	width: 100%;
	text-align: top;
	font-size: 60px;
	color: rgb(255, 255, 255);
	font-weight: bolder;
	font-style: serif;
}

.btn {
	box-sizing: border-box;
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	background-color: transparent;
	border: 2px solid white;
	border-radius: 0.6em;
	color: white;
	cursor: pointer;
	display: flex;
	align-self: center;
	font-size: 1rem;
	font-weight: 400;
	line-height: 1;
	margin: 20px;
	padding: 1.2em 2.8em;
	text-decoration: none;
	text-align: center;
	text-transform: uppercase;
	font-family: "Montserrat", sans-serif;
	font-weight: 700;
}

.btn:hover, .btn:focus {
	color: #fff;
	outline: 0;
}

.btn {
	box-sizing: border-box;
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	background-color: rgb(255, 255, 255);
	border: 2px solid white;
	border-radius: 0.6em;
	color: rgb(0, 0, 0);
	cursor: pointer;
	display: flex;
	align-self: center;
	font-size: 1rem;
	font-weight: 400;
	line-height: 1;
	margin: 20px;
	padding: 1.2em 2.8em;
	text-decoration: none;
	text-align: center;
	text-transform: uppercase;
	font-family: "Montserrat", sans-serif;
	font-weight: 700;
}

.btn:hover, .btn:focus {
	color: rgb(14, 13, 13);
	outline: 0;
}

.third {
	border-color: 2px white;
	color: rgb(7, 7, 7);
	transition: all 150ms ease-in-out;
}

.third:hover {
	box-shadow: 0 0 10px 0 #3498db inset, 0 0 10px 4px #3498db;
}
</style>
</head>
<body>
	<form action="/GenerateOTP" method="post">
		<nav class="navbar fixed-top navbar-dark bg-dark">
		<div class="topnav">
			<a href="/home">Home</a> <a href="/about">About</a> <a href="/faq">FAQ</a>
			<a href="/aboutus">About Us</a>

		</div>
		</nav>

		<section class="vh-100 gradient-custom">

		<div class="container py-5 h-100">

			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5">
					<center>
						<h1 class="head">USER LOGIN</h1>
					</center>
					<div class="form-row">
						<input type="text" class="form-control form-control-lg"
							id="mobile" placeholder="Phone Number" name="mobNo"
							required="required" minlength="10" maxlength="10" value="${mob }"
							pattern="[6-9]{1}[0-9]{9}" />

					</div>



					<center style="color: white;">
						<b>${enter}</b>
					</center>
					<center style="color: red;">
						<b>${fail}</b>
					</center>

					<table>
						<tr>


							<td><input class="btn third" type="submit" name="submit"
								value="Get OTP" /></td>

						</tr>
					</table>
	</form>


</body>
</html>

















