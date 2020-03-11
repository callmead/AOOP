//package beximtex;
/**
* <p>Title: BeximTex, Main MDI</p>
* <p>Description: Support Software System</p>
* <p>Copyright: 2006-2010</p>
* <p>Company: ASKA</p>
* @author Adeel Ashraf Malik
* @version 1.0.0
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.Date;
import java.applet.*;
import java.net.*;
import java.sql.*;

import java.rmi.*;

public class frmMain extends JFrame

{//Class

    //**************************************************************
    //RMI Declare Server Object
 UserController usercon;
 User usr = new User();

 SecuriteeController seccon;
 Securitee sec = new Securitee();
    //**************************************************************

 //Menu Bar
 JMenuBar mb = new JMenuBar();

 //File Menu
 JMenu mnuFile = new JMenu();
 //Sub Menu for File
 JMenuItem mnLockApp = new JMenuItem();
 JMenuItem mnChangePW = new JMenuItem();
 JMenuItem mnLogOff = new JMenuItem();
 JMenuItem miExit = new JMenuItem();

 //Request Menu
 JMenu mnuRequest = new JMenu();
 //Sub Menu for Request
 JMenu mnuNewItem = new JMenu();
 JMenuItem miNewHardware = new JMenuItem();
 JMenuItem miHardwareRep = new JMenuItem();
 JMenuItem miNewSoftware = new JMenuItem();
 JMenuItem miSoftwareRep = new JMenuItem();
 JMenuItem miNewMobile = new JMenuItem();
 JMenuItem miMobileRep = new JMenuItem();
 JMenuItem miNewEmail = new JMenuItem();
 JMenuItem miEmailRep = new JMenuItem();
 JMenuItem miNewPhone = new JMenuItem();
 JMenuItem miPhoneRep = new JMenuItem();
 JMenu mnuApproval = new JMenu();
 JMenuItem miDeptApp = new JMenuItem();
 JMenuItem miISApp = new JMenuItem();

 //Jobs Menu
 JMenu mnuJob = new JMenu();
 //Sub Menu for Jobs
 JMenuItem miHWJob = new JMenuItem();
 JMenuItem miSWJob = new JMenuItem();
 JMenuItem miMBJob = new JMenuItem();
 JMenuItem miEJob = new JMenuItem();
 JMenuItem miPJob = new JMenuItem();

 //Inventory Menu
 JMenu mnuInventory = new JMenu();
 //Sub Menu for Inventory
 JMenu mnuHardware = new JMenu();
 JMenuItem miHWPO = new JMenuItem();
 JMenuItem miHWSTM = new JMenuItem();
 JMenuItem miHWIH = new JMenuItem();
 JMenuItem miHWUR = new JMenuItem();

 JMenu mnuMobileInv = new JMenu();
 JMenuItem miMBissue = new JMenuItem();
 JMenuItem miMBpStk = new JMenuItem();
 JMenuItem miMBsStk = new JMenuItem();
 JMenuItem miMBbill = new JMenuItem();
 JMenuItem miMBTbill = new JMenuItem();
 JMenuItem miMBbgt = new JMenuItem();

 JMenuItem miSupplier = new JMenuItem();
 JMenuItem miSuppPay = new JMenuItem();
 JMenuItem miIndent = new JMenuItem();

 //Report Menu
 JMenu mnuReport = new JMenu();
 //Sub Menu for Report
 JMenu mnuHWInvRep = new JMenu();
 JMenuItem miHWPORep = new JMenuItem();
 JMenuItem miHWPORepDT = new JMenuItem();
 JMenuItem miHWPODetRep = new JMenuItem();
 JMenuItem miSuppRep = new JMenuItem();
 JMenuItem miSuppAllRep = new JMenuItem();
 JMenuItem miHWTotalStockRep = new JMenuItem();
 JMenuItem miHWTotalStockDTRep = new JMenuItem();
 JMenuItem miHWIssuedStockRep = new JMenuItem();
 JMenuItem miHWNewStockRep = new JMenuItem();
 JMenuItem miHWIssuedRep = new JMenuItem();
 JMenuItem miHWIssuedDTRep = new JMenuItem();
 JMenuItem miHWUsersRep = new JMenuItem();
 JMenuItem miHWIndentsRep = new JMenuItem();
 JMenuItem miHWIndentsDTRep = new JMenuItem();
 JMenuItem miHWCIndentsRep = new JMenuItem();

 JMenu mnuMBInvRep = new JMenu();
 JMenuItem miMBpStkRepF = new JMenuItem();
 JMenuItem miMBpStkRepI = new JMenuItem();
 JMenuItem miMBpStkRepN = new JMenuItem();
 JMenuItem miMBpStkRepB = new JMenuItem();
 JMenuItem miMBsStkRepF = new JMenuItem();
 JMenuItem miMBsStkRepI = new JMenuItem();
 JMenuItem miMBsStkRepN = new JMenuItem();
 JMenuItem miMBsStkRepB = new JMenuItem();
 JMenuItem miMBiSdRep = new JMenuItem();
 JMenuItem miMBbiLRep = new JMenuItem();
 JMenuItem miMBtNtRep = new JMenuItem();
 JMenuItem miMBbGtRep = new JMenuItem();

 JMenu mnuChart = new JMenu();
 JMenuItem miCHTotalSChart = new JMenuItem();
 JMenuItem miCHTotalSChartDT = new JMenuItem();
 JMenuItem miCHIndentsChart = new JMenuItem();
 JMenuItem miCHIndentsChartDT = new JMenuItem();
 JMenuItem miCHMBbillChart = new JMenuItem();
 JMenuItem miCHMBbillChartDT = new JMenuItem();
 JMenuItem miCHMBbillChartDep = new JMenuItem();
 JMenuItem miCHMBbgtChart = new JMenuItem();
 JMenuItem miCHMBbgtChartDT = new JMenuItem();
 JMenuItem miCHMBbgtChartBU = new JMenuItem();

 JMenu mnuList = new JMenu();
 JMenuItem miUsersRep = new JMenuItem();
 JMenuItem miUsersDeptRep = new JMenuItem();

 JMenu mnuViewer = new JMenu();
 JMenuItem miEMview = new JMenuItem();
 JMenuItem miHWview = new JMenuItem();
 JMenuItem miMBview = new JMenuItem();
 JMenuItem miPHview = new JMenuItem();
 JMenuItem miSWview = new JMenuItem();
 JMenuItem miJBview = new JMenuItem();

 //Maintinance Menu
 JMenu mnuMaintinance = new JMenu();
 //Sub Menu for Maintinance
 JMenuItem miBackupManager = new JMenuItem();
 JMenuItem miImpExp = new JMenuItem();
 JMenuItem miQueryProcessor = new JMenuItem();
 JMenuItem miPrintManager = new JMenuItem();
 JMenuItem miUserManager = new JMenuItem();
 JMenu mnuReqQueManager = new JMenu();
 JMenuItem miEmailReqM = new JMenuItem();
 JMenuItem miHardwareRemM = new JMenuItem();
 JMenuItem miMobileReqM = new JMenuItem();
 JMenuItem miPhoneReqM = new JMenuItem();
 JMenuItem miSoftwareReqM = new JMenuItem();
 JMenuItem miJobManager = new JMenuItem();
 JMenuItem miPOGRManager = new JMenuItem();

 //Loon & Feel Menu
 JMenu mnuVO = new JMenu();
 //Sub Menu
 JMenuItem miLF = new JMenuItem();
 JMenuItem miTB = new JMenuItem();

 //Help Menu
 JMenu mnuHelp = new JMenu();
 //Sub Menu for  Help
 JMenuItem miAbout = new JMenuItem();
 JMenuItem miHelp = new JMenuItem();

 //Image Icons Used
 ImageIcon imgNewReq = new ImageIcon("./Images/new24.gif");
 ImageIcon imgLock = new ImageIcon("./Images/lock.png");
 ImageIcon imgLogOff = new ImageIcon("./Images/logOff.jpg");
 ImageIcon imgExit = new ImageIcon("./Images/end.jpg");

 ImageIcon imgPrint = new ImageIcon("./Images/printer.png");
 ImageIcon imgJob = new ImageIcon("./Images/jobs.png");
 ImageIcon imgTri = new ImageIcon("./Images/triangle.png");

 ImageIcon imgRep = new ImageIcon("./Images/mant.png");
 ImageIcon imgDBS = new ImageIcon("./Images/mant1.png");
 ImageIcon imgImpExp = new ImageIcon("./Images/impExp.png");
 ImageIcon imgUsr = new ImageIcon("./Images/login.png");
 ImageIcon imgAbout = new ImageIcon("./Images/question.png");
 ImageIcon imgQ = new ImageIcon("./Images/question32.png");
 ImageIcon imgPW = new ImageIcon("./Images/pw.gif");

 JLabel lblStatus = new JLabel();
 JDesktopPane dp = new JDesktopPane();

 //ToolBar...
 JToolBar tb = new JToolBar();
 //ToolBar Buttons...
 JButton btnLock = new JButton();
 JButton btnLF = new JButton();
 JButton btnStockChart = new JButton();
 JButton btnINChart = new JButton();
 JButton btnMBbillChart = new JButton();
 JButton btnMBbgtChart = new JButton();
 JButton btnQP = new JButton();
 JButton btnUM = new JButton();
 JButton btnLOut = new JButton();
 JButton btnExit = new JButton();
 JButton btnAbout = new JButton();

 JScrollPane SP = new JScrollPane();

 //User variables
 String EmpCode = null;
 String userName = null;
 String Pass = null;
 String userType = null;
 String SNo = null;
 String LogInTime = null;
 String LogOutTime = null;
 SimpleDateFormat sdf = new SimpleDateFormat();
 String y1,y2;
 boolean ReqAppIS = false;

 static JFrame frame;
 String TBar=null;

 public frmMain(String ec,String ToolBar,String pw)
 {//Cons
  //**************************************************************
     //Connection: Connects with Server
  try
  {
   usercon = (UserController)Naming.lookup(new ReadHost().getHost() + "UserController");
   seccon = (SecuriteeController)Naming.lookup(new ReadHost().getHost() + "SecuriteeController");

  }catch(Exception exc)
  {
   System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
   System.out.println("Error: "+exc.getMessage());
   JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+exc.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
   System.exit(0);
  }
  System.out.println("\n******************************\n CLIENT READY [frmMain] \n******************************\n");
  //**************************************************************

  EmpCode = ec;TBar=ToolBar;if(!pw.equals(null))Pass=pw;
  this.setTitle("Support Software System (C) 2006-2010 ASKA [Server Software ver: 5.2.02]");
  this.setLocation(0, 0);
  this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
  //this.setDefaultCloseOperation(EXIT_ON_CLOSE);

  int sw = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
  int sh = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
  this.setSize(sw, sh - 30);

  //Adding MenuBar on Frame...
  this.setJMenuBar(mb);

  //Adding ToolBar on Frame...
  this.getContentPane().add(tb, BorderLayout.NORTH);

  //Adding Status Label on Frame
  this.getContentPane().add(lblStatus, BorderLayout.SOUTH);

  this.getContentPane().add(SP, BorderLayout.CENTER);
  //dp.add(SP, new Integer(Integer.MIN_VALUE));

  //Adding DesktopPane on Frame
  this.getContentPane().add(dp, BorderLayout.CENTER);

  //Adding Window Listener
  this.addWindowListener(new WindowAdapter()
  {
   public void windowActivated(WindowEvent e) {}
   public void windowClosed(WindowEvent e) {}
   public void windowDeactivated(WindowEvent e) {}
   public void windowDeiconfied(WindowEvent e) {}
   public void windowIconified(WindowEvent e) {}
   public void windowOpened(WindowEvent e) {}
   public void windowClosing(WindowEvent e)
   { exitMsg(); }
  });

  //Adding Components to the MenuBar...
  //File Menu...
  mb.add(mnuFile);
  //Sub Menu for File...
  mnuFile.add(mnLockApp);
  mnuFile.addSeparator();
  mnuFile.add(mnChangePW);
  mnuFile.addSeparator();
  mnuFile.add(mnLogOff);
  mnuFile.addSeparator();
  mnuFile.add(miExit);

  //Request Menu...
  mb.add(mnuRequest);
  //Sub Menu for Request...
  mnuRequest.add(mnuNewItem);
  mnuRequest.addSeparator();
  //mnuRequest.add(miRepair);
  //mnuRequest.addSeparator();
  mnuRequest.add(mnuApproval);
  mnuNewItem.add(miNewEmail);
  mnuNewItem.add(miEmailRep);
  mnuNewItem.addSeparator();
  mnuNewItem.add(miNewHardware);
  mnuNewItem.add(miHardwareRep);
  mnuNewItem.addSeparator();
  mnuNewItem.add(miNewMobile);
  mnuNewItem.add(miMobileRep);
  mnuNewItem.addSeparator();
  mnuNewItem.add(miNewPhone);
  mnuNewItem.add(miPhoneRep);
  mnuNewItem.addSeparator();
  mnuNewItem.add(miNewSoftware);
  mnuNewItem.add(miSoftwareRep);
  mnuApproval.add(miDeptApp);
  mnuApproval.add(miISApp);

  //Jobs Menu
  mb.add(mnuJob);
  //Sub Menu for Jobs
  mnuJob.add(miEJob);
  mnuJob.add(miHWJob);
  mnuJob.add(miMBJob);
  mnuJob.add(miPJob);
  mnuJob.add(miSWJob);

  //Inventory Menu...
  mb.add(mnuInventory);
  //Sub Menu for Inventory...
  mnuInventory.add(mnuHardware);
  mnuHardware.add(miHWPO);
  mnuHardware.add(miSupplier);
  mnuHardware.add(miSuppPay);
  mnuHardware.add(miIndent);
  mnuHardware.addSeparator();
  mnuHardware.add(miHWSTM);
  mnuHardware.add(miHWIH);
  mnuHardware.addSeparator();
  mnuHardware.add(miHWUR);

  mnuInventory.addSeparator();

  mnuInventory.add(mnuMobileInv);
  mnuMobileInv.add(miMBpStk);
  mnuMobileInv.add(miMBsStk);
  mnuMobileInv.add(miMBissue);
  mnuMobileInv.addSeparator();
  mnuMobileInv.add(miMBbill);
  mnuMobileInv.add(miMBTbill);
  mnuMobileInv.addSeparator();
  mnuMobileInv.add(miMBbgt);


  //Report Menu...
  mb.add(mnuReport);
  //Sub Menu for Report...
  mnuReport.add(mnuHWInvRep);
  mnuHWInvRep.add(miHWPORep);
  mnuHWInvRep.add(miHWPORepDT);
  mnuHWInvRep.add(miHWPODetRep);
  mnuHWInvRep.addSeparator();
  mnuHWInvRep.add(miSuppRep);
  mnuHWInvRep.add(miSuppAllRep);
  mnuHWInvRep.addSeparator();
  mnuHWInvRep.add(miHWIndentsRep);
  mnuHWInvRep.add(miHWIndentsDTRep);
  mnuHWInvRep.add(miHWCIndentsRep);
  mnuHWInvRep.addSeparator();
  mnuHWInvRep.add(miHWTotalStockRep);
  mnuHWInvRep.add(miHWTotalStockDTRep);
  mnuHWInvRep.add(miHWIssuedStockRep);
  mnuHWInvRep.add(miHWNewStockRep);
  mnuHWInvRep.addSeparator();
  mnuHWInvRep.add(miHWIssuedRep);
  mnuHWInvRep.add(miHWIssuedDTRep);
  mnuHWInvRep.addSeparator();
  mnuHWInvRep.add(miHWUsersRep);

  mnuReport.addSeparator();
  mnuReport.add(mnuMBInvRep);
  mnuMBInvRep.add(miMBpStkRepF);
  mnuMBInvRep.add(miMBpStkRepI);
  mnuMBInvRep.add(miMBpStkRepN);
  mnuMBInvRep.add(miMBpStkRepB);
  mnuMBInvRep.addSeparator();
  mnuMBInvRep.add(miMBsStkRepF);
  mnuMBInvRep.add(miMBsStkRepI);
  mnuMBInvRep.add(miMBsStkRepN);
  mnuMBInvRep.add(miMBsStkRepB);
  mnuMBInvRep.addSeparator();
  mnuMBInvRep.add(miMBiSdRep);
  mnuMBInvRep.add(miMBbiLRep);
  mnuMBInvRep.add(miMBtNtRep);
  mnuMBInvRep.addSeparator();
  mnuMBInvRep.add(miMBbGtRep);

  mnuReport.addSeparator();
  mnuReport.add(mnuChart);
  mnuChart.add(miCHTotalSChart);
  mnuChart.add(miCHTotalSChartDT);
  mnuChart.addSeparator();
  mnuChart.add(miCHIndentsChart);
  mnuChart.add(miCHIndentsChartDT);
  mnuChart.addSeparator();
  mnuChart.add(miCHMBbillChart);
  mnuChart.add(miCHMBbillChartDT);
  mnuChart.add(miCHMBbillChartDep);
  mnuChart.addSeparator();
  mnuChart.add(miCHMBbgtChart);
  mnuChart.add(miCHMBbgtChartDT);
  mnuChart.add(miCHMBbgtChartBU);

  mnuReport.addSeparator();
  mnuReport.add(mnuList);

  mnuList.add(miUsersRep);
  mnuList.add(miUsersDeptRep);

  mnuReport.addSeparator();
  mnuReport.add(mnuViewer);
  mnuViewer.add(miEMview);
  mnuViewer.add(miHWview);
  mnuViewer.add(miMBview);
  mnuViewer.add(miPHview);
  mnuViewer.add(miSWview);
  mnuViewer.add(miJBview);

  //Maintinance Menu...
  mb.add(mnuMaintinance);
  //Sub Menu for Maintinance...
  mnuMaintinance.add(miBackupManager);
  mnuMaintinance.add(miQueryProcessor);
  mnuMaintinance.addSeparator();
  mnuMaintinance.add(miImpExp);
  mnuMaintinance.addSeparator();
  mnuMaintinance.add(miUserManager);
  mnuMaintinance.addSeparator();
  mnuMaintinance.add(mnuReqQueManager);
  mnuReqQueManager.add(miEmailReqM);
  mnuReqQueManager.add(miHardwareRemM);
  mnuReqQueManager.add(miMobileReqM);
  mnuReqQueManager.add(miPhoneReqM);
  mnuReqQueManager.add(miSoftwareReqM);
  mnuMaintinance.add(miJobManager);
  mnuMaintinance.add(miPOGRManager);

  //Look & Feel Menu
  mb.add(mnuVO);
  // Group the radio buttons.
  mnuVO.add(miLF);
  mnuVO.add(miTB);

  //Help Menu...
  mb.add(mnuHelp);
  //Sub Menu for Help...
  mnuHelp.add(miAbout);
  mnuHelp.add(miHelp);

  //Properties of Menu Items

  //File Menu
  mnuFile.setText("File");
  mnuFile.setMnemonic('F');
  mnuFile.setIcon(imgTri);
  mnuFile.setFont(new java.awt.Font("Tahoma", 1, 11));
  //Sub Menu for Files
  mnLockApp.setText("Lock Application");
  mnLockApp.setMnemonic('L');
  mnLockApp.setFont(new java.awt.Font("Tahoma", 1, 11));
  mnLockApp.setIcon(imgLock);
  mnLockApp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
  KeyEvent.CTRL_MASK, true));
  mnLockApp.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmPassword pw = new frmPassword(EmpCode, userName, Pass);
    pw.setSize(382, 192);
    pw.setVisible(true);
   }
  });

  mnChangePW.setText("Change Password");
  mnChangePW.setMnemonic('C');
  mnChangePW.setFont(new java.awt.Font("Tahoma", 1, 11));
  mnChangePW.setIcon(imgPW);
  mnChangePW.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
  KeyEvent.ALT_MASK, true));
  mnChangePW.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmChangePW cpw = new frmChangePW(EmpCode, userName, Pass);
    cpw.setSize(382, 192);
    cpw.setVisible(true);
   }
  });

  mnLogOff.setText("Log Off");
  mnLogOff.setMnemonic('L');
  mnLogOff.setFont(new java.awt.Font("Tahoma", 1, 11));
  mnLogOff.setIcon(imgLogOff);
  mnLogOff.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
  KeyEvent.ALT_MASK, true));
  mnLogOff.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    UpdateSecurity();
    dispose();
    frmLogin fl = new frmLogin();
    fl.setVisible(true);
   }
  });

  miExit.setText("Exit");
  miExit.setMnemonic('E');
  miExit.setFont(new java.awt.Font("Tahoma", 1, 11));
  miExit.setIcon(imgExit);
  miExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0, true));
  miExit.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { exitMsg(); }
  });
  //-----------------------------------------

  //Request Menu...
  mnuRequest.setText("Request");
  mnuRequest.setMnemonic('q');
  mnuRequest.setIcon(imgTri);
  mnuRequest.setFont(new java.awt.Font("Tahoma", 1, 11));
  //Sub Menu for Request...
  mnuNewItem.setText("New Item");
  mnuNewItem.setMnemonic('N');
  mnuNewItem.setFont(new java.awt.Font("Tahoma", 1, 11));
  mnuNewItem.setIcon(imgNewReq);

  miNewEmail.setText("Email");
  miNewEmail.setMnemonic('E');
  miNewEmail.setFont(new java.awt.Font("Tahoma", 1, 11));
  miNewEmail.setIcon(imgNewReq);
  miNewEmail.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmEmail em = new frmEmail(EmpCode, userName, Pass);
    createFrame(em);
   }
  });

  miEmailRep.setText("Email Request Report");
  //miEmailRep.setMnemonic('E');
  miEmailRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miEmailRep.setIcon(imgPrint);
  miEmailRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    String tmpID = null;
    frmList lst = new frmList("REQUEST QUEUE FOR "+userName, "SELECT TransactionID,EmpCode,Date,Remarks,Email1,Email2,Password FROM Email WHERE EmpCode='"+EmpCode+"' ORDER BY TransactionID;");
    lst.setVisible(true);
    String t[][] = lst.getType();
    if(t!=null)
    {
     tmpID=(t[0][0]);
     frmJR jr=new frmJR("EMAIL REQUEST FOR "+userName,"./Reports/Email","AND Email.TransactionID='"+tmpID+"'");
     createFrame(jr);
    }
   }
  });

  miNewHardware.setText("Hardware");
  miNewHardware.setMnemonic('H');
  miNewHardware.setFont(new java.awt.Font("Tahoma", 1, 11));
  miNewHardware.setIcon(imgNewReq);
  miNewHardware.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmHardware hw = new frmHardware(EmpCode, userName);
    createFrame(hw);
   }
  });

  miHardwareRep.setText("Hardware Request Report");
  //miHardwareRep.setMnemonic('H');
  miHardwareRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHardwareRep.setIcon(imgPrint);
  miHardwareRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    String tmpID = null;
    frmList lst = new frmList("REQUEST QUEUE FOR "+userName, "SELECT TransactionID,EmpCode,Date,Description,Need,Spec FROM Hardware WHERE EmpCode='"+EmpCode+"' ORDER BY TransactionID;");
    lst.setVisible(true);
    String t[][] = lst.getType();
    if(t!=null)
    {
     tmpID=(t[0][0]);
     frmJR jr=new frmJR("HARDWARE REQUEST FOR "+userName,"./Reports/Hardware","AND Hardware.TransactionID='"+tmpID+"'");
     createFrame(jr);
    }
   }
  });

  miNewMobile.setText("Mobile");
  miNewMobile.setMnemonic('M');
  miNewMobile.setFont(new java.awt.Font("Tahoma", 1, 11));
  miNewMobile.setIcon(imgNewReq);
  miNewMobile.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmMobile fm = new frmMobile(EmpCode, userName);
    createFrame(fm);
   }
  });

  miMobileRep.setText("Mobile Request Report");
  //miMobileRep.setMnemonic('M');
  miMobileRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMobileRep.setIcon(imgPrint);
  miMobileRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    String tmpID = null;
    frmList lst = new frmList("REQUEST QUEUE FOR "+userName, "SELECT TransactionID, EmpCode, Date, Q1, Q2, Q2a, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10, Q11, Q12, Q13, Q13a, Q14 FROM Mobile WHERE EmpCode='"+EmpCode+"' ORDER BY TransactionID;");
    lst.setVisible(true);
    String t[][] = lst.getType();
    if(t!=null)
    {
     tmpID=(t[0][0]);
     frmJR jr=new frmJR("MOBILE REQUEST FOR "+userName,"./Reports/Mobile","AND Mobile.TransactionID='"+tmpID+"'");
     createFrame(jr);
    }
   }
  });


  miNewPhone.setText("Phone");
  miNewPhone.setMnemonic('P');
  miNewPhone.setFont(new java.awt.Font("Tahoma", 1, 11));
  miNewPhone.setIcon(imgNewReq);
  miNewPhone.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmPhone ph = new frmPhone(EmpCode, userName);
    createFrame(ph);
   }
  });

  miPhoneRep.setText("Phone Request Report");
  //miPhoneRep.setMnemonic('P');
  miPhoneRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miPhoneRep.setIcon(imgPrint);
  miPhoneRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    String tmpID = null;
    frmList lst = new frmList("REQUEST QUEUE FOR "+userName, "SELECT TransactionID,EmpCode,Date,RequestType,Need FROM Phone WHERE EmpCode='"+EmpCode+"' ORDER BY TransactionID;");
    lst.setVisible(true);
    String t[][] = lst.getType();
    if(t!=null)
    {
     tmpID=(t[0][0]);
     frmJR jr=new frmJR("PHONE REQUEST FOR "+userName,"./Reports/Phone","AND Phone.TransactionID='"+tmpID+"'");
     createFrame(jr);
    }
   }
  });

  miNewSoftware.setText("Software");
  miNewSoftware.setMnemonic('S');
  miNewSoftware.setFont(new java.awt.Font("Tahoma", 1, 11));
  miNewSoftware.setIcon(imgNewReq);
  miNewSoftware.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmSoftware fs = new frmSoftware(EmpCode, userName);
    createFrame(fs);
   }
  });

  miSoftwareRep.setText("Software Request Report");
  //miSoftwareRep.setMnemonic('S');
  miSoftwareRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miSoftwareRep.setIcon(imgPrint);
  miSoftwareRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    String tmpID = null;
    frmList lst = new frmList("REQUEST QUEUE FOR "+userName, "SELECT TransactionID,EmpCode,Date,RequestType,Description FROM Software WHERE EmpCode='"+EmpCode+"' ORDER BY TransactionID;");
    lst.setVisible(true);
    String t[][] = lst.getType();
    if(t!=null)
    {
     tmpID=(t[0][0]);
     frmJR jr=new frmJR("SOFTWARE REQUEST FOR "+userName,"./Reports/Software","AND Software.TransactionID='"+tmpID+"'");
     createFrame(jr);
    }
   }
  });

  mnuApproval.setText("Approval");
  mnuApproval.setMnemonic('A');
  mnuApproval.setFont(new java.awt.Font("Tahoma", 1, 11));
  mnuApproval.setIcon(imgNewReq);

  miDeptApp.setText("Department Head");
  miDeptApp.setMnemonic('D');
  miDeptApp.setFont(new java.awt.Font("Tahoma", 1, 11));
  miDeptApp.setIcon(imgNewReq);
  miDeptApp.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    ReqAppIS = false;
    frmReqApp ra = new frmReqApp(EmpCode, userName, "DEPARTMENTAL APPROVAL",
    ReqAppIS);
    createFrame(ra);
   }
  });

  miISApp.setText("IS Head");
  miISApp.setMnemonic('I');
  miISApp.setFont(new java.awt.Font("Tahoma", 1, 11));
  miISApp.setIcon(imgNewReq);
  miISApp.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    ReqAppIS = true;
    frmReqApp ra = new frmReqApp(EmpCode, userName, "IS APPROVAL", ReqAppIS);
    createFrame(ra);
   }
  });
  //---------------------------------

  //Jobs Menu
  mnuJob.setText("Jobs");
  mnuJob.setMnemonic('J');
  mnuJob.setIcon(imgTri);
  mnuJob.setFont(new java.awt.Font("Tahoma", 1, 11));

  //Sub Menu for Jobs
  miEJob.setText("Email");
  miEJob.setMnemonic('E');
  miEJob.setFont(new java.awt.Font("Tahoma", 1, 11));
  miEJob.setIcon(imgJob);
  miEJob.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmJobs fej = new frmJobs(EmpCode, "EMAIL", "SELECT TransactionID, EmpCode, Date, Remarks, Email1, Email2, Password, DeptComm, ISComm FROM Email WHERE ISApp='YES' AND JobStatus='-';", "Email");
    createFrame(fej);
  }
  });

  miHWJob.setText("Hardware");
  miHWJob.setMnemonic('H');
  miHWJob.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWJob.setIcon(imgJob);
  miHWJob.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmJobs fhj = new frmJobs(EmpCode, "HARDWARE", "SELECT TransactionID, EmpCode, Date, Description, Spec as 'Specification', DeptComm, ISComm FROM Hardware WHERE ISApp='YES' AND JobStatus='-';", "Hardware");
    createFrame(fhj);
   }
  });

  miMBJob.setText("Mobile");
  miMBJob.setMnemonic('M');
  miMBJob.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBJob.setIcon(imgJob);
  miMBJob.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmJobs fmj = new frmJobs(EmpCode, "MOBILE", "SELECT TransactionID, EmpCode, Date,Q5 as 'Usage',Q9 as 'ResidencePhone',Q13 as 'ISD', DeptComm, ISComm FROM Mobile WHERE ISApp='YES' AND JobStatus='-';", "Mobile");
    createFrame(fmj);
   }
  });

  miPJob.setText("Phone");
  miPJob.setMnemonic('P');
  miPJob.setFont(new java.awt.Font("Tahoma", 1, 11));
  miPJob.setIcon(imgJob);
  miPJob.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmJobs fpj = new frmJobs(EmpCode, "PHONE", "SELECT TransactionID, EmpCode, Date, RequestType, DeptComm, ISComm FROM Phone WHERE ISApp='YES' AND JobStatus='-';", "Phone");
    createFrame(fpj);
   }
  });

  miSWJob.setText("Software");
  miSWJob.setMnemonic('S');
  miSWJob.setFont(new java.awt.Font("Tahoma", 1, 11));
  miSWJob.setIcon(imgJob);
  miSWJob.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmJobs fsj = new frmJobs(EmpCode, "SOFTWARE", "SELECT TransactionID, EmpCode, Date, RequestType, Description, DeptComm, ISComm FROM Software WHERE ISApp='YES' AND JobStatus='-';", "Software");
    createFrame(fsj);
   }
  });
  //---------------------------------

  //Inventory Menu...
  mnuInventory.setText("Inventory");
  mnuInventory.setMnemonic('I');
  mnuInventory.setIcon(imgTri);
  mnuInventory.setFont(new java.awt.Font("Tahoma", 1, 11));
  //Sub Menu for Invenorty...
  mnuHardware.setText("Hardware");
  mnuHardware.setMnemonic('H');
  mnuHardware.setFont(new java.awt.Font("Tahoma", 1, 11));
  mnuHardware.setIcon(imgNewReq);

  miHWPO.setText("Purchase Orders");
  miHWPO.setMnemonic('P');
  miHWPO.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWPO.setIcon(imgNewReq);
  miHWPO.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmPOGR fpogr = new frmPOGR(EmpCode);
    createFrame(fpogr);
   }
  });

  miSupplier.setText("Suppliers");
  miSupplier.setMnemonic('S');
  miSupplier.setFont(new java.awt.Font("Tahoma", 1, 11));
  miSupplier.setIcon(imgNewReq);
  miSupplier.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmSupplier fs = new frmSupplier(EmpCode);
    createFrame(fs);
   }
  });

  miSuppPay.setText("Supplier Payments");
  miSuppPay.setMnemonic('P');
  miSuppPay.setFont(new java.awt.Font("Tahoma", 1, 11));
  miSuppPay.setIcon(imgNewReq);
  miSuppPay.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmPayments fps = new frmPayments(EmpCode);
    createFrame(fps);
   }
  });

  miIndent.setText("Indents");
  miIndent.setMnemonic('I');
  miIndent.setFont(new java.awt.Font("Tahoma", 1, 11));
  miIndent.setIcon(imgNewReq);
  miIndent.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmIndent fin = new frmIndent(EmpCode);
    createFrame(fin);
   }
  });

  miHWSTM.setText("Stock Management");
  miHWSTM.setMnemonic('S');
  miHWSTM.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWSTM.setIcon(imgNewReq);
  miHWSTM.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmStock fs = new frmStock(EmpCode);
    createFrame(fs);
   }
  });

  miHWIH.setText("Issue Hardware");
  miHWIH.setMnemonic('H');
  miHWIH.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWIH.setIcon(imgNewReq);
  miHWIH.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmIssueHW fih = new frmIssueHW(EmpCode);
    createFrame(fih);
   }
  });

  miHWUR.setText("Register User");
  miHWUR.setMnemonic('R');
  miHWUR.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWUR.setIcon(imgNewReq);
  miHWUR.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmHWUsers fhu = new frmHWUsers(EmpCode);
    createFrame(fhu);
   }
  });

  mnuMobileInv.setText("Mobile");
  mnuMobileInv.setMnemonic('M');
  mnuMobileInv.setFont(new java.awt.Font("Tahoma", 1, 11));
  mnuMobileInv.setIcon(imgNewReq);
  mnuMobileInv.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {}
  });

  miMBpStk.setText("Mobile Phone Stock");
  miMBpStk.setMnemonic('P');
  miMBpStk.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBpStk.setIcon(imgNewReq);
  miMBpStk.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmMBpStock fmbp = new frmMBpStock(EmpCode);
    createFrame(fmbp);
   }
  });

  miMBsStk.setText("SIM Stock");
  miMBsStk.setMnemonic('S');
  miMBsStk.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBsStk.setIcon(imgNewReq);
  miMBsStk.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmMBsStock fmbs = new frmMBsStock(EmpCode);
    createFrame(fmbs);
   }
  });

  miMBbill.setText("Mobile Billing");
  miMBbill.setMnemonic('M');
  miMBbill.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBbill.setIcon(imgNewReq);
  miMBbill.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmMBill mbb = new frmMBill(EmpCode);
    createFrame(mbb);
   }
  });

  miMBTbill.setText("T&T Billing");
  miMBTbill.setMnemonic('T');
  miMBTbill.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBTbill.setIcon(imgNewReq);
  miMBTbill.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmMBTBill ftb = new frmMBTBill(EmpCode);
    createFrame(ftb);
   }
  });

  miMBbgt.setText("Mobile Budget");
  miMBbgt.setMnemonic('D');
  miMBbgt.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBbgt.setIcon(imgNewReq);
  miMBbgt.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmMBbgt fmbgt = new frmMBbgt(EmpCode);
    createFrame(fmbgt);
   }
  });

  miMBissue.setText("Issue");
  miMBissue.setMnemonic('I');
  miMBissue.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBissue.setIcon(imgNewReq);
  miMBissue.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmMBIssue fis = new frmMBIssue(EmpCode);
    createFrame(fis);
   }
  });
  //---------------------------------

  //Report Menu
  mnuReport.setText("Reports");
  mnuReport.setMnemonic('R');
  mnuReport.setIcon(imgTri);
  mnuReport.setFont(new java.awt.Font("Tahoma", 1, 11));
  //Sub Menu for Report...
  mnuHWInvRep.setText("Hardware Inventory");
  mnuHWInvRep.setMnemonic('H');
  mnuHWInvRep.setIcon(imgPrint);
  mnuHWInvRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  mnuHWInvRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {}
  });

  miHWPORep.setText("Purchase Orders");
  miHWPORep.setMnemonic('P');
  miHWPORep.setIcon(imgPrint);
  miHWPORep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWPORep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //Purchase Orders [Parameter Optional]
    frmJR jr=new frmJR("Purchase Orders","./Reports/PO_Det","");
    //frmJR jr=new frmJR("Purchase Orders","./Reports/PO_Det","WHERE SID='S01'");
    createFrame(jr);
   }
  });

  miHWPORepDT.setText("Purchase Orders Between 2 Dates");
  //miHWPORepDT.setMnemonic('P');
  miHWPORepDT.setIcon(imgPrint);
  miHWPORepDT.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWPORepDT.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmDate fd = new frmDate("Select Start Date");
    fd.setSize(new Dimension(212, 163));
    fd.setVisible(true);
    String SDate = fd.createDate();

    fd = new frmDate("Select Finish Date");
    fd.setSize(new Dimension(212, 163));
    fd.setVisible(true);
    String FDate = fd.createDate();

    //Purchase Orders [Parameter Optional]
    frmJR jr=new frmJR("Purchase Orders Between "+SDate+" AND "+FDate,"./Reports/PO_Det","WHERE Date BETWEEN '"+SDate+"' AND '"+FDate+"'");
    createFrame(jr);
   }
  });

  miHWPODetRep.setText("Particular Purchase Order");
  miHWPODetRep.setMnemonic('O');
  miHWPODetRep.setIcon(imgPrint);
  miHWPODetRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWPODetRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    String tmpOID = null;
    frmList lst = new frmList("ORDER DETAILS", "SELECT * FROM HW_POGR ORDER BY OID;");
    lst.setVisible(true);

    String t[][] = lst.getType();
    if(t!=null)
    {
     tmpOID=(t[0][1]);
     //Purchase Order [Parameter Required!]...
     frmJR jr=new frmJR("PURCHASE ORDER","./Reports/HW_PO","WHERE HW_POGR.SID=Suppliers.SID AND HW_POGR.OID='"+tmpOID+"'");
     createFrame(jr);
    }
   }
  });

  miSuppRep.setText("Supplier Details");
  miSuppRep.setMnemonic('S');
  miSuppRep.setIcon(imgPrint);
  miSuppRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miSuppRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    String tmpSID = null;
    frmList lst = new frmList("SUPPLIER DETAILS", "SELECT * FROM Suppliers ORDER BY SID;");
    lst.setVisible(true);

    String t[][] = lst.getType();
    if(t!=null)
    {
     tmpSID=(t[0][0]);
     //Suppliers [Parameters Optional]
     frmJR jr=new frmJR("SUPPLIER","./Reports/Supp","WHERE SID='"+tmpSID+"'");
     createFrame(jr);
    }
   }
  });

  miSuppAllRep.setText("All Suppliers");
  miSuppAllRep.setMnemonic('A');
  miSuppAllRep.setIcon(imgPrint);
  miSuppAllRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miSuppAllRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //Suppliers [Parameters Optional]
    frmJR jr=new frmJR("Suppliers","./Reports/Supp","");
    createFrame(jr);
   }
  });

  miHWTotalStockRep.setText("Total Stock");
  miHWTotalStockRep.setMnemonic('T');
  miHWTotalStockRep.setIcon(imgPrint);
  miHWTotalStockRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWTotalStockRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //Hardware Stock [Parameter Optional]
    frmJR jr=new frmJR("Total Hardware Stock","./Reports/HW_Stock","");
    createFrame(jr);
   }
  });
  miHWTotalStockDTRep.setText("Total Stock Between 2 Dates");
  //miHWTotalStockDTRep.setMnemonic('T');
  miHWTotalStockDTRep.setIcon(imgPrint);
  miHWTotalStockDTRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWTotalStockDTRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmDate fd = new frmDate("Select Start Date");
    fd.setSize(new Dimension(212, 163));
    fd.setVisible(true);
    String SDate = fd.createDate();

    fd = new frmDate("Select Finish Date");
    fd.setSize(new Dimension(212, 163));
    fd.setVisible(true);
    String FDate = fd.createDate();

    //Hardware Stock [Parameter Optional]
    frmJR jr=new frmJR("Total Hardware Stock Between "+SDate+" AND "+FDate,"./Reports/HW_Stock","WHERE Date BETWEEN '"+SDate+"' AND '"+FDate+"'");
    createFrame(jr);
   }
  });

  miHWIssuedStockRep.setText("Issued Stock");
  //miHWIssuedStockRep.setMnemonic('I');
  miHWIssuedStockRep.setIcon(imgPrint);
  miHWIssuedStockRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWIssuedStockRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //Hardware Stock [Parameter Optional]
    frmJR jr=new frmJR("Hardware Issued Stock","./Reports/HW_Stock","WHERE Issued='Yes'");
    createFrame(jr);
   }
  });

  miHWNewStockRep.setText("New Stock");
  //miHWNewStockRep.setMnemonic('N');
  miHWNewStockRep.setIcon(imgPrint);
  miHWNewStockRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWNewStockRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //Hardware Stock [Parameter Optional]
    frmJR jr=new frmJR("Hardware New Stock","./Reports/HW_Stock","WHERE Issued='No'");
    createFrame(jr);
   }
  });

  miHWIssuedRep.setText("Hardware Issue Details");
  //miHWIssuedRep.setMnemonic('I');
  miHWIssuedRep.setIcon(imgPrint);
  miHWIssuedRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWIssuedRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //Hardware Issue Report [Parameter Optional]
    //frmJR jr=new frmJR("Hardware Issue Details","./Reports/HW_Issue","AND Employees.Department='IS'");
    frmJR jr=new frmJR("Hardware Issue Details","./Reports/HW_Issue","");
    createFrame(jr);
   }
  });

  miHWIssuedDTRep.setText("Hardware Issue Between 2 Dates");
  //miHWIssuedRep.setMnemonic('I');
  miHWIssuedDTRep.setIcon(imgPrint);
  miHWIssuedDTRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWIssuedDTRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmDate fd = new frmDate("Select Start Date");
    fd.setSize(new Dimension(212, 163));
    fd.setVisible(true);
    String SDate = fd.createDate();

    fd = new frmDate("Select Finish Date");
    fd.setSize(new Dimension(212, 163));
    fd.setVisible(true);
    String FDate = fd.createDate();

    //Hardware Issue Report [Parameter Optional]
    frmJR jr=new frmJR("Hardware Issue Details Between "+SDate+" AND "+FDate,"./Reports/HW_Issue","AND HW_Issue.Date BETWEEN '"+SDate+"' AND '"+FDate+"'");
    createFrame(jr);
   }
  });

  miHWUsersRep.setText("Hardware Users Details");
  //miHWIssuedRep.setMnemonic('I');
  miHWUsersRep.setIcon(imgPrint);
  miHWUsersRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWUsersRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //Hardware Users Report [Parameter Optional] WHERE...
    frmJR jr=new frmJR("Hardware Users Details","./Reports/HW_Users","");
    createFrame(jr);
   }
  });

  miHWIndentsRep.setText("Indents");
  //miHWIndentsRep.setMnemonic('I');
  miHWIndentsRep.setIcon(imgPrint);
  miHWIndentsRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWIndentsRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //Indents [Parameters Optional]
    frmJR jr=new frmJR("Indents","./Reports/Indents","");
    createFrame(jr);
   }
  });

  miHWIndentsDTRep.setText("Indents Between 2 Dates");
  //miHWIndentsRep.setMnemonic('I');
  miHWIndentsDTRep.setIcon(imgPrint);
  miHWIndentsDTRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWIndentsDTRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmDate fd = new frmDate("Select Start Date");
    fd.setSize(new Dimension(212, 163));
    fd.setVisible(true);
    String SDate = fd.createDate();

    fd = new frmDate("Select Finish Date");
    fd.setSize(new Dimension(212, 163));
    fd.setVisible(true);
    String FDate = fd.createDate();

    //Indents [Parameters Optional]
    frmJR jr=new frmJR("Indents Between "+SDate+" AND "+FDate,"./Reports/Indents","WHERE Date BETWEEN '"+SDate+"' AND '"+FDate+"'");
    createFrame(jr);
   }
  });

  miHWCIndentsRep.setText("Cancelled Indents");
  miHWCIndentsRep.setMnemonic('I');
  miHWCIndentsRep.setIcon(imgPrint);
  miHWCIndentsRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWCIndentsRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //Indents [Parameters Optional]
    frmJR jr=new frmJR("Indents","./Reports/Indents","WHERE Remarks Like 'Can%'");
    createFrame(jr);
   }
  });

  mnuMBInvRep.setText("Mobile Inventory");
  mnuMBInvRep.setMnemonic('M');
  mnuMBInvRep.setIcon(imgPrint);
  mnuMBInvRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  mnuMBInvRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {}
  });

  miMBpStkRepF.setText("Mobile Stock");
  miMBpStkRepF.setMnemonic('M');
  miMBpStkRepF.setIcon(imgPrint);
  miMBpStkRepF.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBpStkRepF.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //Mobile Stock [Parameters Optional]
    frmJR jr=new frmJR("MOBILE STOCK","./Reports/MB_P_Stock","");
    createFrame(jr);
   }
  });

  miMBpStkRepI.setText("Mobile Stock [Issued]");
  //miMBpStkRepI.setMnemonic('M');
  miMBpStkRepI.setIcon(imgPrint);
  miMBpStkRepI.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBpStkRepI.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //Mobile Stock [Parameters Optional]
    frmJR jr=new frmJR("MOBILE STOCK [Issued]","./Reports/MB_P_Stock","WHERE Issued='Yes'");
    createFrame(jr);
   }
  });

  miMBpStkRepN.setText("Mobile Stock [New]");
  //miMBpStkRepN.setMnemonic('M');
  miMBpStkRepN.setIcon(imgPrint);
  miMBpStkRepN.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBpStkRepN.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //Mobile Stock [Parameters Optional]
    frmJR jr=new frmJR("MOBILE STOCK [New]","./Reports/MB_P_Stock","WHERE Issued='No'");
    createFrame(jr);
   }
  });

  miMBpStkRepB.setText("Mobile Stock [Bad]");
  //miMBpStkRepB.setMnemonic('M');
  miMBpStkRepB.setIcon(imgPrint);
  miMBpStkRepB.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBpStkRepB.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //Mobile Stock [Parameters Optional]
    frmJR jr=new frmJR("MOBILE STOCK [Bad]","./Reports/MB_P_Stock","WHERE Quality='Bad'");
    createFrame(jr);
   }
  });

  miMBsStkRepF.setText("SIM Stock");
  miMBsStkRepF.setMnemonic('S');
  miMBsStkRepF.setIcon(imgPrint);
  miMBsStkRepF.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBsStkRepF.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //SIM Stock [Parameters Optional]
    frmJR jr=new frmJR("SIM STOCK","./Reports/MB_S_Stock","");
    createFrame(jr);
   }
  });

  miMBsStkRepI.setText("SIM Stock [Issued]");
  //miMBsStkRepI.setMnemonic('M');
  miMBsStkRepI.setIcon(imgPrint);
  miMBsStkRepI.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBsStkRepI.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //SIM Stock [Parameters Optional]
    frmJR jr=new frmJR("SIM STOCK [Issued]","./Reports/MB_S_Stock","WHERE Issued='Yes'");
    createFrame(jr);
   }
  });

  miMBsStkRepN.setText("SIM Stock [New]");
  //miMBsStkRepN.setMnemonic('M');
  miMBsStkRepN.setIcon(imgPrint);
  miMBsStkRepN.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBsStkRepN.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //SIM Stock [Parameters Optional]
    frmJR jr=new frmJR("SIM STOCK [New]","./Reports/MB_S_Stock","WHERE Issued='No'");
    createFrame(jr);
   }
  });

  miMBsStkRepB.setText("SIM Stock [Bad]");
  //miMBsStkRepB.setMnemonic('M');
  miMBsStkRepB.setIcon(imgPrint);
  miMBsStkRepB.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBsStkRepB.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //SIM Stock [Parameters Optional]
    frmJR jr=new frmJR("SIM STOCK [Bad]","./Reports/MB_S_Stock","WHERE Quality='Bad'");
    createFrame(jr);
   }
  });

  miMBiSdRep.setText("Issue Details");
  miMBiSdRep.setMnemonic('I');
  miMBiSdRep.setIcon(imgPrint);
  miMBiSdRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBiSdRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //MB ISSUE DETAILS [Parameters Optional] AND...
    frmJR jr=new frmJR("MOBILE ISSUE DETAILS","./Reports/MB_Issue","");
    createFrame(jr);
   }
  });

  miMBbiLRep.setText("Monthly Mobile Bills");
  //miMBbiLRep.setMnemonic('I');
  miMBbiLRep.setIcon(imgPrint);
  miMBbiLRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBbiLRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //MB Bill DETAILS [Parameters Optional] AND...
    frmJR jr=new frmJR("MOBILE BILL DETAILS","./Reports/MB_Bill","");
    createFrame(jr);
   }
  });

  miMBtNtRep.setText("Monthly T&T Bills");
  //miMBtNtRep.setMnemonic('I');
  miMBtNtRep.setIcon(imgPrint);
  miMBtNtRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBtNtRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //MB TBill DETAILS [Parameters Optional] WHERE...
    frmJR jr=new frmJR("MOBILE T&T BILL DETAILS","./Reports/MB_TBill","");
    createFrame(jr);
   }
  });

  miMBbGtRep.setText("Mobile Phone Budget");
  //miMBbGtRep.setMnemonic('I');
  miMBbGtRep.setIcon(imgPrint);
  miMBbGtRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBbGtRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //MB Budget DETAILS [Parameters Optional] WHERE...
    frmJR jr=new frmJR("MOBILE PHONE BUDGET DETAILS","./Reports/MB_Budget","");
    createFrame(jr);
   }
  });

  mnuChart.setText("Charts");
  mnuChart.setMnemonic('C');
  mnuChart.setIcon(imgPrint);
  mnuChart.setFont(new java.awt.Font("Tahoma", 1, 11));
  mnuChart.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {}
  });

  miCHTotalSChart.setText("Hardware Stock Chart");
  //miCHTotalSChart.setMnemonic('T');
  miCHTotalSChart.setIcon(imgPrint);
  miCHTotalSChart.setFont(new java.awt.Font("Tahoma", 1, 11));
  miCHTotalSChart.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //Hardware Stock [Parameter Optional]
    frmJR jr=new frmJR("Hardware Stock Chart","./Reports/HW_Chart","");
    createFrame(jr);
   }
  });

  miCHTotalSChartDT.setText("Hardware Stock Chart [Between 2 Dates]");
  //miCHTotalSChart.setMnemonic('T');
  miCHTotalSChartDT.setIcon(imgPrint);
  miCHTotalSChartDT.setFont(new java.awt.Font("Tahoma", 1, 11));
  miCHTotalSChartDT.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmDate fd = new frmDate("Select Start Date");
    fd.setSize(new Dimension(212, 163));
    fd.setVisible(true);
    String SDate = fd.createDate();

    fd = new frmDate("Select Finish Date");
    fd.setSize(new Dimension(212, 163));
    fd.setVisible(true);
    String FDate = fd.createDate();

    //Hardware Stock [Parameter Optional]
    frmJR jr=new frmJR("Total Hardware Stock Chart Between "+SDate+" AND "+FDate,"./Reports/HW_Chart","WHERE Date BETWEEN '"+SDate+"' AND '"+FDate+"'");
    createFrame(jr);
   }
  });

  miCHIndentsChart.setText("Indents Chart");
  //miHWIndentsRep.setMnemonic('I');
  miCHIndentsChart.setIcon(imgPrint);
  miCHIndentsChart.setFont(new java.awt.Font("Tahoma", 1, 11));
  miCHIndentsChart.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //Indents Chart [Parameters Optional]
    frmJR jr=new frmJR("Indents Chart","./Reports/IN_Chart","");
    createFrame(jr);
   }
  });

  miCHIndentsChartDT.setText("Indents Chart [Between 2 Dates]");
  //miHWIndentsRep.setMnemonic('I');
  miCHIndentsChartDT.setIcon(imgPrint);
  miCHIndentsChartDT.setFont(new java.awt.Font("Tahoma", 1, 11));
  miCHIndentsChartDT.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmDate fd = new frmDate("Select Start Date");
    fd.setSize(new Dimension(212, 163));
    fd.setVisible(true);
    String SDate = fd.createDate();

    fd = new frmDate("Select Finish Date");
    fd.setSize(new Dimension(212, 163));
    fd.setVisible(true);
    String FDate = fd.createDate();

    //Indents Chart [Parameters Optional]
    frmJR jr=new frmJR("Indents Chart Between "+SDate+" AND "+FDate,"./Reports/IN_Chart","AND Date BETWEEN '"+SDate+"' AND '"+FDate+"'");
    createFrame(jr);
   }
  });

  miCHMBbillChart.setText("Mobile Bill Chart");
  //miCHMBbillChart.setMnemonic('I');
  miCHMBbillChart.setIcon(imgPrint);
  miCHMBbillChart.setFont(new java.awt.Font("Tahoma", 1, 11));
  miCHMBbillChart.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //MB Bill Chart [Parameters Optional]
    frmJR jr=new frmJR("Mobile Bill Chart","./Reports/MB_BChart","");
    createFrame(jr);
   }
  });

  miCHMBbillChartDT.setText("Mobile Bill Chart [Particular Year(s)]");
  //miCHMBbillChartDT.setMnemonic('I');
  miCHMBbillChartDT.setIcon(imgPrint);
  miCHMBbillChartDT.setFont(new java.awt.Font("Tahoma", 1, 11));
  miCHMBbillChartDT.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //MB Bill Chart [Parameters Optional]
    y1 = JOptionPane.showInputDialog(null, "Enter First Year",
    "Information Required",
    JOptionPane.
    INFORMATION_MESSAGE);
    y2 = JOptionPane.showInputDialog(null, "Enter Second Year",
    "Information Required",
    JOptionPane.
    INFORMATION_MESSAGE);
    if(y1!=null && y2!=null)
    {
     frmJR jr = new frmJR("Mobile Bill Chart Between "+y1+" AND "+y2, "./Reports/MB_BChart", "AND MB_Bill.Year BETWEEN '"+y1+"' AND '"+y2+"'");
     createFrame(jr);
    }
   }
  });

  miCHMBbillChartDep.setText("Mobile Bill Chart [Particular Department]");
  //miCHMBbillChartDep.setMnemonic('I');
  miCHMBbillChartDep.setIcon(imgPrint);
  miCHMBbillChartDep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miCHMBbillChartDep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //MB Bill Chart [Parameters Optional]
    String tmpDept = null;
    frmList lst = new frmList("DEPARTMENTS", "SELECT * FROM Dept ORDER BY Department;");
    lst.setVisible(true);
    String t[][] = lst.getType();
    if(t!=null)
    {
     tmpDept=(t[0][0]);
     frmJR jr = new frmJR("Mobile Bill Chart for "+tmpDept, "./Reports/MB_BChart", "AND Employees.Department='"+tmpDept+"'");
     createFrame(jr);
    }
   }
  });


  miCHMBbgtChart.setText("Mobile Budget Chart");
  //miCHMBbgtChart.setMnemonic('I');
  miCHMBbgtChart.setIcon(imgPrint);
  miCHMBbgtChart.setFont(new java.awt.Font("Tahoma", 1, 11));
  miCHMBbgtChart.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //MB Bill Chart [Parameters Optional]
    frmJR jr=new frmJR("Mobile Budget Chart","./Reports/MB_BgtChart","");
    createFrame(jr);
   }
  });

  miCHMBbgtChartDT.setText("Mobile Budget Chart [Particular Year(s)]");
  //miCHMBbgtChart.setMnemonic('I');
  miCHMBbgtChartDT.setIcon(imgPrint);
  miCHMBbgtChartDT.setFont(new java.awt.Font("Tahoma", 1, 11));
  miCHMBbgtChartDT.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //MB Bill Chart [Parameters Optional]
    y1 = JOptionPane.showInputDialog(null, "Enter First Year",
    "Information Required",
    JOptionPane.INFORMATION_MESSAGE);
    y2 = JOptionPane.showInputDialog(null, "Enter Second Year",
    "Information Required",
    JOptionPane.INFORMATION_MESSAGE);
    if(y1!=null && y2!=null)
    {
     frmJR jr = new frmJR("Mobile Budget Chart Between "+y1+" AND "+y2, "./Reports/MB_BgtChart", "WHERE Year BETWEEN '" + y1 + "' AND '" + y2 + "'");
     createFrame(jr);
    }
   }
  });

  miCHMBbgtChartBU.setText("Mobile Budget Chart [Particular BU]");
  //miCHMBbgtChartBU.setMnemonic('I');
  miCHMBbgtChartBU.setIcon(imgPrint);
  miCHMBbgtChartBU.setFont(new java.awt.Font("Tahoma", 1, 11));
  miCHMBbgtChartBU.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //MB Bill Chart [Parameters Optional]
    String tmpBU = null;
    frmList lst = new frmList("BUSSINESS UNITS", "SELECT * FROM BU ORDER BY BU;");
    lst.setVisible(true);
    String t[][] = lst.getType();
    if(t!=null)
    {
     tmpBU=(t[0][0]);
     frmJR jr = new frmJR("Mobile Budget Chart", "./Reports/MB_BgtChart",
     "WHERE BU='" + tmpBU + "'");
     createFrame(jr);
    }
   }
  });

  mnuList.setText("List");
  mnuList.setMnemonic('L');
  mnuList.setIcon(imgPrint);
  mnuList.setFont(new java.awt.Font("Tahoma", 1, 11));
  mnuList.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {}
  });

  miUsersRep.setText("Employees");
  miUsersRep.setMnemonic('E');
  miUsersRep.setIcon(imgPrint);
  miUsersRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miUsersRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //Employee List [Parameter Optional]
    frmJR jr=new frmJR("Employees","./Reports/Emp","");
    createFrame(jr);
   }
  });

  miUsersDeptRep.setText("Specific Department's Employees");
  //miUsersDeptRep.setMnemonic('E');
  miUsersDeptRep.setIcon(imgPrint);
  miUsersDeptRep.setFont(new java.awt.Font("Tahoma", 1, 11));
  miUsersDeptRep.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    String tmpDept = null;
    frmList lst = new frmList("DEPARTMENTS", "SELECT * FROM Dept ORDER BY Department;");
    lst.setVisible(true);

    String t[][] = lst.getType();
    if(t!=null)
    {
     tmpDept=(t[0][0]);
     //Employee List [Parameter Optional]
     frmJR jr=new frmJR("Employees","./Reports/Emp","WHERE Department='"+tmpDept+"'");
     createFrame(jr);
    }
   }
  });

  mnuViewer.setText("QUEUE Viewer");
  mnuViewer.setMnemonic('Q');
  mnuViewer.setIcon(imgPrint);
  mnuViewer.setFont(new java.awt.Font("Tahoma", 1, 11));
  mnuViewer.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {}
  });

  miEMview.setText("Email QUEUE");
  miEMview.setMnemonic('E');
  miEMview.setIcon(imgPrint);
  miEMview.setFont(new java.awt.Font("Tahoma", 1, 11));
  miEMview.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmView fr = new frmView("EMAIL QUEUE","SELECT * FROM Email WHERE JobStatus<>'Cleared' ORDER BY TransactionID;","Email");
    createFrame(fr);
   }
  });
  miHWview.setText("Hardware QUEUE");
  miHWview.setMnemonic('H');
  miHWview.setIcon(imgPrint);
  miHWview.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHWview.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmView fr = new frmView("HARDWARE QUEUE","SELECT * FROM Hardware WHERE JobStatus<>'Cleared' ORDER BY TransactionID;","Hardware");
    createFrame(fr);
   }
  });
  miMBview.setText("Mobile QUEUE");
  miMBview.setMnemonic('M');
  miMBview.setIcon(imgPrint);
  miMBview.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMBview.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmView fr = new frmView("MOBILE QUEUE","SELECT * FROM Mobile WHERE JobStatus<>'Cleared' ORDER BY TransactionID;","Mobile");
    createFrame(fr);
   }
  });
  miPHview.setText("Phone QUEUE");
  miPHview.setMnemonic('P');
  miPHview.setIcon(imgPrint);
  miPHview.setFont(new java.awt.Font("Tahoma", 1, 11));
  miPHview.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmView fr = new frmView("PHONE QUEUE","SELECT * FROM Phone WHERE JobStatus<>'Cleared' ORDER BY TransactionID;","Phone");
    createFrame(fr);
   }
  });
  miSWview.setText("Software QUEUE");
  miSWview.setMnemonic('S');
  miSWview.setIcon(imgPrint);
  miSWview.setFont(new java.awt.Font("Tahoma", 1, 11));
  miSWview.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmView fr = new frmView("SOFTWARE QUEUE","SELECT * FROM Software WHERE JobStatus<>'Cleared' ORDER BY TransactionID;","Software");
    createFrame(fr);
   }
  });

  miJBview.setText("Jobs QUEUE");
  miJBview.setMnemonic('J');
  miJBview.setIcon(imgPrint);
  miJBview.setFont(new java.awt.Font("Tahoma", 1, 11));
  miJBview.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmView fr = new frmView("JOBS QUEUE","SELECT * FROM Jobs WHERE Status<>'Cleared' ORDER BY TransactionID;","Jobs");
    createFrame(fr);
   }
  });
  //----------------------------------------

  //Maintinance Menu...
  mnuMaintinance.setText("Maintenance");
  mnuMaintinance.setMnemonic('M');
  mnuMaintinance.setIcon(imgTri);
  mnuMaintinance.setFont(new java.awt.Font("Tahoma", 1, 11));
  //Sub Menu for Reports...
  miBackupManager.setText("Database Manager");
  miBackupManager.setMnemonic('D');
  miBackupManager.setFont(new java.awt.Font("Tahoma", 1, 11));
  miBackupManager.setIcon(imgDBS);
  miBackupManager.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmDBM dbm = new frmDBM();
    createFrame(dbm);
   }
  });

  miImpExp.setText("Import / Export Manager");
  miImpExp.setMnemonic('I');
  miImpExp.setFont(new java.awt.Font("Tahoma", 1, 11));
  miImpExp.setIcon(imgImpExp);
  miImpExp.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmBackup fb = new frmBackup();
    createFrame(fb);
   }
  });

  miQueryProcessor.setText("Query Processor");
  miQueryProcessor.setMnemonic('Q');
  miQueryProcessor.setFont(new java.awt.Font("Tahoma", 1, 11));
  miQueryProcessor.setIcon(imgDBS);
  miQueryProcessor.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmQueryProcessor fq = new frmQueryProcessor();
    createFrame(fq);
   }
  });

  miUserManager.setText("User Manager");
  miUserManager.setMnemonic('U');
  miUserManager.setFont(new java.awt.Font("Tahoma", 1, 11));
  miUserManager.setIcon(imgUsr);
  miUserManager.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmUsers fu = new frmUsers();
    createFrame(fu);
   }
  });

  mnuReqQueManager.setText("Request Queue Manager");
  mnuReqQueManager.setMnemonic('R');
  mnuReqQueManager.setFont(new java.awt.Font("Tahoma", 1, 11));
  mnuReqQueManager.setIcon(imgJob);
  mnuReqQueManager.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {}
  });

  miEmailReqM.setText("Email Requests");
  miEmailReqM.setFont(new java.awt.Font("Tahoma", 1, 11));
  miEmailReqM.setIcon(imgJob);
  miEmailReqM.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmQue fq = new frmQue(EmpCode, "EMAIL", "SELECT * FROM Email ORDER BY TransactionID;","Email");
    createFrame(fq);
   }
  });
  miHardwareRemM.setText("Hardware Requests");
  miHardwareRemM.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHardwareRemM.setIcon(imgJob);
  miHardwareRemM.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmQue fq = new frmQue(EmpCode, "HARDWARE", "SELECT * FROM Hardware ORDER BY TransactionID;","Hardware");
    createFrame(fq);
   }
  });
  miMobileReqM.setText("Mobile Requests");
  miMobileReqM.setFont(new java.awt.Font("Tahoma", 1, 11));
  miMobileReqM.setIcon(imgJob);
  miMobileReqM.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmQue fq = new frmQue(EmpCode, "MOBILE", "SELECT * FROM Mobile ORDER BY TransactionID;","Mobile");
    createFrame(fq);
   }
  });
  miPhoneReqM.setText("Phone Requests");
  miPhoneReqM.setFont(new java.awt.Font("Tahoma", 1, 11));
  miPhoneReqM.setIcon(imgJob);
  miPhoneReqM.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmQue fq = new frmQue(EmpCode, "PHONE", "SELECT * FROM Phone ORDER BY TransactionID;","Phone");
    createFrame(fq);
   }
  });
  miSoftwareReqM.setText("Software Requests");
  miSoftwareReqM.setFont(new java.awt.Font("Tahoma", 1, 11));
  miSoftwareReqM.setIcon(imgJob);
  miSoftwareReqM.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmQue fq = new frmQue(EmpCode, "SOFTWARE", "SELECT * FROM Software ORDER BY TransactionID;","Software");
    createFrame(fq);
   }
  });

  miJobManager.setText("Job Queue Manager");
  miJobManager.setMnemonic('J');
  miJobManager.setFont(new java.awt.Font("Tahoma", 1, 11));
  miJobManager.setIcon(imgJob);
  miJobManager.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmQue fq = new frmQue(EmpCode, "JOBS", "SELECT * FROM Jobs ORDER BY TransactionID;","Jobs");
    createFrame(fq);
   }
  });

  miPOGRManager.setText("PO & GR Manager");
  miPOGRManager.setMnemonic('J');
  miPOGRManager.setFont(new java.awt.Font("Tahoma", 1, 11));
  miPOGRManager.setIcon(imgJob);
  miPOGRManager.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmQue fq = new frmQue(EmpCode, "PURCHASE ORDERS", "SELECT * FROM HW_POGR ORDER BY TransactionID;","HW_POGR");
    createFrame(fq);
   }
  });
  //----------------------------------------

  //View Options
  mnuVO.setText("View");
  mnuVO.setMnemonic('V');
  mnuVO.setIcon(imgTri);
  mnuVO.setFont(new java.awt.Font("Tahoma", 1, 11));

  miLF.setText("Look & Feel");
  miLF.setMnemonic('L');
  miLF.setIcon(imgNewReq);
  miLF.setFont(new java.awt.Font("Tahoma", 1, 11));
  miLF.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmLF lf = new frmLF();
    lf.setSize(345,150);
    lf.setVisible(true);
   }
  });

  miTB.setText("ToolBar");
  miTB.setMnemonic('T');
  miTB.setIcon(imgNewReq);
  miTB.setFont(new java.awt.Font("Tahoma", 1, 11));
  miTB.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmTB ft = new frmTB(EmpCode);
    ft.setSize(237,148);
    ft.setVisible(true);
   }
  });

  //Help Menu...
  mnuHelp.setText("Help");
  mnuHelp.setMnemonic('H');
  mnuHelp.setIcon(imgTri);
  mnuHelp.setFont(new java.awt.Font("Tahoma", 1, 11));
  //Sub Menu for Help...
  miAbout.setText("About Software");
  miAbout.setFont(new java.awt.Font("Tahoma", 1, 11));
  miAbout.setIcon(imgAbout);
  miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,
  KeyEvent.CTRL_MASK, true));
  miAbout.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //showHelp();
    frmAbout fa = new frmAbout();
    fa.setSize(new Dimension(400, 430));
    fa.setVisible(true);
   }
  });

  miHelp.setText("Help");
  miHelp.setFont(new java.awt.Font("Tahoma", 1, 11));
  miHelp.setIcon(imgAbout);
  miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,
  KeyEvent.CTRL_MASK, true));
  miHelp.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmHelp fh = new frmHelp();
    createFrame(fh);
   }
  });
  //----------------------------------------

  //Properties of ToolBar...
  tb.setFloatable(false); //toolbar stationary
  //tb.setOrientation(JToolBar.VERTICAL);

  //Adding Components to ToolBar...
  tb.add(btnLock);
  tb.add(btnLF);
  tb.addSeparator();
  tb.add(btnStockChart);
  tb.add(btnINChart);
  tb.add(btnMBbillChart);
  tb.add(btnMBbgtChart);
  tb.addSeparator();
  tb.add(btnQP);
  tb.add(btnUM);
  tb.addSeparator();
  tb.add(btnLOut);
  tb.add(btnExit);
  tb.addSeparator();
  tb.add(btnAbout);
  setToolBar(TBar);
  //---------Properties of ToolBar's Button-----
  btnLock.setIcon(imgLock);
  btnLock.setToolTipText("Lock Application");
  btnLock.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmPassword pw = new frmPassword(EmpCode, userName, Pass);
    pw.setSize(382, 192);
    pw.setVisible(true);
   }
  });

  btnLF.setIcon(imgNewReq);
  btnLF.setToolTipText("Look & Feel");
  btnLF.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmLF lf = new frmLF();
    lf.setSize(345,150);
    lf.setVisible(true);
   }
  });

  btnStockChart.setIcon(imgPrint);
  btnStockChart.setToolTipText("Hardware Stock Chart");
  btnStockChart.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmJR jr=new frmJR("Hardware Stock Chart","./Reports/HW_Chart","");
    createFrame(jr);
   }
  });

  btnINChart.setIcon(imgPrint);
  btnINChart.setToolTipText("Indent Chart");
  btnINChart.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmJR jr=new frmJR("Indents Chart","./Reports/IN_Chart","");
    createFrame(jr);
   }
  });
  btnMBbillChart.setIcon(imgPrint);
  btnMBbillChart.setToolTipText("Mobile Bill Chart");
  btnMBbillChart.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //MB Bill Chart [Parameters Optional] AND...
    frmJR jr=new frmJR("MOBILE BILL CHART","./Reports/MB_BChart","");
    createFrame(jr);
   }
  });

  btnMBbgtChart.setIcon(imgPrint);
  btnMBbgtChart.setToolTipText("Mobile Budget Chart");
  btnMBbgtChart.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //MB Bgt Chart [Parameters Optional] WHERE...
    frmJR jr=new frmJR("MOBILE BILL CHART","./Reports/MB_BgtChart","");
    createFrame(jr);
   }
  });

  btnQP.setIcon(imgDBS);
  btnQP.setToolTipText("Query Processor");
  btnQP.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmQueryProcessor fq = new frmQueryProcessor();
    createFrame(fq);
   }
  });

  btnUM.setIcon(imgUsr);
  btnUM.setToolTipText("User Manager");
  btnUM.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    frmUsers fu = new frmUsers();
    createFrame(fu);
   }
  });

  btnLOut.setIcon(imgLogOff);
  btnLOut.setToolTipText("Log Out");
  btnLOut.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    UpdateSecurity();
    dispose();
    frmLogin fl = new frmLogin();
    fl.setVisible(true);
   }
  });

  btnExit.setIcon(imgExit);
  btnExit.setToolTipText("EXIT");
  btnExit.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   { exitMsg(); }
  });

  btnAbout.setIcon(imgAbout);
  btnAbout.setToolTipText("HELP");
  btnAbout.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    //showHelp();
    frmHelp fh = new frmHelp();
    createFrame(fh);
   }
  });

  //Properties of Status Bar...
  lblStatus.setText("00:00:00 AM");
  //lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
  lblStatus.setVerticalAlignment(SwingConstants.CENTER);
  lblStatus.setForeground(Color.black);
  lblStatus.setFont(new Font("Verdana", 1, 12));
  lblStatus.setBorder(BorderFactory.createEtchedBorder(0)); //1 default raised line

  //DisableMenu
  SetMenu(false);

  if(EmpCode.equals("MASTER"))
  { SetMenu(true); }
  else
  {
   //Setting User Menu
   //getUserData
   getUserData();
   //EnableUserLevelMenu
   setUserMenu();
  }

  //Setting JDesktopPane...
  dp.setBackground(new Color(0, 74, 97));
  //Setting Statusbar
  getSystemTime();
  //PlaySound
  playAudioSound("./sounds/NoProblem.wav");
  this.setIconImage(Toolkit.getDefaultToolkit().getImage("./Images/Home.png"));
  this.setExtendedState(6);//Maxim
 } //End of Constructor

 /**
 * Gets The System Time And Displays it on Status Bar
 *
 */

 private void getSystemTime()
 { //getSystemTime

  Thread th = new Thread(new Runnable()
  { //Runnable
   public void run()
   { //run
    SimpleDateFormat sdf = new SimpleDateFormat();
    while (true)
    { //loop
     Date dt = new Date();
     sdf.applyPattern("hh:mm:ss a"); //a is used to display either AM or PM
     if (EmpCode.equals("MASTER"))
     {
      lblStatus.setText(":: [WELCOME MASTER] [" + sdf.format(dt) + "] :.");
     }
     else
     {
      lblStatus.setText(":: [WELCOME " + userName + "] [EMP CODE " +
      EmpCode + "] [Login Time: " + LogInTime + "] [" +
      sdf.format(dt) + "] :.");
     }

     //SHOWTING DATE
     sdf.applyPattern("EEEE, MMMM dd yyyy"); //EEE for date MM for month dd for day yy for year
     lblStatus.setToolTipText(sdf.format(dt));

     try
     {
      Thread.sleep(1000);
     }
     catch (Exception e) {}

    } //loop
   } //run
  }); //Runnable

  th.start();

 } //getSystemTime

 /**
 * On Exit Actions to be Parformed
 *
 */

 private void exitMsg()
 {

  int yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit "+userName,
  "Exit Confirmation", JOptionPane.YES_NO_OPTION, 3, imgQ);

  if (yn == JOptionPane.YES_OPTION)
  {
   UpdateSecurity();
   System.out.println("\n*** Connection Closed ***");
   System.out.println("\n*** THANK YOU FOR USING SUPPORT SOFTWARE SYSTEM ***\n*** Good Bye "+userName+" ***");
   System.exit(0);
  }
 }

 /**
 * Updates Security Table, User Logout Time
 *
 */

 public void UpdateSecurity()
 {//UpdateSecurity

  //Get SNo First...
  String srchStr = "SELECT * FROM Security WHERE EmpCode='" + EmpCode + "' ORDER BY SNo;";

  try
  {
   if (seccon.isFound(srchStr))
   {
    sec = seccon.SearchData(srchStr);
    sec=seccon.moveLast();

    SNo=(sec.getSNo());
   }
   else{}

  }catch(RemoteException re)
  {System.out.println("Client [frmMain]: EXIT MSG Error");System.out.println("Error: "+re.getMessage());}

  //Update Securty Table...
  Date d = new Date();

  String strQuery="UPDATE Security SET LogOutTime='" + d.toString() + "' WHERE SNo='" + sec.getSNo()+"';";

  try
  {
   seccon.UpdateData(strQuery);
  }catch(RemoteException re)
  {
   System.out.println("Client [frmMain]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
  }
 }//Update Security

 /**
 * Retreives User Name and User Type
 *
 */

 private void getUserData()
 { //getUserData

  //Getting Logintime
  Date d = new Date();
  sdf.applyPattern("hh:mm:ss a");
  sdf.format(d);
  LogInTime = sdf.format(d).toString();

  String srchStr = "SELECT * FROM Employees WHERE EmpCode='" + EmpCode + "';";

  try
  {
   usr = usercon.SearchData(srchStr);

   userName=(usr.getName());System.out.println("UserName:"+userName);
   userType=(usr.getUserType());System.out.println("UserType:"+userType);

  }catch(RemoteException re)
  {System.out.println("Client [frmMain]: GET USER DATA Error");System.out.println("Error: "+re.getMessage());}

 } //getUserData

 /**
 * Sets Menu Bar Items According to the User Type
 *
 */

 private void setUserMenu()
 {//Setting MenuBar
  if(userType.equals("Admin"))
  {
   SetMenu(true);
  }
  if(userType.equals("IS Manager"))
  {
   mnuNewItem.setEnabled(true);
   //Request Menu
   mnuRequest.setEnabled(true);
   //Sub Menu for Request
   mnuNewItem.setEnabled(true);
   miNewHardware.setEnabled(true);
   miHardwareRep.setEnabled(true);
   miNewSoftware.setEnabled(true);
   miSoftwareRep.setEnabled(true);
   miNewMobile.setEnabled(true);
   miMobileRep.setEnabled(true);
   miNewEmail.setEnabled(true);
   miEmailRep.setEnabled(true);
   miNewPhone.setEnabled(true);
   miPhoneRep.setEnabled(true);
   mnuApproval.setEnabled(true);
   miISApp.setEnabled(true);

   //Report Menu
   mnuReport.setEnabled(true);
   //Sub Menu for Report
   mnuHWInvRep.setEnabled(true);
   miHWPORep.setEnabled(true);
   miHWPORepDT.setEnabled(true);
   miHWPODetRep.setEnabled(true);
   miSuppRep.setEnabled(true);
   miSuppAllRep.setEnabled(true);
   miHWTotalStockRep.setEnabled(true);
   miHWTotalStockDTRep.setEnabled(true);
   miHWIssuedStockRep.setEnabled(true);
   miHWNewStockRep.setEnabled(true);
   miHWIssuedRep.setEnabled(true);
   miHWIssuedDTRep.setEnabled(true);
   miHWUsersRep.setEnabled(true);
   miHWIndentsRep.setEnabled(true);
   miHWIndentsDTRep.setEnabled(true);
   miHWCIndentsRep.setEnabled(true);

   mnuMBInvRep.setEnabled(true);
   miMBpStkRepF.setEnabled(true);
   miMBpStkRepI.setEnabled(true);
   miMBpStkRepN.setEnabled(true);
   miMBpStkRepB.setEnabled(true);
   miMBsStkRepF.setEnabled(true);
   miMBsStkRepI.setEnabled(true);
   miMBsStkRepN.setEnabled(true);
   miMBsStkRepB.setEnabled(true);
   miMBiSdRep.setEnabled(true);
   miMBbiLRep.setEnabled(true);
   miMBtNtRep.setEnabled(true);
   miMBbGtRep.setEnabled(true);

   mnuChart.setEnabled(true);
   miCHTotalSChart.setEnabled(true);
   miCHTotalSChartDT.setEnabled(true);
   miCHIndentsChart.setEnabled(true);
   miCHIndentsChartDT.setEnabled(true);
   miCHMBbillChart.setEnabled(true);
   miCHMBbillChartDT.setEnabled(true);
   miCHMBbillChartDep.setEnabled(true);
   miCHMBbgtChart.setEnabled(true);
   miCHMBbgtChartDT.setEnabled(true);
   miCHMBbgtChartBU.setEnabled(true);

   mnuList.setEnabled(true);
   miUsersRep.setEnabled(true);
   miUsersDeptRep.setEnabled(true);

   mnuViewer.setEnabled(true);
   miEMview.setEnabled(true);
   miHWview.setEnabled(true);
   miMBview.setEnabled(true);
   miPHview.setEnabled(true);
   miSWview.setEnabled(true);
   miJBview.setEnabled(true);

   //ToolBar
   btnStockChart.setEnabled(true);
   btnINChart.setEnabled(true);
   btnMBbillChart.setEnabled(true);
   btnMBbgtChart.setEnabled(true);
   }
   if(userType.equals("Manager"))
   {
   mnuNewItem.setEnabled(true);
   //Request Menu
   mnuRequest.setEnabled(true);
   //Sub Menu for Request
   mnuNewItem.setEnabled(true);
   miNewHardware.setEnabled(true);
   miHardwareRep.setEnabled(true);
   miNewSoftware.setEnabled(true);
   miSoftwareRep.setEnabled(true);
   miNewMobile.setEnabled(true);
   miMobileRep.setEnabled(true);
   miNewEmail.setEnabled(true);
   miEmailRep.setEnabled(true);
   miNewPhone.setEnabled(true);
   miPhoneRep.setEnabled(true);
   mnuApproval.setEnabled(true);
   miDeptApp.setEnabled(true);

   //Report Menu
   mnuReport.setEnabled(true);
   //Sub Menu for Report
   mnuHWInvRep.setEnabled(true);
   miHWPORep.setEnabled(true);
   miHWPORepDT.setEnabled(true);
   miHWPODetRep.setEnabled(true);
   miSuppRep.setEnabled(true);
   miSuppAllRep.setEnabled(true);
   miHWTotalStockRep.setEnabled(true);
   miHWTotalStockDTRep.setEnabled(true);
   miHWIssuedStockRep.setEnabled(true);
   miHWNewStockRep.setEnabled(true);
   miHWIssuedRep.setEnabled(true);
   miHWIssuedDTRep.setEnabled(true);
   miHWUsersRep.setEnabled(true);
   miHWIndentsRep.setEnabled(true);
   miHWIndentsDTRep.setEnabled(true);
   miHWCIndentsRep.setEnabled(true);

   mnuMBInvRep.setEnabled(true);
   miMBpStkRepF.setEnabled(true);
   miMBpStkRepI.setEnabled(true);
   miMBpStkRepN.setEnabled(true);
   miMBpStkRepB.setEnabled(true);
   miMBsStkRepF.setEnabled(true);
   miMBsStkRepI.setEnabled(true);
   miMBsStkRepN.setEnabled(true);
   miMBsStkRepB.setEnabled(true);
   miMBiSdRep.setEnabled(true);
   miMBbiLRep.setEnabled(true);
   miMBtNtRep.setEnabled(true);
   miMBbGtRep.setEnabled(true);

   mnuChart.setEnabled(true);
   miCHTotalSChart.setEnabled(true);
   miCHTotalSChartDT.setEnabled(true);
   miCHIndentsChart.setEnabled(true);
   miCHIndentsChartDT.setEnabled(true);
   miCHMBbillChart.setEnabled(true);
   miCHMBbillChartDT.setEnabled(true);
   miCHMBbillChartDep.setEnabled(true);
   miCHMBbgtChart.setEnabled(true);
   miCHMBbgtChartDT.setEnabled(true);
   miCHMBbgtChartBU.setEnabled(true);

   mnuList.setEnabled(true);
   miUsersRep.setEnabled(true);
   miUsersDeptRep.setEnabled(true);

   mnuViewer.setEnabled(true);
   miEMview.setEnabled(true);
   miHWview.setEnabled(true);
   miMBview.setEnabled(true);
   miPHview.setEnabled(true);
   miSWview.setEnabled(true);
   miJBview.setEnabled(true);

   //ToolBar
   btnStockChart.setEnabled(true);
   btnINChart.setEnabled(true);
   btnMBbillChart.setEnabled(true);
   btnMBbgtChart.setEnabled(true);
  }
  if(userType.equals("Hardware Eng."))
  {
   mnuNewItem.setEnabled(true);
   //Request Menu
   mnuRequest.setEnabled(true);
   //Sub Menu for Request
   mnuNewItem.setEnabled(true);
   miNewHardware.setEnabled(true);
   miHardwareRep.setEnabled(true);
   miNewSoftware.setEnabled(true);
   miSoftwareRep.setEnabled(true);
   miNewMobile.setEnabled(true);
   miMobileRep.setEnabled(true);
   miNewEmail.setEnabled(true);
   miEmailRep.setEnabled(true);
   miNewPhone.setEnabled(true);
   miPhoneRep.setEnabled(true);

   //Jobs Menu
   mnuJob.setEnabled(true);
   //Sub Menu for Jobs
   miHWJob.setEnabled(true);

   //Inventory Menu
   mnuInventory.setEnabled(true);
   //Sub Menu for Inventory
   mnuHardware.setEnabled(true);
   miHWSTM.setEnabled(true);
   miHWIH.setEnabled(true);
   miHWUR.setEnabled(true);

   //Report Menu
   mnuReport.setEnabled(true);
   //Sub Menu for Report
   mnuHWInvRep.setEnabled(true);
   miHWTotalStockRep.setEnabled(true);
   miHWTotalStockDTRep.setEnabled(true);
   miHWIssuedStockRep.setEnabled(true);
   miHWNewStockRep.setEnabled(true);
   miHWIssuedRep.setEnabled(true);
   miHWIssuedDTRep.setEnabled(true);
   miHWUsersRep.setEnabled(true);

   mnuChart.setEnabled(true);
   miCHTotalSChart.setEnabled(true);
   miCHTotalSChartDT.setEnabled(true);
   mnuViewer.setEnabled(true);
   miHWview.setEnabled(true);

   //Maintinance Menu
   mnuMaintinance.setEnabled(true);
   //Sub Menu for Maintinance
   mnuReqQueManager.setEnabled(true);
   miHardwareRemM.setEnabled(true);
   miJobManager.setEnabled(true);

   //ToolBar
   btnStockChart.setEnabled(true);
   }
   if(userType.equals("Hardware Inv. Eng."))
   {
   mnuNewItem.setEnabled(true);
   //Request Menu
   mnuRequest.setEnabled(true);
   //Sub Menu for Request
   mnuNewItem.setEnabled(true);
   miNewHardware.setEnabled(true);
   miHardwareRep.setEnabled(true);
   miNewSoftware.setEnabled(true);
   miSoftwareRep.setEnabled(true);
   miNewMobile.setEnabled(true);
   miMobileRep.setEnabled(true);
   miNewEmail.setEnabled(true);
   miEmailRep.setEnabled(true);
   miNewPhone.setEnabled(true);
   miPhoneRep.setEnabled(true);

   //Jobs Menu
   mnuJob.setEnabled(true);
   //Sub Menu for Jobs
   miHWJob.setEnabled(true);

   //Inventory Menu
   mnuInventory.setEnabled(true);
   //Sub Menu for Inventory
   mnuHardware.setEnabled(true);
   miHWPO.setEnabled(true);
   miHWSTM.setEnabled(true);
   miHWIH.setEnabled(true);
   miHWUR.setEnabled(true);
   miSupplier.setEnabled(true);
   miSuppPay.setEnabled(true);
   miIndent.setEnabled(true);

   //Report Menu
   mnuReport.setEnabled(true);
   //Sub Menu for Report
   mnuHWInvRep.setEnabled(true);
   miHWPORep.setEnabled(true);
   miHWPORepDT.setEnabled(true);
   miHWPODetRep.setEnabled(true);
   miSuppRep.setEnabled(true);
   miSuppAllRep.setEnabled(true);
   miHWTotalStockRep.setEnabled(true);
   miHWTotalStockDTRep.setEnabled(true);
   miHWIssuedStockRep.setEnabled(true);
   miHWNewStockRep.setEnabled(true);
   miHWIssuedRep.setEnabled(true);
   miHWIssuedDTRep.setEnabled(true);
   miHWUsersRep.setEnabled(true);
   miHWIndentsRep.setEnabled(true);
   miHWIndentsDTRep.setEnabled(true);
   miHWCIndentsRep.setEnabled(true);

   mnuChart.setEnabled(true);
   miCHTotalSChart.setEnabled(true);
   miCHTotalSChartDT.setEnabled(true);
   miCHIndentsChart.setEnabled(true);
   miCHIndentsChartDT.setEnabled(true);

   mnuViewer.setEnabled(true);
   miHWview.setEnabled(true);

   //Maintinance Menu
   mnuMaintinance.setEnabled(true);
   mnuReqQueManager.setEnabled(true);
   miHardwareRemM.setEnabled(true);
   miJobManager.setEnabled(true);
   miPOGRManager.setEnabled(true);

   //ToolBar
   btnStockChart.setEnabled(true);
   btnINChart.setEnabled(true);
  }
  if(userType.equals("Mobile Inv. Staff"))
  {
   mnuNewItem.setEnabled(true);
   //Request Menu
   mnuRequest.setEnabled(true);
   //Sub Menu for Request
   mnuNewItem.setEnabled(true);
   miNewHardware.setEnabled(true);
   miHardwareRep.setEnabled(true);
   miNewSoftware.setEnabled(true);
   miSoftwareRep.setEnabled(true);
   miNewMobile.setEnabled(true);
   miMobileRep.setEnabled(true);
   miNewEmail.setEnabled(true);
   miEmailRep.setEnabled(true);
   miNewPhone.setEnabled(true);
   miPhoneRep.setEnabled(true);

   //Jobs Menu
   mnuJob.setEnabled(true);
   //Sub Menu for Jobs
   miMBJob.setEnabled(true);
   miPJob.setEnabled(true);

   //Inventory Menu
   mnuInventory.setEnabled(true);
   //Sub Menu for Inventory
   mnuMobileInv.setEnabled(true);
   miMBissue.setEnabled(true);
   miMBpStk.setEnabled(true);
   miMBsStk.setEnabled(true);
   miMBbill.setEnabled(true);
   miMBTbill.setEnabled(true);
   miMBbgt.setEnabled(true);

   //Report Menu
   mnuReport.setEnabled(true);
   //Sub Menu for Report
   mnuMBInvRep.setEnabled(true);
   miMBpStkRepF.setEnabled(true);
   miMBpStkRepI.setEnabled(true);
   miMBpStkRepN.setEnabled(true);
   miMBpStkRepB.setEnabled(true);
   miMBsStkRepF.setEnabled(true);
   miMBsStkRepI.setEnabled(true);
   miMBsStkRepN.setEnabled(true);
   miMBsStkRepB.setEnabled(true);
   miMBiSdRep.setEnabled(true);
   miMBbiLRep.setEnabled(true);
   miMBtNtRep.setEnabled(true);
   miMBbGtRep.setEnabled(true);

   mnuChart.setEnabled(true);
   miCHMBbillChart.setEnabled(true);
   miCHMBbillChartDT.setEnabled(true);
   miCHMBbillChartDep.setEnabled(true);
   miCHMBbgtChart.setEnabled(true);
   miCHMBbgtChartDT.setEnabled(true);
   miCHMBbgtChartBU.setEnabled(true);

   mnuViewer.setEnabled(true);
   miMBview.setEnabled(true);
   miPHview.setEnabled(true);
   miJBview.setEnabled(true);

   //Maintinance Menu
   mnuMaintinance.setEnabled(true);
   //Sub Menu for Maintinance
   mnuReqQueManager.setEnabled(true);
   miMobileReqM.setEnabled(true);
   miPhoneReqM.setEnabled(true);
   miJobManager.setEnabled(true);

   //ToolBar
   btnMBbillChart.setEnabled(true);
   btnMBbgtChart.setEnabled(true);
  }
  if(userType.equals("Communication Eng"))
  {
   mnuNewItem.setEnabled(true);
   //Request Menu
   mnuRequest.setEnabled(true);
   //Sub Menu for Request
   mnuNewItem.setEnabled(true);
   miNewHardware.setEnabled(true);
   miHardwareRep.setEnabled(true);
   miNewSoftware.setEnabled(true);
   miSoftwareRep.setEnabled(true);
   miNewMobile.setEnabled(true);
   miMobileRep.setEnabled(true);
   miNewEmail.setEnabled(true);
   miEmailRep.setEnabled(true);
   miNewPhone.setEnabled(true);
   miPhoneRep.setEnabled(true);

   //Jobs Menu
   mnuJob.setEnabled(true);
   //Sub Menu for Jobs
   miPJob.setEnabled(true);

   //Report Menu
   mnuReport.setEnabled(true);
   //Sub Menu for Report
   mnuViewer.setEnabled(true);
   miPHview.setEnabled(true);

   //Maintinance Menu
   mnuMaintinance.setEnabled(true);
   mnuReqQueManager.setEnabled(true);
   miPhoneReqM.setEnabled(true);
  }
  if(userType.equals("Software Staff"))
  {
   mnuNewItem.setEnabled(true);
   //Request Menu
   mnuRequest.setEnabled(true);
   //Sub Menu for Request
   mnuNewItem.setEnabled(true);
   miNewHardware.setEnabled(true);
   miHardwareRep.setEnabled(true);
   miNewSoftware.setEnabled(true);
   miSoftwareRep.setEnabled(true);
   miNewMobile.setEnabled(true);
   miMobileRep.setEnabled(true);
   miNewEmail.setEnabled(true);
   miEmailRep.setEnabled(true);
   miNewPhone.setEnabled(true);
   miPhoneRep.setEnabled(true);

   //Jobs Menu
   mnuJob.setEnabled(true);
   //Sub Menu for Jobs
   miSWJob.setEnabled(true);
   miEJob.setEnabled(true);

   //Reports
   mnuReport.setEnabled(true);
   mnuViewer.setEnabled(true);
   miEMview.setEnabled(true);
   miSWview.setEnabled(true);

   //Maintinance Menu
   mnuMaintinance.setEnabled(true);
   //Sub Menu for Maintinance
   mnuReqQueManager.setEnabled(true);
   miEmailReqM.setEnabled(true);
   miSoftwareReqM.setEnabled(true);
   miJobManager.setEnabled(true);
  }
  if(userType.equals("Operator"))
  {
   mnuNewItem.setEnabled(true);
   //Request Menu
   mnuRequest.setEnabled(true);
   //Sub Menu for Request
   mnuNewItem.setEnabled(true);
   miNewHardware.setEnabled(true);
   miHardwareRep.setEnabled(true);
   miNewSoftware.setEnabled(true);
   miSoftwareRep.setEnabled(true);
   miNewMobile.setEnabled(true);
   miMobileRep.setEnabled(true);
   miNewEmail.setEnabled(true);
   miEmailRep.setEnabled(true);
   miNewPhone.setEnabled(true);
   miPhoneRep.setEnabled(true);
  }
 }

 /**
 * Sets Menu Items Enabled or Disabled
 *
 */

 private void SetMenu(boolean mnVal)
 {
  mnuNewItem.setEnabled(mnVal);
  //Request Menu
  mnuRequest.setEnabled(mnVal);
  //Sub Menu for Request
  mnuNewItem.setEnabled(mnVal);
  miNewHardware.setEnabled(mnVal);
  miHardwareRep.setEnabled(mnVal);
  miNewSoftware.setEnabled(mnVal);
  miSoftwareRep.setEnabled(mnVal);
  miNewMobile.setEnabled(mnVal);
  miMobileRep.setEnabled(mnVal);
  miNewEmail.setEnabled(mnVal);
  miEmailRep.setEnabled(mnVal);
  miNewPhone.setEnabled(mnVal);
  miPhoneRep.setEnabled(mnVal);
  mnuApproval.setEnabled(mnVal);
  miDeptApp.setEnabled(mnVal);
  miISApp.setEnabled(mnVal);

  //Jobs Menu
  mnuJob.setEnabled(mnVal);
  //Sub Menu for Jobs
  miHWJob.setEnabled(mnVal);
  miSWJob.setEnabled(mnVal);
  miMBJob.setEnabled(mnVal);
  miEJob.setEnabled(mnVal);
  miPJob.setEnabled(mnVal);

  //Inventory Menu
  mnuInventory.setEnabled(mnVal);
  //Sub Menu for Inventory
  mnuHardware.setEnabled(mnVal);
  miHWPO.setEnabled(mnVal);
  miHWSTM.setEnabled(mnVal);
  miHWIH.setEnabled(mnVal);
  miHWUR.setEnabled(mnVal);

  mnuMobileInv.setEnabled(mnVal);
  miMBissue.setEnabled(mnVal);
  miMBpStk.setEnabled(mnVal);
  miMBsStk.setEnabled(mnVal);
  miMBbill.setEnabled(mnVal);
  miMBTbill.setEnabled(mnVal);
  miMBbgt.setEnabled(mnVal);

  miSupplier.setEnabled(mnVal);
  miSuppPay.setEnabled(mnVal);
  miIndent.setEnabled(mnVal);

  //Report Menu
  mnuReport.setEnabled(mnVal);
  //Sub Menu for Report
  mnuHWInvRep.setEnabled(mnVal);
  miHWPORep.setEnabled(mnVal);
  miHWPORepDT.setEnabled(mnVal);
  miHWPODetRep.setEnabled(mnVal);
  miSuppRep.setEnabled(mnVal);
  miSuppAllRep.setEnabled(mnVal);
  miHWTotalStockRep.setEnabled(mnVal);
  miHWTotalStockDTRep.setEnabled(mnVal);
  miHWIssuedStockRep.setEnabled(mnVal);
  miHWNewStockRep.setEnabled(mnVal);
  miHWIssuedRep.setEnabled(mnVal);
  miHWIssuedDTRep.setEnabled(mnVal);
  miHWUsersRep.setEnabled(mnVal);
  miHWIndentsRep.setEnabled(mnVal);
  miHWIndentsDTRep.setEnabled(mnVal);
  miHWCIndentsRep.setEnabled(mnVal);

  mnuMBInvRep.setEnabled(mnVal);
  miMBpStkRepF.setEnabled(mnVal);
  miMBpStkRepI.setEnabled(mnVal);
  miMBpStkRepN.setEnabled(mnVal);
  miMBpStkRepB.setEnabled(mnVal);
  miMBsStkRepF.setEnabled(mnVal);
  miMBsStkRepI.setEnabled(mnVal);
  miMBsStkRepN.setEnabled(mnVal);
  miMBsStkRepB.setEnabled(mnVal);
  miMBiSdRep.setEnabled(mnVal);
  miMBbiLRep.setEnabled(mnVal);
  miMBtNtRep.setEnabled(mnVal);
  miMBbGtRep.setEnabled(mnVal);

  mnuChart.setEnabled(mnVal);
  miCHTotalSChart.setEnabled(mnVal);
  miCHTotalSChartDT.setEnabled(mnVal);
  miCHIndentsChart.setEnabled(mnVal);
  miCHIndentsChartDT.setEnabled(mnVal);
  miCHMBbillChart.setEnabled(mnVal);
  miCHMBbillChartDT.setEnabled(mnVal);
  miCHMBbillChartDep.setEnabled(mnVal);
  miCHMBbgtChart.setEnabled(mnVal);
  miCHMBbgtChartDT.setEnabled(mnVal);
  miCHMBbgtChartBU.setEnabled(mnVal);

  mnuViewer.setEnabled(mnVal);
  miEMview.setEnabled(mnVal);
  miHWview.setEnabled(mnVal);
  miMBview.setEnabled(mnVal);
  miPHview.setEnabled(mnVal);
  miSWview.setEnabled(mnVal);
  miJBview.setEnabled(mnVal);

  mnuList.setEnabled(mnVal);
  miUsersRep.setEnabled(mnVal);
  miUsersDeptRep.setEnabled(mnVal);

  //Maintinance Menu
  mnuMaintinance.setEnabled(mnVal);
  //Sub Menu for Maintinance
  miBackupManager.setEnabled(mnVal);
  miImpExp.setEnabled(mnVal);
  miQueryProcessor.setEnabled(mnVal);
  miPrintManager.setEnabled(mnVal);
  miUserManager.setEnabled(mnVal);
  mnuReqQueManager.setEnabled(mnVal);
  miEmailReqM.setEnabled(mnVal);
  miHardwareRemM.setEnabled(mnVal);
  miMobileReqM.setEnabled(mnVal);
  miPhoneReqM.setEnabled(mnVal);
  miSoftwareReqM.setEnabled(mnVal);
  miJobManager.setEnabled(mnVal);
  miPOGRManager.setEnabled(mnVal);

  //ToolBar
  btnStockChart.setEnabled(mnVal);
  btnINChart.setEnabled(mnVal);
  btnMBbillChart.setEnabled(mnVal);
  btnMBbgtChart.setEnabled(mnVal);
  btnQP.setEnabled(mnVal);
  btnUM.setEnabled(mnVal);
 }

 /**
 * Plays background Audio File
 *
 */

 private void playAudioSound(String strAudio)
 {
  try
  {
   URL url = new URL("file:" + strAudio);
   AudioClip ac = Applet.newAudioClip(url);
   ac.play();
  }
  catch (Exception e)
  { System.out.println(e); }
 }

 /**
 * Adds the Internal Frames to the Desktop Pane
 *
 */

 protected void createFrame(JInternalFrame frm)
 {
  JInternalFrame frame = frm;
  frame.setVisible(true);
  dp.add(frame);
  try
  {
   frame.setSelected(true);
  }
  catch (java.beans.PropertyVetoException e)
  {
   System.out.println("frmMain.createFrame Error:\n" +e);
   JOptionPane.showMessageDialog(null, "frmMain.createFrame Error!" +
            "\nError: " + e, "Error",
            JOptionPane.ERROR_MESSAGE);
  }
 }

 /**
 * Display / Hides the Toolbar
 *
 */

 public void setToolBar(String x)
 {
  if(x!=null)
  {
   if (x.equals("Display")) {tb.setVisible(true);}
   if (x.equals("Hide")) {tb.setVisible(false);}
  }
 }

}//Class