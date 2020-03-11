//package beximtex;
/**
* <p>Title: BeximTex, Designation Manager</p>
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

public class DesignationControllerImpl extends UnicastRemoteObject implements DesignationController
{

 //Global Objects...
 DBU db = new DBU();
 ResultSet rsDesignation;
 Designation des;

 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

 /**
 * Default Constructor With no parameter
 *
 */

 public DesignationControllerImpl() throws RemoteException
 {
  Connect();
 }//End of Constructor

 /**
 * Gets Data from Resultset Sets Data
 *
 */

 public void setData()
 {
  try
  {
   des.setDesignation(rsDesignation.getString(1));
  }catch(SQLException sqle)
  {
   System.out.println("Server [DesignationControllerImpl] : SET DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }
 }

 /**
 * MOVE TO FIRST Record
 *  @return Designation Object
 */

 public Designation moveFirst()
 {
  des = new Designation();

  try
  {
   rsDesignation.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [DesignationControllerImpl] : MOVE FIRST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return des;
 };

 /**
 * MOVE TO PREVIOUS Record
 *  @return Designation Object
 */

 public Designation movePrevious()
 {
  des = new Designation();

  try
  {
   if (!rsDesignation.previous()) rsDesignation.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [DesignationControllerImpl] : MOVE PREVIOUS Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return des;
 };

 /**
 * MOVE TO NEXT Record
 *  @return Designation Object
 */

 public Designation moveNext()
 {
  des = new Designation();

  try
  {
   if (!rsDesignation.next()) rsDesignation.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [DesignationControllerImpl] : MOVE NEXT Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return des;
 };

 /**
 * MOVE TO LAST Record
 *  @return Designation Object
 */

 public Designation moveLast()
 {
  des = new Designation();

  try
  {
   rsDesignation.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [DesignationControllerImpl] : MOVE LAST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return des;
 };

 /**
 * Open Table
 *
 */

 public void Connect()
 {
  try
  {
   rsDesignation=db.stmt.executeQuery("SELECT * FROM Desg ORDER BY Designation;");

  }catch(SQLException sqle)
  {
   System.out.println("Server [DesignationControllerImpl]: Connect Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }
 }

 /**
 * Insert Data into Designation Table
 *  @param Designation Class Object
 *  @return boolean true or false value
 */

 public boolean insertData(Designation des)
 {

  try
  {
   String strQuery="INSERT INTO Desg VALUES ('" + des.getDesignation() + "')";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

   //Refresh Table
   Connect();

  }catch(SQLException sqle)
  {
   System.out.println("Server [DesignationControllerImpl]: INSERT DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of insertData Method


 /**
 * UPDATE DATA from Designation Table
 *  @param String Criteria
 *
 */

 public void UpdateData(String strQuery)
 {//Update Data
  System.out.println("\nQuery: "+strQuery);
  try
  {
   db.stmt.executeUpdate(strQuery);

   //Refresh Table...
   Connect();
  }catch(SQLException sqle)
  {
   System.out.println("Server [DesignationControllerImpl]: UPDATE DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

 }//End of Update Data

 /**
 * DELETE DATA from Designation Table
 *  @param String Criteria
 *
 */

 public void DeleteData(String strQuery)
 {//Delete Data

  System.out.println("\nQuery: "+strQuery);
  try
  {
   db.stmt.executeUpdate(strQuery);

   //Refresh Table...
   Connect();
  }catch(SQLException sqle)
  {
   System.out.println("Server [DesignationControllerImpl]: UPDATE DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

 }//End of Delete Data

 /**
 * CHECK DATA Exist or Not
 *  @param String Criteria
 *  @return boolean true or false value
 */

 public boolean isFound(String srchStr)
 {//isFound
  System.out.println("\nQuery: "+srchStr);
  try
  {
   rsDesignation = db.stmt.executeQuery(srchStr);

   if (!rsDesignation.next())
   {
    Connect();
    return false;
   }
  }catch(SQLException sqle)
  {
   System.out.println("Server [DesignationControllerImpl]: CHECK DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   JOptionPane.showMessageDialog(null, "Server [DesignationControllerImpl]: RECORD NOT FOUND!");
   return false;
  }

  //Refresh Table...
  Connect();
  return true;

 }//End of isFound Data

 /**
 * SEARCH DATA from Security Table
 *  @param String Criteria
 *  @return User Class Object
 */

 public Designation SearchData(String srchStr)
 {//SearchData

  des = new Designation();

  if (srchStr.equals("")) return des;
  else
  {
   //System.out.println("\nQuery: "+srchStr);

   try
   {
    rsDesignation = db.stmt.executeQuery(srchStr);

    if (rsDesignation.next())
    {
     setData();
    }

   }catch(SQLException sqle)
   {
    System.out.println("Server [DesignationControllerImpl]: SEARCH DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }

  return des;
 }//End of Search Data

}//End of DesignationController Class