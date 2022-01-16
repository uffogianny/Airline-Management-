/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passengers;

import connector.Connect;
import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author uffog
 */
public class PassengerMenu {
    private static Scanner reader = new Scanner(System.in);
    private ResultSet rs;
    private static Connect conn = new Connect();
    
    public void menuPassenger(){
        boolean menu = false;
        int choose = 0;
        
        while(menu == false){
            System.out.println("-----Passengers Management Menu-----\n"
                 + "1- Passengers Database Consult.\n"
                 + "2- Change Smoking type Passenger.\n"
                 + "3- Add a Passenger.\n"
                 + "4- Remove Passenger.\n"
                 + "5- Exit.");
             choose = reader.nextInt();

             switch (choose) {
                case 1: 
                    passengersConsult();
                     break;
                case 2:
                  changeSmoking();
                    break;
                case 3:
                    addPassenger();
                    break;
                case 4:
                    removePassenger();
                    break;
                case 5:
                    menu = true;
                    break;
                 default:
                     System.out.println("Wrong option.");
             }
        }
    }
    public static void datosPasajeros(String query) throws SQLException {
        String ID = null, Cod_vuelo = null, nombre = null, apellido = null, tipo_plaza = null, fumador = null;
        int telefono = 0;
        ResultSet rs = conn.getData(query);
        while (rs.next()) {
            ID = rs.getString("ID");
            Cod_vuelo = rs.getString("COD_VUELO");
            nombre = rs.getString("NOMBRE");
            apellido = rs.getString("APELLIDO");
            tipo_plaza = rs.getString("TIPO_PLAZA");
            fumador = rs.getString("FUMADOR");
            telefono = rs.getInt("TELEFONO");
            System.out.println("\nID " + ID + "\ncod_vuelo " + Cod_vuelo + "\nnombre " + nombre + " \napellido " + apellido + " \ntipo_plaza " + tipo_plaza + "\nfumador " + fumador + " \ntelefono " + telefono + "\n");

        }
    }    
    public static void datosPasajerosUpdate(String query) throws SQLException {
        String ID = null, Cod_vuelo = null, nombre = null, apellido = null, tipo_plaza = null, fumador = null;
        int telefono = 0;
        ResultSet rs = conn.getData(query);
        while (rs.next()) {
            ID = rs.getString("ID");
            Cod_vuelo = rs.getString("COD_VUELO");
            nombre = rs.getString("NOMBRE");
            apellido = rs.getString("APELLIDO");
            tipo_plaza = rs.getString("TIPO_PLAZA");
            fumador = rs.getString("FUMADOR");
            telefono = rs.getInt("TELEFONO");
            System.out.println("\nID " + ID + "\ncod_vuelo " + Cod_vuelo + "\nnombre " + nombre + " \napellido " + apellido + " \ntipo_plaza " + tipo_plaza + "\nfumador " + fumador + " \ntelefono " + telefono + "\n");

        }
    }
    public void passengersConsult(){
        System.out.println("Se estan consultando los pasajeros ...");
        try {
            datosPasajeros("Select * from pasajeros");
        }catch(NullPointerException | SQLException npe) {
            System.out.println(npe);
        }
    }
    private void changeSmoking(){
        
    }
    private void removePassenger(){
        
    }
    private void addPassenger(){
        
    }
}
