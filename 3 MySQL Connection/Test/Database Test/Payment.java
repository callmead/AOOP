//package beximtex;
/**
 * <p>Title: BeximTex, Payment Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.io.Serializable;

public class Payment implements Serializable
{//Class

 private String f_TransactionID;
 private String f_Date;
 private String f_OID;
 private String f_SID;
 private String f_Amount;
 private String f_Status;
 private String f_LPD;
 private String f_IndentNo;
 private String f_PMode;
 private String f_Remarks;

 /**
  * Default Constructor With no parameter
  *
  */

 public Payment()
 {//Default Constructor...

  f_TransactionID = "";
  f_Date   = "";
  f_OID   = "";
  f_SID   = "";
  f_Amount  = "";
  f_Status  = "";
  f_LPD   = "";
  f_IndentNo  = "";
  f_PMode   = "";
  f_Remarks  = "";

 }//END Default Constructor...


 /**
  * Constructor with parameter
  *
  */

 public Payment(Payment supp)
 {//Constructor...

  f_TransactionID = supp.f_TransactionID;
  f_Date   = supp.f_Date;
  f_OID   = supp.f_OID;
  f_SID   = supp.f_SID;
  f_Amount  = supp.f_Amount;
  f_Status  = supp.f_Status;
  f_LPD   = supp.f_LPD;
  f_IndentNo  = supp.f_IndentNo;
  f_PMode   = supp.f_PMode;
  f_Remarks  = supp.f_Remarks;

 }//END Constructor...


    //Setting Values...
 public void setTransactionID(String TransactionID)
 { f_TransactionID=TransactionID; }

 public void setDate(String Date)
 { f_Date=Date; }

 public void setOID(String OID)
 { f_OID=OID; }

 public void setSID(String SID)
 { f_SID=SID; }

 public void setAmount(String Amount)
 { f_Amount=Amount; }

 public void setStatus(String Status)
 { f_Status=Status; }

 public void setLPD(String LPD)
 { f_LPD=LPD; }

 public void setIndentNo(String IndentNo)
 { f_IndentNo=IndentNo; }

 public void setPMode(String PMode)
 { f_PMode=PMode; }

 public void setRemarks(String Remarks)
 { f_Remarks=Remarks; }


    //Get Methods...
 public String getTransactionID() { return f_TransactionID; }
 public String getDate()    { return f_Date; }
 public String getOID()     { return f_OID; }
 public String getSID()     { return f_SID; }
 public String getAmount()    { return f_Amount; }
 public String getStatus()   { return f_Status; }
 public String getLPD()     { return f_LPD; }
 public String getIndentNo()   { return f_IndentNo; }
 public String getPMode()   { return f_PMode; }
 public String getRemarks()    { return f_Remarks; }

}//Class