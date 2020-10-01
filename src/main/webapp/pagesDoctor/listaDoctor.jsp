<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html>     
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Listado de Doctores</title>    
    </head>     
    <body background="Imagenes/fondoAdmin.jpg"> 
        <%@ page import="Controller.adminServlet" %>
        <%@ page import="Objetos.Doctor, java.util.ArrayList" %> 
        <h2>Los doctores que están registrados son: </h2> 
        <br>
        <%ArrayList<Doctor> doctores = null;
            doctores = (ArrayList<Doctor>) request.getAttribute("Doctor");      %>

        <%ArrayList<Doctor> doctores2 = null;
            doctores2 = (ArrayList<Doctor>) request.getAttribute("Doctor2");      %>
                <div>

        </div><!-- comment -->
         
        <br>        
            <table align="center" border="1">                  
            <tr> 
            <h5>Medicos con especialidad</h5>
                <th>Codigo </th>            
                <th>Nombre</th>            
                <th>Colegiado</th>            
                <th>Correo</th>           
                <th>Hora Inicio jornada</th> 
                <th>Hora Finaliza jornada</th>
                <th>Fecha de contratacion</th> 
                <th>Especialidad</th> 
            </tr> 
            <%            for (Doctor doctor : doctores) {%>          
            <tr valign="rigth">            
                <td><%=doctor.getCodigo()%></td>             
                <td><%=doctor.getNombre()%></td> 
                <td><%=doctor.getColegiado()%></td> 
                <td><%=doctor.getCorreo() %></td> 
                <td><%=doctor.getHoraInicio()%></td> 
                <td><%=doctor.getHoraFin()%></td>
                <td><%=doctor.getFechaTrabajo()%></td>
                <td><%=doctor.getEspecialidad()%></td>

            </tr>          
            <% }%>



        </table>

        <form action="crearAdmin" method="post">
            <table align="left">
                <br>
                <h4>Ingresa el codigo del medico y su especialidad a agregar </h4>
                <td align="right"> Codigo del doctor: </td>            
                <td><input required type="text" Id='codigo' name="codigo"></td>           
                </tr>             
                <tr>             
                    <td align="right"> Especialidad </td>                
                    <td> <input required type="text" Id='especialidad' name="especialidad"  > </td>           
                </tr>

                <input type="submit" name="boton" value="Agrega Nueva Especialidad"  >


            </table><!--  -->

        </form>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
    </body> 
</html> 
