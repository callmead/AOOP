package beximtex;
/**
 * <p>Title: BeximTex, About Software</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.applet.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class frmAbout extends JDialog {
  JPanel pnlMain = new JPanel();
  BorderLayout borderLayout = new BorderLayout();
  JLabel lblTop = new JLabel();
  JLabel lblBottom = new JLabel();
  ImageIcon imgSplash = new ImageIcon("./Images/sp.jpg");
  ImageIcon imgLine = new ImageIcon("./Images/sp3.gif");
  JLabel lblHead = new JLabel();
  JLabel lblHead2 = new JLabel();
  JLabel lblC = new JLabel();
  JLabel lblW = new JLabel();
  JLabel lblW1 = new JLabel();
  JLabel lblW2 = new JLabel();
  JLabel lblW3 = new JLabel();
  JLabel lblW4 = new JLabel();
  JLabel lblW5 = new JLabel();
  JLabel lblDB = new JLabel();
  JLabel lblDB1 = new JLabel();
  JLabel lblEm = new JLabel();
  JLabel lblURL = new JLabel();
  JLabel lblVer = new JLabel();
  JLabel lblBT = new JLabel();
  JLabel lblDF = new JLabel();
  JButton btnOK = new JButton();

  public frmAbout(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public frmAbout() {
    this(null, "", false);
  }
  private void jbInit() throws Exception {
    pnlMain.setLayout(null);
    lblTop.setText("");
    lblTop.setIcon(imgSplash);
    lblTop.setBounds(0,0,400,382);
    lblBottom.setText("");
    lblBottom.setIcon(imgLine);
    lblBottom.setBounds( -10, 382, 400, 18);
    lblHead.setFont(new java.awt.Font("BankGothic Md BT", 0, 30));
    lblHead.setForeground(Color.white);
    lblHead.setHorizontalAlignment(SwingConstants.CENTER);
    lblHead.setHorizontalTextPosition(SwingConstants.TRAILING);
    lblHead.setText("SUPPORT SOFTWARE");
    lblHead.setBounds(new Rectangle(15, 5, 365, 34));
    lblHead2.setBounds(new Rectangle(15, 35, 365, 34));
    lblHead2.setText("SYSTEM");
    lblHead2.setHorizontalAlignment(SwingConstants.CENTER);
    lblHead2.setFont(new java.awt.Font("BankGothic Md BT", 0, 30));
    lblHead2.setForeground(Color.white);

    lblC.setText("Copyright © 2006 ASKA. All rights reserved.");
    lblC.setBounds(new Rectangle(15, 77, 365, 15));
    lblC.setFont(new java.awt.Font("Verdana", 1, 11));
    lblC.setForeground(Color.white);

    lblW.setBounds(new Rectangle(15, 156, 365, 15));
    lblW.setFont(new java.awt.Font("Verdana", 1, 11));
    lblW.setForeground(Color.white);
    lblW.setText("Warning: This software is protected by copyright law");
    lblW1.setBounds(new Rectangle(15, 174, 365, 15));
    lblW1.setFont(new java.awt.Font("Verdana", 1, 11));
    lblW1.setForeground(Color.white);
    lblW1.setText("and international treaties. Unauthorized reproduction");
    lblW2.setFont(new java.awt.Font("Verdana", 1, 11));
    lblW2.setForeground(Color.white);
    lblW2.setBounds(new Rectangle(15, 192, 365, 15));
    lblW2.setText("and distribution of this software, or any portion of it,");
    lblW3.setBounds(new Rectangle(15, 210, 365, 15));
    lblW3.setFont(new java.awt.Font("Verdana", 1, 11));
    lblW3.setForeground(Color.white);
    lblW3.setText("may result in severe civil and criminal penalties, and");
    lblW4.setFont(new java.awt.Font("Verdana", 1, 11));
    lblW4.setForeground(Color.white);
    lblW4.setBounds(new Rectangle(15, 228, 365, 15));
    lblW4.setText("will be prosecuted to the maximum extend possible");
    lblW5.setBounds(new Rectangle(15, 246, 365, 15));
    lblW5.setFont(new java.awt.Font("Verdana", 1, 11));
    lblW5.setForeground(Color.white);
    lblW5.setText("under law.");
    lblDB.setFont(new java.awt.Font("BankGothic Md BT", 0, 18));
    lblDB.setForeground(Color.white);
    lblDB.setText("DEVELOPED BY");
    lblDB.setBounds(new Rectangle(15, 285, 179, 24));

    lblDB1.setForeground(Color.white);
    lblDB1.setFont(new java.awt.Font("BankGothic Md BT", 0, 20));
    lblDB1.setText("ADEEL ASHRAF MALIK");
    lblDB1.setBounds(new Rectangle(15, 305, 380, 24));
    lblEm.setBounds(new Rectangle(15, 335, 365, 15));
    lblEm.setForeground(Color.white);
    lblEm.setText("EMAIL :  adeel_s90@hotmail.com");
    lblEm.setFont(new java.awt.Font("Verdana", 1, 11));
    lblURL.setFont(new java.awt.Font("Verdana", 1, 11));
    lblURL.setText("URL     :  malik.co.nr");
    lblURL.setForeground(Color.white);
    lblURL.setBounds(new Rectangle(15, 350, 365, 15));

    lblVer.setForeground(Color.white);
    lblVer.setHorizontalAlignment(SwingConstants.RIGHT);
    lblVer.setText("SOFTWARE VERSION 5.2.02");
    lblVer.setFont(new java.awt.Font("Verdana", 1, 11));
    lblVer.setBounds(new Rectangle(15, 370, 365, 15));

    lblDF.setText("DEVELOPED FOR");
    lblDF.setFont(new java.awt.Font("BankGothic Md BT", 0, 18));
    lblDF.setForeground(Color.white);
    lblDF.setBounds(new Rectangle(15, 100, 179, 24));

    lblBT.setText("BEXIMCO TEXTILES DIVISION");
    lblBT.setFont(new java.awt.Font("BankGothic Md BT", 0, 22));
    lblBT.setForeground(Color.white);
    lblBT.setBounds(new Rectangle(15, 120, 380, 24));


    btnOK.setBounds(new Rectangle(280, 338, 101, 25));
    btnOK.setMnemonic('0');
    btnOK.setText("OK");
    btnOK.setFont(new java.awt.Font("Verdana", 1, 11));
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });


    getContentPane().add(pnlMain);
    pnlMain.setBackground(Color.black);
    pnlMain.add(lblHead, null);
    pnlMain.add(lblC, null);
    pnlMain.add(lblBottom, null);
    pnlMain.add(lblEm, null);
    pnlMain.add(lblURL, null);
    pnlMain.add(lblVer, null);
    pnlMain.add(lblW4, null);
    pnlMain.add(lblW5, null);
    pnlMain.add(lblW, null);
    pnlMain.add(lblW1, null);
    pnlMain.add(lblW2, null);
    pnlMain.add(lblW3, null);
    pnlMain.add(lblBT, null);
    pnlMain.add(lblDF, null);
    pnlMain.add(lblDB, null);
    pnlMain.add(lblDB1, null);
    pnlMain.add(btnOK, null);
    pnlMain.add(lblHead2, null);
    pnlMain.add(lblTop, null);

    this.setSize(new Dimension(400, 400));
    this.setModal(true);
    this.setResizable(false);
    this.setTitle("About Support Software System");

    centerForm(this);
    //playAudioSound("./Sounds/Snd.wav");

  }
  public void centerForm(JDialog f) {
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
    catch (Exception e) {
      System.out.println(e);
    }
  }
}