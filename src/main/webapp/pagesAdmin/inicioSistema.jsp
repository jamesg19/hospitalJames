<%-- 
    Document   : inicioSistema
    Created on : Sep 27, 2020, 5:29:52 PM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body  background="Imagenes/fondoAdmin.jpg">

        <h1>Bienvenido al portal de Administrador </h1>
        <%@ page import="Controller.adminServlet" %>
        <%
            String nombre = (String) request.getAttribute("nombre");
            String cuenta = (String) request.getAttribute("cuenta");
        %>
        <h1> Hola <%= nombre%> bienvenido al sistema!</h1>


        <form action="crearAdmin" method="post">
            <br>  
            <br> 

            <div align="left" >
                <p>Agrega un nuevo administrador </p>
                <input type="submit" name="boton" align="center" value="Agregar Admin">
                <input type="submit" name="boton" align="center" value="Modifica Admin">
                <br>
                <p>Agrega un nuevo examen y modifica precios de examen</p>
                <input type="submit" name="boton" align="center" value="Agregar Examen">
                <input type="submit" name="boton" align="center" value="Modifica precios">

            </div>

        </form>

    </body>
</html>
