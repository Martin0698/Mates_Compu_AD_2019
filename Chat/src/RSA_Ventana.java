import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class RSA_Ventana {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RSA_Ventana window = new RSA_Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RSA_Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 400, 724, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNumerosPY = new JLabel("Numeros P y Q para Generar LLaves");
		lblNumerosPY.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumerosPY.setBounds(12, 13, 373, 16);
		frame.getContentPane().add(lblNumerosPY);
		
		textField = new JTextField();
		textField.setBounds(12, 61, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(259, 61, 116, 22);
		frame.getContentPane().add(textField_1);
		
		JLabel lblP = new JLabel("P");
		lblP.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblP.setBounds(59, 42, 56, 16);
		frame.getContentPane().add(lblP);
		
		JLabel lblQ = new JLabel("Q");
		lblQ.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblQ.setBounds(306, 42, 56, 16);
		frame.getContentPane().add(lblQ);
		
		JLabel lblLlavesPblicaY = new JLabel("LLaves P\u00FAblica y Privada");
		lblLlavesPblicaY.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLlavesPblicaY.setBounds(12, 133, 373, 16);
		frame.getContentPane().add(lblLlavesPblicaY);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(12, 188, 116, 22);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(259, 188, 116, 22);
		frame.getContentPane().add(textField_3);
		
		JLabel lblPublica = new JLabel("Publica");
		lblPublica.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPublica.setBounds(22, 162, 93, 16);
		frame.getContentPane().add(lblPublica);
		
		JLabel lblPrivada = new JLabel("Privada");
		lblPrivada.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrivada.setBounds(269, 162, 93, 16);
		frame.getContentPane().add(lblPrivada);
		
		JButton btnGenerarPrimos = new JButton("Generar Primos");
		btnGenerarPrimos.setBounds(508, 60, 121, 25);
		frame.getContentPane().add(btnGenerarPrimos);
		
		JButton btnCalculaarLlaves = new JButton("Calcular llaves");
		btnCalculaarLlaves.setBounds(508, 187, 121, 25);
		frame.getContentPane().add(btnCalculaarLlaves);
	}
}
