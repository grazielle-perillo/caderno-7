<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Bem vindo 
	<br>
	<c:forEach items="${cursos}" var="curso">
		${curso.nome} ${curso.cargaHoraria} <br>
	</c:forEach>

</body>
</html>