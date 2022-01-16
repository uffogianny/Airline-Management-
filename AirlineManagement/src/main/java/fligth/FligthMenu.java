
package fligth;

import connector.Connect;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.SQLException;
import passengers.PassengerMenu;

/**
 *
 * @author uffog
 */
public class FligthMenu {
    private static Scanner reader = new Scanner(System.in);
    private Connect conn = new Connect();
    private ResultSet rs;
   
    
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
               addFligth();
                break;
            case 3:
                removeFligth();
               
                break;
            case 4:
                noSmoking();
                
                break;
            case 5: 
                fligthPassengerInfo();                
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
     private void datosVuelos(String query) throws SQLException {
        this.rs = conn.getData(query);
        String cod_vuelo = null, hora_salida = null, destino = null, procedencia = null;        
        int plazas_fumador=0,plazas_no_fumador=0,plazas_primera=0,plazas_turista=0;
        
        while (rs.next()) {
            cod_vuelo= rs.getString("COD_VUELO");
            hora_salida= rs.getString("HORA_SALIDA");
            destino= rs.getString("DESTINO");
            procedencia = rs.getString("PROCEDENCIA");
            plazas_fumador = rs.getInt("PLAZAS_FUMADOR");
            plazas_no_fumador = rs.getInt("PLAZAS_NO_FUMADOR");
            plazas_primera= rs.getInt("PLAZAS_PRIMERA");
            plazas_turista= rs.getInt("PLAZAS_TURISTA");
            System.out.println("\ncod_vuelo " + cod_vuelo + "\nhora_salida " + hora_salida + "\ndestino " + destino + " \nprocedencia " + procedencia + " \nplazas_fumador " + plazas_fumador + "\nplazas_no_fumador " + plazas_no_fumador + " \nplazas_primera " + plazas_primera+ "\nPlazas_Turista"+plazas_turista+"\n");
        }
    }
     
    
    public void fligthConsult(){
        System.out.println("Se estan consultando los vuelos ...");
        try {
            datosVuelos("Select * from vuelos");
        }catch(NullPointerException | SQLException npe) {
            System.out.println(npe);
        }
    }
    
    private static void fligthPassengerInfo(){
        String vuelo,prueba;
        do {
            try {
                System.out.println("introduce el vuelo a revisar");
            }catch (Exception e){
                System.out.println(e);
            }
            vuelo=reader.next();
        } while (vuelo.length()>6);
        try{
            PassengerMenu.datosPasajeros("Select * from pasajeros where COD_VUELO='"+vuelo+"'");

        }catch(NullPointerException | SQLException npe){
            System.out.println(npe);
        }
    }
    private void addFligth(){
        
    }
    private void removeFligth(){
        String vuelo;
        do {
            try {
                System.out.println("Que vuelo deseas modificar?");
            }catch (Exception e){
                System.out.println(e);
            }
            vuelo=reader.next();
        } while (vuelo.length()>6);
        try{
            datosVuelos("DELETE * FROM vuelos where COD_VUELO='"+vuelo+"'");

        }catch(NullPointerException | SQLException npe){
            System.out.println(npe);
        }
    }
    private void noSmoking(){
        
    }
    private void consultRoutes(){
        
        
    }
}
