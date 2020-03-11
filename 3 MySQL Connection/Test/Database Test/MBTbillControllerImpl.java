//package beximtex;
/**
* <p>Title: BeximTex, MBTbill Manager</p>
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

public class MBTbillControllerImpl extends UnicastRemoteObject implements MBTbillController
{

 //Global Objects...
 DBU db = new DBU();
 ResultSet rsTBill;
 MBTbill mbtb;
 boolean haveData=false;

 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

 /**
 * Default Constructor With no parameter
 *
 */

 public MBTbillControllerImpl() throws RemoteException
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
    mbtb.setTransactionID(rsTBill.getString(1));
    mbtb.setYear(rsTBill.getString(2));
    mbtb.setMonth(rsTBill.getString(3));
    mbtb.setCCC(rsTBill.getString(4));
    mbtb.setUserName(rsTBill.getString(5));
    mbtb.setTelName(rsTBill.getString(6));
    mbtb.setTelNo(rsTBill.getString(7));
    mbtb.setAmount(rsTBill.getString(8));
    mbtb.setUnit(rsTBill.getString(9));
    mbtb.setArea(rsTBill.getString(10));
    mbtb.setEmpCode(rsTBill.getString(11));
    mbtb.setRemarks(rsTBill.getString(12));

   }catch(SQLException sqle)
   {
    System.out.println("Server [MBTbillControllerImpl] : SET DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }
  else{System.out.println("Server [MBTbillControllerImpl] : NO RECORDS FOUND!");}
 }

 /**
 * MOVE TO FIRST Record
 *  @return MBTbill Object
 */

 public MBTbill moveFirst()
 {
  mbtb = new MBTbill();

  try
  {
   rsTBill.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [MBTbillControllerImpl] : MOVE FIRST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return mbtb;
 };

 /**
 * MOVE TO PREVIOUS Record
 *  @return MBTbill Object
 */

 public MBTbill movePrevious()
 {
  mbtb = new MBTbill();

  try
  {
   if (!rsTBill.previous()) rsTBill.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [MBTbillControllerImpl] : MOVE PREVIOUS Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return mbtb;
 };

 /**
 * MOVE TO NEXT Record
 *  @return MBTbill Object
 */

 public MBTbill moveNext()
 {
  mbtb = new MBTbill();

  try
  {
   if (!rsTBill.next()) rsTBill.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [MBTbillControllerImpl] : MOVE NEXT Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return mbtb;
 };

 /**
 * MOVE TO LAST Record
 *  @return MBTbill Object
 */

 public MBTbill moveLast()
 {
  mbtb = new MBTbill();

  try
  {
   rsTBill.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [MBTbillControllerImpl] : MOVE LAST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return mbtb;
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
   rsTBill=db.stmt.executeQuery("SELECT * FROM MB_TBill ORDER BY TransactionID;");
   if (rsTBill.next()) haveData=true;
  }catch(SQLException sqle)
  {
   System.out.println("Server [MBTbillControllerImpl]: Connect Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   haveData=false;
  }
 }

 /**
 * Insert Data into MB_P_Stock Table
 *  @param MBTbill Class Object
 *  @return boolean true or false value
 */

 public boolean insertData(MBTbill mbtb)
 {

  try
  {
   String strQuery="INSERT INTO MB_TBill VALUES(" +
       "'" + mbtb.getTransactionID() + "',"+
       "'" + mbtb.getYear()       + "',"+
       "'" + mbtb.getMonth()    + "',"+
       "'" + mbtb.getCCC()    + "',"+
       "'" + mbtb.getUserName()   + "',"+
       "'" + mbtb.getTelName()      + "',"+
       "'" + mbtb.getTelNo()      + "',"+
       ""  + mbtb.getAmount()      + "," +
       "'" + mbtb.getUnit()      + "',"+
       "'" + mbtb.getArea()    + "',"+
       "'" + mbtb.getEmpCode()   + "',"+
       "'" + mbtb.getRemarks()   + "');";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

   //Refresh Table
   Connect();

  }catch(SQLException sqle)
  {
   System.out.println("Server [MBTbillControllerImpl]: INSERT DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of insertData Method

 /**
 * Update Data MB_P_Stock Table
 *  @param MBTbill Class Object
 *  @return boolean true or false value
 */

 public boolean updateData(MBTbill mbtb)
 {
  try
  {
   String strQuery="UPDATE MB_TBill SET "  +
       "Year = "    + "'" + mbtb.getYear()       + "',"+
       "Month = "       + "'" + mbtb.getMonth()     + "',"+
       "CCC = "       + "'" + mbtb.getCCC()   + "',"+
       "UserName = "   + "'" + mbtb.getUserName()  + "',"+
       "TelName = "      + "'" + mbtb.getTelName()     + "',"+
       "TelNo = "     + "'" + mbtb.getTelNo()    + "',"+
       "Amount = "     + ""  + mbtb.getAmount()     + "," +
       "Unit = "     + "'" + mbtb.getUnit()    + "',"+
       "Area = "     + "'" + mbtb.getArea()    + "',"+
       "EmpCode = "    + "'" + mbtb.getEmpCode()    + "',"+
       "Remarks = "    + "'" + mbtb.getRemarks()    + "' "+

       "WHERE TransactionID = "+ "'" + mbtb.getTransactionID() +"';";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

   //Refresh Table...
   Connect();

  }catch(SQLException sqle){
   System.out.println("Server [MBTbillControllerImpl]: UPDATE DATA Error !!!");
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
   rsTBill = db.stmt.executeQuery(srchStr);

   if (!rsTBill.next())
   {
    Connect();
    return false;
   }
  }catch(SQLException sqle)
  {
   System.out.println("Server [MBTbillControllerImpl]: CHYearK DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   JOptionPane.showMessageDialog(null, "Server: RYearORD NOT FOUND!");
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
   System.out.println("Server [MBTbillControllerImpl]: DELETE DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

 }//End of Delete Data

 /**
 * SEARCH DATA from MB_P_Stock Table
 *  @param String Criteria
 *  @return MBTbill Class Object
 */

 public MBTbill SearchData(String srchStr)
 {
  mbtb = new MBTbill();

  if (srchStr.equals("")) return mbtb;
  else
  {
   //System.out.println("\nQuery: "+srchStr);

   try
   {
    rsTBill = db.stmt.executeQuery(srchStr);

    if (rsTBill.next())
    {
     setData();
    }

   }catch(SQLException sqle)
   {
    System.out.println("Server [MBTbillControllerImpl]: SEARCH DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }

  return mbtb;
 }//End of Search Data

}//End of MBTbillController Class