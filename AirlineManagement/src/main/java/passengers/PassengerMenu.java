/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passengers;

import java.util.Scanner;

/**
 *
 * @author uffog
 */
public class PassengerMenu {
    private Scanner reader = new Scanner(System.in);
    
    public void menuPassenger(){
        boolean menu = false;
        int choose = 0;
        
        while(menu == false){
            System.out.println("-----Passengers Management Menu-----\n"
                 + "1- Passengers Database Consult.\n"
                 + "2- Fligth Passenger Info.\n"
                 + "3- Change Smoking type Passenger.\n"
                 + "4- Exit.");
             choose = reader.nextInt();

             switch (choose) {
                case 1: 
                    fligthConsult();
                     break;
                case 2:
                    fligthPassengerInfo();
                    break;
                case 3:
                  changeSmoking();
                    break;
                case 4:
                    menu = true;
                    break;
                 default:
                     System.out.println("Wrong option.");
             }
        }
    }
    
    private void fligthConsult(){
        
    }
    private void fligthPassengerInfo(){
        
    }
    private void changeSmoking(){
        
    }
    private void removePassenger(){
        
    }
    private void addPassenger(){
        
    }
}
