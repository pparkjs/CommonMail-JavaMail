package javamail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class DaumMail {
   public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {
	   String from = "qkrwjdtn963@daum.net";
	   String password = "";
	   String to = "qkrwjdtn963@daum.net";
     
       String host = "smtp.daum.net";

       Properties properties = System.getProperties();
       properties.setProperty("mail.smtp.host", host);
       properties.setProperty("mail.smtp.port", "465");
       properties.setProperty("mail.smtp.ssl.enable", "true");
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
          message.setSubject("정수의 메일");
          message.setText("안녕하세요? 자바메일 테스트 입니다.");

          Transport.send(message);
          System.out.println("메일 보내기 성공");
       } catch (MessagingException mex) {
    	   System.out.println("메일 보내기 실패!");
       }
  }
}


