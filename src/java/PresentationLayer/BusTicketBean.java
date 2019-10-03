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
import DataAccessLayer.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public String cinsiyetBul(String kullaniciAdi) throws ClassNotFoundException, SQLException{
        Database database=new Database();
        Class.forName(database.driver);
        database.conn=DriverManager.getConnection(database.DB_url,database.DB_user,database.DB_password);
        database.psmt=database.conn.prepareStatement("select cinsiyet from kisiler where isim=? ");
        database.psmt.setString(1,kullaniciAdi);
        database.results=database.psmt.executeQuery();
        String cinsiyet2="";
        while(database.results.next()){
          cinsiyet2=database.results.getString("cinsiyet");
        }
        
        database.DatabaseClose();
      return cinsiyet2;
    }
    
    
    
    public String sat(String kullaniciAdi,String BusID) throws ClassNotFoundException, SQLException{
        String cinsiyet=cinsiyetBul(kullaniciAdi);
        
        if(cinsiyet.equals("Male")){
            cinsiyet="erkek";
            
        }else{
            cinsiyet="kadın";
        }
       
      Connection conn = null;
      ResultSet results = null;
      String DB_url="jdbc:mysql://localhost:3306/BusAutomation";
      String DB_user="root";
      String DB_password="";
     
      PreparedStatement psmt;
      Class.forName("com.mysql.jdbc.Driver");
      conn=DriverManager.getConnection(DB_url, DB_user,DB_password);
      for(int i=0;i<sellSeatsList.size();i++){
        psmt=conn.prepareStatement("UPDATE BUSANDSEAT SET gender=? , kullaniciAdi=? where BUSID=? and "
                + "SeatNumber=? ");
        psmt.setString(1, cinsiyet);
        psmt.setString(2,kullaniciAdi );
        psmt.setString(3,BusID );
        psmt.setString(4, sellSeatsList.get(i).toString());
        psmt.executeUpdate();
        }
        conn.close();  
        return "finishXhtml?faces-redirect=true";
            
           
       
    }
   
 
   
    
    
}
