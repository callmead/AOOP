//package beximtex;
/**
 * <p>Title: BeximTex, Supplier Payments</p>
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

public class frmPayments extends JInternalFrame
{//Class

 JTabbedPane TP = new JTabbedPane();
 JPanel pnlPO = new JPanel();
 JPanel pnlDV = new JPanel();
 TitledBorder titledBorder1;
 TitledBorder titledBorder2;
 TitledBorder titledBorder3;
 JPanel pnlFieldsPO = new JPanel();
 TitledBorder titledBorder4;
 TitledBorder titledBorder5;
 JTextField txtTID = new JTextField();
 JTextField txtDate = new JTextField();
 JLabel lblTID = new JLabel();
 JLabel lblSID = new JLabel();
 JTextField txtEmpCode = new JTextField();
 JLabel lblDate = new JLabel();
 JTextField txtOID = new JTextField();
 JLabel lblOID = new JLabel();
 JTextField txtAmount = new JTextField();
 JLabel lblAmount = new JLabel();
 JTextField txtRemarks = new JTextField();
 JLabel lblRem = new JLabel();
 JPanel pnlButtonsPO = new JPanel();
 TitledBorder titledBorder6;
 TitledBorder titledBorder7;
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
 TitledBorder titledBorder8;
 JPanel pnlTab = new JPanel();
 TitledBorder titledBorder9;
 TitledBorder titledBorder10;
 JScrollPane sp = new JScrollPane();
 JTable Table = new JTable();
 JPanel pnlFieldsRE = new JPanel();
 TitledBorder titledBorder11;
 TitledBorder titledBorder12;
 JPanel pnlSearch = new JPanel();
 TitledBorder titledBorder13;
 TitledBorder titledBorder14;
 JButton btnGo = new JButton();
 JLabel lblPicture = new JLabel();
 JComboBox cboSearch = new JComboBox();
 JTextField txtSearch = new JTextField();

 //**************************************************************
 //RMI Declare Server Object
 PaymentController paycon;
 Payment pay = new Payment();

 CommonTableController ctccon;
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
 ImageIcon imgTab = new ImageIcon("./Images/table.gif");
 ImageIcon imgSrc = new ImageIcon("./Images/find.png");
 ImageIcon imgRef = new ImageIcon("./Images/db.gif");
 ImageIcon imgSearch = new ImageIcon("./Images/powerSearch.gif");
 ImageIcon imgExc = new ImageIcon("./Images/exc.gif");
 ImageIcon imgQ = new ImageIcon("./Images/question32.png");
 ImageIcon imgHead = new ImageIcon("./Images/touch.gif");

 int yn;
 boolean isAdd = false;

 String Type[][];
 String SelRow[][];

 String OrderID=null;
 String QtyOrd=null;
 String ExiQty=null;

 String EmpCode = null;
 String TableName = null;

 String CurrentDate = null;
 String TranID = null;
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 Date d;

 String SQL = null;
 String SQL1 = null;

 Vector ColHead = new Vector();
 Vector rows = new Vector();

 int TotalCol = 0;
 int Rows = 0;
 int Columns = 0;

 JTextField txtPS = new JTextField();
 JLabel lblPS = new JLabel();
 JTextField txtSID = new JTextField();
 JTextField txtPM = new JTextField();
 JLabel lblPM = new JLabel();
 JToggleButton btnDT1 = new JToggleButton();
 JToggleButton btnLPD = new JToggleButton();
 JTextField txtLPD = new JTextField();
 JLabel lblLPD = new JLabel();
 JToggleButton btnIN = new JToggleButton();
 JTextField txtIN = new JTextField();
 JLabel lblIN = new JLabel();
 JToggleButton btnSID = new JToggleButton();
 JToggleButton btnOID = new JToggleButton();
 JLabel lblHead = new JLabel();

 public frmPayments(String ec)
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
   paycon = (PaymentController)Naming.lookup(new ReadHost().getHost() + "PaymentController");
   ctccon = (CommonTableController)Naming.lookup(new ReadHost().getHost() + "CommonTableController");

  }catch(Exception ec)
  {
   System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
   System.out.println("Error: "+ec.getMessage());
   JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
   "Error", JOptionPane.ERROR_MESSAGE);
   System.exit(0);
  }
  System.out.println("\n******************************\n CLIENT READY [frmPayments] \n******************************\n");
  //**************************************************************

  titledBorder1 = new TitledBorder("");
  titledBorder2 = new TitledBorder("");
  titledBorder3 = new TitledBorder("");
  titledBorder4 = new TitledBorder("");
  titledBorder5 = new TitledBorder("");
  titledBorder6 = new TitledBorder("");
  titledBorder7 = new TitledBorder("");
  titledBorder8 = new TitledBorder("");
  titledBorder9 = new TitledBorder("");
  titledBorder10 = new TitledBorder("");
  titledBorder11 = new TitledBorder("");
  titledBorder12 = new TitledBorder("");
  titledBorder13 = new TitledBorder("");
  titledBorder14 = new TitledBorder("");

  this.setTitle("SUPPLIER PAYMENTS");
  this.getContentPane().setLayout(null);
  this.setForeground(Color.white);
  this.setFrameIcon(imgIco);
  this.getContentPane().setBackground(Color.white);
  this.setClosable(true);
  this.setIconifiable(true);
  this.setMaximizable(false);
  this.setSize(new Dimension(596, 474));

  TP.setBackground(Color.black);
  TP.setFont(new java.awt.Font("Monospaced", 1, 12));
  TP.setForeground(Color.white);
  TP.setBounds(new Rectangle(7, 42, 572, 285));

  pnlPO.setBackground(Color.white);
  pnlPO.setForeground(Color.white);
  pnlPO.setBorder(titledBorder2);
  pnlPO.setLayout(null);
  pnlDV.setBackground(Color.white);
  pnlDV.setBorder(titledBorder3);
  pnlDV.setLayout(null);
  pnlFieldsPO.setBackground(Color.white);
  pnlFieldsPO.setBorder(titledBorder5);
  pnlFieldsPO.setBounds(new Rectangle(8, 9, 550, 160));
  pnlFieldsPO.setLayout(null);
  txtTID.setText("");
  txtTID.setBounds(new Rectangle(143, 9, 140, 23));
  txtTID.setEnabled(false);
  txtTID.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtDate.setBounds(new Rectangle(399, 9, 117, 23));
  txtDate.setEnabled(false);
  txtDate.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtDate.setText("");

  lblTID.setText("TRANSACTION ID");
  lblTID.setBounds(new Rectangle(10, 8, 102, 24));
  lblTID.setFont(new java.awt.Font("Tahoma", 1, 11));

  lblSID.setBounds(new Rectangle(285, 37, 106, 24));
  lblSID.setText("SUPPLIER ID");
  lblSID.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblSID.setHorizontalAlignment(SwingConstants.RIGHT);

  lblDate.setBounds(new Rectangle(350, 8, 41, 24));
  lblDate.setText("DATE");
  lblDate.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblDate.setHorizontalAlignment(SwingConstants.RIGHT);

  txtOID.setText("");
  txtOID.setBounds(new Rectangle(143, 38, 117, 23));
  txtOID.setEnabled(false);
  txtOID.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtOID.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtOID.selectAll();}
   public void focusLost(FocusEvent f) {}
  });

  lblOID.setText("ORDER ID");
  lblOID.setBounds(new Rectangle(10, 37, 106, 24));
  lblOID.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblOID.setToolTipText("");

  txtAmount.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtAmount.setBounds(new Rectangle(143, 67, 140, 23));
  txtAmount.setText("");
  txtAmount.setHorizontalAlignment(SwingConstants.RIGHT);
  txtAmount.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtAmount.selectAll();}
   public void focusLost(FocusEvent f) {}
  });

  txtAmount.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtAmount.getText().length()>=10){ke1.consume();}
    if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8)) {}
    else ke1.consume();
   }
  });

  txtAmount.setEnabled(true);
  lblAmount.setToolTipText("");
  lblAmount.setHorizontalAlignment(SwingConstants.LEFT);
  lblAmount.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblAmount.setBounds(new Rectangle(10, 66, 106, 24));
  lblAmount.setText("AMOUNT");
  txtRemarks.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtRemarks.setBounds(new Rectangle(399, 124, 140, 23));
  txtRemarks.setText("");
  txtRemarks.setEnabled(true);
  txtRemarks.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtRemarks.selectAll();}
   public void focusLost(FocusEvent f) {}
  });

  lblRem.setToolTipText("");
  lblRem.setHorizontalAlignment(SwingConstants.RIGHT);
  lblRem.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblRem.setBounds(new Rectangle(285, 123, 106, 24));
  lblRem.setText("REMARKS");
  pnlButtonsPO.setBackground(Color.white);
  pnlButtonsPO.setBorder(titledBorder7);
  pnlButtonsPO.setMaximumSize(new Dimension(32767, 32767));
  pnlButtonsPO.setBounds(new Rectangle(8, 175, 550, 74));
  pnlButtonsPO.setLayout(null);
  btnDelete.setBorder(BorderFactory.createRaisedBevelBorder());
  btnDelete.setMnemonic('D');
  btnDelete.setText("DELETE");
  btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnDelete.setIcon(new ImageIcon("images/Delete16.gif"));
  btnDelete.setBounds(new Rectangle(352, 36, 91, 28));
  btnDelete.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    if(txtTID.getText().equals(""))
    { return; }
    DeleteData();
   }
  });
  btnClose.setBorder(BorderFactory.createRaisedBevelBorder());
  btnClose.setMnemonic('L');
  btnClose.setText("CLOSE");
  btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnClose.setIcon(new ImageIcon("./Images/close.gif"));
  btnClose.setBounds(new Rectangle(446, 36, 91, 28));
  btnClose.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { dispose(); }
  });
  lblRec.setBackground(Color.white);
  lblRec.setBounds(new Rectangle(199, 10, 150, 21));
  lblRec.setOpaque(true);
  lblRec.setText("");
  lblRec.setFont(new Font("Tahoma", 1, 12));

  btnSave.setBorder(BorderFactory.createRaisedBevelBorder());
  btnSave.setMnemonic('S');
  btnSave.setText("SAVE");
  btnSave.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnSave.setIcon(new ImageIcon("images/Save16.gif"));
  btnSave.setBounds(new Rectangle(10, 36, 91, 28));
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
  btnCancel.setBounds(new Rectangle(104, 36, 91, 28));
  btnCancel.setText("CANCEL");
  btnCancel.setMnemonic('C');
  btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnCancel.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    setButton(true);
    setFields(false);
    getConnected();
    isAdd = false;
    lblRec.setText("");
   }
  });

  btnEdit.setBorder(BorderFactory.createRaisedBevelBorder());
  btnEdit.setBounds(new Rectangle(104, 36, 91, 28));
  btnEdit.setText("EDIT");
  btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnEdit.setMnemonic('E');
  btnEdit.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    btnDT1.setEnabled(false);
    setButton(false);
    setFields(true);
    btnDT1.setEnabled(false);
    txtOID.requestFocus();
    lblRec.setText(" Edit Record... ");
   }
  });

  btnNew.setBorder(BorderFactory.createRaisedBevelBorder());
  btnNew.setBounds(new Rectangle(10, 36, 91, 28));
  btnNew.setText("NEW");
  btnNew.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnNew.setMnemonic('N');
  btnNew.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    isAdd = true;
    setButton(false);
    setFields(true);
    clearFields();
    txtEmpCode.setText(EmpCode);
    d = new Date();
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    CurrentDate = sdf.format(d);
    txtDate.setText(CurrentDate);
    d = new Date();
    CurrentDate = null;
    sdf = new SimpleDateFormat("y");
    TranID = sdf.format(d);
    sdf = new SimpleDateFormat("M");
    TranID = TranID + sdf.format(d);
    sdf = new SimpleDateFormat("d");
    TranID = TranID + sdf.format(d);
    TranID = TranID + EmpCode;
    sdf = new SimpleDateFormat("Hms");
    TranID = TranID + sdf.format(d);
    txtTID.setText("S"+TranID);
    System.out.println("Transaction ID: " + txtTID.getText());

    txtOID.requestFocus();
    lblRec.setText(" Add New Record... ");
   }
  });

  btnLast.setToolTipText("Last");
  btnLast.setText("");
  btnLast.setIcon(imgLast);
  btnLast.setBounds(new Rectangle(376, 9, 22, 23));
  btnLast.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    try
    {
     pay=paycon.moveLast();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmPayments]: MOVE LAST Error");System.out.println("Error: "+re.getMessage());}
   }
  });
  btnLast.addMouseListener(new MouseAdapter()
  {
   public void mouseEntered(MouseEvent e)
   { btnLast.setIcon(imgLO); }

   public void mouseExited(MouseEvent f)
   { btnLast.setIcon(imgLast); }
  });
  btnRefresh.setToolTipText("Refresh Database");
  btnRefresh.setBorder(BorderFactory.createRaisedBevelBorder());
  btnRefresh.setMnemonic('B');
  btnRefresh.setIcon(imgRef);
  btnRefresh.setText("REFRESH DB");
  btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnRefresh.setBounds(new Rectangle(199, 36, 149, 28));
  btnRefresh.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { getConnected(); }
  });
  btnPrevious.setToolTipText("Previous");
  btnPrevious.setText("");
  btnPrevious.setIcon(imgPrev);
  btnPrevious.setBounds(new Rectangle(174, 9, 22, 23));
  btnPrevious.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    try
    {
     pay=paycon.movePrevious();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmPayments]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
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
  btnNext.setBounds(new Rectangle(353, 9, 22, 23));
  btnNext.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    try
    {
     pay=paycon.moveNext();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmPayments]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
   }
  });
  btnNext.addMouseListener(new MouseAdapter()
  {
   public void mouseEntered(MouseEvent e)
   { btnNext.setIcon(imgNO); }
   public void mouseExited(MouseEvent f)
   { btnNext.setIcon(imgNext); }
  });
  btnFirst.setToolTipText("First");
  btnFirst.setText("");
  btnFirst.setIcon(imgFirst);
  btnFirst.setBounds(new Rectangle(150, 9, 22, 23));
  btnFirst.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    try
    {
     pay=paycon.moveFirst();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmPayments]: MOVE FIRST Error");System.out.println("Error: "+re.getMessage());}
   }
  });
  btnFirst.addMouseListener(new MouseAdapter()
  {
   public void mouseEntered(MouseEvent e)
   { btnFirst.setIcon(imgFO); }
   public void mouseExited(MouseEvent f)
   { btnFirst.setIcon(imgFirst); }
  });
  pnlTab.setBounds(new Rectangle(6, 8, 554, 243));
  pnlTab.setLayout(null);
  pnlTab.setBackground(Color.white);
  pnlTab.setBorder(titledBorder9);
  sp.getViewport().setBackground(Color.white);
  sp.setToolTipText("Orders Queue");
  sp.setBounds(new Rectangle(6, 6, 540, 229));
  pnlFieldsRE.setBackground(Color.white);
  pnlFieldsRE.setBorder(titledBorder12);
  pnlFieldsRE.setBounds(new Rectangle(6, 158, 554, 60));
  pnlFieldsRE.setLayout(null);
  pnlSearch.setBackground(Color.white);
  pnlSearch.setBorder(titledBorder14);
  pnlSearch.setBounds(new Rectangle(7, 333, 572, 98));
  pnlSearch.setLayout(null);

  btnGo.setBounds(new Rectangle(459, 60, 91, 28));
  btnGo.setText("  FIND     ");
  btnGo.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnGo_actionPerformed(e); }
  });
  btnGo.setIcon(imgSrc);
  btnGo.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnGo.setBorder(BorderFactory.createRaisedBevelBorder());
  lblPicture.setText("");
  lblPicture.setIcon(imgSearch);
  lblPicture.setBounds(new Rectangle(17, 15, 273, 42));
  cboSearch.setBounds(new Rectangle(354, 63, 101, 24));
  cboSearch.setMaximumRowCount(4);
  cboSearch.setBackground(Color.white);
  txtSearch.setFont(new Font("Tahoma", 1, 12));
  txtSearch.setCaretColor(Color.blue);
  txtSearch.setText("");
  txtSearch.setBounds(new Rectangle(19, 63, 330, 24));

  txtPS.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtPS.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtPS.selectAll();}
   public void focusLost(FocusEvent f) {}
  });
  lblPS.setToolTipText("");
  lblPS.setHorizontalAlignment(SwingConstants.RIGHT);
  lblPS.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblPS.setDoubleBuffered(false);
  lblPS.setBounds(new Rectangle(285, 66, 106, 24));
  lblPS.setText("PAYMENT STATUS");
  txtPS.setBounds(new Rectangle(399, 67, 140, 23));
  txtSID.setBounds(new Rectangle(399, 38, 117, 23));
  txtSID.setText("");
  txtSID.setEnabled(false);
  txtSID.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtSID.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   { txtSID.selectAll();}

   public void focusLost(FocusEvent f) {}
  });

  txtPM.setBounds(new Rectangle(143, 124, 140, 23));
  txtPM.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtPM.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtPM.selectAll();}
   public void focusLost(FocusEvent f) {}
  });
  lblPM.setText("PAYMENT MODE");
  lblPM.setBounds(new Rectangle(10, 123, 106, 24));
  lblPM.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblPM.setToolTipText("");
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
  btnDT1.setBounds(new Rectangle(517, 38, 22, 23));
  btnDT1.setBounds(new Rectangle(378, 8, 22, 23));
  btnDT1.setBounds(new Rectangle(517, 9, 22, 23));
  btnLPD.setBounds(new Rectangle(517, 9, 22, 23));
  btnLPD.setBounds(new Rectangle(378, 8, 22, 23));
  btnLPD.setBounds(new Rectangle(517, 38, 22, 23));
  btnLPD.setBounds(new Rectangle(518, 11, 22, 23));
  btnLPD.setToolTipText("DATE SELECTOR");
  btnLPD.setText("");
  btnLPD.setIcon(imgTab);
  btnLPD.setBounds(new Rectangle(261, 96, 22, 23));
  btnLPD.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnLPD_actionPerformed(e); }
  });
  txtLPD.setText("");
  txtLPD.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtLPD.setEnabled(false);
  txtLPD.setBounds(new Rectangle(143, 96, 117, 23));
  lblLPD.setHorizontalAlignment(SwingConstants.LEFT);
  lblLPD.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblLPD.setText("LAST PAYMENT DATE");
  lblLPD.setBounds(new Rectangle(10, 96, 121, 24));
  btnIN.setBounds(new Rectangle(517, 9, 22, 23));
  btnIN.setBounds(new Rectangle(378, 8, 22, 23));
  btnIN.setBounds(new Rectangle(517, 38, 22, 23));
  btnIN.setBounds(new Rectangle(518, 11, 22, 23));
  btnIN.setToolTipText("DATE SELECTOR");
  btnIN.setText("");
  btnIN.setIcon(imgTab);
  btnIN.setBounds(new Rectangle(517, 96, 22, 23));
  btnIN.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnIN_actionPerformed(e); }
  });
  txtIN.setText("");
  txtIN.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtIN.setEnabled(false);
  txtIN.setBounds(new Rectangle(399, 96, 117, 23));
  lblIN.setHorizontalAlignment(SwingConstants.RIGHT);
  lblIN.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblIN.setText("INDENT NO.");
  lblIN.setBounds(new Rectangle(293, 95, 98, 24));
  btnSID.setBounds(new Rectangle(517, 9, 22, 23));
  btnSID.setBounds(new Rectangle(378, 8, 22, 23));
  btnSID.setBounds(new Rectangle(517, 38, 22, 23));
  btnSID.setBounds(new Rectangle(518, 11, 22, 23));
  btnSID.setToolTipText("DATE SELECTOR");
  btnSID.setText("");
  btnSID.setIcon(imgTab);
  btnSID.setBounds(new Rectangle(517, 38, 22, 23));
  btnSID.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnSID_actionPerformed(e); }
  });
  btnOID.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnOID_actionPerformed(e); }
  });
  btnOID.setBounds(new Rectangle(517, 38, 22, 23));
  btnOID.setIcon(imgTab);
  btnOID.setText("");
  btnOID.setToolTipText("DATE SELECTOR");
  btnOID.setBounds(new Rectangle(518, 11, 22, 23));
  btnOID.setBounds(new Rectangle(517, 38, 22, 23));
  btnOID.setBounds(new Rectangle(378, 8, 22, 23));
  btnOID.setBounds(new Rectangle(261, 38, 22, 23));
  lblHead.setBounds(new Rectangle(0, 0, 534, 60));
  lblHead.setIcon(imgHead);

  pnlFieldsPO.add(txtEmpCode, null);
  pnlFieldsPO.add(lblSID, null);
  pnlFieldsPO.add(lblTID, null);
  pnlFieldsPO.add(lblOID, null);
  pnlFieldsPO.add(lblRem, null);
  pnlFieldsPO.add(txtRemarks, null);
  pnlFieldsPO.add(txtTID, null);
  pnlFieldsPO.add(txtOID, null);
  pnlFieldsPO.add(txtSID, null);
  pnlFieldsPO.add(lblDate, null);
  pnlFieldsPO.add(txtDate, null);
  pnlFieldsPO.add(txtPM, null);
  pnlFieldsPO.add(lblPM, null);
  pnlFieldsPO.add(btnDT1, null);
  pnlFieldsPO.add(txtAmount, null);
  pnlFieldsPO.add(lblAmount, null);
  pnlFieldsPO.add(txtPS, null);
  pnlFieldsPO.add(lblPS, null);
  pnlFieldsPO.add(lblLPD, null);
  pnlFieldsPO.add(btnLPD, null);
  pnlFieldsPO.add(txtLPD, null);
  pnlFieldsPO.add(btnIN, null);
  pnlFieldsPO.add(txtIN, null);
  pnlFieldsPO.add(lblIN, null);
  pnlFieldsPO.add(btnSID, null);
  pnlFieldsPO.add(btnOID, null);

  pnlButtonsPO.add(btnEdit, null);
  pnlButtonsPO.add(btnNew, null);
  pnlButtonsPO.add(btnRefresh, null);
  pnlButtonsPO.add(btnSave, null);
  pnlButtonsPO.add(btnDelete, null);
  pnlButtonsPO.add(lblRec, null);
  pnlButtonsPO.add(btnClose, null);
  pnlButtonsPO.add(btnCancel, null);
  pnlButtonsPO.add(btnPrevious, null);
  pnlButtonsPO.add(btnLast, null);
  pnlButtonsPO.add(btnNext, null);
  pnlButtonsPO.add(btnFirst, null);
  pnlPO.add(pnlFieldsPO, null);
  pnlPO.add(pnlButtonsPO, null);

  pnlDV.add(pnlTab, null);
  pnlTab.add(sp, null);
  pnlDV.add(pnlFieldsRE, null);
  TP.add(pnlPO, "PROCESS");
  sp.add(Table, null);
  TP.add(pnlDV, "DATA VIEW");
  this.getContentPane().add(TP, null);
  this.getContentPane().add(pnlSearch, null);
  this.getContentPane().add(lblHead, null);
  pnlSearch.add(btnGo, null);
  pnlSearch.add(lblPicture, null);
  pnlSearch.add(txtSearch, null);
  pnlSearch.add(cboSearch, null);

  getComboItems();
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
   paycon.Connect();
  }catch(RemoteException re){ System.out.println("Client [frmPayments]: Open Error");System.out.println("Error: "+re.getMessage());}

  //DISPLAY DATA RMI
  try
  {
   pay = paycon.moveNext();
   display();
  }catch(RemoteException re){ System.out.println("Client [frmPayments]: Show Error");System.out.println("Error: "+re.getMessage());}

  SQL="SELECT * FROM Payments ORDER BY TransactionID;";
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
  btnRefresh.setEnabled(btnValue);
  btnGo.setEnabled(btnValue);
  btnDT1.setEnabled(!btnValue);
  btnSID.setEnabled(!btnValue);
  btnOID.setEnabled(!btnValue);
  btnIN.setEnabled(!btnValue);
  btnLPD.setEnabled(!btnValue);
 }

 /**
 * Sets Fields States
 * @param boolean true or false
 *
 */

 public void setFields(boolean txtValue)
 {
  txtAmount.setEnabled(txtValue);
  txtPS.setEnabled(txtValue);
  txtPM.setEnabled(txtValue);
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
  txtOID.setText("");
  txtSID.setText("");
  txtPS.setText("");
  txtAmount.setText("");
  txtPM.setText("");
  txtLPD.setText("");
  txtIN.setText("");
  txtRemarks.setText("");
 }

 /**
 * Display Data
 *
 */

 public void display()
 {
  txtTID.setText(pay.getTransactionID());
  txtDate.setText(pay.getDate());
  txtOID.setText(pay.getOID());
  txtSID.setText(pay.getSID());
  txtAmount.setText(pay.getAmount());
  txtPS.setText(pay.getStatus());
  txtLPD.setText(pay.getLPD());
  txtIN.setText(pay.getIndentNo());
  txtPM.setText(pay.getPMode());
  txtRemarks.setText(pay.getRemarks());
 }

 /**
 * Checks the Fields
 *
 * @return boolean true or false value
 */

 public boolean checkFields()
 {
  if (txtOID.getText().equals("")){JOptionPane.showMessageDialog(null,"Please select an Order!","Missing Information",JOptionPane.ERROR_MESSAGE);txtOID.requestFocus();return false;}
  if (txtSID.getText().equals("")){JOptionPane.showMessageDialog(null,"Please select a Supplier!","Missing Information",JOptionPane.ERROR_MESSAGE);txtSID.requestFocus();return false;}
  if (txtAmount.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Amount!","Missing Information",JOptionPane.ERROR_MESSAGE);txtAmount.requestFocus();return false;}
  if (txtPS.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Payment Status!","Missing Information",JOptionPane.ERROR_MESSAGE);txtPS.requestFocus();return false;}
  if (txtLPD.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Last Payment Date!","Missing Information",JOptionPane.ERROR_MESSAGE);txtLPD.requestFocus();return false;}
  if (txtIN.getText().equals("")){JOptionPane.showMessageDialog(null,"Please select Indent No.!","Missing Information",JOptionPane.ERROR_MESSAGE);txtIN.requestFocus();return false;}
  if (txtPM.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Payment Mode!","Missing Information",JOptionPane.ERROR_MESSAGE);txtPM.requestFocus();return false;}
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
  pay.setTransactionID(txtTID.getText());
  pay.setDate(txtDate.getText());
  pay.setOID(txtOID.getText());
  pay.setSID(txtSID.getText());
  pay.setAmount(txtAmount.getText());
  pay.setStatus(txtPS.getText());
  pay.setLPD(txtLPD.getText());
  pay.setIndentNo(txtIN.getText());
  pay.setPMode(txtPM.getText());
  pay.setRemarks(txtRemarks.getText());

  try
  {
   savesucc = paycon.insertData(pay);
   StartWorking("ADDING NEW RECORD");
   JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
   getConnected();

  }catch(RemoteException re)
  {
   System.out.println("Client [frmPayments]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmPayments]: "+re.getMessage(),
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
  pay.setTransactionID(txtTID.getText());
  pay.setDate(txtDate.getText());
  pay.setOID(txtOID.getText());
  pay.setSID(txtSID.getText());
  pay.setAmount(txtAmount.getText());
  pay.setStatus(txtPS.getText());
  pay.setLPD(txtLPD.getText());
  pay.setIndentNo(txtIN.getText());
  pay.setPMode(txtPM.getText());
  pay.setRemarks(txtRemarks.getText());

  try
  {
   updatesucc = paycon.updateData(pay);
   StartWorking("UPDATING RECORD");
   JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
   getConnected();

  }catch(RemoteException re)
  {
   System.out.println("Client [frmPayments]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmPayments]: "+re.getMessage(),
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
  String strQuery = "DELETE FROM Payments WHERE TransactionID='" + txtTID.getText() + "';";

  int yn;
  yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
  JOptionPane.YES_NO_OPTION, 3, imgQ);

  if (yn == JOptionPane.YES_OPTION)
  {
   try
   {
    paycon.DeleteData(strQuery);
    StartWorking("DELETING RECORD");
    JOptionPane.showMessageDialog(null, "Server: Record Deleted!", "Information", 1);
    clearFields();
    getConnected();

   }catch(RemoteException re)
   {
    System.out.println("Client [frmPayments]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmPayments]: "+re.getMessage(),
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
   System.out.println("Client [frmPayments]: GET TABLE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmPayments]: "+re.getMessage(),
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
     txtTID.setText(SelRow[0][0]);txtDate.setText(SelRow[0][1]);txtOID.setText(SelRow[0][2]);txtSID.setText(SelRow[0][3]);txtAmount.setText(SelRow[0][4]);txtPS.setText(SelRow[0][5]);txtLPD.setText(SelRow[0][6]);txtIN.setText(SelRow[0][7]);txtPM.setText(SelRow[0][8]);txtRemarks.setText(SelRow[0][9]);
    }
    else if (x.length < 1)
    {
     JOptionPane.showMessageDialog(null, "Please Select One Item!",
     "Information Required...",
     JOptionPane.ERROR_MESSAGE);
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
  int[] sz = new int[10];
  sz[0]=100;sz[1]=60;sz[2]=100;sz[3]=100;sz[4]=70;sz[5]=70;sz[6]=60;sz[7]=100;
  sz[8]=120;sz[9]=200;
  for (int j = 0; j < TotalCol; ++j)
  {
   column = Table.getColumnModel().getColumn(j);
   column.setPreferredWidth(sz[j]);
  }
 }

 /**
 * Searching
 *
 */

 void btnGo_actionPerformed(ActionEvent e)
 {
  String SQLString=null;
  if (txtSearch.getText().equals(""))
  {
   JOptionPane.showMessageDialog(null, "Search What ?", "Information Required...", JOptionPane.INFORMATION_MESSAGE, imgExc);
   txtSearch.requestFocus();
  }
  else
  {
   SQLString = "SELECT * FROM Payments WHERE " + cboSearch.getSelectedItem().toString() + "='" + txtSearch.getText() + "';";

   try
   {
    if (paycon.isFound(SQLString))
    {
     pay = paycon.SearchData(SQLString);
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
   {System.out.println("Client [frmPayments]: SEARCH DATA Error");System.out.println("Error: "+re.getMessage());}
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
 * Adding Combo Items
 *
 */

 void getComboItems()
 {
  cboSearch.addItem("SID");
  cboSearch.addItem("OID");
  cboSearch.addItem("IndentNo");
 }

 void btnLPD_actionPerformed(ActionEvent e)
 {
  frmDate fd = new frmDate("Select Last Payment Date");
  fd.setSize(new Dimension(212, 163));
  fd.setVisible(true);
  String SDate = fd.createDate();
  txtLPD.setText(SDate);
 }

 void btnOID_actionPerformed(ActionEvent e)
 {
  frmList lst = new frmList("PURCHASE ORDERS", "SELECT HW_POGR.OID as 'PO', HW_POGR.Date, Suppliers.Name as 'Supplier', HW_POGR.Item, HW_POGR.QtyOrd, HW_POGR.OfferNo, HW_POGR.DeliveryAt FROM HW_POGR, Suppliers WHERE Suppliers.SID = HW_POGR.SID;");

  lst.setVisible(true);

  String t[][] = lst.getType();
  if(t!=null)
  {
   txtOID.setText(t[0][0]);
  }
 }

 void btnSID_actionPerformed(ActionEvent e)
 {
  frmList lst = new frmList("SUPPLIERS INFORMATION", "SELECT SID, Name as 'Firm', Address,Email,Phone,Mobile,ContactPerson,Remarks FROM Suppliers ORDER BY SID;");
  lst.setVisible(true);

  String t[][] = lst.getType();
  if(t!=null)
  {
   txtSID.setText(t[0][0]);
  }
 }

 void btnIN_actionPerformed(ActionEvent e)
 {
  frmList lst = new frmList("INDENTS", "SELECT IndentNo,BU,Date,Amount,RecFrom,RecDate,RecBy,Remarks FROM Indents ORDER BY IndentNo;");
  lst.setVisible(true);

  String t[][] = lst.getType();
  if(t!=null)
  {
   txtIN.setText(t[0][0]);
  }
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