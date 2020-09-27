/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaBD {
public static Connection con=null;
private static String bd = "sistemalogin";
public static String usuario = "root";
public static String passw = "Guatemala13.";
//public static String url = "jdbc:mysql://localhost/"+bd+"?useTimezona=true&serverTimezone=CST";
public static String url="jdbc:mysql://localhost:3306/sistemalogin?useTimezona=true&serverTimezone=CST";

public static Connection abrir(){
try{
Class.forName("com.mysql.cj.jdbc.Driver");

con = DriverManager.getConnection(url,usuario,passw);
System.out.println("Conexión exitosa:"+con);

} catch (Exception e) {
System.out.println("Error en la conexion...");
e.printStackTrace();
return null;
}
return con;
}

public static void cerrar(){
try{
if(con != null)
con.close();
} catch (Exception e){
System.out.println("Error: No se logro cerrarla conexion:\n"+e);
}
}


}
