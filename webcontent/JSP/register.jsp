<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
	<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<link rel="stylesheet" type="text/css" href="../css/Background.css"></link>
			<link rel="stylesheet" type="text/css" href="../css/FrontPage.css"></link>
			<link rel="stylesheet" type="text/css" href="../css/register.css"></link>
			<link rel="stylesheet" type="text/css" href="../css/buttons.css"></link>
		</head>
		<body>
					<jsp:include page="Background.jsp" />

		<div class = "moveToCenter">	
		<h3 class = "separate">Please Register:</h3>
		
			<form action="register" method="post">
			<div>
				<h4 class = "separate">Username:</h4> <input class = "move, styleImput" type="text" placeholder="enter username" name="user" required="required"> 
			</div>
			<div>
				<h4 class = "separate">Password:</h4> <input class = "move, styleImput" type="password" placeholder="enter pass" name="password1" required="required">
			</div>
			<div>
				<h4 class = "separate">Confirm Password:</h4> <input class = "move, styleImput" type="password" placeholder="enter pass" name="password2" required="required">
			</div>
			<div>
				<h4 class = "separate">E-mail:</h4> <input class = "move, styleImput" type="email" placeholder="enter email" name="email" required="required">
			</div>
			<div>
				<h4 class = "separate">Name:</h4> <input class = "move, styleImput" type="text" placeholder="enter name" name="name"> 
			</div>
			<div>
				<h4 class = "separate">Interests:</h4> <input class = "move, styleImput" type="text" placeholder="interests" name="interest"> 
			</div>
			<div>
				<h4 class = "separate">Gender:</h4> 
				<select class = "move, styleImput" name="gender"> 
					<option value="F">F</option>
					<option value="M">M</option>
				</select>
			</div>
			<div>
				<h4 class = "separate">Country:</h4> <input class = "move, styleImput" type="text" placeholder="country" name="	country"> 
			</div>
			<div>
				<h4 class = "separate">Birth Date :</h4> 
				<select name="day">
			<option value="01">1</option>
			<option value="02">2</option>
			<option value="03">3</option>
			<option value="04">4</option>
			<option value="05">5</option>
			<option value="06">6</option>
			<option value="07">7</option>
			<option value="08">8</option>
			<option value="09">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
			<option value="13">13</option>
			<option value="14">14</option>
			<option value="15">15</option>
			<option value="16">16</option>
			<option value="17">17</option>
			<option value="18">18</option>
			<option value="19">19</option>
			<option value="20">20</option>
			<option value="21">21</option>
			<option value="22">22</option>
			<option value="23">23</option>
			<option value="24">24</option>
			<option value="25">25</option>
			<option value="26">26</option>
			<option value="27">27</option>
			<option value="28">28</option>
			<option value="29">29</option>
			<option value="30">30</option>
			<option value="31">31</option>
		</select> <select name="month">
			<option value="01">January</option>
			<option value="02">February</option>
			<option value="03">March</option>
			<option value="04">April</option>
			<option value="05">May</option>
			<option value="06">June</option>
			<option value="07">July</option>
			<option value="08">August</option>
			<option value="09">September</option>
			<option value="10">October</option>
			<option value="11">November</option>
			<option value="12">December</option>
		</select> <select name="year">
			<option value="1994">1994</option>
			<option value="1999">1999</option>
			<option value="2000">2000</option>
			<option value="2010">2010</option>
		</select>
			</div>		
			<div>
				<input class = "styleSubmit" type="submit" value="Submit" method="post" action="../Login"></br>
			</div>
			</form>	
		</div>
</body>
</html>