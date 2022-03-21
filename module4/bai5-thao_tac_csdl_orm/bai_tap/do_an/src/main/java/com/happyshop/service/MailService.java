package com.happyshop.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.happyshop.bean.MailInfo;


@Service
public class MailService {
	
	@Autowired
	JavaMailSender mailer;
	
	public void send(MailInfo mail) throws MessagingException {
		MimeMessage message=mailer.createMimeMessage();
		MimeMessageHelper helper=new  MimeMessageHelper(message,true,"utf-8");
		helper.setFrom(mail.getFrom());//Gửi từ
		helper.setTo(mail.getTo());//Gửi đến
		helper.setSubject(mail.getSubject());//Thiết lập tiêu đề mail
		helper.setText(mail.getBody(),true);//thiết lập nội dung mail
		helper.setReplyTo(mail.getFrom());//Thiết lập địa chỉ sẽ đc phản hồi về
		
		if(mail.getCc() != null) {
			helper.setCc(mail.getCc());//Gửi theo dang bao cao cc
		}
		if(mail.getBcc() != null) {
			helper.setBcc(mail.getBcc());
		}
		if(mail.getFiles() != null) {
			String[] paths = mail.getFiles().split(";");
			for(String path: paths) {
				File file=new File(path);
				helper.addAttachment(file.getName(), file);
			}
		}
		mailer.send(message);
	}
}
