import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;


public class Principal {
	
	static String busqueda;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String exp= JOptionPane.showInputDialog("Ingrese su expresión regular: "
				+ "\n usando la siguiente notacion:"
				+ "\n para Cerradura de Klene: *"
				+ "\n para cerradura positiva ^"
				+ "\n para concatenación -");
						
		String posfijo=(Calculadora.convertir_APostfijo(exp));
		
		System.out.println(posfijo);
		
		busqueda= Calculadora.calculaPosFijo(posfijo);
		
		System.out.println(busqueda);
		
		Busqueda.buscar(busqueda, new File("C:\\Users\\Martin Guevara\\Desktop\\Algoritmos"));
		
		Busqueda.imprimeListaArchivo();
		
		System.out.println("Espero que haya jalado para tener 100");
	}

}
