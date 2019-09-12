import javax.swing.JOptionPane;

public class Principal {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String exp= JOptionPane.showInputDialog("Ingrese su expresión regular: "
				+ "\n usando la siguiente notacion:"
				+ "\n para Cerradura de Klene: *"
				+ "\n para cerradura positiva ^"
				+ "\n para concatenación -");
		
		
		
		
		System.out.println(Calculadora.convertir_APostfijo(exp));
		
		Calculadora.calculaPosFijo(Calculadora.convertir_APostfijo(exp));
	}

}
