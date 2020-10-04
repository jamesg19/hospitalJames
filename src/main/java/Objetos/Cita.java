/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author james
 */
public class Cita {
    private int codigo;
    private String paciente;
    private String medico;
    private String especialidad;
    private String fecha;
    private String hora;

    public Cita(int codigo, String paciente, String medico, String especialidad, String fecha, String hora) {
        this.codigo = codigo;
        this.paciente = paciente;
        this.medico = medico;
        this.especialidad = especialidad;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getMedico() {
        return medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }
    
    
}
