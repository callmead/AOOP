import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.sql.*;

/**
 * Database Connection, contains a GUI having User Name and Password entry. 
 * Run the file using the jar file conn. "java -cp conn.jar;. DBCon"
 * @author Adeel Malik
 * @since 03/20/2017
 * @version 1.0
 */

public class DBCon extends JFrame {//Class

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

	JTable tblResults = new JTable(); 
	JScrollPane sp = new JScrollPane();

    /**
     * Constructor responsible for initialization of all the containers and components
     * 
     */
	 
	public DBCon(){//Constructor

		this.setTitle("Database Connection");
		this.setBounds(250, 200, 465, 487);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);		
		this.getContentPane().setLayout(null);
		
		this.getContentPane().add(p1);
		this.getContentPane().add(lblUser);
		this.getContentPane().add(txtDBUser);
		this.getContentPane().add(lblPass);
		this.getContentPane().add(txtDBPass);
		this.getContentPane().add(btnConnect);
		this.getContentPane().add(btnExit);

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
		txtDBUser.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke1){
				if (ke1.getKeyCode() == KeyEvent.VK_ENTER){txtDBPass.requestFocus();}
			}
			public void keyTyped(KeyEvent ke1){
				if(txtDBUser.getText().length()>5){
					if(ke1.getKeyCode()==8){}
					else ke1.consume();
				}
				if((ke1.getKeyChar()==32)){ke1.consume();}//Space key
			}
		});

		txtDBUser.addFocusListener(new FocusAdapter(){
			public void focusGained(FocusEvent f){
				txtDBUser.selectAll();
			}
			public void focusLost(FocusEvent f){}
		});

		txtDBPass.setBounds(300, 10, 100, 20);
		txtDBPass.setEchoChar('*');
		txtDBPass.setCaretColor(Color.blue);
		txtDBPass.setFont(new Font("Tahoma", 1, 12));
		txtDBPass.setForeground(Color.blue);
		txtDBPass.addFocusListener(new FocusAdapter(){
			public void focusGained(FocusEvent f){
				txtDBPass.selectAll();
			}
			public void focusLost(FocusEvent f) {}
		});

		txtDBPass.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke1){
				txtDBPass.setCaretColor(Color.blue);
				if (ke1.getKeyCode() == KeyEvent.VK_ENTER){
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
		btnConnect.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(ActionEvent x1) {
				ConnectDatabase();
			}
		});

		btnExit.setText("Exit");
		btnExit.setBounds(300, 40, 80, 25);
		btnExit.setMnemonic('x');
		btnExit.setBorder(BorderFactory.createRaisedBevelBorder());
		btnExit.addActionListener(new java.awt.event.ActionListener(){ 
			public void actionPerformed(ActionEvent x2){
				System.exit(0);
			}
		});
		
		//Panel to hold JTable
		p1.setBounds(2, 80, 450, 370);
		p1.setBorder(BorderFactory.createLineBorder(Color.black));
		p1.setLayout(new BorderLayout());
        p1.add(sp,BorderLayout.CENTER);	

		txtDBUser.requestFocus();		
		
	}//End Constructor

    /**
     * The main method. 
     *
     * @param args no params
     */
	 
	public static void main(String args[]) { //Main
		DBCon dbc = new DBCon();
		dbc.setVisible(true);
	}//End Main
 
    /**
     * Connects to the Database and pulls data
     * 
     */
	 
	public void ConnectDatabase() { //ConnectDatabase
		try {
            DBurl  = "jdbc:mysql://localhost:3306/CS3331?useSSL=false";
            DBUser = new String(txtDBUser.getText());
            char p[] = txtDBPass.getPassword();
            DBPass = String.valueOf(p);      
            SQLQuery = "SELECT * FROM Test";
            DBCon = DriverManager.getConnection(DBurl, DBUser, DBPass);
            if (DBCon != null) {
                System.out.println("\nDatabase Connected!\n");
                btnConnect.setEnabled(false);
            }else {System.out.println("\nConnection Failure...\n");}
 
            Statement st = DBCon.createStatement();
            st.executeQuery(SQLQuery);
            ResultSet rs = st.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();

			String[] tableColumnsName = {rsmd.getColumnName(1)}; 
			DefaultTableModel dtm = (DefaultTableModel) tblResults.getModel();
			dtm.setColumnIdentifiers(tableColumnsName);
			int colNo = rsmd.getColumnCount();
			
            //Printing and Capturing ResultSet Data...
			System.out.println(rsmd.getColumnName(1));
            while(rs.next()){
				System.out.println(rs.getString(rsmd.getColumnName(1)));

				Object[] objects = new Object[colNo];
				for(int i=0;i<colNo;i++){
					objects[i]=rs.getObject(i+1);
				}
				dtm.addRow(objects);				
			}
			
			//Finalizing JTable Data...
			tblResults.setModel(dtm);			
			sp.getViewport().add(tblResults);
			tblResults.setColumnSelectionAllowed(true);	
            
        } catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Invalid user name or password. Please try again...", "Login Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("An error occurred. Invalid user name or password");
            ex.printStackTrace();
			txtDBUser.requestFocus();
        }
    }//End ConnectDatabase   
}//Class