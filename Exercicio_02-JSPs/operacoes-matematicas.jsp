<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Operações Matemáticas</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>

	<div class="container">

		<%@ include file="topo.jsp"%>

		<div>
			<h1>Operações Matemáticas</h1>
		</div>

		<%
			List<String> o = new ArrayList<>(); //desde java 8 não precisa declarar String no segundo "diamante".
			o.add("Soma");
			o.add("Subtração");
			o.add("Multiplicação");
			o.add("Divisão");
		%>

		<ul>

			<%
				for (String tipo : o) {
			%>

			<li><%=tipo%></li>

			<%
				}
			%>

		</ul>

		<%@ include file="rodape.jsp"%>

	</div>

</body>
</html>
