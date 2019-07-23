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
import javax.faces.bean.ViewScoped;

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
    List<Integer> sellSeatsList = new ArrayList<Integer>();
    public String ticketList;
    Job job=new Job();

    public String getTicketList() throws SQLException {
       String genderList ="";
       ArrayList<String> genders=job.returnSellingTicket();
       for(String gender:genders){
            if(genderList==""){
               genderList=gender;
               continue;
           }
          
            if(genderList!=""){
               genderList=genderList+","+gender;
           }
          
           
       } 
    
        
        
        return genderList;
    }
    
   

    public List<Integer> getSellSeatsList() {
       /* if(this.sellSeatsList.size()>4){
         for(int i=4;i<this.sellSeatsList.size();i++){
             this.sellSeatsList.remove(i);
         }
            
        }*/
        return sellSeatsList;
    }

    public void setSellSeatsList(List<Integer> sellSeatsList) {
        for(int i=0;i<this.sellSeatsList.size();i++){
            this.sellSeatsList.remove(i);
        }
      
        this.sellSeatsList = sellSeatsList;
    }


    public BusTicketBean(){

    }


  

 
    public String submitted(){
        System.out.println("submit edildi");
        return "sell?faces-redirect=true"; 
    }

    public String getSellSeats() {
        return sellSeats;
    }
    
    

    public void setSellSeats(String sellSeats) {
        this.sellSeats="";
        this.sellSeatsList.clear();
        this.sellSeats=sellSeats;
        String[] splitter=sellSeats.split(",");
        
        if(splitter.length>4){
         this.sellSeats="";
            
        }else{
            for(int i=0;i<splitter.length;i++){
            sellSeatsList.add(Integer.parseInt(splitter[i]));

        }
        
        }
        
        
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
