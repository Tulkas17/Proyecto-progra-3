package crucigrama.model;

import java.util.ArrayList;

public class Crucigrama {

    public Crucigrama() {
        this.l = null;
        this.mat = null;
    }

    public Crucigrama(Lista l) {
        this.l = l;
        this.mat = null;
    }
   public Crucigrama(Lista l, int h, int v)
    {
        this.l=l;
        mat = new Matriz(h,v);
    
    }
    public Crucigrama(Lista l, Matriz mat) {
        this.l = l;
        this.mat = mat;
    }

    public Lista getL() {
        return l;
    }

    public void setL(Lista l) {
        this.l = l;
    }

    public Matriz getMat() {
        return mat;
    }

    public void setMat(Matriz mat) {
        this.mat = mat;
    }

    void insertaPalabrasLista() {

        int i = 0;
        while (i < l.getPalabras().size()) {
            insertarPalabraUnica(l.getPalabras().get(i));
            i++;
        }
    }

    void insertarPalabraUnica(Palabra p) {
        int h = (int) p.getFila();
        int v = (int)p.getColumna();
        for (int j = 0; j < p.getPalabra().size(); j++) {
            if (!p.isDireccion()) {
                mat.getMatriz()[v-1][h-1] = p.getPalabra().get(j);
                h++;
            } else {
                mat.getMatriz()[v-1][h-1] = p.getPalabra().get(j);
                v++;
            }
        }

    }

    public boolean existeEn(char c, int h, int v) {
        
        return mat.getMatriz()[v][h] == c;
    }

 
    public static void main(String[] args) {

        int h, v, i;
        i = 1;
        h = 2;
        v = 4;
        boolean g = false;
        ArrayList<Character> f = new ArrayList<>();
        f.add('h');
        f.add('o');
        f.add('l');
        f.add('a');
        String desc = "solo tantiando...";

        Palabra p = new Palabra(i, h, v, g, f, desc);

        i = 2;
        h = 5;
        v = 6;
        g = true;
        ArrayList<Character> z = new ArrayList<>();
        z.add('p');
        z.add('e');
        z.add('l');
        z.add('o');
        desc = "solo tantiando2...";

        Palabra p2 = new Palabra(i, h, v, g, z, desc);

        i = 3;
        h = 8;
        v = 2;
        g = false;
        ArrayList<Character> k = new ArrayList<>();
        k.add('p');
        k.add('o');
        k.add('l');
        k.add('a');
        k.add('r');
        desc = "solo tantiando3...";

        Palabra p3 = new Palabra(i, h, v, g, k, desc);

        Lista l = new Lista();
        l.getPalabras().add(p);
        l.getPalabras().add(p2);
        l.getPalabras().add(p3);
        System.out.println(l.toString());

        Matriz m = new Matriz(10, 10);
        m.llenaDeAsteriscos();
        
        Crucigrama c = new Crucigrama(l, m);

        c.insertaPalabrasLista();

        c.getMat().imprimirMatriz();

    }

    private Lista l;
    private Matriz mat;

}
