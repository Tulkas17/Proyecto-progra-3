// Institucion: Universidad Nacional.
// Proyecto   : Divertigrama.
// Diseno     : Julian Delgado, Roger Cascante, Justin Vega. Implementacio: Justin Vega. Inspiracion: Ejemplo18B
// Propiedades: Solo Dios sabe bajo que tipo de licencia se puede publicar este trabajo.



package crucigrama.control ;



import crucigrama.model.Lista;
import javax.swing.JFileChooser           ;
import javax.swing.filechooser.FileFilter ;
import java.io.File                       ;
import org.w3c.dom.Document               ;
import javax.xml.parsers.DocumentBuilderFactory ;
import java.io.IOException                ;
import org.xml.sax.SAXException                 ;
import javax.xml.parsers.ParserConfigurationException ;
import java.util.List                                 ;
import java.util.ArrayList                            ;
import org.w3c.dom.Node                               ;
import org.w3c.dom.Element                            ;

public class Lector_de_Archivos
{
    public void ejecutar ( )
    {
        JFileChooser _Variable_ = new JFileChooser ( ) ;
        
        _Variable_.addChoosableFileFilter ( new FileFilter ( ) 
        {
            @Override
            public boolean accept ( File _Archivo_ )
            {
                return _Archivo_.isDirectory ( ) || _Archivo_.getName ( ).endsWith ( ".xml" ) ;
            }
            
            @Override
            public String getDescription ( )
            {
                return ".xml" ;
            }
        } ) ;
        
        System.out.println ( "Selecciona el archivo de entrada..." ) ;
        
        if ( _Variable_.showOpenDialog ( null ) == JFileChooser.APPROVE_OPTION )
        {
            try
            {
                File A1 = _Variable_.getSelectedFile ( ) ;
                
                Document D1 = _leer_documento_XML ( A1,true ) ;
                
                System.out.printf ( "Documento leido: %s...\n", A1.getPath ( ) ) ;
                
                _procesar_documento_XML ( D1 ) ;
            }
            catch ( Exception E1 )
            {
                System.err.println ( "Ocurrio un error al analizar el archivo de entrada..." ) ;
            }
        }
        else
        {
            System.err.println ( "No se selecciono el archivo de entrada..." ) ;
        }
    }
    
    public Document _leer_documento_XML ( File _Archivo_, boolean _Validar_ ) throws Exception
   {
        Document _Documento_ = null ;
        
        try
        {
            DocumentBuilderFactory _Documento_de_Fabrica_ = DocumentBuilderFactory.newInstance ( ) ;
            
            _Documento_de_Fabrica_.setValidating( _Validar_ )                  ;
            _Documento_de_Fabrica_.setIgnoringElementContentWhitespace( true ) ;
            
            _Documento_ = _Documento_de_Fabrica_.newDocumentBuilder ( ).parse( _Archivo_ ) ;
        }
        catch ( ParserConfigurationException | SAXException | IOException _A_ )
        {
            throw _A_ ;
        }
        return _Documento_ ;
    }
    
    public void _procesar_documento_XML ( Document D1 )
    {
        String F1 = "" ; // Filas de la matriz.
        String C1 = "" ; // Columnas de la matriz.
        
        double I1 =  1 ; // Indice de la palabra.
        String F2 = "" ; // Fila donde se hubica la palabra.
        String C2 = "" ; // Columna donde se hubica la palabra.
        String D2 = "" ; // Direccion de la palabra ( horizontal y vertical ).
        String P1 = "" ; // Palabra.
        String D3 = "" ; // Descrpcion de la palabra.
        
        Lista LP = new Lista ( ) ; // Lista de palabras.
        
        Element R1 = D1.getDocumentElement ( ) ;
        Node    N0 = R1.getFirstChild      ( ) ;
        
        if ( N0.getNodeType ( ) == Node.ELEMENT_NODE ) ;
        {
           
        if ( N0.getNodeName ( ).equals ( "crossword" ) )
        {    
        Node N1 = N0.getFirstChild ( ) ;
        
        while ( N1 != null )
        {
            if ( N1.getNodeType ( ) == Node.ELEMENT_NODE )
            {
                if ( N1.getNodeName ( ).equals ( "rows" ) ) { F1 = N1.getFirstChild ( ).getNodeValue ( ) ; }
                if ( N1.getNodeName ( ).equals ( "cols" ) ) { C1 = N1.getFirstChild ( ).getNodeValue ( ) ; }
                if ( N1.getNodeName ( ).equals ( "word" ) )
                {
                    Node N2 = N1.getFirstChild ( ) ;

                    while ( N2 != null )
                    {
                        if ( N2.getNodeName ( ).equals ( "row"       ) ) { F2 = N2.getFirstChild ( ).getNodeValue ( ) ; }
                        if ( N2.getNodeName ( ).equals ( "col"       ) ) { C2 = N2.getFirstChild ( ).getNodeValue ( ) ; }
                        if ( N2.getNodeName ( ).equals ( "direction" ) ) { D2 = N2.getFirstChild ( ).getNodeValue ( ) ; }
                        if ( N2.getNodeName ( ).equals ( "term"      ) ) { P1 = N2.getFirstChild ( ).getNodeValue ( ) ; }
                        if ( N2.getNodeName ( ).equals ( "definition") ) { D3 = N2.getFirstChild ( ).getNodeValue ( ) ; }

                        N2 = N2.getNextSibling ( ) ;
                    }
                
                    // Palabra P2 = new Palabra ( I1, Double.parseDouble ( F2 ), Double.parseDouble ( C2 ), _convertir_string_a_bool ( D2 ), _convertir_string_a_lista_de_letras ( P1 ), D3 ) ;
                    
                    // LP.agregar ( P2 ) ;
                }
            }
            N1 = N1.getNextSibling ( ) ;
        }
        }
        }

        
// return Crucigrama C3 = new Crucigrama ( Double.parseDouble ( D1 ), Double.parseDouble ( C1 ), LP ) ;
    }
    
    public boolean _convertir_string_a_bool ( String L1 )
    {
        if ( L1.equals ( "H" ) )
        {
            return true ;
        }
        else
        {
            return false ;
        }
    }
    
    public List < Character > _convertir_string_a_lista_de_letras ( String P1 )
    {
        List < Character > LL = new ArrayList < > ( ) ;
        
        for ( int a = 0 ; a <= P1.length ( ) ; a ++ )
        {
            LL.add ( P1.charAt ( a ) ) ;
        }
        return LL ;
    }
}