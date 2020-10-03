<%-- 
    Document   : llenaRegistroPaciente
    Created on : Oct 2, 2020, 2:23:50 AM
    Author     : james
--%>

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
        <%@ page import="Controller.pacienteServlet" %>

        <h2 align="center"> Registrate como nuevo paciente</h2>
        <form  action="paciente" name="forma" method="post">


            <table cellspacing="3" cellpadding="3" align="center"  >          

                <td align="right"> Usuario: </td>            
                <td><input required type="text" Id='codigo' name="codigo"></td>           
                </tr>             
                <tr>             
                    <td align="right"> Nombres: </td>                
                    <td> <input required type="text" Id='nombre' name="nombre"  > </td>           
                </tr>           
                <tr>             
                    <td align="right"> Sexo: </td>                
                    <td> <select class="form-control" name="sexo" Id="sexo" >
                            <option>Masculino</option>
                            <option>Femenino</option>
                        </select> 
                    </td>           
                </tr>  
                <tr>             
                    <td align="right"> Fecha nacimiento: </td>                
                    <td> <input type="date" id="cumple" name="cumple" value="2020-03-19"
                       min="1980-01-01" max="2020-12-31"> </td>           
                </tr>
                <tr>             
                    <td align="right"> DPI </td>                
                    <td> <input required type="number" Id='dpi' name="dpi"  > </td>           
                </tr>           
                <tr>             
                    <td align="right"> Telefono: </td>                
                    <td> <input required type="number" Id='telefono' name="telefono"> </td>           
                </tr>
                <tr>             
                    <td align="right"> Sangre: </td>                
                    <td> <select class="form-control" Id="sangre" name="sangre">
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
                </tr>
                <tr>             
                    <td align="right"> Peso </td>                
                    <td> <input required type="number" step="any" Id='peso' name="peso"> </td>           
                </tr>
                <tr>             
                    <td align="right"> correo </td>                
                    <td> <input required type="text" Id='correo' name="correo"> </td>           
                </tr>  
                <tr>             
                    <td align="right"> Password </td>                
                    <td> <input required type="password" Id='password' name="password"> </td>           
                </tr>


            </table> 
                            <div align="center" >
                    <input type="reset" value="Borrar">

                    <input type="submit" name="boton" value="Registrarme como paciente" >
                </div>

        </form>


    </body> 
</html>