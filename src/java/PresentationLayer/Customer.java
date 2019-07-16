/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ozcan
 */
@ManagedBean
@RequestScoped
public class Customer {

    /**
     * Creates a new instance of Customer
     */
    public String nameSurname;
    public String TCIdNumber;
    public String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getTCIdNumber() {
        return TCIdNumber;
    }

    public void setTCIdNumber(String TCIdNumber) {
        this.TCIdNumber = TCIdNumber;
    }


    
    public Customer() {
    }
    
}
