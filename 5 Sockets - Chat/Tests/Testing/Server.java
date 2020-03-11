import java.io.*;
import java.net.*;

public class Server{
    ServerSocket ss;
    Socket s;
	DataInputStream dis;
    DataOutputStream dos;			
	String ClientMsg, ServerMsg;
	public int ServerPort = 10;
	//public int ServerPort = 4242;
	
    public static void main (String as[]) throws IOException{
        new Server().runServer();
    }
	public void runServer() throws IOException{
            ss=new ServerSocket(ServerPort);
            System.out.println("Server Ready...");
			while(true){
				s=ss.accept();
				new ServerThread(s).start();
			}
	}

    public void ServerChat() throws IOException{
         

    }
	public class ServerThread extends Thread{
		Socket s;
		ServerThread(Socket s){
			this.s = s;
		}
		
		public void run(){
			try{
				System.out.println(s);
				System.out.println("CLIENT CONNECTED");
				dis= new DataInputStream(s.getInputStream());
				dos= new DataOutputStream(s.getOutputStream());

				do{
					ClientMsg=dis.readUTF();
					System.out.println("Client "+s.getLocalAddress().getHostName()+" Message: "+ClientMsg);
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					ServerMsg=br.readLine();
					dos.writeUTF(ServerMsg);
					dos.flush();
				}
				while(!ServerMsg.equals("bye"));				
				
				//s.close();
			}catch(IOException e){e.printStackTrace();}
		}
	}	
}