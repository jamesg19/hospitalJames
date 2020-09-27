<%-- 
    Document   : index
    Created on : Sep 26, 2020, 7:26:20 PM
    Author     : james
--%>

<%@ page import="Controller.login" %>

<title>Ingreso al sistema</title>
<h1></h1> 
<h1></h1>
<h1></h1>
<h1></h1> 
<h1></h1>
<h1></h1>
<h2 align="center" > Ingresa al portal de Hospital USAC </h2>
<h1></h1>
<form >
<h2></h2>
<h2></h2>
<h3 align="center" > Introduce tu IDf y tu contraseña</h3>
  <div class="form-group" align="center">
    <label  for="exampleInputEmail1" >Email address</label>
    <input type="text" align="center" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
    <small id="emailHelp" class="form-text text-muted"></small>
  </div>
  <div class="form-group" align="center">
    <label for="exampleInputPassword1" >Password</label>
    <input type="password" align="center"  class="form-control" id="exampleInputPassword1" placeholder="Password:   ">
  </div>
</form>



<input type="reset" value="Borrar">
<input type="submit" value="Ingresar">
<form action="login" method="post" >

</form>
<form action="llenaRegistro.jsp" method="post">
    <input type="submit" value="Registrar">
</form>



