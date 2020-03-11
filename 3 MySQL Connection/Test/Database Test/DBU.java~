package beximtex;
/**
 * <p>Title: BeximTex, Database Connection</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.sql.*;
import javax.swing.*;

public class DBU
{
  Statement stmt;
  Connection cn;
  String TableName = null;

 /**
  *	 Constructor With no parameter
  *
  */
  public DBU()
  {
    try
    {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      //System.out.println("\nACCESSING Database...");
      cn = DriverManager.getConnection("jdbc:odbc:BTSSS2", "root", "samsung");
      stmt = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
    catch (ClassNotFoundException cnfe)
    {
      System.out.println("*** DBU.Cons Error: Invalid Class Name!");
      System.out.println("*** Exception: " + cnfe);
      JOptionPane.showMessageDialog(null,
                                    "*** DBU.Cons Error: Invalid Class Name!" + "\nError: " +
                                    cnfe, "Error Occured",
                                    JOptionPane.ERROR_MESSAGE);
      System.exit(0);
    }
    catch (SQLException sqle)
    {
      System.out.println("*** DBU.Cons Error: DSN or Database not found!");
      System.out.println("*** Exception: " + sqle);
      System.out.println("*** SQLException: " + sqle.getMessage());
      JOptionPane.showMessageDialog(null,
                                    "*** CONNECTION ERROR!" + "\nError: " +
                                    sqle.getMessage()+"\nContact Your Developer.",
                                    "Error Occured", JOptionPane.ERROR_MESSAGE);
      System.exit(0);
    }
  }
}