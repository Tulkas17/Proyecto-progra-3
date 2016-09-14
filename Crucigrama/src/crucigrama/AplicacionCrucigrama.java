package crucigrama;

import crucigrama.control.control;
import crucigrama.model.Crucigrama;
import crucigrama.model.Lista;
import crucigrama.model.Palabra;
import crucigrama.model.Matriz;
import java.util.ArrayList;
import crucigrama.vista.Ventana;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AplicacionCrucigrama {

 
    public static void main(String[] args) {        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch(ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                UnsupportedLookAndFeelException e){
            System.err.println(e.getMessage());
        }
        control aplicacion=new control();
        Ventana vista=new Ventana("prueba",aplicacion);
        vista.init();

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
    
  


}
