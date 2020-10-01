
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>     
    <head>         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
        <title>JSP Page</title> 

    </head>

    <body  background="Imagenes/fondoAdmin.jpg">

        <%@ page import="Controller.adminServlet" %>

        <h3 align="center"> Agrega un nuevo Laboratorista</h3>
        <form  action="crearAdmin" name="forma" method="post">


            <table cellspacing="3" cellpadding="3" align="center"  >

                <tr>
                    <td align="right"> Codigo: </td>
                    <td><input type="text" Id='codigo' name="codigo" required></td>
                </tr>

                <tr>
                    <td align="right"> Nombre: </td>
                    <td> <input type="text" Id='nombre' name="nombre" required > </td>
                </tr>
                <div>
                    <tr>
                        <td align="right"> Registro: </td>
                        <td> <input type="text" Id='registro'  name="registro"  required > </td>
                    </tr>
                    <tr>
                        <td align="right"> DPI: </td>
                        <td> <input type="text" Id='dpi'  name="dpi"  required > </td>
                    </tr>
                    <tr>
                        <td align="right"> Telefono: </td>
                        <td> <input type="text" Id='telefono'  name="telefono"  required > </td>
                    </tr>
                    <tr>
                        <td align="right"> Examen: </td>
                        <td> <input type="text" Id='examen'  name="examen"  required > </td>
                    </tr>
                    <tr>
                        <td align="right"> Correo: </td>
                        <td> <input type="text" Id='correo'  name="correo"  required > </td>
                    </tr>
                    <tr>
                        <td align="right"> Dias trabajo: </td>
                        <td> <input type="text" Id='diasTrabajo'  name="diasTrabajo"  required > </td>
                    </tr>

                    <tr>
                        <td align="right"> Password</td>
                        <td> <input type="text" Id='password'  name="password"  required > </td>
                    </tr>

            </table>

            <div class="form-group" align="center">
                <td align="right"> Trabaja desde </td>
                <input type="date" id="start" name="trabajo" value="2020-03-19"
                       min="1980-01-01" max="2020-12-31" required>
            </div>

            <div align="center">

            </div>
            <div align="center">
                <input  align="center" type="reset" value="Borrar">

                <input align="center" type="submit" name="boton" value="Registrar Laboratorista"  >
            </div>
        </form>

    </body> 
</html>