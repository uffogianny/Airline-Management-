package com.company;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
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
    public static void datosPasajeros(String query) throws SQLException {
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
}