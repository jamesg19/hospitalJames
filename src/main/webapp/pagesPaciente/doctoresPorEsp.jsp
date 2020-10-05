<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html>     
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Agendar cita</title>    
    </head>     
    <body background="Imagenes/fondoPaciente.jpg"> 
        <%@ page import="Controller.adminServlet" %>
        <%@ page import="Objetos.Doctor, java.util.ArrayList" %> 
        <br>
        <%
            ArrayList<Doctor> doctores = null;
            doctores = (ArrayList<Doctor>) request.getAttribute("Doctor");
            ArrayList<Doctor> doctoresd = null;
            doctoresd = (ArrayList<Doctor>) request.getAttribute("Doctor");
            String cuenta=(String) request.getAttribute("cuenta");
            String especialidad=(String) request.getAttribute("especialidad");
            String hora=(String) request.getAttribute("hora");
            String fecha=(String) request.getAttribute("fecha");
            Double costo=(Double) request.getAttribute("costo");
        %>
        <div>
        </div><!-- comment -->
        <table align="center" border="1">                  
            <tr> 
            <h4>Medicos disponibles segun el tipo de cita seleccionada</h4>
            <th>Codigo </th>            
            <th>Nombre</th>            
            <th>Colegiado</th>            
            <th>Correo</th>           
            <th>Hora Inicio jornada</th> 
            <th>Hora Finaliza jornada</th>
            <th>Fecha de contratacion</th> 
            <th>Especialidad</th> 
        </tr> 
        <%        if(doctores!=null){    for (Doctor doctor : doctores) {%>          
        <tr valign="rigth">            
            <td><%=doctor.getCodigo()%></td>             
            <td><%=doctor.getNombre()%></td> 
            <td><%=doctor.getColegiado()%></td> 
            <td><%=doctor.getCorreo() %></td> 
            <td><%=doctor.getHoraInicio()%></td> 
            <td><%=doctor.getHoraFin()%></td>
            <td><%=doctor.getFechaTrabajo()%></td>
            <td><%=doctor.getEspecialidad()%></td>
        </tr>          
        <% }}%>
    </table>
    <form action="paciente" method="post" >
        <table>
            <tr>
                <td>
                    Selecciona el codigo del medico para tu cita
                </td>
            </tr>
            <tr>
                <td>Codigo del medico:</td>                                  
                <td><select align="center" required type="text" Id='medico' name="medico" >
                        <%if(doctoresd!=null){for (Doctor doctorr : doctoresd) {%>
                        <option><%=doctorr.getCodigo() %></option>
                        <% }}%>
                    </select></td>
            </tr>
            <% if(especialidad!= null && hora!=null && fecha!= null && cuenta!= null && costo != null){%>
            <tr>
                <td>
                    Costo (Q):
                </td>
                <td>
                    <input type="text" Id="costo" name="costo" value="<%=costo%>"readonly >
                </td>
            </tr>
            <tr>
                <td>Mi codigo Paciente</td><!-- comment -->
                <td><input  type="text" Id="paciente" name="paciente" value="<%=cuenta%>" readonly ></td><!-- comment -->
            </tr>
            <tr>
                <td>Tipo de consulta:</td>                                  
                <td>
                    <input type="text" Id="especialidad" name="especialidad" value="<%=especialidad%>"readonly >
                </td>
            </tr>
            <tr>
                <td>
                    <label align="center" for="exampleFormControlSelect1">Hora:</label>
                </td>
                <td>
                    <input type="text" Id="hora" name="hora" value="<%=hora%>" readonly >
                </td>   
            </tr>
            <tr>
                <td>Fecha:</td>
                <td>

                    <div class="form-group" align="center">
                        <input type="text" id="fecha" name="fecha" value="<%=fecha%>">
                    </div> 
                </td>
            </tr>
            <%}%>
            <tr>  
                <td>
                    <br>
                    <input  type="submit" name="boton" value="Agregar mi cita" >
                </td>
            </tr>

        </table>
        <br>
        <br>  
        <br>
        <br> 
        <br>
    </form>
</body> 
</html> 
