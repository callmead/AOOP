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

public class Main extends JFrame

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
 JMenuItem miNewSoftware = new JMenuItem();
 JMenuItem miNewMobile = new JMenuItem();
 JMenuItem miNewEmail = new JMenuItem();
 JMenuItem miNewPhone = new JMenuItem();
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

 public Main(String ec,String ToolBar,String pw)
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
  System.out.println("\n******************************\n CLIENT READY [Main] \n******************************\n");
  //**************************************************************

  EmpCode = ec;TBar=ToolBar;if(!pw.equals(null))Pass=pw;
  this.setTitle("Support Software System (C) 2006-2010 ASKA [Client Software ver: 5.2.02]");
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
  mnuNewItem.addSeparator();
  mnuNewItem.add(miNewHardware);
  mnuNewItem.addSeparator();
  mnuNewItem.add(miNewMobile);
  mnuNewItem.addSeparator();
  mnuNewItem.add(miNewPhone);
  mnuNewItem.addSeparator();
  mnuNewItem.add(miNewSoftware);
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
    Login fl = new Login();
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

  btnLOut.setIcon(imgLogOff);
  btnLOut.setToolTipText("Log Out");
  btnLOut.addActionListener(new java.awt.event.ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    UpdateSecurity();
    dispose();
    Login fl = new Login();
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
  {System.out.println("Client [Main]: EXIT MSG Error");System.out.println("Error: "+re.getMessage());}

  //Update Securty Table...
  Date d = new Date();

  String strQuery="UPDATE Security SET LogOutTime='" + d.toString() + "' WHERE SNo='" + sec.getSNo()+"';";

  try
  {
   seccon.UpdateData(strQuery);
  }catch(RemoteException re)
  {
   System.out.println("Client [Main]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
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
  {System.out.println("Client [Main]: GET USER DATA Error");System.out.println("Error: "+re.getMessage());}

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
   miNewSoftware.setEnabled(true);
   miNewMobile.setEnabled(true);
   miNewEmail.setEnabled(true);
   miNewPhone.setEnabled(true);
   mnuApproval.setEnabled(true);
   miISApp.setEnabled(true);

   }
   if(userType.equals("Manager"))
   {
   mnuNewItem.setEnabled(true);
   //Request Menu
   mnuRequest.setEnabled(true);
   //Sub Menu for Request
   mnuNewItem.setEnabled(true);
   miNewHardware.setEnabled(true);
   miNewSoftware.setEnabled(true);
   miNewMobile.setEnabled(true);
   miNewEmail.setEnabled(true);
   miNewPhone.setEnabled(true);
   mnuApproval.setEnabled(true);
   miDeptApp.setEnabled(true);
  }
  if(userType.equals("Hardware Eng."))
  {
   mnuNewItem.setEnabled(true);
   //Request Menu
   mnuRequest.setEnabled(true);
   //Sub Menu for Request
   mnuNewItem.setEnabled(true);
   miNewHardware.setEnabled(true);
   miNewSoftware.setEnabled(true);
   miNewMobile.setEnabled(true);
   miNewEmail.setEnabled(true);
   miNewPhone.setEnabled(true);

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

   }
   if(userType.equals("Hardware Inv. Eng."))
   {
   mnuNewItem.setEnabled(true);
   //Request Menu
   mnuRequest.setEnabled(true);
   //Sub Menu for Request
   mnuNewItem.setEnabled(true);
   miNewHardware.setEnabled(true);
   miNewSoftware.setEnabled(true);
   miNewMobile.setEnabled(true);
   miNewEmail.setEnabled(true);
   miNewPhone.setEnabled(true);

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
  }
  if(userType.equals("Mobile Inv. Staff"))
  {
   mnuNewItem.setEnabled(true);
   //Request Menu
   mnuRequest.setEnabled(true);
   //Sub Menu for Request
   mnuNewItem.setEnabled(true);
   miNewHardware.setEnabled(true);
   miNewSoftware.setEnabled(true);
   miNewMobile.setEnabled(true);
   miNewEmail.setEnabled(true);
   miNewPhone.setEnabled(true);

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
  }
  if(userType.equals("Communication Eng"))
  {
   mnuNewItem.setEnabled(true);
   //Request Menu
   mnuRequest.setEnabled(true);
   //Sub Menu for Request
   mnuNewItem.setEnabled(true);
   miNewHardware.setEnabled(true);
   miNewSoftware.setEnabled(true);
   miNewMobile.setEnabled(true);
   miNewEmail.setEnabled(true);
   miNewPhone.setEnabled(true);

   //Jobs Menu
   mnuJob.setEnabled(true);
   //Sub Menu for Jobs
   miPJob.setEnabled(true);
  }
  if(userType.equals("Software Staff"))
  {
   mnuNewItem.setEnabled(true);
   //Request Menu
   mnuRequest.setEnabled(true);
   //Sub Menu for Request
   mnuNewItem.setEnabled(true);
   miNewHardware.setEnabled(true);
   miNewSoftware.setEnabled(true);
   miNewMobile.setEnabled(true);
   miNewEmail.setEnabled(true);
   miNewPhone.setEnabled(true);

   //Jobs Menu
   mnuJob.setEnabled(true);
   //Sub Menu for Jobs
   miSWJob.setEnabled(true);
   miEJob.setEnabled(true);
  }
  if(userType.equals("Operator"))
  {
   mnuNewItem.setEnabled(true);
   //Request Menu
   mnuRequest.setEnabled(true);
   //Sub Menu for Request
   mnuNewItem.setEnabled(true);
   miNewHardware.setEnabled(true);
   miNewSoftware.setEnabled(true);
   miNewMobile.setEnabled(true);
   miNewEmail.setEnabled(true);
   miNewPhone.setEnabled(true);
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
  miNewSoftware.setEnabled(mnVal);
  miNewMobile.setEnabled(mnVal);
  miNewEmail.setEnabled(mnVal);
  miNewPhone.setEnabled(mnVal);
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
   System.out.println("Main.createFrame Error:\n" +e);
   JOptionPane.showMessageDialog(null, "Main.createFrame Error!" +
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