import java.util.Queue;
import java.util.Stack;

public class Calculadora {
	
	Stack<String> operadores;
	Queue<String> datos;
	
	
	public static void postfijo(String[] expresion) {
		for(int i=0; i< expresion.length; i++){
			System.out.print(expresion[i]);
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}
