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
public class CitaMedico {
        private String codigo;
        private String nombre;
        private String sexo;
        private String nacimiento;
        private String telefono;
        private String sangre;
        private String correo;
        private String especialidad;
        private String fecha;
        private String hora;

    public CitaMedico(String codigo,String nombre, String sexo, String nacimiento, String telefono, String sangre, String correo, String especialidad, String fecha, String hora) {
        this.codigo=codigo;
        this.nombre = nombre;
        this.sexo = sexo;
        this.nacimiento = nacimiento;
        this.telefono = telefono;
        this.sangre = sangre;
        this.correo = correo;
        this.especialidad = especialidad;
        this.fecha = fecha;
        this.hora = hora;
    }

    public CitaMedico() {
    }

    public String getCodigo() {
        return codigo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSangre() {
        return sangre;
    }

    public void setSangre(String sangre) {
        this.sangre = sangre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
        
        
    
}
