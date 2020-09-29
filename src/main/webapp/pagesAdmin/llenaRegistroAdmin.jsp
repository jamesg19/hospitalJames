<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<link rel="stylesheet" href="css/jquery.min.js"><!DOCTYPE html> 
<html>     
    <head>         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
        <title>JSP Page</title>   
        <script src="error.js" type="text/javascript" >
        </script> 
    </head>
 
    <body>

        <%@ page import="Controller.registroAdmin" %> 
                <script src="error.js" type="text/javascript" >
        </script>
        <h2> Sistema de Gestión de productos</h2>
     
        <form  action="newAdmin" name="forma" method="post">        
            <table cellspacing="3" cellpadding="3"  >          

                <td align="right"> Codigo: </td>            
                <td><input type="text" name="codigo"></td>           
                </tr>             
                <tr>             
                    <td align="right"> DPI: </td>                
                    <td> <input type="text" name="dpi"> </td>           
                </tr>           
                <tr>             
                    <td align="right"> Nombre: </td>                
                    <td> <input type="text" name="nombre"> </td>           
                </tr>  
                <tr>             
                    <td align="right"> Password: </td>                
                    <td> <input type="text" name="password"> </td>           
                </tr>
            </table>         
            <input type="reset" value="Borrar">
            <input type="submit" value="Registrar" onClic="valida(this.forma)"> 

        </form>       


    </body> 
</html>