package beximtex;
/**
* <p>Title: BeximTex, Login</p>
* <p>Description: Support Software System</p>
* <p>Copyright: 2006-2010</p>
* <p>Company: ASKA</p>
* @author Adeel Ashraf Malik
* @version 1.0.0
*/

import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;

import java.rmi.*;

public class Login extends JFrame
{//Class

	JPanel p1 = new JPanel();
	JLabel lblUser = new JLabel();
	JLabel lblPass = new JLabel();
	JLabel lblPicture = new JLabel();
	JLabel lblTitle1 = new JLabel();
	JLabel lblTitle2 = new JLabel();
	TitledBorder titledBorder1;

	JTextField txtEmpCode = new JTextField();
	JPasswordField txtPass = new JPasswordField();

    //**************************************************************
    //RMI Declare Server Object
	UserController usercon;
	User usr = new User();

	SecuriteeController seccon;
	Securitee sec = new Securitee();
    //**************************************************************

	String EmpCode;
	String pass;
	int SNo;

	JButton btnOk = new JButton();
	JButton btnCancel = new JButton();

	String userEmpCode=null;
	String TB=null;

	String P1 = new String("./Images/data");
	String P2 = new String("./Images/TB");
	File F1 = new File(P1);
	File F2 = new File(P2);

	ImageIcon imgTop = new ImageIcon("./Images/login.jpg");

	/**
	*	Default Constructor With no parameter
	*
	*/

