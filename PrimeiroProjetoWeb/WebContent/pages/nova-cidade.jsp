<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova cidade</title>
</head>
<body>

	<form action="/PrimeiroProjetoWeb/ChamadaJspCidades" method="post">
	
		Nome da Cidade: <input type="text" name="nome" />
		Codigo IBGE: <input type="text" name="ibge" />
		<input type="hidden" name="id"/>
		<input type="hidden" name="acao" value="novo"/>
		
		<input type="submit" value= "Cadastrar"/>
	</form>

</body>
</html>