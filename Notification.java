/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author richardmagnus-george
 */
public class Notification {
    private String userName = "richard.magnusgeorge@gmail.com";
    private String password = "Readme123";
    //private String toEmail = "r.magnus-george@hotmail.co.uk";
    
    public Notification(String to, String subject, String msg)
    {
        Properties prop = new Properties();
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.user", userName);//
        prop.put("mail.smtp.ssl.password", password);//
        prop.put("mail.smtp.ssl.auth", "true");
        prop.put("mail.debug", "false");//
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");// 465, 587
        prop.put("mail.transport.protocol", "smtp");
        
        System.out.println("Properties check!!!!!!!!!");
        
        
        
        //create Authenticator object to pass in Session.getInstance argument
        /*  Authenticator auth = new Authenticator() {
        //override the getPasswordAuthentication method
        protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
        }
        };
        Session session = Session.getInstance(prop, auth);*/
        //{
        //    protected javax.mail.PasswordAuthentication getPasswordAuthentication()
        //    {
        //        return new javax.mail.PasswordAuthentication(userName, password);
        //    }
        //});
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });

        session.setDebug(true);
        
        
        System.out.println("Authentication check!!!!!!");
        
        try
        {
            Message message = new MimeMessage(session);
            message.setFrom( new InternetAddress("no-reply@infantMonitor.co.uk"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to)); // to in the internetaddress
            message.setSubject(subject);
            message.setText(msg);
            
            // must define transport like this or it will not work
            Transport transport = session.getTransport("smtp");
            transport.connect ("smtp.gmail.com", 587, userName, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();    
            
            System.out.println("Mail Sent Successful");
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Mail Sent Unsuccessful");
        } 
    }
    
}
