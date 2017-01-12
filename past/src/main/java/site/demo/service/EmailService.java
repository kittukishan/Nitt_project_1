package site.demo.service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import site.demo.model.Users;


@Service
public class EmailService {
	public static final String REPLY_TO_ADDRESS="donotreply@$foodies.com";
	public static final String FROM_ADDRESS="foodies4all.at.hyd@gmail.com";
	@Autowired
	public JavaMailSender javaMailSender;
public void send( Users user, String subject,String body) throws MessagingException
{
	
	 MimeMessage mail=javaMailSender.createMimeMessage();
	 MimeMessageHelper helper=new MimeMessageHelper(mail,true);
	 helper.setTo(user.getEmail());
	 System.out.print("\nEmail id : " + user.getEmail());
	 helper.setReplyTo(REPLY_TO_ADDRESS);
	 helper.setFrom(FROM_ADDRESS);
	 helper.setSubject(subject);
	helper.setText(body);
	javaMailSender.send(mail);
		
	 
}	

}
