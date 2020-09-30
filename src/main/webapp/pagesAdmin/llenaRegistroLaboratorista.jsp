
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>     
    <head>         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
        <title>JSP Page</title> 

    </head>

    <body  background="Imagenes/fondoAdmin.jpg">

        <%@ page import="Controller.adminServlet" %>

        <h2 align="center"> Agrega un nuevo Laboratorista</h2>
        <form  action="crearAdmin" name="forma" method="post">


            <table cellspacing="3" cellpadding="3" align="center"  >
                <div>
                <tr>
                    <td align="right"> Codigo: </td>
                    <td><input type="text" Id='codigo' name="codigo" required></td>
                </tr>

                <tr>
                    <td align="right"> Nombre: </td>
                    <td> <input type="text" Id='nombre' name="nombre"required > </td>
                </tr>



                <tr>
                    <td align="right"> Costo: </td>
                    <td> <input type="number" Id='costo' value="1" name="costo" step="any" required > </td>
                </tr>
            </div>
            <div align="center">
                <label for="exampleFormControlSelect1">Tipo Informe:</label>
                <select type="text" class="form-control" id="tipoInforme" name="tipoInforme" >
                    <option>PDF</option>
                    <option>IMG</option>
                </select>
            
            
                <label for="exampleFormControlSelect1">Orden:</label>
                <select  type="text" class="form-control" id="orden" name="orden" align="center">
                    <option>SI</option>
                    <option>NO</option>
                </select>
            </div>

            </table>
            <div class="form-group" align="center">
                <label for="exampleFormControlTextarea1">Descripcion:</label>
                <textarea required class="form-control" id="descripcion" name="descripcion" rows="8" cols="80"></textarea>
            </div>

            <div>
                <input type="reset" value="Borrar">

                <input type="submit" name="boton" value="Registrar Examen"  >
            </div>
        </form>


    </body> 
</html>