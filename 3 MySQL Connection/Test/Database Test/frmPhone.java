//package beximtex;
/**
* <p>Title: BeximTex, Phone Request</p>
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

public class frmPhone extends JInternalFrame
{//Class

 JPanel pnlTop = new JPanel();
 JPanel pnlMid = new JPanel();
 JPanel pnlButtons = new JPanel();

 TitledBorder titledBorder1;
 TitledBorder titledBorder2;
 TitledBorder titledBorder3;
 TitledBorder titledBorder4;
 TitledBorder titledBorder5;
 TitledBorder titledBorder6;

 JLabel lblEmpCode = new JLabel();
 JLabel lblEID = new JLabel();
 JLabel lblName = new JLabel();
 JLabel lblDate = new JLabel();
 JLabel lblNeed = new JLabel();
 JLabel lblRem = new JLabel();
 JLabel lblRec = new JLabel();

 JTextField txtEmpCode = new JTextField();
 JTextField txtPID = new JTextField();
 JTextField txtName = new JTextField();
 JTextField txtDate = new JTextField();

 JScrollPane SPtxtNeed = new JScrollPane();
 JScrollPane SPtxtRem = new JScrollPane();

 JToggleButton btnDelete = new JToggleButton();
 JToggleButton btnEdit = new JToggleButton();
 JToggleButton btnNext = new JToggleButton();
 JToggleButton btnPrev = new JToggleButton();
 JToggleButton btnNew = new JToggleButton();
 JToggleButton btnSave = new JToggleButton();
 JToggleButton btnCancel = new JToggleButton();

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

 JTextArea txtNeed = new JTextArea();
 JTextArea txtRem = new JTextArea();
 JLabel lblRT = new JLabel();

 ButtonGroup ReqTyp = new ButtonGroup();

 JRadioButton rdoPABX = new JRadioButton();
 JRadioButton rdoTEL = new JRadioButton();
 JRadioButton rdoMB = new JRadioButton();

 //**************************************************************
 //RMI Declare Server Object
 PhoneController phncon;
 Phone phn = new Phone();
 //**************************************************************

 String RequestType = null;
 String EmpCode = null;
 String userName = null;

 String CurrentDate = null;
 String TranID = null;
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 Date d;
 int yn;

 boolean isAdd = false;
 boolean fieldsOK = false;
 JToggleButton btnClose = new JToggleButton();

 public frmPhone(String ec, String un)
 {//Cons
  EmpCode = ec;
  userName = un;

  try {jbInit();}
  catch (Exception e) {System.exit(0);}
 }//Cons

 private void jbInit() throws Exception
 {//jbInit

  //**************************************************************
  //Connection: Connects with Server
  try
  {
   phncon = (PhoneController)Naming.lookup(new ReadHost().getHost() + "PhoneController");
  }catch(Exception ec)
  {
   System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
   System.out.println("Error: "+ec.getMessage());
   JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
   "Error", JOptionPane.ERROR_MESSAGE);
   System.exit(0);
  }
  System.out.println("\n******************************\n CLIENT READY [frmPhone] \n******************************\n");
  //**************************************************************

  titledBorder1 = new TitledBorder("");
  titledBorder2 = new TitledBorder("");
  titledBorder3 = new TitledBorder("");
  titledBorder4 = new TitledBorder("");
  titledBorder5 = new TitledBorder("");
  titledBorder6 = new TitledBorder("");
  txtRem.setText("");

  pnlTop.setBackground(Color.white);
  pnlTop.setForeground(Color.white);
  pnlTop.setBorder(titledBorder2);
  pnlTop.setBounds(new Rectangle(9, 12, 551, 71));
  pnlTop.setLayout(null);

  pnlMid.setBackground(Color.white);
  pnlMid.setForeground(Color.white);
  pnlMid.setBorder(titledBorder4);
  pnlMid.setDebugGraphicsOptions(0);
  pnlMid.setBounds(new Rectangle(9, 89, 551, 195));
  pnlMid.setLayout(null);

  pnlButtons.setBackground(Color.white);
  pnlButtons.setForeground(Color.white);
  pnlButtons.setBorder(titledBorder6);
  pnlButtons.setBounds(new Rectangle(9, 290, 551, 45));
  pnlButtons.setLayout(null);

  lblEmpCode.setBounds(new Rectangle(285, 37, 106, 24));
  lblEmpCode.setText("EMPLOYEE CODE");
  lblEmpCode.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblEmpCode.setHorizontalAlignment(SwingConstants.RIGHT);
  lblEID.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblEID.setBounds(new Rectangle(10, 10, 131, 24));
  lblEID.setText("TRANSACTION #");
  lblName.setText("NAME");
  lblName.setBounds(new Rectangle(10, 37, 131, 24));
  lblName.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblDate.setBounds(new Rectangle(285, 10, 106, 24));
  lblDate.setText("DATE");
  lblDate.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
  lblNeed.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblNeed.setText("NEED / JUSTIFICATION [JOBS TO BE DONE]");
  lblNeed.setBounds(new Rectangle(11, 40, 413, 24));
  lblRem.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblRem.setRequestFocusEnabled(true);
  lblRem.setText("REMARKS");
  lblRem.setBounds(new Rectangle(11, 111, 519, 24));
  lblRec.setBounds(new Rectangle(230, 11, 88, 24));
  lblRec.setText("");
  lblRec.setHorizontalAlignment(SwingConstants.LEFT);
  lblRec.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblRec.setBorder(null);
  lblRT.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblRT.setBounds(new Rectangle(11, 8, 265, 24));
  lblRT.setText("REQUEST FOR");

  txtEmpCode.setBounds(new Rectangle(399, 38, 140, 23));
  txtEmpCode.setText("");
  txtEmpCode.setEnabled(false);
  txtEmpCode.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtPID.setEnabled(false);
  txtPID.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtPID.setBounds(new Rectangle(120, 11, 170, 23));
  txtPID.setText("");
  txtName.setText("");
  txtName.setBounds(new Rectangle(120, 38, 170, 23));
  txtName.setEnabled(false);
  txtName.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtDate.setBounds(new Rectangle(399, 11, 140, 23));
  txtDate.setEnabled(false);
  txtDate.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtDate.setText("");

  txtNeed.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtNeed.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1)
   {
    if (ke1.getKeyCode() == KeyEvent.VK_TAB)
    { txtRem.requestFocus(); }
   }
   public void KeyReleased(KeyEvent ke2) {}
   public void KeyTyped(KeyEvent ke3) {}
  });
  txtNeed.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   { txtNeed.selectAll(); }
   public void focusLost(FocusEvent f) {}
  });

  txtRem.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtRem.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1)
   {
    if (ke1.getKeyCode() == KeyEvent.VK_TAB)
    { btnSave.requestFocus(); }
   }
   public void KeyReleased(KeyEvent ke2) {}
   public void KeyTyped(KeyEvent ke3) {}
  });
  txtRem.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   { txtRem.selectAll(); }
   public void focusLost(FocusEvent f)
   {
    if (txtRem.getText().equals(""))
    { txtRem.setText("-"); }
   }
  });

  txtNeed.setText("");

  SPtxtRem.setBounds(new Rectangle(11, 133, 527, 49));
  SPtxtNeed.setBounds(new Rectangle(11, 61, 527, 49));

  btnNew.setBounds(new Rectangle(7, 9, 91, 28));
  btnNew.setText("NEW");
  btnNew.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnNew.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    d = new Date();
    CurrentDate = null;
    TranID = new String("P");
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
    txtPID.setText(TranID);
    txtEmpCode.setText(EmpCode);
    txtName.setText(userName);
    d = new Date();
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    CurrentDate = sdf.format(d);
    txtDate.setText(CurrentDate);

    isAdd = true;
    SetInitialButtons(false);
    SetTextFields(true);
    lblRT.setText("REQUEST FOR ");
    rdoMB.setSelected(true);
    lblRec.setText(" Add New Rec. ");
   }
  });

  btnSave.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnSave.setText("SAVE");
  btnSave.setBounds(new Rectangle(7, 9, 91, 28));
  btnSave.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    CheckRDOs();
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
      }
     }

     //SET FLAG...
     isAdd=false;
     lblRec.setText("");
    }
    else
    { return; }
   }
  });

  btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnCancel.setText("CANCEL");
  btnCancel.setBounds(new Rectangle(103, 9, 91, 28));
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

  btnDelete.setBounds(new Rectangle(356, 8, 91, 28));
  btnDelete.setText("Delete");
  btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnDelete.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    if (txtPID.getText().equals(""))
    { return; }
    DeleteData();
   }
  });

  btnEdit.setText("EDIT");
  btnEdit.setBounds(new Rectangle(103, 9, 91, 28));
  btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnEdit.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    SetInitialButtons(false);
    SetTextFields(true);
    lblRT.setText("REQUEST FOR ");
    rdoMB.setSelected(true);
    lblRec.setText(" Edit Record. ");
   }
  });

  btnNext.setText("");
  btnNext.setBounds(new Rectangle(321, 11, 22, 23));
  btnNext.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnNext.setIcon(imgNext);
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
     phn=phncon.moveNext();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmPhone]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
   }
  });

  btnPrev.setBounds(new Rectangle(206, 11, 22, 23));
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
     phn=phncon.movePrevious();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmPhone]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
   }
  });

  rdoTEL.setBackground(Color.white);
  rdoPABX.setBackground(Color.white);
  rdoMB.setBackground(Color.white);
  btnClose.setText("CLOSE");
  btnClose.setBounds(new Rectangle(451, 8, 91, 28));
  btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnClose.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent x2)
   { dispose(); }
  });
  ReqTyp.add(rdoMB);
  ReqTyp.add(rdoPABX);
  ReqTyp.add(rdoTEL);

  rdoPABX.setText("NEW PABX EXT");
  rdoPABX.setBounds(new Rectangle(117, 8, 113, 24));
  rdoPABX.setFont(new java.awt.Font("Tahoma", 1, 11));
  rdoTEL.setFont(new java.awt.Font("Tahoma", 1, 11));
  rdoTEL.setBounds(new Rectangle(248, 8, 113, 24));
  rdoTEL.setText("TELEPHONE SET");
  rdoMB.setText("MOBILE");
  rdoMB.setBounds(new Rectangle(383, 8, 113, 24));
  rdoMB.setFont(new java.awt.Font("Tahoma", 1, 11));

  pnlTop.add(txtDate, null);
  pnlTop.add(lblEID, null);
  pnlTop.add(txtPID, null);
  pnlTop.add(txtName, null);
  pnlTop.add(lblName, null);
  pnlTop.add(lblEmpCode, null);
  pnlTop.add(lblDate, null);
  pnlTop.add(txtEmpCode, null);

  pnlMid.add(lblRT, null);
  pnlMid.add(rdoPABX, null);
  pnlMid.add(rdoTEL, null);
  pnlMid.add(rdoMB, null);
  pnlMid.add(lblNeed, null);
  pnlMid.add(SPtxtNeed, null);
  pnlMid.add(lblRem, null);
  pnlMid.add(SPtxtRem, null);
  this.getContentPane().add(pnlButtons, null);
  SPtxtRem.getViewport().add(txtRem, null);
  SPtxtNeed.getViewport().add(txtNeed, null);

  pnlButtons.add(btnNew, null);
  pnlButtons.add(btnEdit, null);
  pnlButtons.add(btnPrev, null);
  pnlButtons.add(lblRec, null);
  pnlButtons.add(btnNext, null);
  pnlButtons.add(btnDelete, null);
  pnlButtons.add(btnSave, null);
  pnlButtons.add(btnCancel, null);
  pnlButtons.add(btnClose, null);
  this.getContentPane().add(pnlMid, null);
  this.getContentPane().add(pnlTop, null);

  this.setClosable(true);
  this.setIconifiable(true);
  this.setMaximizable(false);
  this.setTitle("PHONE REQUEST FORM");
  this.getContentPane().setLayout(null);
  this.setFrameIcon(imgIco);
  this.getContentPane().setBackground(Color.white);
  this.setSize(new Dimension(579, 377));

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
  txtNeed.setEnabled(txtValue);
  txtRem.setEnabled(txtValue);
  rdoMB.setVisible(txtValue);
  rdoPABX.setVisible(txtValue);
  rdoTEL.setVisible(txtValue);
 }

 /**
 * Checking RDO's States
 *
 */

 public void CheckRDOs()
 {
  if (rdoMB.isSelected())
  { RequestType = "Mobile"; }
  if (rdoPABX.isSelected())
  { RequestType = "New PABX Ext"; }
  if (rdoTEL.isSelected())
  { RequestType = "Telephone Set"; }
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
 * Field Checking
 *
 * @return boolean true or false value
 */

 public void CheckFields()
 {
  if (txtNeed.getText().equals("") || txtNeed.getText().equals(" "))
  {
   JOptionPane.showMessageDialog(null,
   "Please Provide Why is the Hardware Required!!!",
   "Missing Information",
   JOptionPane.ERROR_MESSAGE);
   txtNeed.requestFocus();
   if(txtRem.getText().equals("")){txtRem.setText("-");}
   fieldsOK = false;
  }

  else { fieldsOK = true; }
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
   phncon.Connect(EmpCode);
  }catch(RemoteException re){ System.out.println("Client [frmPhone]: Open Error");System.out.println("Error: "+re.getMessage());}

  //DISPLAY DATA RMI
  try
  {
   phn=phncon.moveNext();
   display();
  }catch(RemoteException re){ System.out.println("Client [frmPhone]: Show Error");System.out.println("Error: "+re.getMessage());}
 }

 /**
 * Display Data
 *
 */

 public void display()
 {
  clearFields();
  RequestType = new String("");

  txtPID.setText(phn.getTransactionID());
  if(!txtPID.getText().equals("")) txtName.setText(userName);
  txtEmpCode.setText(phn.getEmpCode());
  txtDate.setText(phn.getDate());
  lblRT.setText("REQUEST TYPE: " + phn.getRequestType());
  txtNeed.setText(phn.getNeed());
  txtRem.setText(phn.getRemarks());

  //lblRec.setText(" REC # " + rsP.getRow());
 }

 /**
 * Clears TextFields
 *
 */

 void clearFields()
 {
  txtName.setText("");
  txtNeed.setText("");
  txtRem.setText("");
 }

 /**
 * Requests Server to Add New Record
 *
 */

 public boolean save()
 {//Save
  boolean savesucc=false;

  //INITIALISE USER OBJECT...
  phn.setTransactionID(txtPID.getText());
  phn.setEmpCode(EmpCode);
  phn.setDate(txtDate.getText());
  phn.setRequestType(RequestType);
  phn.setNeed(txtNeed.getText());
  phn.setDeptApp("-");
  phn.setDeptComm("-");
  phn.setDeptAppBy("-");
  phn.setISApp("-");
  phn.setISComm("-");
  phn.setISAppBy("-");
  phn.setRemarks(txtRem.getText());
  phn.setJobStatus("-");

  try
  {
   savesucc = phncon.insertData(phn);
   StartWorking("ADDING NEW RECORD");
   JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
   lblRec.setText("");
   getConnected();

  }catch(RemoteException re)
  {
   System.out.println("Client [frmPhone]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmPhone]: "+re.getMessage(),
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
  phn.setRequestType(RequestType);
  phn.setNeed(txtNeed.getText());
  phn.setRemarks(txtRem.getText());

  try
  {
   updatesucc = phncon.updateEmpData(phn);
   StartWorking("UPDATING RECORD");
   JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
   lblRec.setText("");
   getConnected();

  }catch(RemoteException re)
  {
   System.out.println("Client [frmPhone]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmPhone]: "+re.getMessage(),
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
  String strQuery = "DELETE FROM Phone WHERE TransactionID='" + txtPID.getText() +"';";

  yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
  JOptionPane.YES_NO_OPTION, 3, imgQ);

  if (yn == JOptionPane.YES_OPTION)
  {
   try
   {
    phncon.DeleteData(strQuery);
    StartWorking("DELETING RECORD");
    JOptionPane.showMessageDialog(null, "Server: Record Deleted!", "Information", 1);
    clearFields();
    getConnected();

   }catch(RemoteException re)
   {
    System.out.println("Client [frmPhone]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmPhone]: "+re.getMessage(),
             "Error", JOptionPane.ERROR_MESSAGE);
   }
  }
  else {}
 }//Delete Data

 //void btnPrint_actionPerformed(ActionEvent e) {}
 //void btnClose_actionPerformed(ActionEvent e) {}

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
