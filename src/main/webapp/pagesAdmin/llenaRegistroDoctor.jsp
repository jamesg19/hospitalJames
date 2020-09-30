
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>     
    <head>         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
        <title>JSP Page</title> 

    </head>

    <body  background="Imagenes/fondoAdmin.jpg">

        <%@ page import="Controller.adminServlet" %>

        <h2 align="center"> Agrega un nuevo Doctor</h2>
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


                <tr>
                    <td align="right"> Colegiado: </td>
                    <td> <input type="text" Id='colegiado' value="1" name="colegiado"  required > </td>
                </tr>
                <tr>
                    <td align="right"> DPI: </td>
                    <td> <input type="text" Id='dpi' value="1" name="dpi"  required > </td>
                </tr>
                <tr>
                    <td align="right"> Telefono: </td>
                    <td> <input type="text" Id='telefono'  name="telefono"  required > </td>
                </tr>
                <tr>
                    <td align="right"> Correo: </td>
                    <td> <input type="text" Id='correo'  name="correo"  required > </td>
                </tr>
                <tr align="center">
                <label for="exampleFormControlSelect1">Hora Inicio (24hrs):</label>
                <select type="text" class="form-control" id="horaInicio" name="horaInicio" >
                    <option>1:00</option><option>2:00</option><option>3:00</option><option>4:00</option><option>5:00</option><option>6:00</option>
                    <option>7:00</option><option>8:00</option><option>9:00</option><option>10:00</option><option>11:00</option><option>12:00</option>
                    <option>13:00</option><option>14:00</option><option>15:00</option><option>16:00</option><option>17:00</option><option>18:00</option>
                    <option>19:00</option><option>20:00</option><option>21:00</option><option>22:00</option><option>23:00</option><option>24:00</option>
                </select>   
                
                <label for="exampleFormControlSelect1">Hora fin (24hrs):</label>
                <select type="text" class="form-control" id="horaFin" name="horaFin" >
                    <option>1:00</option><option>2:00</option><option>3:00</option><option>4:00</option><option>5:00</option><option>6:00</option>
                    <option>7:00</option><option>8:00</option><option>9:00</option><option>10:00</option><option>11:00</option><option>12:00</option>
                    <option>13:00</option><option>14:00</option><option>15:00</option><option>16:00</option><option>17:00</option><option>18:00</option>
                    <option>19:00</option><option>20:00</option><option>21:00</option><option>22:00</option><option>23:00</option><option>24:00</option>
                </select>
                </tr>
                                <tr>
                    <td align="right"> Fecha de contratacion: </td>
                    <td> <input type="text" Id='trabajo'  name="trabajo"  required > </td>
                </tr>
                <tr>
                    <td align="right"> Password</td>
                    <td> <input type="text" Id='password'  name="password"  required > </td>
                </tr>
            </table>
            <div class="form-group" align="center">
                <label for="exampleFormControlTextarea1">Descripcion:</label>
                <textarea required class="form-control" id="descripcion" name="descripcion" rows="8" cols="80"></textarea>
            </div>

            <div align="center">
                <input  align="center" type="reset" value="Borrar">

                <input align="center" type="submit" name="boton" value="Registrar Examen"  >
            </div>
        </form>

    </body> 
</html>