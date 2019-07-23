/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;



import DataAccessLayer.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;



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
    
    public ArrayList<String> returnSellingTicket() throws SQLException{
        ArrayList<String> genders=new ArrayList<String>();
        String sql="Select *from BUSANDSEAT WHERE BusID='1'";
        ResultSet rs=DB.query(sql);
        while(rs.next()){
           genders.add(rs.getString("Gender"));
               
        }
    
        
        return genders;
    }
    
}