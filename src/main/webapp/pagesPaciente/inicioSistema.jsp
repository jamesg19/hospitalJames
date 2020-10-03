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

        <h1>Bienvenido al portal de Administrador </h1>
        <%@ page import="Controller.adminServlet" %>
        <%
            String nombreI = (String) request.getAttribute("nombre");
            String cuentaI = (String) request.getAttribute("cuenta");
            String dpi = (String) request.getAttribute("dpi");
            String name = (String) request.getAttribute("password");
            request.setAttribute("nombre",nombreI);
            request.setAttribute("cuenta",cuentaI);
        %>
        <h1> Hola <%= nombreI%> bienvenido al sistema! tu usuario es:</h1>


        <form action="crearAdmin" method="post" >
            <input type="text"  name="user" value="<%= cuentaI%>" readonly="">

            <div align="center" >
                <br>
                <br>
                <table >
                    <tr>
                        
                    <br>
                        <td><input class="btn btn--3"  type="submit" name="boton" align="center" value="Ver historial medico">
                    </td>

                        
                        <td><input class="btn btn--3" type="submit" name="boton" align="center" value="Buscar doctor">
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
