
import java.nio.channels.ShutdownChannelGroupException;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Calculadora {
	
	static Stack<Jerarquia> operadores = new Stack<>();
	static Stack<String> datos= new Stack<>();
	
	
	
	
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
	
	
	
	public static String calculaPosFijo(String convertir_APostfijo) {
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
					resultado= resultado+ cerraduraDeKleene(valor1);
					break;
				case'+':
					
					valor1= datos.pop();
					valor2=datos.pop();
					
					resultado= resultado+ union(valor1, valor2);
					break;
				case '^':
					valor1=datos.pop();
					resultado= resultado+ cerraduraPositiva(valor1);
					break;
				case '-':
					valor1= datos.pop();
					valor2=datos.pop();
					
					resultado= resultado+ concatenacion(valor1, valor2);
					break;
				default:
					break;
				}
			}
			else{
				
				datos.push(String.valueOf(letra));
				
			}
			
			datos.push(resultado);
		}
		
		return resultado;
	}
	
	
	
	

	private static String concatenacion(String valor1, String valor2) {
		// TODO Auto-generated method stub
		
		return valor1 + valor2;
	}





	private static String cerraduraPositiva(String valor1) {
		
		String retorno="";
		int n= Integer.parseInt(JOptionPane.showInputDialog("Cuantas repeticiones desea de la cerradura de kleene para esta palabra: "+ valor1));
		for(int i=1; i<= n ; i++){
			
			retorno+= valor1;
			
		}
		
		
		return retorno;
	}





	private static String union(String valor1, String valor2) {
		// TODO Auto-generated method stub
		String res= JOptionPane.showInputDialog("Cual de estas opciones desea"
				+ "\n 1)"+ valor1+
				"\n 2)"+ valor2+
				"\n 3)"+valor1+" "+valor2  );
		
		String retorno = "";
		switch (res) {
		case "1":
			
			retorno= valor1;
			
			
		
		case "2":
		
			retorno= valor2;
			
			
			
		case "3":	
			
			retorno= valor1 +valor2;
			
		
			
		default:
			res= JOptionPane.showInputDialog("Cual de estas opciones desea: "
					+ "\n 1)"+ valor1+
					"\n 2)"+ valor2+
					"\n 3)"+valor1+" "+valor2  );
		}
		
		return retorno;
		
	}





	private static String cerraduraDeKleene(String palabra) {
		
		String retorno="";
		int n= Integer.parseInt(JOptionPane.showInputDialog("Cuantas repeticiones desea de la cerradura de kleene para esta palabra: "+ palabra));
		for(int i=0; i< n ; i++){
			
			retorno+= palabra;
			
		}
		
		
		return retorno;
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}






	

}
