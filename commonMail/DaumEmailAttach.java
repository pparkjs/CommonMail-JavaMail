package commonMail;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class DaumEmailAttach{

	public static void main(String[] args) throws EmailException {
		// TODO Auto-generated method stub
		
		
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("E:/jar과정1.png");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("이클립스 다운 zip");
		attachment.setName("jar.png");
		String from = "qkrwjdtn963@daum.net";
	 	String password = "";
	 	String to = "qkrwjdtn741@naver.com";
		
	    
	    MultiPartEmail email = new MultiPartEmail();
	    email.setCharset("UTF-8");
	    email.setHostName("smtp.daum.net");
	    email.setSmtpPort(465);
	    email.setSSLOnConnect(true);
	    email.setAuthentication(from, password);
	    email.setFrom(from);
	    email.addTo(to);
	    email.setSubject("첨부 파일 테스트 메일입니다.");
	    email.setMsg("이건 내용입니다.");
	    
	    email.attach(attachment);    
	    email.send();
	    
	    if (email.getSentDate() != null) {
	    	System.out.println("이메일 보내기 완료");
	    } else {
	        System.out.println("이메일 보내기 실패");
	    }
	    
	   
	}

}
