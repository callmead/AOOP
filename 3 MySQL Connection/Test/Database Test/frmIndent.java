//package beximtex;
/**
 * <p>Title: BeximTex, Indents</p>
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

public class frmIndent extends JInternalFrame
{//Class

 JTabbedPane TP = new JTabbedPane();
 JPanel pnlR = new JPanel();
 JPanel pnlVD = new JPanel();
 TitledBorder titledBorder1;
 TitledBorder titledBorder2;
 TitledBorder titledBorder3;
 JPanel pnlFieldsPO = new JPanel();
 TitledBorder titledBorder4;
 TitledBorder titledBorder5;
 JTextField txtIN = new JTextField();
 JTextField txtDate = new JTextField();
 JLabel lblIN = new JLabel();
 JLabel lblRF = new JLabel();
 JTextField txtEmpCode = new JTextField();
 JLabel lblDate = new JLabel();
 JTextField txtRB = new JTextField();
 JLabel lblRB = new JLabel();
 JTextField txtAmount = new JTextField();
 JLabel lblAmount = new JLabel();
 JPanel pnlButtonsRC = new JPanel();
 TitledBorder titledBorder6;
 TitledBorder titledBorder7;
 JButton btnDelete = new JButton();
 JButton btnClose = new JButton();
 JLabel lblRec = new JLabel();
 JButton btnSave = new JButton();
 JButton btnCancel = new JButton();
 JButton btnEdit = new JButton();
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
 IndentController indcon;
 Indent ind = new Indent();

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
 String SQL = null;
 String SQL1 = null;

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

 Vector ColHead = new Vector();
 Vector rows = new Vector();

 int TotalCol = 0;
 int Rows = 0;
 int Columns = 0;

 JTextField txtRD = new JTextField();
 JLabel lblRD = new JLabel();
 JTextField txtBAL = new JTextField();
 JLabel lblBAL = new JLabel();
 JTextField txtRF = new JTextField();
 JTextField txtSD = new JTextField();
 JLabel lblSD = new JLabel();
 JTextField txtST = new JTextField();
 JLabel lblST = new JLabel();
 JToggleButton btnDT = new JToggleButton();
 JToggleButton btnRD = new JToggleButton();
 JToggleButton btnSD = new JToggleButton();
 JToggleButton btnST = new JToggleButton();
 JToggleButton btnRB = new JToggleButton();
 JToggleButton btnRF = new JToggleButton();
 JComboBox cboBU = new JComboBox();
 JPanel pnlRec = new JPanel();
 JPanel pnlReceive = new JPanel();
 TitledBorder titledBorder15;
 TitledBorder titledBorder16;
 JPanel pnlRB = new JPanel();
 TitledBorder titledBorder17;
 TitledBorder titledBorder18;
 JButton btnNew = new JButton();
 JLabel lblBU = new JLabel();
 JButton btnCI = new JButton();
 JLabel lblRec1 = new JLabel();
 JToggleButton btnLast1 = new JToggleButton();
 JToggleButton btnPrevious1 = new JToggleButton();
 JToggleButton btnNext1 = new JToggleButton();
 JToggleButton btnFirst1 = new JToggleButton();
 JLabel lblRem = new JLabel();
 JLabel lblRem1 = new JLabel();
 JButton btnClose1 = new JButton();
 JButton btnDelete1 = new JButton();
 JScrollPane SPR = new JScrollPane();
 JTextArea txtRemarks = new JTextArea();
 JScrollPane SPR1 = new JScrollPane();
 JTextArea txtRemarks1 = new JTextArea();
 JButton btnSave1 = new JButton();
 JButton btnCancel1 = new JButton();
 JButton btnEdit1 = new JButton();
 JLabel lblHead = new JLabel();

 public frmIndent(String ec)
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
   indcon = (IndentController)Naming.lookup(new ReadHost().getHost() + "IndentController");
   ctccon = (CommonTableController)Naming.lookup(new ReadHost().getHost() + "CommonTableController");

  }catch(Exception ec)
  {
   System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
   System.out.println("Error: "+ec.getMessage());
   JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
   "Error", JOptionPane.ERROR_MESSAGE);
   System.exit(0);
  }
  System.out.println("\n******************************\n CLIENT READY [frmIndent] \n******************************\n");
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

  titledBorder15 = new TitledBorder("");
  titledBorder16 = new TitledBorder("");
  titledBorder17 = new TitledBorder("");
  titledBorder18 = new TitledBorder("");
  this.setTitle("INDENTS");
  this.getContentPane().setLayout(null);
  this.setForeground(Color.white);
  this.setFrameIcon(imgIco);
  this.getContentPane().setBackground(Color.white);
  this.setClosable(true);
  this.setIconifiable(true);
  this.setMaximizable(false);
  this.setSize(new Dimension(596, 473));

  TP.setBackground(Color.black);
  TP.setFont(new java.awt.Font("Monospaced", 1, 12));
  TP.setForeground(Color.white);
  TP.setBounds(new Rectangle(7, 42, 572, 285));

  pnlR.setBackground(Color.white);
  pnlR.setForeground(Color.white);
  pnlR.setBorder(titledBorder2);
  pnlR.setLayout(null);
  pnlVD.setBackground(Color.white);
  pnlVD.setBorder(titledBorder3);
  pnlVD.setLayout(null);
  pnlFieldsPO.setBackground(Color.white);
  pnlFieldsPO.setBorder(titledBorder5);
  pnlFieldsPO.setBounds(new Rectangle(8, 9, 550, 155));
  pnlFieldsPO.setLayout(null);
  txtIN.setText("");
  txtIN.setBounds(new Rectangle(107, 9, 140, 23));
  txtIN.setEnabled(false);
  txtIN.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtDate.setBounds(new Rectangle(399, 40, 117, 23));
  txtDate.setEnabled(false);
  txtDate.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtDate.setText("");

  lblIN.setText("INDENT NO.");
  lblIN.setBounds(new Rectangle(10, 8, 102, 24));
  lblIN.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblIN.setHorizontalTextPosition(SwingConstants.LEFT);

  lblRF.setBounds(new Rectangle(288, 11, 106, 24));
  lblRF.setText("RECEIVED FROM");
  lblRF.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblRF.setHorizontalAlignment(SwingConstants.RIGHT);

  lblDate.setBounds(new Rectangle(350, 39, 41, 24));
  lblDate.setText("DATE");
  lblDate.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblDate.setHorizontalAlignment(SwingConstants.RIGHT);

  txtRB.setText("");
  txtRB.setBounds(new Rectangle(402, 41, 117, 23));
  txtRB.setEnabled(false);
  txtRB.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtRB.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtRB.selectAll();}
   public void focusLost(FocusEvent f) {}
  });

  lblRB.setText("RECEIVED BY");
  lblRB.setBounds(new Rectangle(288, 40, 106, 24));
  lblRB.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblRB.setToolTipText("");
  lblRB.setHorizontalAlignment(SwingConstants.RIGHT);

  txtAmount.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtAmount.setEditable(true);
  txtAmount.setBounds(new Rectangle(107, 40, 140, 23));
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
    if(txtAmount.getText().length()>=20){ke1.consume();}
    if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8) || (ke1.getKeyChar()==44)) {}
    else ke1.consume();
   }
  });

  txtAmount.setEnabled(true);
  lblAmount.setToolTipText("");
  lblAmount.setHorizontalAlignment(SwingConstants.LEFT);
  lblAmount.setHorizontalTextPosition(SwingConstants.LEFT);
  lblAmount.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblAmount.setBounds(new Rectangle(10, 39, 106, 24));
  lblAmount.setText("AMOUNT");

  pnlButtonsRC.setBackground(Color.white);
  pnlButtonsRC.setBorder(titledBorder7);
  pnlButtonsRC.setMaximumSize(new Dimension(32767, 32767));
  pnlButtonsRC.setBounds(new Rectangle(8, 175, 550, 74));
  pnlButtonsRC.setLayout(null);
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
    if(txtIN.getText().equals(""))
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
     if (editData())
     {
      setButton(true);
      setFields(false);
     }
    }
    isAdd = false;
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
    //clearFields();
    txtIN.setEnabled(false);
    btnDT.setEnabled(false);
    btnRD.requestFocus();
    lblRec.setText(" Edit Record... ");
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
     ind=indcon.moveLast();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmIndent]: MOVE LAST Error");System.out.println("Error: "+re.getMessage());}
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
     ind=indcon.movePrevious();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmIndent]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
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
     ind=indcon.moveNext();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmIndent]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
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
     ind=indcon.moveFirst();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmIndent]: MOVE FIRST Error");System.out.println("Error: "+re.getMessage());}
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
  cboSearch.addItem("IndentNo");
  cboSearch.addItem("Date");
  cboSearch.addItem("RecFrom");
  cboSearch.addItem("RecBy");
  cboSearch.addItem("RecDate");
  cboSearch.addItem("SubmtTo");
  txtSearch.setFont(new Font("Tahoma", 1, 12));
  txtSearch.setCaretColor(Color.blue);
  txtSearch.setText("");
  txtSearch.setBounds(new Rectangle(19, 63, 330, 24));

  txtRD.setEnabled(false);
  txtRD.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtRD.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtRD.selectAll();}
   public void focusLost(FocusEvent f) {}
  });
  lblRD.setToolTipText("");
  lblRD.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblRD.setBounds(new Rectangle(13, 11, 106, 24));
  lblRD.setText("RECEIVED DATE");
  txtRD.setBounds(new Rectangle(110, 11, 117, 23));
  txtBAL.setEnabled(true);
  txtBAL.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtBAL.setHorizontalAlignment(SwingConstants.RIGHT);
  txtBAL.setBounds(new Rectangle(110, 40, 140, 23));
  txtBAL.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtBAL.getText().length()>=20){ke1.consume();}
     if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8)) {}
    else ke1.consume();
   }
  });
  txtBAL.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   { txtBAL.selectAll(); }
   public void focusLost(FocusEvent f) {}
  });

  lblBAL.setText("BALANCE");
  lblBAL.setBounds(new Rectangle(13, 40, 106, 24));
  lblBAL.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblBAL.setToolTipText("");
  lblBAL.setHorizontalAlignment(SwingConstants.LEFT);
  txtRF.setBounds(new Rectangle(402, 12, 117, 23));
  txtRF.setText("");
  txtRF.setEnabled(false);
  txtRF.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtRF.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   { txtRF.selectAll(); }
   public void focusLost(FocusEvent f) {}
  });
  txtRF.addKeyListener(new KeyAdapter()
  {
   public void keyPressed(KeyEvent ke1) {}
   public void keyTyped(KeyEvent ke1)
   {
    if(txtRF.getText().length()>=20){ke1.consume();}
   }
  });
  txtSD.setEnabled(false);
  txtSD.setBounds(new Rectangle(402, 70, 117, 23));
  txtSD.setFont(new java.awt.Font("Tahoma", 1, 11));

  lblSD.setText("SUBMITTED DATE");
  lblSD.setBounds(new Rectangle(288, 69, 106, 24));
  lblSD.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblSD.setHorizontalAlignment(SwingConstants.RIGHT);
  lblSD.setToolTipText("");
  txtST.setBounds(new Rectangle(110, 69, 117, 23));
  txtST.setEnabled(false);
  txtST.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtST.addFocusListener(new FocusAdapter()
  {
   public void focusGained(FocusEvent f)
   {txtST.selectAll();}
   public void focusLost(FocusEvent f){}
  });
  lblST.setText("SUBMITTED TO");
  lblST.setBounds(new Rectangle(13, 69, 106, 24));
  lblST.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblST.setToolTipText("");
  btnDT.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnDT_actionPerformed(e); }
  });
  btnDT.setBounds(new Rectangle(331, 9, 22, 23));
  btnDT.setIcon(imgTab);
  btnDT.setText("");
  btnDT.setToolTipText("DATE SELECTOR");
  btnDT.setBounds(new Rectangle(518, 11, 22, 23));
  btnDT.setBounds(new Rectangle(517, 38, 22, 23));
  btnDT.setBounds(new Rectangle(378, 8, 22, 23));
  btnDT.setBounds(new Rectangle(517, 40, 22, 23));
  btnRD.setBounds(new Rectangle(517, 9, 22, 23));
  btnRD.setBounds(new Rectangle(378, 8, 22, 23));
  btnRD.setBounds(new Rectangle(517, 38, 22, 23));
  btnRD.setBounds(new Rectangle(518, 11, 22, 23));
  btnRD.setToolTipText("DATE SELECTOR");
  btnRD.setText("");
  btnRD.setIcon(imgTab);
  btnRD.setBounds(new Rectangle(228, 11, 22, 23));
  btnRD.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnRD_actionPerformed(e); }
  });
  btnSD.setBounds(new Rectangle(517, 9, 22, 23));
  btnSD.setBounds(new Rectangle(378, 8, 22, 23));
  btnSD.setBounds(new Rectangle(517, 38, 22, 23));
  btnSD.setBounds(new Rectangle(518, 11, 22, 23));
  btnSD.setToolTipText("DATE SELECTOR");
  btnSD.setText("");
  btnSD.setIcon(imgTab);
  btnSD.setBounds(new Rectangle(520, 70, 22, 23));
  btnSD.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnSD_actionPerformed(e); }
  });
  btnST.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnST_actionPerformed(e); }
  });
  btnST.setBounds(new Rectangle(225, 67, 22, 23));
  btnST.setIcon(imgTab);
  btnST.setText("");
  btnST.setToolTipText("Show Employee List");
  btnST.setBounds(new Rectangle(518, 11, 22, 23));
  btnST.setBounds(new Rectangle(517, 38, 22, 23));
  btnST.setBounds(new Rectangle(378, 8, 22, 23));
  btnST.setBounds(new Rectangle(228, 69, 22, 23));
  btnRB.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnRB_actionPerformed(e); }
  });
  btnRB.setBounds(new Rectangle(517, 96, 22, 23));
  btnRB.setIcon(imgTab);
  btnRB.setText("");
  btnRB.setToolTipText("Show Employee List");
  btnRB.setBounds(new Rectangle(518, 11, 22, 23));
  btnRB.setBounds(new Rectangle(517, 38, 22, 23));
  btnRB.setBounds(new Rectangle(378, 8, 22, 23));
  btnRB.setBounds(new Rectangle(520, 41, 22, 23));
  btnRF.setBounds(new Rectangle(517, 67, 22, 23));
  btnRF.setBounds(new Rectangle(378, 8, 22, 23));
  btnRF.setBounds(new Rectangle(517, 38, 22, 23));
  btnRF.setBounds(new Rectangle(518, 11, 22, 23));
  btnRF.setToolTipText("Show Employee List");
  btnRF.setText("");
  btnRF.setIcon(imgTab);
  btnRF.setBounds(new Rectangle(520, 12, 22, 23));
  btnRF.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { btnRF_actionPerformed(e); }
  });
  cboBU.setToolTipText("DIVISION");
  cboBU.setBackground(Color.white);
  cboBU.setBounds(new Rectangle(399, 9, 117, 23));
  pnlRec.setBackground(Color.white);
  pnlRec.setLayout(null);
  pnlReceive.setBackground(Color.white);
  pnlReceive.setBorder(titledBorder16);
  pnlReceive.setBounds(new Rectangle(8, 7, 550, 161));
  pnlReceive.setLayout(null);
  pnlRB.setBackground(Color.white);
  pnlRB.setBorder(titledBorder18);
  pnlRB.setBounds(new Rectangle(8, 172, 550, 76));
  pnlRB.setLayout(null);
  btnNew.setBorder(BorderFactory.createRaisedBevelBorder());
  btnNew.setBounds(new Rectangle(12, 39, 91, 28));
  btnNew.setText("NEW");
  btnNew.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnNew.setMnemonic('N');
  btnNew.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    isAdd = true;
    setInButton(false);
    setFields(true);
    clearInFields();
    txtEmpCode.setText(EmpCode);
    d = new Date();
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    CurrentDate = sdf.format(d);
    txtDate.setText(CurrentDate);
    txtIN.requestFocus();
    lblRec.setText(" Add New Record... ");
   }
  });
  lblBU.setHorizontalAlignment(SwingConstants.RIGHT);
  lblBU.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblBU.setText("BU");
  lblBU.setBounds(new Rectangle(350, 8, 41, 24));
  btnCI.setBorder(BorderFactory.createRaisedBevelBorder());
  btnCI.setBounds(new Rectangle(203, 39, 138, 28));
  btnCI.setText("CANCEL INDENT");
  btnCI.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnCI.setMnemonic('C');
  btnCI.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    String SQLString = "UPDATE Indents SET Remarks='Canceled' WHERE IndentNo='" +txtIN.getText()+ "';";
    try
    {
     ctccon.ExecuteQuery(SQLString);
     StartWorking("UPDATING RECORD");
     JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);

    }catch(RemoteException re)
    {
     System.out.println("Client [frmIndent]: btnCI Action Error");System.out.println("Error: "+re.getMessage());
     JOptionPane.showMessageDialog(null, "btnCI Action Error\nClient [frmIndent]: "+re.getMessage(),
     "Error", JOptionPane.ERROR_MESSAGE);
    }
   }
  });
  btnFirst1.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    try
    {
     ind=indcon.moveFirst();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmIndent]: MOVE FIRST Error");System.out.println("Error: "+re.getMessage());}
   }
  });
  btnFirst1.addMouseListener(new MouseAdapter()
  {
   public void mouseEntered(MouseEvent e)
   { btnFirst1.setIcon(imgFO); }
   public void mouseExited(MouseEvent f)
   { btnFirst1.setIcon(imgFirst); }
  });

  btnLast1.setBounds(new Rectangle(360, 9, 22, 23));
  btnLast1.setToolTipText("Last");
  btnLast1.setText("");
  btnLast1.setIcon(imgLast);
  btnLast1.setBounds(new Rectangle(376, 9, 22, 23));
  btnLast1.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    try
    {
     ind=indcon.moveLast();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmIndent]: MOVE LAST Error");System.out.println("Error: "+re.getMessage());}
   }
  });
  btnLast1.addMouseListener(new MouseAdapter()
  {
   public void mouseEntered(MouseEvent e)
   { btnLast1.setIcon(imgLO); }
   public void mouseExited(MouseEvent f)
   { btnLast1.setIcon(imgLast); }
  });

  btnPrevious1.setBounds(new Rectangle(158, 9, 22, 23));
  btnPrevious1.setToolTipText("Previous");
  btnPrevious1.setText("");
  btnPrevious1.setIcon(imgPrev);
  btnPrevious1.setBounds(new Rectangle(166, 9, 22, 23));
  btnPrevious1.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    try
    {
     ind=indcon.movePrevious();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmIndent]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
   }
  });
  btnPrevious1.addMouseListener(new MouseAdapter()
  {
   public void mouseEntered(MouseEvent e)
   { btnPrevious1.setIcon(imgPO); }
   public void mouseExited(MouseEvent f)
   { btnPrevious1.setIcon(imgPrev); }
  });

  btnNext1.setBounds(new Rectangle(337, 9, 22, 23));
  btnNext1.setToolTipText("Next");
  btnNext1.setText("");
  btnNext1.setIcon(imgNext);
  btnNext1.setBounds(new Rectangle(353, 9, 22, 23));
  btnNext1.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    try
    {
     ind=indcon.moveNext();
     display();
    }catch(RemoteException re){ System.out.println("Client [frmIndent]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
   }
  });
  btnNext1.addMouseListener(new MouseAdapter()
  {
   public void mouseEntered(MouseEvent e)
   { btnNext1.setIcon(imgNO); }
   public void mouseExited(MouseEvent f)
   { btnNext1.setIcon(imgNext); }
  });

  btnFirst1.setBounds(new Rectangle(142, 9, 22, 23));
  btnFirst1.setIcon(imgFirst);
  lblRec1.setBounds(new Rectangle(196, 10, 150, 21));
  lblRem.setToolTipText("");
  lblRem.setHorizontalAlignment(SwingConstants.LEFT);
  lblRem.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblRem.setBounds(new Rectangle(10, 66, 69, 24));
  lblRem.setText("REMARKS");
  lblRem1.setText("REMARKS");
  lblRem1.setFont(new java.awt.Font("Tahoma", 1, 11));
  lblRem1.setBounds(new Rectangle(13, 95, 69, 24));
  btnClose1.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { dispose(); }
  });
  btnClose1.setBounds(new Rectangle(442, 39, 91, 28));
  btnClose1.setIcon(new ImageIcon("./Images/close.gif"));
  btnClose1.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnClose1.setText("CLOSE");
  btnClose1.setMnemonic('L');
  btnClose1.setBorder(BorderFactory.createRaisedBevelBorder());
  btnDelete1.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
    {
    if(txtIN.getText().equals(""))
    { return; }
    DeleteData();
   }
  });
  btnDelete1.setBounds(new Rectangle(346, 39, 91, 28));
  btnDelete1.setIcon(new ImageIcon("images/Delete16.gif"));
  btnDelete1.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnDelete1.setText("DELETE");
  btnDelete1.setMnemonic('D');
  btnDelete1.setBorder(BorderFactory.createRaisedBevelBorder());
  SPR.setBounds(new Rectangle(106, 71, 410, 75));
  SPR1.setBounds(new Rectangle(111, 99, 407, 53));
  txtRemarks1.setText("");
  txtRemarks.setFont(new java.awt.Font("Tahoma", 1, 11));
  txtRemarks1.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnSave1.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    if(checkInFields()==true)
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
      if (editInData()==false)
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
     lblRec1.setText("");
    }
   }
  });
  btnSave1.setBounds(new Rectangle(12, 39, 91, 28));
  btnSave1.setIcon(new ImageIcon("images/Save16.gif"));
  btnSave1.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnSave1.setText("SAVE");
  btnSave1.setMnemonic('S');
  btnSave1.setBorder(BorderFactory.createRaisedBevelBorder());
  btnCancel1.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    setInButton(true);
    setFields(false);
    getConnected();
    isAdd = false;
    lblRec1.setText("");
   }
  });
  btnCancel1.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnCancel1.setMnemonic('C');
  btnCancel1.setText("CANCEL");
  btnCancel1.setBounds(new Rectangle(108, 39, 91, 28));
  btnCancel1.setBorder(BorderFactory.createRaisedBevelBorder());
  btnEdit1.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    setInButton(false);
    setFields(true);
    txtIN.setEnabled(false);
    btnDT.setEnabled(false);
    cboBU.requestFocus();
    lblRec1.setText(" Edit Record... ");
   }
  });
  btnEdit1.setMnemonic('E');
  btnEdit1.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnEdit1.setText("EDIT");
  btnEdit1.setBounds(new Rectangle(108, 39, 91, 28));
  btnEdit1.setBorder(BorderFactory.createRaisedBevelBorder());
  lblHead.setBounds(new Rectangle(0, 0, 534, 60));
  lblHead.setIcon(imgHead);
  pnlFieldsPO.add(txtEmpCode, null);
  pnlFieldsPO.add(lblIN, null);
  pnlFieldsPO.add(txtIN, null);
  pnlFieldsPO.add(cboBU, null);
  pnlFieldsPO.add(lblBU, null);
  pnlFieldsPO.add(lblRem, null);
  pnlFieldsPO.add(SPR, null);
  pnlFieldsPO.add(txtDate, null);
  pnlFieldsPO.add(btnDT, null);
  pnlFieldsPO.add(lblAmount, null);
  pnlFieldsPO.add(txtAmount, null);
  pnlFieldsPO.add(lblDate, null);
  TP.add(pnlRec, "RECEIVE");
  SPR.getViewport().add(txtRemarks, null);
  pnlRB.add(btnNew, null);
  pnlRB.add(btnNext1, null);
  pnlRB.add(btnLast1, null);
  pnlRB.add(btnFirst1, null);
  pnlRB.add(btnPrevious1, null);
  pnlRB.add(lblRec1, null);
  pnlRB.add(btnClose1, null);
  pnlRB.add(btnDelete1, null);
  pnlRB.add(btnCI, null);
  pnlRB.add(btnEdit1, null);
  pnlRB.add(btnSave1, null);
  pnlRB.add(btnCancel1, null);
  pnlR.add(pnlFieldsPO, null);
  pnlR.add(pnlRB, null);

  pnlReceive.add(txtBAL, null);
  pnlReceive.add(lblBAL, null);
  pnlReceive.add(lblST, null);
  pnlReceive.add(txtST, null);
  pnlReceive.add(btnST, null);
  pnlReceive.add(lblSD, null);
  pnlReceive.add(txtSD, null);
  pnlReceive.add(btnSD, null);
  pnlReceive.add(lblRD, null);
  pnlReceive.add(txtRD, null);
  pnlReceive.add(btnRD, null);
  pnlReceive.add(lblRF, null);
  pnlReceive.add(txtRF, null);
  pnlReceive.add(btnRF, null);
  pnlReceive.add(btnRB, null);
  pnlReceive.add(txtRB, null);
  pnlReceive.add(lblRB, null);
  pnlReceive.add(lblRem1, null);
  pnlReceive.add(SPR1, null);
  pnlRec.add(pnlButtonsRC, null);
  SPR1.getViewport().add(txtRemarks1, null);
  pnlRec.add(pnlReceive, null);

  pnlButtonsRC.add(btnEdit, null);
  pnlButtonsRC.add(btnRefresh, null);
  pnlButtonsRC.add(btnDelete, null);
  pnlButtonsRC.add(lblRec, null);
  pnlButtonsRC.add(btnClose, null);
  pnlButtonsRC.add(btnCancel, null);
  pnlButtonsRC.add(btnPrevious, null);
  pnlButtonsRC.add(btnLast, null);
  pnlButtonsRC.add(btnNext, null);
  pnlButtonsRC.add(btnFirst, null);
  pnlButtonsRC.add(btnSave, null);

  pnlVD.add(pnlTab, null);
  pnlTab.add(sp, null);
  pnlVD.add(pnlFieldsRE, null);
  TP.add(pnlR, "RAISE");
  sp.add(Table, null);
  TP.add(pnlVD, "VIEW DATA");
  this.getContentPane().add(TP, null);
  this.getContentPane().add(pnlSearch, null);
  this.getContentPane().add(lblHead, null);
  pnlSearch.add(btnGo, null);
  pnlSearch.add(lblPicture, null);
  pnlSearch.add(txtSearch, null);
  pnlSearch.add(cboSearch, null);

  getComboData("SELECT * FROM BU ORDER BY BU;", cboBU);

  setButton(true);
  setInButton(true);
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
   indcon.Connect();
  }catch(RemoteException re){ System.out.println("Client [frmMBbgt]: Open Error");System.out.println("Error: "+re.getMessage());}

  //DISPLAY DATA RMI
  try
  {
   ind = indcon.moveNext();
   display();
  }catch(RemoteException re){ System.out.println("Client [frmMBbgt]: Show Error");System.out.println("Error: "+re.getMessage());}

  SQL="SELECT * FROM Indents ORDER BY IndentNo;";
  getTableData(SQL);
 }

 /**
 * Sets Button States
 *
 */

 public void setButton(boolean btnValue)
 {
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
  btnSD.setEnabled(!btnValue);
  btnRD.setEnabled(!btnValue);
  btnRF.setEnabled(!btnValue);
  btnRF.setEnabled(!btnValue);
  btnRB.setEnabled(!btnValue);
  btnST.setEnabled(!btnValue);
 }

 /**
 * Sets Button States
 *
 */

 public void setInButton(boolean btnValue)
 {
  btnNew.setVisible(btnValue);
  btnEdit1.setVisible(btnValue);
  btnCI.setEnabled(btnValue);
  btnSave1.setVisible(!btnValue);
  btnCancel1.setVisible(!btnValue);
  btnDelete1.setEnabled(btnValue);
  btnClose1.setEnabled(btnValue);
  btnFirst1.setEnabled(btnValue);
  btnPrevious1.setEnabled(btnValue);
  btnNext1.setEnabled(btnValue);
  btnLast1.setEnabled(btnValue);
  btnGo.setEnabled(btnValue);

  btnDT.setEnabled(!btnValue);
 }

 /**
 * Sets Fields States
 *
 */

 public void setFields(boolean txtValue)
 {
  txtIN.setEnabled(txtValue);
  cboBU.setEnabled(txtValue);
  txtAmount.setEnabled(txtValue);
  txtRemarks.setEnabled(txtValue);

  txtBAL.setEnabled(txtValue);
  txtRemarks1.setEnabled(txtValue);
 }

 /**
 * Clear Text From Fields
 *
 */

 public void clearFields()
 {
  txtRF.setText("");
  txtRD.setText("");
  txtRB.setText("");
  txtBAL.setText("");
  txtSD.setText("");
  txtST.setText("");
 }

 /**
 * Clear Text From Fields
 *
 */

 public void clearInFields()
 {
  txtIN.setText("");
  txtDate.setText("");
  txtAmount.setText("");
  txtRemarks.setText("");
 }

 /**
 * Display Data
 *
 */

 public void display()
 {
  txtIN.setText(ind.getIndentNo());
  cboBU.setSelectedItem(ind.getBU());
  txtDate.setText(ind.getDate());
  txtAmount.setText(ind.getAmount());
  txtRF.setText(ind.getRecFrom());
  txtRD.setText(ind.getRecDate());
  txtRB.setText(ind.getRecBy());
  txtBAL.setText(ind.getBalance());
  txtSD.setText(ind.getSubmtDate());
  txtST.setText(ind.getSubmtTo());
  txtRemarks.setText(ind.getRemarks());
 }

 /**
 * Checks the Fields
 *
 * @return boolean true or false value
 */

 public boolean checkFields()
 {
  if (txtIN.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide an Indent No.!","Missing Information",JOptionPane.ERROR_MESSAGE);txtIN.requestFocus();return false;}
  if (txtAmount.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Amount!","Missing Information",JOptionPane.ERROR_MESSAGE);txtAmount.requestFocus();return false;}
  if (txtRF.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide the Employee from whom Amount is received!","Missing Information",JOptionPane.ERROR_MESSAGE);txtRF.requestFocus();return false;}
  if (txtRD.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Amount Receive Date!","Missing Information",JOptionPane.ERROR_MESSAGE);txtRD.requestFocus();return false;}
  if (txtRB.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide whom has received the Amount!","Missing Information",JOptionPane.ERROR_MESSAGE);txtRB.requestFocus();return false;}
  if (txtBAL.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Balance!","Missing Information",JOptionPane.ERROR_MESSAGE);txtBAL.requestFocus();return false;}
  if (txtSD.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Submition Date!","Missing Information",JOptionPane.ERROR_MESSAGE);txtSD.requestFocus();return false;}
  if (txtST.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide the employee to whom the payment is submitted!","Missing Information",JOptionPane.ERROR_MESSAGE);txtST.requestFocus();return false;}
  if (txtRemarks.getText().equals("")){txtRemarks.setText("-");}
  return true;
 }

 /**
 * Checks the Fields
 *
 * @return boolean true or false value
 */

 public boolean checkInFields()
 {
  if (txtIN.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide an Indent No.!","Missing Information",JOptionPane.ERROR_MESSAGE);txtIN.requestFocus();return false;}
  if (txtAmount.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Amount!","Missing Information",JOptionPane.ERROR_MESSAGE);txtAmount.requestFocus();return false;}
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
  ind.setIndentNo(txtIN.getText());
  ind.setBU(cboBU.getSelectedItem()+"");
  ind.setDate(txtDate.getText());
  ind.setAmount(txtAmount.getText());
  ind.setRecFrom("-");
  ind.setRecDate(txtDate.getText());
  ind.setRecBy("-");
  ind.setBalance("0");
  ind.setSubmtDate(txtDate.getText());
  ind.setSubmtTo("-");
  ind.setRemarks(txtRemarks.getText());
  try
  {
   savesucc = indcon.insertData(ind);
   StartWorking("ADDING NEW RECORD");
   JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
   getConnected();

  }catch(RemoteException re)
  {
   System.out.println("Client [frmIndent]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmIndent]: "+re.getMessage(),
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

 public boolean editInData()
 {//Edit Data
  boolean updatesucc=false;

  //INITIALISE USER OBJECT...
  ind.setIndentNo(txtIN.getText());
  ind.setBU(cboBU.getSelectedItem()+"");
  ind.setDate(txtDate.getText());
  ind.setAmount(txtAmount.getText());
  ind.setRecFrom("-");
  ind.setRecDate(txtDate.getText());
  ind.setRecBy("-");
  ind.setBalance("0");
  ind.setSubmtDate(txtDate.getText());
  ind.setSubmtTo("-");
  ind.setRemarks(txtRemarks.getText());

  try
  {
   updatesucc = indcon.updateData(ind);
   StartWorking("UPDATING RECORD");
   JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
   getConnected();

  }catch(RemoteException re)
  {
   System.out.println("Client [frmIndent]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmIndent]: "+re.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
   return updatesucc;
  }

  return updatesucc;
 }//Edit Data

 /**
 * Requests Server to Update a Specific Record
 *
 * @return boolean true or false value
 */

 public boolean editData()
 {//Edit Data
  boolean updatesucc=false;

  //INITIALISE USER OBJECT...
  ind.setIndentNo(txtIN.getText());
  ind.setBU(cboBU.getSelectedItem()+"");
  ind.setDate(txtDate.getText());
  ind.setAmount(txtAmount.getText());
  ind.setRecFrom(txtRF.getText());
  ind.setRecDate(txtRD.getText());
  ind.setRecBy(txtRB.getText());
  ind.setBalance(txtBAL.getText());
  ind.setSubmtDate(txtSD.getText());
  ind.setSubmtTo(txtST.getText());
  ind.setRemarks(txtRemarks.getText());

  try
  {
   updatesucc = indcon.updateData(ind);
   StartWorking("UPDATING RECORD");
   JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
   getConnected();

  }catch(RemoteException re)
  {
   System.out.println("Client [frmIndent]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmIndent]: "+re.getMessage(),
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
  String strQuery = "DELETE FROM Indents WHERE IndentNo='" + txtIN.getText() + "';";

  int yn;
  yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
  JOptionPane.YES_NO_OPTION, 3, imgQ);

  if (yn == JOptionPane.YES_OPTION)
  {
   try
   {
    indcon.DeleteData(strQuery);
    StartWorking("DELETING RECORD");
    JOptionPane.showMessageDialog(null, "Server: Record Deleted!", "Information", 1);
    clearFields();
    clearInFields();
    getConnected();

   }catch(RemoteException re)
   {
    System.out.println("Client [frmIndent]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmIndent]: "+re.getMessage(),
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
   System.out.println("Client [frmIndent]: GET TABLE DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmIndent]: "+re.getMessage(),
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
     txtIN.setText(SelRow[0][0]);cboBU.setSelectedItem(SelRow[0][1]);txtDate.setText(SelRow[0][2]);txtAmount.setText(SelRow[0][3]);txtRF.setText(SelRow[0][4]);txtRD.setText(SelRow[0][5]);txtRB.setText(SelRow[0][6]);txtBAL.setText(SelRow[0][7]);txtSD.setText(SelRow[0][8]);txtST.setText(SelRow[0][9]);txtRemarks.setText(SelRow[0][10]);txtRemarks1.setText(SelRow[0][10]);
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
  int[] sz = new int[11];
  sz[0]=100;sz[1]=100;sz[2]=60;sz[3]=70;sz[4]=120;sz[5]=60;sz[6]=120;sz[7]=70;
  sz[8]=60;sz[9]=120;sz[10]=200;
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
   SQLString = "SELECT * FROM Indents WHERE " + cboSearch.getSelectedItem().toString() + "='" + txtSearch.getText() + "';";

   try
   {
    if (indcon.isFound(SQLString))
    {
     ind = indcon.SearchData(SQLString);
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
   {System.out.println("Client [frmIndent]: SEARCH DATA Error");System.out.println("Error: "+re.getMessage());}
  }

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
 * Query Server Specific Column and Sets Combo Data
 *  @param String strQuery, JComboBox cbo
 *
 */

 private void getComboData(String Query, JComboBox cbo)
 {
  String ComboData = new String("");
  String strQuery = Query;
  Vector tmp = new Vector();

  try
  {
   tmp = ctccon.getComboData(strQuery,1);

   for (int i = 0;i<tmp.size();i++)
   {
    ComboData = new String("");
    ComboData = tmp.elementAt(i).toString();
    cbo.addItem(ComboData);
   }

  }catch(RemoteException re)
  {
   System.out.println("Client [frmIndent]: GET COMBO DATA Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "GET COMBO DATA Error\nClient [frmIndent]: "+re.getMessage(),
   "Error", JOptionPane.ERROR_MESSAGE);
  }
 }

 void btnRD_actionPerformed(ActionEvent e)
 {
  frmDate fd = new frmDate("Select Received Date");
  fd.setSize(new Dimension(212, 163));
  fd.setVisible(true);
  String SDate = fd.createDate();
  txtRD.setText(SDate);
 }

 void btnSD_actionPerformed(ActionEvent e)
 {
  frmDate fd = new frmDate("Select Submitted Date");
  fd.setSize(new Dimension(212, 163));
  fd.setVisible(true);
  String SDate = fd.createDate();
  txtSD.setText(SDate);
 }

 void btnRF_actionPerformed(ActionEvent e)
 {
  frmList lst = new frmList("ACOUNTS EMPLOYEES",
  "SELECT EmpCode, Name, Designation, Department, Ext FROM Employees WHERE Department='Accounts' ORDER BY EmpCode;");
  lst.setVisible(true);

  String t[][] = lst.getType();
  if(t!=null)
  {
   txtRF.setText(t[0][1]);
  }
 }

 void btnST_actionPerformed(ActionEvent e)
 {
  frmList lst = new frmList("IS EMPLOYEES", "SELECT EmpCode, Name, Designation, Department, Ext FROM Employees WHERE Department='IS' ORDER BY EmpCode;");
  lst.setVisible(true);

  String t[][] = lst.getType();
  if(t!=null)
  {
   txtST.setText(t[0][1]);
  }
 }

 void btnRB_actionPerformed(ActionEvent e)
 {
  frmList lst = new frmList("IS EMPLOYEES", "SELECT EmpCode, Name, Designation, Department, Ext FROM Employees WHERE Department='IS' ORDER BY EmpCode;");
  lst.setVisible(true);

  String t[][] = lst.getType();
  if(t!=null)
  {
   txtRB.setText(t[0][1]);
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