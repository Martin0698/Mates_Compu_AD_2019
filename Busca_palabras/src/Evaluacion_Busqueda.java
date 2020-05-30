import java.util.TreeSet;


public class Evaluacion_Busqueda {

	
	static TreeSet<String> posibles_opciones= new TreeSet<>();
	static boolean me_hice_recursivo= false;
	
	static String sub_expresion="";
	
	public static void prearacion_divide_Expresion(String expresion){
		
		recurvidad_expresion(expresion, me_hice_recursivo);
		
	}
	
	
	public static void recurvidad_expresion(String expresion, boolean recursivo){
	
		for(int i=0; i<expresion.length(); i++){
			
			if(expresion.substring(i, i+1).equals("(")){
				int tmp=i+1;
				while(!(expresion.substring(tmp, tmp+1).equals(")"))){
					
					if(expresion.substring(tmp, tmp+1).equals("+")){
						
					}
					else{
						sub_expresion += expresion.substring(tmp, tmp+1);
					}
					tmp++;
				}
				
				posibles_opciones.add(sub_expresion);
				
			}
				
				
		}
		
		System.out.println(posibles_opciones.toString());

	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
