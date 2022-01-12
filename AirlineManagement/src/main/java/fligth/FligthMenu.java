/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fligth;

import java.util.Scanner;

/**
 *
 * @author uffog
 */
public class FligthMenu {
    private Scanner reader = new Scanner(System.in);
    
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
