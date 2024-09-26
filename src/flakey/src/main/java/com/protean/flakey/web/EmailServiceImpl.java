package com.protean.flakey.web;

import com.protean.flakey.dto.Mail;
import com.protean.flakey.dto.ParkingTickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service("mailService")
public class EmailServiceImpl implements EmailService{

    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendEmail(String message) {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();


        try {
//            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            SimpleMailMessage mimeMessageHelper = new SimpleMailMessage();
            mimeMessageHelper.setSubject("New Ticket");
            mimeMessageHelper.setText(message);
            mimeMessageHelper.setTo("email@gmail.com");
            mimeMessageHelper.setFrom("email@gmail.com"); // use Admin email id
            System.out.print("Mime Message is :"+mimeMessageHelper);

            mailSender.send(mimeMessageHelper);
//        } catch (MessagingException e) {
//            e.printStackTrace();
        } finally {
            System.out.println("Email sent");
        }



    }
}
