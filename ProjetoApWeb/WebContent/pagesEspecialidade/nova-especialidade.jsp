<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Nova especialidade</title>
</head>
<body>

	<form action="/ProjetoApWeb/ChamadaEspecialidadeMed" method="post">
	
		Nome da Especialidade: <input type="text" name="nome" />
		<input type="hidden" name="id"/>
		<input type="hidden" name="acao" value="novo"/>
		
		<input type="submit" value= "Cadastrar"/>
	</form>

</body>
</html>