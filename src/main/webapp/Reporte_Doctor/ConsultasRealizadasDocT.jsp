<%@page import="Objetos.Cita"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html>     
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Reporte 2</title>    
    </head>     
    <body background="Imagenes/fondo3.jpg"> 
        <%@ page import="Controller.pacienteServlet" %>
        <%@ page import="Objetos.Doctor, java.util.ArrayList" %> 
        <br>
        <br>
        <br>
        <h2>Consultas realizadas con un doctor especifico en un intervalo de tiempo </h2> 
        <br>
        <%
            ArrayList<Cita> citas = null;
            citas = (ArrayList<Cita>) request.getAttribute("Cita");
            
            String cuentaII = (String) request.getAttribute("cuenta");   
            request.setAttribute("cuenta",cuentaII);
            %>
        <div> 
            <form action="paciente" method="post" >
            <input readonly type="text"  value='<%=cuentaII%>' Id="user" name="user" style="visibility:hidden">
            
            </form>
        </div><!-- comment -->
        <br>        
            <table align="center" border="1">                  
            <tr> 
            <h5>Citas realizadas</h5>
                <th>Medico </th>            
                <th>Especialidad</th>            
                <th>Fecha</th>            
                <th>Hora</th>           
            </tr>   
<%                  if(citas!=null){   %> 
            <script>               
                alert('Citas en un intervalo de tiempo');
                
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
                
                alert('No se encontraron resultados :)');
                
            </script>
    <%}%>
    </table>
    <br><!-- comment -->
    <br>
    <br>
    <br>
    <br>
    </body> 
</html> 
