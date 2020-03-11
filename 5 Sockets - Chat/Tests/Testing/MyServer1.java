import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class MyServer1 extends JFrame
{
    ServerSocket ss;
    Socket s;
    DataInputStream dis;
    DataOutputStream dos;
	String str, s1;

	JTextArea txtChat = new JTextArea();
	JTextField txtText = new JTextField();
	JButton btnSend = new JButton("Send");
	JLabel lblConnections = new JLabel("Connections");
	DefaultListModel listModel = new DefaultListModel();
	JList list = new JList(listModel);	
	JScrollPane sp = new JScrollPane(txtChat);

	
    public MyServer1()
    {		
		this.setTitle("Server");
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
		
		//txtChat.setBounds(10, 11, 330, 186);
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
				s1 = ("Server Message: "+txtText.getText()+"\n");
				try{
					dos.writeUTF(s1);
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
			System.out.println("Server Started");
            ss=new ServerSocket(10);
            s=ss.accept();
            System.out.println("Client "+s+" Connected...");
			
			listModel.addElement(s);
            dis= new DataInputStream(s.getInputStream());
            dos= new DataOutputStream(s.getOutputStream());
            
			ServerChat();
        }
        catch(Exception e){
             System.out.println(e);
        }
    }
	
    public static void main (String as[]){
        MyServer1 msrv = new MyServer1();
    }

    public void ServerChat() throws IOException{
         do{
             str=dis.readUTF();
             System.out.println("Client Message: "+str+"\n");
			 txtChat.append("Client Message: "+str+"\n"); 			 
             BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
             s1=br.readLine();
             txtChat.append("Server Message: "+s1+"\n"); 
			 dos.writeUTF("Server Message: "+s1+"\n");
             dos.flush();
         }
         while(!s1.equals("bye"));
    }
}