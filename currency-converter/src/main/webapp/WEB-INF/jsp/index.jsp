<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>Calculate BMI</title>
	</head>

<body>
<form name="bmiForm" action="TestServlet" method="POST">

	<table>
		<tr>
			<td>Your Weight (kg) :</td>
			<td><input type="text" name="weight"/></td>
		</tr>
		<tr>
			<td>Your Height (m) :</td>
			<td><input type="text" name="height"/></td>
		</tr>
		<td><input type="submit" value="submit" name="find"/></td>
		<td><input type="reset" value="reset" name="reset"/></td>
	</table>
	<h2>${bmi}</h2>
</form>
</body>
</html>