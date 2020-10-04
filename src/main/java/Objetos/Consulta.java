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
public class Consulta {
    private int codigo;
    private String tipo;
    private double costo;
    /**
     * 
     * @param codigo
     * @param tipo
     * @param costo 
     */
    public Consulta(int codigo, String tipo, double costo) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.costo = costo;
    }
    /**
     * 
     * @param tipo 
     */
    public Consulta(String tipo) {
        this.tipo = tipo;
    }

    public Consulta(double costo) {
        this.costo = costo;
    }
    
    
    public int getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCosto() {
        return costo;
    }


    
    
    
    
    
    
}
