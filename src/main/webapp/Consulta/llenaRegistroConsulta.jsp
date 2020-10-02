<%@page import="Objetos.Consulta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html>     
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Listado de Especialidades</title>    
    </head>     
    <body background="Imagenes/fondoAdmin.jpg"> 
        <%@ page import="Controller.adminServlet" %>
        <%@ page import="Objetos.Especialidad, java.util.ArrayList" %> 
        <h2>Agrega consulta por especialidad </h2> 
        <h2>las especialidades de los medicos del hospital son las siguientes </h2> 
        <%ArrayList<Especialidad> especialidades = null;
            especialidades = (ArrayList<Especialidad>) request.getAttribute("Especialidad");      %>
            <div>
        <table align="center" border="1">                  
            <tr>             
                <th>Especialidades de los medicos  </th>            

            </tr> 
            <%            for (Especialidad especialidad : especialidades) {%>          
            <tr valign="rigth">            
                <td><%=especialidad.getTipo() %></td>             

            </tr>          
            <% }%>
        </table>
        </div>
        <div>
            <%ArrayList<Consulta> consultas = null;
            consultas = (ArrayList<Consulta>) request.getAttribute("Consulta");      %>
            <%ArrayList<Consulta> consultas2 = null;
            consultas2 = (ArrayList<Consulta>) request.getAttribute("Consulta2");      %>            
            <table align="center" border="1">                  
                <tr>             
                    <th>Codigo consulta </th>    
                    <th>Tipo consulta </th> 
                    <th>Costo (Q):</th> 

                </tr> 
                <%for (Consulta consulta : consultas) {%>          
                <tr valign="rigth">            
                    <td><%=consulta.getCodigo()%></td>  
                    <td><%=consulta.getTipo()%></td>  
                    <td><%=consulta.getCosto()%></td>  
                </tr>          
                <% }%>
                <h4>Para Agregar una consulta se debe de seleccionar la especialidad y agregar un costo </h4>
                <br><!-- comment --> 
            </table>
        </div>

             
        <form action="crearAdmin" method="post">
                    <br>
                 
            <table align="center" >
                <tr>
                    
                    
                    
                <td>Tipo de consulta:</td>                                  
                <td><select align="center" required type="text" Id='tipo' name="tipo" >
                    <%for (Consulta consulta2 : consultas2) {%>
                    <option><%=consulta2.getTipo()%></option>

                    <% }%>
                    </select></td>
                </tr>
                <tr>             
                    <td align="left"> Costo: </td>                
                    <td> <input align="left" required type="number" Id='costo' name="costo" step="any" > </td>           
                </tr>

                <tr>
                    <td>
                        <input  type="submit" name="boton" value="Crear Consulta"  >
                    </td>
                    
                </tr>
                    
            </table><!--  -->
            
            
        </form>
                
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>


    </body> 
</html> 
