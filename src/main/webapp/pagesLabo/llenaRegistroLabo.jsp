
<%@page import="java.util.ArrayList"%>
<%@page import="Objetos.Examenes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>     
    <head>         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
        <title>Registra Laboratorista</title> 
<%          ArrayList<Examenes> examenes = null;
            examenes = (ArrayList<Examenes>) request.getAttribute("Examenes");      
            
            String nombreI = (String) request.getAttribute("nombre");
            String cuentaI = (String) request.getAttribute("cuenta");
            request.setAttribute("nombre",nombreI);
            request.setAttribute("cuenta",cuentaI);

            
%> 
    </head>

    <body  background="Imagenes/fondoAdmin.jpg">

        <%@ page import="Controller.adminServlet" %>
        <form action="crearAdmin" method="post" >
            <div align="right" >
                <input type="submit" value="Inicio"  name="boton" >
                
            </div>
            
            <input type="text" value="<%=cuentaI%>" Id='cuentaI' name="cuentaI" style="visibility:hidden" >
            <input type="text" value="<%=nombreI%>" Id='nombreI' name="nombreI" style="visibility:hidden" >

        </form>

        <h3 align="center"> Agrega un nuevo Laboratorista</h3>
        <form  action="crearAdmin" name="forma" method="post">

            <table cellspacing="3" cellpadding="3" align="center"  >

                <tr>
                    <td align="right"> Codigo: </td>
                    <td><input type="text" Id='codigo' name="codigo" required></td>
                </tr>

                <tr>
                    <td align="right"> Nombre: </td>
                    <td> <input type="text" Id='nombre' name="nombre" required > </td>
                </tr>
                <div>
                    <tr>
                        <td align="right"> Registro: </td>
                        <td> <input type="text" Id='registro'  name="registro"  required > </td>
                    </tr>
                    <tr>
                        <td align="right"> DPI: </td>
                        <td> <input type="text" Id='dpi'  name="dpi"  required > </td>
                    </tr>
                    <tr>
                        <td align="right"> Telefono: </td>
                        <td> <input type="text" Id='telefono'  name="telefono"  required > </td>
                    </tr>
                    
                    
                    
                <tr>
 
                <td>Tipo de examen:</td>                                  
                <td><select align="center" required type="text" Id='tipo' name="tipo" >
                    <%for (Examenes examen : examenes) {%>
                    <option><%=examen.getNombre()%></option>

                    <% }%>
                    </select></td>
                </tr>
    
                
                
                
                
                
                

                
                
                
                
                
                
                
                
                <tr>
                        <td align="right"> Correo: </td>
                        <td> <input type="email" Id='correo'  name="correo"  required > </td>
                    </tr>
                    <tr>
                        <td align="right"> Dias trabajo: </td>
                        <td> <select name="diasTrabajo" multiple>
                                <option selected>Lunes, </option>
                                <option>Martes, </option>
                                <option>Miercoles, </option>
                                <option>Jueves, </option>
                                <option>Viernes, </option>
                                <option>Sabado, </option>
                                <option>Domingo, </option>
                            </select> </td>
                    </tr>

                    <tr>
                        <td align="right"> Password</td>
                        <td> <input type="text" Id='password'  name="password"  required > </td>
                    </tr>

            </table>

            <div class="form-group" align="center">
                <td align="right"> Trabaja desde: </td>
                <input type="date" id="start" name="trabajo" value="2020-03-19"
                       min="1980-01-01" max="2020-12-31" required>
            </div>

            <div align="center">

            </div>
            <div align="center">
                <input  align="center" type="reset" value="Borrar">

                <input align="center" type="submit" name="boton" value="Registrar Laboratorista"  >
            </div>
        </form>

    </body> 
</html>