package Model;

import static Model.ConectaBD.passw;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorBDAdmin {

    String claveUsuario;
    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    Administrador usuarioHallado;
    String codigoo, dpi, nombre, passwordd;

    public boolean registrar(String codigo, String dpi, String nombre, String password) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();

        String query = "INSERT INTO administrador VALUES (?,?,?,?)";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {


            preSt.setString(1, codigo);
            preSt.setString(2, dpi);
            preSt.setString(3, nombre);
            preSt.setString(4, password);

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
        public boolean registrarExamen(String codigo, String nombre, String orden, String descripcion,Double costo,String tipoInforme) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();

        String query = "INSERT INTO examen VALUES (?,?,?,?,?,?)";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {


            preSt.setString(1, codigo);
            preSt.setString(2, nombre);
            preSt.setString(3, orden);
            preSt.setString(4, descripcion);
            preSt.setDouble(5, costo);
            preSt.setString(6, tipoInforme);

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
        public boolean modificar(String codigo, String dpi, String nombre, String password) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();
        
        String query = "UPDATE administrador  SET dpi = ?, nombre = ?, password = ? WHERE codigo = ?";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, dpi);
            preSt.setString(2, nombre);
            preSt.setString(3, password);
            preSt.setString(4, codigo);

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

    public Administrador consultar(String codigo, String password) {
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT * FROM administrador WHERE codigo='" + codigo + "' AND password='" + password + "';");
            
            
            
            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                System.out.println("Se encontró el registro");
                codigoo = usuarioResultSet.getString("codigo");
                dpi = usuarioResultSet.getString("dpi");
                nombre = usuarioResultSet.getString("nombre");
                passwordd = usuarioResultSet.getString("password");
                usuarioHallado = new Administrador(codigoo, dpi, nombre, passwordd);
                ConectaBD.cerrar();
                return usuarioHallado;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
        public Administrador AdminU(String codigo) {
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT * FROM administrador WHERE codigo='" + codigo + "';");
            
            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                System.out.println("Se encontró el registro");
                codigoo = usuarioResultSet.getString("codigo");
                dpi = usuarioResultSet.getString("dpi");
                nombre = usuarioResultSet.getString("nombre");
                passwordd = usuarioResultSet.getString("password");
                usuarioHallado = new Administrador(codigoo, dpi, nombre, passwordd);
                ConectaBD.cerrar();
                return usuarioHallado;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public boolean borrar(String cuenta, String clave) {
        int resultUpdate = 0;
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();

            resultUpdate = stm.executeUpdate("DELETE FROM usuarios WHERE(cuenta='" + cuenta + "'and clave='" + clave + "');");

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

//    public ArrayList<Usuario> leeTodos() {
//        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
//        try {
//            conn = ConectaBD.abrir();
//            stm = conn.createStatement();
//            usuarioResultSet = stm.executeQuery("SELECT * FROM usuarios");
//            if (!usuarioResultSet.next()) {
//                System.out.println(" No se encontraron registros");
//                ConectaBD.cerrar();
//                return null;
//            } else {
//                do {
//                    cuent = usuarioResultSet.getString("cuenta");
//                    nom = usuarioResultSet.getString("nombre");
//                    passw = usuarioResultSet.getString("clave");
//                    mail = usuarioResultSet.getString("mail");
//                    usuarioHallado = new Administrador(cuent, nom, passw, mail);
//                    usuarios.add(usuarioHallado);
//                } while (usuarioResultSet.next());
//                ConectaBD.cerrar();
//                return usuarios;
//            }
//        } catch (Exception e) {
//            System.out.println("Error en la base de datos.");
//            e.printStackTrace();
//            return null;
//        }
//    }
}
