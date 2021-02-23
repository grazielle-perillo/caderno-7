<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar cidade</title>
</head>
<body>

	<form action="/PrimeiroProjetoWeb/ChamadaJspCidades" method="post">
	
		IBGE: <input type="text" name="ibge" value="${cidade.cidadeIbge}" />
		Nome: <input type="text" name="nome" value="${cidade.cidade}" />
		<input type="hidden" name="id" value="${cidade.idCidade}">
		<input type="hidden" name="acao" value="alterar">
		<input type="submit" value= "Alterar"/>
	</form>
	
</body>
</html>