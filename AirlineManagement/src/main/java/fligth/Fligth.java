package fligth;

import java.util.Scanner;
/**
 *
 * @author uffog
 */
public class Fligth {
    private Scanner reader = new Scanner(System.in);
    
    public void menuFligth(){
        boolean menu = false;
        int choose = 0;
        
        while(menu == false){
            System.out.println("-----Fligth Manamegement Menu-----\n"
                 + "1- Fligth Database Consult.\n"
                 + "2- Fligth Passenger Info.\n"
                 + "3- Add a Fligth.\n"
                 + "4- Remove a Fligth.\n"
                 + "5- Change to a NO-Smoking Fligth.\n"
                 + "6- Exit.");
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

