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
            String nombreI = (String) request.getAttribute("nombre");
            String cuentaI = (String) request.getAttribute("cuenta");
            String dpi = (String) request.getAttribute("dpi");
            String name = (String) request.getAttribute("password");
            request.setAttribute("nombre",nombreI);
            request.setAttribute("cuenta",cuentaI);
            request.setAttribute("dpi",dpi);
            request.setAttribute("password",name);

        %>
        <h1> Hola <%= nombreI%> bienvenido al sistema! tu usuario es:</h1>


        <form action="crearAdmin" method="post" >
            <input type="text"  name="user" value="<%= cuentaI%>" readonly="">

            <div align="left" >
                <br>  
                <br> 
                <p>Agrega un nuevo administrador </p>
                <input type="submit" name="boton" align="center" value="Agregar Admin">
                <input type="submit" name="boton" align="center" value="Modificar mis datos">              
                <p>Agrega un nuevo examen y modifica precios de examen</p>
                <input type="submit" name="boton" align="center" value="Agregar Examen">
                <input type="submit" name="boton" align="center" value="Modifica precios">
                <p>Agrega un nuevo doctor</p>
                <input type="submit" name="boton" align="center" value="Agregar Doctor">
                <input type="submit" name="boton" align="center" value="Agrega Especialidad a Medico">
                <p>Agrega una nueva consulta</p>
                <input type="submit" name="boton" align="center" value="Agregar Nueva Consulta.">
                <input type="submit" name="boton" align="center" value="Modifica precio consulta">
                <p>Agrega un nuevo Laboratorista</p>
                <input type="submit" name="boton" align="center" value="Agregar Nuevo Laboratorista">
                <input type="submit" name="boton" align="center" value="Modifica Laboratorista">

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
