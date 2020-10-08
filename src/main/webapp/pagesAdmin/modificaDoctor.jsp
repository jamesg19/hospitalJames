<%-- 
    Document   : registroGuardado
    Created on : Sep 26, 2020, 7:40:33 PM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="Imagenes/fondo2.jpg">
        <%@ page import="Controller.adminServlet" %> 
        <%
            String nombreI = (String) request.getAttribute("Nombre");
            String cuentaI = (String) request.getAttribute("cuenta");
            String dpi = (String) request.getAttribute("Dpi");
            String name = (String) request.getAttribute("Password");
        %>
        <form action="crearAdmin" method="post" >
            <div align="right" >
                <input type="submit" value="Inicio"  name="boton" >          
            </div>           
            <input type="text" value="<%=cuentaI%>" Id='cuentaI' name="cuentaI" style="visibility:hidden" >
            <input type="text" value="<%=nombreI%>" Id='nombreI' name="nombreI" style="visibility:hidden" >
        </form>        
        <br> 
        <h2 align="center"> Modifica un doctor</h2>
        <br>      
        <br>
        <p align="center"> . </p>
        <form action="crearAdmin">
            <table cellspacing="3" cellpadding="3" align="center"  >          

                <td align="right"> Codigo: </td>            
                <td><input required type="text"  value='<%=cuentaI%>' name="codigo" readonly=""> </td>           
                </tr>             
                <tr>             
                    <td align="right"> Nombre: </td>                
                    <td> <input required type="text"  value='<%=dpi%>' name="nombre"> </td>           
                </tr>           
                <tr>             
                    <td align="right"> Colegiado </td>                
                    <td> <input required type="text" value='<%=nombreI%>' name="colegiado"> </td>           
                </tr>
                <tr>             
                    <td align="right"> DPI: </td>                
                    <td> <input required type="text" value='<%=nombreI%>' name="dpi"> </td>           
                </tr>
                <tr>             
                    <td align="right"> Telefono </td>                
                    <td> <input required type="text" value='<%=nombreI%>' name="telefono"> </td>           
                </tr>
                <tr>             
                    <td align="right"> Correo </td>                
                    <td> <input required type="text" value='<%=nombreI%>' name="correo"> </td>           
                </tr>
                <tr>             
                    <td align="right"> Hora Inicio: </td>                
                    <td> <input required type="text" value='<%=nombreI%>' name="horaInicio"> </td>           
                </tr>
                <tr>             
                    <td align="right"> Hora Fin </td>                
                    <td> <input required type="text" value='<%=nombreI%>' name="horaFin"> </td>           
                </tr>
                <tr>             
                    <td align="right"> Trabaja desde: </td>                
                    <td> <input required type="text" value='<%=nombreI%>' name="trabajo"> </td>           
                </tr>
                <tr>             
                    <td align="right"> Password: </td>                
                    <td> <input required type="text" value='<%=nombreI%>' name="password"> </td>           
                </tr>

                <br><!-- comment -->
                <br><!-- comment -->
                

            </table>
                <div align="center">
            
            <input align="center" type="submit" name="boton" value="Actualizar Doctor" >
                </div>
            </form>
    </body>
</html>