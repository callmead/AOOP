//package beximtex;
/**
 * <p>Title: BeximTex, Email Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.io.Serializable;

public class Email implements Serializable
{//Class

 private String f_TransactionID;
 private String f_EmpCode;
 private String f_Date;
 private String f_Remarks;
 private String f_Email1;
 private String f_Email2;
 private String f_Password;
 private String f_DeptApp;
 private String f_DeptComm;
 private String f_DeptAppBy;
 private String f_ISApp;
 private String f_ISComm;
 private String f_ISAppBy;
 private String f_JobStatus;

 /**
  * Default Constructor With no parameter
  *
  */

 public Email()
 {//Default Constructor...

  f_TransactionID ="";
  f_EmpCode  ="";
  f_Date   ="";
  f_Remarks  ="";
  f_Email1  ="";
  f_Email2  ="";
  f_Password  ="";
  f_DeptApp  ="";
  f_DeptComm  ="";
  f_DeptAppBy  ="";
  f_ISApp   ="";
  f_ISComm  ="";
  f_ISAppBy  ="";
  f_JobStatus  ="";

 }//END Default Constructor...


 /**
  * Constructor with parameter
  *
  */

 public Email(Email eml)
 {//Constructor...

  f_TransactionID = eml.f_TransactionID;
  f_EmpCode  = eml.f_EmpCode;
  f_Date   = eml.f_Date;
  f_Remarks  = eml.f_Remarks;
  f_Email1  = eml.f_Email1;
  f_Email2  = eml.f_Email2;
  f_Password  = eml.f_Password;
  f_DeptApp  = eml.f_DeptApp;
  f_DeptComm  = eml.f_DeptComm;
  f_DeptAppBy  = eml.f_DeptAppBy;
  f_ISApp   = eml.f_ISApp;
  f_ISComm  = eml.f_ISComm;
  f_ISAppBy  = eml.f_ISAppBy;
  f_JobStatus  = eml.f_JobStatus;

 }//END Constructor...


    //Setting Values...
 public void setTransactionID(String TransactionID)
 { f_TransactionID=TransactionID; }

 public void setEmpCode(String EmpCode)
 { f_EmpCode=EmpCode; }

 public void setDate(String Date)
 { f_Date=Date; }

 public void setRemarks(String Remarks)
 { f_Remarks=Remarks; }

 public void setEmail1(String Email1)
 { f_Email1=Email1; }

 public void setEmail2(String Email2)
 { f_Email2=Email2; }

 public void setPass(String Password)
 { f_Password=Password; }

 public void setDeptApp(String DeptApp)
 { f_DeptApp=DeptApp; }

 public void setDeptComm(String DeptComm)
 { f_DeptComm=DeptComm; }

 public void setDeptAppBy(String DeptAppBy)
 { f_DeptAppBy=DeptAppBy; }

 public void setISApp(String ISApp)
 { f_ISApp=ISApp; }

 public void setISComm(String ISComm)
 { f_ISComm=ISComm; }

 public void setISAppBy(String ISAppBy)
 { f_ISAppBy=ISAppBy; }

 public void setJobStatus(String JobStatus)
 { f_JobStatus=JobStatus; }


    //Get Methods...
 public String getTransactionID() { return f_TransactionID; }
 public String getEmpCode()    { return f_EmpCode; }
 public String getDate()    { return f_Date; }
 public String getRemarks()    { return f_Remarks; }
 public String getEmail1()    { return f_Email1; }
 public String getEmail2()    { return f_Email2; }
 public String getPass()     { return f_Password; }
 public String getDeptApp()    { return f_DeptApp; }
 public String getDeptComm()   { return f_DeptComm; }
 public String getDeptAppBy()   { return f_DeptAppBy; }
 public String getISApp()    { return f_ISApp; }
 public String getISComm()    { return f_ISComm; }
 public String getISAppBy()    { return f_ISAppBy; }
 public String getJobStatus()   { return f_JobStatus; }

}//Class