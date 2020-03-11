//package beximtex;
/**
 * <p>Title: BeximTex, Indent Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.io.Serializable;

public class Indent implements Serializable
{//Class

 private String f_IndentNo;
 private String f_BU;
 private String f_Date;
 private String f_Amount;
 private String f_RecFrom;
 private String f_RecDate;
 private String f_RecBy;
 private String f_Balance;
 private String f_SubmtDate;
 private String f_SubmtTo;
 private String f_Remarks;

 /**
  * Default Constructor With no parameter
  *
  */

 public Indent()
 {//Default Constructor...

  f_IndentNo = "";
  f_BU  = "";
  f_Date  = "";
  f_Amount = "";
  f_RecFrom = "";
  f_RecDate = "";
  f_RecBy  = "";
  f_Balance = "";
  f_SubmtDate = "";
  f_SubmtTo = "";
  f_Remarks = "";

 }//END Default Constructor...


 /**
  * Constructor with parameter
  *
  */

 public Indent(Indent ind)
 {//Constructor...

  f_IndentNo = ind.f_IndentNo;
  f_BU  = ind.f_BU;
  f_Date  = ind.f_Date;
  f_Amount = ind.f_Amount;
  f_RecFrom = ind.f_RecFrom;
  f_RecDate = ind.f_RecDate;
  f_RecBy  = ind.f_RecBy;
  f_Balance = ind.f_Balance;
  f_SubmtDate = ind.f_SubmtDate;
  f_SubmtTo = ind.f_SubmtTo;
  f_Remarks = ind.f_Remarks;

 }//END Constructor...


    //Setting Values...
 public void setIndentNo(String IndentNo)
 { f_IndentNo=IndentNo; }

 public void setBU(String BU)
 { f_BU=BU; }

 public void setDate(String Date)
 { f_Date=Date; }

 public void setAmount(String Amount)
 { f_Amount=Amount; }

 public void setRecFrom(String RecFrom)
 { f_RecFrom=RecFrom; }

 public void setRecDate(String RecDate)
 { f_RecDate=RecDate; }

 public void setRecBy(String RecBy)
 { f_RecBy=RecBy; }

 public void setBalance(String Balance)
 { f_Balance=Balance; }

 public void setSubmtDate(String SubmtDate)
 { f_SubmtDate=SubmtDate; }

 public void setSubmtTo(String SubmtTo)
 { f_SubmtTo=SubmtTo; }

 public void setRemarks(String Remarks)
 { f_Remarks=Remarks; }


    //Get Methods...
 public String getIndentNo() { return f_IndentNo; }
 public String getBU()   { return f_BU; }
 public String getDate()  { return f_Date; }
 public String getAmount()  { return f_Amount; }
 public String getRecFrom()  { return f_RecFrom; }
 public String getRecDate() { return f_RecDate; }
 public String getRecBy()  { return f_RecBy; }
 public String getBalance()  { return f_Balance; }
 public String getSubmtDate(){ return f_SubmtDate; }
 public String getSubmtTo()  { return f_SubmtTo; }
 public String getRemarks()  { return f_Remarks; }

}//Class