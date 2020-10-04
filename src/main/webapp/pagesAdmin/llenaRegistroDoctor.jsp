
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
                <div>


                    <tr>
                        <td align="right"> Colegiado: </td>
                        <td> <input type="text" Id='colegiado' value="1" name="colegiado"  required > </td>
                    </tr>
                    <tr>
                        <td align="right"> DPI: </td>
                        <td> <input type="number" Id='dpi' value="1" name="dpi"  required > </td>
                    </tr>
                    <tr>
                        <td align="right"> Especialidad1: *</td>
                        <td> <input type="text" Id='especialidad'  name="especialidad"  required > </td>
                    </tr>
                    <tr>
                        <td align="right"> Especialidad2: </td>
                        <td> <input type="text" Id='especialidad2'  name="especialidad2"  > </td>
                    </tr>
                    <tr>
                        <td align="right"> Especialidad3: </td>
                        <td> <input type="text" Id='especialidad3'  name="especialidad3"  > </td>
                    </tr>
                    <tr>
                        <td align="right"> Telefono: </td>
                        <td> <input type="text" Id='telefono'  name="telefono"  required > </td>
                    </tr>
                    <tr>
                        <td align="right"> Correo: </td>
                        <td> <input type="text" Id='correo'  name="correo"  required > </td>
                    </tr>

                    <tr>
                        <td align="right"> Password</td>
                        <td> <input type="text" Id='password'  name="password"  required > </td>
                    </tr>


                    <div align="center">

                        <label align="center" for="exampleFormControlSelect1">Hora Inicio (24hrs):</label>
                        <select type="text" class="form-control" id="horaInicio" name="horaInicio" >
                            <option>1:00</option><option>2:00</option><option>3:00</option><option>4:00</option><option>5:00</option><option>6:00</option>
                            <option>7:00</option><option selected >8:00</option><option>9:00</option><option>10:00</option><option>11:00</option><option>12:00</option>
                            <option>13:00</option><option>14:00</option><option>15:00</option><option>16:00</option><option>17:00</option><option>18:00</option>
                            <option>19:00</option><option>20:00</option><option>21:00</option><option>22:00</option><option>23:00</option><option>24:00</option>
                        </select><br>   

                        <label align="center" for="exampleFormControlSelect1">Hora fin (24hrs):</label>
                        <select type="text" class="form-control" id="horaFin" name="horaFin" >
                            <option>1:00</option><option>2:00</option><option>3:00</option><option>4:00</option><option>5:00</option><option>6:00</option>
                            <option>7:00</option><option>8:00</option><option>9:00</option><option>10:00</option><option>11:00</option><option>12:00</option>
                            <option>13:00</option><option>14:00</option><option>15:00</option><option selected>16:00</option><option>17:00</option><option>18:00</option>
                            <option>19:00</option><option>20:00</option><option>21:00</option><option>22:00</option><option>23:00</option><option>24:00</option>
                        </select>
                    </div>
            </table>

            <div class="form-group" align="center">
                <input type="date" id="start" name="trabajo" value="2020-03-19"
                       min="1980-01-01" max="2020-12-31">
            </div>

            <div align="center">
                <input class="btn btn--4" align="center" type="reset" value="Borrar">

                <input align="center" type="submit" name="boton" value="Registrar Doctor"  >
                <h1>.</h1>
            </div>
        </form>

    </body> 
</html>