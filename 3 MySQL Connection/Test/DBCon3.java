import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;


import java.sql.*;

public class DBCon3 extends JFrame {//Class

	JPanel p1 = new JPanel();
	JLabel lblUser = new JLabel();
	JLabel lblPass = new JLabel();
	TitledBorder titledBorder1;

	JTextField txtDBUser = new JTextField();
	JPasswordField txtDBPass = new JPasswordField();

	Connection DBCon = null;
	String DBurl = null;
	String DBUser = null;
	String DBPass = null;
	String SQLQuery = null;

	JButton btnConnect = new JButton();
	JButton btnExit = new JButton();

	JTable tblResults;//JTable(rows,columns)
	JScrollPane sp = new JScrollPane(); //Scroll for Table
 
	public DBCon3()
	{//Cons

		this.setTitle("Database Connection");
		this.setBounds(250, 200, 465, 487);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(p1);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		titledBorder1 = new TitledBorder("");
		txtDBUser.requestFocus();

		p1.setLayout(null);
		p1.setBounds(2, 2, 450, 450);
		p1.setBorder(titledBorder1);
		p1.add(lblUser); p1.add(lblPass);
		p1.add(txtDBUser); p1.add(txtDBPass);
		p1.add(btnConnect); p1.add(btnExit);

		lblUser.setText("DB User:");
		lblUser.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblUser.setBounds(28, 10, 60, 20);
		lblPass.setText("Password:");
		lblPass.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblPass.setBounds(220, 10, 60, 20);

		txtDBUser.setBounds(100, 10, 100, 20);
		txtDBUser.setCaretColor(Color.blue);
		txtDBUser.setFont(new Font("Tahoma", 1, 12));
		txtDBUser.setForeground(Color.blue);
		txtDBUser.setText("root");
		txtDBUser.setSelectionStart(0);
		txtDBUser.setSelectionEnd(5);
		txtDBUser.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1){
				if (ke1.getKeyCode() == KeyEvent.VK_ENTER){txtDBPass.requestFocus();}
			}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtDBUser.getText().length()>5)
				{
					if(ke1.getKeyCode()==8){}
					else ke1.consume();
				}
				if((ke1.getKeyChar()==32)){ke1.consume();}//Space key
			}
		});

		txtDBUser.addFocusListener(new FocusAdapter()
		{
		   public void focusGained(FocusEvent f)
			{
				txtDBUser.selectAll();
			}
			public void focusLost(FocusEvent f){}
		});

		txtDBPass.setBounds(300, 10, 100, 20);
		txtDBPass.setEchoChar('*');
		txtDBPass.setCaretColor(Color.blue);
		txtDBPass.setFont(new Font("Tahoma", 1, 12));
		txtDBPass.setForeground(Color.blue);
		txtDBPass.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{
				txtDBPass.selectAll();
			}
			public void focusLost(FocusEvent f) {}
		});

		txtDBPass.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1)
			{
				txtDBPass.setCaretColor(Color.blue);
				if (ke1.getKeyCode() == KeyEvent.VK_ENTER)
				{
					ke1.setKeyCode(KeyEvent.VK_TAB);
					ConnectDatabase();
				}
			}
			public void KeyReleased(KeyEvent ke1) {}
			public void KeyTyped(KeyEvent ke1) {}
		});

		btnConnect.setText("Connect");
		btnConnect.setBounds(100, 40, 80, 25);
		btnConnect.setMnemonic('C');
		btnConnect.setBorder(BorderFactory.createRaisedBevelBorder());
		btnConnect.addActionListener(new java.awt.event.ActionListener() 
		{		
			public void actionPerformed(ActionEvent x1) 
			{
				ConnectDatabase();
			}
		});

		btnExit.setText("Exit");
		btnExit.setBounds(300, 40, 80, 25);
		btnExit.setMnemonic('x');
		btnExit.setBorder(BorderFactory.createRaisedBevelBorder());
		btnExit.addActionListener(new java.awt.event.ActionListener()
		{ 
			public void actionPerformed(ActionEvent x2)
			{
				System.exit(0);
			}
		});

		p1.add(tblResults, null);
		tblResults.setBounds(10, 80, 430, 360);
		   
		this.setVisible(true);
		   
		if(DBUser!=null){txtDBUser.setText(DBUser);}
	}//End Cons
	 
	public static void main(String args[]) 
	{
		DBCon3 dbc = new DBCon3();
	}
 
	public void ConnectDatabase() 
	{
		try 
		{
			DBurl  = "jdbc:mysql://localhost:3306/CS3331?useSSL=false";
			DBUser = new String(txtDBUser.getText());
			char p[] = txtDBPass.getPassword();
			DBPass = String.valueOf(p);      
			SQLQuery = "SELECT * FROM Person";
			
			DBCon = DriverManager.getConnection(DBurl, DBUser, DBPass);
			if (DBCon != null) 
			{
				System.out.println("CS3331 Database Connected!\n");
				btnConnect.setEnabled(false);
			}else {System.out.println("Connection Failure...\n");}
	 
			Statement st = DBCon.createStatement();
			st.executeQuery(SQLQuery);
			ResultSet rs = st.getResultSet();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			String[] tableColumnsName = {rsmd.getColumnName(1), rsmd.getColumnName(2)}; 
			System.out.println("\n\n Hello World...\n\n");
			DefaultTableModel dtm = new DefaultTableModel();
			dtm.setColumnIdentifiers(tableColumnsName); 
			tblResults.setModel(dtm);
			
			int colNo = rsmd.getColumnCount(); 
			
			while (rs.next()) 
			{ 
				int aantal = rs.getRow(); 
				System.out.println(aantal); 
				Object[] objects = new Object[colNo]; 
				for (int i = 0; i < colNo; i++) 
				{ 
					objects[i] = rs.getObject(i + 1); 
					//print the objects for example 
					System.out.println(objects[i]); 
					int rNo = 0; 
					tblResults.setValueAt(objects[i],rNo,i); 
				} 
			} 


				
		} catch (SQLException ex) 
		{
			JOptionPane.showMessageDialog(null, "An error occurred. Invalid user name or password", "Login Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("An error occurred. Invalid user name or password");
			ex.printStackTrace();
		}
    }   
}//Class

