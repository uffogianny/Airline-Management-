package com.company;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;

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
                    nuevoVuelo(sc);
                    break;
                case 5:
                    borrarAnteriorVuelo(sc);
                    break;
                case 6:
                    convertirVuelo(sc);
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
            try {

                System.out.println("introduce una opcion  0-6");
                op = sc.nextInt();
            }catch(InputMismatchException ime){
                System.out.println("introduce un numero"+ime);
            }
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
        String vuelo;
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
    static void nuevoVuelo(Scanner sc){

        int mes=0, anho=0,dia=0,hora=0,minutos=0,plazas_fumador=0,plazas_no_fumador=0,plazas_primera=0,plazas_turista=0,maximo_pasajeros=400;
        String cod_vuelo=null,destino=null,procedencia=null;
        boolean fechaC=false;

        LocalDate current_date = LocalDate.now();
        //getting the current year from the current_date
        int year = current_date.getYear();
        do {
            try {
                System.out.println("introduce el codigo del vuelo");
            } catch (Exception e) {
                System.out.println(e);
            }
            cod_vuelo= sc.next();
        } while (cod_vuelo.length()>6);

        do{
            do {
                try {
                    System.out.println("introduce el dia del vuelo");
                } catch (NumberFormatException nfe) {
                    System.out.println(nfe);
                }
                dia = sc.nextInt();
            } while (dia>31);

            do {
                try {
                    System.out.println("introduce mes del vuelo");
                } catch (NumberFormatException nfe) {
                    System.out.println(nfe);
                }
                mes = sc.nextInt();
            } while (mes>12);
            do {
                try {
                    System.out.println("introduce año del vuelo");
                } catch (NumberFormatException nfe) {
                    System.out.println(nfe);
                }
                anho = sc.nextInt();
            } while (anho<year);
        } while(!DB.validation(dia, mes, anho));

        do {
            try {
                System.out.println("introduce los minutos del vuelo");
            } catch (NumberFormatException nfe) {
                System.out.println(nfe);
            }
            minutos= sc.nextInt();
        } while (minutos>60);
        do {
            try {
                System.out.println("introduce la hora del vuelo");
            } catch (NumberFormatException nfe) {
                System.out.println(nfe);
            }
            hora = sc.nextInt();
        } while (hora>24);
        do {
            try {
                System.out.println("introduce destino del vuelo");
            } catch (Exception e) {
                System.out.println(e);
            }
            destino=sc.next();
        } while (destino.length()>15);

        do {
            try {
                System.out.println("introduce la procedencia del vuelo");
            } catch (Exception e) {
                System.out.println(e);
            }
            procedencia= sc.next();
        } while (procedencia.length()>15);

        do {
            try {
                System.out.println("introduce la cantidad de pasajeros fumadores");
            } catch (NumberFormatException nfe) {
                System.out.println(nfe);
            }
            plazas_fumador= sc.nextInt();
        } while (plazas_fumador>400);

        plazas_no_fumador=maximo_pasajeros-plazas_fumador;
        do {
            try {
                System.out.println("introduce las plazas de primera clase");
            } catch (NumberFormatException nfe) {
                System.out.println(nfe);
            }
            plazas_primera = sc.nextInt();
        } while (mes>400);

        plazas_turista=maximo_pasajeros-plazas_primera;




    }
    static void borrarAnteriorVuelo(Scanner sc) throws SQLException {
        String vuelo;
        do {
            try {
                System.out.println("introduce el vuelo a revisar");
            } catch (Exception e) {
                System.out.println(e);
            }
            vuelo = sc.next();
        } while (vuelo.length() > 6);
        if (DB.datosPasajeros("Select * from pasajeros where COD_VUELO='"+vuelo+"'") == 0){
            DB.datosVuelosUpdate("Delete from vuelos where COD_VUELO='"+vuelo+"'");

            System.out.println("borrado completado");
            informacionGeneral();

        }else{
            System.out.println("la tabla tiene valores dentro");
        }


    }
    static void convertirVuelo(Scanner sc){
        String opcion="";
        do {
            try {
                System.out.println("Se convertiran todos los vuelos de fumadores a no fumadores .¿Desea continuar (S/N)? ");
            }catch (Exception e){
                System.out.println(e);
            }
            opcion=sc.next();


            System.out.println(opcion);
        }while(!opcion.equalsIgnoreCase("N") && !opcion.equalsIgnoreCase("S"));
        if (opcion=="N") {
            System.out.println("Se ha cancelado  la conversion");
        } else{
            try{
                DB.datosPasajerosUpdate("update pasajeros set PLAZA_FUMADOR='NO'");
                DB.datosVuelosUpdate("update vuelos set PLAZA_NO_FUMADOR=SUM(PLAZA_NO_FUMADOR,PLAZA_FUMADOR),set PLAZA_FUMADOR=0");

            }catch(NullPointerException | SQLException npe) {
                System.out.println(npe);
            }

        }
    }
    static void fin(){
        System.out.println("Fin de Programa , gracias por su visita");
    }
}