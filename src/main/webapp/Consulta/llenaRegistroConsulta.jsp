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
        <br>
        <h2>las especialidades de los medicos del hospital son las siguientes </h2> 
        <br>
        <%ArrayList<Especialidad> especialidades = null;
            especialidades = (ArrayList<Especialidad>) request.getAttribute("Especialidad");      %>

        <%ArrayList<Consulta> consultas = null;
            consultas = (ArrayList<Consulta>) request.getAttribute("Consulta");      %>
        <table align="center" border="1">                  
            <tr>             
                <th>Especialidades de los medicos  </th>            

            </tr> 
            <%            for (Especialidad especialidad : especialidades) {%>          
            <tr valign="rigth">            
                <td><%=especialidad.getTipo() %></td>             

            </tr>          
            <% }%>
            <br><!-- comment --> 
        </table>
        <h4>Para Agregar una consulta se debe de seleccionar que especialidad y agregar un costo </h4> 
        <br>
        <div>
            <%            for (Consulta consulta : consultas) {%>          
            <tr valign="rigth">            
                <td><%=consulta.getTipo() %></td>             

            </tr>          
            <% }%>
        </div>


        <form action="crearAdmin" method="post">
            <table align="left">
                <td align="right"> Codigo: </td>            
                <td><input required type="text" Id='codigo' name="codigo"></td>           
                </tr>             
                <tr>             
                    <td align="right"> Precio: </td>                
                    <td> <input required type="number" Id='costo' name="costo" step="any" > </td>           
                </tr>

                <input type="submit" name="boton" value="Modificar precio examen"  >


            </table><!--  -->

        </form>


    </body> 
</html> 
