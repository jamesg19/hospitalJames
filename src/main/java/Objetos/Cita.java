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

    public Cita(String paciente, String medico, String fecha, String hora) {
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Cita() {
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

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
}
