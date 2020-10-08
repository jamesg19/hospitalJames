<%--
    Document   : inicioSistema
    Created on : Oct 6, 2020, 2:19:42 AM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal Doctor</title>
        <link rel="stylesheet"
              href="CSS/Estilo.css">
        <link rel="stylesheet"
              href="CSS/Letra.css">
        <link rel="stylesheet"
              href="CSS/botones.css">
        <link rel="stylesheet"
              href="CSS/SuccesBtn.css">
    </head>
    <body  background="Imagenes/fondo3.jpg">
        <h1 align="center" >Bienvenido al portal de Doctor </h1>
        <%@ page import="Controller.doctorServlet" %>
        <%
            String nombreI = (String) request.getAttribute("nombre");
            String cuentaI = (String) request.getAttribute("cuenta");
            request.setAttribute("nombre",nombreI);
            request.setAttribute("cuenta",cuentaI);
        %>
        <h1 align="center" > Hola  bienvenido al sistema de doctores </h1>
        <form action="paciente" method="POST" >
            <div align="right" >
                <input type="text" Id="user" name="user" value="<%=cuentaI%>" readonly="" style="visibility:hidden" >
                <input  type="submit" name="boton" align="right" value="Cerrar sesion">    
            </div>
        </form>
        <form action="doctor" method="post" >
            <input type="text" Id="user" name="user" value="<%= cuentaI%>" readonly="" style="visibility:hidden">
            <div align="center" >
                <table >
                    <tr>
                        <td><input class="btn btn--3"  type="submit" name="boton" align="center" value="Citas programadas">
                        </td>
                        <td><input class="btn btn--3" type="submit" name="boton" align="center" value="Modificar mis datos">
                        </td>
                    </tr>                  
                        <tr align="center" >                      
                            <td align="center" ><input class="btn btn--3"  type="submit" name="boton" align="center" value="///Modificar mis datos">
                            </td>
                        </tr>
                </table>
            </div>
        </form>
        <div align="center" >
            <form action="ReporteDoctor" method="get"  >
                <input type="text" Id="user" name="user" value="<%=cuentaI%>" readonly="" style="visibility:hidden">
                <table>
                    <tr>
                        <td><input class="btn btn--3" type="submit" name="boton" align="center" value="Paciente con mas informes">
                        </td>
                         <td><input class="btn btn--3" type="submit" name="boton" align="center" value="Citas programadas para hoy">
                        </td>
                         <td><input class="btn btn--3" type="submit" name="boton" align="center" value="Citas con intervalo de tiempo">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
    </body>
    
</html>
