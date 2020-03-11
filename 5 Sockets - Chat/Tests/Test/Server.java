import java.io.*;
import java.net.*;

public class Server{
	public static final int PORT = 4444;
	public static void main(String[] args) throws IOException{
		new Server().runServer();
	}
	public void runServer() throws IOException{
		ServerSocket ss = new ServerSocket(PORT);
		System.out.println("Server Ready...");
		while(true){
			Socket s = ss.accept();
			new ServerThread(s).start();
		}
	}
	public class ServerThread extends Thread{
		Socket s;
		ServerThread(Socket s){
			this.s = s;
		}
		public void run(){
			try{
				String message = null;
				BufferedReader br = new BufferedReader (new InputStreamReader(s.getInputStream()));
				while((message = br.readLine()) != null){
					System.out.println("Client "+message);
				}
				s.close();
			}catch(IOException e){e.printStackTrace();}
		}
	}
}