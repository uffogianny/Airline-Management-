
package fligth;

import connector.Connect;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author uffog
 */
public class FligthMenu {
    private Scanner reader = new Scanner(System.in);
    private Connect conn = new Connect();
    
    public void menuFligth(){
        boolean menu = false;
        int choose = 0;
        
        while(menu == false){
            System.out.println("-----Fligth Management Menu-----\n"
                 + "1- Fligths Database Consult.\n"
                 + "2- Add a fligth."
                 + "3- Remove a fligth."
                 + "4- No-smoking fligth."
                 + "5- Fligth Passenger Info.\n"
                 + "6- Consult routes.\n"
                 + "7- Exit.");
             choose = reader.nextInt();

           switch (choose) {
            case 1: 
                fligthConsult();
                 break;
            case 2:
                fligthPassengerInfo();
                break;
            case 3:
               addFligth();
                break;
            case 4:
                removeFligth();
                break;
            case 5: 
                noSmoking();
                break;
            case 6: 
                consultRoutes();
                break;
            case 7: 
                menu = true;
                break;
             default:
                 System.out.println("Wrong option.");
         }
        }  
    
    }
    
    private void fligthConsult(){
        try (PreparedStatement stmt = conn.getConnection().prepareStatement("SELECT vuelos FROM AirlineDatabase")) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
              System.out.println (rs.getString("COD_VUELO"));

        } catch (SQLException sqle) { 
          System.out.println("Error en la ejecución:" 
            + sqle.getErrorCode() + " " + sqle.getMessage());    
        }
        
    }
    private void fligthPassengerInfo(){
        
    }
    private void addFligth(){
        
    }
    private void removeFligth(){
        
    }
    private void noSmoking(){
        
    }
    private void consultRoutes(){
        
        
    }
}
