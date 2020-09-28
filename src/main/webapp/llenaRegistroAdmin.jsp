<%-- 
    Document   : llenaRegistro
    Created on : Sep 26, 2020, 7:33:33 PM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Llena Registro</title>
    </head>
    <body>
        <%@ page import="Controller.registroAdmin" %>
        <h3> Registra los datos del nuevo Admin</h3>
        <form action="registroAdmin" method="post">
            <table cellspacing="3" cellpadding="3" border="1" >
                <tr>
                    <td align="right"> Codigo </td>
                    <td><input type="text" name="codigo"></td>
                </tr>
                <tr>
                    <td align="right"> DPI: </td>
                    <td><input type="text" name="dpi"></td>
                </tr>
                <tr>
                    <td align="right"> Nombre: </td>
                    <td><input type="text" name="nombre"></td>
                </tr>
                <tr>
                    <td align="right"> Password: </td>
                    <td><input type="text" name="password"></td>
                </tr>
            </table>
            <input type="reset" value="Borrar">
            <input type="submit" value="Guardar">
        </form>
        <form action="index.jsp" method="post">
            <input type="submit" value="Regresar">
        </form>
    </body>
</html>
