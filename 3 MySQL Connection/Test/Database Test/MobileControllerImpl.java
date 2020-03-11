//package beximtex;
/**
* <p>Title: BeximTex, Mobile Manager</p>
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

public class MobileControllerImpl extends UnicastRemoteObject implements MobileController
{

 //Global Objects...
 DBU db = new DBU();
 ResultSet rsMobile;
 Mobile mob;
 boolean haveData=false;

 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

 /**
 * Default Constructor With no parameter
 *
 */

 public MobileControllerImpl() throws RemoteException
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
    mob.setTransactionID(rsMobile.getString(1));
    mob.setEmpCode(rsMobile.getString(2));
    mob.setDate(sdf.format(rsMobile.getDate(3)));
    mob.setQ1(rsMobile.getString(4));
    mob.setQ2(rsMobile.getString(5));
    mob.setQ2a(rsMobile.getString(6));
    mob.setQ3(rsMobile.getString(7));
    mob.setQ4(rsMobile.getString(8));
    mob.setQ5(rsMobile.getString(9));
    mob.setQ6(rsMobile.getString(10));
    mob.setQ7(rsMobile.getString(11));
    mob.setQ8(rsMobile.getString(12));
    mob.setQ9(rsMobile.getString(13));
    mob.setQ10(rsMobile.getString(14));
    mob.setQ11(rsMobile.getString(15));
    mob.setQ12(rsMobile.getString(16));
    mob.setQ13(rsMobile.getString(17));
    mob.setQ13a(rsMobile.getString(18));
    mob.setQ14(rsMobile.getString(19));
    mob.setDeptApp(rsMobile.getString(20));
    mob.setDeptComm(rsMobile.getString(21));
    mob.setDeptAppBy(rsMobile.getString(22));
    mob.setISApp(rsMobile.getString(23));
    mob.setISComm(rsMobile.getString(24));
    mob.setISAppBy(rsMobile.getString(25));
    mob.setJobStatus(rsMobile.getString(26));
   }catch(SQLException sqle)
   {
    System.out.println("Server [MobileControllerImpl] : SET DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }
  else{System.out.println("Server [MobileControllerImpl] : NO RECORDS FOUND!");}
 }

 /**
 * MOVE TO FIRST Record
 *  @return Mobile Object
 */

 public Mobile moveFirst()
 {
  mob = new Mobile();

  try
  {
   rsMobile.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [MobileControllerImpl] : MOVE FIRST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return mob;
 };

 /**
 * MOVE TO PREVIOUS Record
 *  @return Mobile Object
 */

 public Mobile movePrevious()
 {
  mob = new Mobile();

  try
  {
   if (!rsMobile.previous()) rsMobile.first();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [MobileControllerImpl] : MOVE PREVIOUS Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return mob;
 };

 /**
 * MOVE TO NEXT Record
 *  @return Mobile Object
 */

 public Mobile moveNext()
 {
  mob = new Mobile();

  try
  {
   if (!rsMobile.next()) rsMobile.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [MobileControllerImpl] : MOVE NEXT Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return mob;
 };

 /**
 * MOVE TO LAST Record
 *  @return Mobile Object
 */

 public Mobile moveLast()
 {
  mob = new Mobile();

  try
  {
   rsMobile.last();
   setData();
  }catch(SQLException sqle)
  {
   System.out.println("Server [MobileControllerImpl] : MOVE LAST Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return mob;
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
   rsMobile=db.stmt.executeQuery("SELECT * FROM Mobile WHERE EmpCode='" +EmpCode + "' AND DeptApp='-' ORDER BY Date;");
   if (rsMobile.next()) haveData=true;
  }catch(SQLException sqle)
  {
   System.out.println("Server [MobileControllerImpl]: Connect Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   haveData=false;
  }
 }

 /**
 * Insert Data into Mobile Table
 *  @param Mobile Class Object
 *  @return boolean true or false value
 */

 public boolean insertData(Mobile mob)
 {

  try
  {
   String strQuery="INSERT INTO Mobile VALUES(" +
       "'" + mob.getTransactionID()    + "',"+
       "'" + mob.getEmpCode()       + "',"+
       "'" + mob.getDate()       + "',"+
       "'" + mob.getQ1()    + "',"+
       "'" + mob.getQ2()      + "',"+
       "'" + mob.getQ2a()      + "',"+
       "'" + mob.getQ3()      + "',"+
       "'" + mob.getQ4()      + "',"+
       "'" + mob.getQ5()      + "',"+
       "'" + mob.getQ6()      + "',"+
       "'" + mob.getQ7()      + "',"+
       "'" + mob.getQ8()      + "',"+
       "'" + mob.getQ9()      + "',"+
       "'" + mob.getQ10()      + "',"+
       "'" + mob.getQ11()      + "',"+
       "'" + mob.getQ12()      + "',"+
       "'" + mob.getQ13()      + "',"+
       "'" + mob.getQ13a()      + "',"+
       "'" + mob.getQ14()      + "',"+
       "'" + mob.getDeptApp()       + "',"+
       "'" + mob.getDeptComm()      + "',"+
       "'" + mob.getDeptAppBy()     + "',"+
       "'" + mob.getISApp()        + "',"+
       "'" + mob.getISComm()        + "',"+
       "'" + mob.getISAppBy()       + "',"+
       "'" + mob.getJobStatus()   + "')";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

  }catch(SQLException sqle)
  {
   System.out.println("Server [MobileControllerImpl]: INSERT DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of insertData Method

 /**
 * Update Emp Data Mobile Table
 *  @param Mobile Class Object
 *  @return boolean true or false value
 */

 public boolean updateEmpData(Mobile mob)
 {
  try
  {
   String strQuery="UPDATE Mobile SET "  +
       "Q1 = "     + "'" + mob.getQ1()  + "',"+
       "Q2 = "    + "'" + mob.getQ2()  + "',"+
       "Q2a = "    + "'" + mob.getQ2a()  + "',"+
       "Q3 = "    + "'" + mob.getQ3()  + "',"+
       "Q4 = "    + "'" + mob.getQ4()  + "',"+
       "Q5 = "    + "'" + mob.getQ5()  + "',"+
       "Q6 = "    + "'" + mob.getQ6()  + "',"+
       "Q7 = "    + "'" + mob.getQ7()  + "',"+
       "Q8 = "    + "'" + mob.getQ8()  + "',"+
       "Q9 = "    + "'" + mob.getQ9()  + "',"+
       "Q10 = "    + "'" + mob.getQ10()  + "',"+
       "Q11 = "    + "'" + mob.getQ11()  + "',"+
       "Q12 = "    + "'" + mob.getQ12()  + "',"+
       "Q13 = "    + "'" + mob.getQ13()  + "',"+
       "Q13a= "    + "'" + mob.getQ13a()  + "',"+
       "Q14 = " + "'" + mob.getQ14() + "' "+

       "WHERE TransactionID = "+ "'" + mob.getTransactionID() +"';";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

  }catch(SQLException sqle){
   System.out.println("Server [MobileControllerImpl]: UPDATE EMP DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of updateEmpData Method

 /**
 * Update Dept Data Mobile Table
 *  @param Mobile Class Object
 *  @return boolean true or false value
 */

 public boolean updateDeptData(Mobile mob)
 {
  try
  {
   String strQuery="UPDATE Mobile SET "  +
       "DeptApp = "        + "'" + mob.getDeptApp()     + "'," +
       "DeptComm = "    + "'" + mob.getDeptComm()    + "'," +
       "DeptAppBy = "    + "'" + mob.getDeptAppBy()   + "'," +

       "WHERE TransactionID = "+ "'" + mob.getTransactionID()  +"';";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

  }catch(SQLException sqle){
   System.out.println("Server [MobileControllerImpl]: UPDATE DEPT DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of updateDeptData Method

 /**
 * Update IS Data Mobile Table
 *  @param Mobile Class Object
 *  @return boolean true or false value
 */

 public boolean updateISData(Mobile mob)
 {
  try
  {
   String strQuery="UPDATE Mobile SET "  +
       "ISApp = "     + "'" + mob.getISApp()     + "',"+
       "ISComm = "    + "'" + mob.getISComm()     + "',"+
       "ISAppBy = "    + "'" + mob.getISAppBy()     + "',"+

       "WHERE TransactionID = "+ "'" + mob.getTransactionID()  +"';";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

  }catch(SQLException sqle){
   System.out.println("Server [MobileControllerImpl]: UPDATE DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   return false;
  }

  return true;

 }//End of updateISData Method

 /**
 * Update Job Data Mobile Table
 *  @param Mobile Class Object
 *  @return boolean true or false value
 */

 public boolean updateJobData(Mobile mob)
 {
  try
  {
   String strQuery="UPDATE Mobile SET "  +
       "JobStatus = "   + "'" + mob.getJobStatus()   + "' "+

       "WHERE TransactionID = "+ "'" + mob.getTransactionID()  +"';";

   System.out.println("\nQuery: "+strQuery);
   //Executing SQL
   db.stmt.executeUpdate(strQuery);

  }catch(SQLException sqle){
   System.out.println("Server [MobileControllerImpl]: UPDATE JOB DATA Error !!!");
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
   rsMobile = db.stmt.executeQuery(srchStr);

   if (!rsMobile.next())
   { return false; }
  }catch(SQLException sqle)
  {
   System.out.println("Server [MobileControllerImpl]: CHECK DATA Error !!!");
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
   System.out.println("Server [MobileControllerImpl]: DELETE DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

 }//End of Delete Data

 /**
 * SEARCH DATA from Employee Table
 *  @param String Criteria
 *  @return Mobile Class Object
 */

 public Mobile SearchData(String srchStr)
 {
  Mobile mob = new Mobile();

  if (srchStr.equals("")) return mob;
  else
  {
   //System.out.println("\nQuery: "+srchStr);

   try
   {
    rsMobile = db.stmt.executeQuery(srchStr);

    if (rsMobile.next())
    {
     setData();
    }

   }catch(SQLException sqle)
   {
    System.out.println("Server [MobileControllerImpl]: SEARCH DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());
   }
  }

  return mob;
 }//End of Search Data

}//End of MobileController Class