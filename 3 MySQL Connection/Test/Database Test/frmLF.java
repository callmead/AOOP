//package beximtex;
/**
 * <p>Title: BeximTex, Look & Feel</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class frmLF extends JDialog {
  JPanel panel1 = new JPanel();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  JRadioButton rdoMotif = new JRadioButton();
  JRadioButton rdoMetal = new JRadioButton();
  JLabel lblQ2a = new JLabel();
  JRadioButton rdoWindows = new JRadioButton();
  JButton btnApply = new JButton();
  static String metal= "Metal";
  static String metalClassName = "javax.swing.plaf.metal.MetalLookAndFeel";
  static String motif = "Motif";
  static String motifClassName = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
  static String windows = "Windows";
  static String windowsClassName = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

  JRadioButton metalButton, motifButton, windowsButton;
  String MyTheme = null;
  String path = new String("./Images/LF");
  File f = new File(path);

  public frmLF(Frame frame, String title, boolean modal)
  {
    super(frame, title, modal);
    try{jbInit();pack();}
    catch(Exception ex) {ex.printStackTrace();}
  }

  public frmLF() {
    this(null, "", false);
  }
  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    panel1.setLayout(null);
    panel1.setBackground(Color.white);
    panel1.setBorder(titledBorder1);
    panel1.setBounds(new Rectangle(10, 10, 316, 97));
    this.getContentPane().setLayout(null);
    rdoMotif.setBackground(Color.white);
    rdoMotif.setBounds(new Rectangle(103, 33, 92, 19));
    rdoMotif.setText("MOTIF");
    rdoMotif.setFont(new java.awt.Font("Tahoma", 1, 11));
    rdoMetal.setBackground(Color.white);
    rdoMetal.setText("METAL");
    rdoMetal.setFont(new java.awt.Font("Tahoma", 1, 11));
    rdoMetal.setBounds(new Rectangle(11, 33, 92, 19));
    lblQ2a.setBounds(new Rectangle(10, 2, 290, 24));
    lblQ2a.setText("SELECT YOUR THEME");
    lblQ2a.setFont(new java.awt.Font("Tahoma", 1, 11));
    rdoWindows.setFont(new java.awt.Font("Tahoma", 1, 11));
    rdoWindows.setText("WINDOWS");
    rdoWindows.setBounds(new Rectangle(200, 33, 92, 19));
    rdoWindows.setBackground(Color.white);
    ButtonGroup group = new ButtonGroup();
    this.getContentPane().setBackground(new Color(0, 74, 97));
    group.add(rdoMotif);
    group.add(rdoMetal);
    group.add(rdoWindows);
    btnApply.setBounds(new Rectangle(11, 59, 293, 27));
    btnApply.setMnemonic('A');
    btnApply.setText("APPLY");
    btnApply.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnApply.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(ActionEvent e)
          {
            if(rdoMetal.isSelected()){MyTheme=metalClassName;}
            if(rdoMotif.isSelected()){MyTheme=motifClassName;}
            if(rdoWindows.isSelected()){MyTheme=windowsClassName;}
            writeLF(MyTheme);
            frmWork w = new frmWork("SAVING SETTING");
            w.setSize(368, 140);
            w.setVisible(true);
            JOptionPane.showMessageDialog(null, "Look & Feel Settings Saved. Please Restart Application.", "Information", 1);
            dispose();
          }
        });

    getContentPane().add(panel1, null);
    panel1.add(lblQ2a, null);
    panel1.add(rdoMetal, null);
    panel1.add(rdoMotif, null);
    panel1.add(rdoWindows, null);
    panel1.add(btnApply, null);
    rdoMetal.setSelected(true);
    this.setModal(true);
    this.setSize(new Dimension(345, 150));
    setTitle("Look & Feel");
    centerForm(this);
  }
  private void writeLF(String x)
  {
      try
      {
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(x,0,x.length());
        bw.close();
      }catch(Exception e)
      {System.out.println("*** frmLF.writeLF Error"+"\nError: "+e);}
  }

  public void centerForm(JDialog f) {
    int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    int cx = (x - f.getWidth()) / 2;
    int cy = (y - f.getHeight()) / 2;
    f.setLocation(cx, cy);
  }
}