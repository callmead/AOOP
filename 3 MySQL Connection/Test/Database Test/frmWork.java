//package beximtex;
/**
 * <p>Title: BeximTex, Processor [Work]</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class frmWork extends JDialog {//Class

  JPanel jPanel1 = new JPanel();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  JLabel lblPicDown = new JLabel();
  JLabel jLabel2 = new JLabel();
  String T = null;

 /**
  * Default Constructor
  *
  */
  public frmWork(String title) {//Cons
    T = title;
    try {jbInit();pack();}
    catch (Exception ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(null,
                                    "Error Occured !!!" + "\nError: " + ex,
                                    "Error", JOptionPane.ERROR_MESSAGE);
    }
  }//Cons

  private void jbInit() throws Exception {//jbInit
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    jPanel1.setBackground(Color.white);
    jPanel1.setBorder(titledBorder2);
    jPanel1.setBounds(new Rectangle(8, 11, 343, 90));
    jPanel1.setLayout(null);
    lblPicDown.setText("");
    lblPicDown.setBounds(new Rectangle(61, 50, 229, 29));
    lblPicDown.setIcon(new ImageIcon("./Images/busy.gif"));
    jLabel2.setBounds(new Rectangle(8, 9, 170, 16));
    jLabel2.setText("Please wait...");
    jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
    jPanel1.add(lblPicDown, null);
    jPanel1.add(jLabel2, null);
    this.getContentPane().add(jPanel1, null);
    this.getContentPane().setBackground(Color.white);
    this.getContentPane().setLayout(null);
    this.setModal(true);
    this.setSize(new Dimension(368, 140));
    this.setTitle(T);
    this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    this.setDefaultCloseOperation(0);
    centerForm(this);
    Process();
  }//jbInit


   /**
    * Process [Progress Bar]
    *
    */
  public void Process() {//Process
    Thread TMain = new Thread(new Runnable() {
      public void run() {
        try {Thread.sleep(2000);}
        catch (InterruptedException ie) {
          JOptionPane.showMessageDialog(null,
                                        "Error Occured !!!" + "\nError: " + ie,
                                        "Error", JOptionPane.ERROR_MESSAGE);
        }
        dispose();
      }
    });
    TMain.start();
  }//Process

 /**
  * Move the form to Screen Center
  *
  */
  public void centerForm(JDialog f) {//CenterForm
    int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    int cx = (x - f.getWidth()) / 2;
    int cy = (y - f.getHeight()) / 2;
    f.setLocation(cx, cy);
  }//CenterForm
}//Class