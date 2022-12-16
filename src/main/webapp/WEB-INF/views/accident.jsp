<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome</title>
<style>
body {
	background-image: url("https://i.dailymail.co.uk/i/pix/2017/02/20/22/3D7581DA00000578-4243228-image-a-1_1487629465232.jpg"
		");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}

.head1 {
	border: none;
	color: rgb(9, 46, 170);
	padding: 15px 5px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 30px;
	margin: 4px 2px;
	cursor: pointer;
}

.head2 {
	border: none;
	color: rgb(9, 46, 170);
	padding: 15px 5px;
	text-align: center;
	text-decoration: none;
	/* display: inline-block; */
	font-size: 30px;
	margin: 4px 2px;
	cursor: pointer;
	width: 50%;
}

button {
	border-radius: 4px font-size: 10px;
	text-align: center;
	transition-duration: 0.4s;
	cursor: pointer;
}

button:hover {
	background-color: #e7502a;
	color: white;
}
</style>
</head>
<body>
	<form action="/allowAccess/${id}" method="Post">
		<class="container">
		<div class="button">
			<center>
				<button class="btn btn-outline-light btn-lg px-500" type="submit"
					name="submit" value="submit" style="color: rgb(51, 0, 255);">
					<h1 class="head1" style="border-color: blueviolet;">Accident</h1>
				</button>
			</center>
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<center>
			<h1 class="head2"
				style="color: rgb(255, 0, 255); border-style: groove; border-color: rgb(161, 148, 148); width: 250;">
				User Allowed To Drive</h1>
		</center>
	</form>



	<h2>User Information</h2>
	<table>
		<tr>
			<td>Name</td>
			<td>${name }</td>
		</tr>
		<tr>
			<td>Dlno</td>
			<td>${dlno }</td>
		</tr>
		<tr>
			<td>DOB</td>
			<td>${dob }</td>
		</tr>
		<tr>
			<td>Address</td>
			<td>${address }</td>
		</tr>
		<tr>
			<td>PhoneNumber</td>
			<td>${phno }</td>
		</tr>
	</table>







</body>
</html>