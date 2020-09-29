/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author james
 */
public class Administrador {
private String codigo;
private String dpi;
private String nombre;
private String password;


    public Administrador(String codigo, String dpi,String nombre, String password){
        this.codigo = codigo;
        this.dpi = dpi;
        this.nombre = nombre;
        this.password = password; 
    }
    public String getCuenta(){
        return codigo;
    }
    public String getNombre(){
        return nombre;
    }
    public String getClave(){
        return password;
    }

    public String getDPI(){
        return dpi;
    }

}
