//package beximtex;
/**
 * <p>Title: BeximTex, Mobile Bill</p>
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
import java.math.*;

import java.rmi.*;

public class frmMBill extends JInternalFrame
{//Class

 JTabbedPane TP = new JTabbedPane();
 JPanel pnlAB = new JPanel();
 JPanel pnlView = new JPanel();
 TitledBorder titledBorder1;
 TitledBorder titledBorder2;
 TitledBorder titledBorder3;
 JPanel pnlFields = new JPanel();
 TitledBorder titledBorder4;
 TitledBorder titledBorder5;
 JTextField txtEC = new JTextField();
 JTextField txtDate = new JTextField();
 JLabel lblEC = new JLabel();
 JLabel lblMobile = new JLabel();
 JLabel lblDate = new JLabel();
 JTextField txtName = new JTextField();
 JLabel lblName = new JLabel();
 JTextField txtAmt = new JTextField();
 JLabel lblAmt = new JLabel();
 JTextField txtRemarks = new JTextField();
 JLabel lblRem = new JLabel();
 JPanel pnlButtons = new JPanel();
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
 MBbillController mbbcon;
 MBbill mbb = new MBbill();

 CommonTableController ctccon;
 //**************************************************************

 ImageIcon imgFirst = new ImageIcon("./Images/iconFirst.gif");
 ImageIcon imgFO = new ImageIcon("./Images/iconFirstOver.gif");
 ImageIcon imgLast = new ImageIcon("./Images/iconLast.gif");
 ImageIcon imgLO = new ImageIcon("./Images/iconLastOver.gif");
 ImageIcon imgNext = new ImageIcon("./Images/iconNext.gif");
 ImageIcon imgHead = new ImageIcon("./Images/touch.gif");
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

 int yn;
 boolean isAdd = false;

 String Type[][];
 String SelRow[][];

 String EmpCode = null;
 String TableName = null;

 String CurrentDate = null;
 String TranID = null;
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 DecimalFormat df = new DecimalFormat();
 Date d;

 String SQL = null;
 String AppMBTK = null;
 Vector ColHead = new Vector();
 Vector rows = new Vector();

 int TotalCol = 0;
 int Rows = 0;
 int Columns = 0;

 JTextField txtATK = new JTextField();
 JLabel lblATK = new JLabel();
 JTextField txtMobile = new JTextField();
 JTextField txtBalance = new JTextField();
 JLabel lblBalance = new JLabel();
 JTextField txtTID = new JTextField();
 JLabel lblTID = new JLabel();
 JComboBox cboYear = new JComboBox();
 JComboBox cboMonth = new JComboBox();
 JLabel lblYM = new JLabel();
 JComboBox cboCP = new JComboBox();
 JLabel lblMobile1 = new JLabel();
 JToggleButton btnEmp = new JToggleButton();
 JToggleButton btnDT1 = new JToggleButton();
 JComboBox cboVAT = new JComboBox();
 JLabel lblHead = new JLabel();

 public frmMBill(String ec)
 {//Cons
  EmpCode = ec;
  try {jbInit(); }
  catch(Exception e){System.exit(0);}
 }//Cons

 private void jbInit() throws Exception
 {//jbInit

  //**************************************************************
     //getConnectedion: getConnecteds with Server
  try
  {
   mbbcon = (MBbillController)Naming.lookup(new ReadHost().getHost() + "MBbillController");
   ctccon = (CommonTableController)Naming.lookup(new ReadHost().getHost() + "CommonTableController");

  }catch(Exception ec)
  {
   System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
   System.out.println("Error: "+ec.getMessage());
   JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
   "Error", JOptionPane.ERROR_MESSAGE);
   System.exit(0);
  }
  System.out.println("\n******************************\n CLIENT READY [frmMBsStock] \n******************************\n");
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

  this.setTitle("MOBILE BILLING");
  this.getContentPane().setLayout(null);
  this.setForeground(Color.white);
  this.setFrameIcon(imgIco);
  this.getContentPane().setBackground(Color.white);
  this.setClosable(true);
  this.setIconifiable(true);
  this.setMaximizable(false);
  this.setSize(new Dimension(596, 472));

  TP.setBackground(Color.lightGray);
  TP.setFont(new java.awt.Font("Monospaced", 1, 12));
  TP.setForeground(Color.white);
  TP.setBounds(new Rectangle(7, 42, 572, 285));

  pnlAB.setBackground(Color.white);
  pnlAB.setForeground(Color.white);
  pnlAB.setBorder(titledBorder2);
  pnlAB.setLayout(null);
  pnlView.setBackground(Color.white);
  pnlView.setBorder(titledBorder3);
  pnlView.setLayout(null);
  pnlFields.setBackground(Color.white);
  pnlFields.setBorder(titledBorder5);
  pnlFields.setBounds(new Rectangle(8, 9, 550, 160));
  pnlFields.setLayout(null);
  txtEC.setText("");
  txtEC.setBounds(new Rectangle(108, 9, 79, 23));
  txtEC.setEnabled(false);
  txtEC.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtDate.setBounds(new Rectangle(251, 9, 77, 23));
  txtDate.setEnabled(false);
  txtDate.setFont(new java.awt.Font("Tahoma", 1, 11));

  lblEC.setText("Employee Code");
  lblEC.setBounds(new Rectangle(10, 8, 102, 24));
  lblEC.setFont(new java.awt.Font("Tahoma", 1, 11));

  lblMobile.setBounds(new Rectangle(323, 37, 68, 24));
  lblMobile.setText("MOBILE NO.");
  lblMobile.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblMobile.setHorizontalAlignment(SwingConstants.RIGHT);

  lblDate.setBounds(new Rectangle(204, 8, 41, 24));
  lblDate.setText("DATE");
  lblDate.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblDate.setHorizontalAlignment(SwingConstants.RIGHT);

  txtName.setText("");
  txtName.setBounds(new Rectangle(108, 38, 140, 23));
  txtName.setEnabled(false);
  txtName.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtName.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtName.selectAll();}
   public void focusLost(FocusEvent f) {}
  });

  lblName.setText("NAME");
  lblName.setBounds(new Rectangle(10, 37, 106, 24));
  lblName.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblName.setToolTipText("");

  txtAmt.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtAmt.setBounds(new Rectangle(399, 67, 140, 23));
  txtAmt.setText("");
  txtAmt.setHorizontalAlignment(SwingConstants.RIGHT);
  txtAmt.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtAmt.selectAll();}
   public void focusLost(FocusEvent f) {}
  });

  txtAmt.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtAmt.getText().length()>=7){ke1.consume();}
    if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8) || (ke1.getKeyChar()==46)) {}
    else ke1.consume();
   }
   public void keyReleased(KeyEvent ke)
   { Calculate(); }
  });

  txtAmt.setEnabled(true);
  lblAmt.setToolTipText("");
  lblAmt.setHorizontalAlignment(SwingConstants.RIGHT);
  lblAmt.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblAmt.setBounds(new Rectangle(285, 66, 106, 24));
  lblAmt.setText("AMOUNT");
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
  pnlButtons.setBackground(Color.white);
  pnlButtons.setBorder(titledBorder7);
  pnlButtons.setMaximumSize(new Dimension(32767, 32767));
  pnlButtons.setBounds(new Rectangle(8, 175, 550, 74));
  pnlButtons.setLayout(null);
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
      if(CheckData()==false)
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
       JOptionPane.showMessageDialog(null, "Record already Exists!",
                "Error", JOptionPane.ERROR_MESSAGE);
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
    setButton(false);
    setFields(true);
    btnDT1.setEnabled(false);
    txtName.requestFocus();
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
    d = new Date();
    CurrentDate = null;
    sdf = new SimpleDateFormat("y");
    TranID = sdf.format(d);
    sdf = new SimpleDateFormat("yyyy");
    cboYear.setSelectedItem(sdf.format(d));
    sdf = new SimpleDateFormat("M");
    TranID = TranID + sdf.format(d);
    cboMonth.setSelectedItem(sdf.format(d));
    sdf = new SimpleDateFormat("d");
    TranID = TranID + sdf.format(d);
    sdf = new SimpleDateFormat("Hms");
    TranID = TranID + sdf.format(d);
    txtTID.setText("T"+TranID);
    cboCP.requestFocus();
    cboCP.setSelectedItem("GrameenPhone");
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
     mbb=mbbcon.moveLast();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmMBbill]: MOVE LAST Error");System.out.println("Error: "+re.getMessage());}
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
     mbb=mbbcon.movePrevious();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmMBbill]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
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
     mbb=mbbcon.moveNext();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmMBbill]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
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
     mbb=mbbcon.moveFirst();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmMBbill]: MOVE FIRST Error");System.out.println("Error: "+re.getMessage());}
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
  txtSearch.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtSearch.selectAll();}
   public void focusLost(FocusEvent f) {}
  });

  txtATK.setEnabled(false);
  txtATK.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtATK.setHorizontalAlignment(SwingConstants.RIGHT);
  txtATK.setBounds(new Rectangle(108, 96, 69, 23));
  txtATK.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtATK.getText().length()>=7){ke1.consume();}
    if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8) || (ke1.getKeyChar()==46)) {}
    else ke1.consume();
   }
   public void keyReleased(KeyEvent ke) {}
  });
  txtATK.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtATK.selectAll();}
   public void focusLost(FocusEvent f) {}
  });
  lblATK.setText("APPROVE TAKA");
  lblATK.setBounds(new Rectangle(10, 95, 106, 24));
  lblATK.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblATK.setHorizontalAlignment(SwingConstants.LEFT);
  txtMobile.setBounds(new Rectangle(399, 38, 140, 23));
  txtMobile.setText("");
  txtMobile.setEnabled(false);
  txtMobile.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtMobile.setDoubleBuffered(false);
  txtMobile.setEditable(true);
  txtMobile.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   { txtMobile.selectAll(); }

   public void focusLost(FocusEvent f) {}
  });
  txtMobile.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtMobile.getText().length()>=12){ke1.consume();}
    if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8)) {}
    else ke1.consume();
   }
   public void keyReleased(KeyEvent ke)
   { Calculate(); }
  });

  txtBalance.setBounds(new Rectangle(399, 96, 140, 23));
  txtBalance.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtBalance.setHorizontalAlignment(SwingConstants.RIGHT);
  txtBalance.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtBalance.getText().length()>=7){ke1.consume();}
    if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8) || (ke1.getKeyChar()==46)) {}
    else ke1.consume();
   }
   public void keyReleased(KeyEvent ke) {}
  });
  txtBalance.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtBalance.selectAll();}
   public void focusLost(FocusEvent f) {}
  });
  lblBalance.setText("BALANCE");
  lblBalance.setBounds(new Rectangle(285, 95, 106, 24));
  lblBalance.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblBalance.setHorizontalAlignment(SwingConstants.RIGHT);
  lblBalance.setToolTipText("");
  txtTID.setBounds(new Rectangle(108, 124, 140, 23));
  txtTID.setEnabled(false);
  txtTID.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtTID.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtTID.selectAll();}
   public void focusLost(FocusEvent f) {}
  });
  lblTID.setText("Transaction ID");
  lblTID.setBounds(new Rectangle(10, 123, 106, 24));
  lblTID.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblTID.setToolTipText("");
  cboYear.setBounds(new Rectangle(108, 66, 69, 24));
  cboYear.setMaximumRowCount(10);
  cboYear.setBackground(Color.white);
  cboYear.setFont(new java.awt.Font("Tahoma", 1, 12));
  cboMonth.setBounds(new Rectangle(179, 66, 69, 24));
  cboMonth.setFont(new java.awt.Font("Tahoma", 1, 12));
  cboMonth.setMaximumRowCount(10);
  cboMonth.setBackground(Color.white);
  lblYM.setToolTipText("");
  lblYM.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblYM.setBounds(new Rectangle(10, 66, 106, 24));
  lblYM.setText("YEAR & MONTH");
  cboCP.setFont(new java.awt.Font("Tahoma", 1, 12));
  cboCP.setToolTipText("Connection Provider");
  cboCP.setBackground(Color.white);
  cboCP.setEnabled(false);
  cboCP.setBounds(new Rectangle(399, 8, 140, 24));
  lblMobile1.setHorizontalAlignment(SwingConstants.RIGHT);
  lblMobile1.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblMobile1.setText("CONN.");
  lblMobile1.setBounds(new Rectangle(342, 8, 49, 24));
  btnEmp.setToolTipText("Show Employee List");
  btnEmp.setText("");
  btnEmp.setIcon(imgTab);
  btnEmp.setBounds(new Rectangle(190, 9, 22, 23));
  btnEmp.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnEmp_actionPerformed(e); }
  });
  btnDT1.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnDT1_actionPerformed(e); }
  });
  btnDT1.setBounds(new Rectangle(331, 9, 22, 23));
  btnDT1.setIcon(imgTab);
  btnDT1.setText("");
  btnDT1.setToolTipText("DATE SELECTOR");
  cboVAT.setMaximumRowCount(10);
  cboVAT.setBackground(Color.white);
  cboVAT.setFont(new java.awt.Font("Tahoma", 1, 12));
  cboVAT.setToolTipText("15% VAT Included or NOT");
  cboVAT.setBounds(new Rectangle(179, 95, 69, 24));
  cboVAT.addItemListener(new ItemListener()
  {
   public void itemStateChanged(ItemEvent e)
   { Calculate(); }
  });

  lblHead.setBounds(new Rectangle(0, 0, 534, 60));
  lblHead.setIcon(imgHead);
  pnlFields.add(lblMobile, null);
  pnlFields.add(lblEC, null);
  pnlFields.add(lblName, null);
  pnlFields.add(txtAmt, null);
  pnlFields.add(lblAmt, null);
  pnlFields.add(lblRem, null);
  pnlFields.add(txtRemarks, null);
  pnlFields.add(lblATK, null);
  pnlFields.add(txtMobile, null);
  pnlFields.add(txtBalance, null);
  pnlFields.add(lblBalance, null);
  pnlFields.add(lblTID, null);
  pnlFields.add(lblYM, null);
  pnlFields.add(lblMobile1, null);
  pnlFields.add(cboCP, null);
  pnlFields.add(txtTID, null);
  pnlFields.add(txtEC, null);
  pnlFields.add(txtName, null);
  pnlFields.add(cboYear, null);
  pnlFields.add(cboMonth, null);
  pnlFields.add(txtATK, null);
  pnlFields.add(btnEmp, null);
  pnlFields.add(btnDT1, null);
  pnlFields.add(lblDate, null);
  pnlFields.add(txtDate, null);
  pnlFields.add(cboVAT, null);

  TP.add(pnlView, "VIEW DATA");
  pnlView.add(pnlTab, null);
  pnlTab.add(sp, null);
  TP.add(pnlAB, "ADD BILLS");
  sp.add(Table, null);

  pnlButtons.add(btnEdit, null);
  pnlButtons.add(btnNew, null);
  pnlButtons.add(btnRefresh, null);
  pnlButtons.add(btnSave, null);
  pnlButtons.add(btnDelete, null);
  pnlButtons.add(lblRec, null);
  pnlButtons.add(btnClose, null);
  pnlButtons.add(btnCancel, null);
  pnlButtons.add(btnPrevious, null);
  pnlButtons.add(btnLast, null);
  pnlButtons.add(btnNext, null);
  pnlButtons.add(btnFirst, null);
  pnlAB.add(pnlFields, null);
  pnlAB.add(pnlButtons, null);

  this.getContentPane().add(TP, null);
  pnlSearch.add(btnGo, null);
  pnlSearch.add(lblPicture, null);
  pnlSearch.add(txtSearch, null);
  pnlSearch.add(cboSearch, null);

  this.getContentPane().add(pnlSearch, null);
  this.getContentPane().add(TP, null);
  this.getContentPane().add(lblHead, null);

  addComboItems();
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
   mbbcon.Connect();
  }catch(RemoteException re){ System.out.println("Client [frmMBbill]: Open Error");System.out.println("Error: "+re.getMessage());}

  //DISPLAY DATA RMI
  try
  {
   mbb = mbbcon.moveNext();
   display();
  }catch(RemoteException re){ System.out.println("Client [frmMBbill]: Show Error");System.out.println("Error: "+re.getMessage());}

  SQL="SELECT * FROM MB_Bill ORDER BY Name,Year,Month;";
  getTableData(SQL);
 }

 /**
 * Sets Button States
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
  btnEmp.setEnabled(!btnValue);
 }

 /**
 * Sets Fields States
 *
 */

 public void setFields(boolean txtValue)
 {
  txtAmt.setEnabled(txtValue);
  txtBalance.setEnabled(txtValue);
  txtRemarks.setEnabled(txtValue);
  cboYear.setEnabled(txtValue);
  cboMonth.setEnabled(txtValue);
  cboVAT.setEnabled(txtValue);
  cboSearch.setEnabled(!txtValue);
  txtSearch.setEnabled(!txtValue);
 }

 /**
 * Clear Text From Fields
 *
 */

 public void clearFields()
 {
  txtEC.setText("");
  txtDate.setText("");
  txtName.setText("");
  txtMobile.setText("");
  txtAmt.setText("");
  txtATK.setText("");
  txtBalance.setText("");
  txtTID.setText("");
  txtRemarks.setText("");
 }

 /**
 * Display Data
 *
 */

 public void display()
 {
  txtTID.setText(mbb.getTransactionID());
  txtEC.setText(mbb.getEC());
  txtDate.setText(mbb.getDate());
  cboCP.setSelectedItem(mbb.getCP());
  txtName.setText(mbb.getName());
  txtMobile.setText(mbb.getMobileNo());
  cboYear.setSelectedItem(mbb.getYear());
  cboMonth.setSelectedItem(mbb.getMonth());
  txtAmt.setText(mbb.getAmount());
  txtATK.setText(mbb.getApproved());
  txtBalance.setText(mbb.getBalance());
  //EmpCode
  txtRemarks.setText(mbb.getRemarks());
 }

 /**
 * Checks the Fields
 *
 * @return boolean true or false value
 */

 public boolean checkFields()
 {
  if (txtEC.getText().equals("")){JOptionPane.showMessageDialog(null,"Please select an Employee!","Missing Information",JOptionPane.ERROR_MESSAGE);return false;}
  if (txtMobile.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide provide a Mobile No.!","Missing Information",JOptionPane.ERROR_MESSAGE);txtMobile.requestFocus();return false;}
  if (txtName.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide a Name!","Missing Information",JOptionPane.ERROR_MESSAGE);txtName.requestFocus();return false;}
  if (txtAmt.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Amount!","Missing Information",JOptionPane.ERROR_MESSAGE);txtAmt.requestFocus();return false;}
  if (txtATK.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Approved Taka!","Missing Information",JOptionPane.ERROR_MESSAGE);txtATK.requestFocus();return false;}
  if (txtBalance.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Balance!","Missing Information",JOptionPane.ERROR_MESSAGE);txtBalance.requestFocus();return false;}
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
  mbb.setTransactionID(txtTID.getText());
  mbb.setEC(txtEC.getText());
  mbb.setDate(txtDate.getText());
  mbb.setCP(cboCP.getSelectedItem()+"");
  mbb.setName(txtName.getText());
  mbb.setMobileNo(txtMobile.getText());
  mbb.setYear(cboYear.getSelectedItem()+"");
  mbb.setMonth(cboMonth.getSelectedItem()+"");
  mbb.setAmount(txtAmt.getText());
  mbb.setBalance(txtBalance.getText());
  mbb.setEmpCode(EmpCode);
  mbb.setRemarks(txtRemarks.getText());

  try
  {
   savesucc = mbbcon.insertData(mbb);
   StartWorking("ADDING NEW RECORD");
   JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
   getConnected();

  }catch(RemoteException re)
  {
   System.out.println("Client [frmMBbill]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmMBbill]: "+re.getMessage(),
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
  mbb.setTransactionID(txtTID.getText());
  mbb.setEC(txtEC.getText());
  mbb.setDate(txtDate.getText());
  mbb.setCP(cboCP.getSelectedItem()+"");
  mbb.setName(txtName.getText());
  mbb.setMobileNo(txtMobile.getText());
  mbb.setYear(cboYear.getSelectedItem()+"");
  mbb.setMonth(cboMonth.getSelectedItem()+"");
  mbb.setAmount(txtAmt.getText());
  mbb.setBalance(txtBalance.getText());
  mbb.setEmpCode(EmpCode);
  mbb.setRemarks(txtRemarks.getText());

  try
  {
   updatesucc = mbbcon.updateData(mbb);
   StartWorking("UPDATING RECORD");
   JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
   getConnected();

  }catch(RemoteException re)
  {
   System.out.println("Client [frmMBbill]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmMBbill]: "+re.getMessage(),
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
  String strQuery = "DELETE FROM MB_Bill WHERE TransactionID='" + txtTID.getText() + "';";

  int yn;
  yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
  JOptionPane.YES_NO_OPTION, 3, imgQ);

  if (yn == JOptionPane.YES_OPTION)
  {
   try
   {
    mbbcon.DeleteData(strQuery);
    StartWorking("DELETING RECORD");
    JOptionPane.showMessageDialog(null, "Server: Record Deleted!", "Information", 1);
    clearFields();
    getConnected();

   }catch(RemoteException re)
   {
    System.out.println("Client [frmMBbill]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmMBbill]: "+re.getMessage(),
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
   System.out.println("Client [frmMBbill]: GET TABLE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmMBbill]: "+re.getMessage(),
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
     txtTID.setText(SelRow[0][0]);txtEC.setText(SelRow[0][1]);txtDate.setText(SelRow[0][2]);cboCP.setSelectedItem(SelRow[0][3]);txtName.setText(SelRow[0][4]);txtMobile.setText(SelRow[0][5]);cboYear.setSelectedItem(SelRow[0][6]);cboMonth.setSelectedItem(SelRow[0][7]);txtAmt.setText(SelRow[0][8]);txtATK.setText(SelRow[0][9]);txtBalance.setText(SelRow[0][10]);txtRemarks.setText(SelRow[0][12]);
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
  int[] sz = new int[13];
  sz[0]=100;sz[1]=50;sz[2]=60;sz[3]=90;sz[4]=120;sz[5]=70;sz[6]=50;sz[7]=50;
  sz[8]=50;sz[9]=50;sz[10]=50;sz[11]=50;sz[12]=200;
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
   JOptionPane.showMessageDialog(null, "Search What ?",
   "Information Required...",
   JOptionPane.INFORMATION_MESSAGE, imgExc);
   txtSearch.requestFocus();
  }
  else
  {
   SQLString = "SELECT * FROM MB_Bill WHERE " + cboSearch.getSelectedItem().toString() + "='" + txtSearch.getText() + "';";

   try
   {
    if (mbbcon.isFound(SQLString))
    {
     mbb = mbbcon.SearchData(SQLString);
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
   {System.out.println("Client [frmMBbill]: SEARCH DATA Error");System.out.println("Error: "+re.getMessage());}
  }
 }

 /**
 * Adding Combo Items
 *
 */

 private void addComboItems()
 {
  DecimalFormat df = new DecimalFormat();
  df.applyPattern("00");
  for (int i=1990;i<=2020;i++)
  {
   cboYear.addItem(String.valueOf(i));
  }
  for (int i=1;i<=12;i++)
  {
   cboMonth.addItem(String.valueOf(df.format(i)));
  }
  cboCP.addItem("GrameenPhone");
  cboCP.addItem("CityCell");

  cboSearch.addItem("EC");
  cboSearch.addItem("MobileNo");
  cboSearch.addItem("Year");
  cboSearch.addItem("Month");

  cboVAT.addItem("15% VAT");
  cboVAT.addItem("NO VAT");
 }

 void btnEmp_actionPerformed(ActionEvent e)
 {
  frmList lst = new frmList("EMPLOYEE INFORMATION",
  "SELECT Employees.EmpCode, Employees.Name, Employees.Designation, Employees.Department, Employees.Ext, Employees.AppMBamt, MB_Issue.PhoneNo, MB_S_Stock.CProvider FROM Employees, MB_Issue, MB_S_Stock WHERE Employees.EmpCode = MB_Issue.IssueTo AND MB_S_Stock.PhoneNo = MB_Issue.PhoneNo ORDER BY Employees.Department,Employees.Name;");
  lst.setVisible(true);

  String t[][] = lst.getType();
  if(t!=null)
  {
   txtEC.setText(t[0][0]);
   txtName.setText(t[0][1]);
   AppMBTK = t[0][5];
   txtMobile.setText(t[0][6]);
   cboCP.setSelectedItem(t[0][7]);
   Calculate();
  }
 }

 /**
 * Checks that the record already exists or not
 *
 */

 private boolean CheckData()
 {
  String srchStr = "SELECT * FROM MB_Bill WHERE Year='"+cboYear.getSelectedItem()+"' AND Month='"+cboMonth.getSelectedItem()+"' AND EC='"+txtEC.getText()+"';";

  try
  {
   if (mbbcon.isFound(srchStr)) { return true; }
   else {return false;}

  }catch(RemoteException re)
  {System.out.println("Client [frmMBbill]: CHECK DATA Error");System.out.println("Error: "+re.getMessage());return false;}
 }

 /**
 * Calculates Monthly Expense
 *
 */

 private void Calculate()
 {
  double mAmount = 0;
  double mATK = 0;
  double mAppMBTaka = 0;
  double mBalance = 0;
  String z = new String();

  String strQuery = "SELECT AppMBAmt FROM Employees WHERE EmpCode='"+txtEC.getText()+"';";

  try
  {
   if (mbbcon.isFound(strQuery))
   {
    z = ctccon.getDataItem(strQuery);
    System.out.println("Amount is"+ z +".");

    if((!z.equals("")) || (z!=null))
    {
     try
     {
      mAppMBTaka = Double.parseDouble(z);
     }catch(NumberFormatException ex){System.out.println("Exception OCCURED"+ex);}

     System.out.println("Allowed Amount: "+mAppMBTaka);

     DecimalFormat df = new DecimalFormat();
     df.applyPattern("######.##");
     try
     {
      mAmount = Double.parseDouble(txtAmt.getText());
      //mAppMBTaka = Double.parseDouble(AppMBTK);
     }catch(Exception ex){}

     if(cboVAT.getSelectedItem().equals("15% VAT"))
     {mATK = ((mAppMBTaka*15)/100)+mAppMBTaka;}
     else if (cboVAT.getSelectedItem().equals("NO VAT"))
     {mATK = mAppMBTaka;}

     if(mAmount > mATK)
     {mBalance = mAmount - mATK;}

     txtATK.setText(df.format(mATK));
     txtBalance.setText(df.format(mBalance));
    }
    else{System.out.println("Amount Not Found for "+txtEC.getText());}
   }
   else {System.out.println("No Record Found");}

  }catch(RemoteException re)
  {System.out.println("Client [frmMbill]: CALCULATE Error");System.out.println("Error: "+re.getMessage());}
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