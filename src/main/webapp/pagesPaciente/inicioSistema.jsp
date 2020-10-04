<%--
    Document   : inicioSistema
    Created on : Sep 27, 2020, 4:29:52 AM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal Paciente</title>
        <link rel="stylesheet"
              href="CSS/Estilo.css">
        <link rel="stylesheet"
              href="CSS/Letra.css">
        <link rel="stylesheet"
              href="CSS/botones.css">
    </head>
    <body  background="Imagenes/fondo2.jpg">
        <%@ include file = "../pagesPaciente/menu.jsp" %>

        <h1>Bienvenido al portal de Paciente </h1>
        <%@ page import="Controller.pacienteServlet" %>
        <%
            String nombreI = (String) request.getAttribute("nombre");
            String cuentaI = (String) request.getAttribute("cuenta");
            request.setAttribute("nombre",nombreI);
            request.setAttribute("cuenta",cuentaI);
        %>
        <h1> Hola  bienvenido al sistema! tu usuario es:</h1>
        <form action="paciente" method="post" >
            <div align="right" >
              <input  type="submit" name="boton" align="right" value="Cerrar sesion">  
                
            </div>
            
            
        </form>


        <form action="paciente" method="post" >
            <input type="text" Id="user" name="user" value="<%= cuentaI%>" readonly="">

            <div align="center" >
                <br>
                <br>
                <table >
                    <tr>
                    <td><input class="btn btn--3"  type="submit" name="boton" align="center" value="Ver historial medico">
                    </td>
                    <td><input class="btn btn--3" type="submit" name="boton" align="center" value="Buscar doctor">
                    </td>
                    </tr>
                    
                    <tr>                  
                    <td><input class="btn btn--3"  type="submit" name="boton" align="center" value="Agendar una cita">
                    </td>
                    <td><input class="btn btn--3" type="submit" name="boton" align="center" value="Ver citas">
                    </td>
                    </tr>
                </table>
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
