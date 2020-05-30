import javax.swing.*;

import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoServidor mimarco=new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}	
}

class MarcoServidor extends JFrame implements Runnable {
	
	public MarcoServidor(){
		
		setBounds(1200,300,280,350);				
			
		JPanel milamina= new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto=new JTextArea();
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
		
		Thread hilo= new Thread(this);
		hilo.start();
		
		}
	
	private	JTextArea areatexto;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		try {
			ServerSocket servidor= new ServerSocket(9999);
			
			String nick, ip, mensaje;
			
			P_Envio p_recibido;
			
			while(true){
			
				Socket socket= servidor.accept();
				
				//recibido
				
				ObjectInputStream p_datos= new ObjectInputStream(socket.getInputStream());
				
				p_recibido= (P_Envio) p_datos.readObject();
				
				nick= p_recibido.getN_name();
				ip= p_recibido.getIp();
				mensaje= p_recibido.getMensaje();
				
				areatexto.append("\n"+ nick +": " + mensaje+ " para "+ ip);
				
				
				// envio
				Socket destino= new Socket(ip,9090);
				
				ObjectOutputStream p_re= new ObjectOutputStream(destino.getOutputStream());
				
				p_re.writeObject(p_recibido);
				
				p_re.close();
				
				destino.close();
				
				socket.close();
				//DataInputStream f_entrada= new DataInputStream(socket.getInputStream());
				
				//String m_texto= f_entrada.readUTF();
				
				//areatexto.append("\n" + m_texto);
				
				
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
