<%-- 
    Document   : registroGuardado
    Created on : Sep 26, 2020, 7:40:33 PM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"
content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<%@ page import="Model.Usuario" %>
<%
String cuenta = request.getParameter("cuenta");
String nombre= request.getParameter("nombre");
String clave= request.getParameter("clave");
String mail = request.getParameter("mail");
%>
92
<h3> Registro exitoso en la base de datos</h3>
<p> Se guardaron los siguientes datos: </p>
<table cellspacing="3" cellpadding="3" border="1" >
<tr>
<td align="right"> Cuenta: </td>
<td> <%= cuenta %> </td>
</tr>
<tr>
<td align="right"> Nombre: </td>
<td> <%= nombre %> </td>
</tr>
<tr>
<td align="right"> Contraseña: </td>
<td> <%= clave %> </td>
</tr>
<tr>
<td align="right"> Mail: </td>
<td> <%= mail %> </td>
</tr>
</table>
<form action="index.jsp" method="post">
<input type="submit" value="Regresar">
</form>
</body>
</html>