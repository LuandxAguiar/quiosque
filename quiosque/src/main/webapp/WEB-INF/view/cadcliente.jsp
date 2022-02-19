<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Cliente</title>
</head>
<body>
	<h1> Cadastro de Clientes</h1>
	
	<form action = "salvarObj" method = "post">
	<table>
		<tr>
			<td> <label>Nome do Cliente:</label></td>
			<td><input type ="text" name="nome" value = "${cliente.nome }" > </td>
		
		</tr>
		<tr>
			<td> <label>Endereço</label></td>
			<td><input type ="text" name="endereco" value = "${cliente.endereco }"> </td>
		
		</tr>
		
		<tr>
			<td> <label>Número</label></td>
			<td><input type ="number" name="numero" value = "${cliente.numero }" > </td>
		
		</tr>
		<tr>
			<td> <label>E-mail</label></td>
			<td><input type ="email" name="email" value = "${cliente.email }" > </td>
		
		</tr>	
		<tr>
			<td> <label>Genero</label></td>
			<td><label>Masculino</label><input type = "radio" class="checkbox" name="genero" value="masculino" required> </td>
			<td><label>Feminino</label><input type = "radio" class="checkbox" name="genero" value="feminino" required> </td>
			<td><label>Não Opinar</label><input type = "radio" class="checkbox" name="genero" value="nOpina" required> </td>
		</tr>
		<tr>
		<td><label>Nascimento:</label></td>
		<td><input type="date" name="dataNascimento" ></td>
		</tr>
			<tr>
			<td> <label>Produtos de Intereses</label></td>
			<td><input type ="text" name="prodInt" value ="${cliente.prodInt }" > </td>
			
			<td><label>Faixa Etaria:</label></td>
				<td><select name="faixaEtaria">
						<c:forEach items="${faixa }" var="f">
							<option value="${f }">${f.toString() }</option>
						</c:forEach>
		</tr>	
		<td><button type="submit">Salvar</button></td>
	</table>
	</form>

</body>
</html>