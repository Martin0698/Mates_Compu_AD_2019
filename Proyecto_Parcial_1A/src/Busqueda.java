import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Busqueda  {
	
	static ArrayList<String> coincidencias_en_archivos= new ArrayList<>();
	static ArrayList<String> coincidencias_en_archivos_de_lectura= new ArrayList<>();
	
	
	static int contador_de_archivos=0, contador_de_archivos_contienen_palabra=0;
	
	static int lineas_totales=0;
	
	
	
	public static void buscar(String palabra, File ruta) {
		// TODO Auto-generated method stub
		File[] lista_archivos = ruta.listFiles();
		
		for(int i=0; i < lista_archivos.length;i++){
			if(lista_archivos[i].isDirectory()){
				buscar(palabra, lista_archivos[i]);
			}
			else if(lista_archivos[i].getName().contains(palabra)){
				contador_de_archivos++;
				coincidencias_en_archivos.add(lista_archivos[i].getName());
				
			}
			else if(lista_archivos[i].getName().contains(".txt")){
				try {
					BufferedReader lector = new BufferedReader(new FileReader(lista_archivos[i]));
					
					String linea_Leida="";
					
					while((linea_Leida= lector.readLine()) != null){
						
						lineas_totales++;
						
						String[] palabras = linea_Leida.split(" ");
					
						for(int i1=0; i1< palabras.length;i1++){
							
							if(palabras[i1].contains(palabra)){
								contador_de_archivos_contienen_palabra++;
								coincidencias_en_archivos_de_lectura.add(lista_archivos[i1].getName());
								break;
							}
						}
					}
				
				
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
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
	
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

	
}
