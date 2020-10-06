package Model;

import static Model.ConectaBD.passw;
import Objetos.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import javax.sql.rowset.serial.SerialBlob;
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
    Doctor doctorHallado;
    Consulta consultaHallada;
    Cita citaHallada;
    String nom,tipE,fecha,hora;
    String codigoP,nombreP,sexoP,nacimientoP,dpiP,telP,sangreP,correoP,passP;
    double pesoP;
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
        
        
        
    /**
     * Array List 
     *Busca un doctor por nombre incluyendo especialidad
     * @return
     */
    public ArrayList<Doctor> leeTodosDoctorNombre(String nombre) {
        ArrayList<Doctor> doctores = new ArrayList<Doctor>();
        try {

            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT distinctrow d.codigo, d.nombre,d.colegiado,d.correo,d.hora_inicio,hora_fin, d.trabajo,e.tipo_Especialidad FROM doctor d INNER JOIN especialidad e ON d.codigo = e.id_doctor WHERE d.nombre LIKE '%"+nombre+"%';");
            if (!usuarioResultSet.next()) {

                System.out.println(" No se encontraron registros");
                ConectaBD.cerrar();
                return doctores;
            } else {
                do {
                    String codigoD = usuarioResultSet.getString("codigo");
                    String nombreD = usuarioResultSet.getString("nombre");
                    String colegiadoD = usuarioResultSet.getString("colegiado");
                    String correoD = usuarioResultSet.getString("correo");
                    String horaInicioD = usuarioResultSet.getString("hora_inicio");
                    String horaFinD = usuarioResultSet.getString("hora_fin");
                    String trabajoD = usuarioResultSet.getString("trabajo");
                    String especialidadD = usuarioResultSet.getString("tipo_Especialidad");

                    doctorHallado = new Doctor(codigoD, nombreD, colegiadoD, correoD, horaInicioD, horaFinD, trabajoD, especialidadD);
                    doctores.add(doctorHallado);
                } while (usuarioResultSet.next());
                ConectaBD.cerrar();
                return doctores;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
        /**
         * Busca todos los doctores segun la especialidad que busquen
         * @param nombre
         * @return 
         */
        public ArrayList<Doctor> leeTodosDoctorEspecialidad(String nombre) {
        ArrayList<Doctor> doctores = new ArrayList<Doctor>();
        try {

            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT distinctrow d.codigo, d.nombre,d.colegiado,d.correo,d.hora_inicio,hora_fin, d.trabajo,e.tipo_Especialidad FROM doctor d INNER JOIN especialidad e ON d.codigo = e.id_doctor WHERE e.tipo_Especialidad LIKE '%"+nombre+"%';");
            if (!usuarioResultSet.next()) {

                System.out.println(" No se encontraron registros");
                ConectaBD.cerrar();
                return doctores;
            } else {
                do {
                    String codigoD = usuarioResultSet.getString("codigo");
                    String nombreD = usuarioResultSet.getString("nombre");
                    String colegiadoD = usuarioResultSet.getString("colegiado");
                    String correoD = usuarioResultSet.getString("correo");
                    String horaInicioD = usuarioResultSet.getString("hora_inicio");
                    String horaFinD = usuarioResultSet.getString("hora_fin");
                    String trabajoD = usuarioResultSet.getString("trabajo");
                    String especialidadD = usuarioResultSet.getString("tipo_Especialidad");

                    doctorHallado = new Doctor(codigoD, nombreD, colegiadoD, correoD, horaInicioD, horaFinD, trabajoD, especialidadD);
                    doctores.add(doctorHallado);
                } while (usuarioResultSet.next());
                ConectaBD.cerrar();
                return doctores;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Lee todos los doctores segun la especialidad y horario de atencion
     * @param nombre
     * @return 
     */    
    public ArrayList<Doctor> leeDoctorEspFecha(String nombre,String hora) {
        ArrayList<Doctor> doctores = new ArrayList<Doctor>();
        try {

            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT distinctrow d.codigo, d.nombre,d.colegiado,d.correo,d.hora_inicio,hora_fin, d.trabajo,e.tipo_Especialidad FROM doctor d INNER JOIN especialidad e ON d.codigo = e.id_doctor WHERE e.tipo_Especialidad LIKE '%"+nombre+"%' AND '"+hora+":01' BETWEEN d.hora_inicio AND d.hora_fin;");
            if (!usuarioResultSet.next()) {

                System.out.println(" No se encontraron registros");
                ConectaBD.cerrar();
                return doctores;
            } else {
                do {
                    String codigoD = usuarioResultSet.getString("codigo");
                    String nombreD = usuarioResultSet.getString("nombre");
                    String colegiadoD = usuarioResultSet.getString("colegiado");
                    String correoD = usuarioResultSet.getString("correo");
                    String horaInicioD = usuarioResultSet.getString("hora_inicio");
                    String horaFinD = usuarioResultSet.getString("hora_fin");
                    String trabajoD = usuarioResultSet.getString("trabajo");
                    String especialidadD = usuarioResultSet.getString("tipo_Especialidad");

                    doctorHallado = new Doctor(codigoD, nombreD, colegiadoD, correoD, horaInicioD, horaFinD, trabajoD, especialidadD);
                    doctores.add(doctorHallado);
                } while (usuarioResultSet.next());
                ConectaBD.cerrar();
                return doctores;
            }
        } catch (Exception e) {
        
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return doctores;
        }
    }
    

        /**
         * Agregar cita del paciente
         * @param codigo
         * @param especialidad
         * @return 
         */
        public boolean registrarCita(String paciente, String medico,String especialidad, String fecha, String hora) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();

        String query = "INSERT INTO cita VALUES (?,?,?,?,?)";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {
            

            preSt.setString(1, paciente);
            preSt.setString(2, medico);
            preSt.setString(3, especialidad);
            preSt.setString(4, fecha);
            preSt.setString(5, hora);

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
        
        
        
        public Consulta consultarPrecioCita(String tipo) {
            String password="james";
//            byte[] encodedBytes = Base64.encodeBase64(password.getBytes());
//            Blob blob = new SerialBlob(encodedBytes);
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT costo FROM consulta WHERE tipo_consulta ='" + tipo.trim() + "';");

            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return consultaHallada;
            } else {
                System.out.println("Se encontró el registro");
                double COSTO = usuarioResultSet.getDouble("costo");
                
                
                consultaHallada = new Consulta(COSTO);
                ConectaBD.cerrar();
                return consultaHallada;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return consultaHallada;
        }
    }
    //Ver citas

        public ArrayList<Cita> leeCita(String paciente) {
        ArrayList<Cita> citas = new ArrayList<Cita>();
        try {
 
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT distinct d.nombre,c.tipo_Especialidad,c.fecha, c.hora FROM doctor d INNER JOIN cita c ON d.codigo = c.id_doctor where c.id_paciente = '"+paciente+"';");
            if (!usuarioResultSet.next()) {

                System.out.println(" No se encontraron registros");
                ConectaBD.cerrar();
                return null;
            } else {
                do {

                    nombre = usuarioResultSet.getString("nombre");
                    tipE = usuarioResultSet.getString("tipo_Especialidad");
                    fecha = usuarioResultSet.getString("fecha");
                    hora = usuarioResultSet.getString("hora");
                    
                    citaHallada = new Cita(nombre,tipE,fecha,hora);
                    citas.add(citaHallada);
                } while (usuarioResultSet.next());
                ConectaBD.cerrar();
                return citas;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
        
        
    /**
     * Obiene datos del paciente con codigo
     * @param codigo
     * @return 
     */    
    public Paciente leePaciente(String codigo) {
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT * FROM paciente WHERE codigo='" + codigo + "';");

            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                System.out.println("Se encontró el registro");
                
                codigoP = usuarioResultSet.getString("codigo");
                nombreP = usuarioResultSet.getString("nombre");
                sexoP = usuarioResultSet.getString("sexo");
                nacimientoP = usuarioResultSet.getString("nacimiento");
                dpiP = usuarioResultSet.getString("dpi");
                telP = usuarioResultSet.getString("telefono");
                pesoP = usuarioResultSet.getDouble("peso");
                sangreP = usuarioResultSet.getString("tipo_sangre");
                correoP = usuarioResultSet.getString("correo");
                passP = usuarioResultSet.getString("password");
                                
                usuarioHallado = new Paciente(codigoP, nombreP, sexoP, nacimientoP,dpiP,telP,pesoP,sangreP,correoP,passP);
                ConectaBD.cerrar();
                return usuarioHallado;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    
        public boolean modificarPACIENTE(String codigo, String nombre, String sexo, String cumple,String dpi,String telefono, double peso, String sangre, String correo,String password) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();

        String query = "UPDATE paciente SET nombre = ?, sexo = ?, nacimiento = ?, dpi = ?, telefono = ?, peso = ?, tipo_sangre = ?, correo = ?, password = ? WHERE (codigo = ?);";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, nombre);
            preSt.setString(2, sexo);
            preSt.setString(3, cumple);
            preSt.setString(4, dpi);
            preSt.setString(5, telefono);
            preSt.setDouble(6, peso);
            preSt.setString(7, sangre);
            preSt.setString(8, correo);
            preSt.setString(9, password);
            preSt.setString(10, codigo);

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
        

    
    
    
    

  
}

//
//
//    public boolean modificarPaciente(String codigo, String nombre, String sexo, String cumple,String dpi,String telefono, double peso, String sangre, String correo,String password) {
//        int resultUpdate = 0;
//
//        conn = ConectaBD.abrir();
//
//        String query = "UPDATE paciente  SET nombre = ?, sexo = ?, String nacimiento = ?, dpi = ?, telefono = ?, peso = ?, tipo_sangre = ?, correo = ?, password = ? WHERE codigo = ?;";
//
//        try (PreparedStatement preSt = conn.prepareStatement(query)) {
//
//            preSt.setString(1, nombre);
//            preSt.setString(2, sexo);
//            preSt.setString(3, cumple);
//            preSt.setString(4, dpi);
//            preSt.setString(5, telefono);
//            preSt.setDouble(6, 40);
//            preSt.setString(7, sangre);
//            preSt.setString(8, correo);
//            preSt.setString(9, password);
//            preSt.setString(10, codigo);
