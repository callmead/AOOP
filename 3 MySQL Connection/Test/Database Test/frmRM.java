//package beximtex;
/**
 * <p>Title: BeximTex, Report Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class frmRM extends JInternalFrame
{
  ImageIcon imgIco = new ImageIcon("./Images/popup.gif");
  ImageIcon imgTab = new ImageIcon("./Images/table.gif");
  ImageIcon imgSrc = new ImageIcon("./Images/find.png");
  ImageIcon imgRef = new ImageIcon("./Images/db.gif");
  ImageIcon imgExc = new ImageIcon("./Images/exc.gif");
  ImageIcon imgQ = new ImageIcon("./Images/question32.png");
  JPanel pnlEmp = new JPanel();
  TitledBorder titledBorder1;
  JLabel lblREmp = new JLabel();
  JTextField txtREmp = new JTextField();
  JComboBox cboEmp = new JComboBox();
  JButton btnGEmp = new JButton();
  JPanel pnlEmail = new JPanel();
  JComboBox cboEmail = new JComboBox();
  JButton btnGEmail = new JButton();
  JTextField txtREmail = new JTextField();
  JLabel lblREmail = new JLabel();
  TitledBorder titledBorder2;
  JPanel pnlHardware = new JPanel();
  TitledBorder titledBorder3;
  JLabel lblREmail1 = new JLabel();
  JTextField txtEmD1 = new JTextField();
  JButton btnEmD1 = new JButton();
  JButton btnEmD2 = new JButton();
  JTextField txtEmD2 = new JTextField();
  JButton btnGEmail1 = new JButton();
  JLabel lblREmp2 = new JLabel();
  JButton btnGEmail2 = new JButton();
  JTextField txtEpD1 = new JTextField();
  JButton btnEpD2 = new JButton();
  JButton btnEpD1 = new JButton();
  JTextField txtEpD2 = new JTextField();

  public frmRM() {
    try {jbInit();}
    catch(Exception e) {e.printStackTrace();}
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(178, 178, 178)),"EMAIL REQUESTS");
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(178, 178, 178)),"EMPLOYEE");
    titledBorder3 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(178, 178, 178)),"HARDWARE REQUESTS");
    this.setFrameIcon(imgIco);
    this.getContentPane().setBackground(Color.white);
    this.setClosable(true);
    this.setIconifiable(true);
    this.setMaximizable(false);
    this.setSize(new Dimension(596, 437));
    this.setTitle("REPORT MANAGER");
    this.getContentPane().setBackground(Color.white);
    this.getContentPane().setLayout(null);
    pnlEmp.setBackground(Color.white);
    pnlEmp.setFont(new java.awt.Font("Dialog", 1, 12));
    pnlEmp.setBorder(titledBorder2);
    pnlEmp.setBounds(new Rectangle(7, 90, 430, 79));
    pnlEmp.setLayout(null);
    lblREmp.setToolTipText("");
    lblREmp.setHorizontalAlignment(SwingConstants.LEFT);
    lblREmp.setFont(new java.awt.Font("Tahoma", 1, 11));
    lblREmp.setBounds(new Rectangle(9, 19, 54, 24));
    lblREmp.setText("SELECT");
    txtREmp.setFont(new java.awt.Font("Tahoma", 1, 11));
    txtREmp.setBounds(new Rectangle(63, 20, 156, 23));
    txtREmp.setText("");
    txtREmp.setEnabled(true);
    txtREmp.addFocusListener(new FocusAdapter()
    {
      public void focusGained(FocusEvent f)
      {txtREmp.selectAll();}
      public void focusLost(FocusEvent f)
      {}
    });
    cboEmp.setBounds(new Rectangle(221, 20, 108, 23));
    btnGEmp.setBorder(BorderFactory.createRaisedBevelBorder());
    btnGEmp.setText("GENERATE");
    btnGEmp.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnGEmp.setIcon(new ImageIcon("./Images/close.gif"));
    btnGEmp.setBounds(new Rectangle(329, 19, 91, 24));
    btnGEmp.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    pnlEmail.setBackground(Color.white);
    pnlEmail.setBorder(titledBorder1);
    pnlEmail.setBounds(new Rectangle(7, 7, 430, 79));
    pnlEmail.setLayout(null);
    txtREmail.addFocusListener(new FocusAdapter()
    {
      public void focusGained(FocusEvent f)
      {txtREmail.selectAll();}
      public void focusLost(FocusEvent f)
      {}
    });
    lblREmail.setText("SELECT");
    lblREmail.setBounds(new Rectangle(9, 19, 54, 24));
    lblREmail.setFont(new java.awt.Font("Tahoma", 1, 11));
    lblREmail.setHorizontalAlignment(SwingConstants.LEFT);
    lblREmail.setToolTipText("");
    cboEmail.setBounds(new Rectangle(221, 20, 108, 23));
    btnGEmail.setBounds(new Rectangle(329, 19, 91, 24));
    btnGEmail.setText("GENERATE");
    btnGEmail.setFont(new java.awt.Font("Tahoma", 1, 11));
    txtREmail.setBounds(new Rectangle(63, 20, 156, 23));
    pnlHardware.setBackground(Color.white);
    pnlHardware.setBorder(titledBorder3);
    pnlHardware.setBounds(new Rectangle(7, 174, 430, 79));
    pnlHardware.setLayout(null);
    lblREmail1.setToolTipText("BETWEEN 2 DATES");
    lblREmail1.setHorizontalAlignment(SwingConstants.LEFT);
    lblREmail1.setFont(new java.awt.Font("Tahoma", 1, 11));
    lblREmail1.setBounds(new Rectangle(9, 44, 54, 24));
    lblREmail1.setText("DATES");
    txtEmD1.setEnabled(false);
    txtEmD1.setText("");
    txtEmD1.addFocusListener(new FocusAdapter()
        {
          public void focusGained(FocusEvent f)
          {txtEmD1.selectAll();}
          public void focusLost(FocusEvent f)
          {}
        });
    txtEmD1.setBounds(new Rectangle(63, 46, 106, 23));
    txtEmD1.setCaretColor(Color.blue);
    txtEmD1.setFont(new Font("Tahoma", 1, 12));
    txtEmD1.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent ke1)
      {}
      public void keyTyped(KeyEvent ke1)
      {
        if(txtEmD1.getText().length()>=10){ke1.consume();}
        if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==45) || (ke1.getKeyChar()==8))//45- 8BackSpace
        {}
        else
         ke1.consume();
      }
    });
    btnEmD1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    btnEmD1.setBounds(new Rectangle(170, 46, 22, 23));
    btnEmD1.setIcon(imgTab);
    btnEmD1.setMnemonic('O');
    btnEmD1.addActionListener(new ActionListener(this));
    btnEmD1.setBorder(BorderFactory.createRaisedBevelBorder());
    btnEmD1.setToolTipText("Select a Particular Date");
    txtEmD2.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent ke1){}
      public void keyTyped(KeyEvent ke1)
      {
        if(txtEmD1.getText().length()>=10){ke1.consume();}
        if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==45) || (ke1.getKeyChar()==8))//45- 8BackSpace
        {}
        else
         ke1.consume();
      }
    });
    btnEmD2.setBounds(new Rectangle(305, 46, 22, 23));
    btnEmD2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEmD2_actionPerformed(e);
      }
    });
    txtEmD2.setEnabled(false);
    txtEmD2.setBounds(new Rectangle(196, 46, 106, 23));
    btnGEmail1.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnGEmail1.setText("GENERATE");
    btnGEmail1.setBounds(new Rectangle(329, 45, 91, 24));
    btnGEmail2.setBounds(new Rectangle(330, 45, 91, 24));
    txtEpD2.setBounds(new Rectangle(197, 46, 106, 23));
    btnEpD2.setBounds(new Rectangle(306, 46, 22, 23));
    btnEpD1.setBounds(new Rectangle(171, 46, 22, 23));
    txtEpD1.setBounds(new Rectangle(64, 46, 106, 23));
    lblREmp2.setToolTipText("Between 2 Dates");
    lblREmp2.setText("DATES");
    lblREmp2.setFont(new java.awt.Font("Tahoma", 1, 11));
    lblREmp2.setBounds(new Rectangle(10, 44, 54, 24));
    pnlEmp.add(lblREmp, null);
    pnlEmp.add(btnGEmp, null);
    pnlEmp.add(cboEmp, null);
    pnlEmp.add(txtREmp, null);
    pnlEmp.add(lblREmp2, null);
    pnlEmp.add(btnGEmail2, null);
    pnlEmp.add(btnEpD2, null);
    pnlEmp.add(txtEpD2, null);
    pnlEmp.add(btnEpD1, null);
    pnlEmp.add(txtEpD1, null);
    this.getContentPane().add(pnlHardware, null);
    this.getContentPane().add(pnlEmail, null);
    this.getContentPane().add(pnlEmp, null);
    pnlEmail.add(lblREmail, null);
    pnlEmail.add(txtREmail, null);
    pnlEmail.add(cboEmail, null);
    pnlEmail.add(btnGEmail, null);
    pnlEmail.add(lblREmail1, null);
    pnlEmail.add(txtEmD1, null);
    pnlEmail.add(btnGEmail1, null);
    pnlEmail.add(btnEmD2, null);
    pnlEmail.add(txtEmD2, null);
    pnlEmail.add(btnEmD1, null);

    getComboItems();
  }
  void getComboItems()
  {
    cboEmp.addItem("Designation");
    cboEmp.addItem("Department");
    cboEmp.addItem("DeptHead");
    cboEmp.addItem("HeadDesg");
    cboEmp.addItem("BU");
    cboEmp.addItem("UserType");

    cboEmail.addItem("DeptAppBy");
    cboEmail.addItem("ISAppBy");
  }
  void btnEmD1_actionPerformed(ActionEvent e) {
    frmDate fd = new frmDate("Select Joining Date");
    fd.setSize(new Dimension(212, 163));
    fd.setVisible(true);
    String SDate = fd.createDate();
    txtEmD1.setText(SDate);
  }

  void btnEmD2_actionPerformed(ActionEvent e) {
    frmDate fd = new frmDate("Select Joining Date");
    fd.setSize(new Dimension(212, 163));
    fd.setVisible(true);
    String SDate = fd.createDate();
    txtEmD2.setText(SDate);
  }
}

class ActionListener implements java.awt.event.ActionListener {
  frmRM adaptee;

  ActionListener(frmRM adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnEmD1_actionPerformed(e);
  }
}