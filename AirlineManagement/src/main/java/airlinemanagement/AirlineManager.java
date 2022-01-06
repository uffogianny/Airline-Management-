/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinemanagement;

import java.util.Scanner;

/**
 *
 * @author uffog
 */
public class AirlineManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in) ;
        
       int choose = 0;
       boolean menu = false;
             
       while(menu == false){
           System.out.println("-----Airline Manamegement Menu-----\n"
                + "1- Database tables consult.\n"
                + "2- Passengers.\n"
                + "3- Fligth.\n"
                + "4- Exit.");
            choose = reader.nextInt();
            
            if(choose>0 && choose <4){
               menu = true;
               
            }
       }      
       
    }    
}