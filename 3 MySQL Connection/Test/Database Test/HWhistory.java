//package beximtex;
/**
 * <p>Title: BeximTex, HWhistory Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.io.Serializable;

public class HWhistory implements Serializable
{//Class

 private String f_SNo;
 private String f_ItemCode;
 private String f_Date;
 private String f_EmpCode;

 /**
  * Default Constructor With no parameter
  *
  */

 public HWhistory()
 {//Default Constructor...

  f_SNo  ="";
  f_ItemCode ="";
  f_Date  ="";
  f_EmpCode ="";

 }//END Default Constructor...


 /**
  * Constructor with parameter
  *
  */

 public HWhistory(HWhistory hwh)
 {//Constructor...

  f_SNo  =hwh.f_SNo;
  f_ItemCode =hwh.f_ItemCode;
  f_Date  =hwh.f_Date;
  f_EmpCode =hwh.f_EmpCode;

 }//END Constructor...


    //Setting Values...
 public void setSNo(String SNo)
 { f_SNo=SNo; }

 public void setItemCode(String ItemCode)
 { f_ItemCode=ItemCode; }

 public void setDate(String Date)
 { f_Date=Date; }

 public void setEmpCode(String EmpCode)
 { f_EmpCode=EmpCode; }


    //Get Methods...
 public String getSNo()   { return f_SNo; }
 public String getItemCode() { return f_ItemCode; }
 public String getDate()  { return f_Date; }
 public String getEmpCode()  { return f_EmpCode; }

}//Class