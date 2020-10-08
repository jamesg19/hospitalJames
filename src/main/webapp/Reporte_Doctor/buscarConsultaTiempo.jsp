<%-- 
    Document   : buscarMedico
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
    <body background="Imagenes/fondo3.jpg">
        <h4>Reporte de citas agendadas en un intervalo de tiempo.</h4>
        <%@ page import="Controller.pacienteServlet" %>
        <%@ page import="Model.*" %>
        <%
            
        String cuentaI = (String) request.getAttribute("cuenta");   
        request.setAttribute("cuenta",cuentaI);

        %>

        <div align="right" >

            <form action="ReporteDoctor" name="boton" method="post" >
                <input readonly type="text" Id='user' name="user" value="<%=cuentaI%>" style="visibility:hidden">
                <input align="right" type="submit" name="boton" value="Inicio"  >
            </form> 
        </div>
        <div>
            <form action="ReporteDoctor" method="get">

                <h4>Tu usuario es:</h4>
                <input readonly type="text" Id='user' name="user" value="<%=cuentaI%>">
                <h4>Citas agendadas en un intervalo de tiempo</h4><br> 
                
                <table align="left">
                    <tr>
                        <td align="right">Ingresa un intervalo de tiempo para buscar una cita </td>
                    </tr>
                    <tr>                                         
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
                    <input type="submit" name="boton" value="Buscar.."  >
                </table><!--  -->
            </form>
        </div>
    </body>
   <%@ include file = "../Reporte_Doctor/ConsultasRealizadasDocT.jsp" %> 
</html>
