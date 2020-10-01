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
public class Especialidad {
    private int codigo;
    private String medico;
    private String tipo;
    /**
     * constructor de especialidades medicas
     * @param codigo
     * @param medico
     * @param tipo 
     */
    public Especialidad(int codigo, String medico, String tipo) {
        this.codigo = codigo;
        this.medico = medico;
        this.tipo = tipo;
    }
    /**
     * constructor del tipo de especialidad
     * @param tipo 
     */
    public Especialidad(String tipo) {
        this.tipo = tipo;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public String getMedico() {
        return medico;
    }

    public String getTipo() {
        return tipo;
    }
    
    
    
    
    
}
