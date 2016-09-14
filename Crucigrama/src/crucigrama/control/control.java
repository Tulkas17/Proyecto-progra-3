
package crucigrama.control;

public class control {
    
    public void cargarArchivo(){
        archivo=new Lector_de_Archivos();
        archivo.ejecutar();
    }
    
    private Lector_de_Archivos archivo;
}
