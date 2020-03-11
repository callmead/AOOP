//package beximtex;
/**
* <p>Title: BeximTex, Securitee Manager</p>
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

public class SecuriteeControllerImpl extends UnicastRemoteObject implements SecuriteeController
{

 //Global Objects...
 DBU db = new DBU();
 ResultSet rsSecuritee;
 Securitee sec;
 boolean haveData=false;

 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

 /**
 * Default Constructor With no parameter
 *
 */

 public SecuriteeControllerImpl() throws RemoteException
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
    sec.setSNo(rsSecuritee.getString(1));
    sec.setEmpCode(rsSecuritee.getString(2));
    sec.setLogInTime(rsSecuritee.getString(3));
    sec.setLogOutTime(rsSecuritee.getString(4));
    sec.setRemarks(rsSecuritee.getString(5));

   }catch(SQLException sqle)
   {
    System.out.println("Server [SecuriteeControllerImpl] : SET DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }
  else{System.out.println("Server [SecuriteeControllerImpl] : NO RECORDS FOUND!");}
 }

 /**
 * MOVE TO FIRST Record
 *  @return Securitee Object
 */

 public Securitee moveFirst()
 {
  sec = new Securitee();

  try
  {
   rsSecuritee.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [SecuriteeControllerImpl] : MOVE FIRST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return sec;
 };

 /**
 * MOVE TO PREVIOUS Record
 *  @return Securitee Object
 */

 public Securitee movePrevious()
 {
  sec = new Securitee();

  try
  {
   if (!rsSecuritee.previous()) rsSecuritee.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [SecuriteeControllerImpl] : MOVE PREVIOUS Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return sec;
 };

 /**
 * MOVE TO NEXT Record
 *  @return Securitee Object
 */

 public Securitee moveNext()
 {
  sec = new Securitee();

  try
  {
   if (!rsSecuritee.next()) rsSecuritee.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [SecuriteeControllerImpl] : MOVE NEXT Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return sec;
 };

 /**
 * MOVE TO LAST Record
 *  @return Securitee Object
 */

 public Securitee moveLast()
 {
  sec = new Securitee();

  try
  {
   rsSecuritee.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [SecuriteeControllerImpl] : MOVE LAST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return sec;
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
   rsSecuritee=db.stmt.executeQuery("SELECT * FROM Security ORDER BY SNo;");
   if (rsSecuritee.next()) haveData=true;
  }catch(SQLException sqle)
  {
   System.out.println("Server [SecuriteeControllerImpl]: Connect Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   haveData=false;
  }
 }

 /**
 * Insert Data into Security Table
 *  @param Securitee Class Object
 *  @return boolean true or false value
 */

 public boolean insertData(Securitee sec)
 {

  try
  {
   String strQuery="INSERT INTO Security (EmpCode,LogInTime,LogOutTime,Remarks) VALUES (" +
       "'" + sec.getEmpCode()    + "',"+
       "'" + sec.getLogInTime()    + "',"+
       "'" + sec.getLogOutTime()  + "',"+
       "'" + sec.getRemarks()   + "')";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

   //Refresh Table
   Connect();

  }catch(SQLException sqle)
  {
   System.out.println("Server [SecuriteeControllerImpl]: INSERT DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of insertData Method


 /**
 * UPDATE DATA from Security Table
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
   System.out.println("Server [SecuriteeControllerImpl]: UPDATE DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

 }//End of Update Data


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
   rsSecuritee = db.stmt.executeQuery(srchStr);

   if (!rsSecuritee.next())
   {
    Connect();
    return false;
   }
  }catch(SQLException sqle)
  {
   System.out.println("Server [SecuriteeControllerImpl]: CHECK DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   JOptionPane.showMessageDialog(null, "Server [SecuriteeControllerImpl]: RECORD NOT FOUND!");
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

 public Securitee SearchData(String srchStr)
 {//SearchData

  sec = new Securitee();

  if (srchStr.equals("")) return sec;
  else
  {
   //System.out.println("\nQuery: "+srchStr);

   try
   {
    rsSecuritee = db.stmt.executeQuery(srchStr);

    if (rsSecuritee.next())
    {
     setData();
    }

   }catch(SQLException sqle)
   {
    System.out.println("Server [SecuriteeControllerImpl]: SEARCH DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }

  return sec;

 }//End of Search Data

}//End of SecuriteeController Class