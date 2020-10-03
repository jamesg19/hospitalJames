<%-- 
    Document   : buscarMedico
    Created on : Oct 2, 2020, 9:43:31 PM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form action="paciente" name="boton" method="post" >
                <input type="submit" name="boton" value="Pagina de Inicio"  >
            </form> 
        </div>
        
        
        <div>
        <form action="paciente" method="get">
            <table align="left">
                
                <tr>
                <br>
                <h4>Busca un doctor adecuado </h4>
                <td align="right">Ingresa busqueda </td>            
                <td><input required type="text" Id='busqueda' name="busqueda"></td>           
                </tr>             
                <tr>
                <div class="form-check form-check-inline" align="center">
                    <input class="form-check-input" required type="radio" name="inlineRadioOptions" id="inlineRadio1" value="nombre">
                    <label class="form-check-label"  for="inlineRadio1">Por nombre</label>

                    <input class="form-check-input" required type="radio" name="inlineRadioOptions" id="inlineRadio2" value="especialidad">
                    <label class="form-check-label"  for="inlineRadio2">Por especialidad</label>
                </div>
                </tr>

                <input type="submit" name="boton" value="Busca doctor"  >
                


            </table><!--  -->

        </form>
        </div>

    </body>
    <%@ include file = "../pagesPaciente/doctores.jsp" %>
</html>
