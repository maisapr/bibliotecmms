
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="estilos/estilo1.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Livros</title>
</head>
<body>
<h1>Listar Livros</h1>

	<table>
			<tr>
			<th>Titulo</th>
			<th>Autor</th>
			<th>Editora</th>
			<th>Edicao</th>
			<th>Data de Publicacao</th>
			</tr>
		
		<c:forEach var="livro" items="${livros}">

			<tr>
				<td>${livro.id}</td>
				<td>${livro.titulo}</td>
				<td>${livro.autor}</td>
				<td>${livro.editora}</td>
				<td>${livro.edicao}</td>
				<td>${livro.dataPublicacao}</td>
			</tr>

		</c:forEach>

	</table>



</body>
</html>