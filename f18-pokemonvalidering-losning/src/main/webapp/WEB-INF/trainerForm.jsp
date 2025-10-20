<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="simple.css">
<title>Trainer form</title>
</head>

<body>
	<h3>Hi. Enter information about the trainer.</h3>
	
	<c:forEach var="errorMessage" items="${errorMessages}">
		<p style="color:red">${errorMessage}</p>
	</c:forEach>
		
	<form action="checktrainer" method="get" id="trainer">
		Name <input type="text" name="name" value="${param.name}"><br>
		Phone <input type="text" name="phone" value="${trainer.phone}"><br>
		Height in cm <input type="number" name="heightcm"><br>
		Birth date <input type="date" name="bdate"><br>
		<input type="submit" value="Send!"/>
	</form>
	
</body>
</html>