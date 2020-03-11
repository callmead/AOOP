//package beximtex;
/**
 * <p>Title: BeximTex, HWissue Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.io.Serializable;

public class HWissue implements Serializable
{//Class

 private String f_TransactionID;
 private String f_Date;
 private String f_ItemCode;
 private String f_Item;
 private String f_IssuedTo;
 private String f_EmpCode;
 private String f_Remarks;

 /**
  * Default Constructor With no parameter
  *
  */

 public HWissue()
 {//Default Constructor...

  f_TransactionID = "";
  f_Date   = "";
  f_ItemCode  = "";
  f_Item    = "";
  f_IssuedTo  = "";
  f_EmpCode  = "";
  f_Remarks  = "";

 }//END Default Constructor...


 /**
  * Constructor with parameter
  *
  */

 public HWissue(HWissue hwis)
 {//Constructor...

  f_TransactionID = hwis.f_TransactionID;
  f_Date   = hwis.f_Date;
  f_ItemCode  = hwis.f_ItemCode;
  f_Item   = hwis.f_Item;
  f_IssuedTo  = hwis.f_IssuedTo;
  f_EmpCode  = hwis.f_EmpCode;
  f_Remarks  = hwis.f_Remarks;

 }//END Constructor...


    //Setting Values...
 public void setTransactionID(String TransactionID)
 { f_TransactionID=TransactionID; }

 public void setDate(String Date)
 { f_Date=Date; }

 public void setItemCode(String ItemCode)
 { f_ItemCode=ItemCode; }

 public void setItem(String Item)
 { f_Item=Item; }

 public void setIssuedTo(String IssuedTo)
 { f_IssuedTo=IssuedTo; }

 public void setEmpCode(String EmpCode)
 { f_EmpCode=EmpCode; }

 public void setRemarks(String Remarks)
 { f_Remarks=Remarks; }

    //Get Methods...
 public String getTransactionID() { return f_TransactionID; }
 public String getDate()     { return f_Date; }
 public String getItemCode()   { return f_ItemCode; }
 public String getItem()    { return f_Item; }
 public String getIssuedTo()   { return f_IssuedTo; }
 public String getEmpCode()    { return f_EmpCode; }
 public String getRemarks()    { return f_Remarks; }

}//Class