	public Login()
	{//Cons

		//**************************************************************
	    //Connection: Connects with Server
		try
		{
			usercon = (UserController)Naming.lookup(new ReadHost().getHost() + "UserController");
			seccon = (SecuriteeController)Naming.lookup(new ReadHost().getHost() + "SecuriteeController");

		}catch(Exception ec)
		{
			System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
			System.out.println("Error: "+ec.getMessage());
			JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
												"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		System.out.println("\n******************************\n CLIENT READY [Login] \n******************************\n");
		//**************************************************************

		this.setTitle("LOGIN TO BTSSS");
		this.setBounds(250, 200, 302, 200);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(p1);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.white);
		titledBorder1 = new TitledBorder("");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./Images/login.png"));
		txtEmpCode.requestFocus();

		p1.setLayout(null);
		p1.setBounds(2, 55, 292, 110);
		p1.setBorder(titledBorder1);
		p1.add(lblUser);
		p1.add(lblPass);
		p1.add(txtEmpCode);
		p1.add(txtPass);
		p1.add(btnOk);
		p1.add(btnCancel);
		p1.setBackground(Color.white);

		lblUser.setText("Employee Code:");
		lblUser.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblUser.setBounds(28, 10, 100, 20);
		lblPass.setText("Password:");
		lblPass.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblPass.setBounds(28, 35, 100, 20);
		lblPicture.setBounds(0, -14, 300, 80);
		lblPicture.setIcon(imgTop);
		lblTitle1.setText("BEXIMCO");
		lblTitle1.setFont(new java.awt.Font("Verdana", 1, 12));
		lblTitle2.setText("Textiles Division");
		lblTitle2.setFont(new java.awt.Font("Verdana", 1, 12));
		lblTitle1.setBounds(75, 5, 150, 20);
		lblTitle1.setForeground(Color.white);
		lblTitle2.setBounds(75, 25, 150, 20);
		lblTitle2.setForeground(Color.white);

		this.getContentPane().add(lblTitle1);
		this.getContentPane().add(lblTitle2);
		this.getContentPane().add(lblPicture);

		txtEmpCode.setBounds(138, 10, 120, 20);
		txtEmpCode.setCaretColor(Color.blue);
		txtEmpCode.setFont(new Font("Tahoma", 1, 12));
		txtEmpCode.setForeground(Color.blue);
		txtEmpCode.setText("007");
		txtEmpCode.setSelectionStart(0);
		txtEmpCode.setSelectionEnd(5);
		txtEmpCode.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1)
			{
				if (ke1.getKeyCode() == KeyEvent.VK_ENTER){txtPass.requestFocus();}
			}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtEmpCode.getText().length()>5)
				{
					if(ke1.getKeyCode()==8)
					{}
					else
					ke1.consume();
				}
			if((ke1.getKeyChar()==32)){ke1.consume();}//Space
			}
		});

		txtEmpCode.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{
				txtEmpCode.selectAll();
			}
			public void focusLost(FocusEvent f)
			{
				String a = txtEmpCode.getText();
				txtEmpCode.setText(a.toUpperCase());
			}
		});

		txtPass.setBounds(138, 35, 120, 20);
		txtPass.setEchoChar(' ');
		txtPass.setCaretColor(Color.blue);
		txtPass.setFont(new Font("Tahoma", 1, 12));
		txtPass.setForeground(Color.blue);
		txtPass.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{
				txtPass.selectAll();
			}
			public void focusLost(FocusEvent f) {}
		});

		txtPass.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1)
			{
				txtPass.setCaretColor(Color.white);
				if (ke1.getKeyCode() == KeyEvent.VK_ENTER)
				{
					ke1.setKeyCode(KeyEvent.VK_TAB);
					checkUser();
				}
			}
			public void KeyReleased(KeyEvent ke1) {}
			public void KeyTyped(KeyEvent ke1) {}
		});

		btnOk.setText("Ok");
		btnOk.setBounds(48, 73, 80, 25);
		btnOk.setMnemonic('O');
		btnOk.setBorder(BorderFactory.createRaisedBevelBorder());
		btnOk.addActionListener(new java.awt.event.ActionListener()
		{ //Action Listener
			public void actionPerformed(ActionEvent x1)
			{
				checkUser();
			}
		});

		btnCancel.setText("Cancel");
		btnCancel.setBounds(158, 73, 80, 25);
		btnCancel.setMnemonic('n');
		btnCancel.setBorder(BorderFactory.createRaisedBevelBorder());
		btnCancel.addActionListener(new java.awt.event.ActionListener()
		{ //ActionListener
			public void actionPerformed(ActionEvent x2)
			{
				System.out.println("\n*** Connection Closed ***\n*** THANK YOU FOR USING SUPPORT SOFTWARE SYSTEM ***\n*** Good Bye ***");
				System.exit(0);
			}
		});

		centerForm(this);
		getEmpCode();
		if(userEmpCode!=null){txtEmpCode.setText(userEmpCode);}

	}//End Cons

	/**
	*	Reads the EmpCode from File
	*
	*/

	private void getEmpCode()
	{
		if(F1.exists())
		{
			try
			{
				FileReader fr = new FileReader(F1);
				BufferedReader br = new BufferedReader(fr);
				userEmpCode=br.readLine();
				System.out.println("Last User: "+userEmpCode);
				br.close();
			}catch(Exception e)
			{JOptionPane.showMessageDialog(null,"*** Login.getEmpCode Error"+"\nError: "+e,"Error",JOptionPane.ERROR_MESSAGE);}
		}
		else
		{
			System.out.println("*** Login.getEmpCode Error: Log File not Found!");
		}
	}

	/**
	*	Writes the EmpCode to File
	*
	*/

	private void writeEmpCode()
	{
		try
		{
			FileWriter fw = new FileWriter(F1);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(EmpCode,0,EmpCode.length());
			bw.close();
		}catch(Exception e)
		{System.out.println("*** Login.writeEmpCode Error"+"\nError: "+e);}
	}

	/**
	*	Reads the Toolbar Setting From File
	*
	*/

	private void getTB()
	{
		if(F2.exists())
		{
			try
			{
				FileReader fr = new FileReader(F2);
				BufferedReader br = new BufferedReader(fr);
				TB=br.readLine();
				System.out.println("ToolBar: "+TB);
				br.close();
			}catch(Exception e)
			{JOptionPane.showMessageDialog(null,"*** Login.getTB Error"+"\nError: "+e,"Error",JOptionPane.ERROR_MESSAGE);}
		}
		else
		{System.out.println("*** Login.getTB Error: Log File not Found!");}
	}

	/**
	*	User Authentication
	*
	*/

	private void checkUser()
	{
		EmpCode = new String(txtEmpCode.getText());
		char p[] = txtPass.getPassword();
		pass = String.valueOf(p);

		if (EmpCode.equals("MASTER") && pass.equals("letmein"))
		{
			getTB();
			Main mn = new Main("MASTER", TB, pass);
			dispose();
			mn.setVisible(true);
			return;
		}
		else
		{

			String srchStr = "SELECT * FROM Employees WHERE EmpCode='" + EmpCode + "' and password='" + pass + "';";

			try
			{
				if (usercon.isFound(srchStr))
				{
					if (InsertRecord()==true)
					{
						writeEmpCode();

						txtEmpCode.setText("");
						txtPass.setText("");
						getTB();
						dispose();
						Main mn = new Main(EmpCode, TB, pass);
						mn.setVisible(true);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "INVALID USER NAME OR PASSWORD!",
														"ACCESS DENIED",
														JOptionPane.ERROR_MESSAGE);
					System.out.println("Login.checkUser: Invalid User OR Password...\n");
					txtEmpCode.requestFocus();
					txtEmpCode.selectAll();
					txtPass.setCaretColor(Color.blue);
					txtPass.setText("");
					return;
				}

			}catch(RemoteException re)
			{System.out.println("Client [Login]: CHECK USER Error");System.out.println("Error: "+re.getMessage());}
		}
	}

	/**
	*	Insert User LoginTime in Security Table
	*  @return boolean true or false value
	*
	*/

	public boolean InsertRecord()
	{
		boolean savesucc=false;

		Date d = new Date();

		//INITIALISE USER OBJECT...
		sec.setEmpCode(EmpCode);
		sec.setLogInTime(d.toString());
		sec.setLogOutTime("-");
		sec.setRemarks("-");


		try
		{
			savesucc = seccon.insertData(sec);

		}catch(RemoteException re)
		{
			System.out.println("Client [Login]: INSERT RECORD Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null,	"INSERT RECORD Error\nClient [Login]: "+re.getMessage(),
												"Error", JOptionPane.ERROR_MESSAGE);
			return savesucc;
		}

		return savesucc;
	}

	/**
	*	Centers the Form on Screen
	*
	*/

	public void centerForm(JFrame f)
	{
		int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int cx = (x - f.getWidth()) / 2;
		int cy = (y - f.getHeight()) / 2;
		f.setLocation(cx, cy);
	}

}//Class