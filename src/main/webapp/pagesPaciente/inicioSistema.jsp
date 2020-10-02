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
        <link rel="stylesheet"
              href="CSS/Estilo.css">
        <link rel="stylesheet"
              href="CSS/Letra.css">
        <link rel="stylesheet"
              href="CSS/botones.css">
    </head>
    <body  background="Imagenes/fondoAdmin.jpg">

        <h1>Bienvenido al portal del Paciente </h1>
        <%@ page import="Controller.adminServlet" %>
        <%
            String nombreI = (String) request.getAttribute("nombre");
            String cuentaI = (String) request.getAttribute("cuenta");

        %>
        <h1> Hola <%= nombreI%> bienvenido al sistema! </h1>
        <h3>Tu usuario es:</h3>


        <form action="crearAdmin" method="post" >
            <input type="text"  name="user" value="<%= cuentaI%>" readonly="">

            <div align="left" >
                <br>  
                <br> 
                <p>Agrega un nuevo administrador </p>
                <input  type="submit" name="boton" align="center" value="Agregar Admin">
                <input  type="submit" name="boton" align="center" value="Modificar mis datos">              
                <p>Agrega un nuevo examen y modifica precios de examen</p>
                <input type="submit" name="boton" align="center" value="Agregar Examen">
                <input type="submit" name="boton" align="center" value="Modifica precios">
                <p>Agrega un nuevo doctor</p>
                <input type="submit" name="boton" align="center" value="Agregar Doctor">
                <input type="submit" name="boton" align="center" value="Agrega Especialidad a Medico">

            </div>


        </form>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>

    </body>
</html>
