import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class Server extends JFrame implements Runnable{  
	ServerThread clients[] = new ServerThread[10]; //Number of Clients that can connect simultaneously...
	ServerSocket ServerSOCK = null;
	Thread thread = null;
	int clientCount = 0;
	int port;
	String ServerIP, ServerName, ClientIP;
	JTextArea txtStatus = new JTextArea();
	JScrollPane sp = new JScrollPane(txtStatus);

	public Server(){
		DefaultCaret caret = (DefaultCaret) txtStatus.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);			
		loadInterface();		
	}
	private void loadInterface() 
	{
		InetAddress ip;
		try{
			ip = InetAddress.getLocalHost();
			ServerIP = ip.getHostAddress();
			ServerName = ip.getHostName();
			System.out.println("\n*** Server: "+ServerName+", IP: "+ServerIP+" ***\n");
			txtStatus.append("*** Server: "+ServerName+", IP: "+ServerIP+" ***\n");
			txtStatus.append(" Please specify the port number and Start Server!\n");
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

		JTextField txtPort = new JTextField();
		txtPort.setBounds(317, 11, 42, 23);
		frame.getContentPane().add(txtPort);

		JButton btnStart = new JButton("Start Server");
		btnStart.setBounds(363, 11, 110, 23);
		frame.getContentPane().add(btnStart);
		btnStart.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(ActionEvent x1) {
				if(txtPort.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please specify a Port number and Start Server!");
					txtPort.requestFocus();
				}else{
					port = Integer.parseInt(txtPort.getText());
					try{  
						System.out.println("*** Binding to port " + port + ", please wait...\n");
						txtStatus.append("*** Binding to port " + port + ", please wait...\n");
						ServerSOCK = new ServerSocket(port);  
						System.out.println("*** Server Ready: \n");
						txtStatus.append("*** Server Ready: \n");
						txtPort.setEditable(false);
						btnStart.setEnabled(false);
						start(); 
					}
					catch(IOException ioe){  
						System.out.println("Error binding to port " + port + ": " + ioe.getMessage()+"\n");
						txtStatus.append("Error binding to port " + port + ": " + ioe.getMessage()+"\n");
					}
				}					
			}
		});
		
		frame.getContentPane().add(txtStatus);
		frame.getContentPane().add(sp);
		sp.setBounds(10, 38, 574, 322);
		txtStatus.setEditable(false);
		
        	
		sp.setViewportView(txtStatus);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);		
		
		JButton button = new JButton("Stop Server");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				stop();
				txtPort.setEditable(true);
				btnStart.setEnabled(true);				
			}
		});
		button.setBounds(474, 11, 110, 23);
		frame.getContentPane().add(button);
		
		frame.setVisible(true);
		frame.setResizable(false);
		txtPort.requestFocus();
	}	
	public void run(){  
		while (thread != null){  
			try{  
				System.out.println("*** Waiting for client...\n"); 
				txtStatus.append("*** Waiting for client...\n");
				addThread(ServerSOCK.accept()); 
			}
			catch(IOException ioe){  
				System.out.println("### Server accept error: " + ioe + "\n"); stop(); 
				txtStatus.append("### Server accept error: " + ioe + "\n");
			}
		}
	}
	public void start(){
		if (thread == null){  
			thread = new Thread(this); 
			thread.start();
		}	
	}
	public void stop(){ 
		if (thread != null){  
			thread.stop(); 
			thread = null;
		}
	}
	private int findClient(int ID){  
		for (int i = 0; i < clientCount; i++)
        if (clients[i].getID() == ID)
        return i;
		return -1;
	}
	public synchronized void handle(int ID, String input){  
		if (input.equals("bye")){  
			clients[findClient(ID)].send("bye");
			remove(ID); 
		}
		else
			for (int i = 0; i < clientCount; i++)
				clients[i].send(ClientIP + "-" + ID + " says: " + input);   
	}
	public synchronized void remove(int ID){  
		int pos = findClient(ID);
		if (pos >= 0){  
			ServerThread toTerminate = clients[pos];
			System.out.println("*** Removing client: " + ID + " at " + pos + "\n");
			txtStatus.append("*** Removing client: " + ID + " at " + pos + "\n");
			if (pos < clientCount-1)
			for (int i = pos+1; i < clientCount; i++)
			clients[i-1] = clients[i];
			clientCount--;
			try{  
				toTerminate.close(); 
			}
			catch(IOException ioe){  
				System.out.println("### Error closing thread: " + ioe + "\n"); 
				txtStatus.append("### Error closing thread: " + ioe + "\n");
			}
			toTerminate.stop(); 
		}
	}
	private void addThread(Socket SOCK){  
		if (clientCount < clients.length){  
			ClientIP = SOCK.getLocalAddress().getHostName();
			System.out.println("*** Client from IP "+ ClientIP +" accepted.\n");
			txtStatus.append("*** Client from IP "+ ClientIP +" accepted.\n");
			clients[clientCount] = new ServerThread(this, SOCK);
			try{  
				clients[clientCount].open(); 
				clients[clientCount].start();  
				clientCount++; 
			}
			catch(IOException ioe){  
				System.out.println("### Error opening thread: " + ioe + "\n"); 
				txtStatus.append("### Error opening thread: " + ioe + "\n");
			} 
		}
		else{
			System.out.println("*** Client "+ClientIP+" refused! Maximum " + clients.length + " reached.\n");
			txtStatus.append("*** Client "+ClientIP+" refused! Maximum " + clients.length + " reached.\n");
		}
	}
	public static void main(String args[]) {
		Server ServerSOCK = null;
		ServerSOCK = new Server();
	}
	
	public class ServerThread extends Thread{  
		Server ServerSOCK    = null;
		Socket SOCK    = null;
		int ID = -1;
		DataInputStream streamIn  =  null;
		DataOutputStream streamOut = null;

		public ServerThread(Server _ServerSOCK, Socket _SOCK){  
			super();
			ServerSOCK = _ServerSOCK;
			SOCK = _SOCK;
			ID = SOCK.getPort();
		}
		public void send(String msg){   
			try{  
				streamOut.writeUTF(msg);
				streamOut.flush();
			}
			catch(IOException ioe){  
				System.out.println("### ERROR sending: " + ID + ": " + ioe.getMessage() + "\n");
				txtStatus.append("### ERROR sending: " + ID + ": " + ioe.getMessage() + "\n");
				ServerSOCK.remove(ID);
				stop();
			}
		}
		public int getID(){  
			return ID;
		}
		public void run(){  
			System.out.println("*** ID: " + ID +" assigned to client from IP "+ClientIP+ " \n");
			txtStatus.append("*** ID: " + ID +" assigned to client from IP "+ClientIP+ " \n");
			while (true){  
				try{  
					ServerSOCK.handle(ID, streamIn.readUTF());
				}
				catch(IOException ioe){  
					System.out.println("### ERROR reading: " + ID +"\n"+ ioe.getMessage() + "\n");
					txtStatus.append("### ERROR reading: " + ID +"\n" + ioe.getMessage() + "\n");
					ServerSOCK.remove(ID);
					stop();
				}
			}
		}
		public void open() throws IOException{  
			streamIn = new DataInputStream(new BufferedInputStream(SOCK.getInputStream()));
			streamOut = new DataOutputStream(new BufferedOutputStream(SOCK.getOutputStream()));
		}
		public void close() throws IOException{  
			if (SOCK != null)    SOCK.close();
			if (streamIn != null)  streamIn.close();
			if (streamOut != null) streamOut.close();
		}
	}	
}