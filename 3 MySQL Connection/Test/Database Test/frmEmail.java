//package beximtex;
/**
 * <p>Title: BeximTex, Email Request</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.text.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import java.rmi.*;

public class frmEmail extends JInternalFrame
{//Class

 JPanel pnlTop = new JPanel();
 JPanel pnlMid = new JPanel();
 JPanel pnlBottom = new JPanel();

 TitledBorder titledBorder1;
 TitledBorder titledBorder2;
 TitledBorder titledBorder3;

 JLabel lblName = new JLabel();
 JLabel lblDate = new JLabel();
 JLabel lblEmpCode = new JLabel();
 JLabel lblEID = new JLabel();
 JLabel lblDept1 = new JLabel();
 JLabel lblEmail1 = new JLabel();
 JLabel lblEmail2 = new JLabel();
 JLabel lblPass = new JLabel();
 JLabel lblRec = new JLabel();

 JTextField txtName = new JTextField();
 JTextField txtDate = new JTextField();
 JTextField txtEmpCode = new JTextField();
 JTextField txtEID = new JTextField();
 JTextField txtEmail1 = new JTextField();
 JTextField txtEmail2 = new JTextField();

 JTextField txtPass = new JPasswordField();

 JTextArea txtRemarks = new JTextArea();
 JScrollPane SPtxtR = new JScrollPane();

 JToggleButton btnSave = new JToggleButton();
 JToggleButton btnDelete = new JToggleButton();
 JToggleButton btnNew = new JToggleButton();
 JToggleButton btnEdit = new JToggleButton();
 JToggleButton btnCancel = new JToggleButton();
 JToggleButton btnNext = new JToggleButton();
 JToggleButton btnPrev = new JToggleButton();

 //**************************************************************
 //RMI Declare Server Object
 EmailController emlcon;
 Email eml = new Email();
 //**************************************************************

 ImageIcon imgFirst = new ImageIcon("./Images/iconFirst.gif");
 ImageIcon imgFO = new ImageIcon("./Images/iconFirstOver.gif");
 ImageIcon imgLast = new ImageIcon("./Images/iconLast.gif");
 ImageIcon imgLO = new ImageIcon("./Images/iconLastOver.gif");
 ImageIcon imgNext = new ImageIcon("./Images/iconNext.gif");
 ImageIcon imgNO = new ImageIcon("./Images/iconNextOver.gif");
 ImageIcon imgPrev = new ImageIcon("./Images/iconPrevious.gif");
 ImageIcon imgPO = new ImageIcon("./Images/iconPreviousOver.gif");
 ImageIcon imgIco = new ImageIcon("./Images/popup.gif");
 ImageIcon imgQ = new ImageIcon("./Images/question32.png");

 String EmpCode = null;
 String userName = null;
 String pass = null;

 String CurrentDate = null;
 String TranID = null;
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 Date d;

 int yn;
 boolean isAdd = false;
 boolean fieldsOK = false;
 JToggleButton btnClose = new JToggleButton();

 public frmEmail(String ec, String un, String p)
 {
  EmpCode = ec;
  userName = un;
  pass = p;

  try {jbInit();}
  catch (Exception e) {System.exit(0);}
 }

 private void jbInit() throws Exception
 {//jbInit

  //**************************************************************
  //Connection: Connects with Server
  try
  {
   emlcon = (EmailController)Naming.lookup(new ReadHost().getHost() + "EmailController");
  }catch(Exception ec)
  {
   System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
   System.out.println("Error: "+ec.getMessage());
   JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
   "Error", JOptionPane.ERROR_MESSAGE);
   System.exit(0);
  }
  System.out.println("\n******************************\n CLIENT READY [frmEmail] \n******************************\n");
  //**************************************************************

  titledBorder1 = new TitledBorder("");
  titledBorder2 = new TitledBorder("");
  titledBorder3 = new TitledBorder("");

  lblName.setText("NAME");
  lblName.setBounds(new Rectangle(12, 38, 131, 24));
  lblName.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblDate.setBounds(new Rectangle(287, 11, 106, 24));
  lblDate.setText("DATE");
  lblDate.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
  lblEmpCode.setBounds(new Rectangle(287, 38, 106, 24));
  lblEmpCode.setText("EMPLOYEE CODE");
  lblEmpCode.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblEmpCode.setHorizontalAlignment(SwingConstants.RIGHT);
  lblDept1.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblDept1.setText("REMARKS");
  lblDept1.setBounds(new Rectangle(12, 68, 106, 24));
  lblEID.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblEID.setBounds(new Rectangle(12, 11, 131, 24));
  lblEID.setText("TRANSACTION #");
  lblEmail1.setBounds(new Rectangle(12, 11, 131, 24));
  lblEmail1.setText("EMAIL ID1");
  lblEmail1.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblEmail2.setBounds(new Rectangle(12, 40, 131, 24));
  lblEmail2.setText("EMAIL ID2");
  lblEmail2.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblRec.setBounds(new Rectangle(230, 12, 89, 24));
  lblRec.setText("");
  lblRec.setHorizontalAlignment(SwingConstants.LEFT);
  lblRec.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblRec.setBorder(null);
  lblPass.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
  lblPass.setText("PASSWORD");
  lblPass.setBounds(new Rectangle(303, 11, 89, 24));

  txtName.setText("");
  txtName.setBounds(new Rectangle(122, 39, 140, 23));
  txtName.setEnabled(false);
  txtName.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtDate.setBounds(new Rectangle(401, 12, 140, 23));
  txtDate.setEnabled(false);
  txtDate.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtDate.setText("");
  txtEmpCode.setBounds(new Rectangle(401, 39, 140, 23));
  txtEmpCode.setText("");
  txtEmpCode.setEnabled(false);
  txtEmpCode.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtEID.setEnabled(false);
  txtEID.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtEID.setBounds(new Rectangle(122, 12, 140, 23));
  txtEID.setText("");
  txtRemarks.setText("");
  txtRemarks.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtRemarks.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1)
   {
    if (ke1.getKeyCode() == KeyEvent.VK_TAB)
    {txtEmail1.requestFocus();}
   }

   public void KeyReleased(KeyEvent ke2) {}
   public void KeyTyped(KeyEvent ke3) {}
  });
  txtRemarks.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   { txtRemarks.selectAll(); }

   public void focusLost(FocusEvent f)
   {
    if (txtRemarks.getText().equals("") || txtRemarks.getText().equals(" "))
    { txtRemarks.setText("-"); }
   }
  });

  txtEmail1.setBounds(new Rectangle(122, 12, 140, 23));
  txtEmail1.setText("");
  txtEmail1.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtEmail1.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   { txtEmail1.selectAll(); }

   public void focusLost(FocusEvent f) {}
  });
  txtEmail1.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if ((ke1.getKeyChar() >= 65 && ke1.getKeyChar() <= 90) ||
    (ke1.getKeyChar() >= 48 && ke1.getKeyChar() <= 57) ||
    (ke1.getKeyChar() >= 97 && ke1.getKeyChar() <= 122) ||
    (ke1.getKeyChar() == '@') || (ke1.getKeyChar() == 46) ||
    (ke1.getKeyChar() == 45) || (ke1.getKeyChar() == 109) ||
    (ke1.getKeyChar() == 8) || (ke1.getKeyChar() == 95)) {}
    else { ke1.consume(); }
   }
  });

  txtEmail2.setBounds(new Rectangle(122, 41, 140, 23));
  txtEmail2.setText("");
  txtEmail2.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtEmail2.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   { txtEmail2.selectAll(); }

   public void focusLost(FocusEvent f) {}
  });
  txtEmail2.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if ( (ke1.getKeyChar() >= 65 && ke1.getKeyChar() <= 90) ||
    (ke1.getKeyChar() >= 48 && ke1.getKeyChar() <= 57) ||
    (ke1.getKeyChar() >= 97 && ke1.getKeyChar() <= 122) ||
    (ke1.getKeyChar() == '@') || (ke1.getKeyChar() == 46) ||
    (ke1.getKeyChar() == 45) || (ke1.getKeyChar() == 109) ||
    (ke1.getKeyChar() == 8) || (ke1.getKeyChar() == 95)) {}
    else { ke1.consume(); }
   }
  });

  txtPass.setText("");
  txtPass.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtPass.setBounds(new Rectangle(402, 12, 140, 23));
  txtPass.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   { txtPass.selectAll(); }

   public void focusLost(FocusEvent f) {}
  });
  txtPass.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtPass.getText().length()>=8){ke1.consume();}
    if((ke1.getKeyChar()==32)){ke1.consume();}//32Space
   }
  });

  SPtxtR.setBounds(new Rectangle(123, 68, 418, 49));

  btnNew.setBounds(new Rectangle(8, 10, 91, 28));
  btnNew.setText("NEW");
  btnNew.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnNew.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    d = new Date();
    CurrentDate = null;
    TranID = new String("E");
    sdf = new SimpleDateFormat("y");
    TranID = TranID + sdf.format(d);
    sdf = new SimpleDateFormat("M");
    TranID = TranID + sdf.format(d);
    sdf = new SimpleDateFormat("d");
    TranID = TranID + sdf.format(d);
    TranID = TranID + EmpCode;
    sdf = new SimpleDateFormat("Hms");
    TranID = TranID + sdf.format(d);
    System.out.println("Transaction ID: " + TranID);

    clearFields();
    txtEID.setText(TranID);
    txtEmpCode.setText(EmpCode);
    txtName.setText(userName);
    d = new Date();
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    CurrentDate = sdf.format(d);
    txtDate.setText(CurrentDate);

    isAdd = true;
    SetInitialButtons(false);
    SetTextFields(true);
    txtRemarks.requestFocus();
    lblRec.setText(" Add New Rec. ");
   }
  });

  btnSave.setText("SAVE");
  btnSave.setBounds(new Rectangle(8, 10, 91, 28));
  btnSave.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnSave.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    CheckFields();
    if (fieldsOK)
    {
     if (isAdd)
     {
      if (save()==false)
      {
       JOptionPane.showMessageDialog(null, "UNABLE TO INSERT NEW RECORD !!!\nPlease try with valid Data ...",
                "Error", JOptionPane.ERROR_MESSAGE);
      }
      else
      {
       //BUTTON STATE...
       SetInitialButtons(true);
       //FIELD STATE...
       SetTextFields(false);
       fieldsOK = false;
      }
     }
     else
     {
      if (editData()==false)
      {
       JOptionPane.showMessageDialog(null, "UNABLE TO UPDATE RECORD !!!\nPlease try with valid Data ...",
                "Error", JOptionPane.ERROR_MESSAGE);
      }
      else
      {
       //BUTTON STATE...
       SetInitialButtons(true);
       //FIELD STATE...
       SetTextFields(false);
       fieldsOK = false;
      }
     }
     //SET FLAG...
     isAdd=false;
     lblRec.setText("");
    }
    else { return; }
   }
  });

  btnDelete.setBounds(new Rectangle(357, 9, 91, 28));
  btnDelete.setText("Delete");
  btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnDelete.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    if (txtEID.getText().equals(""))
    { return; }
    DeleteData();
   }
  });

  btnEdit.setText("EDIT");
  btnEdit.setBounds(new Rectangle(104, 10, 91, 28));
  btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnEdit.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    SetInitialButtons(false);
    SetTextFields(true);
    txtRemarks.requestFocus();
    lblRec.setText(" Edit Record. ");
   }
  });

  btnCancel.setText("CANCEL");
  btnCancel.setBounds(new Rectangle(104, 10, 91, 28));
  btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnCancel.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    SetInitialButtons(true);
    SetTextFields(false);
    //REFRESH...
    getConnected();
    isAdd = false;
    lblRec.setText("");
   }
  });


  btnNext.setText("");
  btnNext.setBounds(new Rectangle(322, 12, 22, 23));
  btnNext.setIcon(imgNext);
  btnNext.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnNext.addMouseListener(new MouseAdapter()
  {
   public void mouseEntered(MouseEvent e)
   { btnNext.setIcon(imgNO); }

   public void mouseExited(MouseEvent f)
   { btnNext.setIcon(imgNext); }
  });
  btnNext.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    try
    {
     eml=emlcon.moveNext();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmEmail]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
   }
  });

  btnPrev.setBounds(new Rectangle(207, 12, 22, 23));
  btnPrev.setText("");
  btnPrev.setIcon(imgPrev);
  btnPrev.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnPrev.addMouseListener(new MouseAdapter()
  {
   public void mouseEntered(MouseEvent e)
   { btnPrev.setIcon(imgPO); }

   public void mouseExited(MouseEvent f)
   { btnPrev.setIcon(imgPrev); }
  });
  btnPrev.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    try
    {
     eml=emlcon.movePrevious();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmEmail]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
   }
  });

  pnlTop.setBorder(titledBorder3);
  pnlTop.setBounds(new Rectangle(7, 7, 554, 127));
  pnlTop.setLayout(null);
  pnlMid.setBorder(titledBorder3);
  pnlMid.setBounds(new Rectangle(7, 141, 554, 77));
  pnlMid.setLayout(null);
  pnlBottom.setBorder(titledBorder3);
  pnlBottom.setBounds(new Rectangle(7, 226, 554, 47));
  pnlBottom.setLayout(null);
  pnlBottom.setBackground(Color.white);
  pnlBottom.setForeground(Color.white);
  pnlMid.setBackground(Color.white);
  pnlMid.setForeground(Color.white);
  pnlTop.setBackground(Color.white);
  pnlTop.setForeground(Color.white);

  btnClose.setText("CLOSE");
  btnClose.setBounds(new Rectangle(453, 9, 91, 28));
  btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnClose.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent x2)
   { dispose(); }
  });
  pnlTop.add(txtDate, null);
  pnlTop.add(lblDate, null);
  pnlTop.add(txtEID, null);
  pnlTop.add(txtName, null);
  pnlTop.add(txtEmpCode, null);
  pnlTop.add(lblEmpCode, null);
  pnlTop.add(lblEID, null);
  pnlTop.add(lblName, null);
  pnlTop.add(SPtxtR, null);
  pnlTop.add(lblDept1, null);
  this.getContentPane().add(pnlMid, null);
  SPtxtR.getViewport().add(txtRemarks, null);

  pnlBottom.add(btnEdit, null);
  pnlBottom.add(btnNew, null);
  pnlBottom.add(btnCancel, null);
  pnlBottom.add(btnSave, null);
  pnlBottom.add(btnDelete, null);
  pnlBottom.add(lblRec, null);
  pnlBottom.add(btnPrev, null);
  pnlBottom.add(btnNext, null);
  pnlBottom.add(btnClose, null);
  this.getContentPane().add(pnlTop, null);

  pnlMid.add(txtEmail1, null);
  pnlMid.add(txtEmail2, null);
  pnlMid.add(lblEmail1, null);
  pnlMid.add(lblEmail2, null);
  pnlMid.add(lblPass, null);
  pnlMid.add(txtPass, null);
  this.getContentPane().add(pnlBottom, null);

  this.getContentPane().setLayout(null);
  this.setTitle("EMAIL REQUEST FORM");
  this.setForeground(Color.white);
  this.setFrameIcon(imgIco);
  this.getContentPane().setBackground(Color.white);
  this.setClosable(true);
  this.setIconifiable(true);
  this.setMaximizable(false);
  this.setSize(new Dimension(578, 314));

  SetTextFields(false);
  SetInitialButtons(true);
  getConnected();

 }//jbInit

 /**
 * Setting Text Fields
 * @param boolean true or false value
 *
 */

 void SetTextFields(boolean txtValue)
 {
  txtRemarks.setEnabled(txtValue);
  txtEmail1.setEnabled(txtValue);
  txtEmail2.setEnabled(txtValue);
  txtPass.setEnabled(txtValue);
 }

 /**
 * Setting Button States
 * @param boolean true or false value
 *
 */

 void SetInitialButtons(boolean bVal)
 {
  btnNew.setVisible(bVal);
  btnEdit.setVisible(bVal);

  btnSave.setVisible(!bVal);
  btnCancel.setVisible(!bVal);

  btnDelete.setEnabled(bVal);

  btnPrev.setEnabled(bVal);
  btnNext.setEnabled(bVal);
 }

 /**
 * Connects Table
 *
 */

 public void getConnected()
 {
  //CONNECT TABLE
  try
  {
   emlcon.Connect(EmpCode);
  }catch(RemoteException re){ System.out.println("Client [frmEmail]: Open Error");System.out.println("Error: "+re.getMessage());}

  //DISPLAY DATA RMI
  try
  {
   eml=emlcon.moveNext();
   display();
  }catch(RemoteException re){ System.out.println("Client [frmEmail]: Show Error");System.out.println("Error: "+re.getMessage());}
 }

 /**
 * Display Data
 *
 */

 public void display()
 {
  clearFields();

  txtEID.setText(eml.getTransactionID());
  if(!txtEID.getText().equals("")) txtName.setText(userName);
  txtEmpCode.setText(eml.getEmpCode());
  txtDate.setText(eml.getDate());
  txtRemarks.setText(eml.getRemarks());
  txtEmail1.setText(eml.getEmail1());
  txtEmail2.setText(eml.getEmail2());
  txtPass.setText(eml.getPass());

  //lblRec.setText(" REC # " + rsP.getRow());
 }//Display

 /**
 * Clears TextFields
 *
 */

 public void clearFields()
 {
  txtEID.setText("");
  txtDate.setText("");
  txtName.setText("");
  txtEmpCode.setText("");
  lblRec.setText("");

  txtRemarks.setText("");
  txtEmail1.setText("");
  txtEmail2.setText("");
  txtPass.setText("");
 }//Clear Fields

 /**
 * Field Checking
 *
 * @return boolean true or false value
 */

 public void CheckFields()
 {
  if (txtEmail1.getText().equals(""))
  {
   JOptionPane.showMessageDialog(null, "Please Provide Email Choice 1 !!!",
   "Missing Information",
   JOptionPane.ERROR_MESSAGE);
   txtEmail1.requestFocus();
   fieldsOK = false;
  }

  else if (txtEmail2.getText().equals(""))
  {
   JOptionPane.showMessageDialog(null, "Please Provide Email Choice 2 !!!",
   "Missing Information",
   JOptionPane.ERROR_MESSAGE);
   txtEmail2.requestFocus();
   fieldsOK = false;
  }

  else if (txtPass.getText().equals(""))
  {
   JOptionPane.showMessageDialog(null,
   "Please Provide Password for your Email Address !!!",
   "Missing Information",
   JOptionPane.ERROR_MESSAGE);
   txtPass.requestFocus();
   fieldsOK = false;
  }
  else
  { fieldsOK = true; }
 }//Check Fields

 /**
 * Requests Server to Add New Record
 *
 */

 public boolean save()
 {//Save
  boolean savesucc=false;

  //INITIALISE USER OBJECT...
  eml.setTransactionID(txtEID.getText());
  eml.setEmpCode(EmpCode);
  eml.setDate(txtDate.getText());
  eml.setRemarks(txtRemarks.getText());
  eml.setEmail1(txtEmail1.getText());
  eml.setEmail2(txtEmail2.getText());
  eml.setPass(txtPass.getText());
  eml.setDeptApp("-");
  eml.setDeptComm("-");
  eml.setDeptAppBy("-");
  eml.setISApp("-");
  eml.setISComm("-");
  eml.setISAppBy("-");
  eml.setJobStatus("-");

  try
  {
   savesucc = emlcon.insertData(eml);
   StartWorking("ADDING NEW RECORD");
   JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
   lblRec.setText("");
   getConnected();

  }catch(RemoteException re)
  {
   System.out.println("Client [frmEmail]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmEmail]: "+re.getMessage(),
   "Error", JOptionPane.ERROR_MESSAGE);
   return savesucc;
  }

  return savesucc;
 }//Save

 /**
 * Requests Server to Update a Specific Record
 *
 */

 public boolean editData()
 {//Edit Data
  boolean updatesucc=false;

  //INITIALISE USER OBJECT...
  eml.setRemarks(txtRemarks.getText());
  eml.setEmail1(txtEmail1.getText());
  eml.setEmail2(txtEmail2.getText());
  eml.setPass(txtPass.getText());

  try
  {
   updatesucc = emlcon.updateEmpData(eml);
   StartWorking("UPDATING RECORD");
   JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
   lblRec.setText("");
   getConnected();

  }catch(RemoteException re)
  {
   System.out.println("Client [frmEmail]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmEmail]: "+re.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
   return updatesucc;
  }

  return updatesucc;
 }//Edit Data

 /**
 * Requests Server to Delete a Specific Record
 *
 */

 public void DeleteData()
 {//Delete Data
  String strQuery = "DELETE FROM Email WHERE TransactionID='" + txtEID.getText() + "';";

  yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
  JOptionPane.YES_NO_OPTION, 3, imgQ);

  if (yn == JOptionPane.YES_OPTION)
  {
   try
   {
    emlcon.DeleteData(strQuery);
    StartWorking("DELETING RECORD");
    JOptionPane.showMessageDialog(null, "Server: Record Deleted!", "Information", 1);
    clearFields();
    getConnected();

   }catch(RemoteException re)
   {
    System.out.println("Client [frmEmail]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmEmail]: "+re.getMessage(),
             "Error", JOptionPane.ERROR_MESSAGE);
   }
  }
  else {}
 }//Delete Data

 /**
 * Progress Bar
 *
 */

 private void StartWorking(String t)
 {
  frmWork w = new frmWork(t);
  w.setSize(368, 140);
  w.setVisible(true);
 }

}//Class