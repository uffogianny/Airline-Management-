/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinemanagement;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author uffog
 */
public class AirlineManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
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
       
       try {
            String controlador = "org.sqlite.JDBC";
            String cadenaconex = "jdbc:sqlite:airline_data.sqlite.sql";
 
            Class.forName(controlador);
            Connection cn;
            cn = DriverManager.getConnection(cadenaconex);
            Statement st =(Statement) cn.createStatement();
            String sql1 ="SELECT * FROM Clientes";
            ResultSet rs= st.executeQuery(sql1);
 
            while (rs.next()){
                System.out.print("Nombre: "+rs.getString("Nombre"));
                System.out.println(" Apellidos: "+rs.getString("Apellidos"));
            }
 
        } catch (ClassNotFoundException ex) {
            System.out.println("Controlador no válido");
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
       
    }    
}