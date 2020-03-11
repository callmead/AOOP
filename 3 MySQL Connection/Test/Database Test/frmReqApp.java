//package beximtex;
/**
 * <p>Title: BeximTex, Request Approvals</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.util.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.TableColumn;

import java.rmi.*;

public class frmReqApp extends JInternalFrame
{//Class

 String Head = null;
 int TotalCol = 0;
 int Rows = 0;
 int Columns = 0;
 String TakenBy = null;
 String BillingID;
 int BIDCounter = 0;

 Vector Col_HW = new Vector();
 Vector Col_EM = new Vector();
 Vector Col_MB = new Vector();
 Vector Col_PH = new Vector();
 Vector Col_SW = new Vector();

 Vector Rows_HW = new Vector();
 Vector Rows_EM = new Vector();
 Vector Rows_MB = new Vector();
 Vector Rows_PH = new Vector();
 Vector Rows_SW = new Vector();

 Vector ColHead = new Vector();
 Vector rows = new Vector();

 Vector Col6 = new Vector();
 Vector Rows6 = new Vector();

 TitledBorder titledBorder1;

 JTabbedPane TP = new JTabbedPane();

 JPanel pnlHardware = new JPanel();
 JPanel pnlEmail = new JPanel();
 JPanel pnlMobile = new JPanel();
 JPanel pnlPhone = new JPanel();
 JPanel pnlSoftware = new JPanel();
 JPanel pnlTop = new JPanel();

 JTable TblHardware = new JTable();
 JTable TblEmail = new JTable();
 JTable TblMobile = new JTable();
 JTable TblPhone = new JTable();
 JTable TblSoftware = new JTable();
 JLabel lblRemHW = new JLabel();
 JLabel lblEmpCodeHW = new JLabel();
 JLabel lblRemPH = new JLabel();
 JLabel lblEmpCodePH = new JLabel();
 JLabel lblRemMB = new JLabel();
 JLabel lblRemSW = new JLabel();

 JToggleButton btnApproveHW = new JToggleButton();
 JToggleButton btnApproveE = new JToggleButton();
 JToggleButton btnApproveMB = new JToggleButton();
 JToggleButton btnApprovePH = new JToggleButton();
 JToggleButton btnApproveSW = new JToggleButton();

 JLabel lblEmpCodeMB = new JLabel();
 JLabel lblEmpCodeSW = new JLabel();

 JLabel lblRemEM = new JLabel();

 JScrollPane SPHardwareTbl = new JScrollPane();
 JScrollPane SPEmailTbl = new JScrollPane();
 JScrollPane SPMobileTbl = new JScrollPane();
 JScrollPane SPPhoneTbl = new JScrollPane();
 JScrollPane SPSoftwareTbl = new JScrollPane();

 JTextField txtRemEM = new JTextField();
 JTextField txtRemHW = new JTextField();
 JTextField txtEmpCodeHW = new JTextField();
 JTextField txtEmpCodePH = new JTextField();
 JTextField txtRemPH = new JTextField();
 JTextField txtEmpCodeMB = new JTextField();
 JTextField txtRemMB = new JTextField();
 JTextField txtEmpCodeSW = new JTextField();
 JTextField txtRemSW = new JTextField();

 JToggleButton btnHoldE = new JToggleButton();
 JToggleButton btnCloseE = new JToggleButton();
 JToggleButton btnPrintE = new JToggleButton();
 JToggleButton btnCloseHW = new JToggleButton();
 JToggleButton btnPrintHW = new JToggleButton();
 JToggleButton btnHoldHW = new JToggleButton();
 JToggleButton btnPrintPH = new JToggleButton();
 JToggleButton btnClosePH = new JToggleButton();
 JToggleButton btnHoldPH = new JToggleButton();
 JToggleButton btnPrintMB = new JToggleButton();
 JToggleButton btnCloseMB = new JToggleButton();
 JToggleButton btnHoldMB = new JToggleButton();
 JToggleButton btnPrintSW = new JToggleButton();
 JToggleButton btnCloseSw = new JToggleButton();
 JToggleButton btnHoldSW = new JToggleButton();

 //**************************************************************
 //RMI Declare Server Object
 CommonTableController ctccon;
 //**************************************************************

 int yn;
 String SQL = "";
 String SelRow[][];

 String SQLEM = "SELECT TransactionID, EmpCode, Date, Remarks, Email1, Email2, DeptApp as 'Status' FROM Email WHERE DeptApp<>'YES';";
 int[] szEM = new int[7];
 String SQLHW = "SELECT TransactionID, EmpCode, Date, Description, Need, Spec, DeptApp as 'Status' FROM Hardware WHERE DeptApp<>'YES';";
 int[] szHW = new int[7];
 String SQLMB = "SELECT TransactionID, EmpCode, Date, Q1, Q2, Q2a, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10, Q11, Q12, Q13, Q13a, Q14, DeptApp as 'Status' FROM Mobile WHERE DeptApp<>'YES';";
 int[] szMB = new int[20];
 String SQLPH = "SELECT TransactionID, EmpCode, Date, RequestType, Need, DeptApp as 'Status' FROM Phone WHERE DeptApp<>'YES';";
 int[] szPH = new int[6];
 String SQLSW = "SELECT TransactionID, EmpCode, Date, RequestType, Description, DeptApp as 'Status' FROM Software WHERE DeptApp<>'YES';";
 int[] szSW = new int[6];

 String SQLISEM = "SELECT TransactionID, EmpCode, Date, Remarks, Email1, Email2, ISApp as 'Status' FROM Email WHERE DeptApp='YES' AND ISApp<>'YES';";
 int[] szISEM = new int[7];
 String SQLISHW = "SELECT TransactionID, EmpCode, Date, Description, Need, Spec, ISApp as 'Status' FROM Hardware WHERE DeptApp='YES' AND ISApp<>'YES';";
 int[] szISHW = new int[7];
 String SQLISMB = "SELECT TransactionID, EmpCode, Date, Q1, Q2, Q2a, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10, Q11, Q12, Q13, Q13a, Q14, ISApp as 'Status' FROM Mobile WHERE DeptApp='YES' AND ISApp<>'YES';";
 int[] szISMB = new int[20];
 String SQLISPH = "SELECT TransactionID, EmpCode, Date, RequestType, Need, ISApp as 'Status' FROM Phone WHERE DeptApp='YES' AND ISApp<>'YES';";
 int[] szISPH = new int[6];
 String SQLISSW = "SELECT TransactionID, EmpCode, Date, RequestType, Description, ISApp as 'Status' FROM Software WHERE DeptApp='YES' AND ISApp<>'YES';";
 int[] szISSW = new int[6];

 String Table = "";
 String ST_TB_EM = "Email";
 String ST_TB_HW = "Hardware";
 String ST_TB_MB = "Mobile";
 String ST_TB_PH = "Phone";
 String ST_TB_SW = "Software";

 String SelectedRowArray[][];
 String UpdateQuery = null;
 String EC = null;
 String UN = null;
 String T = null;

 boolean isISApp = false;

 ImageIcon imgIco = new ImageIcon("./Images/popup.gif");
 ImageIcon imgQ = new ImageIcon("./Images/Question32.png");

 public frmReqApp(String ec, String un, String t, boolean isApp)
 {//Cons
  EC = ec;
  UN = un;
  T = t;
  isISApp = isApp;

  try {jbInit();}
  catch (Exception e) {System.exit(0);}
 }//Cons

 private void jbInit() throws Exception
 {//jbInit

  //**************************************************************
  //Connection: Connects with Server
  try
  {
   ctccon = (CommonTableController)Naming.lookup(new ReadHost().getHost() + "CommonTableController");
  }catch(Exception ec)
  {
   System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
   System.out.println("Error: "+ec.getMessage());
   JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
   "Error", JOptionPane.ERROR_MESSAGE);
   System.exit(0);
  }
  System.out.println("\n******************************\n CLIENT READY [frmReqApp] \n******************************\n");
  //**************************************************************

  pnlTop.setLayout(null);
  pnlTop.setBounds(new Rectangle(9, 2, 520, 444));
  pnlTop.setBorder(titledBorder1);
  pnlTop.setBackground(Color.white);

  pnlHardware.setBackground(Color.white);
  pnlHardware.setLayout(null);

  pnlEmail.setBackground(Color.white);
  pnlEmail.setLayout(null);

  pnlMobile.setBackground(Color.white);
  pnlMobile.setLayout(null);

  pnlPhone.setBackground(Color.white);
  pnlPhone.setLayout(null);

  pnlSoftware.setBackground(Color.white);
  pnlSoftware.setLayout(null);

  TP.setTabPlacement(JTabbedPane.TOP);
  TP.setBackground(Color.BLACK);
  TP.setFont(new java.awt.Font("Monospaced", 1, 12));
  TP.setForeground(Color.WHITE);
  TP.setDebugGraphicsOptions(0);
  TP.setBounds(new Rectangle(5, 10, 508, 426));

  lblRemEM.setText("REMARKS");
  lblRemEM.setBounds(new Rectangle(8, 326, 63, 23));
  lblRemEM.setFont(new java.awt.Font("Tahoma", 1, 12));
  lblRemHW.setFont(new java.awt.Font("Tahoma", 1, 12));
  lblRemHW.setBounds(new Rectangle(8, 326, 63, 23));
  lblRemHW.setText("REMARKS");
  lblEmpCodeHW.setText("EMPLOYEE CODE");
  lblEmpCodeHW.setBounds(new Rectangle(316, 326, 100, 23));
  lblEmpCodeHW.setFont(new java.awt.Font("Tahoma", 1, 12));
  lblRemPH.setText("REMARKS");
  lblRemPH.setBounds(new Rectangle(8, 326, 63, 23));
  lblRemPH.setFont(new java.awt.Font("Tahoma", 1, 12));
  lblEmpCodePH.setFont(new java.awt.Font("Tahoma", 1, 12));
  lblEmpCodePH.setBounds(new Rectangle(316, 326, 100, 23));
  lblEmpCodePH.setText("EMPLOYEE CODE");
  lblRemMB.setText("REMARKS");
  lblRemMB.setBounds(new Rectangle(8, 326, 63, 23));
  lblRemMB.setFont(new java.awt.Font("Tahoma", 1, 12));
  lblEmpCodeMB.setFont(new java.awt.Font("Tahoma", 1, 12));
  lblEmpCodeMB.setBounds(new Rectangle(316, 326, 100, 23));
  lblEmpCodeMB.setText("EMPLOYEE CODE");
  lblRemSW.setText("REMARKS");
  lblRemSW.setBounds(new Rectangle(8, 326, 63, 23));
  lblRemSW.setFont(new java.awt.Font("Tahoma", 1, 12));
  lblEmpCodeSW.setFont(new java.awt.Font("Tahoma", 1, 12));
  lblEmpCodeSW.setBounds(new Rectangle(316, 326, 100, 23));
  lblEmpCodeSW.setText("EMPLOYEE CODE");

  txtEmpCodeSW.setEnabled(false);
  txtEmpCodeMB.setEnabled(false);
  txtRemEM.setText("");
  txtRemEM.setBounds(new Rectangle(74, 327, 412, 20));
  txtRemEM.setCaretColor(Color.blue);
  txtRemEM.setEnabled(true);
  txtRemEM.setFont(new Font("Tahoma", 1, 12));
  txtRemHW.setEnabled(true);
  txtRemHW.setFont(new Font("Tahoma", 1, 12));
  txtRemHW.setCaretColor(Color.blue);
  txtRemHW.setBounds(new Rectangle(74, 327, 233, 20));
  txtRemHW.setText("");
  txtEmpCodeHW.setBounds(new Rectangle(421, 327, 77, 20));
  txtEmpCodeHW.setText("");
  txtEmpCodeHW.setCaretColor(Color.blue);
  txtEmpCodeHW.setFont(new Font("Tahoma", 1, 12));
  txtEmpCodeHW.setEnabled(false);
  txtEmpCodePH.setEnabled(false);
  txtEmpCodePH.setFont(new Font("Tahoma", 1, 12));
  txtEmpCodePH.setCaretColor(Color.blue);
  txtEmpCodePH.setText("");
  txtEmpCodePH.setBounds(new Rectangle(421, 327, 77, 20));
  txtRemPH.setText("");
  txtRemPH.setBounds(new Rectangle(74, 327, 233, 20));
  txtRemPH.setCaretColor(Color.blue);
  txtRemPH.setEnabled(true);
  txtRemPH.setFont(new Font("Tahoma", 1, 12));
  txtEmpCodeMB.setFont(new Font("Tahoma", 1, 12));
  txtEmpCodeMB.setCaretColor(Color.blue);
  txtEmpCodeMB.setEditable(true);
  txtEmpCodeMB.setText("");
  txtEmpCodeMB.setBounds(new Rectangle(421, 327, 77, 20));
  txtRemMB.setText("");
  txtRemMB.setBounds(new Rectangle(74, 327, 233, 20));
  txtRemMB.setCaretColor(Color.blue);
  txtRemMB.setEnabled(true);
  txtRemMB.setFont(new Font("Tahoma", 1, 12));
  txtEmpCodeSW.setFont(new Font("Tahoma", 1, 12));
  txtEmpCodeSW.setCaretColor(Color.blue);
  txtEmpCodeSW.setEditable(true);
  txtEmpCodeSW.setText("");
  txtEmpCodeSW.setBounds(new Rectangle(421, 327, 77, 20));
  txtRemSW.setText("");
  txtRemSW.setBounds(new Rectangle(74, 327, 233, 20));
  txtRemSW.setCaretColor(Color.blue);
  txtRemSW.setFont(new Font("Tahoma", 1, 12));

  SPHardwareTbl.setBounds(new Rectangle(3, 5, 497, 311));
  SPEmailTbl.setBounds(new Rectangle(3, 5, 497, 311));
  SPMobileTbl.setBounds(new Rectangle(3, 5, 497, 311));
  SPPhoneTbl.setBounds(new Rectangle(3, 5, 497, 311));
  SPSoftwareTbl.setBounds(new Rectangle(3, 5, 497, 311));

  btnApproveE.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnApproveE.setText("APPROVE");
  btnApproveE.setBounds(new Rectangle(12, 362, 117, 25));
  btnApproveE.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    SelectedRowArray = null;
    int x[] = TblEmail.getSelectedRows();
    if (x.length >= 1)
    {
     if (txtRemEM.getText().equals(""))
     {
      txtRemEM.setText("-");
     }

     SelectedRowArray = new String[x.length][TotalCol];

     for (int i = 0; i < x.length; i++)
     {
      for (int j = 0; j < TotalCol; j++)
      {
       SelectedRowArray[i][j] = TblEmail.getValueAt(x[i], j).toString();
       //System.out.println(TblEmail.getValueAt(x[i], j).toString());
      }

      if (isISApp)
      {
       UpdateQuery = "UPDATE Email SET ISApp='YES', DeptComm='" +
       txtRemEM.getText() + "',ISAppBy='" + EC +
       "' WHERE TransactionID='" +
       (TblEmail.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
      else
      {
       UpdateQuery = "UPDATE Email SET DeptApp='YES', DeptComm='" +
       txtRemEM.getText() + "',DeptAppBy='" + EC +
       "' WHERE TransactionID='" +
       (TblEmail.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
     }
     ExecuteQueryNow();
    }
    else if (x.length < 1)
    {
     JOptionPane.showMessageDialog(null, "Please Select a Request!!!",
     "Information Required...",
     JOptionPane.ERROR_MESSAGE);
    }
   }
  });

  btnApproveHW.setBounds(new Rectangle(12, 362, 117, 25));
  btnApproveHW.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnApproveHW.setText("APPROVE");
  btnApproveHW.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    SelectedRowArray = null;
    int x[] = TblHardware.getSelectedRows();
    if (x.length >= 1)
    {
     if (txtRemHW.getText().equals(""))
     {
      txtRemHW.setText("-");
     }

     SelectedRowArray = new String[x.length][TotalCol];

     for (int i = 0; i < x.length; i++)
     {
      for (int j = 0; j < TotalCol; j++)
      {
       SelectedRowArray[i][j] = TblHardware.getValueAt(x[i], j).toString();
       //System.out.println(TblHardware.getValueAt(x[i], j).toString());
      }

      if (isISApp)
      {
       UpdateQuery = "UPDATE Hardware SET ISApp='YES', DeptComm='" +
       txtRemHW.getText() + "',ISAppBy='" + txtEmpCodeHW.getText() +
       "' WHERE TransactionID='" +
       (TblHardware.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
      else
      {
       UpdateQuery = "UPDATE Hardware SET DeptApp='YES', DeptComm='" +
       txtRemHW.getText() + "',DeptAppBy='" + txtEmpCodeHW.getText() +
       "' WHERE TransactionID='" +
       (TblHardware.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }

     }
     ExecuteQueryNow();
    }
    else if (x.length < 1)
    {
     JOptionPane.showMessageDialog(null, "Please Select a Request!!!",
     "Information Required...",
     JOptionPane.ERROR_MESSAGE);
    }
   }
  });

  btnApproveMB.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnApproveMB.setText("APPROVE");
  btnApproveMB.setBounds(new Rectangle(12, 362, 117, 25));
  btnApproveMB.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    SelectedRowArray = null;
    int x[] = TblMobile.getSelectedRows();
    if (x.length >= 1)
    {
     if (txtRemMB.getText().equals(""))
     {
      txtRemMB.setText("-");
     }

     SelectedRowArray = new String[x.length][TotalCol];

     for (int i = 0; i < x.length; i++)
     {
      for (int j = 0; j < TotalCol; j++)
      {
       SelectedRowArray[i][j] = TblMobile.getValueAt(x[i], j).toString();
       //System.out.println(TblMobile.getValueAt(x[i], j).toString());
      }
      if (isISApp)
      {
       UpdateQuery = "UPDATE Mobile SET ISApp='YES', DeptComm='" +
       txtRemMB.getText() + "',ISAppBy='" + txtEmpCodeMB.getText() +
       "' WHERE TransactionID='" +
       (TblMobile.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
      else
      {
       UpdateQuery = "UPDATE Mobile SET DeptApp='YES', DeptComm='" +
       txtRemMB.getText() + "',DeptAppBy='" + txtEmpCodeMB.getText() +
       "' WHERE TransactionID='" +
       (TblMobile.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
     }
     ExecuteQueryNow();
    }
    else if (x.length < 1)
    {
     JOptionPane.showMessageDialog(null, "Please Select a Request!!!",
     "Information Required...",
     JOptionPane.ERROR_MESSAGE);
    }
   }
  });

  btnApprovePH.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnApprovePH.setText("APPROVE");
  btnApprovePH.setBounds(new Rectangle(12, 362, 117, 25));
  btnApprovePH.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    SelectedRowArray = null;
    int x[] = TblPhone.getSelectedRows();
    if (x.length >= 1)
    {
     if (txtRemPH.getText().equals(""))
     {
      txtRemPH.setText("-");
     }

     SelectedRowArray = new String[x.length][TotalCol];

     for (int i = 0; i < x.length; i++)
     {
      for (int j = 0; j < TotalCol; j++)
      {
       SelectedRowArray[i][j] = TblPhone.getValueAt(x[i], j).toString();
       //System.out.println(TblPhone.getValueAt(x[i], j).toString());
      }
      if (isISApp)
      {
       UpdateQuery = "UPDATE Phone SET ISApp='YES', DeptComm='" +
       txtRemPH.getText() + "',ISAppBy='" + txtEmpCodePH.getText() +
       "' WHERE TransactionID='" +
       (TblPhone.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
      else
      {
       UpdateQuery = "UPDATE Phone SET DeptApp='YES', DeptComm='" +
       txtRemPH.getText() + "',DeptAppBy='" + txtEmpCodePH.getText() +
       "' WHERE TransactionID='" +
       (TblPhone.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
     }
     ExecuteQueryNow();
    }
    else if (x.length < 1)
    {
     JOptionPane.showMessageDialog(null, "Please Select a Request!!!",
     "Information Required...",
     JOptionPane.ERROR_MESSAGE);
    }
   }
  });

  btnApproveSW.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnApproveSW.setText("APPROVE");
  btnApproveSW.setBounds(new Rectangle(12, 362, 117, 25));
  btnApproveSW.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    SelectedRowArray = null;
    int x[] = TblSoftware.getSelectedRows();
    if (x.length >= 1)
    {
     if (txtRemSW.getText().equals(""))
     {
      txtRemSW.setText("-");
     }

     SelectedRowArray = new String[x.length][TotalCol];

     for (int i = 0; i < x.length; i++)
     {
      for (int j = 0; j < TotalCol; j++)
      {
       SelectedRowArray[i][j] = TblSoftware.getValueAt(x[i], j).toString();
       //System.out.println(TblSoftware.getValueAt(x[i], j).toString());
      }
      //Checking DeptHead of IS
      if (isISApp)
      {
       UpdateQuery = "UPDATE Software SET ISApp='YES', DeptComm='" +
       txtRemSW.getText() + "',ISAppBy='" + txtEmpCodeSW.getText() +
       "' WHERE TransactionID='" +
       (TblSoftware.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
      else
      {
       UpdateQuery = "UPDATE Software SET DeptApp='YES', DeptComm='" +
       txtRemSW.getText() + "',DeptAppBy='" + txtEmpCodeSW.getText() +
       "' WHERE TransactionID='" +
       (TblSoftware.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
     }
     ExecuteQueryNow();
    }
    else if (x.length < 1)
    {
     JOptionPane.showMessageDialog(null, "Please Select a Request!!!",
     "Information Required...",
     JOptionPane.ERROR_MESSAGE);
    }
   }
  });

  btnHoldE.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    SelectedRowArray = null;
    int x[] = TblEmail.getSelectedRows();
    if (x.length >= 1)
    {
     if (txtRemEM.getText().equals(""))
     {
      txtRemEM.setText("-");
     }

     SelectedRowArray = new String[x.length][TotalCol];

     for (int i = 0; i < x.length; i++)
     {
      for (int j = 0; j < TotalCol; j++)
      {
       SelectedRowArray[i][j] = TblEmail.getValueAt(x[i], j).toString();
       //System.out.println(TblEmail.getValueAt(x[i], j).toString());
      }

      if (isISApp)
      {
       UpdateQuery = "UPDATE Email SET ISApp='HOLD', DeptComm='" +
       txtRemEM.getText() + "',ISAppBy='" + EC +
       "' WHERE TransactionID='" +
       (TblEmail.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
      else
      {
       UpdateQuery = "UPDATE Email SET DeptApp='HOLD', DeptComm='" +
       txtRemEM.getText() + "',DeptAppBy='" + EC +
       "' WHERE TransactionID='" +
       (TblEmail.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
     }
     ExecuteQueryNow();
    }
    else if (x.length < 1)
    {
     JOptionPane.showMessageDialog(null, "Please Select a Request!!!",
     "Information Required...",
     JOptionPane.ERROR_MESSAGE);
    }
   }
  });
  btnHoldE.setBounds(new Rectangle(132, 362, 117, 25));
  btnHoldE.setText("HOLD");
  btnHoldE.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnCloseE.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { dispose(); }
  });
  btnCloseE.setBounds(new Rectangle(372, 362, 117, 25));
  btnCloseE.setText("CLOSE");
  btnCloseE.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnPrintE.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e) {}
  });
  btnPrintE.setBounds(new Rectangle(252, 362, 117, 25));
  btnPrintE.setText("PRINT");
  btnPrintE.setMnemonic('D');
  btnPrintE.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnCloseHW.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnCloseHW.setText("CLOSE");
  btnCloseHW.setBounds(new Rectangle(372, 362, 117, 25));
  btnCloseHW.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { dispose(); }
  });
  btnPrintHW.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnPrintHW.setText("PRINT");
  btnPrintHW.setBounds(new Rectangle(252, 362, 117, 25));
  btnPrintHW.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e) {}
  });
  btnHoldHW.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnHoldHW.setText("HOLD");
  btnHoldHW.setBounds(new Rectangle(132, 362, 117, 25));
  btnHoldHW.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    SelectedRowArray = null;
    int x[] = TblHardware.getSelectedRows();
    if (x.length >= 1)
    {
     if (txtRemHW.getText().equals(""))
     {
      txtRemHW.setText("-");
     }

     SelectedRowArray = new String[x.length][TotalCol];

     for (int i = 0; i < x.length; i++)
     {
      for (int j = 0; j < TotalCol; j++)
      {
       SelectedRowArray[i][j] = TblHardware.getValueAt(x[i], j).toString();
       //System.out.println(TblHardware.getValueAt(x[i], j).toString());
      }

      if (isISApp)
      {
       UpdateQuery = "UPDATE Hardware SET ISApp='HOLD', DeptComm='" +
       txtRemHW.getText() + "',ISAppBy='" + txtEmpCodeHW.getText() +
       "' WHERE TransactionID='" +
       (TblHardware.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
      else
      {
       UpdateQuery = "UPDATE Hardware SET DeptApp='HOLD', DeptComm='" +
       txtRemHW.getText() + "',DeptAppBy='" + txtEmpCodeHW.getText() +
       "' WHERE TransactionID='" +
       (TblHardware.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
     }
     ExecuteQueryNow();
    }
    else if (x.length < 1)
    {
     JOptionPane.showMessageDialog(null, "Please Select a Request!!!",
     "Information Required...",
     JOptionPane.ERROR_MESSAGE);
    }
   }
  });
  btnPrintPH.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e) {}
  });
  btnPrintPH.setBounds(new Rectangle(252, 362, 117, 25));
  btnPrintPH.setText("PRINT");
  btnPrintPH.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnClosePH.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { dispose(); }
  });
  btnClosePH.setBounds(new Rectangle(372, 362, 117, 25));
  btnClosePH.setText("CLOSE");
  btnClosePH.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnHoldPH.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    SelectedRowArray = null;
    int x[] = TblPhone.getSelectedRows();
    if (x.length >= 1)
    {
     if (txtRemPH.getText().equals(""))
     {
      txtRemPH.setText("-");
     }

     SelectedRowArray = new String[x.length][TotalCol];

     for (int i = 0; i < x.length; i++)
     {
      for (int j = 0; j < TotalCol; j++)
      {
       SelectedRowArray[i][j] = TblPhone.getValueAt(x[i], j).toString();
       //System.out.println(TblPhone.getValueAt(x[i], j).toString());
      }

      if (isISApp)
      {
       UpdateQuery = "UPDATE Phone SET ISApp='HOLD', DeptComm='" +
       txtRemPH.getText() + "',ISAppBy='" + txtEmpCodePH.getText() +
       "' WHERE TransactionID='" +
       (TblPhone.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
      else
      {
       UpdateQuery = "UPDATE Phone SET DeptApp='HOLD', DeptComm='" +
       txtRemPH.getText() + "',DeptAppBy='" + txtEmpCodePH.getText() +
       "' WHERE TransactionID='" +
       (TblPhone.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
     }
     ExecuteQueryNow();
    }
    else if (x.length < 1)
    {
     JOptionPane.showMessageDialog(null, "Please Select a Request!!!",
     "Information Required...",
     JOptionPane.ERROR_MESSAGE);
    }
   }
  });
  btnHoldPH.setBounds(new Rectangle(132, 362, 117, 25));
  btnHoldPH.setText("HOLD");
  btnHoldPH.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnPrintMB.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e) {}
  });
  btnPrintMB.setBounds(new Rectangle(252, 362, 117, 25));
  btnPrintMB.setText("PRINT");
  btnPrintMB.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnCloseMB.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { dispose(); }
  });
  btnCloseMB.setBounds(new Rectangle(372, 362, 117, 25));
  btnCloseMB.setText("CLOSE");
  btnCloseMB.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnHoldMB.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    SelectedRowArray = null;
    int x[] = TblMobile.getSelectedRows();
    if (x.length >= 1)
    {
     if (txtRemMB.getText().equals(""))
     {
      txtRemMB.setText("-");
     }

     SelectedRowArray = new String[x.length][TotalCol];

     for (int i = 0; i < x.length; i++)
     {
      for (int j = 0; j < TotalCol; j++)
      {
       SelectedRowArray[i][j] = TblMobile.getValueAt(x[i], j).toString();
       //System.out.println(TblMobile.getValueAt(x[i], j).toString());
      }

      if (isISApp)
      {
       UpdateQuery = "UPDATE Mobile SET ISApp='HOLD', DeptComm='" +
       txtRemMB.getText() + "',ISAppBy='" + txtEmpCodeMB.getText() +
       "' WHERE TransactionID='" +
       (TblMobile.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
      else
      {
       UpdateQuery = "UPDATE Mobile SET DeptApp='HOLD', DeptComm='" +
       txtRemMB.getText() + "',DeptAppBy='" + txtEmpCodeMB.getText() +
       "' WHERE TransactionID='" +
       (TblMobile.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
     }
     ExecuteQueryNow();
    }
    else if (x.length < 1)
    {
     JOptionPane.showMessageDialog(null, "Please Select a Request!!!",
     "Information Required...",
     JOptionPane.ERROR_MESSAGE);
    }
   }
  });
  btnHoldMB.setBounds(new Rectangle(132, 362, 117, 25));
  btnHoldMB.setText("HOLD");
  btnHoldMB.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnPrintSW.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e) {}
  });
  btnPrintSW.setBounds(new Rectangle(252, 362, 117, 25));
  btnPrintSW.setText("PRINT");
  btnPrintSW.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnCloseSw.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { dispose(); }
  });
  btnCloseSw.setBounds(new Rectangle(372, 362, 117, 25));
  btnCloseSw.setText("CLOSE");
  btnCloseSw.setFont(new java.awt.Font("Tahoma", 1, 11));
  btnHoldSW.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    SelectedRowArray = null;
    int x[] = TblSoftware.getSelectedRows();
    if (x.length >= 1)
    {
     if (txtRemSW.getText().equals(""))
     {
      txtRemSW.setText("-");
     }

     SelectedRowArray = new String[x.length][TotalCol];

     for (int i = 0; i < x.length; i++)
     {
      for (int j = 0; j < TotalCol; j++)
      {
       SelectedRowArray[i][j] = TblSoftware.getValueAt(x[i], j).toString();
       //System.out.println(TblSoftware.getValueAt(x[i], j).toString());
      }

      if (isISApp)
      {
       UpdateQuery = "UPDATE Software SET ISApp='HOLD', DeptComm='" +
       txtRemSW.getText() + "',ISAppBy='" + txtEmpCodeSW.getText() +
       "' WHERE TransactionID='" +
       (TblSoftware.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
      else
      {
       UpdateQuery = "UPDATE Software SET DeptApp='HOLD', DeptComm='" +
       txtRemSW.getText() + "',DeptAppBy='" + txtEmpCodeSW.getText() +
       "' WHERE TransactionID='" +
       (TblSoftware.getValueAt(x[i], 0).toString()) + "'";
       //System.out.println("Query: \n" + UpdateQuery);
      }
     }
     ExecuteQueryNow();
    }
    else if (x.length < 1)
    {
     JOptionPane.showMessageDialog(null, "Please Select a Request!!!",
     "Information Required...",
     JOptionPane.ERROR_MESSAGE);
    }
   }
  });
  btnHoldSW.setBounds(new Rectangle(132, 362, 117, 25));
  btnHoldSW.setText("HOLD");
  btnHoldSW.setFont(new java.awt.Font("Tahoma", 1, 11));
  this.getContentPane().add(pnlTop, null);
  pnlTop.add(TP, null);

  titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.
  white, new Color(178, 178, 178)), "");

  pnlEmail.add(SPEmailTbl, null);
  pnlEmail.add(lblRemEM, null);
  pnlEmail.add(txtRemEM, null);
  pnlEmail.add(btnCloseE, null);
  pnlEmail.add(btnApproveE, null);
  pnlEmail.add(btnHoldE, null);
  pnlEmail.add(btnPrintE, null);

  SPEmailTbl.add(TblEmail, null);

  pnlHardware.add(SPHardwareTbl, null);
  pnlHardware.add(lblRemHW, null);
  pnlHardware.add(txtRemHW, null);
  pnlHardware.add(lblEmpCodeHW, null);
  pnlHardware.add(txtEmpCodeHW, null);
  pnlHardware.add(btnCloseHW, null);
  pnlHardware.add(btnApproveHW, null);
  pnlHardware.add(btnHoldHW, null);
  pnlHardware.add(btnPrintHW, null);

  SPHardwareTbl.getViewport().add(TblHardware, null);

  pnlMobile.add(SPMobileTbl, null);
  pnlMobile.add(btnApproveMB, null);
  pnlMobile.add(btnPrintMB, null);
  pnlMobile.add(txtEmpCodeMB, null);
  pnlMobile.add(btnCloseMB, null);
  pnlMobile.add(lblRemMB, null);
  pnlMobile.add(btnHoldMB, null);
  pnlMobile.add(lblEmpCodeMB, null);
  pnlMobile.add(txtRemMB, null);

  SPMobileTbl.add(TblMobile, null);

  pnlPhone.add(SPPhoneTbl, null);
  pnlPhone.add(btnApprovePH, null);
  pnlPhone.add(btnPrintPH, null);
  pnlPhone.add(txtEmpCodePH, null);
  pnlPhone.add(btnClosePH, null);
  pnlPhone.add(lblRemPH, null);
  pnlPhone.add(btnHoldPH, null);
  pnlPhone.add(lblEmpCodePH, null);
  pnlPhone.add(txtRemPH, null);

  SPPhoneTbl.add(TblPhone, null);

  pnlSoftware.add(SPSoftwareTbl, null);
  pnlSoftware.add(btnApproveSW, null);
  pnlSoftware.add(btnPrintSW, null);
  pnlSoftware.add(txtEmpCodeSW, null);
  pnlSoftware.add(btnCloseSw, null);
  pnlSoftware.add(lblRemSW, null);
  pnlSoftware.add(btnHoldSW, null);
  pnlSoftware.add(lblEmpCodeSW, null);
  pnlSoftware.add(txtRemSW, null);

  SPSoftwareTbl.add(TblSoftware, null);

  SPEmailTbl.getViewport();
  SPMobileTbl.getViewport();
  SPPhoneTbl.getViewport();
  SPSoftwareTbl.getViewport();

  SPHardwareTbl.getViewport().setBackground(Color.white);
  SPEmailTbl.getViewport().setBackground(Color.white);
  SPMobileTbl.getViewport().setBackground(Color.white);
  SPPhoneTbl.getViewport().setBackground(Color.white);
  SPSoftwareTbl.getViewport().setBackground(Color.white);

  txtEmpCodeHW.setText(EC);
  txtEmpCodeMB.setText(EC);
  txtEmpCodePH.setText(EC);
  txtEmpCodeSW.setText(EC);

  this.getContentPane().setLayout(null);
  this.setSize(new Dimension(545, 483));
  this.setTitle(T);
  this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  this.setFrameIcon(imgIco);
  this.getContentPane().setBackground(Color.white);
  this.setResizable(false);
  this.setIconifiable(true);
  this.setClosable(true);
  this.setResizable(false);
  TP.addTab( "EMAIL", new ImageIcon("./Images/Table.gif"), pnlEmail);
  TP.addTab( "HARDWARE", new ImageIcon("./Images/Table.gif"), pnlHardware);
  TP.addTab( "MOBILE", new ImageIcon("./Images/Table.gif"), pnlMobile);
  TP.addTab( "PHONE", new ImageIcon("./Images/Table.gif"), pnlPhone);
  TP.addTab( "SOFTWARE", new ImageIcon("./Images/Table.gif"), pnlSoftware);
  getTableData();
 }//jbInit

 /**
 * Gets Table Data
 *
 */

 void getTableData()
 {//getTableData

  if (isISApp)
  {
   System.out.println("IS Approval");
   SQL = new String(SQLISHW);
   Table = ST_TB_HW;

   try
   {
    Rows_HW = ctccon.getRowData(SQL);
    Col_HW = ctccon.getColumnData(SQL);

   }catch(RemoteException re)
   {
    System.out.println("Client [frmReqApp]: GET ISHW TABLE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmReqApp]: "+re.getMessage(),
             "Error", JOptionPane.ERROR_MESSAGE);
   }
   szISHW[0]=115;szISHW[1]=50;szISHW[2]=60;szISHW[3]=150;szISHW[4]=150;szISHW[5]=150;szISHW[6]=50;
   TblHardware = new JTable(Rows_HW, Col_HW);
   setColWidth(SQL, TblHardware, szISHW);

   SQL = new String(SQLISEM);
   Table = new String(ST_TB_EM);

   try
   {
    Rows_EM = ctccon.getRowData(SQL);
    Col_EM = ctccon.getColumnData(SQL);

   }catch(RemoteException re)
   {
    System.out.println("Client [frmReqApp]: GET ISEM TABLE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmReqApp]: "+re.getMessage(),
             "Error", JOptionPane.ERROR_MESSAGE);
   }
   szISEM[0]=115;szISEM[1]=50;szISEM[2]=60;szISEM[3]=200;szISEM[4]=150;szISEM[5]=150;szISEM[6]=50;
   TblEmail = new JTable(Rows_EM, Col_EM);
   setColWidth(SQL, TblEmail, szISEM);

   SQL = new String(SQLISMB);
   Table = new String(ST_TB_MB);

   try
   {
    Rows_MB = ctccon.getRowData(SQL);
    Col_MB = ctccon.getColumnData(SQL);

   }catch(RemoteException re)
   {
    System.out.println("Client [frmReqApp]: GET ISMB TABLE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmReqApp]: "+re.getMessage(),
             "Error", JOptionPane.ERROR_MESSAGE);
   }
   TblMobile = new JTable(Rows_MB, Col_MB);
   szISMB[0]=115;szISMB[1]=50;szISMB[2]=60;szISMB[3]=50;szISMB[4]=50;szISMB[5]=80;szISMB[6]=150;szISMB[7]=50;
   szISMB[8]=50;szISMB[9]=150;szISMB[10]=50;szISMB[11]=70;szISMB[12]=50;szISMB[13]=50;szISMB[14]=50;
   szISMB[15]=150;szISMB[16]=50;szISMB[17]=150;szISMB[18]=70;szISMB[19]=50;
   setColWidth(SQL, TblMobile, szISMB);

   SQL = new String(SQLISPH);
   Table = new String(ST_TB_PH);

   try
   {
    Rows_PH = ctccon.getRowData(SQL);
    Col_PH = ctccon.getColumnData(SQL);

   }catch(RemoteException re)
   {
    System.out.println("Client [frmReqApp]: GET ISPH TABLE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmReqApp]: "+re.getMessage(),
             "Error", JOptionPane.ERROR_MESSAGE);
   }
   TblPhone = new JTable(Rows_PH, Col_PH);
   szISPH[0]=115;szISPH[1]=50;szISPH[2]=60;szISPH[3]=100;szISPH[4]=150;szISPH[5]=50;
   setColWidth(SQL, TblPhone, szISPH);

   SQL = new String(SQLISSW);
   Table = new String(ST_TB_SW);

   try
   {
    Rows_SW = ctccon.getRowData(SQL);
    Col_SW = ctccon.getColumnData(SQL);

   }catch(RemoteException re)
   {
    System.out.println("Client [frmReqApp]: GET ISSW TABLE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmReqApp]: "+re.getMessage(),
             "Error", JOptionPane.ERROR_MESSAGE);
   }
   TblSoftware = new JTable(Rows_SW, Col_SW);
   szISSW[0]=115;szISSW[1]=50;szISSW[2]=60;szISSW[3]=100;szISSW[4]=150;szISSW[5]=50;
   setColWidth(SQL, TblSoftware, szISSW);

  }

  else
  {
   System.out.println("DeptHead Approval");
   SQL = new String(SQLHW);
   Table = ST_TB_HW;

   try
   {
    Rows_HW = ctccon.getRowData(SQL);
    Col_HW = ctccon.getColumnData(SQL);

   }catch(RemoteException re)
   {
    System.out.println("Client [frmReqApp]: GET HW TABLE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmReqApp]: "+re.getMessage(),
             "Error", JOptionPane.ERROR_MESSAGE);
   }
   TblHardware = new JTable(Rows_HW, Col_HW);
   szHW[0]=115;szHW[1]=50;szHW[2]=60;szHW[3]=150;szHW[4]=150;szHW[5]=150;szHW[6]=50;
   setColWidth(SQL, TblHardware, szHW);

   SQL = new String(SQLEM);
   Table = new String(ST_TB_EM);

   try
   {
    Rows_EM = ctccon.getRowData(SQL);
    Col_EM = ctccon.getColumnData(SQL);

   }catch(RemoteException re)
   {
    System.out.println("Client [frmReqApp]: GET EM TABLE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmReqApp]: "+re.getMessage(),
             "Error", JOptionPane.ERROR_MESSAGE);
   }
   TblEmail = new JTable(Rows_EM, Col_EM);
   szEM[0]=115;szEM[1]=50;szEM[2]=60;szEM[3]=200;szEM[4]=150;szEM[5]=150;szEM[6]=50;
   setColWidth(SQL, TblEmail, szEM);

   SQL = new String(SQLMB);
   Table = new String(ST_TB_MB);

   try
   {
    Rows_MB = ctccon.getRowData(SQL);
    Col_MB = ctccon.getColumnData(SQL);

   }catch(RemoteException re)
   {
    System.out.println("Client [frmReqApp]: GET MB TABLE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmReqApp]: "+re.getMessage(),
             "Error", JOptionPane.ERROR_MESSAGE);
   }
   TblMobile = new JTable(Rows_MB, Col_MB);
   szMB[0]=115;szMB[1]=50;szMB[2]=60;szMB[3]=50;szMB[4]=50;szMB[5]=80;szMB[6]=150;szMB[7]=50;szMB[8]=50;szMB[9]=150;
   szMB[10]=50;szMB[11]=70;szMB[12]=50;szMB[13]=50;szMB[14]=50;szMB[15]=150;szMB[16]=50;szMB[17]=150;szMB[18]=70;szMB[19]=50;
   setColWidth(SQL, TblMobile, szMB);

   SQL = new String(SQLPH);
   Table = new String(ST_TB_PH);

   try
   {
    Rows_PH = ctccon.getRowData(SQL);
    Col_PH = ctccon.getColumnData(SQL);

   }catch(RemoteException re)
   {
    System.out.println("Client [frmReqApp]: GET PH TABLE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmReqApp]: "+re.getMessage(),
             "Error", JOptionPane.ERROR_MESSAGE);
   }
   TblPhone = new JTable(Rows_PH, Col_PH);
   szPH[0]=115;szPH[1]=50;szPH[2]=60;szPH[3]=100;szPH[4]=150;szPH[5]=50;
   setColWidth(SQL, TblPhone, szPH);

   SQL = new String(SQLSW);
   Table = new String(ST_TB_SW);

   try
   {
    Rows_SW = ctccon.getRowData(SQL);
    Col_SW = ctccon.getColumnData(SQL);

   }catch(RemoteException re)
   {
    System.out.println("Client [frmReqApp]: GET SW TABLE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmReqApp]: "+re.getMessage(),
             "Error", JOptionPane.ERROR_MESSAGE);
   }
   TblSoftware = new JTable(Rows_SW, Col_SW);
   szSW[0]=115;szSW[1]=50;szSW[2]=60;szSW[3]=100;szSW[4]=150;szSW[5]=50;
   setColWidth(SQL, TblSoftware, szSW);
  }

  SPEmailTbl.getViewport().add(TblEmail);
  SPHardwareTbl.getViewport().add(TblHardware);
  SPMobileTbl.getViewport().add(TblMobile);
  SPPhoneTbl.getViewport().add(TblPhone);
  SPSoftwareTbl.getViewport().add(TblSoftware);

  TblHardware.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
  TblHardware.setFont(new java.awt.Font("Tahoma", 0, 11));
  TblHardware.addMouseListener(new java.awt.event.MouseAdapter()
     {
      public void mouseClicked(MouseEvent e)
      {
    int x[] = TblHardware.getSelectedRows();

    if (x.length >= 1)
    {
     SelRow = new String[x.length][TotalCol];

     for (int i = 0; i < x.length; i++)
     {
      for (int j = 0; j < TotalCol; j++)
      {
       SelRow[i][j] = TblHardware.getValueAt(x[i], j).toString();
      }
     }

     System.out.println("SELECTED ROW: "+SelRow[0][0]+" * "+SelRow[0][1]+" * "+SelRow[0][2]+" * "+SelRow[0][3]+" * "+SelRow[0][4]+" * "+SelRow[0][5]);
    }
    else if (x.length < 1)
    {
     JOptionPane.showMessageDialog(null, "Please Select One Item!", "Information Required...", JOptionPane.ERROR_MESSAGE);
    }
   }
  });

  TblEmail.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
  TblEmail.setFont(new java.awt.Font("Tahoma", 0, 11));
  TblEmail.addMouseListener(new java.awt.event.MouseAdapter()
     {
      public void mouseClicked(MouseEvent e)
      {
    int x[] = TblEmail.getSelectedRows();

    if (x.length >= 1)
    {
     SelRow = new String[x.length][TotalCol];

     for (int i = 0; i < x.length; i++)
     {
      for (int j = 0; j < TotalCol; j++)
      {
       SelRow[i][j] = TblEmail.getValueAt(x[i], j).toString();
      }
     }

     System.out.println("SELECTED ROW: "+SelRow[0][0]+" * "+SelRow[0][1]+" * "+SelRow[0][2]+" * "+SelRow[0][3]+" * "+SelRow[0][4]+" * "+SelRow[0][5]);
    }
    else if (x.length < 1)
    {
     JOptionPane.showMessageDialog(null, "Please Select One Item!", "Information Required...", JOptionPane.ERROR_MESSAGE);
    }
   }
  });

  TblMobile.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
  TblMobile.setFont(new java.awt.Font("Tahoma", 0, 11));
  TblMobile.addMouseListener(new java.awt.event.MouseAdapter()
     {
      public void mouseClicked(MouseEvent e)
      {
    int x[] = TblMobile.getSelectedRows();

    if (x.length >= 1)
    {
     SelRow = new String[x.length][TotalCol];

     for (int i = 0; i < x.length; i++)
     {
      for (int j = 0; j < TotalCol; j++)
      {
       SelRow[i][j] = TblMobile.getValueAt(x[i], j).toString();
      }
     }

     System.out.println("SELECTED ROW: "+SelRow[0][0]+" * "+SelRow[0][1]+" * "+SelRow[0][2]+" * "+SelRow[0][3]+" * "+SelRow[0][4]+" * "+SelRow[0][5]);
    }
    else if (x.length < 1)
    {
     JOptionPane.showMessageDialog(null, "Please Select One Item!", "Information Required...", JOptionPane.ERROR_MESSAGE);
    }
   }
  });

  TblPhone.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
  TblPhone.setFont(new java.awt.Font("Tahoma", 0, 11));
  TblPhone.addMouseListener(new java.awt.event.MouseAdapter()
     {
      public void mouseClicked(MouseEvent e)
      {
    int x[] = TblPhone.getSelectedRows();

    if (x.length >= 1)
    {
     SelRow = new String[x.length][TotalCol];

     for (int i = 0; i < x.length; i++)
     {
      for (int j = 0; j < TotalCol; j++)
      {
       SelRow[i][j] = TblPhone.getValueAt(x[i], j).toString();
      }
     }

     System.out.println("SELECTED ROW: "+SelRow[0][0]+" * "+SelRow[0][1]+" * "+SelRow[0][2]+" * "+SelRow[0][3]+" * "+SelRow[0][4]+" * "+SelRow[0][5]);
    }
    else if (x.length < 1)
    {
     JOptionPane.showMessageDialog(null, "Please Select One Item!", "Information Required...", JOptionPane.ERROR_MESSAGE);
    }
   }
  });

  TblSoftware.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
  TblSoftware.setFont(new java.awt.Font("Tahoma", 0, 11));
  TblSoftware.addMouseListener(new java.awt.event.MouseAdapter()
     {
      public void mouseClicked(MouseEvent e)
      {
    int x[] = TblSoftware.getSelectedRows();

    if (x.length >= 1)
    {
     SelRow = new String[x.length][TotalCol];

     for (int i = 0; i < x.length; i++)
     {
      for (int j = 0; j < TotalCol; j++)
      {
       SelRow[i][j] = TblSoftware.getValueAt(x[i], j).toString();
      }
     }

     System.out.println("SELECTED ROW: "+SelRow[0][0]+" * "+SelRow[0][1]+" * "+SelRow[0][2]+" * "+SelRow[0][3]+" * "+SelRow[0][4]+" * "+SelRow[0][5]);
    }
    else if (x.length < 1)
    {
     JOptionPane.showMessageDialog(null, "Please Select One Item!", "Information Required...", JOptionPane.ERROR_MESSAGE);
    }
   }
  });

 }//getTableData

 /**
 * Sets Column Widths of Table
 * @param String SQL, @param JTable Table
 *
 */

 void setColWidth(String SQLString, JTable Table, int[] sz)
 {
  try
  {
   TotalCol = ctccon.getColNo(SQLString);
  }catch(RemoteException re)
  {
   System.out.println("Client [frmReqApp]: SET COL WIDTH Error");System.out.println("Error: "+re.getMessage());
   JOptionPane.showMessageDialog(null, "SET COL WIDTH Error\nClient [frmReqApp]: "+re.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
  }

  TableColumn column = null;
  for (int j = 0; j < TotalCol; ++j)
  {
   column = Table.getColumnModel().getColumn(j);
   column.setPreferredWidth(sz[j]);
  }
 }

 void ExecuteQueryNow()
 {
  int yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to APPROVE/HOLD the selected request?", "Conformation...",
  JOptionPane.YES_NO_OPTION, 3, imgQ);
  if (yn == JOptionPane.YES_OPTION)
  {
   try
   {
    ctccon.ExecuteQuery(UpdateQuery);
    StartWorking("DELETING RECORD");
    JOptionPane.showMessageDialog(null, "Record Updated!", "Information", 1);
    getTableData();

   }catch(RemoteException re)
   {
    System.out.println("Client [frmReqApp]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
    JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmReqApp]: "+re.getMessage(),
             "Error", JOptionPane.ERROR_MESSAGE);
   }
  }
  else
  {
   System.out.println("\nRecord not Deleted, Abord by the user...\n");
   return;
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