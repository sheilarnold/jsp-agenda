<%@ page
	import="br.com.aula.dao.*, br.com.aula.modelo.*, java.util.*, java.text.SimpleDateFormat"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Projeto fj21-agenda</title>
	</head>
	<body>
		<%-- comentário em JSP aqui: nossa primeira página JSP --%>
		<%
			String mensagem = "Bem vindo ao sistema JSP Agenda!";
		%>
		<%
			out.println(mensagem);
		%>
		<br />
		<%
			String desenvolvido = "Desenvolvido por Sheila C.S Arnold";
		%>
		<%=desenvolvido%>
		<br />
		<%
			System.out.println("Tudo foi executado!");
		%>
	</body>
</html>