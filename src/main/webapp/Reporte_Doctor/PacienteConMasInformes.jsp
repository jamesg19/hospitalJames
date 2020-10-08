<%@page import="Objetos.Informe"%>
<%@page import="Objetos.Cita"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html>     
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Mas Informes</title>    
    </head>     
    <body background="Imagenes/fondo3.jpg"> 
        <%@ page import="Controller.doctorServlet" %>
        <%@ page import="Objetos.Doctor, java.util.ArrayList" %> 
        <h2>Citas programadas: </h2> 
        <br>
        <%
            ArrayList<Informe> informes = null;
            informes = (ArrayList<Informe>) request.getAttribute("Informe");
            
            String cuentaII = (String) request.getAttribute("cuenta");   
            request.setAttribute("cuenta",cuentaII);
            %>
        <div align="right" > 
            <form action="ReporteDoctor" method="post" >
            <input readonly type="text"  value='<%=cuentaII%>' Id="user" name="user" style="visibility:hidden">
            <input align="center" type="submit" name="boton" value="Inicio" style="visibility:hidden">
            </form>
        </div>
        <br>        
            <table align="center" border="1">                  
            <tr> 
            <h5>Pacientes con mas informes</h5>
                <th>ID paciente</th>            
                <th>Nombre</th>            
                <th>Total de informes</th>                      
            </tr>   
<%                  if(informes!=null){   %> 
            <script>
                
                alert('Pacientes con mas informes');
                
            </script>
                
<%           for (Informe informe : informes) {%>          
            <tr valign="rigth">            
                <td><%=informe.getCodigo() %></td>             
                <td><%=informe.getPaciente() %></td> 
                <td><%=informe.getFecha() %></td> 

            </tr>          
            <% }}
            else {%>
            <script>
                
                alert('No hay registros de informes');
                
            </script>
    <%}%>
    </table>
    </body> 
</html> 
