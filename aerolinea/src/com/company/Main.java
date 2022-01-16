package com.company;

import java.sql.SQLException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner (System.in);
        int opcion;
        DB.db();
        do {
            opcion = menu(sc);
            switch (opcion){
                case 1:
                    informacionGeneral();
                    break;
                case 2:
                    informacionPasajeros();
                    break;
                case 3:
                    pasajerosVueloConcreto(sc);
                    break;
                case 4:
                    nuevoVuelo();
                    break;
                case 5:
                    borrarAnteriorVuelo(sc);
                    break;
                case 6:
                    convertirVuelo();
                    break;
                default:
                    fin();
            }
        }while(opcion!=0);
    }
    static int menu(Scanner sc){
        int op=0;
        System.out.println("Menuuu\n0.-Salir del programa\n1.Mostrar informacion general\n2.Mostrar informacion de los pasajeros\n3.Ver los pasajeros de un vuelo\n4.Insertar nuevo vuelo\n5.Borrar vuelo introducido previamente\n6.Convertir vuelos de fumadores a no fumadores");
        do {

            System.out.println("introduce una opcion  0-6");
            op=sc.nextInt();
        }while(op<0 ||op>6);
        return op;

    }
    static void informacionGeneral()  {
        System.out.println("Se estan consultando los vuelos ...");
        try {
            DB.datosVuelos("Select * from vuelos");
        }catch(NullPointerException | SQLException npe) {
            System.out.println(npe);
        }
    }

    static void informacionPasajeros(){
        System.out.println("Se estan consultando los pasajeros....");
        try{
            DB.datosPasajeros("Select * from pasajeros");
        }catch(NullPointerException | SQLException npe){
            System.out.println(npe);
        }
    }
    static void pasajerosVueloConcreto(Scanner sc) {
        String vuelo,prueba;
        do {
            try {
                System.out.println("introduce el vuelo a revisar");
            }catch (Exception e){
                System.out.println(e);
            }
            vuelo=sc.next();
        } while (vuelo.length()>6);
        try{
            DB.datosPasajeros("Select * from pasajeros where COD_VUELO='"+vuelo+"'");

        }catch(NullPointerException | SQLException npe){
            System.out.println(npe);
        }
    }
    static void nuevoVuelo(){


    }
    static void borrarAnteriorVuelo(Scanner sc){
        String vuelo;
        do {
            try {
                System.out.println("Que vuelo deseas eliminar");
            }catch (Exception e){
                System.out.println(e);
            }
            vuelo=sc.next();
        } while (vuelo.length()>6);
        try{
            DB.datosVuelos("DELETE * FROM vuelos where COD_VUELO='"+vuelo+"'");

        }catch(NullPointerException | SQLException npe){
            System.out.println(npe);
        }



    }
    static void convertirVuelo(Scanner sc){
        String vuelo;
        do {
            try {
                System.out.println("Que vuelo deseas modificar?");
            }catch (Exception e){
                System.out.println(e);
            }
            vuelo=sc.next();
        } while (vuelo.length()>6);
        try{
            DB.datosVuelos("DELETE * FROM vuelos where COD_VUELO='"+vuelo+"'");

        }catch(NullPointerException | SQLException npe){
            System.out.println(npe);
        }
    }
    static void fin(){
        System.out.println("Fin de Programa , gracias por su visita");
    }
}