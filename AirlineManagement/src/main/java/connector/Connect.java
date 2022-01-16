
package connector;
import java.sql.*;
/**
 *
 * @author uffog
 */
public class Connect {
    private String  dbName ="AirlineDatabase";    
    private String user ="admin";
    private String pass = "administrador";
    private String url = "jdbc:mysql://ariline-database.cdvmmbn7lwdu.eu-west-1.rds.amazonaws.com:3306/"+dbName+"?useUnicode=true&use"
            +"JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
            +"serverTimezone=UTC";
    Connect conn = null;
    
    public Connect(){
               
        try{
            //getting the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //getting connection
            conn = (Connect) DriverManager.getConnection(url, user, pass); 
            if(conn!=null){
                System.out.println("Connected to "+ dbName);
            }
        }catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }catch(SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }
    }
    public Connect getConnection(){
        
        return conn;
    }
    
}
