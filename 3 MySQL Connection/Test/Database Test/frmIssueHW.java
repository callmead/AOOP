//package beximtex;
/**
 * <p>Title: BeximTex, Hardware Issue</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.util.Date;

import java.rmi.*;

public class frmIssueHW extends JInternalFrame
{//Class

 JPanel pnlFields = new JPanel();
 TitledBorder titledBorder1;
 TitledBorder titledBorder2;
 JTextField txtISTO = new JTextField();
 JScrollPane SPtxtR = new JScrollPane();
 JTextField txtDate = new JTextField();
 JLabel lblDept1 = new JLabel();
 JLabel lblDate = new JLabel();
 JTextField txtTID = new JTextField();
 JLabel lblEID = new JLabel();
 JComboBox cboHW = new JComboBox();
 JLabel lblHW = new JLabel();
 JToggleButton btnEmp = new JToggleButton();
 JToggleButton btnHW = new JToggleButton();//Class

 JLabel lblISTO = new JLabel();
 JTextField txtItemCode = new JTextField();
 JPanel pnlButtons = new JPanel();
 TitledBorder titledBorder3;
 JButton btnDelete = new JButton();
 JButton btnClose = new JButton();
 JLabel lblRec = new JLabel();
 JButton btnSave = new JButton();
 JButton btnCancel = new JButton();
 JButton btnEdit = new JButton();
 JButton btnNew = new JButton();
 JToggleButton btnLast = new JToggleButton();
 JButton btnRefresh = new JButton();
 JToggleButton btnPrevious = new JToggleButton();
 JToggleButton btnNext = new JToggleButton();
 JToggleButton btnFirst = new JToggleButton();
 TitledBorder titledBorder4;
 JLabel lblIRem = new JLabel();
 JPanel pnlSearch = new JPanel();
 TitledBorder titledBorder5;
 TitledBorder titledBorder6;
 JScrollPane sp = new JScrollPane();
 JTable Table = new JTable();
 JButton btnGo = new JButton();
 JLabel lblPicture = new JLabel();
 JComboBox cboSearch = new JComboBox();
 JTextField txtSearch = new JTextField();

 //**************************************************************
 //RMI Declare Server Object
 HWissueController hwiscon;
 HWissue hwis = new HWissue();

 CommonTableController ctccon;
 //**************************************************************

 ImageIcon imgIco = new ImageIcon("./Images/popup.gif");
 ImageIcon imgTab = new ImageIcon("./Images/Table.gif");
 ImageIcon imgFirst = new ImageIcon("./Images/iconFirst.gif");
 ImageIcon imgFO = new ImageIcon("./Images/iconFirstOver.gif");
 ImageIcon imgLast = new ImageIcon("./Images/iconLast.gif");
 ImageIcon imgLO = new ImageIcon("./Images/iconLastOver.gif");
 ImageIcon imgNext = new ImageIcon("./Images/iconNext.gif");
 ImageIcon imgNO = new ImageIcon("./Images/iconNextOver.gif");
 ImageIcon imgPrev = new ImageIcon("./Images/iconPrevious.gif");
 ImageIcon imgPO = new ImageIcon("./Images/iconPreviousOver.gif");
 ImageIcon imgSrc = new ImageIcon("./Images/find.png");
 ImageIcon imgRef = new ImageIcon("./Images/db.gif");
 ImageIcon imgSearch = new ImageIcon("./Images/powerSearch.gif");
 ImageIcon imgExc = new ImageIcon("./Images/exc.gif");
 ImageIcon imgQ = new ImageIcon("./Images/question32.png");

 JTextArea txtRemarks = new JTextArea();

 int yn;
 boolean isAdd = false;

 String SQL = null;
 String SQL1 = null;
 String SelRow[][];
 String EmpCode = null;
 String CurrentDate = null;
 String TranID = null;
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 Date d;

 Vector ColHead = new Vector();
 Vector rows = new Vector();

 int TotalCol = 0;
 int Rows = 0;
 int Columns = 0;
 JLabel lblIC = new JLabel();
 JToggleButton btnDT1 = new JToggleButton();

 public frmIssueHW(String ec)
 {//Cons
  EmpCode = ec;
  try {jbInit();}
  catch(Exception e){System.exit(0);}
 }//Cons

 private void jbInit() throws Exception
 {//jbInit

  //**************************************************************
     //getConnectedion: getConnecteds with Server
  try
  {
   hwiscon = (HWissueController)Naming.lookup(new ReadHost().getHost() + "HWissueController");
   ctccon = (CommonTableController)Naming.lookup(new ReadHost().getHost() + "CommonTableController");

  }catch(Exception ec)
  {
   System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
   System.out.println("Error: "+ec.getMessage());
   JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
   "Error", JOptionPane.ERROR_MESSAGE);
   System.exit(0);
  }
  System.out.println("\n******************************\n CLIENT READY [frmIssueHW] \n******************************\n");
  //**************************************************************

  titledBorder3 = new TitledBorder("");
  titledBorder4 = new TitledBorder("");
  titledBorder5 = new TitledBorder("");
  titledBorder6 = new TitledBorder("");
  pnlButtons.setBackground(Color.white);
  pnlButtons.setBorder(titledBorder4);
  pnlButtons.setBounds(new Rectangle(6, 156, 553, 67));
  pnlButtons.setLayout(null);
  btnDelete.setBorder(BorderFactory.createRaisedBevelBorder());
  btnDelete.setMnemonic('D');
  btnDelete.setText("DELETE");
  btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnDelete.setIcon(new ImageIcon("images/Delete16.gif"));
  btnDelete.setBounds(new Rectangle(354, 32, 91, 28));
  btnDelete.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    if (txtTID.getText().equals(""))
    { return; }
    DeleteData();
   }
  });
  btnClose.setBorder(BorderFactory.createRaisedBevelBorder());
  btnClose.setMnemonic('L');
  btnClose.setText("CLOSE");
  btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnClose.setIcon(new ImageIcon("images/close.gif"));
  btnClose.setBounds(new Rectangle(448, 32, 91, 28));
  btnClose.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { dispose(); }
  });
  lblRec.setBackground(Color.white);
  lblRec.setBounds(new Rectangle(201, 6, 150, 21));
  lblRec.setOpaque(true);
  lblRec.setText("");
  lblRec.setFont(new Font("Tahoma", 1, 12));

  btnSave.setBorder(BorderFactory.createRaisedBevelBorder());
  btnSave.setMnemonic('S');
  btnSave.setText("SAVE");
  btnSave.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnSave.setIcon(new ImageIcon("images/Save16.gif"));
  btnSave.setBounds(new Rectangle(12, 32, 91, 28));
  btnSave.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    if(checkFields()==true)
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
       setButton(true);
       setFields(false);
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
       setButton(true);
       setFields(false);
      }
     }
     //SET FLAG...
     isAdd=false;
     lblRec.setText("");
    }
   }
  });

  btnCancel.setBorder(BorderFactory.createRaisedBevelBorder());
  btnCancel.setBounds(new Rectangle(106, 32, 91, 28));
  btnCancel.setText("CANCEL");
  btnCancel.setIcon(new ImageIcon("images/Cancel.gif"));
  btnCancel.setMnemonic('C');
  btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnCancel.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    if(!isAdd)
    {
     try
     {
      ctccon.ExecuteQuery("UPDATE HW_Stock SET Issued='Yes' WHERE ItemCode='"+txtItemCode.getText()+"';");
     }catch(RemoteException re)
     {
      System.out.println("Client [frmIssueHW]: CANCEL BUTTON ACTION Error");System.out.println("Error: "+re.getMessage());
      JOptionPane.showMessageDialog(null, "CANCEL BUTTON ACTION Error\nClient [frmIssueHW]: "+re.getMessage(),
               "Error", JOptionPane.ERROR_MESSAGE);
     }
    }
    setButton(true);
    setFields(false);
    getConnected();
    isAdd = false;
    lblRec.setText("");
   }
  });

  btnEdit.setBorder(BorderFactory.createRaisedBevelBorder());
  btnEdit.setBounds(new Rectangle(106, 32, 91, 28));
  btnEdit.setText("EDIT");
  btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnEdit.setIcon(new ImageIcon("images/EditMnu.gif"));
  btnEdit.setMnemonic('E');
  btnEdit.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    try
    {
     ctccon.ExecuteQuery("UPDATE HW_Stock SET Issued='No' WHERE ItemCode='"+txtItemCode.getText()+"';");
    }catch(RemoteException re)
    {
     System.out.println("Client [frmIssueHW]: EDIT BUTTON ACTION Error");System.out.println("Error: "+re.getMessage());
     JOptionPane.showMessageDialog(null, "EDIT BUTTON ACTION Error\nClient [frmIssueHW]: "+re.getMessage(),
              "Error", JOptionPane.ERROR_MESSAGE);
    }

    setButton(false);
    btnDT1.setEnabled(false);
    setFields(true);
    lblRec.setText(" Edit Record... ");
   }
  });

  btnNew.setBorder(BorderFactory.createRaisedBevelBorder());
  btnNew.setBounds(new Rectangle(12, 32, 91, 28));
  btnNew.setText("NEW");
  btnNew.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnNew.setIcon(new ImageIcon("images/FileMnu.gif"));
  btnNew.setMnemonic('N');
  btnNew.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    isAdd = true;
    setButton(false);
    setFields(true);
    clearFields();
    d = new Date();
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    CurrentDate = sdf.format(d);
    txtDate.setText(CurrentDate);
    d = new Date();
    CurrentDate = null;
    TranID = new String("I");
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
    txtTID.setText(TranID);
    lblRec.setText(" Add New Record... ");
   }
  });

  btnRefresh.setToolTipText("Refresh Database");
  btnRefresh.setBorder(BorderFactory.createRaisedBevelBorder());
  btnRefresh.setMnemonic('B');
  btnRefresh.setIcon(imgRef);
  btnRefresh.setText("REFRESH DB");
  btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnRefresh.setBounds(new Rectangle(201, 32, 149, 28));
  btnRefresh.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {getConnected();}
  });

  btnFirst.setToolTipText("First");
  btnFirst.setText("");
  btnFirst.setIcon(imgFirst);
  btnFirst.setBounds(new Rectangle(152, 5, 22, 23));
  btnFirst.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    try
    {
     hwis=hwiscon.moveFirst();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmIssueHW]: MOVE FIRST Error");System.out.println("Error: "+re.getMessage());}
   }
  });
  btnFirst.addMouseListener(new MouseAdapter()
  {
   public void mouseEntered(MouseEvent e)
   { btnFirst.setIcon(imgFO); }
   public void mouseExited(MouseEvent f)
   { btnFirst.setIcon(imgFirst); }
  });

  btnPrevious.setToolTipText("Previous");
  btnPrevious.setText("");
  btnPrevious.setIcon(imgPrev);
  btnPrevious.setBounds(new Rectangle(176, 5, 22, 23));
  btnPrevious.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    try
    {
     hwis=hwiscon.movePrevious();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmIssueHW]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
   }
  });
  btnPrevious.addMouseListener(new MouseAdapter()
  {
   public void mouseEntered(MouseEvent e)
   { btnPrevious.setIcon(imgPO); }
   public void mouseExited(MouseEvent f)
   { btnPrevious.setIcon(imgPrev); }
  });

  btnNext.setToolTipText("Next");
  btnNext.setText("");
  btnNext.setIcon(imgNext);
  btnNext.setBounds(new Rectangle(355, 5, 22, 23));
  btnNext.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    try
    {
     hwis=hwiscon.moveNext();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmIssueHW]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
   }
  });
  btnNext.addMouseListener(new MouseAdapter()
  {
   public void mouseEntered(MouseEvent e)
   { btnNext.setIcon(imgNO); }
   public void mouseExited(MouseEvent f)
   { btnNext.setIcon(imgNext); }
  });

  btnLast.setToolTipText("Last");
  btnLast.setText("");
  btnLast.setIcon(imgLast);
  btnLast.setBounds(new Rectangle(378, 5, 22, 23));
  btnLast.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    try
    {
     hwis=hwiscon.moveLast();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmIssueHW]: MOVE LAST Error");System.out.println("Error: "+re.getMessage());}
   }
  });
  btnLast.addMouseListener(new MouseAdapter()
  {
   public void mouseEntered(MouseEvent e)
   { btnLast.setIcon(imgLO); }
   public void mouseExited(MouseEvent f)
   { btnLast.setIcon(imgLast); }
  });

  btnGo.setBounds(new Rectangle(451, 175, 91, 28));
  btnGo.setText("  FIND     ");
  btnGo.setIcon(imgSrc);
  btnGo.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnGo.setBorder(BorderFactory.createRaisedBevelBorder());
  btnGo.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    if (txtSearch.getText().equals(""))
    {
     JOptionPane.showMessageDialog(null, "Search What ?", "Information Required...", JOptionPane.INFORMATION_MESSAGE, imgExc);
     txtSearch.requestFocus();
    }
    else
    {
     String SQLString = "SELECT * FROM HW_Issue WHERE " + cboSearch.getSelectedItem().toString() +"='" + txtSearch.getText() + "';";

     try
     {
      if (hwiscon.isFound(SQLString))
      {
       hwis = hwiscon.SearchData(SQLString);
       StartWorking("LOADING");
       getTableData(SQLString);
       display();
      }
      else
      {
       System.out.println("Record Not Found!");
       JOptionPane.showMessageDialog(null, "Record Not Found!", "Information", JOptionPane.INFORMATION_MESSAGE, imgExc);
       getConnected();
      }

     }catch(RemoteException re)
     {System.out.println("Client [frmIssueHW]: SEARCH DATA Error");System.out.println("Error: "+re.getMessage());}
    }
   }
  });

  lblIRem.setText("REMARKS");
  lblIRem.setBounds(new Rectangle(10, 90, 75, 24));
  lblIRem.setFont(new java.awt.Font("Tahoma", 1, 11));
  pnlSearch.setBackground(Color.white);
  pnlSearch.setAlignmentY((float) 0.5);
  pnlSearch.setBorder(titledBorder6);
  pnlSearch.setBounds(new Rectangle(6, 227, 553, 212));
  pnlSearch.setLayout(null);
  sp.getViewport().setBackground(Color.white);
  sp.setToolTipText("Issued Items");
  sp.setBounds(new Rectangle(6, 7, 540, 119));

  lblPicture.setText("");
  lblPicture.setIcon(imgSearch);
  lblPicture.setBounds(new Rectangle(9, 130, 273, 42));

  cboSearch.setBounds(new Rectangle(346, 178, 101, 24));
  cboSearch.setMaximumRowCount(4);
  cboSearch.setBackground(Color.white);
  cboSearch.addItem("Item");
  cboSearch.addItem("ItemCode");
  cboSearch.addItem("Date");
  cboSearch.addItem("IssuedTo");

  txtSearch.setFont(new Font("Tahoma", 1, 12));
  txtSearch.setCaretColor(Color.blue);
  txtSearch.setText("");
  txtSearch.setBounds(new Rectangle(11, 178, 330, 24));
  SPtxtR.getViewport().setBackground(Color.white);
  lblIC.setHorizontalAlignment(SwingConstants.RIGHT);
  lblIC.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblIC.setText("ITEM CODE");
  lblIC.setBounds(new Rectangle(292, 34, 106, 24));
  btnDT1.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnDT1_actionPerformed(e); }
  });
  btnDT1.setBounds(new Rectangle(331, 9, 22, 23));
  btnDT1.setIcon(imgTab);
  btnDT1.setText("");
  btnDT1.setToolTipText("DATE SELECTOR");
  btnDT1.setBounds(new Rectangle(518, 11, 22, 23));
  btnDT1.setBounds(new Rectangle(508, 8, 22, 23));
  pnlFields.add(lblISTO, null);
  pnlFields.add(SPtxtR, null);
  pnlFields.add(txtDate, null);
  pnlFields.add(txtItemCode, null);
  pnlFields.add(lblEID, null);
  pnlFields.add(lblHW, null);
  pnlFields.add(lblISTO, null);
  pnlFields.add(txtISTO, null);
  pnlFields.add(cboHW, null);
  pnlFields.add(txtTID, null);
  pnlFields.add(btnHW, null);
  pnlFields.add(btnEmp, null);
  pnlFields.add(lblIRem, null);
  pnlFields.add(lblDate, null);
  pnlFields.add(lblIC, null);
  pnlFields.add(btnDT1, null);
  SPtxtR.getViewport().add(txtRemarks, null);
  this.getContentPane().add(pnlSearch, null);
  this.getContentPane().add(pnlButtons, null);
  titledBorder1 = new TitledBorder("");
  titledBorder2 = new TitledBorder("");
  this.getContentPane().setBackground(Color.white);
  this.getContentPane().setLayout(null);
  pnlFields.setBackground(Color.white);
  pnlFields.setBorder(titledBorder2);
  pnlFields.setBounds(new Rectangle(6, 6, 553, 146));
  pnlFields.setLayout(null);
  this.setClosable(true);
  this.setIconifiable(true);
  this.setTitle("HARDWARE ISSUE");
  this.setSize(new Dimension(581, 477));
  this.setFrameIcon(imgIco);
  txtISTO.setText("");
  txtISTO.setBounds(new Rectangle(107, 62, 140, 23));
  txtISTO.setEnabled(false);
  txtISTO.setFont(new java.awt.Font("Tahoma", 1, 11));
  SPtxtR.setBounds(new Rectangle(107, 90, 423, 49));
  txtDate.setBounds(new Rectangle(409, 8, 98, 23));
  txtDate.setEnabled(false);
  txtDate.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtDate.setText("");
  lblDept1.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblDept1.setText("REMARKS");
  lblDept1.setBounds(new Rectangle(11, 99, 106, 24));
  lblDate.setBounds(new Rectangle(347, 6, 51, 24));
  lblDate.setText("DATE");
  lblDate.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
  txtTID.setEnabled(false);
  txtTID.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtTID.setBounds(new Rectangle(107, 8, 140, 23));
  txtTID.setText("");
  lblEID.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblEID.setBounds(new Rectangle(10, 6, 131, 24));
  lblEID.setText("TRANSACTION #");
  txtRemarks.setFont(new Font("Tahoma", 1, 12));
  txtRemarks.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1)
   {
    if (ke1.getKeyCode() == KeyEvent.VK_TAB)
    { btnSave.requestFocus(); }
   }
   public void KeyReleased(KeyEvent ke2) {}
   public void KeyTyped(KeyEvent ke3) {}
  });

  cboHW.setMaximumRowCount(5);
  cboHW.setBounds(new Rectangle(107, 35, 140, 23));
  cboHW.setBackground(Color.white);
  cboHW.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1)
   {
    if (ke1.getKeyCode() == KeyEvent.VK_ENTER)
    {
     ke1.setKeyCode(KeyEvent.VK_TAB);
    }
   }
   public void KeyReleased(KeyEvent ke1) {}
   public void KeyTyped(KeyEvent ke1) {}
  });
  lblHW.setText("HARDWARE");
  lblHW.setBounds(new Rectangle(10, 34, 75, 24));
  lblHW.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnEmp.setToolTipText("Show Employee List");
  btnEmp.setText("");
  btnEmp.setIcon(imgTab);
  btnEmp.setBounds(new Rectangle(249, 62, 22, 23));
  btnEmp.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnEmp_actionPerformed(e); }
  });
  btnHW.setToolTipText("Show Available Hardware");
  btnHW.setText("");
  btnHW.setIcon(imgTab);
  btnHW.setBounds(new Rectangle(249, 35, 22, 23));
  btnHW.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnHW_actionPerformed(e); }
  });
  lblISTO.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblISTO.setBounds(new Rectangle(10, 62, 75, 24));
  lblISTO.setText("ISSUE TO");
  txtItemCode.setText("");
  txtItemCode.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtItemCode.setToolTipText("Item Code");
  txtItemCode.setEnabled(false);
  txtItemCode.setBounds(new Rectangle(409, 35, 121, 23));
  this.getContentPane().add(pnlFields, null);
  this.getContentPane().add(pnlButtons, null);
  this.getContentPane().add(pnlSearch, null);

  pnlButtons.add(btnCancel, null);
  pnlButtons.add(btnSave, null);
  pnlButtons.add(btnClose, null);
  pnlButtons.add(btnDelete, null);
  pnlButtons.add(btnRefresh, null);
  pnlButtons.add(btnEdit, null);
  pnlButtons.add(btnNew, null);
  pnlButtons.add(btnFirst, null);
  pnlButtons.add(btnPrevious, null);
  pnlButtons.add(lblRec, null);
  pnlButtons.add(btnNext, null);
  pnlButtons.add(btnLast, null);

  cboHW.addItem("AGP");
  cboHW.addItem("CD ROM");
  cboHW.addItem("CDRW");
  cboHW.addItem("CPU");
  cboHW.addItem("DVD ROM");
  cboHW.addItem("FDD");
  cboHW.addItem("HDD");
  cboHW.addItem("KEYBOARD");
  cboHW.addItem("MONITOR");
  cboHW.addItem("MOTHERBOARD");
  cboHW.addItem("MOUSE");
  cboHW.addItem("NIC CARD");
  cboHW.addItem("PRINTER");
  cboHW.addItem("PROCESSOR");
  cboHW.addItem("RAM");
  cboHW.addItem("SCANNER");
  cboHW.addItem("SPECIAL CARD");
  cboHW.addItem("SOUND CARD");
  cboHW.addItem("UPS");
  cboHW.addItem("OTHER");

  pnlSearch.add(sp, null);
  pnlSearch.add(txtSearch, null);
  pnlSearch.add(cboSearch, null);
  pnlSearch.add(btnGo, null);
  pnlSearch.add(lblPicture, null);
  sp.add(Table, null);

  setButton(true);
  setFields(false);
  getConnected();

 }//jbInit

 /**
 * getConnecteds Table
 *
 */

 public void getConnected()
 {
  //CONNECT TABLE
  try
  {
   hwiscon.Connect();
  }catch(RemoteException re){ System.out.println("Client [frmIssueHW]: Open Error");System.out.println("Error: "+re.getMessage());}

  //DISPLAY DATA RMI
  try
  {
   hwis = hwiscon.moveNext();
   display();
  }catch(RemoteException re){ System.out.println("Client [frmIssueHW]: Show Error");System.out.println("Error: "+re.getMessage());}

  SQL="SELECT TransactionID, Date, ItemCode, Item, IssuedTo, Remarks FROM HW_Issue ORDER BY Date;";
  getTableData(SQL);
 }

 /**
 * Sets Button States
 * @param boolean true or false
 *
 */

 public void setButton(boolean btnValue)
 {
  btnNew.setVisible(btnValue);
  btnEdit.setVisible(btnValue);
  btnSave.setVisible(!btnValue);
  btnCancel.setVisible(!btnValue);
  btnDelete.setEnabled(btnValue);
  btnClose.setEnabled(btnValue);
  btnFirst.setEnabled(btnValue);
  btnPrevious.setEnabled(btnValue);
  btnNext.setEnabled(btnValue);
  btnLast.setEnabled(btnValue);
  btnEmp.setEnabled(!btnValue);
  btnHW.setEnabled(!btnValue);
  btnRefresh.setEnabled(btnValue);
  btnDT1.setEnabled(!btnValue);
 }

 /**
 * Sets Fields States
 * @param boolean true or false
 *
 */

 public void setFields(boolean txtValue)
 {
  cboHW.setEnabled(txtValue);
  txtRemarks.setEnabled(txtValue);
 }

 /**
 * Clear Text From Fields
 *
 */

 public void clearFields()
 {
  txtTID.setText("");
  txtDate.setText("");
  txtItemCode.setText("");
  txtISTO.setText("");
  txtRemarks.setText("");
 }

 /**
 * Display Data
 *
 */

 public void display()
 {
  txtTID.setText(hwis.getTransactionID());
  txtDate.setText(hwis.getDate());
  txtItemCode.setText(hwis.getItemCode());
  cboHW.setSelectedItem(hwis.getItem());
  txtISTO.setText(hwis.getIssuedTo());
  //txtEmpCode.setText(hwis.getEmpCode());
  txtRemarks.setText(hwis.getRemarks());
 }

 /**
 * Checks the Fields
 *
 * @return boolean true or false value
 */

 public boolean checkFields()
 {
  if (txtItemCode.getText().equals("")) {JOptionPane.showMessageDialog(null, "Please Select an Item from the list!","Missing Information",JOptionPane.ERROR_MESSAGE);return false;}
  if (txtISTO.getText().equals("")) {JOptionPane.showMessageDialog(null, "Please Select the employee to which the hardware is being issued!","Missing Information",JOptionPane.ERROR_MESSAGE);return false;}
  if (txtRemarks.getText().equals("")){txtRemarks.setText("-");}
  return true;
 }

 /**
 * Requests Server to Add New Record
 *
 * @return boolean true or false value
 */

 public boolean save()
 {//Save
  boolean savesucc=false;

  //INITIALISE USER OBJECT...
  hwis.setTransactionID(txtTID.getText());
  hwis.setDate(txtDate.getText());
  hwis.setItemCode(txtItemCode.getText());
  hwis.setItem(cboHW.getSelectedItem()+"");
  hwis.setIssuedTo(txtISTO.getText());
  hwis.setEmpCode(EmpCode);
  hwis.setRemarks(txtRemarks.getText());

  try
  {
   savesucc = hwiscon.insertData(hwis);
   StartWorking("ADDING NEW RECORD");

   ctccon.ExecuteQuery("INSERT INTO HW_History (ItemCode,Date,EmpCode)VALUES('"+txtItemCode.getText()+"','"+txtDate.getText()+"','"+txtISTO.getText()+"');");

   JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
   getConnected();

  }catch(RemoteException re)
  {
   System.out.println("Client [frmIssueHW]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmIssueHW]: "+re.getMessage(),
   "Error", JOptionPane.ERROR_MESSAGE);
   return savesucc;
  }

  return savesucc;
 }//Save

 /**
 * Requests Server to Update a Specific Record
 *
 * @return boolean true or false value
 */

 public boolean editData()
 {//Edit Data
  boolean updatesucc=false;

  //INITIALISE USER OBJECT...
  hwis.setTransactionID(txtTID.getText());
  hwis.setDate(txtDate.getText());
  hwis.setItemCode(txtItemCode.getText());
  hwis.setItem(cboHW.getSelectedItem()+"");
  hwis.setIssuedTo(txtISTO.getText());
  hwis.setEmpCode(EmpCode);
  hwis.setRemarks(txtRemarks.getText());

  try
  {
   updatesucc = hwiscon.updateData(hwis);
   StartWorking("UPDATING RECORD");

   ctccon.ExecuteQuery("UPDATE HW_Stock SET Issued='Yes' WHERE ItemCode='"+txtItemCode.getText()+"';");
   ctccon.ExecuteQuery("INSERT INTO HW_History (ItemCode,Date,EmpCode)VALUES('"+txtItemCode.getText()+"','"+txtDate.getText()+"','"+txtISTO.getText()+"');");

   JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
   getConnected();

  }catch(RemoteException re)
  {
   System.out.println("Client [frmIssueHW]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmIssueHW]: "+re.getMessage(),
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
  String strQuery = "DELETE FROM HW_Issue WHERE TransactionID='" + txtTID.getText() + "';";

  int yn;
  yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
  JOptionPane.YES_NO_OPTION, 3, imgQ);

  if (yn == JOptionPane.YES_OPTION)
  {
   try
   {
    hwiscon.DeleteData(strQuery);
    StartWorking("DELETING RECORD");

    ctccon.ExecuteQuery("UPDATE HW_Stock SET Issued='No' WHERE ItemCode='"+txtItemCode.getText()+"';");

    JOptionPane.showMessageDialog(null, "Server: Record Deleted!", "Information", 1);
    clearFields();
    getConnected();

   }catch(RemoteException re)
   {
    System.out.println("Client [frmHWStock]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmHWStock]: "+re.getMessage(),
             "Error", JOptionPane.ERROR_MESSAGE);
   }
  }
  else {}
 }//Delete Data

 /**
 * Gets Table Data
 * @param String SQL
 *
 */

 void getTableData(String SQLString)
 {
  try
  {
   rows = ctccon.getRowData(SQLString);
   ColHead = ctccon.getColumnData(SQLString);
   TotalCol = ctccon.getColNo(SQLString);

  }catch(RemoteException re)
  {
   System.out.println("Client [frmHWStock]: GET TABLE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmHWStock]: "+re.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
  }

  Table = new JTable(rows, ColHead);
  setColWidth(SQL, Table);
  sp.getViewport().add(Table);
  Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
  Table.setFont(new java.awt.Font("Tahoma", 0, 11));

  Table.addMouseListener(new java.awt.event.MouseAdapter()
  {
   public void mouseClicked(MouseEvent e)
   {
    int x[] = Table.getSelectedRows();

    if (x.length >= 1)
    {
     SelRow = new String[x.length][TotalCol];
     System.out.println("\nSELECTED ROW: ");
     for (int i = 0; i < x.length; i++)
     {
      for (int j = 0; j < TotalCol; j++)
      {
       SelRow[i][j] = Table.getValueAt(x[i], j).toString();
       System.out.print(SelRow[i][j]+" * ");
      }
     }
     txtTID.setText(SelRow[0][0]);txtDate.setText(SelRow[0][1]);txtItemCode.setText(SelRow[0][2]);cboHW.setSelectedItem(SelRow[0][3]);txtISTO.setText(SelRow[0][4]);txtRemarks.setText(SelRow[0][5]);
    }
    else if (x.length < 1)
    {
     JOptionPane.showMessageDialog(null, "Please Select One Item!", "Information Required...", JOptionPane.ERROR_MESSAGE);
    }
   }
  });
 }

 /**
 * Sets Column Widths of Table
 * @param String SQL, @param JTable Table
 *
 */

 void setColWidth(String SQLString, JTable Table)
 {
  TableColumn column = null;
  int[] sz = new int[6];
  sz[0]=110;sz[1]=60;sz[2]=110;sz[3]=120;sz[4]=60;sz[5]=60;
  for (int j = 0; j < TotalCol; ++j)
  {
   column = Table.getColumnModel().getColumn(j);
   column.setPreferredWidth(sz[j]);
  }
 }

 void btnEmp_actionPerformed(ActionEvent e)
 {
  frmList lst = new frmList("EMPLOYEE INFORMATION", "SELECT EmpCode, Name, Designation, Department, Ext FROM Employees ORDER BY EmpCode;");
  lst.setVisible(true);

  String t[][] = lst.getType();
  if(t!=null)
  {
   txtISTO.setText(t[0][0]);
  }
 }

 void btnHW_actionPerformed(ActionEvent e)
 {
  frmList lst = new frmList("AVAILABLE "+cboHW.getSelectedItem().toString()+"", "SELECT ItemCode, Item, Brand, Capacity, MB, Speed, CPUType FROM HW_Stock WHERE Item='"+cboHW.getSelectedItem().toString()+"' AND Issued='No' ORDER BY ItemCode;");
  lst.setVisible(true);

  String t[][] = lst.getType();
  if(t!=null)
  {
   txtItemCode.setText(t[0][0]);
  }
 }

 void btnDT1_actionPerformed(ActionEvent e)
 {
  frmDate fd = new frmDate("Select Date");
  fd.setSize(new Dimension(212, 163));
  fd.setVisible(true);
  String SDate = fd.createDate();
  txtDate.setText(SDate);
 }

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