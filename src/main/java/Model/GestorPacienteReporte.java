/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Objetos.*;
import Objetos.Consulta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class GestorPacienteReporte {
    String claveUsuario;
    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    Consulta consultaHallada;
    
    
    /**
     * Ultimas 5 citas realizadas
     * @param paciente
     * @return 
     */
    public ArrayList<Cita> leeCita(String paciente) {
        java.time.LocalDate today = java.time.LocalDate.now();
        String fechaa=today.toString();
        
        ArrayList<Cita> citas = new ArrayList<Cita>();
        try {
 
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT distinct d.nombre,c.tipo_Especialidad,c.fecha, c.hora FROM doctor d INNER JOIN cita c ON d.codigo = c.id_doctor where c.id_paciente = '"+paciente+"' AND c.fecha<= '"+fechaa+"' ORDER BY c.fecha DESC LIMIT 5;");
            if (!usuarioResultSet.next()) {

                System.out.println(" No se encontraron registros");
                ConectaBD.cerrar();
                return null;
            } else {
                do {

                    String nombre = usuarioResultSet.getString("nombre");
                    String tipE = usuarioResultSet.getString("tipo_Especialidad");
                    String fecha = usuarioResultSet.getString("fecha");
                    String hora = usuarioResultSet.getString("hora");
                    
                    Cita citaHallada = new Cita(nombre,tipE,fecha,hora);
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
    
    
}
