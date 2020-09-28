<%-- 
    Document   : index
    Created on : Sep 26, 2020, 7:26:20 PM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso al sistema</title>
    </head>
    <body>
        <h1>Bienvenido al sistema de Login!</h1>
        <%@ page import="Controller.login" %>
        <h3> Introduce tu cuenta y tu contraseña</h3>
        <form action="login" method="post">
            <table cellspacing="3" cellpadding="3" border="1" >
                <tr>

                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="text" name="codigo" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>

                </tr>
                <tr>
                    <td align="right"> Contraseña: </td>
                    <td><input type="password" name="password"></td>
                </tr>
            </table>
            <input type="reset" value="Borrar">
            <input type="submit" value="Ingresar">
        </form>
        <form action="llenaRegistro.jsp" method="post">
            <input type="submit" value="Registrar">
        </form>
    </body>
</html>


