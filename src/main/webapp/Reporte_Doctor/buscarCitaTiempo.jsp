<%-- 
    Document   : 
    Created on : Oct 2, 2020, 2:43:31 PM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar consulta</title>

    </head>
    <body background="Imagenes/fondo2.jpg">
        <%@ page import="Controller.pacienteServlet" %>
        <%@ page import="Model.*" %>
        <%
            
        String cuentaI = (String) request.getAttribute("cuenta");   
        request.setAttribute("cuenta",cuentaI);

        %>

        <div align="right" >

            <form action="paciente" name="boton" method="post" >
                <input readonly type="text" Id='user' name="user" value="<%=cuentaI%>" style="visibility:hidden">
                <input align="right" type="submit" name="boton" value="Inicio"  >
            </form> 
        </div>
        <div>
            <form action="ReportePaciente" method="get">

                <h4>Tu usuario es:</h4>
                <input readonly type="text" Id='user' name="user" value="<%=cuentaI%>">
                <h4>Ingresa el id del doctor para la busqueda</h4>
                <table align="left">

                    <tr>
                    <br>
                    <h4> </h4>
                    <td align="right">Ingresa busqueda </td>            
                    <td><input required type="text" Id='busqueda' name="busqueda"></td>           
                    </tr>             
                    <tr>
            <div class="form-group" align="center">
                <label for="fecha1">Desde:</label>
                <input required type="date" id="start" name="fecha1" value="2020-9-4"
                       min="1980-01-01" max="2020-12-31">
            
                <label for="fecha2">Hasta:</label>

                <input required type="date" id="start" name="fecha2" value="2020-10-2"
                       min="1980-01-01" max="2020-12-31">
            </div>
                    </tr>

                    <input type="submit" name="boton" value="Buscar."  >

                </table><!--  -->
                

            </form>
        </div>

    </body>
    <%@ include file = "../Reporte_Paciente/ConsultasRealizadasDocT.jsp" %>
</html>
