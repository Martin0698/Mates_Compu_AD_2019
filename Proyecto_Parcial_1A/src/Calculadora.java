

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Calculadora {
	
	static Stack<Jerarquia> operadores = new Stack<>();
	
	static Stack<String> datos= new Stack<>();
	
	 static LinkedList<ArrayList<String>> Resultado= new  LinkedList<>();
	
	
	public static String convertir_APostfijo(String infijo) {
		
		String posfijo = "";
		//boolean primer_operador= false;
		
		for(int i=0; i < infijo.length(); i++){
			char letra= infijo.charAt(i);
			
			if(operadores.isEmpty() && ((letra == '(') || 
			(letra == ')') ||(letra == '*') || (letra == '+') || 
			(letra == '^') || (letra =='-') )){
				validaOperadorI(letra);
				
				System.out.println("Entre al if 1");
				System.out.println(operadores.toString());
			}
			else if ( (!(operadores.isEmpty())) && ((letra == '(') || 
					(letra == ')') ||(letra == '*') || (letra == '+') || 
					(letra == '^') || (letra =='-') )) {
				
				posfijo= posfijo + comparaJerarquia(letra);
				
				System.out.println("Entre al if 2");
				System.out.println(operadores.toString());
			}else{
				
				posfijo= posfijo + Character.toString(letra);
				
				System.out.println("Entre al if 3");
				System.out.println(operadores.toString());
			}
			
			
		}
		
		while(!operadores.isEmpty()){
			
			posfijo= posfijo + operadores.pop().getOperador();
			
		}
		
		return posfijo;
	}
	
	
	
	
	
	public  static void validaOperadorI(char caracter){
		
		if(caracter == '('){
			operadores.push(Jerarquia.PAR_ABRE);	
		}
		else if(caracter == ')'){
			operadores.push(Jerarquia.PAR_CIERRA);
		}
		else if(caracter == '*'){
			operadores.push(Jerarquia.ASTERISCO_POW);
		}
		else if(caracter == '+'){
			operadores.push(Jerarquia.UNION);
		}
		else if(caracter == '^'){
			operadores.push(Jerarquia.MAS_POW);
		}
		else if(caracter == '-'){
			operadores.push(Jerarquia.CONCAT);
		}
	}
	
	
	
	
	
	public  static Jerarquia  buscaJerarquia(char caracter){
		
		if(caracter == '('){
			return(Jerarquia.PAR_ABRE);	
		}
		else if(caracter == ')'){
			return(Jerarquia.PAR_CIERRA);
		}
		else if(caracter == '*'){
			return(Jerarquia.ASTERISCO_POW);
		}
		else if(caracter == '+'){
			return(Jerarquia.UNION);
		}
		else if(caracter == '^'){
			return(Jerarquia.MAS_POW);
		}
		else {
			return(Jerarquia.CONCAT);
		}
	}
	
	
	
	public  static String comparaJerarquia(char letra){
		
		Jerarquia nvo_Operador= buscaJerarquia(letra);
		
		String retorno ="";
		if(nvo_Operador.getImportancia() >= operadores.peek().getImportancia()){
			operadores.push(nvo_Operador);
			System.out.println(operadores.toString());
		}
		
		else if(nvo_Operador.getOperador() == ")"){
			
			
			while(!operadores.isEmpty()){
				
				if(operadores.peek().getOperador()== "("){
						operadores.pop();
					break;
				}
				else{
					retorno= retorno+ operadores.pop().getOperador();
				}
			}
			
			System.out.println(operadores.toString());

		}
		
		else{
			while(!operadores.isEmpty()){	
				
				System.out.println(operadores.toString());
				if(operadores.peek().getOperador()== "(" ){
					break;
				}
				else{
					retorno= retorno + operadores.pop().getOperador();
				}

			}
			
		operadores.push(nvo_Operador);
		System.out.println(operadores.toString());
		}
		
		
		return retorno;
	}
	
	
	
	public static String calculaPosFijo(String convertir_APostfijo) throws IOException {
		// TODO Auto-generated method stub
		
		String resultado="";
		String valor1, valor2;
		
		char letra;
		for(int i=0; i< convertir_APostfijo.length(); i++){
			letra= convertir_APostfijo.charAt(i);
			
			if((letra == '*') || (letra == '+') || 
			(letra == '^') || (letra =='-') ){
				
				switch (letra) {
				case '*':
					valor1=datos.pop();
					resultado= cerraduraDeKleene(valor1);
					datos.push(resultado);
					break;
				case'+':
					
					valor1= datos.pop();
					valor2=datos.pop();
					
					resultado= union(valor2, valor1);
					datos.push(resultado);
					break;
				case '^':
					valor1=datos.pop();
					resultado=  cerraduraPositiva(valor1);
					datos.push(resultado);
					break;
				case '-':
					
					valor1= datos.pop();
					valor2=datos.pop();
					
					resultado= concatenacion(valor2, valor1) ;
					
					datos.push(resultado);
							
					break;
				default:
					break;
				}
			}
			else{
				
				datos.push(String.valueOf(letra));
				
			}
			
			
		}
		
		return datos.pop();
	}
	
	
	
	

	private static String concatenacion(String valor1, String valor2) {
		// TODO Auto-generated method stub
		
		return valor1 + valor2;
	}





	private static String cerraduraPositiva(String valor1) throws IOException {
		
		String retorno="";
		//int n= Integer.parseInt(JOptionPane.showInputDialog("Cuantas repeticiones desea de la cerradura de kleene para esta palabra: "+ valor1));
		for(int i=1; i<= 1 ; i++){
			
			retorno+= valor1;
			Busqueda.buscar(retorno, new File("C:\\Users\\Martin Guevara\\Desktop\\Algoritmos"));
			
			Busqueda.imprimeListaArchivo();
		}
		
		
		return retorno;
	}





	private static String union(String valor1, String valor2) throws IOException {
		// TODO Auto-generated method stub
		boolean flag= false;
		String res= "1";
		
		String retorno = "";
		
		if(res.equals("1")){
			
			flag= Busqueda.buscar(valor1, new File("C:\\Users\\Martin Guevara\\Desktop\\Algoritmos"));
			
			
			
			if(flag){
				Busqueda.buscar(valor1+valor2, new File("C:\\Users\\Martin Guevara\\Desktop\\Algoritmos"));
				
				Busqueda.imprimeListaArchivo();
				retorno= valor1 + valor2;
			}
			else{
				Busqueda.imprimeListaArchivo();
				retorno= valor1;
			}
		
		}	
			
		
		else {
			Busqueda.buscar(valor2, new File("C:\\Users\\Martin Guevara\\Desktop\\Algoritmos"));
			Busqueda.imprimeListaArchivo();
			retorno= valor2;
			
		}
		return retorno;	
			
		
		
			
	}





	private static String cerraduraDeKleene(String palabra) throws IOException {
		boolean flag;
		String retorno="";
		//int n= Integer.parseInt(JOptionPane.showInputDialog("Cuantas repeticiones desea de la cerradura de kleene para esta palabra: "+ palabra));
		for(int i=0; i< 2 ; i++){
			
			retorno+= palabra;
			Busqueda.buscar(retorno, new File("C:\\Users\\Martin Guevara\\Desktop\\Algoritmos"));
			
			
			
		}
		Busqueda.imprimeListaArchivo();
		return retorno;
		}
		
		
		

}
