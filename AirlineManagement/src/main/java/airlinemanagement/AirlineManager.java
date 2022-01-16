package airlinemanagement;

import connector.Connect;
import fligth.FligthMenu;
import java.util.Scanner;
import passengers.PassengerMenu;
/**
 *
 * @author uffog
 */
public class AirlineManager {

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in) ;
        PassengerMenu pMenu = new PassengerMenu();
        FligthMenu fMenu = new FligthMenu();
        Connect.database();
        
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
               dbConsult(fMenu, pMenu);
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
    private static void dbConsult(FligthMenu fMenu, PassengerMenu pMenu){ 
        fMenu.fligthConsult();
        pMenu.passengersConsult();
    }
}