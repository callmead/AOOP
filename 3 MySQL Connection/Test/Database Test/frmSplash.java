//package beximtex;
/**
 * <p>Title: BeximTex, Splash Screen</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.applet.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;

public class frmSplash extends JWindow
{
  JPanel pnl = new JPanel();
  JLabel lblPicture = new JLabel();
  JLabel lblLoad = new JLabel();
  JLabel lblLine = new JLabel();
  JLabel lblVer = new JLabel();
  JLabel lblCopyright = new JLabel();

  String MyTheme = null;
  String path = new String("./Images/LF");
  File f = new File(path);


  public static void main(String[] args)
  {
    String vers = System.getProperty("java.version");
    System.out.println("**********************************************\n********** SUPPORT SOFTWARE SYSTEM ***********\n**********************************************\nDeveloped for BEXIMCO Textiles Division\nCopyright(R) [ASKA] 2006 - Adeel Ashraf Malik\nAll Rights Reserved\nServer Software Version: 5.2.02\n\nFor Support contact \nEmail: adeel_s90@hotmail.com\nURL:   malik.co.nr\n\nSpecial Thanks To:\nBM Nazmul Haque\n\nCurrent Java Ver: "+vers+"\n**********************************************\nLoading Software Please Wait...");
    if (vers.compareTo("1.4.1") < 0){System.out.println("*** WARNING: Software must run with a 1.4.1 or higher version VM!!!");System.exit(0);}
    frmSplash frame1 = new frmSplash();
  }

  public frmSplash()
  {
    this.getContentPane().setLayout(null);
    ImageIcon imgSplash = new ImageIcon("./Images/sps.jpg");
    ImageIcon imgLoad = new ImageIcon("./Images/sp2.gif");
    ImageIcon imgLine = new ImageIcon("./Images/sp3.gif");

    pnl.setLayout(null);
    pnl.setBounds(0, 0, 400, 400);
    pnl.setBackground(Color.black);
    pnl.add(lblPicture);
    pnl.add(lblLine);
    pnl.add(lblLoad);
    pnl.add(lblVer);

    lblPicture.setIcon(imgSplash);
    lblLine.setIcon(imgLine);
    lblLoad.setIcon(imgLoad);

    lblPicture.setBounds(0, -7, 400, 366);
    lblLoad.setBounds(1, 363, 110, 15);
    lblVer.setBounds( 120, 363, 280, 15);
    lblVer.setText("[Server] Software Version 5.2.02 ");
    lblVer.setFont(new java.awt.Font("Tahoma", 1, 12));
    lblVer.setHorizontalAlignment(SwingConstants.RIGHT);
    lblVer.setForeground(Color.white);
    lblLine.setBounds( -5, 380, 400, 18);

    this.setSize(400, 400);
    this.getContentPane().add(pnl);
    this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    this.getContentPane().setBackground(Color.black);
    centerForm(this);
    getLF();setLF();
    this.setVisible(true);
    playAudioSound("./Sounds/Snd.wav");

    try {Thread.sleep(5000);}
    catch (InterruptedException ie) {
      JOptionPane.showMessageDialog(null,
                                    "Error Occured !!!" + "\nError: " + ie,
                                    "Error", JOptionPane.ERROR_MESSAGE);
    }
    dispose();
    frmLogin fl = new frmLogin();
    fl.setVisible(true);
  }

  public void centerForm(JWindow f) {
    int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    int cx = (x - f.getWidth()) / 2;
    int cy = (y - f.getHeight()) / 2;
    f.setLocation(cx, cy);
  }

  public void playAudioSound(String strAudio) {
    try {
      URL url = new URL("file:" + strAudio);
      AudioClip ac = Applet.newAudioClip(url);
      ac.play();
    }
    catch (Exception e) {System.out.println(e);}
  }

  private void getLF()
  {
    if(f.exists())
    {
      try
      {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        MyTheme=br.readLine();
        System.out.println("\nUser Theme: "+MyTheme);
        br.close();

      }catch(Exception e){JOptionPane.showMessageDialog(null,"*** frmSplash.getLF Error"+"\nError: "+e,"Error",JOptionPane.ERROR_MESSAGE);}
    }
    else{System.out.println("*** frmSplash.getLF: Look & Feel Not Set!");}
  }

  private void setLF()
  {
    if(MyTheme!=null)
    {
      try {UIManager.setLookAndFeel(MyTheme);}
      catch (Exception exc) {System.err.println("Could not load LookAndFeel: " + MyTheme);}
    }
  }
}