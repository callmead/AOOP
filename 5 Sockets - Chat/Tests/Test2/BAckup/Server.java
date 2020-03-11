import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Server implements Runnable{  
	ServerThread clients[] = new ServerThread[50];
	ServerSocket ServerSOCK = null;
	Thread thread = null;
	int clientCount = 0;
	String ServerIP, ServerName, ClientIP;

	public Server(int port){  
		InetAddress ip;
		try{
			ip = InetAddress.getLocalHost();
			ServerIP = ip.getHostAddress();
			ServerName = ip.getHostName();
			System.out.println("\n*** Server: "+ServerName+", IP: "+ServerIP+" ***\n");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		try{  
			System.out.println("*** Binding to port " + port + ", please wait...\n");
			ServerSOCK = new ServerSocket(port);  
			System.out.println("*** Server Ready: \n");
			start(); 
		}
		catch(IOException ioe){  
			System.out.println("Error binding to port " + port + ": " + ioe.getMessage()); 
		}
	}
	public void run(){  
		while (thread != null){  
			try{  
				System.out.println("*** Waiting for client...\n"); 
				addThread(ServerSOCK.accept()); 
			}
			catch(IOException ioe){  
				System.out.println("### Server accept error: " + ioe + "\n"); stop(); 
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
				clients[i].send(ID + ": " + input);   
	}
	public synchronized void remove(int ID){  
		int pos = findClient(ID);
		if (pos >= 0){  
			ServerThread toTerminate = clients[pos];
			System.out.println("*** Removing client: " + ID + " at " + pos + "\n");
			if (pos < clientCount-1)
			for (int i = pos+1; i < clientCount; i++)
			clients[i-1] = clients[i];
			clientCount--;
			try{  
				toTerminate.close(); 
			}
			catch(IOException ioe){  
				System.out.println("### Error closing thread: " + ioe + "\n"); 
			}
			toTerminate.stop(); 
		}
	}
	private void addThread(Socket SOCK){  
		if (clientCount < clients.length){  
			ClientIP = SOCK.getLocalAddress().getHostName();
			System.out.println("*** Client "+ ClientIP +" accepted.\n");
			clients[clientCount] = new ServerThread(this, SOCK);
			try{  
				clients[clientCount].open(); 
				clients[clientCount].start();  
				clientCount++; 
			}
			catch(IOException ioe){  
				System.out.println("### Error opening thread: " + ioe + "\n"); 
			} 
		}
		else
			System.out.println("*** Client "+ClientIP+" refused! Maximum " + clients.length + " reached.\n");
	}
	public static void main(String args[]) {
		
		Server ServerSOCK = null;
		ServerSOCK = new Server(Integer.parseInt(JOptionPane.showInputDialog("Enter the port number that you would like to use:")));
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
				System.out.println(ID + "### ERROR sending: " + ioe.getMessage() + "\n");
				ServerSOCK.remove(ID);
				stop();
			}
		}
		public int getID(){  
			return ID;
		}
		public void run(){  
			System.out.println("*** Client "+SOCK.getLocalAddress().getHostName()+" ID: " + ID + "\n");
			while (true){  
				try{  
					ServerSOCK.handle(ID, streamIn.readUTF());
				}
				catch(IOException ioe){  
					System.out.println(ID + "### ERROR reading: " + ioe.getMessage() + "\n");
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