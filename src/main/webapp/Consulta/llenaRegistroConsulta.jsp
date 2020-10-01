
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>     
    <head>         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
        <title>JSP Page</title> 

    </head>

    <body  background="Imagenes/fondoAdmin.jpg">

        <%@ page import="Controller.adminServlet" %>

        <h2 align="center"> Agrega un nuevo tipo de consulta:</h2>
        <form  action="crearAdmin" name="forma" method="post">


            <table cellspacing="3" cellpadding="3" align="center"  >
                <div>
                <tr>
                    <td align="right"> Codigo: </td>
                    <td><input type="text" Id='codigo' name="codigo" required></td>
                </tr>

                <tr>
                    <td align="right"> Tipo: </td>
                    <td> <input type="text" Id='tipo'



                <tr>
                    <td align="right"> Costo: </td>
                    <td> <input type="number" Id='costo' value="1" name="costo" step="any" required > </td>
                </tr>
            </div>

            </table>

            <div>
                <input type="reset" value="Borrar">

                <input type="submit" name="boton" value="Registrar Examen"  >
            </div>
        </form>


    </body> 
</html>