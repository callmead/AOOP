import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
 
public class MySQLConnectExample {
    public static void main(String[] args) {
 
        // creates three different Connection objects
        Connection DBCon = null;

 
        try {
            //String url1 = "jdbc:mysql://localhost:3306/CS3331?verifyServerCertificate=false&useSSL=false"; //Working OK
            String url1 = "jdbc:mysql://localhost:3306/CS3331?useSSL=false";
            String user = "root";
            String password = "P@ssw0rd";
            String sqlQuery = "SELECT * FROM Person";
 
            DBCon = DriverManager.getConnection(url1, user, password);
            if (DBCon != null) {
                System.out.println("CS3331 Database Connected!");
            }
 
            Statement st = DBCon.createStatement();
            st.executeQuery(sqlQuery);
            ResultSet rs = st.getResultSet();
            
            System.out.println("Name"+"\t\t"+"Age");
            while(rs.next()){
              System.out.println(rs.getString("Name")+"\t"+rs.getString("Age"));
              //System.out.println(rs.getString("Age"));
            }


        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }
}