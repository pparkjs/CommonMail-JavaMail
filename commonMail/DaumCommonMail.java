package commonMail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class DaumCommonMail {

    public static void main(String[] args) throws EmailException {

 	   String from = "qkrwjdtn963@daum.net";
 	   String password = "";
 	   String to = "qkrwjdtn741@naver.com";
      
       Email email = new SimpleEmail();
       email.setCharset("UTF-8");
       email.setHostName("smtp.daum.net");
       email.setSmtpPort(465);
       email.setSSLOnConnect(true);
       email.setAuthentication(from, password);

       email.setFrom(from);
       email.addTo(to);
       email.setSubject("정수의 메일");
       email.setContent("안녕하세요? 자바메일 테스트 입니다.", 
    		   "text/plain; charset=UTF-8");

       email.send();
       
	   if (email.getSentDate() != null) {
	    	System.out.println("이메일 보내기 완료");
	    } else {
	        System.out.println("이메일 보내기 실패");
	    }
    }
}





