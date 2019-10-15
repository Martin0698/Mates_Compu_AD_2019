package CYK_Complete;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 *
 * @author Martin Guevara
 */
public class Separador {
	
    static Hashtable<String, LinkedList<String>> indexador= new Hashtable<>();
    
    static Hashtable<String, LinkedList<String>> llave_Generador= new Hashtable<>();
    
    public static void lee_linea(String linea_GLC){
        
            System.out.println(linea_GLC);
            String[] palabras = linea_GLC.split(" ");
            
            //System.out.println("ITERACION LEE LINEA STRING[0]: "+palabras[0]);
            opciones(palabras);
            
          
    }
    
    
    
    public static void opciones(String[] palabras){
    	LinkedList<String> Lista= new LinkedList<>();
    	Lista.addLast(palabras[0]);
    	
    	for (int i=1; i < palabras.length;i++){
    		
    		if(!(palabras[i].equals("=")) && (!(palabras[i].equals("|")) && (!(palabras[i].equals(" "))))){
    			
    			if(!(indexador.containsKey(palabras[i]))){
    				
    				indexador.put(palabras[i], (LinkedList<String>) Lista.clone());
    				
    			}
    			else{
    				
    				indexador.get(palabras[i]).addLast(palabras[0]);
    			}
    					
    			
    		}
    	}
    	
    	Lista= new LinkedList<>();
    	
    	for (int i=1; i < palabras.length;i++){
    		
    		if(!(palabras[i].equals("=")) && (!(palabras[i].equals("|")) && (!(palabras[i].equals(" "))))){
    			Lista.addLast(palabras[i]);
    		}  			
		
    	}
    		llave_Generador.put(palabras[0], Lista);
    }
    
}