/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crucigrama.model;
import java.util.Observable;

public class Modelo extends Observable {
    int filas,columnas;
    String matrizUsuario[][];
    String matrizRespuesta[][];

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
    public Modelo(int filas,int columnas)
    {
        this.filas=filas;
        this.columnas=columnas;
        matrizUsuario=new String[filas][columnas];
        matrizRespuesta=new String[filas][columnas];
    }
    public void agregar(String[][] a)
    {
        matrizUsuario=a;
        matrizRespuesta=a;
        this.setChanged();
        this.notifyObservers(null);
    }
    public Modelo agregar(String letra,int x, int y)
    {
        char c=(char)letra.toUpperCase().charAt(0);
        if(Character.isLetter(c))
            matrizUsuario[x][y]=""+c;
        this.setChanged();
        this.notifyObservers(null);
        return this;
    }
    public String[][] getMatrizUsuario() {
        return matrizUsuario;
    }
    public void addObserver(java.util.Observer o)
    {
        super.addObserver(o);
        setChanged();
        notifyObservers(null);
    }
      
    
}

//prueba de github por netbeans en linux,      y ahora desde win