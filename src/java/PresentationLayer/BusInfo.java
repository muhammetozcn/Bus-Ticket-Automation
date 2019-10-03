/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ozcan
 */
@ManagedBean(name="businfo")
@SessionScoped
public class BusInfo {

    /**
     * Creates a new instance of BusInfo
     */
    public BusInfo() {
    }
    public String BusID;

    public String getBusID() {
        return BusID;
    }

    public void setBusID(String BusID) {
        this.BusID = BusID;
    }
    
    
     public String otobusAra(){
        
        return "giris?faces-redirect=true";
    }
   /* private String firstCity;
    private String secondCity;

    public String getFirstCity() {
        return firstCity;
    }

    public void setFirstCity(String firstCity) {
        this.firstCity = firstCity;
    }

    public String getSecondCity() {
        return secondCity;
    }

    public void setSecondCity(String secondCity) {
        this.secondCity = secondCity;
    }
    
    
    */
   
    
}
