
package connector;
import java.sql.*;
/**
 *
 * @author uffog
 */
public class Connect {
    private static String  dbName ="AirlineDatabase";    
    private static String user ="admin";
    private static String pass = "administrador";
    private static String url = "jdbc:mysql://ariline-database.cdvmmbn7lwdu.eu-west-1.rds.amazonaws.com:3306/"+dbName+"?useUnicode=true&use"
            +"JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
            +"serverTimezone=UTC";
    private static ResultSet rs;
    private static Connection conn;
    
    public static void database(){
               
        try{
            //getting the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //getting connection
            conn = DriverManager.getConnection(url, user, pass); 
            if(conn!=null){
                System.out.println("Connected to "+ dbName);
            }
        }catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }catch(SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }
    }
    
    public Connection getConnection(){        
        return conn;
    }
    
     public static ResultSet getData(String query) throws SQLException {
        rs = getStatement().executeQuery(query);
        return rs;
    }
     public static Statement getStatement() throws SQLException {
        Statement stmt;
        stmt = conn.createStatement();
        return stmt;
    }
}
