//package beximtex;
/**
 * <p>Title: BeximTex, MBTbill Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.io.Serializable;

public class MBTbill implements Serializable
{//Class

 private String f_TransactionID;
 private String f_Year;
 private String f_Month;
 private String f_CCC;
 private String f_UserName;
 private String f_TelName;
 private String f_TelNo;
 private String f_Amount;
 private String f_Unit;
 private String f_Area;
 private String f_EmpCode;
 private String f_Remarks;

 /**
  * Default Constructor With no parameter
  *
  */

 public MBTbill()
 {//Default Constructor...

  f_TransactionID = "";
  f_Year   = "";
  f_Month   = "";
  f_CCC    = "";
  f_UserName  = "";
  f_TelName  = "";
  f_TelNo   = "";
  f_Amount  = "";
  f_Unit   = "";
  f_Area   = "";
  f_EmpCode  = "";
  f_Remarks  = "";

 }//END Default Constructor...


 /**
  * Constructor with parameter
  *
  */

 public MBTbill(MBTbill mbtb)
 {//Constructor...

  f_TransactionID = mbtb.f_TransactionID;
  f_Year   = mbtb.f_Year;
  f_Month   = mbtb.f_Month;
  f_CCC   = mbtb.f_CCC;
  f_UserName  = mbtb.f_UserName;
  f_TelName  = mbtb.f_TelName;
  f_TelNo   = mbtb.f_TelNo;
  f_Amount  = mbtb.f_Amount;
  f_Unit   = mbtb.f_Unit;
  f_Area   = mbtb.f_Area;
  f_EmpCode  = mbtb.f_EmpCode;
  f_Remarks  = mbtb.f_Remarks;

 }//END Constructor...


    //Setting Values...
 public void setTransactionID(String TransactionID)
 { f_TransactionID=TransactionID; }

 public void setYear(String Year)
 { f_Year=Year; }

 public void setMonth(String Month)
 { f_Month=Month; }

 public void setCCC(String CCC)
 { f_CCC=CCC; }

 public void setUserName(String UserName)
 { f_UserName=UserName; }

 public void setTelName(String TelName)
 { f_TelName=TelName; }

 public void setTelNo(String TelNo)
 { f_TelNo=TelNo; }

 public void setAmount(String Amount)
 { f_Amount=Amount; }

 public void setUnit(String Unit)
 { f_Unit=Unit; }

 public void setArea(String Area)
 { f_Area=Area; }

 public void setEmpCode(String EmpCode)
 { f_EmpCode=EmpCode; }

 public void setRemarks(String Remarks)
 { f_Remarks=Remarks; }

    //Get Methods...
 public String getTransactionID() { return f_TransactionID; }
 public String getYear()     { return f_Year; }
 public String getMonth()   { return f_Month; }
 public String getCCC()    { return f_CCC; }
 public String getUserName()   { return f_UserName; }
 public String getTelName()   { return f_TelName; }
 public String getTelNo()    { return f_TelNo; }
 public String getAmount()    { return f_Amount; }
 public String getUnit()    { return f_Unit; }
 public String getArea()     { return f_Area; }
 public String getEmpCode()    { return f_EmpCode; }
 public String getRemarks()    { return f_Remarks; }

}//Class