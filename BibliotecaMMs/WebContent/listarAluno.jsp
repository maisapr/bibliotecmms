<%@page import="models.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="daos.AlunoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de Alunos</h1>

	<table>
		<tr>
			<th>ID</th>
			<th>Matricula</th>
			<th>Cpf</th>
			<th>Email</th>
			<th>Endereço</th>
			<th>Data de Nascimento</th>
		</tr>

		<c:forEach var="aluno" items="${alunos}">

			<tr>
				<td>${aluno.id}</td>
				<td>${aluno.nome }</td>
				<td>${aluno.cpf }</td>
				<td>${aluno.endereco }</td>
				<td>${aluno.dataNascimento.time }</td>
				<td><a href="mvc?logica=RemoverContato&id=${contato.id}">Remover</a></td>
				<td><a href="mvc?logica=SelecionarContato&id=${contato.id}">Alterar</a></td>
			</tr>

		</c:forEach>

	</table>

</body>
</html>