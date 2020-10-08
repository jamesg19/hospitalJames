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
            request.setAttribute("dpi",dpi);
            request.setAttribute("password",name);

        %>
        <h1> Hola <%= nombreI%> bienvenido al sistema! tu usuario es:</h1>


        <form action="crearAdmin" method="post" >
            <input type="text"  name="user" value="<%= cuentaI%>" readonly="" style="visibility:hidden">
            <input type="text"  name="nombre" value="<%=nombreI%>" readonly="" style="visibility:hidden">

            <div align="center" >

                <table align="center" >
                    <tr align="center" >
                        <td align="center" >
                <input class="btn btn--3" type="submit" name="boton" align="center" value="Agregar Admin">
                <input class="btn btn--3" type="submit" name="boton" align="center" value="Agregar Examen">
                        </td>

                    
                    <td>   
                <input class="btn btn--3" type="submit" name="boton" align="center" value="Modificar mis datos">
                <input class="btn btn--3" type="submit" name="boton" align="center" value="Modifica precios">
                    </td>
                
                <tr>
                    <td> 
                <input class="btn btn--3" type="submit" name="boton" align="center" value="Agregar Doctor">
                                <input class="btn btn--3" type="submit" name="boton" align="center" value="Agregar Nueva Consulta.">
                    </td>

                    
                    <td>
                <input class="btn btn--3" type="submit" name="boton" align="center" value="Agrega Especialidad a Medico">    

                <input class="btn btn--3" type="submit" name="boton" align="center" value="Modifica precio consulta">
                    </td>
                </tr>
                <tr>
                    
                    <td>
                    
                <input class="btn btn--3" type="submit" name="boton" align="center" value="Agregar Nuevo Laboratorista">
                    </td><!-- comment -->
                    <td>
                <input class="btn btn--3" type="submit" name="boton" align="center" value="Modifica Laboratorista">
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
