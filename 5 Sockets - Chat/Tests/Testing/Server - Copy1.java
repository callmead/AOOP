import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class Server extends JFrame
{
    ServerSocket ss;
    Socket s;
    DataInputStream dis;
    DataOutputStream dos;
	String ClientString, ServerString; 
	public String ServerIP, ServerName;
	public int ServerPort = 10;

	JTextArea txtChat = new JTextArea();
	JTextField txtText = new JTextField();
	JButton btnSend = new JButton("Send");
	JLabel lblConnections = new JLabel("Connections");
	DefaultListModel listModel = new DefaultListModel();
	JList list = new JList(listModel);	
	JScrollPane sp = new JScrollPane(txtChat);

	
    public Server()
    {	
		//Fetching the IP and Host...
		InetAddress ip;
		try{
			ip = InetAddress.getLocalHost();
			//System.out.println("Server IP: " + ip.getHostAddress());
			ServerIP = ip.getHostAddress();
			ServerName = ip.getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		this.setTitle("Chat Server "+ServerIP);
		this.setBounds(100, 100, 670, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);		
		this.getContentPane().setLayout(null);

		this.getContentPane().add(txtChat);
		this.getContentPane().add(txtText);
		this.getContentPane().add(lblConnections);
		this.getContentPane().add(list);
		this.getContentPane().add(btnSend);
		this.getContentPane().add(sp);
		
		sp.setBounds(10, 11, 330, 186);
		txtChat.setEditable(false);
		DefaultCaret caret = (DefaultCaret) txtChat.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);		
		sp.setViewportView(txtChat);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		txtText.setBounds(10, 205, 330, 45);
		txtText.setColumns(10);
		btnSend.setBounds(349, 205, 89, 23);
		btnSend.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(ActionEvent x1) {
				txtChat.append("Server Message: "+txtText.getText()+"\n");
				ServerString = ("Server Message: "+txtText.getText()+"\n");
				try{
					dos.writeUTF(ServerString);
					dos.flush();
				}
				catch(Exception e){System.out.println(e);}
				
				txtText.setText("");
				txtText.requestFocus();
			}
		});
		list.setBounds(350, 36, 300, 161);
		lblConnections.setBounds(350, 12, 99, 23);
		
		this.setVisible(true);
		txtText.requestFocus();
		
        try{		
			ss=new ServerSocket(ServerPort);
			System.out.println("*** Server: "+ServerName+", IP: "+ServerIP+" Ready...\n");
			
            System.out.println("*** Client "+s.getLocalAddress().getHostName()+" Connected...\n");
			listModel.addElement(s.getLocalAddress().getHostName());
            dis= new DataInputStream(s.getInputStream());
            dos= new DataOutputStream(s.getOutputStream());
            
			ServerChat();
        }
        catch(Exception e){
             System.out.println(e);
        }
    }
	
    public static void main (String as[]){
        Server msrv = new Server();
    }

    public void ServerChat() throws IOException{
         do{
             ClientString=dis.readUTF();
             System.out.println("Client Message: "+ClientString+"\n");
			 txtChat.append("Client Message: "+ClientString+"\n"); 			 
             BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
             ServerString=br.readLine();
             txtChat.append("Server Message: "+ServerString+"\n"); 
			 dos.writeUTF("Server Message: "+ServerString+"\n");
             dos.flush();
         }
         while(!ServerString.equals("bye"));
    }
}