package passengers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author uffog
 */
public class Passenger {
    private String id, name, lastName, phoneNumber, fligths;
    private boolean smoker = false;
    
    public Passenger(String id, String name, String lastName, String phoneNumber, String cod_vuelo){
        this.id = id;
        this.name= name;
        this.lastName = lastName;
        this.phoneNumber= phoneNumber;
        this.fligths = cod_vuelo + ","+ this.fligths;
        
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFligths() {
        return fligths;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFligths(String fligths) {
        this.fligths = fligths;
    }

    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }
    
    
}
