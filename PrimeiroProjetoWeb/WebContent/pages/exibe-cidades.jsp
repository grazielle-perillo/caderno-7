<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Tabela Cidades</title>
</head>
<body>

	<td><a href="/PrimeiroProjetoWeb/ChamadaJspCidades?acao=novo">Nova Cidade</a></td>
	<table>
	<tr>
		<th>ID</th>
		<th>UF</th>
		<th>IBGE</th>
		<th>CIDADE</th>
	</tr>

		<c:forEach items="${cidades}" var="cidade">
			<tr>
				<td>${cidade.idCidade}</td>
				<td>${cidade.idUf}</td>
				<td>${cidade.cidadeIbge}</td>
				<td>${cidade.cidade}</td>
				<td><a href="/PrimeiroProjetoWeb/ChamadaJspCidades?acao=editar&id=${ cidade.idCidade }">editar</a></td>
				<td><a href="/PrimeiroProjetoWeb/ChamadaJspCidades?acao=remover&id=${ cidade.idCidade }">remover</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>