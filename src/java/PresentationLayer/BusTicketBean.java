/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import BusinessLogicLayer.Job;
import java.sql.SQLException;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ozcan
 */
@ManagedBean(name="ticket")
@SessionScoped
public class BusTicketBean {

    /**
     * Creates a new instance of BusTicketBean
     */
   // Job job=new Job();

    public String sellSeats="";
    public String str2="";

    public String getStr2() {
        return str2;
    }
 
    public String submitted(){
        this.str2=sellSeats;
        System.out.println("submit edildi");
        return "sell?faces-redirect=true"; 
    }

    public String getSellSeats() {
        return sellSeats;
    }
    
    

    public void setSellSeats(String sellSeats) {
        this.sellSeats=sellSeats;
    }

   
    /*
    public BusTicketBean() {
        koltukDiziDoldur();
        //veritabanından koltukları çek String dizisine ata
    }

    public String[] getSeats() {
        return seats;
    }

    public void setSeats(int seatNumber,String gender) throws SQLException, ClassNotFoundException {
        this.seats[seatNumber-1]=gender;
        job.ticketAddDb(gender,seatNumber);
        
        if(true==true){//Kullanıcı koltuğu satın alırsa
        
            //Eğer o if(dizi[seatNumber-1]!="boş") --> kullanıcının seçtiği
        }
        
    }
   
    */
   
    
    
}
