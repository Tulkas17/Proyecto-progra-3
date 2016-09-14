
package crucigrama.model;

import java.util.ArrayList;
import java.util.List;


public class Lista {

    public Lista() {
        palabras = new ArrayList();
    }

    public Lista(ArrayList p) {
        palabras = p;
    }
   
    
    public List<Palabra> getPalabras() {
        return palabras;
    }

    public void setPalabras(List<Palabra> palabras) {
        this.palabras = palabras;
    }

    @Override
    public String toString() {
        return "Lista{" + "palabras=" + palabras + '}';
    }
    

    
    private List<Palabra> palabras;
}
