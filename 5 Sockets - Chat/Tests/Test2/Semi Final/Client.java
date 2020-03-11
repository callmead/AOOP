import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class Client extends JFrame implements Runnable{  
	Socket SOCK = null;
	Thread thread = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	ClientThread client = null;
	String ClientIP, ClientName, serverName;
	int serverPort;
	JTextField txtServer = new JTextField();
	JTextField txtPort = new JTextField();
	JTextField txtMessage = new JTextField();	
	JTextArea txtChat = new JTextArea();
	JScrollPane sp = new JScrollPane(txtChat);
	JButton btnConnect = new JButton("Connect");
	JButton btnDisconnect = new JButton("Disconnect");
	JButton btnSend = new JButton("Send");
	
	public Client(){ 
		DefaultCaret caret = (DefaultCaret) txtChat.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);			
		loadInterface();
	}
	private void loadInterface() 
	{
		InetAddress ip;
		try{
			ip = InetAddress.getLocalHost();
			ClientIP = ip.getHostAddress();
			ClientName = ip.getHostName();
			txtChat.append("*** Client: "+ClientName+", IP: "+ClientIP+" ***\n");
		} catch (UnknownHostException e) { e.printStackTrace(); }
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 496, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblServer = new JLabel("Server");
		lblServer.setBounds(10, 15, 50, 14);
		frame.getContentPane().add(lblServer);
		
		txtServer.setBounds(51, 12, 110, 20);
		frame.getContentPane().add(txtServer);
		txtServer.setColumns(10);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(171, 11, 50, 23);
		frame.getContentPane().add(lblPort);
		
		txtPort.setBounds(200, 11, 42, 23);
		frame.getContentPane().add(txtPort);
		txtPort.setColumns(5);

		btnConnect.setBounds(252, 11, 110, 23);
		frame.getContentPane().add(btnConnect);
		btnConnect.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(ActionEvent x1) {
				ConnectChatServer();	
			}
		});
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop();
				setFields(true);
				txtChat.append("\n**************************************************\n Good bye!");
			}
		});
		btnDisconnect.setBounds(372, 11, 110, 23);
		frame.getContentPane().add(btnDisconnect);
		
		frame.getContentPane().add(txtChat);		
		JScrollPane sp = new JScrollPane(txtChat);
		frame.getContentPane().add(sp);
		sp.setBounds(10, 38, 471, 241);
		txtChat.setEditable(false);
		DefaultCaret caret = (DefaultCaret) txtChat.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);		
		sp.setViewportView(txtChat);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);		
		
		txtMessage.setBounds(10, 290, 372, 20);
		
		frame.getContentPane().add(txtMessage);
		
		btnSend.setBounds(392, 289, 89, 23);
		frame.getContentPane().add(btnSend);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtMessage.getText().equals("")){
					txtMessage.requestFocus();
				}else{
					try{  
						dos.writeUTF(txtMessage.getText().trim());
						dos.flush();
					}
					catch(IOException ioe){  
						txtChat.append("### Sending error: " + ioe.getMessage() + "\n");
					}					
					txtMessage.setText("");
					txtMessage.requestFocus();
				}
			}
		});
		
		frame.setVisible(true);
		frame.setResizable(false);
		txtServer.requestFocus();
	}	
	
	public void setFields(boolean b){
		txtServer.setEditable(b);
		txtPort.setEditable(b);
		btnConnect.setEnabled(b);
		txtServer.requestFocus();
		txtServer.selectAll();
		txtPort.selectAll();
	}		
	public void ConnectChatServer(){
		if(txtServer.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please specify the Server IP or Name!");
			txtServer.requestFocus();
		}else if(txtPort.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please specify a Port number!");
			txtPort.requestFocus();					
		}else{				
			serverName = txtServer.getText();
			serverPort = Integer.parseInt(txtPort.getText());
			txtChat.append("*** Establishing Connection...\n");
			try{  
				SOCK = new Socket(serverName, serverPort);
				txtChat.append("*** Connected to " + serverName + ", at port " + serverPort + "\n**************************************************\n\n");
				setFields(false);
				txtMessage.requestFocus();
				start();
			}
			catch(UnknownHostException uhe){ txtChat.append("*** Host unknown: " + uhe.getMessage() + "\n"); }
			catch(IOException ioe){ txtChat.append("### Unexpected exception: " + ioe.getMessage() + "\n"); }
		}
	}
	
	public void run(){  
		while (thread != null){ }
	}

	public void handle(String msg){ 
		if (msg.equals("bye")){  
			txtChat.append("\n**************************************************\n Good bye!");
			setFields(true);
			stop();
		}
		else{txtChat.append(msg+"\n");}
	}
	public void start() throws IOException{  
		dis = new DataInputStream(SOCK.getInputStream());
		dos = new DataOutputStream(SOCK.getOutputStream());
		if (thread == null){  
			client = new ClientThread(this, SOCK);
			thread = new Thread(this);                   
			thread.start();
		}
	}
	public void stop(){  
		if (thread != null){  
			thread.stop();  
			thread = null;
		}
		try{  
			if (dis != null) dis.close();
			if (dos != null) dos.close();
			if (SOCK != null) SOCK.close();
		}
		catch(IOException ioe){txtChat.append("### Error closing...\n");}
		client.close(); client.stop();
	}
	public static void main(String args[]){  
		Client client = null;
		client = new Client();
	}
	
	public class ClientThread extends Thread{  
		private Socket SOCK = null;
		private Client client = null;
		private DataInputStream streamIn = null;

		public ClientThread(Client _client, Socket _SOCK){  
			client = _client;
			SOCK = _SOCK;
			open();  
			start();
		}
		public void open(){  
			try{  
				streamIn = new DataInputStream(SOCK.getInputStream());
			}
			catch(IOException ioe){  
				txtChat.append("### Error getting input stream: " + ioe + "\n");
				client.stop();
			}
		}
		public void close(){  
			try{  
				if (streamIn != null) streamIn.close();
			}
			catch(IOException ioe){txtChat.append("### Error closing input stream: " + ioe + "\n");}
		}
		
		public void run(){  
			while (true){  
				try{  
					client.handle(streamIn.readUTF());
				}
				catch(IOException ioe){
					txtChat.append("### Listening error: " + ioe.getMessage()  + "\n");
					client.stop();
				}
			}
		}
		
	}	
}