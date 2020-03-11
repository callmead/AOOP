import java.sql.*;
import javax.swing.*;

public class DBConnect
{
  Statement stmt;
  Connection cn;
  String TableName = null;

 /**
  *  Constructor With no parameter
  *
  */
  public DBConnect()
  {
    try
    {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      //System.out.println("\nACCESSING Database...");
      cn = DriverManager.getConnection("jdbc:odbc:CS3331", "root", "P@ssw0rd");
      stmt = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
    catch (ClassNotFoundException cnfe)
    {
      System.out.println("*** DBConnect.Cons Error: Invalid Class Name!");
      System.out.println("*** Exception: " + cnfe);
      JOptionPane.showMessageDialog(null,
                                    "*** DBConnect.Cons Error: Invalid Class Name!" + "\nError: " +
                                    cnfe, "Error Occured",
                                    JOptionPane.ERROR_MESSAGE);
      System.exit(0);
    }
    catch (SQLException sqle)
    {
      System.out.println("*** DBConnect.Cons Error: DSN or Database not found!");
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