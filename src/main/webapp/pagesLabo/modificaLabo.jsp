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
        <title>JSP Page</title>
    </head>
    <body background="Imagenes/fondoAdmin.jpg">
        <script>             
    function validaAd(form) {            
        if(document.forma.codigo.value ==='')                  
            alert("falta introducir el codigo");              
        else{                 
            if(document.forma.dpi.value ==='')   
                alert("falta introducir el dpi");                  
            else{
                if(document.forma.nombre.value ==='')   
                    alert("falta introducir el nombre");  
                else{ 
                    if(document.forma.password.value ==='')   
                        alert("falta introducir el password");  
                    else 
                        form.submit();
                }
            }
        }          
    }      
        </script>
        <%@ page import="Controller.adminServlet" %> 
        <%
            String nombreI = (String) request.getAttribute("Nombre");
            String cuentaI = (String) request.getAttribute("cuenta");
            String dpi = (String) request.getAttribute("Dpi");
            String name = (String) request.getAttribute("Password");
        %>
        <br>
        <h2 align="center"> Modifica un laboratorista:</h2>
        <br>      
        <br>
        <p align="center"> Los laboratoristas registrados son: </p>
        <form action="crearAdmin">
            <table cellspacing="3" cellpadding="3" align="center"  >          

                <td align="right"> Codigo: </td>            
                <td><input required type="text"  value='<%=cuentaI%>' name="codigo" readonly=""> </td>           
                </tr>             
                <tr>             
                    <td align="right"> DPI: </td>                
                    <td> <input required type="text"  value='<%=dpi%>' name="dpi"> </td>           
                </tr>           
                <tr>             
                    <td align="right"> Nombre: </td>                
                    <td> <input required type="text" value='<%=nombreI%>' name="nombre"> </td>           
                </tr>  
                <tr>             
                    <td align="right"> Password: </td>                
                    <td> <input required type="text"  value='<%=name%>' name="password"> </td>           
                </tr>
                <br><!-- comment -->
                <br><!-- comment -->
                

            </table>
                <div align="center">
            
            <input align="center" type="submit" name="boton" value="Actualizar Admin" onClick='validaAd(forma)' >
                </div>
            </form>
    </body>
</html>