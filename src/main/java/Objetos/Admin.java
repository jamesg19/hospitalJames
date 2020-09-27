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
public class Admin {
    private String codigo;
    private String dpi;
    private String nombre;
    private String password;
    
    public Admin(String codigo, String dpi, String nombre, String password){
        this.codigo=codigo;
        this.dpi=codigo;
        this.nombre=codigo;
        this.password=codigo;
    }
    // Getter y Setter
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
