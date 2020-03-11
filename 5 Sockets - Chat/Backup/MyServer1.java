import java.io.*;
import java.net.*;

//Code for server
//Code Retrieved from: http://stackoverflow.com/questions/28308584/connecting-two-computers-for-client-server-communication-in-java
public class MyServer1
{
    ServerSocket ss;
    Socket s;
    DataInputStream dis;
    DataOutputStream dos;
    public MyServer1(){
        try{
			System.out.println("Server Started");
            ss=new ServerSocket(10);
            s=ss.accept();
            System.out.println(s);
            System.out.println("CLIENT CONNECTED");
            dis= new DataInputStream(s.getInputStream());
            dos= new DataOutputStream(s.getOutputStream());
            ServerChat();
        }
        catch(Exception e){ System.out.println(e); }
    }

    public static void main (String as[]){
         new MyServer1();
    }

    public void ServerChat() throws IOException{
         String str, s1;
         do{
             str=dis.readUTF();
             System.out.println("Client Message:"+str);
             BufferedReader br=new BufferedReader(new   InputStreamReader(System.in));
             s1=br.readLine();
             dos.writeUTF(s1);
             dos.flush();
         }
         while(!s1.equals("bye"));
    }
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
}