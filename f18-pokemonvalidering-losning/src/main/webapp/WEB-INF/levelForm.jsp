<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="simple.css">
<title>Valid level</title>
</head>
<body>
	<p style="color:red">${errorMessage}</p>
	<form action="checkLevel" method="get">
		Level: <input type="text" name="level"> 
		<input type="submit" value="Send!">
	</form>
</body>
</html>