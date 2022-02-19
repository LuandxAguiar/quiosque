<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="cad.css" />
<title>Cadastro de jogador</title>
</head>
<body>
	<h1>Cadastro de Jogador</h1>


	<form action="salvar" method="post">
		<table>
			<tr>
				<td><label>Nome do jogador:</label></td>
				<td><input type="text" name="nome" value="${jogador.nome }"></td>

			</tr>
			<tr>
				<td><label>Peso:</label></td>
				<td><input type="text" name="peso" value="${jogador.peso }"></td>
			</tr>
			<tr>
				<td><label>Altura:</label></td>
				<td><input type="text" name="altura" value="${jogador.altura }"></td>
			</tr>
			<tr>
				<td><label>Numero da camisa:</label></td>
				<td><input type="number" name="numCamisa"
					value="${jogador.numCamisa }"></td>
			</tr>
			<tr>
				<td><label>Nascimento:</label></td>
				<td><input type="date" name="dataNascimento"></td>
			</tr>
			<tr>
				<td><label>Posição:</label></td>
				<td><input type="text" name="posicao"
					value="${jogador.posicao }"></td>
			</tr>
			<tr>
				<td><label>Títular:</label></td>
				<td><input type="checkbox" name="titular"></td>
			</tr>
			<tr>
				<td><label>Tamanho do uniforme:</label></td>
				<td><select name="tamanhoUniforme">
						<c:forEach items="${tamanhos }" var="t">
							<option value="${t }">${t.toString() }</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>
				<td><button type="submit">Salvar</button></td>
			</tr>

		</table>
	</form>
</body>
</html>