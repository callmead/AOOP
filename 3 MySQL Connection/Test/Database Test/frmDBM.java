//package beximtex;
/**
 * <p>Title: BeximTex, Database Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.sql.*;
import java.text.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class frmDBM
    extends JInternalFrame {

  JLabel lblHead = new JLabel();

  boolean isBackup = false;
  boolean isRestore = false;
  String FileName;
  Date d;
  SimpleDateFormat sdf;
  DBU db = new DBU();
  ResultSet rs;
  String Query = new String();

  ImageIcon imgDBM = new ImageIcon("./Images/dbMgr.jpg");
  ImageIcon imgDB = new ImageIcon("./Images/mant1.png");
  ImageIcon imgDsk = new ImageIcon("./Images/disk.gif");
  ImageIcon imgMySQL = new ImageIcon("./Images/mySql.jpg");
  ImageIcon imgJava = new ImageIcon("./Images/javaLogo.gif");
  ImageIcon imgIco = new ImageIcon("./Images/popup.gif");
  ImageIcon imgD = new ImageIcon("./Images/mant1L.png");

  JLabel lblDisk = new JLabel();
  JLabel lblJava = new JLabel();
  JLabel lblIco = new JLabel();
  JPanel pnlMain = new JPanel();
  TitledBorder titledBorder1;
  JPanel pnlButtons = new JPanel();
  JToggleButton btnDelete = new JToggleButton();
  JToggleButton btnClose = new JToggleButton();
  JLabel lblBottom = new JLabel();
  JToggleButton btnCreate = new JToggleButton();
  JComboBox CboMT = new JComboBox();
  JToggleButton btnAutoDelete = new JToggleButton();
  JLabel jLabel112 = new JLabel();
  JToggleButton btnAutoCreate = new JToggleButton();
  JToggleButton btnDeleteRecords = new JToggleButton();
  JLabel lblMySQL = new JLabel();
  JPanel pnlMid = new JPanel();
  TitledBorder titledBorder2;
  TitledBorder titledBorder3;
  JLabel lblH1 = new JLabel();
  JLabel lblSelect = new JLabel();
  JLabel lblType = new JLabel();
  JComboBox CboItem = new JComboBox();
  JTextField txtT = new JTextField();
  JToggleButton btnAdd = new JToggleButton();
  JToggleButton btnRemove = new JToggleButton();

  public frmDBM()
  {
    try {jbInit();}
    catch (Exception e) {e.printStackTrace();}
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,Color.blue),"");
    titledBorder2 = new TitledBorder("");
    titledBorder3 = new TitledBorder("");
    lblMySQL.setIcon(imgMySQL);
    lblMySQL.setBounds(new Rectangle(0, 0, 161, 303));
    lblMySQL.setText("");
    lblHead.setIcon(imgDBM);
    lblHead.setBounds(new Rectangle(147, 7, 546, 161));
    lblHead.setText("");
    lblDisk.setBounds(new Rectangle(569, 72, 73, 65));
    lblDisk.setIcon(imgDsk);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.getContentPane().setBackground(Color.white);
    this.getContentPane().setLayout(null);
    this.setTitle("DATABASE MANAGER");
    this.setMaximum(false);
    this.setFrameIcon(imgIco);
    this.setIconifiable(true);
    this.setClosable(true);

    this.setResizable(false);
    this.setSize(new Dimension(713, 509));
    getTables();

    lblJava.setText("");
    lblJava.setBounds(new Rectangle(642, 55, 65, 84));
    lblJava.setIcon(imgJava);
    lblIco.setBounds(new Rectangle(13, 18, 128, 128));
    lblIco.setIcon(imgD);
    pnlMain.setBackground(Color.white);
    pnlMain.setBorder(titledBorder1);
    pnlMain.setBounds(new Rectangle(8, 165, 687, 305));
    pnlMain.setLayout(null);
    pnlButtons.setBackground(Color.white);
    pnlButtons.setBorder(BorderFactory.createEtchedBorder());
    pnlButtons.setBounds(new Rectangle(165, 6, 517, 293));
    pnlButtons.setLayout(null);
    btnDelete.setBounds(new Rectangle(262, 91, 237, 22));
    btnDelete.setText("DELETE SELECTED TABLE");
    btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(CboMT.getSelectedItem().equals(("BU")))
        {Query = "DROP TABLE IF EXISTS BU;";}
        if(CboMT.getSelectedItem().equals(("Desg")))
        {Query = "DROP TABLE IF EXISTS Desg;";}
        if(CboMT.getSelectedItem().equals(("Dept")))
        {Query = "DROP TABLE IF EXISTS Dept;";}
        if(CboMT.getSelectedItem().equals(("Email")))
        {Query = "DROP TABLE IF EXISTS Email;";}
        if(CboMT.getSelectedItem().equals(("Employees")))
        {Query = "DROP TABLE IF EXISTS Employees;";}
        if(CboMT.getSelectedItem().equals(("Hardware")))
        {Query = "DROP TABLE IF EXISTS Hardware;";}
        if(CboMT.getSelectedItem().equals(("HW_History")))
        {Query = "DROP TABLE IF EXISTS HW_History;";}
        if(CboMT.getSelectedItem().equals(("HW_Issue")))
        {Query = "DROP TABLE IF EXISTS HW_Issue;";}
        if(CboMT.getSelectedItem().equals(("HW_POGR")))
        {Query = "DROP TABLE IF EXISTS HW_POGR;";}
        if(CboMT.getSelectedItem().equals(("HW_Stock")))
        {Query = "DROP TABLE IF EXISTS HW_Stock;";}
        if(CboMT.getSelectedItem().equals(("HW_Users")))
        {Query = "DROP TABLE IF EXISTS HW_Users;";}
        if(CboMT.getSelectedItem().equals(("Indents")))
        {Query = "DROP TABLE IF EXISTS Indents;";}
        if(CboMT.getSelectedItem().equals(("Jobs")))
        {Query = "DROP TABLE IF EXISTS Jobs;";}
        if(CboMT.getSelectedItem().equals(("MB_Bill")))
        {Query = "DROP TABLE IF EXISTS MB_Bill;";}
        if(CboMT.getSelectedItem().equals(("MB_Budget")))
        {Query = "DROP TABLE IF EXISTS MB_Budget;";}
        if(CboMT.getSelectedItem().equals(("MB_Issue")))
        {Query = "DROP TABLE IF EXISTS MB_Issue;";}
        if(CboMT.getSelectedItem().equals(("MB_P_Stock")))
        {Query = "DROP TABLE IF EXISTS MB_P_Stock;";}
        if(CboMT.getSelectedItem().equals(("MB_S_Stock")))
        {Query = "DROP TABLE IF EXISTS MB_S_Stock;";}
        if(CboMT.getSelectedItem().equals(("MB_TBill")))
        {Query = "DROP TABLE IF EXISTS MB_TBill;";}
        if(CboMT.getSelectedItem().equals(("Mobile")))
        {Query = "DROP TABLE IF EXISTS Mobile;";}
        if(CboMT.getSelectedItem().equals(("Payments")))
        {Query = "DROP TABLE IF EXISTS Payments;";}
        if(CboMT.getSelectedItem().equals(("Phone")))
        {Query = "DROP TABLE IF EXISTS Phone;";}
        if(CboMT.getSelectedItem().equals(("Security")))
        {Query = "DROP TABLE IF EXISTS Security;";}
        if(CboMT.getSelectedItem().equals(("Software")))
        {Query = "DROP TABLE IF EXISTS Software;";}
        if(CboMT.getSelectedItem().equals(("Suppliers")))
        {Query = "DROP TABLE IF EXISTS Suppliers;";}
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        ExecuteQueryNow("TABLE "+CboMT.getSelectedItem()+" Deleted!");
      }
    });
    btnClose.setBounds(new Rectangle(20, 175, 479, 22));
    btnClose.setText("CLOSE");
    btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnClose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    lblBottom.setBounds(new Rectangle(13, 0, 299, 39));
    lblBottom.setText("Manage Tables");
    lblBottom.setFont(new java.awt.Font("Monospaced", 1, 20));
    btnCreate.setText("CREATE SELECTED TABLE");
    btnCreate.setBounds(new Rectangle(20, 91, 237, 22));
    btnCreate.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnCreate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(CboMT.getSelectedItem().equals("BU"))
        {Query = "CREATE TABLE BU (BU CHAR(20) Primary Key);";}
        if(CboMT.getSelectedItem().equals(("Dept")))
        {Query = "CREATE TABLE Dept (Department CHAR(20) Primary Key);";}
        if(CboMT.getSelectedItem().equals(("Desg")))
        {Query = "CREATE TABLE Desg (Designation CHAR(20) Primary Key);";}
        if(CboMT.getSelectedItem().equals(("Employees")))
        {Query = "CREATE TABLE Employees (EmpCode CHAR(6) Primary Key, Password CHAR(10), Name CHAR(30), Designation CHAR(20), Department CHAR(20), Ext CHAR(5), DeptHead CHAR(30), HeadDesg CHAR(20), DOJ Date, DOP Date, BU CHAR(20), AppMBamt int(6), UserType CHAR(20), Email CHAR(30), Remarks CHAR(50), CONSTRAINT FK_E_DS FOREIGN KEY (Designation) REFERENCES Desg(Designation), CONSTRAINT FK_E_DP FOREIGN KEY (Department) REFERENCES Dept(Department), CONSTRAINT FK_E_BU FOREIGN KEY (BU) REFERENCES BU(BU));";}
        if(CboMT.getSelectedItem().equals(("Suppliers")))
        {Query = "CREATE TABLE Suppliers (SID CHAR(20) Primary Key, Date Date, Name CHAR(50), Address CHAR(50), Email CHAR(50), Phone CHAR(30), Fax CHAR(30), Mobile CHAR(30), ContactPerson CHAR(30), Remarks CHAR(50));";}
        if(CboMT.getSelectedItem().equals(("HW_Stock")))
        {Query = "CREATE TABLE HW_Stock (ItemCode CHAR(20) Primary Key, Date Date, Item CHAR(30), Brand CHAR(20), Serial CHAR(20), Capacity CHAR(10), MB CHAR(10), Speed CHAR(10), CPUType CHAR(30), Quality CHAR(10), Issued CHAR(5), EmpCode CHAR(6), Warranty CHAR(10), Remarks CHAR(50));";}
        if(CboMT.getSelectedItem().equals(("Indents")))
        {Query = "CREATE TABLE Indents (IndentNo CHAR(20) Primary Key, BU CHAR(20), Date Date, Amount INT, RecFrom CHAR(30), RecDate Date, RecBy CHAR(30), Balance INT, SubmtDate Date, SubmtTo CHAR(30), Remarks CHAR(50), CONSTRAINT FK_IN_BU FOREIGN KEY (BU) REFERENCES BU(BU));";}
        if(CboMT.getSelectedItem().equals(("MB_P_Stock")))
        {Query = "CREATE TABLE MB_P_Stock (SetID CHAR(20) Primary Key, Date Date, SetName CHAR(30), Brand CHAR(30), Model CHAR(20), SNo CHAR(20), Quality CHAR(10), Issued CHAR(5), Warranty CHAR(10), EmpCode CHAR(6), Remarks CHAR(50), CONSTRAINT FK_MBP_EC FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";}
        if(CboMT.getSelectedItem().equals(("MB_S_Stock")))
        {Query = "CREATE TABLE MB_S_Stock (PhoneNo CHAR(10) Primary Key, Date Date, CType CHAR(20), CProvider CHAR(20), CallType CHAR(10), PIN1 CHAR(5), PIN2 CHAR(5), PUK1 CHAR(5), PUK2 CHAR(5), Quality CHAR(10), Issued CHAR(5), EmpCode CHAR(6), AC CHAR(20), Remarks CHAR(50), CONSTRAINT FK_MBS_EC FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";}
        if(CboMT.getSelectedItem().equals(("Email")))
        {Query = "CREATE TABLE Email (TransactionID CHAR(20) Primary Key, EmpCode CHAR(6), Date Date, Remarks CHAR(50), Email1 CHAR(50), Email2 CHAR(50), Password CHAR(10), DeptApp CHAR(5), DeptComm CHAR(50),DeptAppBy CHAR(6), ISApp CHAR(5), ISComm CHAR(50), ISAppBy CHAR(6), JobStatus CHAR(15), CONSTRAINT FK_EM_EC1 FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";}//, CONSTRAINT FK_EM_EC2 FOREIGN KEY (DeptAppBy) REFERENCES Employees(EmpCode), CONSTRAINT FK_EM_EC3 FOREIGN KEY (ISAppBy) REFERENCES Employees(EmpCode)
        if(CboMT.getSelectedItem().equals(("Hardware")))
        {Query = "CREATE TABLE Hardware (TransactionID CHAR(20) Primary Key, EmpCode CHAR(6), Date Date,Description CHAR(50), Need CHAR(50), Spec CHAR(50), DeptApp CHAR(5), DeptComm CHAR(50), DeptAppBy CHAR(6), ISApp CHAR(5), ISComm CHAR(50), ISAppBy CHAR(6), JobStatus CHAR(15), CONSTRAINT FK_HW_EC1 FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";}//, CONSTRAINT FK_HW_EC2 FOREIGN KEY (DeptAppBy) REFERENCES Employees(EmpCode), CONSTRAINT FK_HW_EC3 FOREIGN KEY (ISAppBy) REFERENCES Employees(EmpCode)
        if(CboMT.getSelectedItem().equals(("Mobile")))
        {Query = "CREATE TABLE Mobile (TransactionID CHAR(20) Primary Key, EmpCode CHAR(6), Date Date, Q1 CHAR(5), Q2 CHAR(5), Q2a CHAR(15), Q3 CHAR(50), Q4 CHAR(5), Q5 CHAR(10), Q6 CHAR(50), Q7 CHAR(5), Q8 CHAR(10), Q9 CHAR(5), Q10 CHAR(5), Q11 CHAR(5), Q12 CHAR(50), Q13 CHAR(5), Q13a CHAR(50), Q14 CHAR(10),  DeptApp CHAR(5), DeptComm CHAR(50), DeptAppBy CHAR(6), ISApp CHAR(5), ISComm CHAR(50), ISAppBy CHAR(6), JobStatus CHAR(15), CONSTRAINT FK_M_EC1 FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";}
        if(CboMT.getSelectedItem().equals(("Phone")))
        {Query = "CREATE TABLE Phone (TransactionID CHAR(20) Primary Key, EmpCode CHAR(6), Date Date,RequestType CHAR(20), Need CHAR(50), DeptApp CHAR(5), DeptComm CHAR(50), DeptAppBy CHAR(6), ISApp CHAR(5), ISComm CHAR(50), ISAppBy CHAR(6), Remarks CHAR(50), JobStatus CHAR(15), CONSTRAINT FK_P_EC1 FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";}//, CONSTRAINT FK_P_EC2 FOREIGN KEY (DeptAppBy) REFERENCES Employees(EmpCode), CONSTRAINT FK_P_EC3 FOREIGN KEY (ISAppBy) REFERENCES Employees(EmpCode)
        if(CboMT.getSelectedItem().equals(("Software")))
        {Query = "CREATE TABLE Software (TransactionID CHAR(20) Primary Key, EmpCode CHAR(6), Date Date,RequestType CHAR(20), Description CHAR(50), DeptApp CHAR(5), DeptComm CHAR(50), DeptAppBy CHAR(6), ISApp CHAR(5), ISComm CHAR(50), ISAppBy CHAR(6), JobStatus CHAR(15), CONSTRAINT FK_S_EC1 FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";}//, CONSTRAINT FK_S_EC2 FOREIGN KEY (DeptAppBy) REFERENCES Employees(EmpCode), CONSTRAINT FK_S_EC3 FOREIGN KEY (ISAppBy) REFERENCES Employees(EmpCode)
        if(CboMT.getSelectedItem().equals(("HW_History")))
        {Query = "CREATE TABLE HW_History (SNo INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, ItemCode CHAR(20), Date Date, EmpCode CHAR(6), CONSTRAINT FK_HWH_IC FOREIGN KEY (ItemCode) REFERENCES HW_Stock(ItemCode));";}
        if(CboMT.getSelectedItem().equals(("HW_Issue")))
        {Query = "CREATE TABLE HW_Issue (TransactionID CHAR(20) Primary Key, Date Date, ItemCode CHAR(20), Item CHAR(30), IssuedTo CHAR(6), EmpCode CHAR(6), Remarks CHAR(50), CONSTRAINT FK_HWI_IC FOREIGN KEY (ItemCode) REFERENCES HW_Stock(ItemCode), CONSTRAINT FK_HWI_IT FOREIGN KEY (IssuedTo) REFERENCES Employees(EmpCode), CONSTRAINT FK_HWI_EC FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";}
        if(CboMT.getSelectedItem().equals(("HW_POGR")))
        {Query = "CREATE TABLE HW_POGR (TransactionID CHAR(20) Primary Key, OID CHAR(20), Date Date, SID CHAR(20), Item CHAR(30), QtyOrd INT, QtyRec INT, Price INT, Total INT, EmpCode CHAR(6), Status CHAR(15), OfferNo CHAR(30), OffDated Date, LastDate Date, DeliveryAt CHAR(30), Remarks CHAR(50), CONSTRAINT FK_HWPO_S FOREIGN KEY (SID) REFERENCES Suppliers(SID));";}
        if(CboMT.getSelectedItem().equals(("HW_Users")))
        {Query = "CREATE TABLE HW_Users (EmpCode CHAR(6), Date Date, BIOS_PW CHAR(10), BIOS_SPW CHAR(10), IP CHAR(16), Subnet CHAR(16), NetworkID CHAR(20), NTDomain CHAR(16), DNS CHAR(16), GW CHAR(16), OS CHAR(20), IE CHAR(5), Messenger CHAR(10), Email CHAR(50), Datatex CHAR(5), IFM CHAR(5), Remarks CHAR(50), CONSTRAINT FK_HWU_EC FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";}
        if(CboMT.getSelectedItem().equals(("Payments")))
        {Query = "CREATE TABLE Payments (TransactionID CHAR(20) Primary Key, Date Date, OID CHAR(20), SID CHAR(20), Amount INT, Status CHAR(15), LPD Date, IndentNo CHAR(20), PMode CHAR(30), Remarks CHAR(50), CONSTRAINT FK_PYM_SID FOREIGN KEY (SID) REFERENCES Suppliers(SID));";} //CONSTRAINT FK_PYM_IN FOREIGN KEY (IndentNo) REFERENCES Indents(IndentNo),CONSTRAINT FK_PYM_OID FOREIGN KEY (OID) REFERENCES HW_POGR(OID),
        if(CboMT.getSelectedItem().equals(("Jobs")))
        {Query = "CREATE TABLE Jobs (TransactionID CHAR(20) Primary Key, Date Date, RequestID CHAR(20), ReqFrom CHAR(6), EmpCode CHAR(6), Status CHAR(20), SID CHAR(20), Remarks CHAR(50), CONSTRAINT FK_J_RF FOREIGN KEY (ReqFrom) REFERENCES Employees(EmpCode), CONSTRAINT FK_J_EC FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";}
        if(CboMT.getSelectedItem().equals(("MB_Bill")))
        {Query = "CREATE TABLE MB_Bill (TransactionID CHAR(20) Primary Key, EC CHAR(6), Date Date, CP CHAR(20), Name CHAR(30), MobileNo CHAR(10), Year CHAR(4), Month CHAR(2), Amount INT, Approved INT, Balance INT, EmpCode CHAR(6), Remarks CHAR(50), CONSTRAINT FK_EC1 FOREIGN KEY (EC) REFERENCES Employees(EmpCode), CONSTRAINT FK_EC2 FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";}
        if(CboMT.getSelectedItem().equals(("MB_TBill")))
        {Query = "CREATE TABLE MB_TBill (TransactionID CHAR(20) Primary Key, Year CHAR(4), Month CHAR(2), CCC CHAR(20), UserName CHAR(30), TelName CHAR(30), TelNo CHAR(10), Amount INT, Unit CHAR(30), Area CHAR(10), EmpCode CHAR(6), Remarks CHAR(50), CONSTRAINT FK_MBB_EC FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";}
        if(CboMT.getSelectedItem().equals(("MB_Budget")))
        {Query = "CREATE TABLE MB_Budget (TransactionID CHAR(20) Primary Key, BU CHAR(20), Year CHAR(4), CCC CHAR(20), PhoneNo CHAR(10), MonthlyExp INT, ExpCeiling INT, MonthlyBudget INT, AnnualBudget INT, EmpCode CHAR(6), Remarks CHAR(50), CONSTRAINT FK_MBBT_BU FOREIGN KEY (BU) REFERENCES BU(BU), CONSTRAINT FK_MBBT_EC FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";}
        if(CboMT.getSelectedItem().equals(("MB_Issue")))
        {Query = "CREATE TABLE MB_Issue (TransactionID CHAR(20) Primary Key, Date Date, IssueType CHAR(10), IssueTo CHAR(6), SetOwner CHAR(10), SetID CHAR(20), SetName CHAR(20), PhoneNo CHAR(10), ReturnDate Date, CCC CHAR(20), EmpCode CHAR(6), Remarks CHAR(50), CONSTRAINT FK_MBI_S FOREIGN KEY (SetID) REFERENCES MB_P_Stock(SetID), CONSTRAINT FK_MBI_P FOREIGN KEY (PhoneNo) REFERENCES MB_S_Stock(PhoneNo), CONSTRAINT FK_MBI_IT FOREIGN KEY (IssueTo) REFERENCES Employees(EmpCode), CONSTRAINT FK_MBI_EC FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";}
        if(CboMT.getSelectedItem().equals(("Security")))
        {Query = "CREATE TABLE Security (SNo INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, EmpCode CHAR(6), LogInTime CHAR(30), LogOutTime CHAR(30), Remarks CHAR(50), CONSTRAINT FK_S_EC FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";}
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        ExecuteQueryNow("TABLE "+CboMT.getSelectedItem()+" Created!");
      }
    });
    CboMT.setMaximumRowCount(10);
    CboMT.setBackground(Color.white);
    CboMT.setBounds(new Rectangle(21, 59, 139, 21));
    btnAutoDelete.setBounds(new Rectangle(262, 148, 237, 22));
    btnAutoDelete.setToolTipText("");
    btnAutoDelete.setText("AUTO DELETE ALL TABLES");
    btnAutoDelete.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnAutoDelete.setIcon(new ImageIcon("images/Delete16.gif"));
    btnAutoDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        //Deleting Records First...
        Query = "DELETE FROM Email;";ExecuteQueryNow("");
        Query = "DELETE FROM Hardware;";ExecuteQueryNow("");
        Query = "DELETE FROM Mobile;";ExecuteQueryNow("");
        Query = "DELETE FROM Phone;";ExecuteQueryNow("");
        Query = "DELETE FROM Software;";ExecuteQueryNow("");
        Query = "DELETE FROM Security;";ExecuteQueryNow("");
        Query = "DELETE FROM HW_History;";ExecuteQueryNow("");
        Query = "DELETE FROM HW_Issue;";ExecuteQueryNow("");
        Query = "DELETE FROM HW_POGR;";ExecuteQueryNow("");
        Query = "DELETE FROM HW_Users;";ExecuteQueryNow("");
        Query = "DELETE FROM Jobs;";ExecuteQueryNow("");
        Query = "DELETE FROM MB_Bill;";ExecuteQueryNow("");
        Query = "DELETE FROM MB_Budget;";ExecuteQueryNow("");
        Query = "DELETE FROM MB_Issue;";ExecuteQueryNow("");
        Query = "DELETE FROM MB_TBill;";ExecuteQueryNow("");
        Query = "DELETE FROM Payments;";ExecuteQueryNow("");
        Query = "DELETE FROM HW_Stock;";ExecuteQueryNow("");
        Query = "DELETE FROM MB_P_Stock;";ExecuteQueryNow("");
        Query = "DELETE FROM MB_S_Stock;";ExecuteQueryNow("");
        Query = "DELETE FROM Indents;";ExecuteQueryNow("");
        Query = "DELETE FROM Suppliers;";ExecuteQueryNow("");
        Query = "DELETE FROM Employees;";ExecuteQueryNow("");
        Query = "DELETE FROM BU;";ExecuteQueryNow("");
        Query = "DELETE FROM Desg;";ExecuteQueryNow("");
        Query = "DELETE FROM Dept;";ExecuteQueryNow("");
        //-------------------------------
        //Deleting Tables...
        Query = "DROP TABLE IF EXISTS Email;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS Hardware;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS Mobile;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS Phone;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS Software;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS Security;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS HW_History;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS HW_Issue;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS HW_POGR;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS HW_Users;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS Jobs;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS MB_Bill;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS MB_Budget;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS MB_Issue;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS MB_TBill;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS Payments;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS HW_Stock;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS MB_P_Stock;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS MB_S_Stock;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS Indents;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS Suppliers;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS Employees;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS BU;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS Desg;";ExecuteQueryNow("");
        Query = "DROP TABLE IF EXISTS Dept;";
        ExecuteQueryNow("All Tables Deleted!");
        //-------------------------------
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      }
    });
    jLabel112.setFont(new java.awt.Font("Tahoma", 1, 12));
    jLabel112.setText("Select Table");
    jLabel112.setBounds(new Rectangle(22, 38, 86, 16));
    btnAutoCreate.setToolTipText("");
    btnAutoCreate.setText("AUTO CREATE ALL TABLES");
    btnAutoCreate.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnAutoCreate.setBounds(new Rectangle(20, 148, 237, 22));
    btnAutoCreate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        Query = "CREATE TABLE BU (BU CHAR(20) Primary Key);";ExecuteQueryNow("");
        Query = "CREATE TABLE Dept (Department CHAR(20) Primary Key);";ExecuteQueryNow("");
        Query = "CREATE TABLE Desg (Designation CHAR(20) Primary Key);";ExecuteQueryNow("");
        Query = "CREATE TABLE Employees (EmpCode CHAR(6) Primary Key, Password CHAR(10), Name CHAR(30), Designation CHAR(20), Department CHAR(20), Ext CHAR(5), DeptHead CHAR(30), HeadDesg CHAR(20), DOJ Date, DOP Date, BU CHAR(20), AppMBamt int(6), UserType CHAR(20), Email CHAR(30), Remarks CHAR(50), CONSTRAINT FK_E_DS FOREIGN KEY (Designation) REFERENCES Desg(Designation), CONSTRAINT FK_E_DP FOREIGN KEY (Department) REFERENCES Dept(Department), CONSTRAINT FK_E_BU FOREIGN KEY (BU) REFERENCES BU(BU));";ExecuteQueryNow("");
        Query = "CREATE TABLE Suppliers (SID CHAR(20) Primary Key, Date Date, Name CHAR(50), Address CHAR(50), Email CHAR(50), Phone CHAR(30), Fax CHAR(30), Mobile CHAR(30), ContactPerson CHAR(30), Remarks CHAR(50));";ExecuteQueryNow("");
        Query = "CREATE TABLE HW_Stock (ItemCode CHAR(20) Primary Key, Date Date, Item CHAR(30), Brand CHAR(20), Serial CHAR(20), Capacity CHAR(10), MB CHAR(10), Speed CHAR(10), CPUType CHAR(30), Quality CHAR(10), Issued CHAR(5), EmpCode CHAR(6), Warranty CHAR(10), Remarks CHAR(50));";ExecuteQueryNow("");
        Query = "CREATE TABLE Indents (IndentNo CHAR(20) Primary Key, BU CHAR(20), Date Date, Amount INT, RecFrom CHAR(30), RecDate Date, RecBy CHAR(30), Balance INT, SubmtDate Date, SubmtTo CHAR(30), Remarks CHAR(50), CONSTRAINT FK_IN_BU FOREIGN KEY (BU) REFERENCES BU(BU));";;ExecuteQueryNow("");
        Query = "CREATE TABLE MB_P_Stock (SetID CHAR(20) Primary Key, Date Date, SetName CHAR(30), Brand CHAR(30), Model CHAR(20), SNo CHAR(20), Quality CHAR(10), Issued CHAR(5), Warranty CHAR(10), EmpCode CHAR(6), Remarks CHAR(50), CONSTRAINT FK_MBP_EC FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";ExecuteQueryNow("");
        Query = "CREATE TABLE MB_S_Stock (PhoneNo CHAR(10) Primary Key, Date Date, CType CHAR(20), CProvider CHAR(20), CallType CHAR(10), PIN1 CHAR(5), PIN2 CHAR(5), PUK1 CHAR(5), PUK2 CHAR(5), Quality CHAR(10), Issued CHAR(5), EmpCode CHAR(6), AC CHAR(20), Remarks CHAR(50), CONSTRAINT FK_MBS_EC FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";ExecuteQueryNow("");
        Query = "CREATE TABLE Email (TransactionID CHAR(20) Primary Key, EmpCode CHAR(6), Date Date, Remarks CHAR(50), Email1 CHAR(50), Email2 CHAR(50), Password CHAR(10), DeptApp CHAR(5), DeptComm CHAR(50),DeptAppBy CHAR(6), ISApp CHAR(5), ISComm CHAR(50), ISAppBy CHAR(6), JobStatus CHAR(15), CONSTRAINT FK_EM_EC1 FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";ExecuteQueryNow("");
        Query = "CREATE TABLE Hardware (TransactionID CHAR(20) Primary Key, EmpCode CHAR(6), Date Date,Description CHAR(50), Need CHAR(50), Spec CHAR(50), DeptApp CHAR(5), DeptComm CHAR(50), DeptAppBy CHAR(6), ISApp CHAR(5), ISComm CHAR(50), ISAppBy CHAR(6), JobStatus CHAR(15), CONSTRAINT FK_HW_EC1 FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";ExecuteQueryNow("");
        Query = "CREATE TABLE Mobile (TransactionID CHAR(20) Primary Key, EmpCode CHAR(6), Date Date, Q1 CHAR(5), Q2 CHAR(5), Q2a CHAR(15), Q3 CHAR(50), Q4 CHAR(5), Q5 CHAR(10), Q6 CHAR(50), Q7 CHAR(5), Q8 CHAR(10), Q9 CHAR(5), Q10 CHAR(5), Q11 CHAR(5), Q12 CHAR(50), Q13 CHAR(5), Q13a CHAR(50), Q14 CHAR(10),  DeptApp CHAR(5), DeptComm CHAR(50), DeptAppBy CHAR(6), ISApp CHAR(5), ISComm CHAR(50), ISAppBy CHAR(6), JobStatus CHAR(15), CONSTRAINT FK_M_EC1 FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";ExecuteQueryNow("");
        Query = "CREATE TABLE Phone (TransactionID CHAR(20) Primary Key, EmpCode CHAR(6), Date Date,RequestType CHAR(20), Need CHAR(50), DeptApp CHAR(5), DeptComm CHAR(50), DeptAppBy CHAR(6), ISApp CHAR(5), ISComm CHAR(50), ISAppBy CHAR(6), Remarks CHAR(50), JobStatus CHAR(15), CONSTRAINT FK_P_EC1 FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";ExecuteQueryNow("");
        Query = "CREATE TABLE Software (TransactionID CHAR(20) Primary Key, EmpCode CHAR(6), Date Date,RequestType CHAR(20), Description CHAR(50), DeptApp CHAR(5), DeptComm CHAR(50), DeptAppBy CHAR(6), ISApp CHAR(5), ISComm CHAR(50), ISAppBy CHAR(6), JobStatus CHAR(15), CONSTRAINT FK_S_EC1 FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";ExecuteQueryNow("");
        Query = "CREATE TABLE HW_History (SNo INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, ItemCode CHAR(20), Date Date, EmpCode CHAR(6), CONSTRAINT FK_HWH_IC FOREIGN KEY (ItemCode) REFERENCES HW_Stock(ItemCode));";ExecuteQueryNow("");
        Query = "CREATE TABLE HW_Issue (TransactionID CHAR(20) Primary Key, Date Date, ItemCode CHAR(20), Item CHAR(30), IssuedTo CHAR(6), EmpCode CHAR(6), Remarks CHAR(50), CONSTRAINT FK_HWI_IC FOREIGN KEY (ItemCode) REFERENCES HW_Stock(ItemCode), CONSTRAINT FK_HWI_IT FOREIGN KEY (IssuedTo) REFERENCES Employees(EmpCode), CONSTRAINT FK_HWI_EC FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";ExecuteQueryNow("");
        Query = "CREATE TABLE HW_POGR (TransactionID CHAR(20) Primary Key, OID CHAR(20), Date Date, SID CHAR(20), Item CHAR(30), QtyOrd INT, QtyRec INT, Price INT, Total INT, EmpCode CHAR(6), Status CHAR(15), OfferNo CHAR(30), OffDated Date, LastDate Date, DeliveryAt CHAR(30), Remarks CHAR(50), CONSTRAINT FK_HWPO_S FOREIGN KEY (SID) REFERENCES Suppliers(SID));";ExecuteQueryNow("");
        Query = "CREATE TABLE HW_Users (EmpCode CHAR(6), Date Date, BIOS_PW CHAR(10), BIOS_SPW CHAR(10), IP CHAR(16), Subnet CHAR(16), NetworkID CHAR(20), NTDomain CHAR(16), DNS CHAR(16), GW CHAR(16), OS CHAR(20), IE CHAR(5), Messenger CHAR(10), Email CHAR(50), Datatex CHAR(5), IFM CHAR(5), Remarks CHAR(50), CONSTRAINT FK_HWU_EC FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";ExecuteQueryNow("");
        Query = "CREATE TABLE Payments (TransactionID CHAR(20) Primary Key, Date Date, OID CHAR(20), SID CHAR(20), Amount INT, Status CHAR(15), LPD Date, IndentNo CHAR(20), PMode CHAR(30), Remarks CHAR(50), CONSTRAINT FK_PYM_SID FOREIGN KEY (SID) REFERENCES Suppliers(SID));";;ExecuteQueryNow("");
        Query = "CREATE TABLE Jobs (TransactionID CHAR(20) Primary Key, Date Date, RequestID CHAR(20), ReqFrom CHAR(6), EmpCode CHAR(6), Status CHAR(20), SID CHAR(20), Remarks CHAR(50), CONSTRAINT FK_J_RF FOREIGN KEY (ReqFrom) REFERENCES Employees(EmpCode), CONSTRAINT FK_J_EC FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";ExecuteQueryNow("");
        Query = "CREATE TABLE MB_Bill (TransactionID CHAR(20) Primary Key, EC CHAR(6), Date Date, CP CHAR(20), Name CHAR(30), MobileNo CHAR(10), Year CHAR(4), Month CHAR(2), Amount INT, Approved INT, Balance INT, EmpCode CHAR(6), Remarks CHAR(50), CONSTRAINT FK_EC1 FOREIGN KEY (EC) REFERENCES Employees(EmpCode), CONSTRAINT FK_EC2 FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";ExecuteQueryNow("");
        Query = "CREATE TABLE MB_TBill (TransactionID CHAR(20) Primary Key, Year CHAR(4), Month CHAR(2), CCC CHAR(20), UserName CHAR(30), TelName CHAR(30), TelNo CHAR(10), Amount INT, Unit CHAR(30), Area CHAR(10), EmpCode CHAR(6), Remarks CHAR(50), CONSTRAINT FK_MBB_EC FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";ExecuteQueryNow("");
        Query = "CREATE TABLE MB_Budget (TransactionID CHAR(20) Primary Key, BU CHAR(20), Year CHAR(4), CCC CHAR(20), PhoneNo CHAR(10), MonthlyExp INT, ExpCeiling INT, MonthlyBudget INT, AnnualBudget INT, EmpCode CHAR(6), Remarks CHAR(50), CONSTRAINT FK_MBBT_BU FOREIGN KEY (BU) REFERENCES BU(BU), CONSTRAINT FK_MBBT_EC FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";ExecuteQueryNow("");
        Query = "CREATE TABLE MB_Issue (TransactionID CHAR(20) Primary Key, Date Date, IssueType CHAR(10), IssueTo CHAR(6), SetOwner CHAR(10), SetID CHAR(20), SetName CHAR(20), PhoneNo CHAR(10), ReturnDate Date, CCC CHAR(20), EmpCode CHAR(6), Remarks CHAR(50), CONSTRAINT FK_MBI_S FOREIGN KEY (SetID) REFERENCES MB_P_Stock(SetID), CONSTRAINT FK_MBI_P FOREIGN KEY (PhoneNo) REFERENCES MB_S_Stock(PhoneNo), CONSTRAINT FK_MBI_IT FOREIGN KEY (IssueTo) REFERENCES Employees(EmpCode), CONSTRAINT FK_MBI_EC FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";ExecuteQueryNow("");
        Query = "CREATE TABLE Security (SNo INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, EmpCode CHAR(6), LogInTime CHAR(30), LogOutTime CHAR(30), Remarks CHAR(50), CONSTRAINT FK_S_EC FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode));";
        ExecuteQueryNow("All Tables Created!");
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      }
    });
    btnDeleteRecords.setBounds(new Rectangle(20, 119, 479, 22));
    btnDeleteRecords.setText("DELETE RECORDS FROM SELECTED TABLE");
    btnDeleteRecords.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnDeleteRecords.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if(CboMT.getSelectedItem().equals(("BU")))
        {Query = "DELETE FROM BU;";}
        if(CboMT.getSelectedItem().equals(("Desg")))
        {Query = "DELETE FROM Desg;";}
        if(CboMT.getSelectedItem().equals(("Dept")))
        {Query = "DELETE FROM Dept;";}
        if(CboMT.getSelectedItem().equals(("Email")))
        {Query = "DELETE FROM Email;";}
        if(CboMT.getSelectedItem().equals(("Employees")))
        {Query = "DELETE FROM Employees;";}
        if(CboMT.getSelectedItem().equals(("Hardware")))
        {Query = "DELETE FROM Hardware;";}
        if(CboMT.getSelectedItem().equals(("HW_History")))
        {Query = "DELETE FROM HW_History;";}
        if(CboMT.getSelectedItem().equals(("HW_Issue")))
        {Query = "DELETE FROM HW_Issue;";}
        if(CboMT.getSelectedItem().equals(("HW_POGR")))
        {Query = "DELETE FROM HW_POGR;";}
        if(CboMT.getSelectedItem().equals(("HW_Stock")))
        {Query = "DELETE FROM HW_Stock;";}
        if(CboMT.getSelectedItem().equals(("HW_Users")))
        {Query = "DELETE FROM HW_Users;";}
        if(CboMT.getSelectedItem().equals(("Indents")))
        {Query = "DELETE FROM Indents;";}
        if(CboMT.getSelectedItem().equals(("Jobs")))
        {Query = "DELETE FROM Jobs;";}
        if(CboMT.getSelectedItem().equals(("MB_Bill")))
        {Query = "DELETE FROM MB_Bill;";}
        if(CboMT.getSelectedItem().equals(("MB_Budget")))
        {Query = "DELETE FROM MB_Budget;";}
        if(CboMT.getSelectedItem().equals(("MB_Issue")))
        {Query = "DELETE FROM MB_Issue;";}
        if(CboMT.getSelectedItem().equals(("MB_P_Stock")))
        {Query = "DELETE FROM MB_P_Stock;";}
        if(CboMT.getSelectedItem().equals(("MB_S_Stock")))
        {Query = "DELETE FROM MB_S_Stock;";}
        if(CboMT.getSelectedItem().equals(("MB_TBill")))
        {Query = "DELETE FROM MB_TBill;";}
        if(CboMT.getSelectedItem().equals(("Mobile")))
        {Query = "DELETE FROM Mobile;";}
        if(CboMT.getSelectedItem().equals(("Payments")))
        {Query = "DELETE FROM Payments;";}
        if(CboMT.getSelectedItem().equals(("Phone")))
        {Query = "DELETE FROM Phone;";}
        if(CboMT.getSelectedItem().equals(("Security")))
        {Query = "DELETE FROM Security;";}
        if(CboMT.getSelectedItem().equals(("Software")))
        {Query = "DELETE FROM Software;";}
        if(CboMT.getSelectedItem().equals(("Suppliers")))
        {Query = "DELETE FROM Suppliers;";}
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        ExecuteQueryNow("Records of TABLE "+CboMT.getSelectedItem()+" Deleted!");
      }
    });
    pnlMid.setBackground(Color.white);
    pnlMid.setBorder(titledBorder3);
    pnlMid.setBounds(new Rectangle(20, 206, 479, 80));
    pnlMid.setLayout(null);
    lblH1.setText("ADD / REMOVE ITEMS");
    lblH1.setBounds(new Rectangle(7, 5, 182, 15));
    lblH1.setFont(new java.awt.Font("Tahoma", 1, 12));
    lblSelect.setBounds(new Rectangle(8, 24, 104, 16));
    lblSelect.setText("Select Item");
    lblSelect.setFont(new java.awt.Font("Tahoma", 1, 12));
    lblType.setBounds(new Rectangle(8, 49, 44, 16));
    lblType.setText("Type");
    lblType.setFont(new java.awt.Font("Tahoma", 1, 12));
    CboItem.setBounds(new Rectangle(118, 23, 139, 21));
    CboItem.setBackground(Color.white);
    CboItem.setMaximumRowCount(10);
    CboItem.addItem("Business Unit");
    CboItem.addItem("Designation");
    CboItem.addItem("Department");
    txtT.setText("");
    txtT.setBounds(new Rectangle(118, 49, 139, 21));
    txtT.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(!txtT.getText().equals(""))
        {
          if (CboItem.getSelectedIndex()==0){Query="INSERT INTO BU VALUES('" + txtT.getText() + "');";}
          if (CboItem.getSelectedIndex()==1){Query="INSERT INTO Desg VALUES('" + txtT.getText() + "');";}
          if (CboItem.getSelectedIndex()==2){Query="INSERT INTO Dept VALUES('" + txtT.getText() + "');";}
          ExecuteQueryNow("Item "+txtT.getText()+" Added in "+CboItem.getSelectedItem());
        }
        else{txtT.requestFocus();}
      }
    });
    btnAdd.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnAdd.setText("ADD ITEM");
    btnAdd.setBounds(new Rectangle(266, 22, 201, 22));
    btnRemove.setBounds(new Rectangle(266, 48, 201, 22));
    btnRemove.setText("REMOVE ITEM");
    btnRemove.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnRemove.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(!txtT.getText().equals(""))
        {
          if (CboItem.getSelectedIndex()==0){Query="DELETE FROM BU WHERE BU='" + txtT.getText() + "';";}
          if (CboItem.getSelectedIndex()==1){Query="DELETE FROM Desg WHERE Designation='" + txtT.getText() + "';";}
          if (CboItem.getSelectedIndex()==2){Query="DELETE FROM Dept WHERE Department='" + txtT.getText() + "';";}
          ExecuteQueryNow("Item "+txtT.getText()+" Removed from "+CboItem.getSelectedItem());
        }
        else{txtT.requestFocus();}
      }
    });
    this.getContentPane().add(lblIco, null);
    this.getContentPane().add(lblJava, null);
    this.getContentPane().add(lblDisk, null);
    pnlButtons.add(lblBottom, null);
    pnlButtons.add(jLabel112, null);
    pnlButtons.add(CboMT, null);
    pnlButtons.add(btnDelete, null);
    pnlButtons.add(btnDeleteRecords, null);
    pnlButtons.add(btnCreate, null);
    pnlButtons.add(btnClose, null);
    pnlButtons.add(btnAutoCreate, null);
    pnlButtons.add(btnAutoDelete, null);
    pnlButtons.add(pnlMid, null);
    pnlMain.add(lblMySQL, null);
    pnlMain.add(pnlButtons, null);
    this.getContentPane().add(pnlMain, null);
    this.getContentPane().add(lblHead, null);
    pnlMid.add(lblH1, null);
    pnlMid.add(lblSelect, null);
    pnlMid.add(CboItem, null);
    pnlMid.add(lblType, null);
    pnlMid.add(txtT, null);
    pnlMid.add(btnAdd, null);
    pnlMid.add(btnRemove, null);
  }

  private void ExecuteQueryNow(String x)
  {
    if(!x.equals("")){frmWork w = new frmWork("PROCESSING");w.setSize(368, 140);w.setVisible(true);}
    try
    {db.stmt.executeUpdate(Query);}
    catch(SQLException sqle)
    {
      System.out.println("*** Error: Executing Command!");
      System.out.println("*** Exception: "+sqle);
      JOptionPane.showMessageDialog(null,"Error Occured While Exexuting Command!\nPlease Contact Your Developer"+"\nError Msg: "+sqle.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
      return;
    }
    if(!x.equals("")){JOptionPane.showMessageDialog(null,x,"Information",1);}
  }

  private void getTables() {
    String ComboData = new String("");
    try
    {
      rs = db.stmt.executeQuery("Show Tables;");
      if (!rs.next())
      {JOptionPane.showMessageDialog(null, "No Tables Found in the Database!");return;}
      ResultSetMetaData rsmd = rs.getMetaData();
      do
      {
        for (int i = 1; i <= rsmd.getColumnCount(); ++i)
        {
          ComboData = new String("");
          ComboData = (rs.getString(i));
          CboMT.addItem(ComboData);
        }
      }
      while (rs.next());
    }catch (SQLException sqle)
    {
      System.out.println("\nSet Row data Error !\n" + sqle);
      JOptionPane.showMessageDialog(null, "Error in Querry !!!", "Error...",
                                    JOptionPane.ERROR_MESSAGE);
    }
  }
  void btnClose_actionPerformed(ActionEvent e) {}
  void btnCreate_actionPerformed(ActionEvent e) {}
  void btnAutoDelete_actionPerformed(ActionEvent e) {}
  void btnAutoCreate_actionPerformed(ActionEvent e) {}
  void btnDeleteRecords_actionPerformed(ActionEvent e) {}
  void btnAdd_actionPerformed(ActionEvent e) {}
  void btnRemove_actionPerformed(ActionEvent e) {}
}