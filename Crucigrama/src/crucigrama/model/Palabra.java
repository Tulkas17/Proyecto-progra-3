/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crucigrama.model; 

import java.util.List;

/**
 *
 * @author estudiante
 */
public class Palabra {

    
    public Palabra(double indice, double columna, double fila, boolean direccion,List<Character> x, String descripcion) {
        this.indice = indice;
        this.columna = columna;
        this.fila = fila;
        this.direccion = direccion;
        palabra =x;
        this.descripcion = descripcion;
    }

  
    
    
    public double getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public double getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public double getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public boolean isDireccion() {
        return direccion;
    }

    public void setDireccion(boolean direccion) {
        this.direccion = direccion;
    }

    public List<Character> getPalabra() {
        return palabra;
    }

    public void setPalabra(List<Character> palabra) {
        this.palabra = palabra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Palabra{" + "indice= " + indice + ", columna= " + columna + ", fila= " + fila + ", direccion= " + direccion + ", palabra= " + palabra + ", descripcion= " + descripcion + '}';
    }

    
    
    
    private double indice;
    private double columna; // columna
    private double fila;  // fila
    private boolean direccion; // direccion si va en direccion horizontal es false , si va en vertical es true
    private List<Character> palabra = null;
    private String descripcion;
    
}
