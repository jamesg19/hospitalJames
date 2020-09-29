<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>     
    <head>         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
        <title>JSP Page</title> 

    </head>

    <body  background="Imagenes/fondoAdmin.jpg">
        <script>             
            function valida(form) {            
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
        <%@ page import="Controller.registroAdmin" %> 

        <h2 align="center"> Agrega un nuevo administrador</h2>
        <form  action="newAdmin" name="forma" method="post">

 
            <table cellspacing="3" cellpadding="3" align="center"  >          

                <td align="right"> Codigo: </td>            
                <td><input type="text" Id='codigo' name="codigo"></td>           
                </tr>             
                <tr>             
                    <td align="right"> DPI: </td>                
                    <td> <input type="text" Id='dpi' name="dpi"> </td>           
                </tr>           
                <tr>             
                    <td align="right"> Nombre: </td>                
                    <td> <input type="text" Id='nombre' name="nombre"> </td>           
                </tr>  
                <tr>             
                    <td align="right"> Password: </td>                
                    <td> <input type="text" Id='password' name="password"> </td>           
                </tr>


            </table> 
             <div>
                <input type="reset" value="Borrar">
                <input type="button" value="Registrar" onClick='valida(forma)' >
            </div>
        </form>

            
    </body> 
</html>