
<%-- 
    Document   : registroGuardado
    Created on : Sep 26, 2020, 7:40:33 PM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>Modifica Pacientte</title>
    </head>
    <body background="Imagenes/fondo2.jpg">
        <%@ page import="Controller.pacienteServlet" %> 
        <%
  
            String cuentaI = (String) request.getAttribute("codigo");
            String nombreI = (String) request.getAttribute("Nombre");
            String sexo = (String) request.getAttribute("Sexo");
            String cumple = (String) request.getAttribute("Nacimiento");
            String dpi = (String) request.getAttribute("Dpi");
            String telefono = (String) request.getAttribute("Telefono");
            double peso = (double) request.getAttribute("Peso");
            String sangre = (String) request.getAttribute("Sangre");
            String correo = (String) request.getAttribute("Correo");
            String password = (String) request.getAttribute("Password");
            int m=45;
        %>

        <h2 align="center"> Tus datos son:</h2>
        <form action="paciente" method="post" >
            <div align="right" >
            <input readonly type="text"  value='<%=cuentaI%>' Id="user" name="user" style="visibility:hidden">
            <input align="center" type="submit" name="boton" value="Inicio">
            </div>
        </form>
        <p align="center"> Puedes modificarlos </p>
        <form action="paciente" method="post" >
            
            <input readonly type="text"  value='<%=cuentaI%>' Id="user" name="user" style="visibility:hidden">
            
            <table cellspacing="2" cellpadding="2" align="center"  >          
                <tr>
                <td align="left"> Codigo: </td>            
                <td><input required type="text"  value='<%=cuentaI%>' name="codigo" readonly=""> </td>           
                </tr>             
                <tr>             
                    <td align="left"> Nombre: </td>                
                    <td> <input required type="text"  value='<%=nombreI%>' name="nombre"> </td>           
                </tr>
                <tr>             
                    <td align="left"> Sexo: </td>                
                    <td> <input required type="text"  value='<%=sexo%>' name="sexo" > </td>           
                </tr>
                <tr>             
                    <td align="left"> Fecha nacimiento: </td>                
                    <td> <input required type="date" id="nacimiento" name="nacimiento" value="2020-10-10"
                       min="1900-01-01" max="2020-12-31"> </td>           
                </tr>
                <tr>             
                    <td align="left"> DPI: </td>                
                    <td> <input required type="text" value='<%=dpi%>' name="dpi"> </td>           
                </tr>  
                <tr>             
                    <td align="left"> Telefono: </td>                
                    <td> <input required type="text"  value='<%=telefono%>' name="telefono"> </td>           
                </tr>
                <tr>             
                    <td align="left"> Peso: (Kg)</td>                
                    <td> <input required type="number"  value='' Id="peso" step="any" name="peso"> </td>           
                    <td> Actual: <%=peso%> Kg</td>
                </tr>
                <tr>             
                    <td align="left"> Tipo Sangre: </td>                
                    <td> 
                
                     <select required class="form-control" Id="sangre" name="sangre">
                            <option>A+</option>
                            <option>A-</option>
                            <option>B+</option>
                            <option>B-</option>
                            <option>O+</option>
                            <option>O-</option>
                            <option>AB+</option>
                            <option>AB-</option>
                        </select>
                        
                    
                        
                    </td>
                    <td></td>
                    
                </tr>
                <tr>             
                    <td align="left"> Correo: </td>                
                    <td> <input required type="text"  value='<%=correo%>' name="correo"> </td>           
                </tr>
                <tr>             
                    <td align="left"> Password: </td>                
                    <td> <input required type="text"  value='<%=password%>' name="password"> </td>           
                </tr>


            </table>
                <div align="center">
                    <br>
            
            <input align="center" type="submit" name="boton" value="Actualizar paciente">
                </div>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
            </form>
    </body>
</html>