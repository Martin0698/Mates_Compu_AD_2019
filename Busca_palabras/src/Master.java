
import javax.swing.JOptionPane;

public class Master {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		String expresion_dada = JOptionPane.showInputDialog("Ingrese su expresion: ");
		
		
		Evaluacion_Busqueda.prearacion_divide_Expresion(expresion_dada);
		
	}

}
