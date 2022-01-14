package airlinemanagement;

import fligth.FligthMenu;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import passengers.PassengerMenu;

/**
 *
 * @author uffog
 */
public class AirlineManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in) ;
        PassengerMenu pMenu = new PassengerMenu();
        FligthMenu fMenu = new FligthMenu();
        
        
       int choose = 0;
       boolean menu = false;
             
       while(menu == false){
           System.out.println("-----Airline Management Menu-----\n"
                + "1- Database tables consult.\n"
                + "2- Passengers.\n"
                + "3- Fligth.\n"
                + "4- Exit.");
            choose = reader.nextInt();
            
            switch (choose) {
            case 1: 
               
                 break;
            case 2:
                pMenu.menuPassenger();
                
                break;
            case 3:
                fMenu.menuFligth();
                break;
            case 4:
                menu = true;
                break;
            
             default:
                 System.out.println("Wrong number.");
         }
            
       }     
    }    
}


/* try {
            String controlador = "org.sqlite.JDBC";
            String cadenaconex = "jdbc:sqlite:airline_data.sqlite.sql";
 
            Class.forName(controlador);
            Connection cn;
            cn = DriverManager.getConnection(cadenaconex);
            Statement st =(Statement) cn.createStatement();
            String sql1 ="SELECT * FROM Pasajeros";
            ResultSet rs= st.executeQueery(sql1);
 
            while (rs.next()){
                System.out.print("Nombre: "+rs.getString("Nombre"));
                System.out.println(" Apellidos: "+rs.getString("Apellidos"));
            }
 
        } catch (ClassNotFoundException ex) {
            System.out.println("Controlador no válido");
        } catch (SQLException ex) {
             ex.printStackTrace();
        }*/