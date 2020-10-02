package Model;

import static Model.ConectaBD.passw;
import Objetos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Gestor de base de datos del administrador que maneja todas las acciones o
 * consultas del mismo
 *
 * @author james
 */
public class GestorBDPaciente {

    String claveUsuario;
    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    Paciente usuarioHallado;
    String codigo, nombre;

    /**
     * registra un nuevo administrador al sistema
     *
     * @param codigo
     * @param dpi
     * @param nombre
     * @param password
     * @return
     */
    public boolean registrarPaciente(String codigo, String nombre, String sexo, String cumple,String dpi,String tel,
            double peso, String sangre, String correo, String password) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();

        String query = "INSERT INTO paciente VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, codigo);
            preSt.setString(2, nombre);
            preSt.setString(3, sexo);
            preSt.setString(4, cumple);
            preSt.setString(5, dpi);
            preSt.setString(6, tel);
            preSt.setDouble(7, peso);
            preSt.setString(8, sangre);
            preSt.setString(9, correo);
            preSt.setString(10, password);

            resultUpdate = preSt.executeUpdate();

            if (resultUpdate != 0) {
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return false;
        }
    }
    
    
        /**
         * 
         * @param codigo
         * @param password
         * @return 
         */
    
        public Paciente consultar(String codigo, String password) {
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT * FROM paciente WHERE codigo='" + codigo + "' AND password='" + password + "';");

            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                System.out.println("Se encontró el registro");
                codigo = usuarioResultSet.getString("codigo");
                nombre = usuarioResultSet.getString("nombre");
                
                usuarioHallado = new Paciente(codigo, nombre);
                ConectaBD.cerrar();
                return usuarioHallado;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    
    
    

  
}
