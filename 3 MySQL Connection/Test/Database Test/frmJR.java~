package beximtex;
/**
 * <p>Title: BeximTex, Report Processor</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.view.*;
import java.awt.Color;

class frmJR extends JInternalFrame
{
        DBU db = new DBU();
        ResultSet rs;
        String rptTitle,rptName,rptQuery,rptParameters;

        ImageIcon imgIco = new ImageIcon("./Images/popup.gif");

        public frmJR(String T, String ReportName, String p)
        {
                rptTitle=T;rptName=ReportName;rptParameters=p;
                checkValidity();
        }

        private void showReport()
        {
                try
                {
                        rs = db.stmt.executeQuery(rptQuery);
                          JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                          Map parameters = new HashMap();

                          JasperReport template = JasperManager.loadReport(new FileInputStream(
                              rptName));
                          java.util.Map reportParameters = new HashMap();
                          JasperPrint report = JasperManager.fillReport(template, parameters,
                              jrRS);
                          net.sf.jasperreports.view.JRViewer jrv = new net.sf.jasperreports.view.
                              JRViewer(report);

                          this.setClosable(true);
                          this.setIconifiable(true);
                          this.setMaximizable(true);
                          this.setResizable(true);
                          this.setFrameIcon(imgIco);
                          this.setTitle(rptTitle);
                          this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                          this.getContentPane().add(jrv);
                          this.pack();
                          this.setSize(700, 400);
                          this.setVisible(true);
                }
                catch(SQLException sqle){JOptionPane.showMessageDialog(null, "NO MATCH DATA FOUND for the Query Requested!",rptTitle,1);}
                catch(Exception ex){System.out.println(ex);ex.printStackTrace();}
        }

        private void checkValidity()
        {
                if(rptName.equals("./Reports/HW_PO"))
                {
                        if(rptParameters.equals(""))
                        {
                                System.out.println("Parameter Required...");
                            JOptionPane.showMessageDialog(null,
                                    "Report Error!" + "\nError: Parameter Required!",
                                    "Report Error", JOptionPane.ERROR_MESSAGE);

                        }else
                        {
                                System.out.println("Opening Report...");
                                rptName=rptName+".jasper";
                                rptQuery="SELECT HW_POGR.OID as 'PO',HW_POGR.Date,HW_POGR.SID,HW_POGR.Item,HW_POGR.QtyOrd as 'Quantity',HW_POGR.Price as 'Price',HW_POGR.Total,HW_POGR.OfferNo,HW_POGR.OffDated as 'Dated',HW_POGR.LastDate as 'Deliver By',HW_POGR.DeliveryAt, Suppliers.Name as 'Supplier',Suppliers.Address,Suppliers.Email,Suppliers.Phone,Suppliers.Fax,Suppliers.Mobile,Suppliers.ContactPerson FROM HW_POGR,Suppliers "+rptParameters+"";
                                showReport();
                        }
                }
                else if(rptName.equals("./Reports/PO_Det"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT * FROM HW_POGR "+rptParameters+" ORDER BY OID,Date";
                        showReport();
                }
                else if(rptName.equals("./Reports/Emp"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT * FROM Employees "+rptParameters+" ORDER BY Department,EmpCode";
                        showReport();
                }
                else if(rptName.equals("./Reports/HW_Stock"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT ItemCode,Date,Item,Brand,Quality,Issued,Warranty FROM HW_Stock "+rptParameters+"";
                        showReport();
                }
                else if(rptName.equals("./Reports/HW_Issue"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT HW_Issue.ItemCode, HW_Issue.Date, HW_Issue.Item, HW_Issue.IssuedTo, Employees.Name, Employees.Department, HW_Issue.EmpCode FROM HW_Issue, Employees WHERE HW_Issue.IssuedTo = Employees.EmpCode "+rptParameters+" ORDER BY Employees.Department,HW_Issue.Item";
                        showReport();
                }
                else if(rptName.equals("./Reports/HW_Users"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT EmpCode,Date,IP,Subnet,NetworkID,NTDomain,DNS,OS,IE,Messenger,Datatex,IFM FROM HW_Users "+rptParameters+" ORDER BY IP;";
                        showReport();
                }
                else if(rptName.equals("./Reports/Indents"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT * FROM Indents "+rptParameters+" ORDER BY BU";
                        showReport();
                }
                else if(rptName.equals("./Reports/Supp"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT * FROM Suppliers "+rptParameters+" ORDER BY SID,Date";
                        showReport();
                }
                else if(rptName.equals("./Reports/HW_Chart"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT Item,COUNT(Item) as 'Quantity' from HW_Stock "+rptParameters+" GROUP BY Item";
                        showReport();
                }
                else if(rptName.equals("./Reports/IN_Chart"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT BU, Date, SUM(Amount) as 'Amount',Remarks from Indents WHERE Remarks NOT LIKE'Ca%' "+rptParameters+" GROUP BY BU";
                        showReport();
                }
                else if(rptName.equals("./Reports/Email"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT Employees.Name, Employees.EmpCode, Employees.Designation, Employees.Department, Employees.Ext, Employees.BU, Email.TransactionID, Email.Date, Email.Remarks, Email.Email1, Email.Email2, Email.Password FROM Email, Employees WHERE (Email.EmpCode=Employees.EmpCode) "+rptParameters+"";
                        showReport();
                }
                else if(rptName.equals("./Reports/Hardware"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT Employees.EmpCode, Employees.Name, Employees.Designation, Employees.Department, Employees.Ext, Employees.BU, Hardware.TransactionID, Hardware.Date, Hardware.Description, Hardware.Need, Hardware.Spec FROM Hardware, Employees WHERE (Hardware.EmpCode=Employees.EmpCode) "+rptParameters+"";
                        showReport();
                }
                else if(rptName.equals("./Reports/Mobile"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT Employees.Name, Employees.EmpCode, Employees.Department, Employees.Designation, Employees.Ext, Employees.DOJ, Employees.DOP, Employees.BU, Employees.DeptHead, Employees.HeadDesg, Mobile.TransactionID, Mobile.Date, Mobile.Q1, Mobile.Q2, Mobile.Q2a, Mobile.Q3, Mobile.Q4, Mobile.Q5, Mobile.Q6, Mobile.Q7, Mobile.Q8, Mobile.Q9, Mobile.Q10, Mobile.Q11, Mobile.Q12, Mobile.Q13, Mobile.Q13a, Mobile.Q14 FROM Mobile, Employees WHERE (Employees.EmpCode = Mobile.EmpCode) "+rptParameters+"";
                        showReport();
                }
                else if(rptName.equals("./Reports/Phone"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT Employees.EmpCode, Employees.Name, Employees.Designation, Employees.Department, Employees.Ext, Employees.BU, Phone.TransactionID, Phone.Date, Phone.RequestType, Phone.Need FROM Phone, Employees WHERE (Phone.EmpCode = Employees.EmpCode) "+rptParameters+"";
                        showReport();
                }
                else if(rptName.equals("./Reports/Software"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT Employees.EmpCode, Employees.Name, Employees.Designation, Employees.Department, Employees.Ext, Employees.BU, Software.TransactionID, Software.Date, Software.RequestType, Software.Description FROM Software, Employees WHERE (Software.EmpCode = Employees.EmpCode) "+rptParameters+"";
                        showReport();
                }
                else if(rptName.equals("./Reports/MB_P_Stock"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT SetID,Date,SetName as 'Set',Model,Quality,Issued,Warranty FROM MB_P_Stock "+rptParameters+" ORDER BY Date,SetName;";
                        showReport();
                }
                else if(rptName.equals("./Reports/MB_S_Stock"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT PhoneNo,Date,CProvider,CallType,Quality,Issued,AC FROM MB_S_Stock "+rptParameters+" ORDER BY PhoneNo;";
                        showReport();
                }
                else if(rptName.equals("./Reports/MB_Issue"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT MB_Issue.Date,MB_Issue.IssueType,MB_Issue.IssueTo as 'IssuedTo',Employees.Name,Employees.Department,MB_Issue.SetOwner,MB_Issue.SetName,MB_Issue.PhoneNo,MB_Issue.CCC FROM MB_Issue,Employees WHERE MB_Issue.IssueTo=Employees.EmpCode "+rptParameters+" ORDER BY Employees.Department,Employees.Name;";
                        showReport();
                }
                else if(rptName.equals("./Reports/MB_Bill"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT MB_Bill.EC as 'Employee',MB_Bill.Name,Employees.Department,MB_Bill.Date,MB_Bill.CP as 'Provider',MB_Bill.MobileNo,MB_Bill.Year,MB_Bill.Month,MB_Bill.Amount,MB_Bill.Balance FROM MB_Bill,Employees WHERE MB_Bill.EC=Employees.EmpCode "+rptParameters+" ORDER BY MB_Bill.Year,MB_Bill.Month,Employees.Department,Employees.Name;";
                        showReport();
                }
                else if(rptName.equals("./Reports/MB_BChart"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT MB_Bill.Year,Employees.Department,SUM(MB_Bill.Amount) AS 'Amount' FROM MB_Bill,Employees WHERE MB_Bill.EC=Employees.EmpCode "+rptParameters+" GROUP BY Employees.Department,MB_Bill.Year ORDER BY MB_Bill.Year,Employees.Department;";
                        showReport();
                }
                else if(rptName.equals("./Reports/MB_BgtChart"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT Year,BU,SUM(AnnualBudget) AS 'Budget' FROM MB_Budget "+rptParameters+" GROUP BY BU,Year ORDER BY BU,Year;";
                        showReport();
                }
                else if(rptName.equals("./Reports/MB_TBill"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT UserName as 'User',TelName,TelNo,Year,Month,Amount,Area,CCC FROM MB_TBill "+rptParameters+" ORDER BY Year,Month,UserName;";
                        showReport();
                }
                else if(rptName.equals("./Reports/MB_Budget"))
                {
                        System.out.println("Opening Report...");
                        rptName=rptName+".jasper";
                        rptQuery="SELECT BU,Year,CCC,PhoneNo,MonthlyExp,ExpCeiling,MonthlyBudget as 'MonthlyBgt',AnnualBudget as 'AnnualBgt' FROM MB_Budget "+rptParameters+" ORDER BY Year,BU,PhoneNo;";
                        showReport();
                }

                else
                {
                        System.out.println("Error: java.lang.ClassNotFound Exception");
                    JOptionPane.showMessageDialog(null,
                                    "java.lang.ClassNotFound Exception",
                                    "Report Error", JOptionPane.ERROR_MESSAGE);
                dispose();}

        }

  public frmJR() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    this.getContentPane().setBackground(new Color(0, 74, 97));
  }

}//End of class
