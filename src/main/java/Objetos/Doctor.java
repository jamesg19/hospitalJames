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
public class Doctor {
    private String codigo;
    private String nombre;
    private String colegiado;
    private String dpi;
    private String telefono;
    private String correo;
    private String horaInicio;
    private String horaFin;
    private String fechaTrabajo;
    private String especialidad;
    private String password;
    
    /**
     * CONSTRUCTOR PARA CREAR UN NUEVO DOCTOR
     * @param codigo
     * @param nombre
     * @param colegiado
     * @param dpi
     * @param telefono
     * @param correo
     * @param horaInicio
     * @param horaFin
     * @param fechaTrabajo
     * @param password 
     */
    public Doctor(String codigo, String nombre, String colegiado, String dpi, String telefono, String correo, String horaInicio, String horaFin, String fechaTrabajo, String password) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.colegiado = colegiado;
        this.dpi = dpi;
        this.telefono = telefono;
        this.correo = correo;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fechaTrabajo = fechaTrabajo;
        this.password = password;
    }

    public Doctor(String codigo, String nombre, String colegiado, String correo, String horaInicio, String horaFin, String fechaTrabajo, String especialidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.colegiado = colegiado;
        this.correo = correo;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fechaTrabajo = fechaTrabajo;
        this.especialidad = especialidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColegiado() {
        return colegiado;
    }

    public String getDpi() {
        return dpi;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public String getFechaTrabajo() {
        return fechaTrabajo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getPassword() {
        return password;
    }

    public Doctor() {
    }

    
    

    
    
}
