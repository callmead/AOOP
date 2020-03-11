import java.io.*;
import java.net.*;

public class Client1
{
    Socket s;
    DataInputStream din;
    DataOutputStream dout;
	String ClientString;
	
	public String ServerIP = "127.0.0.1";
	//public String ServerIP = "172.19.166.112";
	public int ServerPort = 10;
	
    public Client1()
    {	
        try{
            s=new Socket(ServerIP,ServerPort);
            System.out.println("Socket Details: "+s);
			System.out.println("IP: "+s.getLocalAddress().getHostName());
            din= new DataInputStream(s.getInputStream());
            dout= new DataOutputStream(s.getOutputStream());
            ClientChat();
        }catch(Exception e){
            System.out.println(e);
        }
     }
     public void ClientChat() throws IOException
     {
           BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
           do
           {
               ClientString=br.readLine();
               dout.writeUTF(ClientString);
               dout.flush();
               //System.out.println("Server Message:"+din.readUTF());
			   System.out.println(din.readUTF());
           }
           while(!ClientString.equals("bye"));
    }
    public static void main(String as[]){		
        new Client1(); 
    }
}