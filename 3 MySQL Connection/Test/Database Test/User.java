//package beximtex;
/**
 * <p>Title: BeximTex, User Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.io.Serializable;

public class User implements Serializable
{//Class

 private String f_EmpCode;
 private String f_Password;
 private String f_Name;
 private String f_Designation;
 private String f_Department;
 private String f_Ext;
 private String f_DeptHead;
 private String f_HeadDesg;
 private String f_DOJ;
 private String f_DOP;
 private String f_BU;
 private String f_AppMBamt;
 private String f_UserType;
 private String f_Email;
 private String f_Remarks;

 /**
  * Default Constructor With no parameter
  *
  */

 public User()
 {//Default Constructor...

  f_EmpCode  ="";
  f_Password  ="";
  f_Name   ="";
  f_Designation ="";
  f_Department ="";
  f_Ext   ="";
  f_DeptHead  ="";
  f_HeadDesg  ="";
  f_DOJ   ="";
  f_DOP   ="";
  f_BU   ="";
  f_AppMBamt  ="";
  f_UserType  ="";
  f_Email   ="";
  f_Remarks  ="";

 }//END Default Constructor...


 /**
  * Constructor with parameter
  *
  */

 public User(User usr)
 {//Constructor...

  f_EmpCode  =usr.f_EmpCode;
  f_Password  =usr.f_Password;
  f_Name   =usr.f_Name;
  f_Designation =usr.f_Designation;
  f_Department =usr.f_Department;
  f_Ext   =usr.f_Ext;
  f_DeptHead  =usr.f_DeptHead;
  f_HeadDesg  =usr.f_HeadDesg;
  f_DOJ   =usr.f_DOJ;
  f_DOP   =usr.f_DOP;
  f_BU   =usr.f_BU;
  f_AppMBamt  =usr.f_AppMBamt;
  f_UserType  =usr.f_UserType;
  f_Email   =usr.f_Email;
  f_Remarks  =usr.f_Remarks;

 }//END Constructor...


    //Setting Values...
 public void setEmpCode(String EmpCode)
 { f_EmpCode=EmpCode; }

 public void setPass(String Password)
 { f_Password=Password; }

 public void setName(String Name)
 { f_Name=Name; }

 public void setDesignation(String Designation)
 { f_Designation=Designation; }

 public void setDepartment(String Department)
 { f_Department=Department; }

 public void setExt(String Ext)
 { f_Ext=Ext; }

 public void setDeptHead(String DeptHead)
 { f_DeptHead=DeptHead; }

 public void setHeadDesg(String HeadDesg)
 { f_HeadDesg=HeadDesg; }

 public void setDOJ(String DOJ)
 { f_DOJ=DOJ; }

 public void setDOP(String DOP)
 { f_DOP=DOP; }

 public void setBU(String BU)
 { f_BU=BU; }

 public void setAppMBamt(String AppMBamt)
 { f_AppMBamt=AppMBamt; }

 public void setUserType(String UserType)
 { f_UserType=UserType; }

 public void setEmail(String Email)
 { f_Email=Email; }

 public void setRemarks(String Remarks)
 { f_Remarks=Remarks; }


    //Get Methods...
 public String getEmpCode()   { return f_EmpCode; }
 public String getPass()   { return f_Password; }
 public String getName()   { return f_Name; }
 public String getDesignation()  { return f_Designation; }
 public String getDepartment()  { return f_Department; }
 public String getExt()    { return f_Ext; }
 public String getDeptHead()  { return f_DeptHead; }
 public String getHeadDesg()  { return f_HeadDesg; }
 public String getDOJ()    { return f_DOJ; }
 public String getDOP()    { return f_DOP; }
 public String getBU()    { return f_BU; }
 public String getAppMBamt()  { return f_AppMBamt; }
 public String getUserType()  { return f_UserType; }
 public String getEmail()   { return f_Email; }
 public String getRemarks()   { return f_Remarks; }

}//Class