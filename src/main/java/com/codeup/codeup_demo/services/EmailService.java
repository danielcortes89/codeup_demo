package com.codeup.codeup_demo.services;

import com.codeup.codeup_demo.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    private String from;

    public void prepareAndSend(Post post, String title, String body){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(post.getOwner().getEmail());
        msg.setSubject(title);
        msg.setText(body);

        try{
            this.emailSender.send(msg);
        }catch (MailException ex){
            ex.printStackTrace();
        }

    }
}
