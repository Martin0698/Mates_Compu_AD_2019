import java.util.LinkedList;
import java.util.TreeSet;

import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument.LeafElement;
import javax.xml.soap.Node;

import org.w3c.dom.NodeList;

public class CYK {

	public static LinkedList<String>[][] Matriz;
	
	static int id=0;

	public static  LinkedList<String>[][] llenarMatriz(String[] simbolos_palabra) {
		
		Matriz= new LinkedList[simbolos_palabra.length][simbolos_palabra.length];
		
		
		
		
		//Numero de Fila
		for(int x=0; x < Matriz.length; x++){
			
			
			
			//Numero de Columna
			for(int y=0; y < Matriz.length; y++){
				
				if(x-y <= 0){
					
					if(x==y){
						Matriz[x][y]= Separador.indexador.get(simbolos_palabra[x]);
					}
					
				
				}
				
				
			}
			
		}
		
		//Para las demás diagonales
		
		//va a indicar en que columna inicia
		int iteraciones=1;
		
		//ciclo para llegar hasta (0,n)
		while(iteraciones< Matriz.length){
		
		//Recorre Matriz en Diagonales	
			for(int x=0;x< Matriz.length;x++){
				
				for(int y= iteraciones; y < Matriz.length; y++){
					
					if(x-y < 0){
						LinkedList<String> Lista=new LinkedList<>();
						
						Matriz[x][y]=Lista;
						
						Matriz[x][y]= llenaCelda(Matriz[x][y], x, y);
					
					}
					x++;
				}	
				
			}
			iteraciones++;
		}
		
		
		
		
		
		
		return Matriz ;
	}
	// "x" es la fila y "y" es la columna
	public static LinkedList<String> llenaCelda(LinkedList<String> celda, int x, int y){
		
		//Recorrido en Horizontal 
		//incrementar y1
		int x1= x, y1= x;
		
		//Recorrido en Vertical
		//incrementar x2
		int x2= x+1, y2= y;
		
		//obtener Lista Horizontal
		LinkedList<String> Lista_Celda_Horizontal = new LinkedList<>();
		
		
		//obtner Lista Vertical
		LinkedList<String> Lista_Celda_Vertical = new LinkedList<>();
		
		
		//concatenar valores de listas
		String Concatenacion_de_valores;
		
		//booleano para verificar que existe en la hash
		boolean verifica_concatenacion;
		
		while(x2 <= y2){
			//Asignación de las listas por cada iteración
			Lista_Celda_Horizontal= Matriz[x1][y1];
			Lista_Celda_Vertical= Matriz[x2][y2];
			
			//Obtiene valores de la celda en horizontal
			for (String valor_en_lista_horizontal : Lista_Celda_Horizontal) {
				
				//Obtiene valores de la celda en vertical
				for (String valor_en_lista_vertical : Lista_Celda_Vertical) {
					
					Concatenacion_de_valores= valor_en_lista_horizontal+valor_en_lista_vertical;
					
					verifica_concatenacion= Separador.indexador.containsKey(Concatenacion_de_valores);
					
					//Si existe la concatenación en la hash: indexador
					if(verifica_concatenacion){
						
						//si la lista está vacia agrega todos los elementos
						if(celda.size()==0){
							for (String valores_lista_de_indexador : Separador.indexador.get(Concatenacion_de_valores)) {
								
								celda.addLast(valores_lista_de_indexador);
							}
						}
						
						//si no está vacia, solo agrega los que no estén
						else{
							for (String valores_lista_de_indexador : Separador.indexador.get(Concatenacion_de_valores)) {
								
								if(!(celda.contains(valores_lista_de_indexador))){
									celda.addLast(valores_lista_de_indexador);
								}
								
							}
						}
					}
				}
			}
			
			//incremento de movimiento
			x2++;
			y1++;
		}
		
		
		if(celda.size()==0){
			celda.addLast("E");
		}
		
		
		
		
		
		return celda;
	}

	
	public static boolean esAceptada(LinkedList<String>[][] Matriz){
		
		return Matriz[0][Matriz.length-1].contains("S");
	}
	
	
	
	public static void backtracking( LinkedList<String> celda, int x, int y, String Valor){
		
		
		
		//Lista Horizontal
		LinkedList<String> Lista_Horizontal= new LinkedList<>();
		
		//Lista Vertical
		LinkedList<String> Lista_Vertical= new  LinkedList<>();
		
		//Lista de la concatenación
		LinkedList<String> Lista_Resultante= new LinkedList<>();
		
		//Concatenar
		String concatenacion;
		boolean esta_en_indexador;
		boolean Generadores_encontrados=false;
		
		
		//coordenadas de celdas
		//Coordenadas Lista Horizontal
		int x1=x, y1= y-1;
		
		//Coordenadas Lista Vertical
		int x2= y, y2= y;
		
		
		if(x == y ){
			System.out.println(Valor +" Hijo: "+Separador.llave_Generador.get(Valor));
		}
		
		while(x1-y1 <=0){
			
			Lista_Horizontal= Matriz[x1][y1];
			Lista_Vertical=Matriz[x2][y2];
			
			
			for (String valor_en_lista_horizontal : Lista_Horizontal) {
				
				for (String valor_en_lista_vertical : Lista_Vertical) {
				
					concatenacion= valor_en_lista_horizontal+valor_en_lista_vertical;
					
					esta_en_indexador= Separador.indexador.containsKey(concatenacion);
					
					if(esta_en_indexador){
						
						Lista_Resultante= Separador.indexador.get(concatenacion);
						
						if(Lista_Resultante.contains(Valor) ){
							Generadores_encontrados= true;
							System.out.println("Nodo"+Valor+ id++ +" izquierdo:"+valor_en_lista_horizontal+" derecho:"+valor_en_lista_vertical);
							backtracking(Matriz[x1][y1], x1, y1, valor_en_lista_horizontal);
							
							backtracking(Matriz[x2][y2], x2, y2, valor_en_lista_vertical);
						}
					}
				}
				
			}
			
			if(!(Generadores_encontrados)){
				x1=x;
				y1=y1-1;
				
				x2=x2-1;
				y2=y2;
			}
			else{
				break;
			}
			
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}




	

}
