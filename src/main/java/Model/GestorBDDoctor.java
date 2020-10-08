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


/**
 * Gestor de base de datos del administrador que maneja todas las acciones o
 * consultas del mismo
 *
 * @author james
 */
public class GestorBDDoctor {

    String claveUsuario;
    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    Paciente usuarioHallado;
    String codigo, nombre;
    Doctor doctorHallado;
    Consulta consultaHallada;
    Examenes examenHallado;
    Informe informeHallado;
    Cita citaHallada;
    CitaMedico citaMHallada;
    String nom,tipE,fecha,hora;
    String codigoP,nombreP,sexoP,nacimientoP,dpiP,telP,sangreP,correoP,passP;                                                                                                                                           String nombreM,codigoM,sexoM,cumpleM,telM,sangreM,correoM,espeM,fechaM,horaM;
    String codigoE,nombreE,ordenE,descripcionE,formatoPDFE;
    double pesoP,costoE;

        /**
         * 
         * @param codigo
         * @param password
         * @return 
         */
    
        public Doctor consultar(String codigo, String password) {
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT * FROM doctor WHERE codigo='" + codigo + "' AND password='" + password + "';");

            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                System.out.println("Se encontró el registro");
                codigo = usuarioResultSet.getString("codigo");
                nombre = usuarioResultSet.getString("nombre");
                
                doctorHallado = new Doctor(codigo, nombre);
                ConectaBD.cerrar();
                return doctorHallado;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
        

    //Ver citas

        public ArrayList<CitaMedico> leeCitaDoctor(String doctor,String fecha) {
        java.time.LocalDate today = java.time.LocalDate.now();
        ArrayList<CitaMedico> citas = new ArrayList<CitaMedico>();
        try {
 
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT distinct p.codigo, p.nombre, p.sexo,p.nacimiento,p.telefono, p.tipo_sangre,p.correo,c.tipo_Especialidad, c.fecha , c. hora FROM paciente p INNER JOIN cita c ON '"+doctor+"' = c.id_doctor WHERE c.fecha='"+fecha+"';");
            if (!usuarioResultSet.next()) {

                System.out.println(" No se encontraron registros");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    codigoM=usuarioResultSet.getString("codigo");
                    nombreM = usuarioResultSet.getString("nombre");
                    sexoM = usuarioResultSet.getString("sexo");
                    cumpleM = usuarioResultSet.getString("nacimiento");
                    telM = usuarioResultSet.getString("telefono");
                    sangreM = usuarioResultSet.getString("tipo_sangre");
                    correoM = usuarioResultSet.getString("correo");
                    espeM = usuarioResultSet.getString("tipo_Especialidad");
                    fechaM = usuarioResultSet.getString("fecha");
                    horaM = usuarioResultSet.getString("hora");
                    
                    citaMHallada = new CitaMedico(codigoM,nombreM,sexoM,cumpleM,telM,sangreM,correoM,espeM,fechaM,horaM);
                    citas.add(citaMHallada);
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
        
        
    public Paciente consultarPacienteC(String codigo) {
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
                codigoM = usuarioResultSet.getString("codigo");
                nombreM = usuarioResultSet.getString("nombre");
                telM = usuarioResultSet.getString("correo");
                
                usuarioHallado = new Paciente(codigoM, nombreM,telM);
                ConectaBD.cerrar();
                return usuarioHallado;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }



    public boolean registrarInforme(String codigo, String paciente, String doctor, String informe, String fecha, String hora) {
        int resultUpdate = 0;
        
        conn = ConectaBD.abrir();

        String query = "INSERT INTO informe VALUES (?,?,?,?,?,?)";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setInt(1, 0);
            preSt.setString(2, paciente);
            preSt.setString(3, doctor);
            preSt.setString(4, informe);
            preSt.setString(5, fecha.toString());
            preSt.setString(6, hora);

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
         * Registra las consultas realizadas
         * @param paciente
         * @param medico
         * @param especialidad
         * @param fecha
         * @param hora
         * @return 
         */
        public boolean registrarCita(String paciente, String medico,String especialidad, String fecha, String hora) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();

        String query = "INSERT INTO cita_realizada VALUES (?,?,?,?,?)";

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
        
        
        
        
    public ArrayList<Informe> leeInforme(String fecha1,String fecha2) {

        ArrayList<Informe> informes = new ArrayList<Informe>();
        try {
 
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT i.id_paciente,p.nombre, COUNT(*) Total FROM informe i INNER JOIN paciente p ON p.codigo=i.id_paciente where i.fecha between '"+fecha1+"' AND '"+fecha2+"' GROUP BY i.id_paciente HAVING COUNT(*)>=1;");
            if (!usuarioResultSet.next()) {

                System.out.println(" No se encontraron registros");
                ConectaBD.cerrar();
                return null;
            } else {
                do {

                    nombre = usuarioResultSet.getString("id_paciente");
                    tipE = usuarioResultSet.getString("nombre");
                    fecha = usuarioResultSet.getString("Total");

                    informeHallado = new Informe(nombre,tipE,fecha);
                    informes.add(informeHallado);
                } while (usuarioResultSet.next());
                ConectaBD.cerrar();
                return informes;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }


    
        
        
    
    
        
         
}
