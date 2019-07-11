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
    Job job=new Job();
    public String [] seats=new String[45];
    public int [] seatNumbers=new int[45];
    
    
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
    public void koltukDiziDoldur(){
        for(int i=0;i<45;i++){
            this.seatNumbers[i]=i+1;
        }
    }
    
    
    
   
    
    
}
