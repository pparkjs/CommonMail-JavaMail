package commonMail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class DaumHtmlMail {

	public static void main(String[] args) throws EmailException {
		// TODO Auto-generated method stub
		
		String from = "qkrwjdtn963@daum.net";
	 	String password = "";
	 	String to = "qkrwjdtn741@naver.com";
		
	    HtmlEmail email = new HtmlEmail();
	    email.setHostName("smtp.daum.net");
	    email.setSmtpPort(465);
	    email.setSSLOnConnect(true);
	    email.setAuthentication(from, password);
	    
	    email.setCharset("UTF-8");
	    email.setFrom(from);
	    email.addTo(to);
	    email.setSubject("HTML 아파치 로고.");

	    email.setHtmlMsg("<html>아파치 로고 - <img src=\"http://www.apache.org/images/asf_logo_wide.gif\"></html>");
	    email.send();
	    
	    if (email.getSentDate() != null) {
	    	System.out.println("이메일 보내기 완료");
	    } else {
	        System.out.println("이메일 보내기 실패");
	    }
	    
	   
	}

}
