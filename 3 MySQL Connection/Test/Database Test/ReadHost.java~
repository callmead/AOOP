package beximtex;
/**
 * <p>Title: BeximTex, User Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.io.*;
import javax.swing.*;

class ReadHost
{//Class

	String serverAddress=null;
	BufferedReader br=null;

	public ReadHost()
	{//Constructor
		try
		{
			br=new BufferedReader(new FileReader("server.inf"));
			serverAddress=br.readLine();

		}catch(FileNotFoundException _ex)
		 {
			 serverAddress=JOptionPane.showInputDialog(null, "Enter The Server Name OR IP Address");

			 try
			 {
				 if(br!=null) br.close();
				 PrintWriter pw=new PrintWriter(new FileOutputStream("server.inf"));
				 pw.println(serverAddress);
				 pw.close();
			 }catch(Exception e) {}
		 }
		 catch(IOException ex){}

	}//Constructor

	public String getHost()
	{//getHost

		return "rmi://"+serverAddress+"/";

	}//getHost

}//Class