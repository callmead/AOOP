//package beximtex;
/**
* <p>Title: BeximTex, Phone Manager</p>
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

public class PhoneControllerImpl extends UnicastRemoteObject implements PhoneController
{

 //Global Objects...
 DBU db = new DBU();
 ResultSet rsPhone;
 Phone phn;
 boolean haveData=false;

 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

 /**
 * Default Constructor With no parameter
 *
 */

 public PhoneControllerImpl() throws RemoteException
 {
  //Connect();
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
    phn.setTransactionID(rsPhone.getString(1));
    phn.setEmpCode(rsPhone.getString(2));
    phn.setDate(sdf.format(rsPhone.getDate(3)));
    phn.setRequestType(rsPhone.getString(4));
    phn.setNeed(rsPhone.getString(5));
    phn.setDeptApp(rsPhone.getString(6));
    phn.setDeptComm(rsPhone.getString(7));
    phn.setDeptAppBy(rsPhone.getString(8));
    phn.setISApp(rsPhone.getString(9));
    phn.setISComm(rsPhone.getString(10));
    phn.setISAppBy(rsPhone.getString(11));
    phn.setRemarks(rsPhone.getString(12));
    phn.setJobStatus(rsPhone.getString(13));

   }catch(SQLException sqle)
   {
    System.out.println("Server [PhoneControllerImpl] : SET DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }
  else{System.out.println("Server [PhoneControllerImpl] : NO RECORDS FOUND!");}
 }

 /**
 * MOVE TO FIRST Record
 *  @return Phone Object
 */

 public Phone moveFirst()
 {
  phn = new Phone();

  try
  {
   rsPhone.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [PhoneControllerImpl] : MOVE FIRST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return phn;
 };

 /**
 * MOVE TO PREVIOUS Record
 *  @return Phone Object
 */

 public Phone movePrevious()
 {
  phn = new Phone();

  try
  {
   if (!rsPhone.previous()) rsPhone.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [PhoneControllerImpl] : MOVE PREVIOUS Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return phn;
 };

 /**
 * MOVE TO NEXT Record
 *  @return Phone Object
 */

 public Phone moveNext()
 {
  phn = new Phone();

  try
  {
   if (!rsPhone.next()) rsPhone.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [PhoneControllerImpl] : MOVE NEXT Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return phn;
 };

 /**
 * MOVE TO LAST Record
 *  @return Phone Object
 */

 public Phone moveLast()
 {
  phn = new Phone();

  try
  {
   rsPhone.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [PhoneControllerImpl] : MOVE LAST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return phn;
 };

 /**
 * Open Table
 *
 *  @return boolean true or false value
 */

 public void Connect(String EmpCode)
 {
  haveData=false;

  try
  {
   rsPhone=db.stmt.executeQuery("SELECT * FROM Phone WHERE EmpCode='" + EmpCode + "' AND DeptApp='-' ORDER BY Date;");
   if (rsPhone.next()) haveData=true;

  }catch(SQLException sqle)
  {
   System.out.println("Server [PhoneControllerImpl]: Connect Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   haveData=false;
  }
 }

 /**
 * Insert Data into Phone Table
 *  @param Phone Class Object
 *  @return boolean true or false value
 */

 public boolean insertData(Phone phn)
 {
  try
  {
   String strQuery="INSERT INTO Phone VALUES(" +
       "'" + phn.getTransactionID()    + "',"+
       "'" + phn.getEmpCode()       + "',"+
       "'" + phn.getDate()       + "',"+
       "'" + phn.getRequestType()  + "',"+
       "'" + phn.getNeed()      + "',"+
       "'" + phn.getDeptApp()       + "',"+
       "'" + phn.getDeptComm()      + "',"+
       "'" + phn.getDeptAppBy()     + "',"+
       "'" + phn.getISApp()        + "',"+
       "'" + phn.getISComm()        + "',"+
       "'" + phn.getISAppBy()       + "',"+
       "'" + phn.getRemarks()    + "',"+
       "'" + phn.getJobStatus()   + "')";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

   //Refresh Table
   //Connect();

  }catch(SQLException sqle)
  {
   System.out.println("Server [PhoneControllerImpl]: INSERT DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of insertData Method

 /**
 * Update Emp Data Phone Table
 *  @param Phone Class Object
 *  @return boolean true or false value
 */

 public boolean updateEmpData(Phone phn)
 {
  try
  {
   String strQuery="UPDATE Phone SET "  +
       "RequestType = "     + "'" + phn.getRequestType() + "',"+
       "Need = "      + "'" + phn.getNeed()       + "',"+
       "Remarks = "   + "'" + phn.getRemarks()  + "' "+

       "WHERE TransactionID = "+ "'" + phn.getTransactionID() +"';";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

   //Refresh Table...
   //Connect();

  }catch(SQLException sqle){
   System.out.println("Server [PhoneControllerImpl]: UPDATE EMP DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of updateEmpData Method

 /**
 * Update Dept Data Phone Table
 *  @param Phone Class Object
 *  @return boolean true or false value
 */

 public boolean updateDeptData(Phone phn)
 {
  try
  {
   String strQuery="UPDATE Phone SET "  +
       "DeptApp = "        + "'" + phn.getDeptApp()     + "'," +
       "DeptComm = "    + "'" + phn.getDeptComm()    + "'," +
       "DeptAppBy = "    + "'" + phn.getDeptAppBy()   + "'," +

       "WHERE TransactionID = "+ "'" + phn.getTransactionID()  +"';";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

   //Refresh Table...
   //Connect();

  }catch(SQLException sqle){
   System.out.println("Server [PhoneControllerImpl]: UPDATE DEPT DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of updateDeptData Method

 /**
 * Update IS Data Phone Table
 *  @param Phone Class Object
 *  @return boolean true or false value
 */

 public boolean updateISData(Phone phn)
 {
  try
  {
   String strQuery="UPDATE Phone SET "  +
       "ISApp = "     + "'" + phn.getISApp()     + "',"+
       "ISComm = "    + "'" + phn.getISComm()     + "',"+
       "ISAppBy = "    + "'" + phn.getISAppBy()     + "',"+

       "WHERE TransactionID = "+ "'" + phn.getTransactionID()  +"';";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

   //Refresh Table...
   //Connect();

  }catch(SQLException sqle){
   System.out.println("Server [PhoneControllerImpl]: UPDATE DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of updateISData Method

 /**
 * Update Job Data Phone Table
 *  @param Phone Class Object
 *  @return boolean true or false value
 */

 public boolean updateJobData(Phone phn)
 {
  try
  {
   String strQuery="UPDATE Phone SET "  +
       "JobStatus = "   + "'" + phn.getJobStatus()   + "' "+

       "WHERE TransactionID = "+ "'" + phn.getTransactionID()  +"';";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

   //Refresh Table...
   //Connect();

  }catch(SQLException sqle){
   System.out.println("Server [PhoneControllerImpl]: UPDATE JOB DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of updateJobData Method

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
   rsPhone = db.stmt.executeQuery(srchStr);

   if (!rsPhone.next())
   {
    //Connect();
    return false;
   }
  }catch(SQLException sqle)
  {
   System.out.println("Server [PhoneControllerImpl]: CHECK DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   JOptionPane.showMessageDialog(null, "Server: RECORD NOT FOUND!");
   return false;
  }

  //Refresh Table...
  //Connect();
  return true;
 }//End of isFound Data

 /**
 * DELETE DATA from Employee Table
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
   //Connect();
  }catch(SQLException sqle)
  {
   System.out.println("Server [PhoneControllerImpl]: DELETE DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

 }//End of Delete Data

 /**
 * SEARCH DATA from Employee Table
 *  @param String Criteria
 *  @return Phone Class Object
 */

 public Phone SearchData(String srchStr)
 {
  phn = new Phone();

  if (srchStr.equals("")) return phn;
  else
  {
   //System.out.println("\nQuery: "+srchStr);

   try
   {
    rsPhone = db.stmt.executeQuery(srchStr);

    if (rsPhone.next())
    {
     setData();
    }

   }catch(SQLException sqle)
   {
    System.out.println("Server [PhoneControllerImpl]: SEARCH DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }

  return phn;
 }//End of Search Data

}//End of PhoneController Class