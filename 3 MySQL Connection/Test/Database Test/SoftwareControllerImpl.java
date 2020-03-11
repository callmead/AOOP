//package beximtex;
/**
* <p>Title: BeximTex, Software Manager</p>
* <p>RequestType: Support Software System</p>
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

public class SoftwareControllerImpl extends UnicastRemoteObject implements SoftwareController
{

 //Global Objects...
 DBU db = new DBU();
 ResultSet rsSoftware;
 Software sft;
 boolean haveData=false;

 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

 /**
 * Default Constructor With no parameter
 *
 */

 public SoftwareControllerImpl() throws RemoteException
 {}//Constructor

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
    sft.setTransactionID(rsSoftware.getString(1));
    sft.setEmpCode(rsSoftware.getString(2));
    sft.setDate(sdf.format(rsSoftware.getDate(3)));
    sft.setRequestType(rsSoftware.getString(4));
    sft.setDescription(rsSoftware.getString(5));
    sft.setDeptApp(rsSoftware.getString(6));
    sft.setDeptComm(rsSoftware.getString(7));
    sft.setDeptAppBy(rsSoftware.getString(8));
    sft.setISApp(rsSoftware.getString(9));
    sft.setISComm(rsSoftware.getString(10));
    sft.setISAppBy(rsSoftware.getString(11));
    sft.setJobStatus(rsSoftware.getString(12));

   }catch(SQLException sqle)
   {
    System.out.println("Server [SoftwareControllerImpl] : SET DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }
  else{System.out.println("Server [SoftwareControllerImpl] : NO RECORDS FOUND!");}
 }

 /**
 * MOVE TO FIRST Record
 *  @return Software Object
 */

 public Software moveFirst()
 {
  sft = new Software();

  try
  {
   rsSoftware.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [SoftwareControllerImpl] : MOVE FIRST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return sft;
 };

 /**
 * MOVE TO PREVIOUS Record
 *  @return Software Object
 */

 public Software movePrevious()
 {
  sft = new Software();

  try
  {
   if (!rsSoftware.previous()) rsSoftware.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [SoftwareControllerImpl] : MOVE PREVIOUS Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return sft;
 };

 /**
 * MOVE TO NEXT Record
 *  @return Software Object
 */

 public Software moveNext()
 {
  sft = new Software();

  try
  {
   if (!rsSoftware.next()) rsSoftware.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [SoftwareControllerImpl] : MOVE NEXT Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return sft;
 };

 /**
 * MOVE TO LAST Record
 *  @return Software Object
 */

 public Software moveLast()
 {
  sft = new Software();

  try
  {
   rsSoftware.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [SoftwareControllerImpl] : MOVE LAST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return sft;
 };

 /**
 * Open Table
 *
 */

 public void Connect(String EmpCode)
 {
  haveData=false;

  try
  {
   rsSoftware=db.stmt.executeQuery("SELECT * FROM Software WHERE EmpCode='" + EmpCode + "' AND DeptApp='-' ORDER BY Date;");
   if (rsSoftware.next()) haveData=true;
  }catch(SQLException sqle)
  {
   System.out.println("Server [SoftwareControllerImpl]: Connect Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   haveData=false;
  }
 }

 /**
 * Insert Data into Software Table
 *  @param Software Class Object
 *  @return boolean true or false value
 */

 public boolean insertData(Software sft)
 {
  try
  {
   String strQuery="INSERT INTO Software VALUES(" +
       "'" + sft.getTransactionID()    + "',"+
       "'" + sft.getEmpCode()       + "',"+
       "'" + sft.getDate()       + "',"+
       "'" + sft.getRequestType()  + "',"+
       "'" + sft.getDescription()    + "',"+
       "'" + sft.getDeptApp()       + "',"+
       "'" + sft.getDeptComm()      + "',"+
       "'" + sft.getDeptAppBy()     + "',"+
       "'" + sft.getISApp()        + "',"+
       "'" + sft.getISComm()        + "',"+
       "'" + sft.getISAppBy()       + "',"+
       "'" + sft.getJobStatus()   + "');";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

  }catch(SQLException sqle)
  {
   System.out.println("Server [SoftwareControllerImpl]: INSERT DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of insertData Method

 /**
 * Update Emp Data Software Table
 *  @param Software Class Object
 *  @return boolean true or false value
 */

 public boolean updateEmpData(Software sft)
 {
  try
  {
   String strQuery="UPDATE Software SET "  +
       "RequestType = "      + "'" + sft.getRequestType() + "',"+
       "Description = "      + "'" + sft.getDescription() + "' "+

       "WHERE TransactionID = " + "'" + sft.getTransactionID() +"';";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

  }catch(SQLException sqle){
   System.out.println("Server [SoftwareControllerImpl]: UPDATE EMP DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of updateEmpData Method

 /**
 * Update Dept Data Software Table
 *  @param Software Class Object
 *  @return boolean true or false value
 */

 public boolean updateDeptData(Software sft)
 {
  try
  {
   String strQuery="UPDATE Software SET "  +
       "DeptApp = "        + "'" + sft.getDeptApp()     + "'," +
       "DeptComm = "    + "'" + sft.getDeptComm()    + "'," +
       "DeptAppBy = "    + "'" + sft.getDeptAppBy()   + "'," +

       "WHERE TransactionID = "+ "'" + sft.getTransactionID()  +"';";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

  }catch(SQLException sqle){
   System.out.println("Server [SoftwareControllerImpl]: UPDATE DEPT DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of updateDeptData Method

 /**
 * Update IS Data Software Table
 *  @param Software Class Object
 *  @return boolean true or false value
 */

 public boolean updateISData(Software sft)
 {
  try
  {
   String strQuery="UPDATE Software SET "  +
       "ISApp = "     + "'" + sft.getISApp()     + "',"+
       "ISComm = "    + "'" + sft.getISComm()     + "',"+
       "ISAppBy = "    + "'" + sft.getISAppBy()     + "',"+

       "WHERE TransactionID = "+ "'" + sft.getTransactionID()  +"';";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

  }catch(SQLException sqle){
   System.out.println("Server [SoftwareControllerImpl]: UPDATE DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of updateISData Method

 /**
 * Update Job Data Software Table
 *  @param Software Class Object
 *  @return boolean true or false value
 */

 public boolean updateJobData(Software sft)
 {
  try
  {
   String strQuery="UPDATE Software SET "  +
       "JobStatus = "   + "'" + sft.getJobStatus()   + "' "+

       "WHERE TransactionID = "+ "'" + sft.getTransactionID()  +"';";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

  }catch(SQLException sqle){
   System.out.println("Server [SoftwareControllerImpl]: UPDATE JOB DATA Error !!!");
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
   rsSoftware = db.stmt.executeQuery(srchStr);

   if (!rsSoftware.next())
   { return false; }
  }catch(SQLException sqle)
  {
   System.out.println("Server [SoftwareControllerImpl]: CHECK DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   JOptionPane.showMessageDialog(null, "Server: RECORD NOT FOUND!");
   return false;
  }
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

  }catch(SQLException sqle)
  {
   System.out.println("Server [SoftwareControllerImpl]: DELETE DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

 }//End of Delete Data

 /**
 * SEARCH DATA from Employee Table
 *  @param String Criteria
 *  @return Software Class Object
 */

 public Software SearchData(String srchStr)
 {
  sft = new Software();

  if (srchStr.equals("")) return sft;
  else
  {
   //System.out.println("\nQuery: "+srchStr);

   try
   {
    rsSoftware = db.stmt.executeQuery(srchStr);

    if (rsSoftware.next())
    {
     setData();
    }

   }catch(SQLException sqle)
   {
    System.out.println("Server [SoftwareControllerImpl]: SEARCH DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }

  return sft;
 }//End of Search Data

}//End of SoftwareController Class