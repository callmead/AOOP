import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

/**
 * Chat Server, Handles clients connections using sockets and ports. 
 * Run the Server program and connect as many clients as you want.
 * Current connection limit in this program is 10 which can be changed.
 * @author Adeel Malik
 * @since 04/03/2017
 * @version 1.0
 */
 
public class Server extends JFrame implements Runnable{//Class Server
	ServerThread clients[] = new ServerThread[10]; //Number of Clients that can connect simultaneously...
	ServerSocket ServerSOCK = null;
	Thread thread = null;
	int clientCount = 0;
	int port;
	String ServerIP, ServerName, ClientIP;
	JTextArea txtStatus = new JTextArea();
	JScrollPane sp = new JScrollPane(txtStatus);
	JTextField txtPort = new JTextField();
	JButton btnStart = new JButton("Start Server");

	public Server(){//Server Constructor
		DefaultCaret caret = (DefaultCaret) txtStatus.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);			
		loadInterface();		
	}//End Server Constructor

	private void loadInterface() 
	{//Server loadInterface
		InetAddress ip;
		try{
			ip = InetAddress.getLocalHost();
			ServerIP = ip.getHostAddress();
			ServerName = ip.getHostName();
			txtStatus.append("*** Server: "+ServerName+", IP: "+ServerIP+" ***\n");
			txtStatus.append("\n Please specify the port number and Start Server!\n");
		} catch (UnknownHostException e) {e.printStackTrace();}
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblServer = new JLabel("Server: "+ServerName+", IP: "+ServerIP);
		lblServer.setBounds(10, 15, 266, 14);
		frame.getContentPane().add(lblServer);

		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(286, 11, 50, 23);
		frame.getContentPane().add(lblPort);

		txtPort.setBounds(317, 11, 42, 23);
		txtPort.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke1){
				if (ke1.getKeyCode() == KeyEvent.VK_ENTER){startServer();}
			}
		});
		frame.getContentPane().add(txtPort);

		btnStart.setBounds(363, 11, 110, 23);
		frame.getContentPane().add(btnStart);
		btnStart.setMnemonic('t');
		btnStart.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(ActionEvent x1) {
				startServer();
			}
		});
		
		frame.getContentPane().add(txtStatus);
		frame.getContentPane().add(sp);
		sp.setBounds(10, 38, 574, 322);
		txtStatus.setEditable(false);
		
        	
		sp.setViewportView(txtStatus);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);		
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(474, 11, 110, 23);
		frame.getContentPane().add(btnClose);
		btnClose.setMnemonic('l');
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop();
				System.exit(0);
			}
		});
		
		frame.setVisible(true);
		frame.setResizable(false);
		txtPort.requestFocus();
	}//End Server loadInterface

	public void startServer(){//Server.startServer
		if(txtPort.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please specify a Port number and Start Server!");
			txtPort.requestFocus();
		}else{
			port = Integer.parseInt(txtPort.getText());
			try{  
				txtStatus.append("\n*** Binding to port " + port + ", please wait...\n");
				ServerSOCK = new ServerSocket(port);  
				txtStatus.append("\n*** Server Ready: \n");
				txtPort.setEditable(false);
				btnStart.setEnabled(false);
				start(); 
			}
			catch(IOException ioe){txtStatus.append("\nError binding to port " + port + ": " + ioe.getMessage()+"\n");}
		}			
	}//End Server.startServer
	
	public void run(){//Server.run
		while (thread != null){  
			try{  
				txtStatus.append("\n*** Waiting for client...\n");
				addThread(ServerSOCK.accept()); 
			}
			catch(IOException ioe){ txtStatus.append("\n### Server accept error: " + ioe + "\n");}
		}
	}//End Server.run
	
	public void start(){//Server.start
		if (thread == null){  
			thread = new Thread(this); 
			thread.start();
		}	
	}//End Server.start
	
	public void stop(){//Server.stop 
		if (thread != null){  
			thread.stop(); 
			thread = null;
		}
	}//End Server.stop
	
	private int findClient(int ID){//Server.findClient
		for (int i = 0; i < clientCount; i++)
        if (clients[i].getID() == ID)
        return i;
		return -1;
	}//End Server.findClient

	public synchronized void handle(int ID, String input){//Server.handle  
		if (input.equals("bye")){  
			clients[findClient(ID)].send("bye");
			remove(ID); 
		}
		else
			for (int i = 0; i < clientCount; i++)
				clients[i].send(ClientIP + " - " + ID + " says: " + input);   
	}//End Server.handle

	public synchronized void remove(int ID){//Server.remove
		int pos = findClient(ID);
		if (pos >= 0){  
			ServerThread toTerminate = clients[pos];
			txtStatus.append("\n*** Removing client: " + ID + " at " + pos + "\n");
			if (pos < clientCount-1)
			for (int i = pos+1; i < clientCount; i++)
			clients[i-1] = clients[i];
			clientCount--;
			try{  
				toTerminate.close(); 
			}
			catch(IOException ioe){ txtStatus.append("\n### Error closing thread: " + ioe + "\n"); }
			toTerminate.stop(); 
		}
	}//End Server.remove
	
	private void addThread(Socket SOCK){//Server.addThread 
		if (clientCount < clients.length){  
			ClientIP = SOCK.getLocalAddress().getHostName();
			txtStatus.append("*** Client from IP "+ ClientIP +" accepted.\n");
			clients[clientCount] = new ServerThread(this, SOCK);
			try{  
				clients[clientCount].open(); 
				clients[clientCount].start();  
				clientCount++; 
			}
			catch(IOException ioe){ txtStatus.append("\n### Error opening thread: " + ioe + "\n");} 
		}
		else{txtStatus.append("\n*** Client "+ClientIP+" refused! Maximum " + clients.length + " reached.\n");}
	}//End Server.addThread

	public static void main(String args[]) {//Server.main
		Server ServerSOCK = null;
		ServerSOCK = new Server();
	}//End Server.main
	
	public class ServerThread extends Thread{//Class ServerThread 
		Server ServerSOCK    = null;
		Socket SOCK    = null;
		int ID = -1;
		DataInputStream streamIn  =  null;
		DataOutputStream streamOut = null;

		public ServerThread(Server _ServerSOCK, Socket _SOCK){//ServerThread Constructor  
			super();
			ServerSOCK = _ServerSOCK;
			SOCK = _SOCK;
			ID = SOCK.getPort();
		}//End ServerThread Constructor
		
		public void send(String msg){//ServerThread.send
			try{  
				streamOut.writeUTF(msg);
				streamOut.flush();
			}
			catch(IOException ioe){  
				txtStatus.append("\n### ERROR sending: " + ID + ": " + ioe.getMessage() + "\n");
				ServerSOCK.remove(ID);
				stop();
			}
		}//End ServerThread.send
		
		public int getID(){//ServerThread.getID
			return ID;
		}//End ServerThread.getID
		
		public void run(){//ServerThread.run  
			txtStatus.append("\n*** ID: " + ID +" assigned to client from IP "+ClientIP+ " \n");
			while (true){  
				try{  
					ServerSOCK.handle(ID, streamIn.readUTF());
				}
				catch(IOException ioe){  
					txtStatus.append("\n### ERROR reading: " + ID +"\n" + ioe.getMessage() + "\n");
					ServerSOCK.remove(ID);
					stop();
				}
			}
		}//End ServerThread.run
		
		public void open() throws IOException{//ServerThread.open 
			streamIn = new DataInputStream(new BufferedInputStream(SOCK.getInputStream()));
			streamOut = new DataOutputStream(new BufferedOutputStream(SOCK.getOutputStream()));
		}//End ServerThread.open
		
		public void close() throws IOException{//ServerThread.close
			if (SOCK != null)    SOCK.close();
			if (streamIn != null)  streamIn.close();
			if (streamOut != null) streamOut.close();
		}//End ServerThread.close
	}//End Class ServerThread
}//End Class Server