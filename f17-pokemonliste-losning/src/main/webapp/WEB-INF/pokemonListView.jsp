<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="simple.css">
  </head>
  <body>
	<h4>Pokémon list</h4>
	<a href="sokeside.html">Perform a new search for a Pokémon</a><br>
	<a href="alleboker">See the list of all Pokémon</a><br>
	<table><tr>
			<th align="left">Name</th>
			<th align="left">Type</th>
			<th>Level</th>
		</tr>
		<!-- Fyll inn forEach-tag for å iterere gjennom listen av pokemoner -->
		<c:forEach var="p" items="${pokemonList}"><tr>
			<td align="left">${p.name}</td>
			<td align="left">${p.type}</td>
			<td>${p.level}</td>
		</tr></c:forEach>
	</table>
	
  </body>
</html>
