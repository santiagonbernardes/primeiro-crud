<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
	<c:import url="cabecalho.jsp" />
	<form action="crud" name="acao" method="post">
		<c:choose>
			<c:when test="${not empty cliente.id}">
			ID: <input type="text" name="id" value="${cliente.id}"
					readonly="readonly" />
				<br />
			</c:when>
			<c:when test="${not empty id}">
			ID: <input type="text" name="id" value="${id}" readonly="readonly" />
				<br />
			</c:when>
		</c:choose>
		Nome: <input type="text" name="nome"
			value="${empty cliente.nome ? nome : cliente.nome}" /> ${erroNome} <br />
		E-mail: <input type="text" name="email"
			value="${empty cliente.email ? email : cliente.email}" />
		${erroEmail} <br /> Data de Nascimento: <input
			type="text" name="dataNascimento"
			value="${empty cliente.dataFormatada ? dataNascimento : cliente.dataFormatada}" />
		${erroDataNascimento} <br /> <input type="hidden" name="acao"
			value="ManipulaClienteController" /> <input type="submit"
			value="${empty cliente.id && empty id ? " Cadastrar" : "Atualizar" }"/>
	</form>
	<br />
	<br />
	<a href="/crud?acao=ListaContatosController">Adicionar novo contato</a><br/>
	<c:choose>
		<c:when test="${empty clientes}">
				Não existem clientes cadastrados.
			</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>E-mail</th>
					<th>Data de Nascimento</th>
					<th>Ação</th>
				</tr>
				<c:forEach var="cliente" items="${clientes}">
					<tr>
						<td>${cliente.id}</td>
						<td>${cliente.nome}</td>
						<td>${cliente.email}</td>
						<td>${cliente.dataFormatada}</td>
						<td><a
							href="/crud/crud?acao=RemoveClienteController&id=${cliente.id}">Remover</a>
							<a href="/crud/crud?acao=FormClienteController&id=${cliente.id}">Alterar</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>


</body>
</html>