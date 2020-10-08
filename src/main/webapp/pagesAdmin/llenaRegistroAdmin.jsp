<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>     
    <head>         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
        <title>JSP Page</title> 
        <link rel="stylesheet"
              href="CSS/Estilo.css">
        <link rel="stylesheet"
              href="CSS/Letra.css">
        <link rel="stylesheet"
              href="CSS/botones.css">
        <%
            String nombreI = (String) request.getAttribute("nombre");
            String cuentaI = (String) request.getAttribute("cuenta");
            request.setAttribute("nombre",nombreI);
            request.setAttribute("cuenta",cuentaI);
        %>        
    </head>

    <body  background="Imagenes/fondoAdmin.jpg">
        <script>             
            function valida(form) {            
                if(document.forma.codigo.value ===''){
                    alert("falta introducir el codigo"),
                    form.cancelFormSubmission();
                    
            }else{                 
                    if(document.forma.dpi.value ===''){ 
                        alert("falta introducir el dpi"),
                        form.cancelFormSubmission();
                }else{
                        if(document.forma.nombre.value ===''){
                            form.cancelFormSubmission(),
                            alert("falta introducir el nombre");       
                    }else{ 
                            if(document.forma.password.value ===''){
                                form.cancelFormSubmission(),
                                alert("falta introducir el password");
                            
                        }else{ 
                                alert("Informacion enviada");
                                form.submit();
                        }
                    }
                }          
            }
        }
        </script>
        <%@ page import="Controller.adminServlet" %>

        <br>
        
        <form action="crearAdmin" method="post" >
            <div align="right" >
                <input type="submit" value="Inicio"  name="boton" >
                
            </div>
            
            <input type="text" value="<%=cuentaI%>" Id='cuentaI' name="cuentaI" style="visibility:hidden" >
            <input type="text" value="<%=nombreI%>" Id='nombreI' name="nombreI" style="visibility:hidden" >

        </form>
        <h2 align="center"> Agrega un nuevo administrador</h2>
        <form  action="crearAdmin" name="forma" method="post">


            <table cellspacing="3" cellpadding="3" align="center"  >          

                <td align="right"> Codigo: </td>            
                <td><input required type="text" Id='codigo' name="codigo"></td>           
                </tr>             
                <tr>             
                    <td align="right"> DPI: </td>                
                    <td> <input required type="text" Id='dpi' name="dpi"  > </td>           
                </tr>           
                <tr>             
                    <td align="right"> Nombre: </td>                
                    <td> <input required type="text" Id='nombre' name="nombre"> </td>           
                </tr>  
                <tr>             
                    <td align="right"> Password: </td>                
                    <td> <input required type="text" Id='password' name="password"> </td>           
                </tr>


            </table>
            <div align="center" >
                <input class="btn btn--4" type="submit" name="boton" value="Registrar Admin" onClick='valida(forma)' >
                <input  class="btn btn--4" type="reset" value="Borrar">
            </div>

        </form>


    </body> 
</html>