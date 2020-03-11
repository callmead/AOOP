//package beximtex;
/**
 * <p>Title: BeximTex, Mobile Sim Stock</p>
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

public class frmMBsStock extends JInternalFrame
{//Class

 JTabbedPane TP = new JTabbedPane();
 JPanel pnlReg = new JPanel();
 JPanel pnlDV = new JPanel();
 TitledBorder titledBorder1;
 TitledBorder titledBorder2;
 TitledBorder titledBorder3;
 JPanel pnlFields = new JPanel();
 TitledBorder titledBorder4;
 TitledBorder titledBorder5;
 JTextField txtPN = new JTextField();
 JTextField txtDate = new JTextField();
 JLabel lblPN = new JLabel();
 JLabel lblCP = new JLabel();
 JTextField txtEmpCode = new JTextField();
 JLabel lblDate = new JLabel();
 JTextField txtCT = new JTextField();
 JLabel lblCT = new JLabel();
 JTextField txtPIN1 = new JTextField();
 JLabel lblPIN1 = new JLabel();
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
 MBsStockController mbsscon;
 MBsStock mbss = new MBsStock();

 CommonTableController ctccon;
 //**************************************************************

 ImageIcon imgFirst = new ImageIcon("./Images/iconFirst.gif");
 ImageIcon imgFO = new ImageIcon("./Images/iconFirstOver.gif");
 ImageIcon imgLast = new ImageIcon("./Images/iconLast.gif");
 ImageIcon imgLO = new ImageIcon("./Images/iconLastOver.gif");
 ImageIcon imgNext = new ImageIcon("./Images/iconNext.gif");
 ImageIcon imgNO = new ImageIcon("./Images/iconNextOver.gif");
 ImageIcon imgHead = new ImageIcon("./Images/touch.gif");
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
 Date d;

 String SQL = null;
 String SQL1 = null;

 Vector ColHead = new Vector();
 Vector rows = new Vector();

 int TotalCol = 0;
 int Rows = 0;
 int Columns = 0;

 JTextField txtCallType = new JTextField();
 JLabel lblCallType = new JLabel();
 JComboBox cboQuality = new JComboBox();
 JComboBox cboIS = new JComboBox();
 JLabel lblQuality = new JLabel();
 JLabel lblIS = new JLabel();
 JComboBox cboCP = new JComboBox();
 JTextField txtPIN2 = new JTextField();
 JLabel lblPIN2 = new JLabel();
 JTextField txtPUK1 = new JTextField();
 JLabel lblPUK1 = new JLabel();
 JTextField txtPUK2 = new JTextField();
 JLabel lblPUK2 = new JLabel();
 JToggleButton btnDT = new JToggleButton();
 JLabel lblAC = new JLabel();
 JTextField txtAC = new JTextField();
 JLabel lblHead = new JLabel();

 public frmMBsStock(String ec)
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
   mbsscon = (MBsStockController)Naming.lookup(new ReadHost().getHost() + "MBsStockController");
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

  this.setTitle("MOBILE SIM STOCK");
  this.getContentPane().setLayout(null);
  this.setForeground(Color.white);
  this.setFrameIcon(imgIco);
  this.getContentPane().setBackground(Color.white);
  this.setClosable(true);
  this.setIconifiable(true);
  this.setMaximizable(false);
  this.setSize(new Dimension(596, 473));

  TP.setBackground(Color.lightGray);
  TP.setFont(new java.awt.Font("Monospaced", 1, 12));
  TP.setForeground(Color.white);
  TP.setBounds(new Rectangle(7, 42, 572, 285));

  pnlReg.setBackground(Color.white);
  pnlReg.setForeground(Color.white);
  pnlReg.setBorder(titledBorder2);
  pnlReg.setLayout(null);
  pnlDV.setBackground(Color.white);
  pnlDV.setBorder(titledBorder3);
  pnlDV.setLayout(null);
  pnlFields.setBackground(Color.white);
  pnlFields.setBorder(titledBorder5);
  pnlFields.setBounds(new Rectangle(8, 9, 550, 160));
  pnlFields.setLayout(null);

  lblPN.setText("PHONE NO.");
  lblPN.setBounds(new Rectangle(10, 8, 102, 24));
  lblPN.setFont(new java.awt.Font("Tahoma", 1, 11));

  txtPN.setText("");
  txtPN.setBounds(new Rectangle(113, 9, 140, 23));
  txtPN.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtPN.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtPN.selectAll();}
   public void focusLost(FocusEvent f) {}
  });
  txtPN.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtPN.getText().length()>=10){ke1.consume();}
    if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8)) {}
    else ke1.consume();
   }
  });


  txtDate.setBounds(new Rectangle(356, 9, 159, 23));
  txtDate.setEnabled(false);
  txtDate.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtDate.setText("");

  lblCP.setBounds(new Rectangle(261, 37, 84, 24));
  lblCP.setText("PROVIDER");
  lblCP.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblCP.setHorizontalAlignment(SwingConstants.RIGHT);

  lblDate.setBounds(new Rectangle(304, 8, 41, 24));
  lblDate.setText("DATE");
  lblDate.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblDate.setHorizontalAlignment(SwingConstants.RIGHT);

  txtCT.setText("");
  txtCT.setBounds(new Rectangle(113, 38, 140, 23));
  txtCT.setEnabled(true);
  txtCT.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtCT.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtCT.selectAll();}
   public void focusLost(FocusEvent f) {}
  });

  lblCT.setText("CONNECTION TYPE");
  lblCT.setBounds(new Rectangle(10, 37, 106, 24));
  lblCT.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblCT.setToolTipText("");

  txtPIN1.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtPIN1.setBounds(new Rectangle(356, 67, 71, 23));
  txtPIN1.setText("");
  txtPIN1.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtPIN1.selectAll();}
   public void focusLost(FocusEvent f) {}
  });
  txtPIN1.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtPIN1.getText().length()>=4){ke1.consume();}
    if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8)) {}
    else ke1.consume();
   }
  });

  txtPIN1.setEnabled(true);
  lblPIN1.setToolTipText("");
  lblPIN1.setHorizontalAlignment(SwingConstants.RIGHT);
  lblPIN1.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblPIN1.setBounds(new Rectangle(294, 66, 51, 24));
  lblPIN1.setText("PIN 1");
  txtRemarks.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtRemarks.setBounds(new Rectangle(356, 124, 184, 23));
  txtRemarks.setText("");
  txtRemarks.setEnabled(true);
  txtRemarks.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtRemarks.selectAll();}
   public void focusLost(FocusEvent f) {}
  });
  txtRemarks.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtRemarks.getText().length()>=50){ke1.consume();}
   }
  });

  lblRem.setToolTipText("");
  lblRem.setHorizontalAlignment(SwingConstants.RIGHT);
  lblRem.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblRem.setBounds(new Rectangle(258, 123, 87, 24));
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
    if(txtPN.getText().equals(""))
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
    setButton(false);
    setFields(true);
    btnDT.setEnabled(false);
    txtPN.requestFocus();
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

    txtPN.requestFocus();
    cboIS.setSelectedItem("No");
    cboIS.setEnabled(false);
    cboQuality.setSelectedItem("New");
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
     mbss=mbsscon.moveLast();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmMBsStock]: MOVE LAST Error");System.out.println("Error: "+re.getMessage());}
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
   {
    getConnected();
   }
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
     mbss=mbsscon.movePrevious();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmMBsStock]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
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
     mbss=mbsscon.moveNext();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmMBsStock]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
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
     mbss=mbsscon.moveFirst();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmMBsStock]: MOVE FIRST Error");System.out.println("Error: "+re.getMessage());}
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
  sp.setToolTipText("SIM STOCK");
  sp.setBounds(new Rectangle(6, 6, 540, 229));
  pnlFieldsRE.setBackground(Color.white);
  pnlFieldsRE.setBorder(titledBorder12);
  pnlFieldsRE.setBounds(new Rectangle(6, 158, 554, 60));
  pnlFieldsRE.setLayout(null);
  pnlSearch.setBackground(Color.white);
  pnlSearch.setBorder(titledBorder14);
  pnlSearch.setBounds(new Rectangle(7, 334, 572, 98));
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

  txtCallType.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtCallType.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtCallType.selectAll();}
   public void focusLost(FocusEvent f) {}
  });
  txtCallType.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtCallType.getText().length()>=10){ke1.consume();}
   }
  });

  lblCallType.setToolTipText("");
  lblCallType.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblCallType.setBounds(new Rectangle(10, 66, 106, 24));
  lblCallType.setText("CALL TYPE");
  txtCallType.setBounds(new Rectangle(113, 67, 140, 23));

  cboQuality.setBounds(new Rectangle(113, 95, 75, 23));
  cboQuality.setToolTipText("");
  cboQuality.setMaximumRowCount(4);
  cboQuality.setBackground(Color.white);
  cboIS.setBackground(Color.white);
  cboIS.setMaximumRowCount(3);
  cboIS.setToolTipText("");
  cboIS.setBounds(new Rectangle(237, 95, 64, 23));
  lblQuality.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblQuality.setBounds(new Rectangle(10, 94, 75, 24));
  lblQuality.setText("QUALITY");
  lblIS.setHorizontalAlignment(SwingConstants.LEFT);
  lblIS.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblIS.setText("ISSUED");
  lblIS.setBounds(new Rectangle(189, 94, 52, 24));

  cboCP.setBounds(new Rectangle(356, 38, 184, 23));
  cboCP.setToolTipText("Connection Provider");
  cboCP.setMaximumRowCount(3);
  cboCP.setBackground(Color.white);
  txtPIN2.setEnabled(true);
  txtPIN2.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtPIN2.setBounds(new Rectangle(469, 67, 71, 23));
  txtPIN2.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtPIN2.selectAll();}
   public void focusLost(FocusEvent f) {}
  });
  txtPIN2.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtPIN2.getText().length()>=4){ke1.consume();}
    if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8)) {}
    else ke1.consume();
   }
  });

  lblPIN2.setText("PIN 2");
  lblPIN2.setBounds(new Rectangle(427, 66, 36, 24));
  lblPIN2.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblPIN2.setHorizontalAlignment(SwingConstants.RIGHT);
  lblPIN2.setToolTipText("");
  txtPUK1.setEnabled(true);
  txtPUK1.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtPUK1.setBounds(new Rectangle(356, 95, 71, 23));
  txtPUK1.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtPUK1.selectAll();}
   public void focusLost(FocusEvent f) {}
  });
  txtPUK1.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtPUK1.getText().length()>=4){ke1.consume();}
    if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8)) {}
    else ke1.consume();
   }
  });

  lblPUK1.setText("PUK 1");
  lblPUK1.setBounds(new Rectangle(294, 94, 51, 24));
  lblPUK1.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblPUK1.setHorizontalAlignment(SwingConstants.RIGHT);
  txtPUK2.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtPUK2.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtPUK2.selectAll();}
   public void focusLost(FocusEvent f) {}
  });
  txtPUK2.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtPUK2.getText().length()>=4){ke1.consume();}
    if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8)) {}
    else ke1.consume();
   }
  });

  lblPUK2.setHorizontalAlignment(SwingConstants.RIGHT);
  lblPUK2.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblPUK2.setBounds(new Rectangle(412, 94, 51, 24));
  lblPUK2.setText("PUK 2");
  txtPUK2.setBounds(new Rectangle(469, 95, 71, 23));
  btnDT.setToolTipText("DATE SELECTOR");
  btnDT.setText("");
  btnDT.setIcon(imgTab);
  btnDT.setBounds(new Rectangle(518, 9, 22, 23));
  btnDT.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnDT_actionPerformed(e); }
  });
  lblAC.setText("ACCOUNT NO");
  lblAC.setBounds(new Rectangle(10, 123, 106, 24));
  lblAC.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblAC.setToolTipText("");
  txtAC.setBounds(new Rectangle(113, 124, 140, 23));
  txtAC.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtAC.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtAC.getText().length()>=15){ke1.consume();}
   }
  });
  lblHead.setBounds(new Rectangle(0, 0, 534, 60));
  lblHead.setIcon(imgHead);
  pnlFields.add(txtEmpCode, null);
  pnlFields.add(lblPN, null);
  pnlFields.add(lblCT, null);
  pnlFields.add(lblCallType, null);
  pnlFields.add(lblQuality, null);
  pnlFields.add(lblDate, null);
  pnlFields.add(lblCP, null);
  pnlFields.add(lblPIN1, null);
  pnlFields.add(lblRem, null);
  pnlFields.add(cboCP, null);
  pnlFields.add(txtPIN1, null);
  pnlFields.add(txtRemarks, null);
  pnlFields.add(txtDate, null);
  pnlFields.add(txtPIN2, null);
  pnlFields.add(lblPIN2, null);
  pnlFields.add(txtPUK1, null);
  pnlFields.add(lblPUK1, null);
  pnlFields.add(txtPUK2, null);
  pnlFields.add(lblPUK2, null);
  pnlFields.add(btnDT, null);
  pnlFields.add(txtCallType, null);
  pnlFields.add(cboQuality, null);
  pnlFields.add(txtPN, null);
  pnlFields.add(txtCT, null);
  pnlFields.add(lblIS, null);
  pnlFields.add(cboIS, null);
  pnlFields.add(lblAC, null);
  pnlFields.add(txtAC, null);

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
  pnlReg.add(pnlFields, null);
  pnlReg.add(pnlButtons, null);

  pnlDV.add(pnlTab, null);
  pnlTab.add(sp, null);
  pnlDV.add(pnlFieldsRE, null);
  TP.add(pnlReg, "REGISTER");
  sp.add(Table, null);
  TP.add(pnlDV, "VIEW DATA");

  pnlSearch.add(btnGo, null);
  pnlSearch.add(lblPicture, null);
  pnlSearch.add(txtSearch, null);
  pnlSearch.add(cboSearch, null);

  addComboItems();

  this.getContentPane().add(TP, null);
  this.getContentPane().add(pnlSearch, null);
  this.getContentPane().add(pnlSearch, null);
  this.getContentPane().add(lblHead, null);

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
   mbsscon.Connect();
  }catch(RemoteException re){ System.out.println("Client [frmMBsStock]: Open Error");System.out.println("Error: "+re.getMessage());}

  //DISPLAY DATA RMI
  try
  {
   mbss = mbsscon.moveNext();
   display();
  }catch(RemoteException re){ System.out.println("Client [frmMBsStock]: Show Error");System.out.println("Error: "+re.getMessage());}

  SQL="SELECT * FROM MB_S_Stock ORDER BY PhoneNo;";
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
  btnDT.setEnabled(!btnValue);
 }

 /**
 * Sets Fields States
 * @param boolean true or false
 *
 */

 public void setFields(boolean txtValue)
 {
  txtPN.setEnabled(txtValue);
  txtCT.setEnabled(txtValue);
  cboCP.setEnabled(txtValue);
  txtCallType.setEnabled(txtValue);
  txtPIN1.setEnabled(txtValue);
  txtPIN2.setEnabled(txtValue);
  txtPUK1.setEnabled(txtValue);
  txtPUK2.setEnabled(txtValue);
  cboQuality.setEnabled(txtValue);
  cboIS.setEnabled(txtValue);
  txtAC.setEnabled(txtValue);
  txtRemarks.setEnabled(txtValue);
  cboSearch.setEnabled(!txtValue);
  txtSearch.setEnabled(!txtValue);
 }

 /**
 * Clear Text From Fields
 *
 */

 public void clearFields()
 {
  txtPN.setText("");
  txtDate.setText("");
  txtCT.setText("");
  txtCallType.setText("");
  txtPIN1.setText("");
  txtPIN2.setText("");
  txtPUK1.setText("");
  txtPUK2.setText("");
  txtAC.setText("");
  txtRemarks.setText("");
 }

 /**
 * Display Data
 *
 */

 public void display()
 {
  txtPN.setText(mbss.getPhoneNo());
  txtDate.setText(mbss.getDate());
  txtCT.setText(mbss.getCType());
  cboCP.setSelectedItem(mbss.getCProvider());
  txtCallType.setText(mbss.getCallType());
  txtPIN1.setText(mbss.getPIN1());
  txtPIN2.setText(mbss.getPIN2());
  txtPUK1.setText(mbss.getPUK1());
  txtPUK2.setText(mbss.getPUK2());
  cboQuality.setSelectedItem(mbss.getQuality());
  cboIS.setSelectedItem(mbss.getIssued());
  //EmpCode 12
  txtAC.setText(mbss.getAC());
  txtRemarks.setText(mbss.getRemarks());

 }

 /**
 * Checks the Fields
 *
 * @return boolean true or false value
 */

 public boolean checkFields()
 {
  if (txtPN.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide a Mobile NO.!","Missing Information",JOptionPane.ERROR_MESSAGE);txtPN.requestFocus();return false;}
  if (txtCallType.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Call Type!","Missing Information",JOptionPane.ERROR_MESSAGE);txtCallType.requestFocus();return false;}
  if (txtPIN1.getText().equals("")){txtPIN1.setText("-");}
  if (txtPIN2.getText().equals("")){txtPIN2.setText("-");}
  if (txtPUK1.getText().equals("")){txtPUK1.setText("-");}
  if (txtPUK2.getText().equals("")){txtPUK2.setText("-");}
  if (txtAC.getText().equals("")){txtAC.setText("-");}
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
  mbss.setPhoneNo(txtPN.getText());
  mbss.setDate(txtDate.getText());
  mbss.setCType(txtCT.getText());
  mbss.setCProvider(cboCP.getSelectedItem()+"");
  mbss.setCallType(txtCallType.getText());
  mbss.setPIN1(txtPIN1.getText());
  mbss.setPIN2(txtPIN2.getText());
  mbss.setPUK1(txtPUK1.getText());
  mbss.setPUK2(txtPUK2.getText());
  mbss.setQuality(cboQuality.getSelectedItem()+"");
  mbss.setIssued(cboIS.getSelectedItem()+"");
  mbss.setEmpCode(EmpCode);
  mbss.setAC(txtAC.getText());
  mbss.setRemarks(txtRemarks.getText());

  try
  {
   savesucc = mbsscon.insertData(mbss);
   StartWorking("ADDING NEW RECORD");
   JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
   getConnected();

  }catch(RemoteException re)
  {
   System.out.println("Client [frmMBsStock]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmMBsStock]: "+re.getMessage(),
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
  mbss.setPhoneNo(txtPN.getText());
  mbss.setDate(txtDate.getText());
  mbss.setCType(txtCT.getText());
  mbss.setCProvider(cboCP.getSelectedItem()+"");
  mbss.setCallType(txtCallType.getText());
  mbss.setPIN1(txtPIN1.getText());
  mbss.setPIN2(txtPIN2.getText());
  mbss.setPUK1(txtPUK1.getText());
  mbss.setPUK2(txtPUK2.getText());
  mbss.setQuality(cboQuality.getSelectedItem()+"");
  mbss.setIssued(cboIS.getSelectedItem()+"");
  mbss.setEmpCode(EmpCode);
  mbss.setAC(txtAC.getText());
  mbss.setRemarks(txtRemarks.getText());

  try
  {
   updatesucc = mbsscon.updateData(mbss);
   StartWorking("UPDATING RECORD");
   JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
   getConnected();

  }catch(RemoteException re)
  {
   System.out.println("Client [frmMBsStock]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmMBsStock]: "+re.getMessage(),
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
  String strQuery = "DELETE FROM MB_S_Stock WHERE PhoneNo='" + txtPN.getText() + "';";

  int yn;
  yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
  JOptionPane.YES_NO_OPTION, 3, imgQ);

  if (yn == JOptionPane.YES_OPTION)
  {
   try
   {
    mbsscon.DeleteData(strQuery);
    StartWorking("DELETING RECORD");
    JOptionPane.showMessageDialog(null, "Server: Record Deleted!", "Information", 1);
    clearFields();
    getConnected();

   }catch(RemoteException re)
   {
    System.out.println("Client [frmMBsStock]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmMBsStock]: "+re.getMessage(),
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
   System.out.println("Client [frmMBsStock]: GET TABLE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmMBsStock]: "+re.getMessage(),
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
     txtPN.setText(SelRow[0][0]);txtDate.setText(SelRow[0][1]);txtCT.setText(SelRow[0][2]);cboCP.setSelectedItem(SelRow[0][3]);txtCallType.setText(SelRow[0][4]);txtPIN1.setText(SelRow[0][5]);txtPIN2.setText(SelRow[0][6]);txtPUK1.setText(SelRow[0][7]);txtPUK2.setText(SelRow[0][8]);cboQuality.setSelectedItem(SelRow[0][9]);cboIS.setSelectedItem(SelRow[0][10]);txtRemarks.setText(SelRow[0][12]);
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
  int[] sz = new int[14];
  sz[0]=70;sz[1]=60;sz[2]=100;sz[3]=100;sz[4]=70;sz[5]=50;sz[6]=50;sz[7]=50;
  sz[8]=50;sz[9]=70;sz[10]=50;sz[11]=50;sz[12]=70;sz[13]=200;
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
   SQLString = "SELECT * FROM MB_S_Stock WHERE " + cboSearch.getSelectedItem().toString() + "='" + txtSearch.getText() + "';";

   try
   {
    if (mbsscon.isFound(SQLString))
    {
     mbss = mbsscon.SearchData(SQLString);
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
   {System.out.println("Client [frmMBsStock]: SEARCH DATA Error");System.out.println("Error: "+re.getMessage());}
  }
 }

 /**
 * Adding Combo Items
 *
 */

 void addComboItems()
 {
  cboQuality.addItem("New");
  cboQuality.addItem("Used");
  cboQuality.addItem("Bad");

  cboIS.addItem("No");
  cboIS.addItem("Yes");

  cboCP.addItem("CityCell");
  cboCP.addItem("GrameenPhone");

  cboSearch.addItem("PhoneNo");
  cboSearch.addItem("CType");
  cboSearch.addItem("CProvider");
  cboSearch.addItem("CallType");
  cboSearch.addItem("Issued");

 }

 void btnDT_actionPerformed(ActionEvent e)
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