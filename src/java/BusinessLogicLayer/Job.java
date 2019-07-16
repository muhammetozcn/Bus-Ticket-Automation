/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;



import DataAccessLayer.Database;
import java.sql.*;
import java.util.Dictionary;



/**
 *
 * @author ozcan
 */
public class Job {
    Database DB=new Database();
    
    
    public  void ticketAddDb(String gender,int seatNumber) throws ClassNotFoundException, SQLException{
        String sql="insert into BusSeat values(?,?)";
       
        DB.update(sql, seatNumber, gender);
        
    }
    
    public void returnSellingTicket() throws SQLException{
        String sql="Select *from BusSeat";
        ResultSet rs=DB.query(sql);
    
        
        
    }
    
}
