package com.company;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class DB {

    private static Connection conn;
    private static ResultSet rs;

    public static void db() {

        try {
            conn = DriverManager.getConnection("jdbc:mysql://ariline-database.cdvmmbn7lwdu.eu-west-1.rds.amazonaws.com:3306/AirlineDatabase", "admin", "administrador");
            System.out.println("Se ha conectado satisfactoriamente");
        } catch (SQLException sqle) {
            System.out.println("No se conecta con la base de datos");
        }
    }
    public static ResultSet getData(String query) throws SQLException {
        rs = getStatement().executeQuery(query);
        return rs;
    }


    public static Statement getStatement() throws SQLException {
        Statement stmt;
        stmt = conn.createStatement();
        return stmt;
    }
    public static int datosPasajeros(String query) throws SQLException {
        String ID = null, cod_vuelo = null, nombre = null, apellido = null, tipo_plaza = null, fumador = null;
        int telefono = 0,cont=0;
        ResultSet rs = getData(query);
        System.out.println(" ID        | cod_vuelo  | nombre        | apellido      | tipo_plaza | fumador | telefono " );
        while (rs.next()) {
            ID = rs.getString("ID");
            cod_vuelo = rs.getString("COD_VUELO");
            nombre = rs.getString("NOMBRE");
            apellido = rs.getString("APELLIDO");
            tipo_plaza = rs.getString("TIPO_PLAZA");
            fumador = rs.getString("FUMADOR");
            telefono = rs.getInt("TELEFONO");
            String telefonoS= String.valueOf(telefono);
            if (ID.length()<10){ do {ID = ID + " ";}while (ID.length()<10);}
            if (cod_vuelo.length()<10){ do {cod_vuelo = cod_vuelo + " ";}while (cod_vuelo.length()<10);}
            if (nombre.length()<14){ do {nombre = nombre + " ";}while (nombre.length()<14);}
            if (apellido.length()<14){ do {apellido = apellido + " ";}while (apellido.length()<14);}
            if (fumador.length()<8){ do {fumador = fumador + " ";}while (fumador.length()<8);}
            if (tipo_plaza.length()<11){ do {tipo_plaza = tipo_plaza + " ";}while (tipo_plaza.length()<11);}


            System.out.println(" "+ID + "| " + cod_vuelo + " | " + nombre + "| " + apellido + "| " + tipo_plaza + "| " + fumador +"| "+ telefonoS);
        }
        return cont;
    }


    public static void datosPasajerosUpdate(String query) throws SQLException {
        String ID = null, Cod_vuelo = null, nombre = null, apellido = null, tipo_plaza = null, fumador = null;
        int telefono = 0;
        ResultSet rs = getData(query);
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
    public static void datosVuelos(String query) throws SQLException {
        ResultSet rs = getData(query);
        String cod_vuelo = null, hora_salida = null, destino = null, procedencia = null;
        int plazas_fumador = 0, plazas_no_fumador = 0, plazas_primera = 0, plazas_turista = 0;
        System.out.println(" cod_vuelo | hora_salida         | destino       | procedencia   | plazas_fumador | plazas_no_fumador | plazas_primera | Plazas_Turista |");
        while (rs.next()) {
            cod_vuelo = rs.getString("COD_VUELO");
            hora_salida = rs.getString("HORA_SALIDA");
            destino = rs.getString("DESTINO");
            procedencia = rs.getString("PROCEDENCIA");
            plazas_fumador = rs.getInt("PLAZAS_FUMADOR");
            plazas_no_fumador = rs.getInt("PLAZAS_NO_FUMADOR");
            plazas_primera = rs.getInt("PLAZAS_PRIMERA");
            plazas_turista = rs.getInt("PLAZAS_TURISTA");

            String plazas_fumadorS = String.valueOf(plazas_fumador);
            String plazas_no_fumadorS = String.valueOf(plazas_no_fumador);
            String plazas_primeraS = String.valueOf(plazas_primera);
            String plazas_turistaS = String.valueOf(plazas_turista);

            if (cod_vuelo.length() < 10) {
                do {
                    cod_vuelo = cod_vuelo + " ";
                } while (cod_vuelo.length() < 10);
            }
            if (destino.length() < 14) {
                do {
                    destino = destino + " ";
                } while (destino.length() < 14);
            }
            if (procedencia.length() < 14) {
                do {
                    procedencia = procedencia + " ";
                } while (procedencia.length() < 14);
            }
            if (plazas_fumadorS.length() < 15) {
                do {
                    plazas_fumadorS = plazas_fumadorS + " ";
                } while (plazas_fumadorS.length() < 15);
            }
            if (plazas_no_fumadorS.length() < 18) {
                do {
                    plazas_no_fumadorS = plazas_no_fumadorS + " ";
                } while (plazas_no_fumadorS.length() < 18);
            }
            if (plazas_turistaS.length() < 15) {
                do {
                    plazas_turistaS = plazas_turistaS + " ";
                } while (plazas_turistaS.length() < 15);
            }
            if (plazas_primeraS.length() < 15) {
                do {
                    plazas_primeraS = plazas_primeraS + " ";
                } while (plazas_primeraS.length() < 15);
            }
            System.out.println(" " + cod_vuelo + "| " + hora_salida + " | " + destino + "| " + procedencia + "| " + plazas_fumadorS + "| " + plazas_no_fumadorS + "| " + plazas_primeraS + "| " + plazas_turistaS);
        }
    }
    public static void datosVuelosUpdate(String query) throws SQLException {
        Statement stmt;
        stmt=getStatement();
        stmt.executeUpdate(query);
    }
    public static boolean validation(int d, int m, int y){
        int day, month, year;
        boolean correct = false;
        day = d;
        month = m;
        year = y;
        try {
            //Formato de fecha (día/mes/año)
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);

            //Comprobación de la fecha
            formatoFecha.parse(day + "/" + month + "/" + year);
            correct = true;
        } catch (ParseException e) {
            //Si la fecha no es correcta, pasará por aquí
            correct = false;
        }
        if (correct == true) {
            System.out.println("Correct date.");
        }else {
            System.out.println("Esa fecha no existe, introduzcala de nuevo");
        }
        return correct;
    }
}