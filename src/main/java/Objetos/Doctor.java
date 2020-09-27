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
    private String password;
    private String colegiado;
    private String dpi;
    private String telefono;
    private String especialidad;
    private String correo;
    private String horario;
    private String fechaTrabajo;

    public Doctor(String codigo, String password, String colegiado, String dpi, String telefono, String especialidad, String correo, String horario, String fechaTrabajo) {
        this.codigo = codigo;
        this.password = password;
        this.colegiado = colegiado;
        this.dpi = dpi;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.correo = correo;
        this.horario = horario;
        this.fechaTrabajo = fechaTrabajo;
    }
    //Getter y Setter
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getColegiado() {
        return colegiado;
    }

    public void setColegiado(String colegiado) {
        this.colegiado = colegiado;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getFechaTrabajo() {
        return fechaTrabajo;
    }

    public void setFechaTrabajo(String fechaTrabajo) {
        this.fechaTrabajo = fechaTrabajo;
    }
    
    
}
