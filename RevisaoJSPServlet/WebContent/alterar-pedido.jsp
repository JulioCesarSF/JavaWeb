<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="includeTaglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Pedido</title>
<%@ include file="includeHead.jsp"%>
</head>
<body>

	<%@include file="navbar.jsp"%>

	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h2>Alterar Pedido</h2>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<c:if test="${not empty tipoMensagem}">
					<div class="${tipoMensagem }">
						<p>${mensagem }</p>
					</div>
				</c:if>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
			
				<form action="pedido" method="post">
					<input type="hidden" name="acao" value="alterar"> <input
						type="hidden" name="id" value="${pedido.id }">
					<div class="row">
						<div class="col-md-3">
							<div class="form-group">
								<label for="idData">Data do Pedido</label> <input type="date"
									name="data" id="idData" class="form-control" value="${pedido.dataPedido }" required>
							</div>
						</div>

						<div class="col-md-3">
							<div class="form-group">
								<label for="idQuarto">Quarto</label> <input type="text"
									name="quarto" id="idQuarto" placeholder="Número do Quarto"
									class="form-control" value="${pedido.quarto }" required>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-3">
							<div class="form-group">
								<label for="idDescricao">Descrição</label> <input type="text"
									name="descricao" id="idDescricao"
									placeholder="Descrição do pedido" class="form-control" value="${pedido.descricao }" required>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label for="idValor">Valor</label> <input type="number"
									step="0.10" name="valor" id="idValor"
									placeholder="Informe o Valor do Pedido" class="form-control"
									value="${pedido.valor }" required>
							</div>
						</div>
						
						<div class="col-md-3">
							<div class="form-group">
								<label for="idStatus">Status</label>
								<select id="idStatus" name="status" class="form-control">
									<option value="">Selecione</option>
									<option value="Aberto" ${pedido.status  == "Aberto" ? 'selected="selected"' : "" }>Aberto</option>
									<option value="Fechado" ${pedido.status  == "Fechado" ? 'selected="selected"' : "" }>Fechado</option>
								</select>
							</div>
						</div>
					</div>

					<div class="form-group">
						<input type="submit" value="Salvar" class="btn btn-primary">
					</div>
				</form>
			</div>
		</div>

	</div>

</body>
</html>