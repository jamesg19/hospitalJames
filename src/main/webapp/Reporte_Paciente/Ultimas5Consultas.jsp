<%@page import="Objetos.Cita"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html>     
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Ultimas 5 citas</title>    
    </head>     
    <body background="Imagenes/fondo2.jpg"> 
        <%@ page import="Controller.adminServlet" %>
        <%@ page import="Objetos.Doctor, java.util.ArrayList" %> 
        <h2>Ultimas 5 citas realizadas: </h2> 
        <br>
        <%
            ArrayList<Cita> citas = null;
            citas = (ArrayList<Cita>) request.getAttribute("Cita");
            
            String cuentaI = (String) request.getAttribute("cuenta");   
            request.setAttribute("cuenta",cuentaI);
            %>
        <div> 
            <form action="paciente" method="post" >
            <input readonly type="text"  value='<%=cuentaI%>' Id="user" name="user" style="visibility:hidden">
            <input align="center" type="submit" name="boton" value="Inicio">
            </form>
        </div><!-- comment -->
        <br>        
            <table align="center" border="1">                  
            <tr> 
            <h5>Citas con los siguientes doctores</h5>
                <th>Medico </th>            
                <th>Especialidad</th>            
                <th>Fecha</th>            
                <th>Hora</th>           
            </tr>   
<%                  if(citas!=null){   %> 
            <script>
                
                alert('Ultimas 5 consultas y/o citas realizadas');
                
            </script>
                
<%           for (Cita cita : citas) {%>          
            <tr valign="rigth">            
                <td><%=cita.getPaciente() %></td>             
                <td><%=cita.getMedico() %></td> 
                <td><%=cita.getFecha() %></td> 
                <td><%=cita.getHora() %></td> 
            </tr>          
            <% }}
            else {%>
            <script>
                
                alert('No has realizado ninguna consulta :)');
                
            </script>
    <%}%>
    </table>
    </body> 
</html> 
