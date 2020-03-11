import java.io.*;
import java.net.*;

public class Client{
	public static void main(String args[]) throws UnknownHostException, IOException{
		String name = args[0];
		Socket s = new Socket("127.0.0.1",4444);
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			String message = br.readLine();
			pw.println(name+": "+message);
		}
	}
}