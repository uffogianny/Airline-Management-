/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fligth;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author uffog
 */
public class DataValidation {
    private int day, month, year;
    
    public boolean validation(int d, int m, int y){
        boolean correct = false;
        this.day = d;
        this.month = m;
        this.year = y;
        try {
            //Formato de fecha (día/mes/año)
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);

            //Comprobación de la fecha
            formatoFecha.parse(this.day + "/" + this.month + "/" + this.year);
            correct = true;
        } catch (ParseException e) {
            //Si la fecha no es correcta, pasará por aquí
            correct = false;
        }                
        if (correct == true) {
            System.out.println("Correct date.");
        }else {
            System.out.println("Wrong date.");
        }
        return correct;
    }
}
