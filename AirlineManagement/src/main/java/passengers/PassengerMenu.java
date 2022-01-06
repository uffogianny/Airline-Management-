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
    
    public void menuFligth(){
        boolean menu = false;
        int choose = 0;
        
        while(menu == false){
            System.out.println("-----Passengers Manamegement Menu-----\n"
                 + "1- Passengers Database Consult.\n"
                 + "2- Fligth Passenger Info.\n"
                 + "3- Change Smoking type Passenger.\n"
                 + "4- Exit.");
             choose = reader.nextInt();

             if(choose>0 && choose <6){
                menu = true;
             }
        }  
        switch (choose) {
            case 1: 
                fligthConsult();
                 break;
            case 2:
                flithPassengerInfo();
                break;
            case 3:
               addFligth();
                break;
            case 4:
                removeFlith();
                break;
            case 5: 
                noSmoking();
                break;
             default:
                 System.out.println("Wrong number.");
         }
    }
    
    private void fligthConsult(){
        
    }
    private void flithPassengerInfo(){
        
    }
    private void addFligth(){
        
    }
    private void removeFlith(){
        
    }
    private void noSmoking(){
        
    }
}
