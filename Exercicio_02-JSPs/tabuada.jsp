<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tabuada</title>
<link rel="" type="">
<link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>

<div class="container">

<%@ include file="topo.jsp" %>

	<div>
		<h1>Tabuada</h1>
	</div>

	<table>
		
		<%
			int n = 1;			
			for (int i = 0; i < 11; i++) {				
				System.out.println(n + " x " + i + " = " + (n*i));
		%>

		<tr>
			<td><%=n%> x <%=i%> =</td>
			<td><%=n*i%></td>
			
			<% n++; %>			
			<td><%=n%> x <%=i%> =</td>
			<td><%=n*i%></td>
			
			<% n++; %>
			<td><%=n%> x <%=i%> =</td>
			<td><%=n*i%></td>
			
			<% n++; %>
			<td><%=n%> x <%=i%> =</td>
			<td><%=n*i%></td>
			
			<% n++; %>
			<td><%=n%> x <%=i%> =</td>
			<td><%=n*i%></td>
			
			<% n++; %>
			<td><%=n%> x <%=i%> =</td>
			<td><%=n*i%></td>
			
			<% n++; %>
			<td><%=n%> x <%=i%> =</td>
			<td><%=n*i%></td>
			
			<% n++; %>
			<td><%=n%> x <%=i%> =</td>
			<td><%=n*i%></td>
			
			<% n++; %>
			<td><%=n%> x <%=i%> =</td>
			<td><%=n*i%></td>	
			
		</tr>

		<%
			n = 1;
			}
		%>
		
	</table>
	
	<%@ include file="rodape.jsp" %>
	</div>

</body>
</html>
