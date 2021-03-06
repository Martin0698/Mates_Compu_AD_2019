import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Busqueda  {
	
	static ArrayList<String> coincidencias_en_archivos= new ArrayList<>();
	static ArrayList<String> coincidencias_en_archivos_de_lectura= new ArrayList<>();
	
	
	static int contador_de_archivos=0, contador_de_archivos_contienen_palabra=0;
	
	
	
	
	
	public static boolean buscar(String palabra, File ruta) throws IOException {
		// TODO Auto-generated method stub
		File[] lista_archivos = ruta.listFiles();
		boolean flag = false;
		
		for(int i=0; i < lista_archivos.length;i++){
			if(lista_archivos[i].isDirectory()){
				buscar(palabra, lista_archivos[i]);
			}
			else if(lista_archivos[i].getName().contains(palabra)){
				contador_de_archivos++;
				coincidencias_en_archivos.add(lista_archivos[i].getName());
				flag= true;
			}
			else if(lista_archivos[i].getName().endsWith(".txt")){
				String s1;
		        String s2;
		 
		        // Cargamos el buffer con el contenido del archivo
		        BufferedReader br = new BufferedReader (new FileReader (lista_archivos[i]));
		 
		        // Leemos la primera linea
		        s1 = br.readLine();
		 
		       // System.out.println ("La primera linea del archivo es: " + s1);
		        //System.out.println ("La linea tiene " + s1.length() + " caracteres");
		 
		        System.out.println ();
		        //System.out.println ("Separando la linea en trozos tenemos las siguientes palabras:");
		 
		        int numTokens = 0;
		        StringTokenizer st = new StringTokenizer (s1);
		        
		      
						
		        // bucle por todas las palabras
		        while (st.hasMoreTokens())
		        {
		            s2 = st.nextToken();
		            numTokens++;
		          // System.out.println ("    Palabra " + numTokens + " es: " + s2);
		            
		            if(s2.contains(palabra)){
		            	flag = true;
		            	contador_de_archivos_contienen_palabra++;
		            	coincidencias_en_archivos_de_lectura.add(lista_archivos[i].getName());
		            	break;
		            }
		            
		            
		        }
			}
		}
		return flag;
		
	}

	public static void imprimeListaArchivo(){
		System.out.println("\n===========================================================================\n");
		for(String a: coincidencias_en_archivos){
			System.out.println(a);
		}
		System.out.println("\nArchivos con la cadena requerida en el titulo: "+ contador_de_archivos);
		System.out.println("\n===========================================================================\n");
		
		for(String b: coincidencias_en_archivos_de_lectura){
			System.out.println(b);
		}
		System.out.println("\nArchivos con la cadena requerida en el texto: "+ contador_de_archivos_contienen_palabra);

		System.out.println("\n===========================================================================\n");

	}
	
		
	
}