//package beximtex;
/**
* <p>Title: BeximTex, Supplier Manager</p>
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

public class SupplierControllerImpl extends UnicastRemoteObject implements SupplierController
{

 //Global Objects...
 DBU db = new DBU();
 ResultSet rsSupp;
 Supplier supp;
 boolean haveData=false;

 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

 /**
 * Default Constructor With no parameter
 *
 */

 public SupplierControllerImpl() throws RemoteException
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
    supp.setSID(rsSupp.getString(1));
    supp.setDate(rsSupp.getString(2));
    supp.setName(rsSupp.getString(3));
    supp.setAddress(rsSupp.getString(4));
    supp.setEmail(rsSupp.getString(5));
    supp.setPhone(rsSupp.getString(6));
    supp.setFax(rsSupp.getString(7));
    supp.setMobile(rsSupp.getString(8));
    supp.setContactPerson(rsSupp.getString(9));
    supp.setRemarks(rsSupp.getString(10));
   }catch(SQLException sqle)
   {
    System.out.println("Server [SupplierControllerImpl] : SET DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }
  else{System.out.println("Server [SupplierControllerImpl] : NO RECORDS FOUND!");}
 }

 /**
 * MOVE TO FIRST Record
 *  @return Supplier Object
 */

 public Supplier moveFirst()
 {
  supp = new Supplier();

  try
  {
   rsSupp.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [SupplierControllerImpl] : MOVE FIRST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return supp;
 };

 /**
 * MOVE TO PREVIOUS Record
 *  @return Supplier Object
 */

 public Supplier movePrevious()
 {
  supp = new Supplier();

  try
  {
   if (!rsSupp.previous()) rsSupp.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [SupplierControllerImpl] : MOVE PREVIOUS Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return supp;
 };

 /**
 * MOVE TO NEXT Record
 *  @return Supplier Object
 */

 public Supplier moveNext()
 {
  supp = new Supplier();

  try
  {
   if (!rsSupp.next()) rsSupp.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [SupplierControllerImpl] : MOVE NEXT Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return supp;
 };

 /**
 * MOVE TO LAST Record
 *  @return Supplier Object
 */

 public Supplier moveLast()
 {
  supp = new Supplier();

  try
  {
   rsSupp.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [SupplierControllerImpl] : MOVE LAST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return supp;
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
   rsSupp=db.stmt.executeQuery("SELECT * FROM Suppliers ORDER BY SID;");
   if (rsSupp.next()) haveData=true;
  }catch(SQLException sqle)
  {
   System.out.println("Server [SupplierControllerImpl]: Connect Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   haveData=false;
  }
 }

 /**
 * Insert Data into Suppliers Table
 *  @param Supplier Class Object
 *  @return boolean true or false value
 */

 public boolean insertData(Supplier supp)
 {

  try
  {
   String strQuery="INSERT INTO Suppliers VALUES(" +
       "'" + supp.getSID()    + "',"+
       "'" + supp.getDate()        + "',"+
       "'" + supp.getName()      + "',"+
       "'" + supp.getAddress()   + "',"+
       "'" + supp.getEmail()    + "',"+
       "'" + supp.getPhone()       + "',"+
       "'" + supp.getFax()      + "',"+
       "'" + supp.getMobile()      + "',"+
       "'" + supp.getContactPerson()   + "',"+
       "'" + supp.getRemarks()   + "');";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

   //Refresh Table
   Connect();

  }catch(SQLException sqle)
  {
   System.out.println("Server [SupplierControllerImpl]: INSERT DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of insertData Method

 /**
 * Update Data Suppliers Table
 *  @param Supplier Class Object
 *  @return boolean true or false value
 */

 public boolean updateData(Supplier supp)
 {
  try
  {
   String strQuery="UPDATE Suppliers SET "  +
       "Name = "        + "'" + supp.getName()       + "',"+
       "Address = "       + "'" + supp.getAddress()  + "',"+
       "Email = "        + "'" + supp.getEmail()   + "',"+
       "Phone = "        + "'" + supp.getPhone()      + "',"+
       "Fax = "      + "'" + supp.getFax()     + "',"+
       "Mobile = "     + "'" + supp.getMobile()     + "',"+
       "ContactPerson = "   + "'" + supp.getContactPerson() + "',"+
       "Remarks = "     + "'" + supp.getRemarks()    + "' "+

       "WHERE SID = "  + "'" + supp.getSID()  +"';";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

   //Refresh Table...
   Connect();

  }catch(SQLException sqle){
   System.out.println("Server [SupplierControllerImpl]: UPDATE DATA Error !!!");
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
   rsSupp = db.stmt.executeQuery(srchStr);

   if (!rsSupp.next())
   {
    Connect();
    return false;
   }
  }catch(SQLException sqle)
  {
   System.out.println("Server [SupplierControllerImpl]: CHECK DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   JOptionPane.showMessageDialog(null, "Server: RECORD NOT FOUND!");
   return false;
  }

  //Refresh Table...
  Connect();
  return true;
 }//End of isFound Data

 /**
 * DELETE DATA from Suppliers Table
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
   System.out.println("Server [SupplierControllerImpl]: DELETE DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

 }//End of Delete Data

 /**
 * SEARCH DATA from Suppliers Table
 *  @param String Criteria
 *  @return Supplier Class Object
 */

 public Supplier SearchData(String srchStr)
 {
  supp = new Supplier();

  if (srchStr.equals("")) return supp;
  else
  {
   //System.out.println("\nQuery: "+srchStr);

   try
   {
    rsSupp = db.stmt.executeQuery(srchStr);

    if (rsSupp.next())
    {
     setData();
    }

   }catch(SQLException sqle)
   {
    System.out.println("Server [SupplierControllerImpl]: SEARCH DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }

  return supp;
 }//End of Search Data

}//End of SupplierController Class