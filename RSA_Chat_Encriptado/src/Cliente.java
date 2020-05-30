import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.*;
import java.net.*;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCliente mimarco=new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoCliente extends JFrame{
	
	public MarcoCliente(){
		
		setBounds(600,300,280,350);
				
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		
		add(milamina);
		
		setVisible(true);
		}	
	
}

class LaminaMarcoCliente extends JPanel{
	
	public LaminaMarcoCliente(){
		
		n_name= new JTextField(5);
	
		add(n_name);
		
		JLabel texto=new JLabel("-CHAT- ");
		
		add(texto);
		
		ip= new JTextField(8);
		
		add(ip);
		
		chat_h = new JTextArea(12,20);
		
		add(chat_h);
	
		campo1=new JTextField(20);
	
		add(campo1);		
	
		miboton=new JButton("Enviar");
		
		EnviaTexto mievent= new EnviaTexto();
		
		miboton.addActionListener(mievent);
		
		add(miboton);	
		
	}
	
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			//System.out.println(campo1.getText());
			
			chat_h.append("\n" + campo1.getText());
			campo1.setText("");
			
			try {
				Socket socket= new Socket("192.168.88.106", 9999);
			
				P_Envio datos= new P_Envio();
				
				datos.setN_name(n_name.getText());
				datos.setIp(ip.getText());
				datos.setMensaje(campo1.getText());
				
				ObjectOutputStream p_datos = new ObjectOutputStream(socket.getOutputStream());
				
				p_datos.writeObject(datos);
				
				socket.close();
				
			//	DataOutputStream f_salida= new DataOutputStream(socket.getOutputStream());
			
			//	f_salida.writeUTF(campo1.getText());
				//f_salida.close();
			
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		
	}
	
		
		
		
	private JTextField campo1;
	
	private JTextField n_name;
	
	private JTextField ip;
	
	private JTextArea chat_h;
	
	private JButton miboton;
	
}

class P_Envio implements Serializable{
	
	private String n_name, ip, mensaje;

	public String getN_name() {
		return n_name;
	}

	public void setN_name(String n_name) {
		this.n_name = n_name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}