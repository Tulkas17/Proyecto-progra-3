
package crucigrama.vista;

import crucigrama.control.control;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class Ventana extends JFrame implements Observer{
    
    public Ventana(String titulo,control apli){
        super(titulo);
        aplicacion=apli;
        
        setSize(600,400);
        setLocationRelativeTo(null);
        
        componentes(getContentPane());
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
           
            @Override
            public void windowClosing(WindowEvent e){
                cerrarAplicacion();
            }
            
        });
        
        addKeyListener(new KeyAdapter(){
        
               @Override
               public void keyPressed(KeyEvent e){
                   System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
               }
        });
        
        
        
    }
    
    private void componentes(Container c){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../vista/crossword-icon.png")));
        //imagen para el icono obtenida de la pagina "http://es.seaicons.com/99103/"
        c.setLayout(new GridLayout(1,2));
        c.add(panel=new PanelMatriz());
        c.add(pistas=new JPanel());
        pistas.setLayout(new GridLayout(1,2));
        pistas.add(new JLabel("prueba1"));
        pistas.add(new JLabel("prueba2"));
        
        barraMenu();
        
        Cargar.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                aplicacion.cargarArchivo();
            }
        });
        
        Salir.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarAplicacion();
            }
            
        });
        Acerca.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                informacion();
            }
        });
        
    }
    
    private void barraMenu(){
        Menus=new JMenuBar();
        
        Menus.add(Archivo=new JMenu("Archivo"));
        Archivo.add(Cargar=new JMenuItem("Cargar Archivos."));
        Archivo.add(Salir=new JMenuItem("Salir."));
        
        Menus.add(Modo=new JMenu("Modo"));
        Modo.add(Normal=new JMenuItem("Normal."));
        Modo.add(Asistido=new JMenuItem("Asistido."));
        
        Menus.add(Crucigrama=new JMenu("Crucigrama"));
        Crucigrama.add(Revisar=new JMenuItem("Revisar."));
        Crucigrama.add(Solucion=new JMenuItem("Ver solucion."));
        
        Menus.add(Ayuda=new JMenu("Ayuda"));
        Ayuda.add(Ayudar=new JMenuItem("Ayuda."));
        Ayuda.add(Acerca=new JMenuItem("Acerca del Programa."));
        
        setJMenuBar(Menus);
    }
    
    private void informacion(){
        JOptionPane.showMessageDialog(null, "Proyecto Crucigrama.\nVersion 1.0");
    }
    
    private void cerrarAplicacion(){
        if(ConfirmarCerrado()){
            System.exit(0);
        }
    }
    
    private boolean ConfirmarCerrado(){
        int option=JOptionPane.showConfirmDialog(null,"¿Desea salir de la apliacion?","Confirmar salida.",JOptionPane.YES_NO_OPTION);
        return option==JOptionPane.YES_OPTION;
    }
    
    public void init(){
        setVisible(true);
    }
    
      @Override
    public void update(Observable m, Object arg) {
        panel.repaint();
    }
    
    private control aplicacion;
    private JPanel pistas;
    private PanelMatriz panel;
    private JMenuBar Menus;
    private JMenu Archivo;
    private JMenuItem Cargar;
    private JMenuItem Salir;
    private JMenu Modo;
    private JMenuItem Normal;
    private JMenuItem Asistido;
    private JMenu Crucigrama;
    private JMenuItem Revisar;
    private JMenuItem Solucion;
    private JMenu Ayuda;
    private JMenuItem Ayudar;
    private JMenuItem Acerca;

    
    
}
