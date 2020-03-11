//package beximtex;
/**
* <p>Title: BeximTex, Payment Manager</p>
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

public class PaymentControllerImpl extends UnicastRemoteObject implements PaymentController
{

 //Global Objects...
 DBU db = new DBU();
 ResultSet rsPay;
 Payment pay;
 boolean haveData=false;

 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

 /**
 * Default Constructor With no parameter
 *
 */

 public PaymentControllerImpl() throws RemoteException
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
    pay.setTransactionID(rsPay.getString(1));
    pay.setDate(rsPay.getString(2));
    pay.setOID(rsPay.getString(3));
    pay.setSID(rsPay.getString(4));
    pay.setAmount(rsPay.getString(5));
    pay.setStatus(rsPay.getString(6));
    pay.setLPD(rsPay.getString(7));
    pay.setIndentNo(rsPay.getString(8));
    pay.setPMode(rsPay.getString(9));
    pay.setRemarks(rsPay.getString(10));
   }catch(SQLException sqle)
   {
    System.out.println("Server [PaymentControllerImpl] : SET DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }
  else{System.out.println("Server [PaymentControllerImpl] : NO RECORDS FOUND!");}
 }

 /**
 * MOVE TO FIRST Record
 *  @return Payment Object
 */

 public Payment moveFirst()
 {
  pay = new Payment();

  try
  {
   rsPay.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [PaymentControllerImpl] : MOVE FIRST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return pay;
 };

 /**
 * MOVE TO PREVIOUS Record
 *  @return Payment Object
 */

 public Payment movePrevious()
 {
  pay = new Payment();

  try
  {
   if (!rsPay.previous()) rsPay.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [PaymentControllerImpl] : MOVE PREVIOUS Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return pay;
 };

 /**
 * MOVE TO NEXT Record
 *  @return Payment Object
 */

 public Payment moveNext()
 {
  pay = new Payment();

  try
  {
   if (!rsPay.next()) rsPay.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [PaymentControllerImpl] : MOVE NEXT Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return pay;
 };

 /**
 * MOVE TO LAST Record
 *  @return Payment Object
 */

 public Payment moveLast()
 {
  pay = new Payment();

  try
  {
   rsPay.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [PaymentControllerImpl] : MOVE LAST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return pay;
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
   rsPay=db.stmt.executeQuery("SELECT * FROM Payments ORDER BY TransactionID;");
   if (rsPay.next()) haveData=true;
  }catch(SQLException sqle)
  {
   System.out.println("Server [PaymentControllerImpl]: Connect Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   haveData=false;
  }
 }

 /**
 * Insert Data into Payments Table
 *  @param Payment Class Object
 *  @return boolean true or false value
 */

 public boolean insertData(Payment pay)
 {

  try
  {
   String strQuery="INSERT INTO Payments VALUES("  +
       "'" + pay.getTransactionID()  + "',"+
       "'" + pay.getDate()        + "',"+
       "'" + pay.getOID()       + "',"+
       "'" + pay.getSID()    + "',"+
       ""  + pay.getAmount()    + "," +
       "'" + pay.getStatus()       + "',"+
       "'" + pay.getLPD()      + "',"+
       "'" + pay.getIndentNo()      + "',"+
       "'" + pay.getPMode()      + "',"+
       "'" + pay.getRemarks()    + "');";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

   //Refresh Table
   Connect();

  }catch(SQLException sqle)
  {
   System.out.println("Server [PaymentControllerImpl]: INSERT DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of insertData Method

 /**
 * Update Data Payments Table
 *  @param Payment Class Object
 *  @return boolean true or false value
 */

 public boolean updateData(Payment pay)
 {
  try
  {
   String strQuery="UPDATE Payments SET "  +
       "OID = "        + "'" + pay.getOID()        + "',"+
       "SID = "       + "'" + pay.getSID()   + "',"+
       "Amount = "       + ""  + pay.getAmount()   + "," +
       "Status = "       + "'" + pay.getStatus()      + "',"+
       "LPD = "     + "'" + pay.getLPD()      + "',"+
       "IndentNo = "   + "'" + pay.getIndentNo()    + "',"+
       "PMode = "    + "'" + pay.getPMode()   + "',"+
       "Remarks = "    + "'" + pay.getRemarks()     + "' "+

       "WHERE TransactionID = "+ "'" + pay.getTransactionID()  +"';";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

   //Refresh Table...
   Connect();

  }catch(SQLException sqle){
   System.out.println("Server [PaymentControllerImpl]: UPDATE DATA Error !!!");
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
   rsPay = db.stmt.executeQuery(srchStr);

   if (!rsPay.next())
   {
    Connect();
    return false;
   }
  }catch(SQLException sqle)
  {
   System.out.println("Server [PaymentControllerImpl]: CHECK DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   JOptionPane.showMessageDialog(null, "Server: RECORD NOT FOUND!");
   return false;
  }

  //Refresh Table...
  Connect();
  return true;
 }//End of isFound Data

 /**
 * DELETE DATA from Payments Table
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
   System.out.println("Server [PaymentControllerImpl]: DELETE DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

 }//End of Delete Data

 /**
 * SEARCH DATA from Payments Table
 *  @param String Criteria
 *  @return Payment Class Object
 */

 public Payment SearchData(String srchStr)
 {
  pay = new Payment();

  if (srchStr.equals("")) return pay;
  else
  {
   //System.out.println("\nQuery: "+srchStr);

   try
   {
    rsPay = db.stmt.executeQuery(srchStr);

    if (rsPay.next())
    {
     setData();
    }

   }catch(SQLException sqle)
   {
    System.out.println("Server [PaymentControllerImpl]: SEARCH DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }

  return pay;
 }//End of Search Data

}//End of PaymentController Class