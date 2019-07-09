/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author ozcan
 */
public class Database {
    private Connection conn = null;
    private  ResultSet results = null;
    private  String DB_url="jdbc:mysql://localhost:3306/adam";
    private  String DB_user="root";
    private  String DB_password="";
    private  String driver = "com.mysql.jdbc.Driver";
    
}
