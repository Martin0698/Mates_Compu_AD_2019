import javax.swing.JOptionPane;

public class Principal {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//entrada= aba*
		
		String expresion= JOptionPane.showInputDialog("Ingrese su expresión regular");
		
		Evaluador.divide_Expresion(expresion);

	}

}
