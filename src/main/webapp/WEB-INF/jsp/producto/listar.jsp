<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="pe.edu.tecsup.tienda.entities.Producto" %>
<%@ page import="java.util.List" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Listar Productos
	
	<%
	
		List<Producto> productos = (List<Producto>)request.getAttribute("productos");
	
		for(Producto item : productos) {
			out.println(item);
		}
	
	%>
	
	
	
</body>
</html>