//package beximtex;
/**
* <p>Title: BeximTex, HWpogr Manager</p>
* <p>Description: Support Software System</p>
* <p>Copyright: 2006-2010</p>
* <p>Company: ASKA</p>
* @author Adeel Ashraf Malik
* @version 1.0.0
*/

import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;

import java.sql.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class HWpogrControllerImpl extends UnicastRemoteObject implements HWpogrController
{

 //Global Objects...
 DBU db = new DBU();
 ResultSet rsPO;
 HWpogr hwpo;
 boolean haveData=false;

 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

 /**
 * Default Constructor With no parameter
 *
 */

 public HWpogrControllerImpl() throws RemoteException
 {
  Connect();
 }//End of Constructor


 /**
 * Gets Data from Resultset Sets Data
 *
 */

 public void setData()
 {
  if (haveData)
  {

   try
   {
    hwpo.setTransactionID(rsPO.getString(1));
    hwpo.setOID(rsPO.getString(2));
    hwpo.setDate(sdf.format(rsPO.getDate(3)));
    hwpo.setSID(rsPO.getString(4));
    hwpo.setItem(rsPO.getString(5));
    hwpo.setQtyOrd(rsPO.getString(6));
    hwpo.setQtyRec(rsPO.getString(7));
    hwpo.setPrice(rsPO.getString(8));
    hwpo.setTotal(rsPO.getString(9));
    hwpo.setEmpCode(rsPO.getString(10));
    hwpo.setStatus(rsPO.getString(11));
    hwpo.setOfferNo(rsPO.getString(12));
    hwpo.setOffDated(rsPO.getString(13));
    hwpo.setLastDate(rsPO.getString(14));
    hwpo.setDeliveryAt(rsPO.getString(15));
    hwpo.setRemarks(rsPO.getString(16));

   }catch(SQLException sqle)
   {
    System.out.println("Server [HWpogrControllerImpl] : SET DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }
  else{System.out.println("Server [HWpogrControllerImpl] : NO RECORDS FOUND!");}
 }

 /**
 * MOVE TO FIRST Record
 *  @return HWpogr Object
 */

 public HWpogr moveFirst()
 {
  hwpo = new HWpogr();

  try
  {
   rsPO.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [HWpogrControllerImpl] : MOVE FIRST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return hwpo;
 };

 /**
 * MOVE TO PREVIOUS Record
 *  @return HWpogr Object
 */

 public HWpogr movePrevious()
 {
  hwpo = new HWpogr();

  try
  {
   if (!rsPO.previous()) rsPO.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [HWpogrControllerImpl] : MOVE PREVIOUS Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return hwpo;
 };

 /**
 * MOVE TO NEXT Record
 *  @return HWpogr Object
 */

 public HWpogr moveNext()
 {
  hwpo = new HWpogr();

  try
  {
   if (!rsPO.next()) rsPO.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [HWpogrControllerImpl] : MOVE NEXT Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return hwpo;
 };

 /**
 * MOVE TO LAST Record
 *  @return HWpogr Object
 */

 public HWpogr moveLast()
 {
  hwpo = new HWpogr();

  try
  {
   rsPO.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [HWpogrControllerImpl] : MOVE LAST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return hwpo;
 };

 /**
 * Open Table
 *
 */

 public void Connect()
 {
  haveData=false;

  try
  {
   rsPO=db.stmt.executeQuery("SELECT * FROM HW_POGR WHERE Status<>'Ok' ORDER BY OID;");
   if (rsPO.next()) haveData=true;
  }catch(SQLException sqle)
  {
   System.out.println("Server [HWpogrControllerImpl]: Connect Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   haveData=false;
  }
 }

 /**
 * Insert Data into MB_P_Stock Table
 *  @param HWpogr Class Object
 *  @return boolean true or false value
 */

 public boolean insertData(HWpogr hwpo)
 {

  try
  {
   String strQuery="INSERT INTO HW_POGR VALUES("  +
       "'" + hwpo.getTransactionID() + "',"+
       "'" + hwpo.getOID()       + "',"+
       "'" + hwpo.getDate()    + "',"+
       "'" + hwpo.getSID()    + "',"+
       "'" + hwpo.getItem()    + "',"+
       ""  + hwpo.getQtyOrd()       + "," +
       ""  + hwpo.getQtyRec()      + "," +
       ""  + hwpo.getPrice()      + "," +
       ""  + hwpo.getTotal()      + "," +
       "'" + hwpo.getEmpCode()   + "',"+
       "'" + hwpo.getStatus()    + "',"+
       "'" + hwpo.getOfferNo()   + "',"+
       "'" + hwpo.getOffDated()   + "',"+
       "'" + hwpo.getLastDate()   + "',"+
       "'" + hwpo.getDeliveryAt()   + "',"+
       "'" + hwpo.getRemarks()   + "');";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

   //Refresh Table
   Connect();

  }catch(SQLException sqle)
  {
   System.out.println("Server [HWpogrControllerImpl]: INSERT DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of insertData Method

 /**
 * Update Data MB_P_Stock Table
 *  @param HWpogr Class Object
 *  @return boolean true or false value
 */

 public boolean updateData(HWpogr hwpo)
 {
  try
  {
   String strQuery="UPDATE HW_POGR SET "   +
       "OID = "     + "'" + hwpo.getOID()        + "',"+
       "SID = "        + "'" + hwpo.getSID()   + "',"+
       "Item = "        + "'" + hwpo.getItem()   + "',"+
       "QtyOrd = "        + ""  + hwpo.getQtyOrd()     + "," +
       "Price = "      + ""  + hwpo.getPrice()     + "," +
       "Total = "      + ""  + hwpo.getTotal()   + "," +
       "OfferNo = "     + "'" + hwpo.getOfferNo()    + "',"+
       "OffDated = "     + "'" + hwpo.getOffDated()   + "',"+
       "LastDate = "     + "'" + hwpo.getLastDate()   + "',"+
       "DeliveryAt = "    + "'" + hwpo.getDeliveryAt()   + "',"+
       "Remarks = "     + "'" + hwpo.getRemarks()    + "' "+

       "WHERE TransactionID = "  + "'" + hwpo.getTransactionID() +"';";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

   //Refresh Table...
   Connect();

  }catch(SQLException sqle){
   System.out.println("Server [HWpogrControllerImpl]: UPDATE DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of updateData Method

 /**
 * CHECK DATA Exist or Not
 *  @param String Criteria
 *  @return boolean true or false value
 */

 public boolean isFound(String srchStr)
 {
  System.out.println("\nQuery: "+srchStr);
  try
  {
   rsPO = db.stmt.executeQuery(srchStr);

   if (!rsPO.next())
   {
    Connect();
    return false;
   }
  }catch(SQLException sqle)
  {
   System.out.println("Server [HWpogrControllerImpl]: CHECK DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   JOptionPane.showMessageDialog(null, "Server: RECORD NOT FOUND!");
   return false;
  }

  //Refresh Table...
  Connect();
  return true;
 }//End of isFound Data

 /**
 * DELETE DATA from MB_P_Stock Table
 *  @param String Criteria
 *
 */

 public void DeleteData(String strQuery)
 {
  System.out.println("\nQuery: "+strQuery);
  try
  {
   db.stmt.executeUpdate(strQuery);

   //Refresh Table...
   Connect();
  }catch(SQLException sqle)
  {
   System.out.println("Server [HWpogrControllerImpl]: DELETE DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

 }//End of Delete Data

 /**
 * SEARCH DATA from MB_P_Stock Table
 *  @param String Criteria
 *  @return HWpogr Class Object
 */

 public HWpogr SearchData(String srchStr)
 {
  hwpo = new HWpogr();

  if (srchStr.equals("")) return hwpo;
  else
  {
   //System.out.println("\nQuery: "+srchStr);

   try
   {
    rsPO = db.stmt.executeQuery(srchStr);

    if (rsPO.next())
    {
     setData();
    }

   }catch(SQLException sqle)
   {
    System.out.println("Server [HWpogrControllerImpl]: SEARCH DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }

  return hwpo;
 }//End of Search Data

}//End of HWpogrController Class