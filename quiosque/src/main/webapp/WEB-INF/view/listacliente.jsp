<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Clientes </title>
</head>
<body>
	<h1> Lista de Jogadores </h1>
	<div>
		<table>
			<tr>
				<th> id</th>
				<th> Nome</th>
				<th>endereço</th>
				<th> Número</th>
				<th>Email</th>
				<th> Genero </th>
				<th> Data de Nascimento</th>
				<th>Produtos de Interesses</th>
				<th>Faixa Etaria</th>
				<th>Excluir</th>
			</tr>
			<c:forEach items="${cliente} " var = "c">
				<tr>
					<td>${c.id } </td>
					<td>${c.nome } </td>
					<td>${c.endereco } </td>
					<td>${c.numero } </td>
					<td>${c.email } </td>
					<td>${c.genero } </td>
					<td><fmt:formatDate value="${c.dataNascimento.time }" pattern="dd/MM/yyyy" /> </td>
					<td>${c.prodInt }</td>
					<td>${c.faixaEtaria }</td>
					<td><a href="excluirCliente?idCliente = ${c.id }" onclick = "return confirm('confirmar Exclusão de Cliente do Banco de dados '${c.id})">Excluir</a>
				
				</tr>
			</c:forEach>
		
		
		</table>
	</div>
</body>
</html>