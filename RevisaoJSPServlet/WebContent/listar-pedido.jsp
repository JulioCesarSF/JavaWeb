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
							<th>Status</th>
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
								<td>${item.dataPedidoString()}</td>
								<td>${item.status }</td>
								<td style="text-align: center;"><c:url var="alterar"
										value="pedido">
										<c:param name="acao" value="alterar"></c:param>
										<c:param name="id" value="${item.id }"></c:param>
									</c:url> <a href=${alterar } " class="btn btn-primary btn-sm">Alterar</a>
									<button onclick="idId.value=${item.id}" type="button"
										class="btn btn-danger btn-sm" data-toggle="modal"
										data-target="#myModal">Excluir</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>

	</div>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Excluir Pedido</h4>
				</div>
				<div class="modal-body">
					<p>Você realmente deseja excluir este pedido?</p>
				</div>
				<div class="modal-footer">
					<form action="pedido" method="post">
						<input type="hidden" name="acao" value="excluir"> <input
							type="hidden" id="idId" name="id">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<input type="submit" value="Excluir" class="btn btn-danger">
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>