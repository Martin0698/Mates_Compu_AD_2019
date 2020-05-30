package color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class Ventana {

	private JFrame frame;
	private JTextField txtBase;
	private JTextPane textPane;
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
		frame.setBounds(100, 100, 450, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLoadFile = new JButton("LOAD FILE");
		frame.getContentPane().add(btnLoadFile, BorderLayout.NORTH);
		
		JButton btnLoadFile_1 = new JButton("LOAD FILE");
		btnLoadFile_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser chooser = new JFileChooser();
		        chooser.showOpenDialog(null);
		        File f = chooser.getSelectedFile();
		        String filename = f.getAbsolutePath();
		        try {
		            FileReader reader = new FileReader(filename);
		            BufferedReader br = new BufferedReader(reader);
		            textPane.read(br, null);
		            br.close();
		            textPane.requestFocus();
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(null, e);
		        }
				
			}
		});
		btnLoadFile_1.setBounds(12, 0, 408, 32);
		frame.getContentPane().add(btnLoadFile_1);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnSearch.setBounds(12, 45, 97, 25);
		frame.getContentPane().add(btnSearch);
		
		txtBase = new JTextField();
		txtBase.setText("BASE");
		txtBase.setBounds(121, 46, 299, 22);
		frame.getContentPane().add(txtBase);
		txtBase.setColumns(10);
		
		 textPane = new JTextPane();
		textPane.setBounds(12, 88, 408, 319);
		frame.getContentPane().add(textPane);
	}
}
