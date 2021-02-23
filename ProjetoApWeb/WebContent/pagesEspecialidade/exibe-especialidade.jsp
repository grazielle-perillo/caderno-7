<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Tabela Especialidades</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-light bg-light">
 			 <div class="container-fluid">
 			 	<a class="navbar-brand">Admin. Tabela Especilidades Médicas</a>
 			 	<form class="d-flex">
 			 		<a href="/ProjetoApWeb/ChamadaEspecialidadeMed?acao=novo" class="btn btn-outline-secondary" role="button" data-bs-toggle="button">Inserir Especialidade</a>
 			 	</form>
 	 		</div>
		</nav>
	</header>
        
    <section class="container-fluid">
        <div class="table-responsive">
          <table class="table table-striped">
            <thead>
            	<tr class="topo">
            		<th colspan="1">ID</th>
            		<th colspan="11">ESPECIALIDADE MÉDICA</th>
            	</tr>
            </thead>
            <tbody>
				<c:forEach items="${especialidades}" var="esp">
				<tr>
					<td>${esp.idEspecialidade}</td>
					<td>${esp.dsEspecialidade}</td>
					<td><a href="/ProjetoApWeb/ChamadaEspecialidadeMed?acao=editar&id=${ esp.idEspecialidade }" class="btn btn-outline-secondary" role="button" data-bs-toggle="button">editar</a></td>
					<td><a href="/ProjetoApWeb/ChamadaEspecialidadeMed?acao=remover&id=${ esp.idEspecialidade }" class="btn btn-outline-secondary" role="button" data-bs-toggle="button">remover</a></td>
				</tr>
				</c:forEach>
			</tbody>
		  </table>
        </div>
    </section>
    
    <footer class="mt-4">
      <nav class="navbar navbar-light bg-light">
      </nav>
  	</footer>
    
</body>
</html>