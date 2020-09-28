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
        
        <form action="crearAdmin" method="post">
            <br>  
            <br> 
            
            <div align="left" >
                <p>Agrega un nuevo administrador </p>
                <input type="submit" name="boton" align="center" value="Agregar Admin">
                <br>
                <p>Agrega un nuevo examen</p>
                <input type="submit" name="boton" align="center" value="Agregar Examen">
                <p>Cambiar precio de examen</p>
            </div>

        </form>
        
    </body>
</html>
