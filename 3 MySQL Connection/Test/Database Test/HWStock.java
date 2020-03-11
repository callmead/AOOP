//package beximtex;
/**
 * <p>Title: BeximTex, HWStock Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.io.Serializable;

public class HWStock implements Serializable
{//Class

 private String f_ItemCode;
 private String f_Date;
 private String f_Item;
 private String f_Brand;
 private String f_Serial;
 private String f_Capacity;
 private String f_MB;
 private String f_Speed;
 private String f_CPUType;
 private String f_Quality;
 private String f_Issued;
 private String f_EmpCode;
 private String f_Warranty;
 private String f_Remarks;

 /**
  * Default Constructor With no parameter
  *
  */

 public HWStock()
 {//Default Constructor...

  f_ItemCode = "";
  f_Date  = "";
  f_Item  = "";
  f_Brand  = "";
  f_Serial = "";
  f_Capacity = "";
  f_MB  = "";
  f_Speed  = "";
  f_CPUType = "";
  f_Quality = "";
  f_Issued = "";
  f_EmpCode = "";
  f_Warranty = "";
  f_Remarks = "";

 }//END Default Constructor...


 /**
  * Constructor with parameter
  *
  */

 public HWStock(HWStock hws)
 {//Constructor...

  f_ItemCode = hws.f_ItemCode;
  f_Date  = hws.f_Date;
  f_Item  = hws.f_Item;
  f_Brand  = hws.f_Brand;
  f_Serial = hws.f_Serial;
  f_Capacity = hws.f_Capacity;
  f_MB  = hws.f_MB;
  f_Speed  = hws.f_Speed;
  f_CPUType = hws.f_CPUType;
  f_Quality = hws.f_Quality;
  f_Issued = hws.f_Issued;
  f_EmpCode = hws.f_EmpCode;
  f_Warranty = hws.f_Warranty;
  f_Remarks = hws.f_Remarks;

 }//END Constructor...


    //Setting Values...
 public void setItemCode(String ItemCode)
 { f_ItemCode=ItemCode; }

 public void setDate(String Date)
 { f_Date=Date; }

 public void setItem(String Item)
 { f_Item=Item; }

 public void setBrand(String Brand)
 { f_Brand=Brand; }

 public void setSerial(String Serial)
 { f_Serial=Serial; }

 public void setCapacity(String Capacity)
 { f_Capacity=Capacity; }

 public void setMB(String MB)
 { f_MB=MB; }

 public void setSpeed(String Speed)
 { f_Speed=Speed; }

 public void setCPUType(String CPUType)
 { f_CPUType=CPUType; }

 public void setQuality(String Quality)
 { f_Quality=Quality; }

 public void setIssued(String Issued)
 { f_Issued=Issued; }

 public void setEmpCode(String EmpCode)
 { f_EmpCode=EmpCode; }

 public void setWarranty(String Warranty)
 { f_Warranty=Warranty; }

 public void setRemarks(String Remarks)
 { f_Remarks=Remarks; }

    //Get Methods...
 public String getItemCode() { return f_ItemCode; }
 public String getDate()   { return f_Date; }
 public String getItem()  { return f_Item; }
 public String getBrand() { return f_Brand; }
 public String getSerial()  { return f_Serial; }
 public String getCapacity() { return f_Capacity; }
 public String getMB()   { return f_MB; }
 public String getSpeed()  { return f_Speed; }
 public String getCPUType() { return f_CPUType; }
 public String getQuality()  { return f_Quality; }
 public String getIssued()  { return f_Issued; }
 public String getEmpCode()  { return f_EmpCode; }
 public String getWarranty() { return f_Warranty; }
 public String getRemarks()  { return f_Remarks; }

}//Class