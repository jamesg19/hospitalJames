<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html>     
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Listado de Examenes</title>    
    </head>     
    <body background="Imagenes/fondoAdmin.jpg"> 
        <%@ page import="Controller.adminServlet" %>
        <%@ page import="Objetos.Examenes, java.util.ArrayList" %> 
        <h2>Cambiar precio de examenes </h2> 
        <br>
        <h2>Los examenes que están registrados son: </h2> 
        <br>
        <%ArrayList<Examenes> examenes = null;
            examenes = (ArrayList<Examenes>) request.getAttribute("Examenes");      %>

        <table align="center" border="1">                  
            <tr>             
                <th>Codigo </th>            
                <th>Nombre</th>            
                <th>Orden</th>            
                <th>Descripcion</th>           
                <th>Costo</th>            
                <th>Tipo Informe</th> 
            </tr> 
            <%            for (Examenes examen : examenes) {%>          
            <tr valign="rigth">            
                <td><%=examen.getCodigo() %></td>             
                <td><%=examen.getNombre()%></td>             
                <td><%=examen.getOrden() %></td>             
                <td><%=examen.getDescripcion() %></td>  
                <td><%=examen.getCosto() %></td> 
                <td><%=examen.getFormatoPDF()%></td> 
            </tr>          
            <% }%>         
        </table>
        <h4>Para cambiar el precio debes de buscar el codigo y luego ingresa el nuevo precio </h4> 
        <br>
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
