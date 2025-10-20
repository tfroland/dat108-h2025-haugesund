<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="simple.css">
	<title>Receipt</title>
  </head>
  <body>
	<%-- ${pokemon} i linjen under er et uttrykk som henter attributten 
	pokemon fra modellen (den vi la til med model.addAttribute()) -- %>
	${pokemon.name} ${pokemon.type} has been registered.
  </body>
</html>
