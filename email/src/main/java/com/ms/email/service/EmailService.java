package com.ms.email.service;

import com.ms.email.model.EmailEntity;
import com.ms.email.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class EmailService {


    private EmailRepository emailRepository;
    private JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender, EmailRepository emailRepository) {
        this.emailSender = emailSender;
        this.emailRepository = emailRepository;
    }

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    @Transactional
    public EmailEntity sendEmail(EmailEntity email){
        try{
            email.setSendDateEmail(LocalDateTime.now());
            email.setEmailFrom(emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());

            emailSender.send(message);
            email.setStatusEmail(EmailEntity.StatusEmail.SENT);
        } catch (Exception e) {
            email.setStatusEmail(EmailEntity.StatusEmail.ERROR);
        } finally {
            return emailRepository.save(email);
        }
    }
}
