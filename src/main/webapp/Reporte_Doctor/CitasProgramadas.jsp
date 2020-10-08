<%@page import="Objetos.CitaMedico"%>
<%@page import="Objetos.Cita"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html>     
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Ver mis citas</title> 
        <%
            ArrayList<CitaMedico> citas = null;
            citas = (ArrayList<CitaMedico>) request.getAttribute("Cita");
            
            String cuentaI = (String) request.getAttribute("cuenta");   
            request.setAttribute("cuenta",cuentaI);
            
            String pacientee = (String) request.getAttribute("paciente");
            request.setAttribute("paciente", pacientee);
            
            String estado = (String) request.getAttribute("estado");
            String correoP = (String) request.getAttribute("correoP");
            String nombreP = (String) request.getAttribute("nombreP");
            String codigoP = (String) request.getAttribute("codigoP");
            String especialidadP = (String) request.getAttribute("especialidadP");
            request.setAttribute("correoP", correoP);
            request.setAttribute("nombreP", nombreP);
            request.setAttribute("codigoP", codigoP);
            request.setAttribute("especialidadP", especialidadP);
        %>
    </head>  
    <body background="Imagenes/fondo3.jpg"> 
        <%@ page import="Controller.adminServlet" %>
        <%@ page import="Objetos.*, java.util.ArrayList" %>       
        <% if(estado.equals("TRUE")){ %>
        <script>
            alert('Se ha registrado el informe y se ha enviado el email');
            <%}%>
        </script>
        <h2>Citas programadas para el transcurso del dia </h2> 
        <div align="center" > 
            <form action="doctor" method="post" >
                <div align="right" >
            <input readonly type="text"  value='<%=cuentaI%>' Id="user" name="user" style="visibility:hidden">
            <input align="center" type="submit" name="boton" value="Inicio">
                </div>
            </form>
        </div><!-- comment -->
        <br>
            <%
                java.time.LocalDate today = java.time.LocalDate.now();          
            %>         
            <table align="center" border="1">                  
            <tr> 
            <h5 align="center" >Citas con los siguientes pacientes para el dia de HOY <%=today%></h5>
                <th>ID</th>
                <th>Nombre</th>            
                <th>Sexo</th>            
                <th>Nacimiento</th>            
                <th>Telefono</th> 
                <th>Tipo Sangre</th>  
                <th>Correo</th> 
                <th>Consulta de</th> 
                <th>Fecha</th> 
                <th>Hora</th> 
            </tr>   
<%                  if(citas!=null){   %> 
                
<%           for (CitaMedico cita : citas) {%>          
            <tr valign="rigth">  
                <td><%=cita.getCodigo()%></td>
                <td><%=cita.getNombre()%></td>             
                <td><%=cita.getSexo()%></td> 
                <td><%=cita.getNacimiento()%></td> 
                <td><%=cita.getTelefono()%></td> 
                <td><%=cita.getSangre()%></td>
                <td><%=cita.getCorreo()%></td>
                <td><%=cita.getEspecialidad()%></td>
                <td><%=cita.getFecha()%></td>
                <td><%=cita.getHora()%></td>
            </tr>          
            <% }}
            else {%>
            <script>                
                alert('No tienes citas programadas para hoy...');               
            </script>
    <%}%>
    
    
    </table>

                    
    </body>
    
</html> 
