/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DataAccessLayer.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ozcan
 */
@ManagedBean(name="users")
@SessionScoped

public class kayitGönder {
   
   private String email; 
   private String isim="admin";        
   private String sifre="";
   private String girisisim;
   private String girissifre;
   private String unutulansifre;
   private static ArrayList <String> cinsiyetler=new ArrayList <String> ();
   private String cinsiyet;
   private String yenisifre;
   private String yeni2sifre;
   
  
   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   static{
        cinsiyetler.add("Male");
        cinsiyetler.add("Female");
    }

    public String getYeni2sifre() {
        return yeni2sifre;
    }

    public void setYeni2sifre(String yeni2sifre) {
        this.yeni2sifre = yeni2sifre;
    }
   

    public String getYenisifre() {
        return yenisifre;
    }

    public void setYenisifre(String yenisifre) {
        this.yenisifre = yenisifre;
    }

    public static ArrayList<String> getCinsiyetler() {
        return cinsiyetler;
    }

    public static void setCinsiyetler(ArrayList<String> cinsiyetler) {
        kayitGönder.cinsiyetler = cinsiyetler;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getUnutulansifre() {
        return unutulansifre;
    }

    public void setUnutulansifre(String unutulansifre) {
        this.unutulansifre = unutulansifre;
    }

    public String getGirisisim() {
        return girisisim;
    }

    public void setGirisisim(String girisisim) {
        this.girisisim = girisisim;
    }

    public String getGirissifre() {
        return girissifre;
    }

    public void setGirissifre(String girissifre) {
        this.girissifre = girissifre;
    }
    
   

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    
    
    public boolean veriTabanınaVeriEkle(String isim,String sifre,String email,String cinsiyet) throws ClassNotFoundException, SQLException{
        Database database=new Database();
        Class.forName(database.driver);
        database.conn=DriverManager.getConnection(database.DB_url,database.DB_user,database.DB_password);
        database.psmt=database.conn.prepareStatement("insert into kisiler(isim,sifre,email,cinsiyet) values(?,?,?,?)");
        database.psmt.setString(1,isim);
        database.psmt.setString(2,sifre);
        database.psmt.setString(3,email);
        database.psmt.setString(4,cinsiyet);
        int veriTabaniEklendiMi=0;
        try{
             veriTabaniEklendiMi=database.psmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Veritabanına Ekleme hatası");
        }finally{
            try{
                database.DatabaseClose();
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Veritabanı kapanmama hatası");
            }
        }
        return veriTabaniEklendiMi>0;
    }
    public String veriTabaninaGönder() throws ClassNotFoundException, SQLException{
    

    boolean kayıtEdildiMi=false;
    kayıtEdildiMi=veriTabanınaVeriEkle(isim, sifre,email,cinsiyet);
  
   
    if(kayıtEdildiMi){
        FacesMessage fm = new FacesMessage("Kayıt başarılı!", "ERROR MSG");
        fm.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "index";
       
    }else{
        FacesMessage fm = new FacesMessage("Kayıt başarısız!", "ERROR MSG");
        fm.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "kayit";
    }
    
    
    }
    public boolean KisiKontrolu(String isim,String sifre) throws ClassNotFoundException, SQLException{
        Database database=new Database();
        Class.forName(database.driver);
        database.conn=DriverManager.getConnection(database.DB_url,database.DB_user,database.DB_password);
        database.psmt=database.conn.prepareStatement("select isim,sifre from kisiler where isim=? and sifre=?");
        database.psmt.setString(1,isim);
        database.psmt.setString(2,sifre);
        database.results=database.psmt.executeQuery();
        
        int kullaniciVarMi=0;
        try{
            while(database.results.next()){
                kullaniciVarMi++;
                
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Veritabanı hatası");
        }finally{
            try{
               database.DatabaseClose();
            
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Veritabanı kapatılamadı");
            }
                
        }
        
        return kullaniciVarMi>0;
    }
    
    public String cek() throws ClassNotFoundException, SQLException{
        boolean kisikontrolu=KisiKontrolu(this.isim,this.sifre);
        if(kisikontrolu){
        return "otobusSecimi?faces-redirect=true";
        //giris yerine otobusSecimi yapıldı.
        }
         else{
            FacesMessage fm = new FacesMessage("Kullanıcı adı veya şifre hatalı, tekrer deneyiniz...", "ERROR MSG");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "index";
            
        }
    }
    
    public void sendMail(){
        Connection conn=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/BusAutomation","root","");
            statement=conn.prepareStatement("select * from kisiler where email=?");
            statement.setString(1,email);
            
            resultSet=statement.executeQuery();     
            while(resultSet.next()){
              //  String isim1=resultSet.getString("isim");
              //  this.setGirisisim(isim1);
                this.setUnutulansifre(resultSet.getString("sifre"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("hata");
        }
        finally{
            try{
                conn.close();
                statement.close();
                
            }catch(Exception e){
                System.out.println("hata"+e);            
            }
        }
            final String username = "zubeyrbaya3@gmail.com";
            final String password = "gwdeqfynzfwkfvei";
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
 
             Session session = Session.getInstance(properties,
                           new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication(){
                           return new PasswordAuthentication(username, password);
                    }
             }); 
            try {
 
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("zubeyrbaya3@gmail.com"));
                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
                    message.setSubject("Şifre Hatırlatma");
                    message.setText("Sifreniz:"+getUnutulansifre()); 
                    Transport.send(message);
             }catch (MessagingException ex) {
                    throw new RuntimeException(ex);
             }       
    }
    public String changePassword(){
        
        Connection conn=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        int i=0;
       
        try{
         
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/BusAutomation","root","");
            statement=conn.prepareStatement("update kisiler set sifre=? where sifre=?");
            if(yenisifre.equals(yeni2sifre)){
            statement.setString(1,yenisifre);
            }else{
            FacesMessage fm = new FacesMessage("Yeni şifreler uyuşmuyor...", "ERROR MSG");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "sifredegistir";
            }
            statement.setString(2,sifre);          
            i=statement.executeUpdate();   
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("hata");
        }
        finally{
            try{
                conn.close();
                statement.close(); 
            }
            catch(Exception e){
                System.out.println("hata"+e);  
            }
        }
        if(i>0){
            FacesMessage fm = new FacesMessage("Şifre Başarıyla değiştirildi...", "ERROR MSG");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm); 
            return "index";
        }else{
            FacesMessage fm = new FacesMessage("Eski şifre yanlış...", "ERROR MSG");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "sifredegistir";
        }        
    }      
}
    
    
