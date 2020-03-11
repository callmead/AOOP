//code for client
//Code Retrieved from: http://stackoverflow.com/questions/28308584/connecting-two-computers-for-client-server-communication-in-java
import java.io.*;
import java.net.*;

public class MyClient1
{
    Socket s;
    DataInputStream din;
    DataOutputStream dout;
    public MyClient1()
    {
         try
         {
             //s=new Socket("10.10.0.3,10");
             s=new Socket("localhost",10);
             System.out.println(s);
             din= new DataInputStream(s.getInputStream());
             dout= new DataOutputStream(s.getOutputStream());
             ClientChat();
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
     }
     public void ClientChat() throws IOException
     {
           BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
           String s1;
           do
           {
               s1=br.readLine();
               dout.writeUTF(s1);
               dout.flush();
               System.out.println("Server Message:"+din.readUTF());
           }
           while(!s1.equals("stop"));
    }
    public static void main(String as[])
    {
        new MyClient1(); 
    }
}