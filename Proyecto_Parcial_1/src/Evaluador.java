import java.util.ArrayList;

public class Evaluador {
	
	
	//Atributos
	static ArrayList<Nodos> subexpresiones = new ArrayList<>();
	
	
	
	// Método que reciba la expresión y la divida de forma correcta
	public static void divide_Expresion(String Expresion){
		String sub_expresion="";
		
		for(int i=0; i< Expresion.length();i++){
			
			if(Expresion.charAt(i) == '*'){
				if( Expresion.charAt(i-1) == ')'){
					int tmp=i;
					while(Expresion.charAt(tmp) != '('){
						sub_expresion= sub_expresion+ String.valueOf(Expresion.charAt(tmp));
					}
					
				}
				else{
					sub_expresion= String.valueOf(Expresion.charAt(i-1));
				}
					
			}
			
			else if(Expresion.charAt(i) == '+'){
				
			}
			
			else if(Expresion.charAt(i) == '~'){
				
			}
			else if(Expresion.charAt(i) == '('){
				
				while(Expresion.charAt(i) != ')'){
					int tmp=i;
					sub_expresion= sub_expresion+ String.valueOf(Expresion.charAt(tmp));

				}
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//entrada= aba*
		
		
		
	}
}
