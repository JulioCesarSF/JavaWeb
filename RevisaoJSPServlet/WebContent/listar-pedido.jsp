<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="includeTaglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Pedido</title>
<%@ include file="includeHead.jsp"%>
</head>
<body>

	<%@ include file="navbar.jsp"%>

	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h2>Lista de Pedido</h2>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<c:if test="${not empty tipoMensagem }">
					<div class="${tipoMensagem }">
						<p>${mensagem }</p>
					</div>
				</c:if>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">

				<table class="table">
					<thead>
						<tr>
							<th>Código</th>
							<th>Quarto</th>
							<th>Descrição</th>
							<th>Valor</th>
							<th>Data Pedido</th>
							<th style="text-align: center;">Ação</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="item" items="${lista }">
							<tr>
								<td>${item.id }</td>
								<td>${item.quarto }</td>
								<td>${item.descricao }</td>
								<td>${item.valor }</td>
								<td>${item.dataPedido }</td>
								<td style="text-align: center;"><c:url var="alterar"
										value="pedido">
										<c:param name="acao" value="alterar"></c:param>
										<c:param name="id" value="${item.id }"></c:param>
									</c:url> <a href=${alterar } " class="btn btn-primary btn-sm">Alterar</a>
									<a href="excluir-pedido.jsp" class="btn btn-danger btn-sm">Excluir</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>

	</div>

</body>
</html>