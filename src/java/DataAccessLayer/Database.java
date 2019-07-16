/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import java.sql.*;

/**
 *
 * @author ozcan
 */
public class Database {
    private Connection conn = null;
    private  ResultSet results = null;
    private  String DB_url="jdbc:mysql://localhost:3306/BusAutomation";
    private  String DB_user="root";
    private  String DB_password="";
    private  String driver = "com.mysql.jdbc.Driver";
    private  PreparedStatement psmt;
 
        //Database'ye executeQuery yapan inner class
  
    public ResultSet query(String sql){
         try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(DB_url,DB_user,DB_password);
            psmt=conn.prepareStatement(sql);
            results=psmt.executeQuery();
     
            
        }catch(Exception e){
            e.printStackTrace();    
        }
        return results;
              
    }
    
        //Databaseye executeUpdate yapan inner css
        public void update(String sql,int key,String gender) throws ClassNotFoundException, SQLException{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(DB_url, DB_user,DB_password);
            psmt=conn.prepareStatement(sql);
            psmt.setInt(1, key);
            psmt.setString(2,gender);
            psmt.executeUpdate();
            conn.close();
       
    }
    
    
    
    
}
