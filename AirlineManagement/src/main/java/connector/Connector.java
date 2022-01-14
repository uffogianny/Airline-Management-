
package connector;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author uffog
 */
public class Connector {
    public static final String url = "jdbc:mysql://ariline-database.cdvmmbn7lwdu.eu-west-1.rds.amazonaws.com:3306/AirlineDatabase";
    private static final String user ="admin";
    private static final String pass = "administrador";
    
    public Connection getConnection(){
        Connection conn = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url, user, pass);            
        }catch(Exception e){
            System.out.println("Err: " + e.getMessage());
        }
        return conn;
    }
}
