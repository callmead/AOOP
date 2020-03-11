//package beximtex;
/**
 * <p>Title: BeximTex, Purchase Orders & Goods Received</p>
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

public class frmPOGR extends JInternalFrame
{//Class

 JTabbedPane TP = new JTabbedPane();
 JPanel pnlPO = new JPanel();
 JPanel pnlReceive = new JPanel();
 TitledBorder titledBorder1;
 TitledBorder titledBorder2;
 TitledBorder titledBorder3;
 JPanel pnlFieldsPO = new JPanel();
 TitledBorder titledBorder4;
 TitledBorder titledBorder5;
 JTextField txtSID = new JTextField();
 JTextField txtDate = new JTextField();
 JLabel lblSID = new JLabel();
 JLabel lblDate = new JLabel();
 JTextField txtTID = new JTextField();
 JLabel lblEID = new JLabel();
 JTextField txtItem = new JTextField();
 JLabel lblItem = new JLabel();
 JTextField txtQty = new JTextField();
 JLabel lblQty = new JLabel();
 JTextField txtRemarks = new JTextField();
 JLabel lblRem = new JLabel();
 JToggleButton btnSup = new JToggleButton();
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
 JButton btnCloseRec = new JButton();
 JButton btnUQ = new JButton();
 JTextField txtQtyRec = new JTextField();
 JLabel lblQtyRec = new JLabel();
 JButton btnGo = new JButton();
 JLabel lblPicture = new JLabel();
 JComboBox cboSearch = new JComboBox();
 JTextField txtSearch = new JTextField();
 JLabel lblHead = new JLabel();

 //**************************************************************
 //RMI Declare Server Object
 HWpogrController hwpocon;
 HWpogr hwpo = new HWpogr();

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
 ImageIcon imgHead = new ImageIcon("./Images/touch.gif");
 ImageIcon imgExc = new ImageIcon("./Images/exc.gif");
 ImageIcon imgQ = new ImageIcon("./Images/question32.png");

 int yn;
 boolean isAdd = false;

 String ExecResult;
 String Type[][];
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
 String PSQL = null;
 String PSQL1 = null;

 String tOID = null;

 Vector ColHead = new Vector();
 Vector rows = new Vector();

 int TotalCol = 0;
 int Rows = 0;
 int Columns = 0;

 String SelRow[][];

 JTextField txtLD = new JTextField();
 JLabel lblLD = new JLabel();
 JToggleButton btnDT = new JToggleButton();
 JTextField txtDP = new JTextField();
 JLabel lblDP = new JLabel();
 JTextField txtOID = new JTextField();
 JLabel lblDate1 = new JLabel();
 JToggleButton btnDT1 = new JToggleButton();
 JLabel lblON = new JLabel();
 JTextField txtON = new JTextField();
 JToggleButton btnDT2 = new JToggleButton();
 JTextField txtODate = new JTextField();
 JLabel lblODate = new JLabel();
 JTextField txtPrice = new JTextField();
 JLabel lblPrice = new JLabel();
 JTextField txtTotal = new JTextField();
 int qo,qr,eq,tq;

 public frmPOGR(String ec)
 {//Cons
  EmpCode = ec;
  try {jbInit();}
  catch(Exception e){System.exit(0);}
 }//Cons

 private void jbInit() throws Exception
 {//jbInit

  //**************************************************************
     //getConnection: getConnected with Server
  try
  {
   hwpocon = (HWpogrController)Naming.lookup(new ReadHost().getHost() + "HWpogrController");
   ctccon = (CommonTableController)Naming.lookup(new ReadHost().getHost() + "CommonTableController");

  }catch(Exception ec)
  {
   System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
   System.out.println("Error: "+ec.getMessage());
   JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
   "Error", JOptionPane.ERROR_MESSAGE);
   System.exit(0);
  }
  System.out.println("\n******************************\n CLIENT READY [frmPOGR] \n******************************\n");
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
  this.setTitle("PURCHASE ORDERS & GOODS RECEIVED");
  this.getContentPane().setLayout(null);
  this.setForeground(Color.white);
  this.setFrameIcon(imgIco);
  this.getContentPane().setBackground(Color.white);
  this.setClosable(true);
  this.setIconifiable(true);
  this.setMaximizable(false);
  this.setSize(new Dimension(596, 471));
  TP.setBackground(Color.black);
  TP.setFont(new java.awt.Font("Monospaced", 1, 12));
  TP.setForeground(Color.white);
  TP.setBounds(new Rectangle(7, 42, 572, 285));

  pnlPO.setBackground(Color.white);
  pnlPO.setForeground(Color.white);
  pnlPO.setBorder(titledBorder2);
  pnlPO.setLayout(null);
  pnlReceive.setBackground(Color.white);
  pnlReceive.setBorder(titledBorder3);
  pnlReceive.setLayout(null);
  pnlFieldsPO.setBackground(Color.white);
  pnlFieldsPO.setBorder(titledBorder5);
  pnlFieldsPO.setBounds(new Rectangle(8, 9, 550, 160));
  pnlFieldsPO.setLayout(null);
  txtSID.setText("");
  txtSID.setBounds(new Rectangle(106, 38, 114, 23));
  txtSID.setEnabled(false);
  txtSID.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtDate.setBounds(new Rectangle(441, 9, 75, 23));
  txtDate.setEnabled(false);
  txtDate.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtDate.setText("");
  lblSID.setText("SUPPLIER ID");
  lblSID.setBounds(new Rectangle(10, 37, 102, 24));
  lblSID.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblDate.setBounds(new Rectangle(396, 8, 36, 24));
  lblDate.setText("DATE");
  lblDate.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
  txtTID.setEnabled(false);
  txtTID.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtTID.setBounds(new Rectangle(106, 9, 140, 23));
  txtTID.setText("");
  lblEID.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblEID.setBounds(new Rectangle(10, 8, 106, 24));
  lblEID.setText("TRANSACTION #");
  txtItem.setText("");
  txtItem.setBounds(new Rectangle(106, 66, 140, 23));
  txtItem.setEnabled(true);
  txtItem.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtItem.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtItem.selectAll();}
   public void focusLost(FocusEvent f) {}
  });

  lblItem.setText("ITEM");
  lblItem.setBounds(new Rectangle(10, 65, 36, 24));
  lblItem.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblItem.setToolTipText("");
  lblItem.setHorizontalAlignment(SwingConstants.LEADING);
  txtQty.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtQty.setBounds(new Rectangle(298, 66, 56, 23));
  txtQty.setText("");
  txtQty.setHorizontalAlignment(SwingConstants.RIGHT);
  txtQty.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtQty.selectAll();}
   public void focusLost(FocusEvent f) {}
  });

  txtQty.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtQty.getText().length()>=5){ke1.consume();}
    if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8)) {}
    else ke1.consume();
   }
   public void keyReleased(KeyEvent ke)
   { Calculate(); }
  });

  txtQty.setEnabled(true);
  lblQty.setToolTipText("");
  lblQty.setHorizontalAlignment(SwingConstants.RIGHT);
  lblQty.setHorizontalTextPosition(SwingConstants.RIGHT);
  lblQty.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblQty.setBounds(new Rectangle(246, 65, 48, 24));
  lblQty.setText("QTY");
  txtRemarks.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtRemarks.setBounds(new Rectangle(106, 124, 433, 23));
  txtRemarks.setText("");
  txtRemarks.setEnabled(true);
  txtRemarks.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtRemarks.selectAll();}
   public void focusLost(FocusEvent f) {}
  });

  lblRem.setToolTipText("");
  lblRem.setHorizontalAlignment(SwingConstants.LEFT);
  lblRem.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblRem.setBounds(new Rectangle(10, 123, 66, 24));
  lblRem.setText("REMARKS");
  btnSup.setToolTipText("Show Supplier List");
  btnSup.setText("");
  btnSup.setBounds(new Rectangle(224, 38, 22, 23));
  btnSup.setIcon(imgTab);
  btnSup.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnSup_actionPerformed(e); }
  });
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
  btnClose.setIcon(new ImageIcon("images/close.gif"));
  btnClose.setBounds(new Rectangle(446, 36, 91, 28));
  btnClose.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { dispose(); }
  });
  lblRec.setBackground(Color.white);
  lblRec.setBounds(new Rectangle(199, 10, 150, 21));
  lblRec.setOpaque(true);
  lblRec.setText("REC #");
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

     int yn=0;
     if (isAdd)
     {
      if (save()==false)
      {
       JOptionPane.showMessageDialog(null, "UNABLE TO INSERT NEW RECORD !!!\nPlease try with valid Data ...",
                "Error", JOptionPane.ERROR_MESSAGE);
      }
      else
      {
       yn = JOptionPane.showConfirmDialog(null,
       "Do you want to End the current ORDER?", "Conformation...",
       JOptionPane.YES_NO_OPTION, 3, imgQ);

       if (yn == JOptionPane.YES_OPTION)
       {
        AddPaymentDetails();
        StartWorking("ADDING NEW RECORD");
        setButton(true);
        setFields(false);
        JOptionPane.showMessageDialog(null, "Server: Recors Added!", "Information", 1);
        getConnected();
        //SET FLAG...
        isAdd=false;
        lblRec.setText("");
       }
       else
       {
        GenerateTransactionID();
        txtItem.requestFocus();
       };
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
    }//CheckFields
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
    tOID = txtOID.getText();
    setButton(false);
    setFields(true);
    btnDT1.setEnabled(false);
    txtItem.requestFocus();
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
    d = new Date();
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    CurrentDate = sdf.format(d);
    txtDate.setText(CurrentDate);
    GenerateTransactionID();
    txtQty.setText("0");
    txtPrice.setText("0");
    txtTotal.setText("0");
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
     hwpo=hwpocon.moveLast();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmPOGR]: MOVE LAST Error");System.out.println("Error: "+re.getMessage());}
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
   { getConnected();}
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
     hwpo=hwpocon.movePrevious();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmPOGR]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
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
     hwpo=hwpocon.moveNext();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmPOGR]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
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
     hwpo=hwpocon.moveFirst();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmPOGR]: MOVE FIRST Error");System.out.println("Error: "+re.getMessage());}
   }
  });
  btnFirst.addMouseListener(new MouseAdapter()
  {
   public void mouseEntered(MouseEvent e)
   { btnFirst.setIcon(imgFO); }
   public void mouseExited(MouseEvent f)
   { btnFirst.setIcon(imgFirst); }
  });
  pnlTab.setBounds(new Rectangle(6, 8, 554, 146));
  pnlTab.setLayout(null);
  pnlTab.setBackground(Color.white);
  pnlTab.setBorder(titledBorder9);
  sp.getViewport().setBackground(Color.white);
  sp.setToolTipText("Orders Queue");
  sp.setBounds(new Rectangle(6, 6, 540, 132));
  pnlFieldsRE.setBackground(Color.white);
  pnlFieldsRE.setBorder(titledBorder12);
  pnlFieldsRE.setBounds(new Rectangle(6, 158, 554, 60));
  pnlFieldsRE.setLayout(null);
  pnlSearch.setBackground(Color.white);
  pnlSearch.setBorder(titledBorder14);
  pnlSearch.setBounds(new Rectangle(7, 333, 572, 98));
  pnlSearch.setLayout(null);

  btnCloseRec.setBounds(new Rectangle(447, 16, 91, 28));
  btnCloseRec.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnCloseRec.setText("CLOSE");
  btnCloseRec.setMnemonic('L');
  btnCloseRec.setBorder(BorderFactory.createRaisedBevelBorder());
  btnCloseRec.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { dispose(); }
  });

  btnUQ.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnUQ.setText("UPDATE");
  btnUQ.setBounds(new Rectangle(234, 16, 91, 28));
  btnUQ.setBorder(BorderFactory.createRaisedBevelBorder());
  btnUQ.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnUQ_actionPerformed(e); }
  });
  txtQtyRec.setEnabled(true);
  txtQtyRec.setText("");
  txtQtyRec.setBounds(new Rectangle(137, 19, 89, 23));
  txtQtyRec.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtQtyRec.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtQtyRec.getText().length()>5){ke1.consume();}
    if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8)) {}
    else ke1.consume();
   }
  });

  lblQtyRec.setText("QUANTITY RECEIVED");
  lblQtyRec.setBounds(new Rectangle(8, 18, 132, 24));
  lblQtyRec.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblQtyRec.setHorizontalAlignment(SwingConstants.LEFT);
  lblQtyRec.setToolTipText("");
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
  cboSearch.addItem("OID");
  cboSearch.addItem("Date");
  cboSearch.addItem("SID");
  cboSearch.addItem("Item");
  cboSearch.addItem("QtyOrd");
  cboSearch.addItem("EmpCode");

  txtSearch.setFont(new Font("Tahoma", 1, 12));
  txtSearch.setCaretColor(Color.blue);
  txtSearch.setText("");
  txtSearch.setBounds(new Rectangle(19, 63, 330, 24));
  txtLD.setEnabled(false);
  txtLD.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtLD.setBounds(new Rectangle(106, 96, 114, 23));
  txtLD.setText("");
  txtLD.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtLD.selectAll();}
   public void focusLost(FocusEvent f) {}
  });
  txtLD.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtLD.getText().length()>=10){ke1.consume();}
    if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==45) || (ke1.getKeyChar()==8)) {}//45- 8BackSpace
    else ke1.consume();
   }
  });

  lblLD.setToolTipText("LAST DELIVERY DATE");
  lblLD.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblLD.setBounds(new Rectangle(10, 95, 98, 24));
  lblLD.setText("DELIVEREY DATE");
  btnDT.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnDT_actionPerformed(e); }
  });
  btnDT.setIcon(imgTab);
  btnDT.setBounds(new Rectangle(224, 96, 22, 23));
  btnDT.setText("");
  txtDP.setEnabled(true);
  txtDP.setBounds(new Rectangle(399, 96, 140, 23));
  txtDP.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtDP.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtDP.selectAll();}
   public void focusLost(FocusEvent f) {}
  });


  lblDP.setText("DELIVERY PLACE");
  lblDP.setBounds(new Rectangle(285, 95, 106, 24));
  lblDP.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblDP.setHorizontalAlignment(SwingConstants.RIGHT);
  lblDP.setToolTipText("");
  txtOID.setText("");
  txtOID.setBounds(new Rectangle(297, 9, 104, 23));
  txtOID.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtOID.setToolTipText("ORDER ID");
  txtOID.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtOID.selectAll();}
   public void focusLost(FocusEvent f) {}
  });

  lblDate1.setHorizontalAlignment(SwingConstants.RIGHT);
  lblDate1.setHorizontalTextPosition(SwingConstants.RIGHT);
  lblDate1.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblDate1.setText("PO");
  lblDate1.setBounds(new Rectangle(269, 8, 25, 24));
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
  btnDT1.setBounds(new Rectangle(517, 9, 22, 23));
  lblON.setText("OFFER #");
  lblON.setBounds(new Rectangle(239, 37, 56, 24));
  lblON.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblON.setToolTipText("");
  lblON.setHorizontalAlignment(SwingConstants.RIGHT);
  lblON.setHorizontalTextPosition(SwingConstants.RIGHT);
  txtON.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtON.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtLD.getText().length()>=15){ke1.consume();}
   }
  });
  txtON.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtON.selectAll();}
   public void focusLost(FocusEvent f) {}
  });

  txtON.setBounds(new Rectangle(297, 38, 104, 23));
  btnDT2.setBounds(new Rectangle(517, 9, 22, 23));
  btnDT2.setBounds(new Rectangle(518, 11, 22, 23));
  btnDT2.setToolTipText("DATE SELECTOR");
  btnDT2.setText("");
  btnDT2.setIcon(imgTab);
  btnDT2.setBounds(new Rectangle(517, 38, 22, 23));
  btnDT2.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnDT2_actionPerformed(e); }
  });
  txtODate.setText("");
  txtODate.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtODate.setEnabled(false);
  txtODate.setBounds(new Rectangle(441, 38, 75, 23));
  lblODate.setHorizontalAlignment(SwingConstants.RIGHT);
  lblODate.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblODate.setText("DATED");
  lblODate.setBounds(new Rectangle(401, 37, 39, 24));
  txtPrice.setEnabled(true);
  txtPrice.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtPrice.setHorizontalAlignment(SwingConstants.RIGHT);
  txtPrice.setBounds(new Rectangle(404, 66, 65, 23));
  txtPrice.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtPrice.getText().length()>=6){ke1.consume();}
    if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8)) {}
    else ke1.consume();
   }
   public void keyReleased(KeyEvent ke)
   { Calculate(); }
  });
  txtPrice.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtPrice.selectAll();}
   public void focusLost(FocusEvent f) {}
  });

  lblPrice.setText("PRICE");
  lblPrice.setBounds(new Rectangle(358, 65, 39, 24));
  lblPrice.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblPrice.setHorizontalTextPosition(SwingConstants.RIGHT);
  lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
  lblPrice.setToolTipText("");
  txtTotal.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtTotal.getText().length()>=6){ke1.consume();}
    if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8)) {}
    else ke1.consume();
   }
  });
  txtTotal.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtTotal.selectAll();}
   public void focusLost(FocusEvent f) {}
  });

  txtTotal.setEnabled(false);
  txtTotal.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtTotal.setToolTipText("TOTAL");
  txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
  txtTotal.setBounds(new Rectangle(474, 66, 65, 23));

  lblHead.setBounds(new Rectangle(0, 0, 534, 60));
  lblHead.setIcon(imgHead);
  pnlFieldsPO.add(lblSID, null);
  pnlFieldsPO.add(lblEID, null);
  pnlFieldsPO.add(lblRem, null);
  pnlFieldsPO.add(txtRemarks, null);
  pnlFieldsPO.add(lblLD, null);
  pnlFieldsPO.add(txtDP, null);
  pnlFieldsPO.add(lblDP, null);
  pnlFieldsPO.add(btnDT1, null);
  pnlFieldsPO.add(txtDate, null);
  pnlFieldsPO.add(txtON, null);
  pnlFieldsPO.add(lblODate, null);
  pnlFieldsPO.add(txtODate, null);
  pnlFieldsPO.add(btnDT2, null);
  pnlFieldsPO.add(txtOID, null);
  pnlFieldsPO.add(lblDate, null);
  pnlFieldsPO.add(txtSID, null);
  pnlFieldsPO.add(btnSup, null);
  pnlFieldsPO.add(txtLD, null);
  pnlFieldsPO.add(btnDT, null);
  pnlFieldsPO.add(txtTID, null);
  pnlFieldsPO.add(txtItem, null);
  pnlFieldsPO.add(lblItem, null);
  pnlFieldsPO.add(lblQty, null);
  pnlFieldsPO.add(lblDate1, null);
  pnlFieldsPO.add(lblON, null);
  pnlFieldsPO.add(txtQty, null);
  pnlFieldsPO.add(txtPrice, null);
  pnlFieldsPO.add(txtTotal, null);
  pnlFieldsPO.add(lblPrice, null);
  pnlPO.add(pnlButtonsPO, null);
  pnlPO.add(pnlFieldsPO, null);

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

  pnlReceive.add(pnlTab, null);
  pnlTab.add(sp, null);
  pnlReceive.add(pnlFieldsRE, null);
  sp.add(Table, null);

  this.getContentPane().add(TP, null);
  this.getContentPane().add(pnlSearch, null);
  this.getContentPane().add(lblHead, null);

  pnlFieldsRE.add(lblQtyRec, null);
  pnlFieldsRE.add(txtQtyRec, null);
  pnlFieldsRE.add(btnUQ, null);
  pnlFieldsRE.add(btnCloseRec, null);
  TP.add(pnlPO, "PURCHASE");
  TP.add(pnlReceive, "RECEIVE");

  pnlSearch.add(btnGo, null);
  pnlSearch.add(lblPicture, null);
  pnlSearch.add(txtSearch, null);
  pnlSearch.add(cboSearch, null);

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
   hwpocon.Connect();
  }catch(RemoteException re){ System.out.println("Client [frmHWPO]: Open Error");System.out.println("Error: "+re.getMessage());}

  //DISPLAY DATA RMI
  try
  {
   hwpo = hwpocon.moveNext();
   display();
  }catch(RemoteException re){ System.out.println("Client [frmHWPO]: Show Error");System.out.println("Error: "+re.getMessage());}

  SQL="SELECT * FROM HW_POGR WHERE Status<>'Ok' ORDER BY OID;";
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
  btnCloseRec.setEnabled(btnValue);
  btnUQ.setEnabled(btnValue);
  btnFirst.setEnabled(btnValue);
  btnPrevious.setEnabled(btnValue);
  btnNext.setEnabled(btnValue);
  btnLast.setEnabled(btnValue);
  btnSup.setEnabled(!btnValue);
  btnDT.setEnabled(!btnValue);
  btnDT1.setEnabled(!btnValue);
  btnDT2.setEnabled(!btnValue);
  btnRefresh.setEnabled(btnValue);
  btnGo.setEnabled(btnValue);
 }

 /**
 * Sets Fields States
 * @param boolean true or false
 *
 */

 public void setFields(boolean txtValue)
 {
  txtOID.setEnabled(txtValue);
  txtON.setEnabled(txtValue);
  txtItem.setEnabled(txtValue);
  txtDP.setEnabled(txtValue);
  txtQty.setEnabled(txtValue);
  txtPrice.setEnabled(txtValue);
  txtRemarks.setEnabled(txtValue);
 }

 /**
 * Clear Text From Fields
 *
 */

 public void clearFields()
 {
  txtOID.setText("");
  txtTID.setText("");
  txtDate.setText("");
  txtON.setText("");
  txtODate.setText("");
  txtSID.setText("");
  txtItem.setText("");
  txtLD.setText("");
  txtDP.setText("");
  txtQty.setText("");
  txtPrice.setText("");
  txtTotal.setText("");
  txtRemarks.setText("");
 }

 /**
 * Display Data
 *
 */

 public void display()
 {
  txtTID.setText(hwpo.getTransactionID());
  txtOID.setText(hwpo.getOID());
  txtDate.setText(hwpo.getDate());
  txtSID.setText(hwpo.getSID());
  txtItem.setText(hwpo.getItem());
  txtQty.setText(hwpo.getQtyOrd());
  txtQtyRec.setText(hwpo.getQtyRec());
  txtPrice.setText(hwpo.getPrice());
  txtTotal.setText(hwpo.getTotal());
  //txtEmpCode.setText(hwpo.getEmpCode());
  //hwpo.getStatus() is for Status of the ORDER
  txtON.setText(hwpo.getOfferNo());
  txtODate.setText(hwpo.getOffDated());
  txtLD.setText(hwpo.getLastDate());
  txtDP.setText(hwpo.getDeliveryAt());
  txtRemarks.setText(hwpo.getRemarks());

 }

 /**
 * Checks the Fields
 *
 * @return boolean true or false value
 */

 public boolean checkFields()
 {
  if (txtOID.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Order ID!","Missing Information",JOptionPane.ERROR_MESSAGE);txtOID.requestFocus();return false;}
  if (txtSID.getText().equals("")){JOptionPane.showMessageDialog(null,"Please select a Supplier!","Missing Information",JOptionPane.ERROR_MESSAGE);return false;}
  if (txtItem.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide an Item!","Missing Information",JOptionPane.ERROR_MESSAGE);txtItem.requestFocus();return false;}
  if (txtQty.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Quantity!","Missing Information",JOptionPane.ERROR_MESSAGE);txtQty.requestFocus();return false;}
  if (txtPrice.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Price!","Missing Information",JOptionPane.ERROR_MESSAGE);txtPrice.requestFocus();return false;}
  if (txtON.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Offer No!","Missing Information",JOptionPane.ERROR_MESSAGE);txtON.requestFocus();return false;}
  if (txtODate.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Offer Date!","Missing Information",JOptionPane.ERROR_MESSAGE);txtODate.requestFocus();return false;}
  if (txtLD.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Last Date of Delivery!","Missing Information",JOptionPane.ERROR_MESSAGE);txtLD.requestFocus();return false;}
  if (txtDP.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide place of delivery","Missing Information",JOptionPane.ERROR_MESSAGE);txtDP.requestFocus();return false;}
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
  hwpo.setTransactionID(txtTID.getText());
  hwpo.setOID(txtOID.getText());
  hwpo.setDate(txtDate.getText());
  hwpo.setSID(txtSID.getText());
  hwpo.setItem(txtItem.getText());
  hwpo.setQtyOrd(txtQty.getText());
  hwpo.setQtyRec("0");
  hwpo.setPrice(txtPrice.getText());
  hwpo.setTotal(txtTotal.getText());
  hwpo.setEmpCode(EmpCode);
  hwpo.setStatus("-");
  hwpo.setOfferNo(txtON.getText());
  hwpo.setOffDated(txtODate.getText());
  hwpo.setLastDate(txtLD.getText());
  hwpo.setDeliveryAt(txtDP.getText());
  hwpo.setRemarks(txtRemarks.getText());

  try
  {
   savesucc = hwpocon.insertData(hwpo);
   //JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
   //getConnected();

  }catch(RemoteException re)
  {
   System.out.println("Client [frmHWPO]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmHWPO]: "+re.getMessage(),
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
  hwpo.setTransactionID(txtTID.getText());
  hwpo.setOID(txtOID.getText());
  hwpo.setDate(txtDate.getText());
  hwpo.setSID(txtSID.getText());
  hwpo.setItem(txtItem.getText());
  hwpo.setQtyOrd(txtQty.getText());
  hwpo.setQtyRec("0");
  hwpo.setPrice(txtPrice.getText());
  hwpo.setTotal(txtTotal.getText());
  hwpo.setEmpCode(EmpCode);
  hwpo.setStatus("-");
  hwpo.setOfferNo(txtON.getText());
  hwpo.setOffDated(txtODate.getText());
  hwpo.setLastDate(txtLD.getText());
  hwpo.setDeliveryAt(txtDP.getText());
  hwpo.setRemarks(txtRemarks.getText());

  try
  {
   updatesucc = hwpocon.updateData(hwpo);
   StartWorking("UPDATING RECORD");
   UpdatePaymentDetails();
   JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
   getConnected();

  }catch(RemoteException re)
  {
   System.out.println("Client [frmHWPO]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmHWPO]: "+re.getMessage(),
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
  String strQuery = "DELETE FROM HW_POGR WHERE TransactionID='" + txtTID.getText() + "';";

  int yn;
  yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
  JOptionPane.YES_NO_OPTION, 3, imgQ);

  if (yn == JOptionPane.YES_OPTION)
  {
   try
   {
    hwpocon.DeleteData(strQuery);
    StartWorking("DELETING RECORD");
    DeletePaymentDetails();
    JOptionPane.showMessageDialog(null, "Server: Record Deleted!", "Information", 1);
    clearFields();
    getConnected();

   }catch(RemoteException re)
   {
    System.out.println("Client [frmHWPO]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmHWPO]: "+re.getMessage(),
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
   System.out.println("Client [frmHWPO]: GET TABLE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmHWPO]: "+re.getMessage(),
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

     System.out.println("SELECTED ROW: "+SelRow[0][0]+" * "+SelRow[0][1]+" * "+SelRow[0][2]+" * "+SelRow[0][3]+" * "+SelRow[0][4]+" * "+SelRow[0][5]);
     txtTID.setText(SelRow[0][0]);txtOID.setText(SelRow[0][1]);txtDate.setText(SelRow[0][2]);txtSID.setText(SelRow[0][3]);txtItem.setText(SelRow[0][4]);txtQty.setText(SelRow[0][5]);txtPrice.setText(SelRow[0][7]);txtTotal.setText(SelRow[0][8]);txtON.setText(SelRow[0][11]);txtODate.setText(SelRow[0][12]);txtLD.setText(SelRow[0][13]);txtDP.setText(SelRow[0][14]);txtRemarks.setText(SelRow[0][15]);
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
  int[] sz = new int[16];
  sz[0]=100;sz[1]=100;sz[2]=60;sz[3]=100;sz[4]=120;sz[5]=70;sz[6]=70;sz[7]=70;
  sz[8]=70;sz[9]=50;sz[10]=70;sz[11]=120;sz[12]=60;sz[13]=60;sz[14]=120;sz[15]=200;
  for (int j = 0; j < TotalCol; ++j)
  {
   column = Table.getColumnModel().getColumn(j);
   column.setPreferredWidth(sz[j]);
  }
 }

 /**
 * Generated New Order ID
 *
 */

 private void GenerateTransactionID()
 {
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
  txtTID.setText("T"+TranID);
  System.out.println("Transaction ID: " + txtTID.getText());
 }

 void btnSup_actionPerformed(ActionEvent e)
 {
  frmList lst = new frmList("SUPPLIER INFORMATION", "SELECT * FROM Suppliers ORDER BY SID;");
  lst.setVisible(true);

  String t[][] = lst.getType();
  if(t!=null)
  {
   txtSID.setText(t[0][0]);
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
   txtOID.setText("O"+TranID);
   System.out.println("ORDER ID: " + txtOID.getText());
  }
  txtON.requestFocus();
 }

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
   if(cboSearch.getSelectedItem().equals("QtyOrd") || cboSearch.getSelectedItem().equals("QtyRec")){SQLString = "SELECT * FROM HW_POGR WHERE " + cboSearch.getSelectedItem().toString() + "=" + txtSearch.getText() + ";";}
   else{SQLString = "SELECT * FROM HW_POGR WHERE " + cboSearch.getSelectedItem().toString() + "='" + txtSearch.getText() + "';";}

   try
   {
    if (hwpocon.isFound(SQLString))
    {
     hwpo = hwpocon.SearchData(SQLString);
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
   {System.out.println("Client [frmHWPO]: SEARCH DATA Error");System.out.println("Error: "+re.getMessage());}

  }
 }

 void btnUQ_actionPerformed(ActionEvent e)
 {
  int x[] = Table.getSelectedRows();
  int yn;

  if (x.length >= 1)
  {
   Type = new String[x.length][TotalCol];

   for (int i = 0; i < x.length; i++)
   {
    for (int j = 0; j < TotalCol; j++)
    {
     Type[i][j] = Table.getValueAt(x[i], j).toString();
     System.out.println(Table.getValueAt(x[i], j).toString());
    }
   }

   TranID = (Type[0][0]);
   QtyOrd = (Type[0][5]);
   ExiQty = (Type[0][6]);

   try
   {
    qo = Integer.parseInt(QtyOrd);
    qr = Integer.parseInt(txtQtyRec.getText());
    eq = Integer.parseInt(ExiQty);
    tq = eq + qr;
    if (tq > qo)
    {
     JOptionPane.showMessageDialog(null, "Receive Quantity is more then Ordered Quantity!", "Error", JOptionPane.ERROR_MESSAGE);
     return;
    }
   }catch(java.lang.NumberFormatException ex){}

   yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to UPDATE Quantity for Transaction: "+TranID+"?", "Conformation...", JOptionPane.YES_NO_OPTION, 3, imgQ);

   //If Quantity Ordered and Quantity Received are same then Clear the Order...
   if(tq==qo)
   {
    SQL1 = "UPDATE HW_POGR SET QtyRec="+tq+", Status='Ok' WHERE TransactionID='"+TranID+"';";
   }
   else
   {
    SQL1 = "UPDATE HW_POGR SET QtyRec="+tq+" WHERE TransactionID='"+TranID+"';";
   }

   if (yn == JOptionPane.YES_OPTION)
   {
    //Updating Quantity Received
    try
    {
     ctccon.ExecuteQuery(SQL1);
     StartWorking("UPDATING QUANTITY");
     System.out.println("\nRecord Updated...\n");
     JOptionPane.showMessageDialog(null, "Record Updated...", "Information", 1);
     getConnected();


    }catch(RemoteException re)
    {
     System.out.println("Client [frmHWPO]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
     JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmHWPO]: "+re.getMessage(),
              "Error", JOptionPane.ERROR_MESSAGE);
    }
   }
  }
  else if (x.length < 1)
  {
   JOptionPane.showMessageDialog(null, "Please select an order first!","Information Required...",JOptionPane.ERROR_MESSAGE);
  }
 }

 void btnDT_actionPerformed(ActionEvent e)
 {
  frmDate fd = new frmDate("Select Last Delivery Date");
  fd.setSize(new Dimension(212, 163));
  fd.setVisible(true);
  String SDate = fd.createDate();
  txtLD.setText(SDate);
 }

 void btnDT1_actionPerformed(ActionEvent e)
 {
  frmDate fd = new frmDate("Select Date");
  fd.setSize(new Dimension(212, 163));
  fd.setVisible(true);
  String SDate = fd.createDate();
  txtDate.setText(SDate);
 }

 void btnDT2_actionPerformed(ActionEvent e)
 {
  frmDate fd = new frmDate("Select Date");
  fd.setSize(new Dimension(212, 163));
  fd.setVisible(true);
  String SDate = fd.createDate();
  txtODate.setText(SDate);
 }

 /**
 * Calculates Total
 *
 */

 private void Calculate()
 {
  double price = 0;
  int Qty=0;
  DecimalFormat df = new DecimalFormat();
  df.applyPattern("########.##"); //If required then shows

  try
  {
   price = Double.parseDouble(txtPrice.getText());
   Qty = Integer.parseInt(txtQty.getText());
  }catch(Exception ex){}
  double total = price * Qty;
  //lblTotal.setText(String.valueOf(total));
  txtTotal.setText(df.format(total));
 }

 /**
 * Adds Payment Details to The Supplier Table
 *
 */

 private void AddPaymentDetails()
 {
  double mAmount = 0;
  String z = new String();

  PSQL = "SELECT SUM(Total) FROM HW_POGR WHERE OID='"+txtOID.getText()+"'";

  z = ExecuteCommand(PSQL);

  try
  {
   mAmount = Double.parseDouble(z);
  }catch(Exception ex){}

  String tmp = null;
  d = new Date();
  CurrentDate = null;
  sdf = new SimpleDateFormat("y");
  tmp = "P"+ sdf.format(d);
  sdf = new SimpleDateFormat("M");
  tmp = tmp + sdf.format(d);
  sdf = new SimpleDateFormat("d");
  tmp = tmp + sdf.format(d);
  tmp = tmp + EmpCode;
  sdf = new SimpleDateFormat("Hms");
  tmp = tmp + sdf.format(d);
  d = new Date();
  sdf = new SimpleDateFormat("yyyy-MM-dd");
  CurrentDate = sdf.format(d);

  PSQL = "INSERT INTO Payments VALUES ('"+tmp+"','"+CurrentDate+"','"+txtOID.getText()+"','"+txtSID.getText()+"',"+mAmount+",'-','"+CurrentDate+"','-','-','-');";

  ExecuteUpdate(PSQL);
 }

 /**
 * Updates Supplier Payment Details
 *
 */

 private void UpdatePaymentDetails()
 {
  double mAmount = 0;
  int rCount = 0;
  String z = new String();

  if (tOID.equals(txtOID.getText()))
  {
   //If OrderID not changed only the Amount Changed...
   PSQL = "SELECT SUM(Total) FROM HW_POGR WHERE OID='" + txtOID.getText() + "'";
   z = ExecuteCommand(PSQL);

   try
   {mAmount = Double.parseDouble(z);}
   catch (Exception ex) {}

   PSQL = "UPDATE Payments SET Amount=" + mAmount + " WHERE OID='" + txtOID.getText() + "';";
   ExecuteUpdate(PSQL);
   //---------------------------------------------------------------
  }
  else //If Order ID Changed...
  {
   //Case 1
   PSQL = "SELECT Count(*) AS 'Total' FROM HW_POGR WHERE OID='"+tOID+"';";
   z = ExecuteCommand(PSQL);

   rCount = Integer.parseInt(z);

   System.out.println("tOID Count: "+rCount);

   if(rCount==0)
   {
    PSQL = "DELETE FROM Payments WHERE OID='" + tOID + "';";
    ExecuteUpdate(PSQL);
   }
   else
   {
    //-----------------------------------------------------------------
    PSQL = "SELECT SUM(Total) FROM HW_POGR WHERE OID='" + tOID + "'";
    z = ExecuteCommand(PSQL);

    try
    {mAmount = Double.parseDouble(z);}
    catch (Exception ex) {}

    PSQL = "UPDATE Payments SET Amount=" + mAmount + " WHERE OID='" + tOID + "';";
    ExecuteUpdate(PSQL);

    //-----------------------------------------------------------------
    PSQL = "SELECT SUM(Total) FROM HW_POGR WHERE OID='" + txtOID.getText() + "'";
    z = ExecuteCommand(PSQL);

    try
    {mAmount = Double.parseDouble(z);}
    catch (Exception ex) {}

    PSQL = "UPDATE Payments SET Amount=" + mAmount + " WHERE OID='" + txtOID.getText() + "';";
    ExecuteUpdate(PSQL);
    //-----------------------------------------------------------------
   }

  }//If Order ID Changed...
 }

 /**
 * Deletes Supplier Payment Details
 *
 */

 private void DeletePaymentDetails()
 {
  System.out.println("Deleting "+txtOID.getText());
  double mAmount = 0;
  int rCount = 0;
  String z = new String();

  PSQL = "SELECT Count(*) AS 'Total' FROM HW_POGR WHERE OID='"+txtOID.getText()+"';";
  z = ExecuteCommand(PSQL);

  rCount = Integer.parseInt(z);
  System.out.println("tOID Count: "+rCount);

  if(rCount==0)
  {
   PSQL = "DELETE FROM Payments WHERE OID='" + txtOID.getText() + "';";
   ExecuteUpdate(PSQL);
  }

  else
  {
   PSQL = "SELECT SUM(Total) FROM HW_POGR WHERE OID='" + txtOID.getText() + "'";
   z = ExecuteCommand(PSQL);

   try
   {mAmount = Double.parseDouble(z);}
   catch (Exception ex) {}

   PSQL = "UPDATE Payments SET Amount=" + mAmount + " WHERE OID='" + txtOID.getText() + "';";
   ExecuteUpdate(PSQL);
  }
 }

 /**
 * Executes SQL Command [Query]
 * @param String Query
 * @return String Class Object
 */

 private String ExecuteCommand(String Query)
 {
  ExecResult = new String();
  PSQL = Query;
  String z = new String();

  try
  {
   if (hwpocon.isFound(PSQL))
   {
    z = ctccon.getDataItem(PSQL);
    System.out.println("Data Item **"+ z +"**");

    if((!z.equals("")) || (z!=null))
    {
     ExecResult = z;
     return ExecResult;
    }
    else{System.out.println("Client [frmHWPO]: Data Item is Null or Not Found!");}
   }
   else {System.out.println("Client [frmHWPO]: No Record Found");}

  }catch(RemoteException re)
  {System.out.println("Client [frmHWPO]: EXECUTE COMMAND Error");System.out.println("Error: "+re.getMessage());}

  return ExecResult;
 }

 /**
 * Executes SQL Command [Update]
 * @param String Query
 *
 */

 private void ExecuteUpdate(String Query)
 {
  PSQL = Query;

  try
  {
   ctccon.ExecuteQuery(PSQL);

  }catch(RemoteException re)
  {System.out.println("Client [frmHWPO]: EXECUTE UPDATE Error");System.out.println("Error: "+re.getMessage());}
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