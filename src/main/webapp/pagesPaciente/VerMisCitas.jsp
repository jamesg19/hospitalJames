<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html>     
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Ver mis citas</title>    
    </head>     
    <body background="Imagenes/fondoPaciente.jpg"> 
        <%@ page import="Controller.adminServlet" %>
        <%@ page import="Objetos.Doctor, java.util.ArrayList" %> 
        <h2>Los doctores que están registrados son: </h2> 
        <br>
        <%
        
            
            ArrayList<Doctor> doctores = null;
            doctores = (ArrayList<Doctor>) request.getAttribute("Doctor");
        
            %>

        <div>
            
        </div><!-- comment -->
         
        <br>        
            <table align="center" border="1">                  
            <tr> 
            <h5>Medicos con especialidad</h5>
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
   
    </body> 
</html> 
