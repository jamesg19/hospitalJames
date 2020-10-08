
<%@page import="java.util.ArrayList"%>
<%@page import="Objetos.Examenes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>     
    <head>         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
        <title>Consulta</title> 

    </head>

    <body  background="Imagenes/fondo2.jpg">

        <%@ page import="Controller.doctorServlet" %>
        <%@ page import="Objetos.*, Model.*" %>
        <%                              
                        String cuentaII= (String) request.getAttribute("cuenta");
                        request.setAttribute("cuenta",cuentaII);

                        String paciente= (String) request.getParameter("paciente");
                        request.setAttribute("paciente",paciente);
                
                        String correoPP = (String) request.getAttribute("correoP");
                        String nombrePP = (String) request.getAttribute("nombreP");
                        String codigoPP = (String) request.getAttribute("codigoP");
                        String especialidadPP = (String) request.getAttribute("especialidadP");
                        request.setAttribute("correoP", correoPP);
                        request.setAttribute("nombreP", nombrePP);
                        request.setAttribute("nombreP", codigoPP);
                         request.setAttribute("especialidadP", especialidadPP);
        %>

        <h3 align="center"></h3>

        <form  action="doctor" name="forma" method="POST">
            <%if(paciente!=null && codigoPP != null && correoPP != null) {%>
            <table cellspacing="3" cellpadding="3" align="center"  >
                <tr>
                    <td align="left"> Fecha: </td>
                    <td> <input type="date" Id='fecha'  name="fecha" value="2020-10-11"
                                min="2020-01-01" max="2020-12-31" required > </td>
                </tr>

                <tr>
                    <td align="left"> Paciente: </td>
                    <td> <input type="text" value='<%=nombrePP%>' Id='paciente' name="paciente" required readonly > </td>
                </tr>
                <tr>
                    <td align="left"> Id paciente:</td>
                    <td> <input type="text" value='<%=codigoPP%>' Id='idpaciente' name="idpaciente" required readonly > </td>
                </tr> 
                <tr>
                    <td align="left"> Correo: </td>
                    <td> <input type="text" value='<%=correoPP%>' Id="correo" name="correo"  readonly > </td>
                </tr>
                <tr>
                    <td align="left"> Id doctor </td>
                    <td> <input type="text" Id='doctor'  name="doctor" value="<%=cuentaII%>" readonly > </td>
                </tr>
                <tr>
                    <td><label for="informe">Descripcion></label></td>
                    <td><textarea class="form-control" id="informe" name="informe" rows="5" cols="40" ></textarea></td>
                </tr>
                <tr  >
                <div align="center" >
                    <label for="hora" >Hora:</label>
                    <select type="text" class="form-control" id="hora" name="hora">
                        <option>01:00</option><option>02:00</option><option>03:00</option><option>04:00</option><option>05:00</option><option>06:00</option>
                        <option selected >07:00</option><option>08:00</option><option>09:00</option><option>10:00</option><option>11:00</option><option>12:00</option>
                        <option>13:00</option><option>14:00</option><option>15:00</option><option>16:00</option><option>17:00</option><option>18:00</option>
                        <option>19:00</option><option>20:00</option><option>21:00</option><option>22:00</option><option>23:00</option><option>24:00</option>
                    </select>   
                </div>
                </tr>

            </table>

            <div align="center">
                <input  align="center" type="reset" value="Borrar">

                <input align="center" type="submit" name="boton" value="Realizar y Enviar Informe">
            </div>
            <%}%>
        </form>
        <br>
        <br>
        <br>
        <br>
    </body> 
</html>