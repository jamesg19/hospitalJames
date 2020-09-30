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
    private final String codigo;
    private final String dpi;
    private final String nombre;
    private final String password;
    
    public Admin(String codigo, String dpi, String nombre, String password){
        this.codigo=codigo;
        this.dpi=dpi;
        this.nombre=nombre;
        this.password=password;
    }
    // Getter 

    public String getCodigo() {
        return codigo;
    }

    public String getDpi() {
        return dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }
    

    
    
    
}
