//package beximtex;
/**
* <p>Title: BeximTex, Jobs Manager</p>
* <p>RequestID: Support Jobs System</p>
* <p>Copyright: 2006-2010</p>
* <p>Company: ASKA</p>
* @author Adeel Ashraf Malik
* @version 1.0.0
*/

import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;

import java.sql.*;
import java.util.*;
import java.text.*;
import javax.swing.*;
import java.math.*;

public class CommonTableControllerImpl extends UnicastRemoteObject implements CommonTableController
{

 //Global Objects...
 DBU db = new DBU();
 ResultSet rsComm;
 public int TabColSize=0;

 /**
 * Default Constructor With no parameter
 *
 */

 public CommonTableControllerImpl() throws RemoteException
 {}//Constructor

 /**
 * Gets Column Data from Table
 *
 * @return Vector Class Object
 */

 public Vector getColumnData(String strQuery) throws RemoteException
 {
  DBU db = new DBU();
  ResultSet rs;


  Vector Col = new Vector();
  System.out.println("\nQuery: "+strQuery);

  try {
    rs = db.stmt.executeQuery(strQuery);
    if (!rs.next()) return null;

    ResultSetMetaData rsmd = rs.getMetaData();
    int TotalCol = rsmd.getColumnCount();

    for (int j = 1; j <= TotalCol; ++j) {
     Col.addElement(rsmd.getColumnName(j));
    }

  }catch (SQLException sqle) {
   System.out.println("Server [CommonTableControllerImpl]: GET COLUMN DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());

   JOptionPane.showMessageDialog(null,
   "Server [CommonTableControllerImpl]: GET COLUMN DATA Error !!!" + "\nError: " + sqle,
   "Error", JOptionPane.ERROR_MESSAGE);
  }
  return Col;

 }//getColumnData

 /**
 * Gets Row Data from Table
 *
 * @return Vector Class Object
 */

 public Vector getRowData(String strQuery) throws RemoteException
 {
  DBU db = new DBU();
  ResultSet rs;
  SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
  DecimalFormat    deci = new DecimalFormat("000000.00");
  Vector Row = new Vector();
  Vector currentRow;

  try
  {
   rs = db.stmt.executeQuery(strQuery);
   if (!rs.next())
   {
    return null;
   }

   ResultSetMetaData rsmd = rs.getMetaData();
   int TotalCol = rsmd.getColumnCount();

   do
   {
    currentRow = new Vector();

    for (int i = 1; i <= rsmd.getColumnCount(); ++i)
    {
     if(rsmd.getColumnType(i)==93) //Date
     currentRow.addElement(sdf.format(rs.getDate(i)));
     else if(rsmd.getColumnType(i)==-7) //Boolean
     {
      if(rs.getBoolean(i))
      currentRow.addElement("Y");
      else
      currentRow.addElement("N");
     }
     else if(rsmd.getColumnTypeName(i).equalsIgnoreCase("Integer")) //Int Number
     {
      currentRow.addElement(rs.getString(i));
     }
     else if(rsmd.getColumnType(i)==2) //Currency
     {
      currentRow.addElement(deci.format(rs.getDouble(i)));
     }
     else //String
     currentRow.addElement(rs.getString(i));
    }
    Row.addElement(currentRow);
   }
   while (rs.next());
  }
  catch (SQLException sqle)
  {
   System.out.println("Server [CommonTableControllerImpl]: GET ROW DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());

   JOptionPane.showMessageDialog(null,
   "Server [CommonTableControllerImpl]: GET ROW DATA Error !!!" + "\nError: " + sqle,
   "Error", JOptionPane.ERROR_MESSAGE);;
  }

  return Row;
 }


 /**
 * Executes SQL Statements
 *  @param String Criteria
 *
 */

 public void ExecuteQuery(String strQuery)
 {
  System.out.println("\nQuery: "+strQuery);
  try
  {
   db.stmt.executeUpdate(strQuery);

  }catch(SQLException sqle)
  {
   System.out.println("Server [CommonTableControllerImpl]: EXECUTE QUERY Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

 }//End of Delete Data

 /**
 * Get Number of Columns
 *  @param String Criteria
 *  @return int Class Object
 */

 public int getColNo(String strQuery)
 {
  ResultSet rs;
  System.out.println("\nQuery: "+strQuery);
  try
  {
   rs = db.stmt.executeQuery(strQuery);
   if (rs.next())
   {
    ResultSetMetaData rsmd = rs.getMetaData();
    TabColSize = rsmd.getColumnCount();
    System.out.println("No of Columns are: "+TabColSize);
   }

  }catch(SQLException sqle)
  {
   System.out.println("Server [CommonTableControllerImpl]: GET COL NO Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return TabColSize;

 }//End of Delete Data

 /**
 *  GET ComboData
 *  @param String strQuery, int colNo
 *  @return Vector Class Object
 */

 public Vector getComboData(String strQuery, int colNo)
 {
  Vector temp = new Vector();
  ResultSet rsTemp;

  System.out.println("\nQuery: "+strQuery);

  try
  {
   rsTemp=db.stmt.executeQuery(strQuery);
   while(rsTemp.next())
   {
    temp.addElement(rsTemp.getString(colNo));

   }//End of While Loop

  }catch(SQLException sqle)
  {
   System.out.println("Server [CommonTableControllerImpl]: GET COMBO DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return temp;
 }//End of getComboData

 /**
 * CHECK DATA Exist or Not
 *  @param String Criteria
 *  @return boolean true or false value
 */

 public boolean isFound(String srchStr)
 {
  ResultSet rsTemp;

  System.out.println("\nQuery: "+srchStr);
  try
  {
   rsTemp = db.stmt.executeQuery(srchStr);

   if (!rsTemp.next())
   {
    return false;
   }
  }catch(SQLException sqle)
  {
   System.out.println("Server [CommonTableControllerImpl]: CHECK DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
   JOptionPane.showMessageDialog(null, "Server: RYearORD NOT FOUND!");
   return false;
  }

  return true;
 }//End of isFound Data

 /**
 *  GET DataItem
 *  @param String strQuery
 *  @return String Class Object
 */

 public String getDataItem(String strQuery)
 {
  String x = new String("");
  ResultSet rsTemp;

  System.out.println("\nQuery: "+strQuery);

  try
  {
   rsTemp=db.stmt.executeQuery(strQuery);

   if (rsTemp.next())
   {
    if(rsTemp.getString(1)!=null)
    {
     x = rsTemp.getString(1);
    }
    else
    {System.out.println("No Record Found!");}
   }

  }catch(SQLException sqle)
  {
   System.out.println("Server [CommonTableControllerImpl]: GET COMBO DATA Error !!!");
   System.out.println("Error: "+sqle.getMessage());
  }

  return x;
 }//End of getDataItem

}//End Class

/*
 public Vector getRowData(String strQuery) throws RemoteException
 {
   DBU db = new DBU();
      ResultSet rs;

      Vector Row = new Vector();
   System.out.println("\nQuery: "+strQuery);

      try {
          rs = db.stmt.executeQuery(strQuery);
          if (!rs.next()) return null;

         ResultSetMetaData rsmd = rs.getMetaData();
          int TotalCol = rsmd.getColumnCount();

     while(rs.next())
     {
          Vector temp = new Vector();
       for (int j = 1; j <= TotalCol; ++j) {
        temp.addElement(rs.getString(j));
       }

            Row.addElement(temp);
        }

      }catch (SQLException sqle) {
    System.out.println("Server [CommonTableControllerImpl]: GET ROW DATA Error !!!");
    System.out.println("Error: "+sqle.getMessage());

             JOptionPane.showMessageDialog(null,
             "Server [CommonTableControllerImpl]: GET ROW DATA Error !!!" + "\nError: " + sqle,
       "Error", JOptionPane.ERROR_MESSAGE);
      }
      return Row;

 }//getRowData
*/