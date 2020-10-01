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
public class Laboratorista {
    private String codigo;
    private String nombre;
    private String registro;
    private String dpi;
    private String telefono;
    private String examen;
    private String correo;
    private String diasTrabajo;
    private String trabajo;
    private String password;

    public Laboratorista(String codigo, String nombre, String registro, String dpi, String telefono, String examen, String correo, String diasTrabajo, String trabajo, String password) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.registro = registro;
        this.dpi = dpi;
        this.telefono = telefono;
        this.examen = examen;
        this.correo = correo;
        this.diasTrabajo = diasTrabajo;
        this.trabajo = trabajo;
        this.password = password;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRegistro() {
        return registro;
    }

    public String getDpi() {
        return dpi;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getExamen() {
        return examen;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDiasTrabajo() {
        return diasTrabajo;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public String getPassword() {
        return password;
    }
    
    
    
    
    
}
