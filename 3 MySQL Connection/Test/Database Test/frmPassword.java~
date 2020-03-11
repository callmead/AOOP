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

public class frmPassword extends JDialog {

  JPanel pnlMain = new JPanel();

  TitledBorder titledBorder1;
  TitledBorder titledBorder2;

  JLabel lblP = new JLabel();

  JPasswordField txtPass = new JPasswordField();

  String passWord = null;
  String tmp = null;
  String usern = null;
  String empcd = null;

  ImageIcon imgLock = new ImageIcon("./Images/lockL.png");

  int t = 0;
  JLabel lblPic = new JLabel();
  JLabel lblUSR = new JLabel();
  JLabel lblEMPCode = new JLabel();

  public frmPassword(String ec, String us, String p) {
    empcd = ec;
    usern = us;
    passWord = p;

    try {jbInit();pack();}
    catch (Exception ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(null,
                                    "Error Occured !!!" + "\nError: " + ex,
                                    "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void jbInit() throws Exception {
    this.setTitle("LOCKED");
    lblPic.setBounds(new Rectangle(9, 8, 128, 128));
    lblPic.setIcon(imgLock);
    lblUSR.setFont(new java.awt.Font("Tahoma", 1, 12));
    lblUSR.setText(usern);
    lblUSR.setBounds(new Rectangle(153, 13, 192, 16));
    lblEMPCode.setBounds(new Rectangle(154, 64, 187, 16));
    lblEMPCode.setText("EMPLOYEE CODE " + empcd);
    lblEMPCode.setFont(new java.awt.Font("Tahoma", 1, 12));
    lblEMPCode.setVerifyInputWhenFocusTarget(true);
    pnlMain.add(lblPic, null);
    pnlMain.add(txtPass, null);
    pnlMain.add(lblUSR, null);
    pnlMain.add(lblP, null);
    pnlMain.add(lblEMPCode, null);
    this.getContentPane().add(pnlMain, null);

    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");

    pnlMain.setBackground(Color.white);
    pnlMain.setBorder(titledBorder2);
    pnlMain.setBounds(new Rectangle(7, 7, 359, 145));
    pnlMain.setLayout(null);
    lblP.setBounds(new Rectangle(153, 98, 118, 16));
    lblP.setText("ENTER PASSWORD");
    lblP.setFont(new java.awt.Font("Tahoma", 1, 12));
    txtPass.setText("");
    txtPass.setFont(new java.awt.Font("Tahoma", 1, 12));
    txtPass.setBounds(new Rectangle(153, 117, 190, 19));
    txtPass.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent ke1) {
        if (ke1.getKeyCode() == KeyEvent.VK_ENTER) {
          CheckPassword();
        }
      }
      public void KeyReleased(KeyEvent ke2) {}
      public void KeyTyped(KeyEvent ke3) {}
    });

    this.getContentPane().setBackground(Color.white);
    this.getContentPane().setLayout(null);
    this.setModal(true);
    this.setResizable(false);
    this.setSize(new Dimension(378, 168));
    this.setDefaultCloseOperation(0);
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
      dispose();
    }
    else {
      t = t + 1;
      JOptionPane.showMessageDialog(null,
                                    "Invalid Password !!! \n" +
                                    "Try: " + t +
                                    " ", "Restricted...",
                                    JOptionPane.ERROR_MESSAGE);
      if (t == 3) {
        System.exit(0);
      }
      else {
        txtPass.setText("");
      }
    }
  }
}