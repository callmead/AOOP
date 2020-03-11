import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Client implements Runnable{  
	Socket SOCK = null;
	Thread thread = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	ClientThread client = null;
	String ClientIP, ClientName;

	public Client(String serverName, int serverPort){ 
		InetAddress ip;
		try{
			ip = InetAddress.getLocalHost();
			ClientIP = ip.getHostAddress();
			ClientName = ip.getHostName();
			System.out.println("\n*** Client: "+ClientName+", IP: "+ClientIP+" ***\n");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		System.out.println("*** Establishing Connection...\n");
		try{  
			SOCK = new Socket(serverName, serverPort);
			System.out.println("*** Connected to " + serverName + ", at port " + serverPort + "\n");
			start();
		}
		catch(UnknownHostException uhe){  
			System.out.println("*** Host unknown: " + uhe.getMessage() + "\n"); 
		}
		catch(IOException ioe){  
			System.out.println("### Unexpected exception: " + ioe.getMessage() + "\n"); 
		}
	}
	public void run(){  
		while (thread != null){  
			try{  
				dos.writeUTF(dis.readLine());
				dos.flush();
			}
			catch(IOException ioe){  
				System.out.println("### Sending error: " + ioe.getMessage() + "\n");
				stop();
			}
		}
	}
	public void handle(String msg){  
		if (msg.equals("bye")){  
			System.out.println("*** Good bye!");
			stop();
		}
		else
			System.out.println(msg);
	}
	public void start() throws IOException{  
		dis   = new DataInputStream(System.in);
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
		catch(IOException ioe){  
			System.out.println("### Error closing...\n"); 
		}
		client.close();  
		client.stop();
	}
	public static void main(String args[]){  
		Client client = null;
		client = new Client (JOptionPane.showInputDialog("Enter the Server IP: "), Integer.parseInt(JOptionPane.showInputDialog("Enter the Server Port: ")));
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
				System.out.println("### Error getting input stream: " + ioe + "\n");
				client.stop();
			}
		}
		public void close(){  
			try{  
				if (streamIn != null) streamIn.close();
			}
			catch(IOException ioe){  
				System.out.println("### Error closing input stream: " + ioe + "\n");
			}
		}
		public void run(){  
			while (true){  
				try{  
					client.handle(streamIn.readUTF());
				}
				catch(IOException ioe){  
					System.out.println("### Listening error: " + ioe.getMessage()  + "\n");
					client.stop();
				}
			}
		}
	}	
}