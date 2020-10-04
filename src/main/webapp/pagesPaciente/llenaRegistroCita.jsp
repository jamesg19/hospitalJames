<%@page import="Objetos.Consulta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html>     
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Agendar Cita</title>    
    </head>     
    <body background="Imagenes/fondo2.jpg"> 
        <%@ page import="Controller.pacienteServlet" %>
        <%@ page import="Objetos.Especialidad, java.util.ArrayList" %> 
        <h2>Agenda un cita por especialidad </h2> 

        <%ArrayList<Especialidad> especialidades = null;
            especialidades = (ArrayList<Especialidad>) request.getAttribute("Especialidad");      %>
        <%
            String cuentaI = (String) request.getAttribute("cuenta");
            request.setAttribute("CUENTA",cuentaI);
            String nombreI = (String) request.getAttribute("nombre");
            request.setAttribute("nombre",nombreI);
            
            %>
        <div>
            <form action="paciente" method="post" >
            <table align="center" border="1">                  
                <h4>Hola <%=request.getAttribute("CUENTA") %> </h4>  

            </table>
            </form>

        </div>


        <form action="paciente" method="get">
            <input align="right" type="submit" name="boton" value="Inicio"  >
            <br>

            <table align="center" >
                <tr>
                    <td>Mi codigo Paciente</td><!-- comment -->
                    <td><input  type="text" Id="user" name="user" value="<%=cuentaI%>" readonly ></td><!-- comment -->

                </tr>
                <tr>
                    <td>Tipo de consulta:</td>                                  
                    <td><select align="center" required type="text" Id='especialidad' name="especialidad" >
                            <%for (Especialidad especialidad : especialidades) {%>
                            <option><%=especialidad.getTipo()%></option>
                            <% }%>
                        </select></td>
                </tr>
                <tr>
                    <td>
                        <label align="center" for="exampleFormControlSelect1">Hora:</label>
                    </td>
                    <td>
                        <select type="text" class="form-control" id="hora" name="hora" >
                            <option>01:00</option><option>02:00</option><option>03:00</option><option>04:00</option><option>05:00</option><option>06:00</option>
                            <option selected >07:00</option><option>08:00</option><option>09:00</option><option>10:00</option><option>11:00</option><option>12:00</option>
                            <option>13:00</option><option>14:00</option><option>15:00</option><option>16:00</option><option>17:00</option><option>18:00</option>
                            <option>19:00</option><option>20:00</option><option>21:00</option><option>22:00</option><option>23:00</option><option>24:00</option>
                        </select>
                    </td>   
                </tr>
                <tr>
                    <td>Fecha:</td>
                    <td>
                        <%
                        java.time.LocalDate hoy = java.time.LocalDate.now();
                                        
                        %> 
                        <div class="form-group" align="center">
                            <input type="date" id="fecha" name="fecha" value="<%=hoy%>"
                                   min="<%=hoy%>" max="2022-12-31">
                        </div> 
                    </td>
                </tr>
                <tr>  
                    <td>
                        <br>
                        <input  type="submit" name="boton" value="Buscar cita" >
                    </td>
                </tr>
            </table><!--  -->

        </form>
                 
    </body> 
    <%@ include file = "../pagesPaciente/doctoresPorEsp.jsp" %>
</html> 
