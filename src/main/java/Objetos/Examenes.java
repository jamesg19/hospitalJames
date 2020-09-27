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
public class Examenes {
    private String codigo;
    private String nombre;
    private boolean orden;
    private String descripcion;
    private double costo;
    private boolean formatoPDF;

    public Examenes(String codigo, String nombre, boolean orden, String descripcion, double costo, boolean formatoPDF) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.orden = orden;
        this.descripcion = descripcion;
        this.costo = costo;
        this.formatoPDF = formatoPDF;
    }
    //Getter and Setter

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isOrden() {
        return orden;
    }

    public void setOrden(boolean orden) {
        this.orden = orden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isFormatoPDF() {
        return formatoPDF;
    }

    public void setFormatoPDF(boolean formatoPDF) {
        this.formatoPDF = formatoPDF;
    }
    

}
