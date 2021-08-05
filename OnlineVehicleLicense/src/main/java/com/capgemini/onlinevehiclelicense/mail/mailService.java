package com.capgemini.onlinevehiclelicense.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class mailService implements IMailService {

	private static final String NOREPLY_ADDR = "vehicleLicense2021@gmail.com";

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public Object sendNormalMail(String to, String subject, String message) {
		// TODO Auto-generated method stub
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(to);
		mail.setFrom(NOREPLY_ADDR);
		mail.setSubject(subject);
		mail.setText(message);

		mailSender.send(mail);
		return null;
	}

	@Override
	public Object sendMailWithAttachment(String to, String subject, String message, String attachement) {
		// TODO Auto-generated method stub
		try {
			MimeMessage msg = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(msg, true);

			helper.setTo(to);
			helper.setFrom(NOREPLY_ADDR);
			helper.setSubject(subject);
			helper.setText(message);

			helper.addAttachment("License.txt", new ClassPathResource(attachement));

			mailSender.send(msg);
		} catch(MessagingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
