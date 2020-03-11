//package beximtex;
/**
* <p>Title: BeximTex, MBsStock Manager</p>
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

public class MBsStockControllerImpl extends UnicastRemoteObject implements MBsStockController
{

 //Global Objects...
 DBU db = new DBU();
 ResultSet rsStock;
 MBsStock mbss;
 boolean haveData=false;

 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

 /**
 * Default Constructor With no parameter
 *
 */

 public MBsStockControllerImpl() throws RemoteException
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
    mbss.setPhoneNo(rsStock.getString(1));
    mbss.setDate(sdf.format(rsStock.getDate(2)));
    mbss.setCType(rsStock.getString(3));
    mbss.setCProvider(rsStock.getString(4));
    mbss.setCallType(rsStock.getString(5));
    mbss.setPIN1(rsStock.getString(6));
    mbss.setPIN2(rsStock.getString(7));
    mbss.setPUK1(rsStock.getString(8));
    mbss.setPUK2(rsStock.getString(9));
    mbss.setQuality(rsStock.getString(10));
    mbss.setIssued(rsStock.getString(11));
    mbss.setEmpCode(rsStock.getString(12));
    mbss.setAC(rsStock.getString(13));
    mbss.setRemarks(rsStock.getString(14));

   }catch(SQLException sqle)
   {
    System.out.println("Server [MBsStockControllerImpl] : SET DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }
  else{System.out.println("Server [MBsStockControllerImpl] : NO RECORDS FOUND!");}
 }

 /**
 * MOVE TO FIRST Record
 *  @return MBsStock Object
 */

 public MBsStock moveFirst()
 {
  mbss = new MBsStock();

  try
  {
   rsStock.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [MBsStockControllerImpl] : MOVE FIRST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return mbss;
 };

 /**
 * MOVE TO PREVIOUS Record
 *  @return MBsStock Object
 */

 public MBsStock movePrevious()
 {
  mbss = new MBsStock();

  try
  {
   if (!rsStock.previous()) rsStock.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [MBsStockControllerImpl] : MOVE PREVIOUS Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return mbss;
 };

 /**
 * MOVE TO NEXT Record
 *  @return MBsStock Object
 */

 public MBsStock moveNext()
 {
  mbss = new MBsStock();

  try
  {
   if (!rsStock.next()) rsStock.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [MBsStockControllerImpl] : MOVE NEXT Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return mbss;
 };

 /**
 * MOVE TO LAST Record
 *  @return MBsStock Object
 */

 public MBsStock moveLast()
 {
  mbss = new MBsStock();

  try
  {
   rsStock.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [MBsStockControllerImpl] : MOVE LAST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return mbss;
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
   rsStock=db.stmt.executeQuery("SELECT * FROM MB_S_Stock ORDER BY PhoneNo;");
   if (rsStock.next()) haveData=true;
  }catch(SQLException sqle)
  {
   System.out.println("Server [MBsStockControllerImpl]: Connect Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   haveData=false;
  }
 }

 /**
 * Insert Data into MB_P_Stock Table
 *  @param MBsStock Class Object
 *  @return boolean true or false value
 */

 public boolean insertData(MBsStock mbss)
 {

  try
  {
   String strQuery="INSERT INTO MB_S_Stock VALUES(" +
       "'" + mbss.getPhoneNo()  + "',"+
       "'" + mbss.getDate()     + "',"+
       "'" + mbss.getCType()   + "',"+
       "'" + mbss.getCProvider() + "',"+
       "'" + mbss.getCallType()  + "',"+
       "'" + mbss.getPIN1()     + "',"+
       "'" + mbss.getPIN2()     + "',"+
       "'" + mbss.getPUK1()     + "',"+
       "'" + mbss.getPUK2()     + "',"+
       "'" + mbss.getQuality()  + "',"+
       "'" + mbss.getIssued()   + "',"+
       "'" + mbss.getEmpCode()  + "',"+
       "'" + mbss.getAC()    + "',"+
       "'" + mbss.getRemarks()  + "');";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

   //Refresh Table
   Connect();

  }catch(SQLException sqle)
  {
   System.out.println("Server [MBsStockControllerImpl]: INSERT DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of insertData Method

 /**
 * Update Data MB_P_Stock Table
 *  @param MBsStock Class Object
 *  @return boolean true or false value
 */

 public boolean updateData(MBsStock mbss)
 {
  try
  {
   String strQuery="UPDATE MB_S_Stock SET "  +
       "Date = "     + "'" + mbss.getDate()      + "',"+
       "CType = "        + "'" + mbss.getCType()   + "',"+
       "CProvider = "       + "'" + mbss.getCProvider() + "',"+
       "CallType = "       + "'" + mbss.getCallType() + "',"+
       "PIN1 = "        + "'" + mbss.getPIN1()     + "',"+
       "PIN2 = "      + "'" + mbss.getPIN2()   + "',"+
       "PUK1 = "      + "'" + mbss.getPUK1()    + "',"+
       "PUK2 = "      + "'" + mbss.getPUK2()   + "',"+
       "Quality = "     + "'" + mbss.getQuality()  + "',"+
       "Issued = "      + "'" + mbss.getIssued()  + "',"+
       "EmpCode = "     + "'" + mbss.getEmpCode()   + "',"+
       "AC = "      + "'" + mbss.getAC()     + "',"+
       "Remarks = "     + "'" + mbss.getRemarks()   + "' "+

       "WHERE PhoneNo = "    + "'" + mbss.getPhoneNo()  +"';)";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

   //Refresh Table...
   Connect();

  }catch(SQLException sqle){
   System.out.println("Server [MBsStockControllerImpl]: UPDATE DATA Error !!!");
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
   rsStock = db.stmt.executeQuery(srchStr);

   if (!rsStock.next())
   {
    Connect();
    return false;
   }
  }catch(SQLException sqle)
  {
   System.out.println("Server [MBsStockControllerImpl]: CHECK DATA Error !!!");
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
   System.out.println("Server [MBsStockControllerImpl]: DELETE DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

 }//End of Delete Data

 /**
 * SEARCH DATA from MB_P_Stock Table
 *  @param String Criteria
 *  @return MBsStock Class Object
 */

 public MBsStock SearchData(String srchStr)
 {
  mbss = new MBsStock();

  if (srchStr.equals("")) return mbss;
  else
  {
   //System.out.println("\nQuery: "+srchStr);

   try
   {
    rsStock = db.stmt.executeQuery(srchStr);

    if (rsStock.next())
    {
     setData();
    }

   }catch(SQLException sqle)
   {
    System.out.println("Server [MBsStockControllerImpl]: SEARCH DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }

  return mbss;
 }//End of Search Data

}//End of MBsStockController Class