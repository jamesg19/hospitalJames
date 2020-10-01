<%-- 
    Document   : index
    Created on : Sep 29, 2020, 12:00:14 AM
    Author     : james
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso al sistema</title>
    </head>
    <body background="Imagenes/pruebaimagen.jpg">
        <br>
        <h1 align="center" >Bienvenido al portal Hospital USAC</h1>


        <%@ page import="Controller.login" %>
        <h3 align="center" > Introduce tu cuenta y tu contraseña</h3>
        <form action="login" method="post">
            <table cellspacing="3" cellpadding="3" border="1" >
                <tr align="right" >
                <br>    
                <div class="form-group" align="center" >
                    <label for="exampleInputEmail1"align="left" >Usuario :</label>
                    <input required type="text" name="codigo" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                    <small id="emailHelp" class="form-text text-muted"></small>
                </div>

                </tr>
                <br>
                <div class="form-group" align="center" >
                    <label for="exampleInputPassword1">Password</label>
                    <input required="Ingresa la contrasena" type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                </div>
                <br>  
                <br> 
            </table>
            <div align="center" >

                <input type="reset" value="Borrar">
                <input type="submit" value="Ingresar">
            </div>
            <br><!-- comment -->
            <div align="center">
            <div class="form-check form-check-inline" align="center">
                <input class="form-check-input" required type="radio" name="inlineRadioOptions" id="inlineRadio1" value="admin">
                <label class="form-check-label" for="inlineRadio1">ADMINISTRADOR</label>

                <input class="form-check-input" required type="radio" name="inlineRadioOptions" id="inlineRadio2" value="paciente">
                <label class="form-check-label"  for="inlineRadio2">PACIENTE</label>
            
            
                <input class="form-check-input" required type="radio" name="inlineRadioOptions" id="inlineRadio3" value="doctor">
                <label class="form-check-label" for="inlineRadio3">DOCTOR</label>
            </div>
            </div>
        </form>
        <form action="pagesAdmin/llenaRegistro.jsp" method="post">
            <br>  
            <br> 
            <div align="center" >
                <input type="submit" align="center" value="Registrarse">
            </div>

        </form>
    </body>



</html>