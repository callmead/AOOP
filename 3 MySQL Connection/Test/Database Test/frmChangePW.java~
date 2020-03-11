package beximtex;
/**
 * <p>Title: BeximTex, Change Password</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.rmi.*;

public class frmChangePW
    extends JDialog {

  JPanel pnlMain = new JPanel();

  TitledBorder titledBorder1;
  TitledBorder titledBorder2;

  JLabel lblP = new JLabel();

  JPasswordField txtPass = new JPasswordField();

  String passWord = null;

  String usern = null;
  String empcd = null;
  char pw[];
  String tmp = null;
  char np1[];
  String tmp1 = null;
  char np2[];
  String tmp2 = null;

  ImageIcon imgLock = new ImageIcon("./Images/lockL.png");

  int t = 0;
  JLabel lblUSR = new JLabel();
  JLabel lblEMPCode = new JLabel();
  JPasswordField txtNP1 = new JPasswordField();
  JLabel lblNP1 = new JLabel();
  JPasswordField txtNP2 = new JPasswordField();
  JLabel lblNP2 = new JLabel();

	//**************************************************************
	//RMI Declare Server Object
	CommonTableController ctccon;
	//**************************************************************

  public frmChangePW(String ec, String us, String p)
  {
    empcd = ec;
    usern = us;
    passWord = p;

    try
    {jbInit();pack();}
    catch(Exception e){System.exit(0);}
  }

  private void jbInit() throws Exception
  {
		//**************************************************************
	    //getConnection: getConnected with Server
		try
		{
			ctccon = (CommonTableController)Naming.lookup(new ReadHost().getHost() + "CommonTableController");

		}catch(Exception ec)
		{
			System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
			System.out.println("Error: "+ec.getMessage());
			JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		System.out.println("\n******************************\n CLIENT READY [frmChangePW] \n******************************\n");
		//**************************************************************

    this.setTitle("CHANGE PASSWORD");
    lblUSR.setFont(new java.awt.Font("Tahoma", 1, 12));
    lblUSR.setText(usern);
    lblUSR.setBounds(new Rectangle(11, 10, 192, 16));
    lblEMPCode.setBounds(new Rectangle(11, 32, 187, 16));
    lblEMPCode.setText("EMPLOYEE CODE " + empcd);
    lblEMPCode.setFont(new java.awt.Font("Tahoma", 1, 12));
    lblEMPCode.setVerifyInputWhenFocusTarget(true);

    txtPass.setText("");
    txtPass.setFont(new java.awt.Font("Tahoma", 1, 12));
    txtPass.setBounds(new Rectangle(184, 62, 161, 19));
    txtPass.addFocusListener(new FocusAdapter()
    {
      public void focusGained(FocusEvent f)
      {txtPass.selectAll();}
      public void focusLost(FocusEvent f)
      {}
    });

    txtPass.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent ke1) {
        if (ke1.getKeyCode() == KeyEvent.VK_ENTER) {
          txtNP1.requestFocus();
        }
      }
      public void KeyReleased(KeyEvent ke1) {}
      public void KeyTyped(KeyEvent ke1) {}
    });

    txtNP1.addFocusListener(new FocusAdapter()
    {
      public void focusGained(FocusEvent f)
      {txtNP1.selectAll();}
      public void focusLost(FocusEvent f)
      {}
    });

    txtNP1.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent ke1) {
        if (ke1.getKeyCode() == KeyEvent.VK_ENTER) {
          txtNP2.requestFocus();
        }
      }
      public void KeyReleased(KeyEvent ke1) {}
      public void KeyTyped(KeyEvent ke1) {}
    });
    lblNP1.setFont(new java.awt.Font("Tahoma", 1, 12));
    lblNP1.setText("NEW PASSWORD");
    lblNP1.setBounds(new Rectangle(11, 89, 151, 16));
    txtNP1.setBounds(new Rectangle(184, 88, 161, 19));
    txtNP1.setFont(new java.awt.Font("Tahoma", 1, 12));
    txtNP2.addFocusListener(new FocusAdapter()
    {
      public void focusGained(FocusEvent f)
      {txtNP2.selectAll();}
      public void focusLost(FocusEvent f)
      {}
    });

    txtNP2.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent ke1) {
        if (ke1.getKeyCode() == KeyEvent.VK_ENTER) {
          CheckPassword();
        }
      }
      public void KeyReleased(KeyEvent ke1) {}
      public void KeyTyped(KeyEvent ke1) {}
    });
    lblNP2.setFont(new java.awt.Font("Tahoma", 1, 12));
    lblNP2.setText("CONFORM NEW PWD");
    lblNP2.setBounds(new Rectangle(11, 114, 151, 16));
    txtNP2.setBounds(new Rectangle(184, 113, 161, 19));
    txtNP2.setFont(new java.awt.Font("Tahoma", 1, 12));
    pnlMain.add(lblUSR, null);
    pnlMain.add(lblEMPCode, null);
    pnlMain.add(txtPass, null);
    pnlMain.add(txtNP1, null);
    pnlMain.add(txtNP2, null);
    pnlMain.add(lblNP1, null);
    pnlMain.add(lblNP2, null);
    pnlMain.add(lblP, null);
    this.getContentPane().add(pnlMain, null);

    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");

    pnlMain.setBackground(Color.white);
    pnlMain.setBorder(titledBorder2);
    pnlMain.setBounds(new Rectangle(7, 7, 359, 145));
    pnlMain.setLayout(null);
    lblP.setBounds(new Rectangle(11, 63, 151, 16));
    lblP.setText("CURRENT PASSWORD");
    lblP.setFont(new java.awt.Font("Tahoma", 1, 12));

    this.getContentPane().setBackground(Color.white);
    this.getContentPane().setLayout(null);
    this.setModal(true);
    this.setResizable(false);
    this.setSize(new Dimension(378, 168));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    centerForm(this);

  }

  public void centerForm(JDialog f) {
    int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    int cx = (x - f.getWidth()) / 2;
    int cy = (y - f.getHeight()) / 2;
    f.setLocation(cx, cy);
  }

  private void CheckPassword() {
    char pw[] = txtPass.getPassword();
    tmp = String.valueOf(pw);

    if (tmp.equals(passWord)) {
      char np1[] = txtNP1.getPassword();
      tmp1 = String.valueOf(np1);

      char np2[] = txtNP2.getPassword();
      tmp2 = String.valueOf(np2);

      if(tmp1.equals(tmp2)){
        ChangePassword();
      }
      else{
        JOptionPane.showMessageDialog(null, "New Password does not match Conform Password", "Restricted...", JOptionPane.ERROR_MESSAGE);
        txtNP1.requestFocus();
        return;
      }
    }
    else {
      t = t + 1;
      JOptionPane.showMessageDialog(null,
                                    "Invalid Current Password !!! \n" +
                                    "Try: " + t +
                                    " ", "Restricted...",
                                    JOptionPane.ERROR_MESSAGE);
      if (t == 3) {
        System.exit(0);
      }
      else {
        txtPass.requestFocus();
      }
    }
  }

	/**
	*	Updates User Password
	*
	*/

  private void ChangePassword()
  {
         String SQLString = "UPDATE Employees SET " +
             "Password='" + tmp2 + "' " +
             "WHERE EmpCode='" + empcd + "';";

		try
		{
			ctccon.ExecuteQuery(SQLString);
			StartWorking("UPDATING PASSWORD");

		}catch(RemoteException re)
		{System.out.println("Client [frmChangePW]: CHANGE PASSWORD Error");System.out.println("Error: "+re.getMessage());}


         JOptionPane.showMessageDialog(null, "PASSWORD CHANGED SUCESSFULLY", "Information", 1);
         System.out.println("\nPASSWORD CHANGED...");
         dispose();

  }

	/**
	*	Progress Bar
	*
	*/

	private void StartWorking(String t)
	{
		frmWork w = new frmWork(t);
		w.setSize(368, 140);
		w.setVisible(true);
	}

}