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
public class Paciente {
        private String codigo;
        private String nombre;
        private String sexo;
        private String cumple;
        private String dpi;
        private String tel;
        private double peso;
        private String sangre;
        private String correo;
        private String password;
    /**
     * Constructor para crear nuevos pacientes
     * @param codigo
     * @param nombre
     * @param sexo
     * @param cumple
     * @param dpi
     * @param tel
     * @param peso
     * @param sangre
     * @param correo
     * @param password 
     */
    public Paciente(String codigo, String nombre, String sexo, String cumple, String dpi, String tel, double peso, String sangre, String correo, String password) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sexo = sexo;
        this.cumple = cumple;
        this.dpi = dpi;
        this.tel = tel;
        this.peso = peso;
        this.sangre = sangre;
        this.correo = correo;
        this.password = password;
    }
    /**
     * COnstructor para trasladar datos del paciente al ingresar al sistema
     * @param codigo
     * @param nombre 
     */
    public Paciente(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Paciente(String codigo) {
        this.codigo = codigo;
    }
    

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCumple() {
        return cumple;
    }

    public String getDpi() {
        return dpi;
    }

    public String getTel() {
        return tel;
    }

    public double getPeso() {
        return peso;
    }

    public Paciente(String codigo, String nombre, String correo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.correo = correo;
    }
    
    public String getSangre() {
        return sangre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }
    
    
    
        
        
        
        
        
        
        
        
        
        
        
        
        
    
}
