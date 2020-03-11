import java.net.*;
import java.io.*;

public class ServerThread extends Thread{
	Socket s;
	
	ServerThread(Socket s){
		this.s = s;
	}
	
	public void run(){
		try{
			String ClientMessage=null;
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			while(ClientMessage = br.readLine() != null) {
				System.out.println("Client "+s.getLocalAddress().getHostName()+" Message: ");
			}
			s.close();
			
		}catch(IOException e){e.printStackTrace();}
		
	}
}