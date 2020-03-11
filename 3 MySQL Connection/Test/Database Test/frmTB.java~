package beximtex;
/**
 * <p>Title: BeximTex, Toolbar</p>
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

public class frmTB extends JDialog {
  JPanel panel1 = new JPanel();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  JRadioButton rdoH = new JRadioButton();
  JRadioButton rdoD = new JRadioButton();
  JLabel lblQ2a = new JLabel();
  JButton btnApply = new JButton();

  JRadioButton metalButton, motifButton, windowsButton;
  String TB = null;
  String path = new String("./Images/TB");
  File f = new File(path);
  String EmpCode=null;

  public frmTB(String EC)
  {
    EmpCode = EC;
    try {jbInit();pack();}
    catch(Exception ex) {ex.printStackTrace();}
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    panel1.setLayout(null);
    panel1.setBackground(Color.white);
    panel1.setBorder(titledBorder1);
    panel1.setBounds(new Rectangle(10, 10, 209, 97));
    this.getContentPane().setLayout(null);
    rdoH.setBackground(Color.white);
    rdoH.setBounds(new Rectangle(103, 33, 92, 19));
    rdoH.setText("HIDE");
    rdoH.setFont(new java.awt.Font("Tahoma", 1, 11));
    rdoD.setBackground(Color.white);
    rdoD.setText("DISPLAY");
    rdoD.setFont(new java.awt.Font("Tahoma", 1, 11));
    rdoD.setBounds(new Rectangle(11, 33, 92, 19));
    lblQ2a.setBounds(new Rectangle(10, 2, 290, 24));
    lblQ2a.setText("TOOLBAR SETTING");
    lblQ2a.setFont(new java.awt.Font("Tahoma", 1, 11));
    ButtonGroup group = new ButtonGroup();
    this.getContentPane().setBackground(new Color(0, 74, 97));
    group.add(rdoH);
    group.add(rdoD);
    btnApply.setBounds(new Rectangle(11, 59, 185, 27));
    btnApply.setMnemonic('A');
    btnApply.setText("APPLY");
    btnApply.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnApply.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(ActionEvent e)
          {
            if(rdoD.isSelected()){TB="Display";}
            if(rdoH.isSelected()){TB="Hide";}
            writeTB(TB);
            work(TB);
            frmWork w = new frmWork("SAVING SETTING");
            w.setSize(368, 140);
            w.setVisible(true);
            JOptionPane.showMessageDialog(null, "Toolbar Settings Saved. Please Restart Application.", "Information", 1);
            dispose();
          }
        });

    getContentPane().add(panel1, null);
    panel1.add(lblQ2a, null);
    panel1.add(rdoD, null);
    panel1.add(rdoH, null);
    panel1.add(btnApply, null);
    rdoD.setSelected(true);
    this.setModal(true);
    this.setSize(new Dimension(235, 119));
    setTitle("Toolbar");
    centerForm(this);
  }
  private void writeTB(String x)
  {
      try
      {
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(x,0,x.length());
        bw.close();
      }catch(Exception e)
      {System.out.println("*** frmTB.writeTB Error"+"\nError: "+e);}
  }
  private void centerForm(JDialog f) {
    int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    int cx = (x - f.getWidth()) / 2;
    int cy = (y - f.getHeight()) / 2;
    f.setLocation(cx, cy);
  }
  private void work(String y)
  {
    frmMain fm = new frmMain(EmpCode,"","");
    fm.setToolBar(y);
  }
}