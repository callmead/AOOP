//package beximtex;
/**
 * <p>Title: BeximTex, HWuser Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.io.Serializable;

public class HWuser implements Serializable
{//Class

 private String f_EmpCode;
 private String f_Date;
 private String f_BIOS_PW;
 private String f_BIOS_SPW;
 private String f_IP;
 private String f_Subnet;
 private String f_NetworkID;
 private String f_NTDomain;
 private String f_DNS;
 private String f_GW;
 private String f_OS;
 private String f_IE;
 private String f_Messenger;
 private String f_Email;
 private String f_Datatex;
 private String f_IFM;
 private String f_Remarks;

 /**
  * Default Constructor With no parameter
  *
  */

 public HWuser()
 {//Default Constructor...

  f_EmpCode = "";
  f_Date  = "";
  f_BIOS_PW = "";
  f_BIOS_SPW  = "";
  f_IP  = "";
  f_Subnet = "";
  f_NetworkID = "";
  f_NTDomain = "";
  f_DNS  = "";
  f_GW  = "";
  f_OS  = "";
  f_IE  = "";
  f_Messenger = "";
  f_Email  = "";
  f_Datatex = "";
  f_IFM  = "";
  f_Remarks = "";

 }//END Default Constructor...


 /**
  * Constructor with parameter
  *
  */

 public HWuser(HWuser hwusr)
 {//Constructor...

  f_EmpCode = hwusr.f_EmpCode;
  f_Date  = hwusr.f_Date;
  f_BIOS_PW = hwusr.f_BIOS_PW;
  f_BIOS_SPW = hwusr.f_BIOS_SPW;
  f_IP  = hwusr.f_IP;
  f_Subnet = hwusr.f_Subnet;
  f_NetworkID = hwusr.f_NetworkID;
  f_NTDomain = hwusr.f_NTDomain;
  f_DNS  = hwusr.f_DNS;
  f_GW  = hwusr.f_GW;
  f_OS  = hwusr.f_OS;
  f_IE  = hwusr.f_IE;
  f_Messenger = hwusr.f_Messenger;
  f_Email  = hwusr.f_Email;
  f_Datatex = hwusr.f_Datatex;
  f_IFM  = hwusr.f_IFM;
  f_Remarks = hwusr.f_Remarks;

 }//END Constructor...


    //Setting Values...
 public void setEmpCode(String EmpCode)
 { f_EmpCode=EmpCode; }

 public void setDate(String Date)
 { f_Date=Date; }

 public void setBIOS_PW(String BIOS_PW)
 { f_BIOS_PW=BIOS_PW; }

 public void setBIOS_SPW(String BIOS_SPW)
 { f_BIOS_SPW=BIOS_SPW; }

 public void setIP(String IP)
 { f_IP=IP; }

 public void setSubnet(String Subnet)
 { f_Subnet=Subnet; }

 public void setNetworkID(String NetworkID)
 { f_NetworkID=NetworkID; }

 public void setNTDomain(String NTDomain)
 { f_NTDomain=NTDomain; }

 public void setDNS(String DNS)
 { f_DNS=DNS; }

 public void setGW(String GW)
 { f_GW=GW; }

 public void setOS(String OS)
 { f_OS=OS; }

 public void setIE(String IE)
 { f_IE=IE; }

 public void setMessenger(String Messenger)
 { f_Messenger=Messenger; }

 public void setEmail(String Email)
 { f_Email=Email; }

 public void setDatatex(String Datatex)
 { f_Datatex=Datatex; }

 public void setIFM(String IFM)
 { f_IFM=IFM; }

 public void setRemarks(String Remarks)
 { f_Remarks=Remarks; }

    //Get Methods...
 public String getEmpCode()  { return f_EmpCode; }
 public String getDate()    { return f_Date; }
 public String getBIOS_PW()  { return f_BIOS_PW; }
 public String getBIOS_SPW()  { return f_BIOS_SPW; }
 public String getIP()    { return f_IP; }
 public String getSubnet()  { return f_Subnet; }
 public String getNetworkID()  { return f_NetworkID; }
 public String getNTDomain()  { return f_NTDomain; }
 public String getDNS()   { return f_DNS; }
 public String getGW()    { return f_GW; }
 public String getOS()    { return f_OS; }
 public String getIE()    { return f_IE; }
 public String getMessenger()  { return f_Messenger; }
 public String getEmail()   { return f_Email; }
 public String getDatatex()   { return f_Datatex; }
 public String getIFM()    { return f_IFM; }
 public String getRemarks()   { return f_Remarks; }

}//Class