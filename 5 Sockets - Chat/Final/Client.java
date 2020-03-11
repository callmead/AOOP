import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

/**
 * Chat Client, Connects to chat server using sockets and ports. 
 * Server program must be running for a client to connect.
 * Run more than one client programs at the same time.
 * @author Adeel Malik
 * @since 04/03/2017
 * @version 1.0
 */
 
public class Client extends JFrame implements Runnable{//Class Client
	Socket SOCK = null;
	Thread thread = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	ClientThread client = null;
	public String ClientIP, ClientName, serverName;
	int serverPort;
	JTextField txtServer = new JTextField();
	JTextField txtPort = new JTextField();
	JTextField txtMessage = new JTextField();	
	JTextArea txtChat = new JTextArea();
	JScrollPane sp = new JScrollPane(txtChat);
	JButton btnConnect = new JButton("Connect");
	JButton btnClose = new JButton("Close");
	JButton btnSend = new JButton("Send");
	
	public Client(){//Client Constructor
		DefaultCaret caret = (DefaultCaret) txtChat.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);			
		loadInterface();
	}//End Client Constructor
	
	private void loadInterface(){//Client.loadInterface
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
		frame.setTitle("Client "+ClientName+" running on "+ClientIP);
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
		txtPort.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke1){
				if (ke1.getKeyCode() == KeyEvent.VK_ENTER){ConnectChatServer();}
			}
		});
		frame.getContentPane().add(txtPort);
		txtPort.setColumns(5);

		btnConnect.setBounds(252, 11, 110, 23);
		btnConnect.setMnemonic('n');
		frame.getContentPane().add(btnConnect);
		btnConnect.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(ActionEvent x1) {
				ConnectChatServer();	
			}
		});

		btnClose.setBounds(372, 11, 110, 23);
		btnClose.setMnemonic('l');
		frame.getContentPane().add(btnClose);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
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
		txtMessage.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke1){
				if (ke1.getKeyCode() == KeyEvent.VK_ENTER){sendMessage();}
			}
		});
		
		frame.getContentPane().add(txtMessage);
		
		btnSend.setBounds(392, 289, 89, 23);
		frame.getContentPane().add(btnSend);
		btnSend.setMnemonic('S');
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		
		frame.setVisible(true);
		frame.setResizable(false);
		txtServer.requestFocus();
	}//End Client.loadInterface
	
	public void setFields(boolean b){//Client.setFields
		txtServer.setEditable(b);
		txtPort.setEditable(b);
		btnConnect.setEnabled(b);
		txtServer.requestFocus();
		txtServer.selectAll();
		txtPort.selectAll();
	}//End Client.setFields
	
	public void ConnectChatServer(){//Client.ConnectChatServer
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
	}//End Client.ConnectChatServer
	
	public void sendMessage(){//Client.sendMessage
		if (txtMessage.getText().equals("")){
			txtMessage.requestFocus();
		}else{
			try{  
				dos.writeUTF(txtMessage.getText().trim());
				dos.flush();
			}
			catch(IOException ioe){txtChat.append("### Sending error: " + ioe.getMessage() + "\n");}	
			
			txtMessage.setText("");
			txtMessage.requestFocus();
		}		
	}//End Client.sendMessage
	
	public void run(){//Client.run
		while (thread != null){ }
	}//End Client.run

	public void handle(String msg){//Client.handle
		if (msg.equals("bye")){  
			txtChat.append("\n**************************************************\n Good bye!");
			setFields(true);
			stop();
		}
		else{txtChat.append(msg+"\n");}
	}//End Client.handle
	
	public void start() throws IOException{//Client.start 
		dis = new DataInputStream(SOCK.getInputStream());
		dos = new DataOutputStream(SOCK.getOutputStream());
		if (thread == null){  
			client = new ClientThread(this, SOCK);
			thread = new Thread(this);                   
			thread.start();
		}
	}//End Client.start
	
	public void stop(){//Client.stop  
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
	}//End Client.stop
	
	public static void main(String args[]){//Main Client
		Client client = null;
		client = new Client();
	}//End Main Client
	
	public class ClientThread extends Thread{//Class ClientThread
		private Socket SOCK = null;
		private Client client = null;
		private DataInputStream streamIn = null;

		public ClientThread(Client _client, Socket _SOCK){//ClientThread Constructor
			client = _client;
			SOCK = _SOCK;
			open();  
			start();
		}//End ClientThread Constructor
		
		public void open(){//ClientThread.open  
			try{  
				streamIn = new DataInputStream(SOCK.getInputStream());
			}
			catch(IOException ioe){  
				txtChat.append("### Error getting input stream: " + ioe + "\n");
				client.stop();
			}
		}//End ClientThread.open
		
		public void close(){//ClientThread.close
			try{  
				if (streamIn != null) streamIn.close();
			}
			catch(IOException ioe){txtChat.append("### Error closing input stream: " + ioe + "\n");}
		}//End ClientThread.close
		
		public void run(){//ClientThread.run
			while (true){//While
				try{  
					client.handle(streamIn.readUTF());
				}
				catch(IOException ioe){
					txtChat.append("### Listening error: " + ioe.getMessage()  + "\n");
					client.stop();
				}
			}//End While
		}//End ClientThread.run
		
	}//End Class ClientThread
}//End Class Client