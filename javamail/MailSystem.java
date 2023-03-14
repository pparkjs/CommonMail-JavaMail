package javamail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class MailSystem {
   public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {
	   String from = "qkrwjdtn741@naver.com";
	   String password = "";
	   String to = "ndm05004@naver.com";
     
       String host = "smtp.naver.com";

       Properties properties = System.getProperties();
       properties.setProperty("mail.smtp.host", host);
       properties.setProperty("mail.smtp.port", "587");
       properties.setProperty("mail.smtp.starttls.enable", "true");
       properties.setProperty("mail.smtp.auth", "true");
      
       Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(from, password);
          }
      });

       try {
          MimeMessage message = new MimeMessage(session);
          message.setFrom(new InternetAddress(from));
          message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
          message.setSubject("승우의 저녁");
          message.setText("승우야 맛있게 먹고있어??");

          Transport.send(message);
          System.out.println("메일 보내기 성공");
       } catch (MessagingException mex) {
    	   System.out.println("메일 보내기 실패");
       }
  }
}

