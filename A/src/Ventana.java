import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;

public class Ventana {

	private JFrame frame;
	 JTextField txtPalabra;
	JTextPane textPane = new JTextPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
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
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 471, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLoadFile = new JButton("LOAD FILE");
		btnLoadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser chooser = new JFileChooser();
		        chooser.showOpenDialog(null);
		        File f = chooser.getSelectedFile();
		        String filename = f.getAbsolutePath();
		        try {
		            FileReader fr = new FileReader(f);
		            BufferedReader br = new BufferedReader(fr);
		       
		            String linea;
		            while((linea = br.readLine()) != null)
		              System.out.println(linea);
		       
		            fr.close();
		          }
		          catch(Exception e) {
		            System.out.println("Excepcion leyendo fichero "+ f + ": " + e);
		          }
		        }
			
		});
		btnLoadFile.setBounds(155, 0, 97, 25);
		frame.getContentPane().add(btnLoadFile);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBounds(12, 39, 97, 25);
		frame.getContentPane().add(btnSearch);
		
		txtPalabra = new JTextField();
		txtPalabra.setText("PALABRA");
		txtPalabra.setBounds(121, 40, 116, 22);
		frame.getContentPane().add(txtPalabra);
		txtPalabra.setColumns(10);
		
		
		textPane.setBounds(22, 76, 419, 325);
		frame.getContentPane().add(textPane);
		
		
	}

}
