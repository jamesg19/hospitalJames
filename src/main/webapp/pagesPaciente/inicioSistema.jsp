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
        <link rel="stylesheet"
              href="CSS/SuccesBtn.css">
    </head>
    <body  background="Imagenes/fondo2.jpg">
        <h1>Bienvenido al portal de Paciente </h1>
        <%@ page import="Controller.pacienteServlet" %>
        <%
            String nombreI = (String) request.getAttribute("nombre");
            String cuentaI = (String) request.getAttribute("cuenta");
            request.setAttribute("nombre",nombreI);
            request.setAttribute("cuenta",cuentaI);
        %>
        <h1> Hola  bienvenido al sistema!</h1>
        <form action="paciente" method="post" >
            <div align="right" >
                <input  type="submit" name="boton" align="right" value="Cerrar sesion">    
            </div>
        </form>
        <form action="paciente" method="post" >
            <input type="text" Id="user" name="user" value="<%= cuentaI%>" readonly="" style="visibility:hidden">
            <div align="center" >
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
                        <td><input class="btn btn--3" type="submit" name="boton" align="center" value="Ver mis citas">
                        </td>
                    </tr>                   
                        <tr align="center" >                      
                            <td align="center" ><input class="btn btn--3"  type="submit" name="boton" align="center" value="Modificar mis datos">
                            </td>
                        </tr>
                </table>
            </div>
        </form>
        <div align="center" >
            <form action="ReportePaciente" method="get"  >
                <h3>Reportes de paciente</h3>
                <input type="text" Id="user" name="user" value="<%=cuentaI%>" readonly="" style="visibility:hidden">
                <table>
                    <tr>
                        <td><input class="btn btn--3" type="submit" name="boton" align="center" value="Ultimas 5 citas">
                        </td>
                        
                            <label align="right" for="Consultas realizadas" >consultas en intervalo de tiempo </label>
                            <td><input class="btn btn--3" type="submit" name="boton" align="center" value="Consultas realizadas.">
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
